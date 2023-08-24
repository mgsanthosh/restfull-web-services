package com.santhosh.restfullapi.restfullwebservices.Login;

public class LoginBean {
    private String message;

    public LoginBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
