package com.openbanking.api.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OpenBankingSelectFrontController extends HttpServlet {

    private Gson gson = new Gson();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 입력값에서 주민등록번호를 받음
        String identityNum = request.getParameter("identityNum");

        // 여러 개의 은행에 요청을 보내는 부분
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Callable<String>> tasks = new ArrayList<>();
        List<String> bankUrls = Arrays.asList(
            "http://localhost:8081/MemberAuthentication01/select",
            "http://localhost:8082/MemberAuthentication02/select",
            "http://localhost:8083/MemberAuthentication03/select",
            "http://localhost:8084/MemberAuthentication04/select",
            "http://localhost:8085/MemberAuthentication05/select"
        );
        for (String url : bankUrls) {
            tasks.add(() -> sendRequestToBank(url, identityNum));
        }

        // 모든 요청을 보내고 결과를 받음
        List<Future<String>> futures = null;
        try {
            futures = executor.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();

        // 모든 결과를 하나의 JSON 배열로 합침
        JsonArray allAccounts = new JsonArray();
        for (Future<String> future : futures) {
            try {
                JsonArray bankAccounts = gson.fromJson(future.get(), JsonArray.class);
                allAccounts.addAll(bankAccounts);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // JSON 배열을 응답으로 반환
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(gson.toJson(allAccounts));
    }

    private String sendRequestToBank(String url, String identityNum) throws IOException {
        URL bankUrl = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) bankUrl.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");
        JsonObject requestObj = new JsonObject();
        requestObj.addProperty("identityNum", identityNum);
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = requestObj.toString().getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return response.toString();
        }
    }

//여기서부터는 CORS문제때문에 추가한 코드, 클라우드 구현시 삭제
//preflight 요청을 처리하기 위한 doOptions 메소드 추가
@Override
protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    setAccessControlHeaders(resp);
}

// CORS 설정을 위한 메소드
private void setAccessControlHeaders(HttpServletResponse response) {
    response.addHeader("Access-Control-Allow-Origin", "*");
    response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, PATCH, HEAD");
    response.addHeader("Access-Control-Allow-Headers", "Content-Type");
    response.addHeader("Access-Control-Expose-Headers", "Access-Control-*");
    response.addHeader("Access-Control-Allow-Credentials", "true");
    response.addHeader("Access-Control-Max-Age", "60");
}
}