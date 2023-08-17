package DAODTO;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.util.ArrayList;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class OpenBankingDAO {

    private String sendPOSTRequest(String url, JsonObject jsonObject) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        // add header
        httpPost.setHeader("Content-type", "application/json");

        // add request body
        StringEntity stringEntity = new StringEntity(jsonObject.toString());
        httpPost.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(httpPost);
        String result = null;
        try {
            result = EntityUtils.toString(response.getEntity());
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } finally {
            response.close();
        }

        return result;
    }

    public boolean depositToBank01(String dAccountNumber, String transferAmount, String wAccountNumber, String wBankCode) {
        try {
            String url = "http://localhost:8081/MemberAuthentication01/deposit"; // 보낼 개별은행 주소

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("dAccountNumber", dAccountNumber);
            jsonObject.addProperty("transferAmount", transferAmount);
            jsonObject.addProperty("wAccountNumber", wAccountNumber);
            jsonObject.addProperty("wBankCode", wBankCode);

            String response = sendPOSTRequest(url, jsonObject);

            // 여기서 잘 될 경우 응답을 확인
            // 성공적으로 입금이 되면, 해당 은행의 API가 true라는 응답을 보내고, 여기서 받음.
            return Boolean.parseBoolean(response);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    // 오버로드된 새로운 메소드를 추가해서, wBankCode에 따라 wAccountNumber에 처리하는 요청을 각 은행에 보냄
    public boolean withdrawToBank01(String dAccountNumber, String transferAmount, String wAccountNumber, String wBankCode) {
        try {
            String url;
            switch (wBankCode) {
                case "TH":
                    url = "http://localhost:8081/MemberAuthentication01/withdraw";
                    break;
                case "ZERO":
                    url = "http://localhost:8082/MemberAuthentication02/withdraw";
                    break;
                case "HI":
                    url = "http://localhost:8083/MemberAuthentication03/withdraw";
                    break;
                case "ALMOND":
                    url = "http://localhost:8084/MemberAuthentication04/withdraw";
                    break;
                default:
                    return false;
            }

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("wAccountNumber", wAccountNumber);
            jsonObject.addProperty("transferAmount", transferAmount);
            jsonObject.addProperty("dAccountNumber", dAccountNumber);
            jsonObject.addProperty("wBankCode", wBankCode);
            jsonObject.addProperty("dBankCode", "TH");

            String response = sendPOSTRequest(url, jsonObject);

            boolean isWithdrawn = Boolean.parseBoolean(response);
            
            // 출금이 성공적으로 이루어진 경우에만 입금 진행
            if (isWithdrawn) {
                return depositToBank01(dAccountNumber, transferAmount, wAccountNumber, wBankCode);
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean depositToBank02(String dAccountNumber, String transferAmount, String wAccountNumber, String wBankCode) {
        try {
            String url = "http://localhost:8082/MemberAuthentication02/deposit"; // 보낼 개별은행 주소

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("dAccountNumber", dAccountNumber);
            jsonObject.addProperty("transferAmount", transferAmount);
            jsonObject.addProperty("wAccountNumber", wAccountNumber);
            jsonObject.addProperty("wBankCode", wBankCode);

            String response = sendPOSTRequest(url, jsonObject);

            // 여기서 잘 될 경우 응답을 확인
            // 성공적으로 입금이 되면, 해당 은행의 API가 true라는 응답을 보내고, 여기서 받음.
            System.out.println("입금 요청을 Open api에서 보냅니다");
            return Boolean.parseBoolean(response);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
 // 오버로드된 새로운 메소드를 추가해서, wBankCode에 따라 wAccountNumber에 처리하는 요청을 각 은행에 보냄
    public boolean withdrawToBank02(String dAccountNumber, String transferAmount, String wAccountNumber, String wBankCode) {
        try {
            String url;
            switch (wBankCode) {
            case "TH":
                url = "http://localhost:8081/MemberAuthentication01/withdraw";
                break;
            case "ZERO":
                url = "http://localhost:8082/MemberAuthentication02/withdraw";
                break;
            case "HI":
                url = "http://localhost:8083/MemberAuthentication03/withdraw";
                break;
            case "ALMOND":
                url = "http://localhost:8084/MemberAuthentication04/withdraw";
                break;
            default:
                return false;
        }

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("wAccountNumber", wAccountNumber);
            jsonObject.addProperty("transferAmount", transferAmount);
            jsonObject.addProperty("dAccountNumber", dAccountNumber);
            jsonObject.addProperty("wBankCode", wBankCode);
            jsonObject.addProperty("dBankCode", "ZERO");

            String response = sendPOSTRequest(url, jsonObject);
            
            boolean isWithdrawn = Boolean.parseBoolean(response);
            
            // 출금이 성공적으로 이루어진 경우에만 입금 진행
            if (isWithdrawn) {
                return depositToBank02(dAccountNumber, transferAmount, wAccountNumber, wBankCode);
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean depositToBank03(String dAccountNumber, String transferAmount, String wAccountNumber, String wBankCode) {
        try {
            String url = "http://localhost:8083/MemberAuthentication03/deposit"; // 보낼 개별은행 주소

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("dAccountNumber", dAccountNumber);
            jsonObject.addProperty("transferAmount", transferAmount);
            jsonObject.addProperty("wAccountNumber", wAccountNumber);
            jsonObject.addProperty("wBankCode", wBankCode);

            String response = sendPOSTRequest(url, jsonObject);

            // 여기서 잘 될 경우 응답을 확인
            // 성공적으로 입금이 되면, 해당 은행의 API가 true라는 응답을 보내고, 여기서 받음.
            return Boolean.parseBoolean(response);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    // 오버로드된 새로운 메소드를 추가해서, wBankCode에 따라 wAccountNumber에 처리하는 요청을 각 은행에 보냄
    public boolean withdrawToBank03(String dAccountNumber, String transferAmount, String wAccountNumber, String wBankCode) {
        try {
            String url;
            switch (wBankCode) {
            case "TH":
                url = "http://localhost:8081/MemberAuthentication01/withdraw";
                break;
            case "ZERO":
                url = "http://localhost:8082/MemberAuthentication02/withdraw";
                break;
            case "HI":
                url = "http://localhost:8083/MemberAuthentication03/withdraw";
                break;
            case "ALMOND":
                url = "http://localhost:8084/MemberAuthentication04/withdraw";
                break;
            default:
                return false;
        }

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("wAccountNumber", wAccountNumber);
            jsonObject.addProperty("transferAmount", transferAmount);
            jsonObject.addProperty("dAccountNumber", dAccountNumber);
            jsonObject.addProperty("wBankCode", wBankCode);
            jsonObject.addProperty("dBankCode", "HI");

            String response = sendPOSTRequest(url, jsonObject);

            boolean isWithdrawn = Boolean.parseBoolean(response);
            
            // 출금이 성공적으로 이루어진 경우에만 입금 진행
            if (isWithdrawn) {
                return depositToBank03(dAccountNumber, transferAmount,wAccountNumber, wBankCode);
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean depositToBank04(String dAccountNumber, String transferAmount, String wAccountNumber, String wBankCode) {
        try {
            String url = "http://localhost:8084/MemberAuthentication04/deposit"; // 보낼 개별은행 주소

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("dAccountNumber", dAccountNumber);
            jsonObject.addProperty("transferAmount", transferAmount);
            jsonObject.addProperty("wAccountNumber", wAccountNumber);
            jsonObject.addProperty("wBankCode", wBankCode);

            String response = sendPOSTRequest(url, jsonObject);

            // 여기서 잘 될 경우 응답을 확인
            // 성공적으로 입금이 되면, 해당 은행의 API가 true라는 응답을 보내고, 여기서 받음.
            return Boolean.parseBoolean(response);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    // 오버로드된 새로운 메소드를 추가해서, wBankCode에 따라 wAccountNumber에 처리하는 요청을 각 은행에 보냄
    public boolean withdrawToBank04(String dAccountNumber, String transferAmount, String wAccountNumber, String wBankCode) {
        try {
            String url;
            switch (wBankCode) {
            case "TH":
                url = "http://localhost:8081/MemberAuthentication01/withdraw";
                break;
            case "ZERO":
                url = "http://localhost:8082/MemberAuthentication02/withdraw";
                break;
            case "HI":
                url = "http://localhost:8083/MemberAuthentication03/withdraw";
                break;
            case "ALMOND":
                url = "http://localhost:8084/MemberAuthentication04/withdraw";
                break;
            default:
                return false;
        }

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("wAccountNumber", wAccountNumber);
            jsonObject.addProperty("transferAmount", transferAmount);
            jsonObject.addProperty("dAccountNumber", dAccountNumber);
            jsonObject.addProperty("wBankCode", wBankCode);
            jsonObject.addProperty("dBankCode", "ALMOND");

            String response = sendPOSTRequest(url, jsonObject);

            boolean isWithdrawn = Boolean.parseBoolean(response);
            
            // 출금이 성공적으로 이루어진 경우에만 입금 진행
            if (isWithdrawn) {
                return depositToBank04(dAccountNumber, transferAmount, wAccountNumber, wBankCode);
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}


