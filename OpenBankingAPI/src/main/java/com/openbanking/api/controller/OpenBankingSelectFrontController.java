package com.openbanking.api.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import Command.SelectCommand;
import DAODTO.OpenBankingSelectDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/OpenBankingSelectAPI")
public class OpenBankingSelectFrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	System.out.println("dwSelect.jsp에서 받은 요청이 도착함");
        
    	BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = reader.readLine();
        reader.close();

        Gson gson = new Gson();
        JsonObject jsonObject = null;

        try {
            jsonObject = gson.fromJson(json, JsonObject.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }

        if (jsonObject != null) {
            JsonArray combinedResult = new JsonArray();
            String identityNum = jsonObject.get("identityNum").getAsString();

            SelectCommand command = new SelectCommand();
            command.setParameters(identityNum);
            List<CompletableFuture<JsonObject>> futures = command.execute();

            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

            for (CompletableFuture<JsonObject> future : futures) {
                combinedResult.add(future.join());
            }

            // Convert the result to JSON and write it to the response
            String resultJsonString = new Gson().toJson(combinedResult);

            // Set response content type
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            // Write JSON response
            response.getWriter().write(resultJsonString);

            // Set the data as a request attribute
            request.setAttribute("data", combinedResult);

            // Forward the request to the JSP
            RequestDispatcher dispatcher = request.getRequestDispatcher("/dwSelect.jsp");
            dispatcher.forward(request, response);
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

