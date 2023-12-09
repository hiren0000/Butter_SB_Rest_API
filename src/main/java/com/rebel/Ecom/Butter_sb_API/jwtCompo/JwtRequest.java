package com.rebel.Ecom.Butter_sb_API.jwtCompo;

public class JwtRequest
{
    private String email;
    private String password;

    public JwtRequest() {
    }

    public JwtRequest(String userName, String password) {
        this.email = userName;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String userName) {
        this.email = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
