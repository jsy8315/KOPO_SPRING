package com.openbanking.api.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.CompletableFuture;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import Command.SelectCommand;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/OpenBankingSelectAPI")
public class OpenBankingSelectFrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	System.out.println("01 : dwSelect.jsp에서 보낸 조회 요청 도착");
    	
    	BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = reader.readLine();
        reader.close();

        System.out.println("02 : JSON 요청 본문 읽기 완료");

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

        String identityNum = jsonObject.get("identityNum").getAsString();

        System.out.println("03 : JSON에서 identityNum 추출 완료");

        SelectCommand command = new SelectCommand();
        command.setParameters(identityNum);
        System.out.println("04 : SelectCommand 설정 완료");

        CompletableFuture<JsonArray> future = command.execute();
        System.out.println("05 : SelectCommand 실행 완료 및 CompletableFuture 생성");

        future.thenAccept(result -> {
            try {
                System.out.println("06 : CompletableFuture 결과 수신 완료");

                // Set response content type
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                System.out.println("07 : 응답 헤더 설정 완료");

                // Write JSON response
                response.getWriter().write(result.toString());
                System.out.println("08 : 응답 본문 작성 완료");
                
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // Log output
                System.out.println("09 : dwSelect.jsp에 응답 전송 완료");
            }
        });
    }

    //여기서부터는 CORS문제때문에 추가한 코드, 클라우드 구현시 삭제
    //preflight 요청을 처리하기 위한 doOptions 메소드 추가
    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlHeaders(resp);
        System.out.println("10 : CORS Preflight 요청 처리 완료");
    }

    // CORS 설정을 위한 메소드
    private void setAccessControlHeaders(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, PATCH, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "Content-Type");
        response.addHeader("Access-Control-Expose-Headers", "Access-Control-*");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Max-Age", "60");
        System.out.println("11 : CORS 헤더 설정 완료");
    }
}
