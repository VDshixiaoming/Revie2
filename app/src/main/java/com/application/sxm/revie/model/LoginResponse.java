package com.application.sxm.revie.model;

/**
 * 用户信息model
 * Created by shixiaoming on 18/11/2.
 */
public class LoginResponse {

    private String name;
    private String account;
    private String password;
    private boolean loginState;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getLoginState() {
        return loginState;
    }

    public void setLoginState(boolean loginState) {
        this.loginState = loginState;
    }
}
