<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        body { font-family: Arial, sans-serif; max-width: 400px; margin: 50px auto; }
        .error { color: red; }
        .success { color: green; }
        input, button { padding: 8px; margin: 5px 0; width: 100%; }
    </style>
</head>
<body>
    <h2>Đăng nhập</h2>
    <s:actionerror cssClass="error"/>
    <s:actionmessage cssClass="success"/>
    <s:form action="login" method="POST">
        <s:textfield name="username" label="Username" required="true"/>
        <s:password name="password" label="Password" required="true"/>
        <s:submit value="Đăng nhập"/>
    </s:form>
</body>
</html>
