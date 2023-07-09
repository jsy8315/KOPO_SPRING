package com.openbanking.api.command;

import com.openbanking.api.dao.OpenBankingTransferDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OpenBankingTransferCommand implements OpenBankingCommand {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        // 필요한 파라미터를 request에서 추출
        // 이 부분은 실제 서비스에 맞게 구현해야 합니다.
        String fromBank = request.getParameter("fromBank");
        String toBank = request.getParameter("toBank");
        String fromAccount = request.getParameter("fromAccount");
        String toAccount = request.getParameter("toAccount");
        String amount = request.getParameter("amount");

        // TransferDAO를 통해 이체 작업 수행
        OpenBankingTransferDAO transferDAO = new OpenBankingTransferDAO();
        transferDAO.transfer(fromBank, toBank, fromAccount, toAccount, amount);
    }
}

