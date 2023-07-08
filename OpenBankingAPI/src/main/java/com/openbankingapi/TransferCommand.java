package com.openbankingapi;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TransferCommand implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 클라이언트로부터 받은 출금 계좌, 입금 계좌, 이체 금액 등을 파라미터로 가져옵니다.
        String sourceAccount = request.getParameter("sourceAccount");
        String targetAccount = request.getParameter("targetAccount");
        double amount = Double.parseDouble(request.getParameter("amount"));

        // B은행으로 이체 요청을 보내고 응답을 받아옵니다.
        boolean transferSuccess = sendTransferRequest(sourceAccount, targetAccount, amount);

        // 이체 결과에 따라 적절한 응답을 생성합니다.
        if (transferSuccess) {
            response.setContentType("text/plain");
            response.getWriter().println("이체가 완료되었습니다.");
        } else {
            response.setContentType("text/plain");
            response.getWriter().println("이체에 실패했습니다.");
        }
    }

    private boolean sendTransferRequest(String sourceAccount, String targetAccount, double amount) {
        // B은행으로 이체 요청을 보내는 로직을 구현합니다.
        // 필요한 데이터를 가공하여 B은행의 Open API를 호출하고, 응답을 받아옵니다.
        // 이곳에 실제로 B은행의 Open API를 호출하는 로직을 작성해주세요.
        // 호출 결과를 기반으로 이체가 성공했는지 여부를 판단하여 반환합니다.
        return true; // 예시: 성공적으로 처리되었다고 가정합니다.
    }
}
