package dataControl;

import java.util.Date;

public class DTO {

    private String id;
    private String name;
    private String password;
    private String identityNum;
    private String phoneNum;
    private String email;
    private String address;
    private String detailAddress;
    private String postalCode;
    private String grade;
    private String status;
    private String bankCode;
    private String jibunAddress;
    private String extraAddress;

    public DTO() {
    }

    public String getJibunAddress() {
        return jibunAddress;
    }

    public void setJibunAddress(String jibunAddress) {
        this.jibunAddress = jibunAddress;
    }

    public String getExtraAddress() {
        return extraAddress;
    }

    public void setExtraAddress(String extraAddress) {
        this.extraAddress = extraAddress;
    }

    public DTO(String id, String bankCode,String name, String password, String identityNum,
               String phoneNum, String email, String postalCode, String address, String detailAddress, 
               String jibunAddress, String extraAddress
               ) {

        this.id = id;
        this.bankCode = bankCode;
        this.name = name;
        this.password = password;
        this.identityNum = identityNum;
        this.phoneNum = phoneNum;
        this.email = email;
        this.address = address;
        this.detailAddress = detailAddress;
        this.postalCode = postalCode;
        this.grade = grade;
        this.status = status;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentityNum() {
        return identityNum;
    }

    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum;
    }


    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getters and setters
    // ...
}

