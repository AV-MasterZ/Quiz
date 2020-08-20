<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
    <head>
        <title>Регистрация</title>
        <link href="/res/css/reg_log.css" rel="stylesheet" type="text/css" />
    </head>
<body>
    <%@include file="/WEB-INF/pages/nav.jsp"%>

    <form:form method="POST" modelAttribute="user">

        <h1>Регистрация</h1>

        <label for="username"><b>Логин</b></label>
        <form:input type="text" placeholder="Введите логин" path="username" required="required"/>
        <form:errors path="username"></form:errors>
        <p style="color:red;">${usernameError}</p>

        <label for="firstName"><b>Имя</b></label>
        <form:input type="text" placeholder="Введите имя" path="firstName" required="required"/>

        <label for="lastName"><b>Фамилия</b></label>
        <form:input type="text" placeholder="Введите фамилию" path="lastName"/>

        <label for="password"><b>Пароль</b></label>
        <form:input type="password" placeholder="Введите пароль" path="password" required="required"/>

        <label for="passwordConfirm"><b>Подтверждение пароля</b></label>
        <form:input type="password" placeholder="Повторите пароль" path="passwordConfirm" required="required"/>
        <form:errors path="password"></form:errors>
        <p style="color:red;">${passwordError}</p>

        <button type="submit"><b>Создать аккаунт</b></button>

    </form:form>
</body>
</html>