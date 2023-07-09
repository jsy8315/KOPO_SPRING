package com.openbanking.api.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface OpenBankingCommand {
    void execute(HttpServletRequest request, HttpServletResponse response);
}

