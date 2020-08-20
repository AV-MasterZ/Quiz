<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Вход</title>
    <link href="/res/css/reg_log.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <%@include file="/WEB-INF/pages/nav.jsp"%>

    <form method="POST" action="<c:url value='/j_spring_security_check'/>">
        <h1>Вход</h1>
        <div>
          <input name="username" type="text" placeholder="Логин" autofocus="true" required/>
          <input name="password" type="password" placeholder="Пароль" required/>
          <button type="submit"><b>Войти</b></button>
          <h4><a href="/registration">Регистрация</a></h4>
        </div>
    </form>

</body>
</html>