package com.openbanking.api.controller;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import Command.TransferCommand;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/openapi")
public class OpenBankingFrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = reader.readLine();
        reader.close();
        
        Gson gson = new Gson();
        JsonObject jsonObj = gson.fromJson(json, JsonObject.class);
        String cmd = jsonObj.get("cmd").getAsString();

        if (cmd != null) {
            if (cmd.equals("transfer")) {
                new TransferCommand().execute(request, response);
            }
            // 추후에 다른 기능이 추가되면, 여기에 if 문으로 더 추가
        }
    }
}



