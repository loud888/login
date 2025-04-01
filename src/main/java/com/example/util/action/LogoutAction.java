package com.example.action;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {
    public String execute() {
        getSession().clear();
        addActionMessage("Đã đăng xuất thành công! Chào bạn!");
        return SUCCESS;
    }
}
