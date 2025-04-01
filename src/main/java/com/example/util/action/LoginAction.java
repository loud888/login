package com.example.action;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.example.util.DatabaseUtil;
import org.mindrot.jbcrypt.BCrypt;

public class LoginAction extends ActionSupport {
    private String username;
    private String password;
    private String errorMessage;

    public String execute() {
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "SELECT password FROM users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedHash = rs.getString("password");
                if (BCrypt.checkpw(password, storedHash)) {
                    getSession().put("username", username);
                    return SUCCESS;
                } else {
                    errorMessage = "Tên đăng nhập hoặc mật khẩu không đúng!";
                    return ERROR;
                }
            } else {
                errorMessage = "Tên đăng nhập không tồn tại!";
                return ERROR;
            }
        } catch (Exception e) {
            errorMessage = "Lỗi hệ thống: " + e.getMessage();
            return ERROR;
        }
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }
}
