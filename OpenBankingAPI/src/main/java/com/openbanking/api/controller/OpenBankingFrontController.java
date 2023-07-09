package com.openbanking.api.controller;

import com.openbanking.api.command.Command;
import com.openbanking.api.command.TransferCommand;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OpenBankingFrontController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String path = request.getPathInfo();

        Command command = null;

        if ("/transfer".equals(path)) {
            command = new TransferCommand();
        }
        // else if (...) 다른 Command들이 필요하면 이곳에 추가

        if (command != null) {
            command.execute(request, response);
        } else {
            // 알 수 없는 요청에 대한 처리
        }
    }
}

