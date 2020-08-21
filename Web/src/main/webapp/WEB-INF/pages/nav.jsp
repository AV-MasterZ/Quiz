<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="/res/css/nav.css"/>
</head>
<body>

    <div class="topnav">
        <div style="max-width: 800px; margin:auto;">
            <div class="topnavbtns">
                <sec:authorize access="isAuthenticated()">
                    <a href="/questionnaires">Анкеты</a>
                </sec:authorize>

                <sec:authorize access="hasRole('ADMIN')">
                    <a href="/users">Ответы пользователей</a>
                </sec:authorize>

                <div class="topnav-right">
                    <sec:authorize access="!isAuthenticated()">
                        <a href="/login">Вход</a>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <a href="/logout">Выйти</a>
                    </sec:authorize>
                </div>
            </div>
        </div>
    </div>
</body>
<html>