<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Анкеты</title>
    <link href="/res/css/questionnaires.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <%@include file="/WEB-INF/pages/nav.jsp"%>

    <div class="container">

        <h1>Пользователи</h1>
        <c:forEach items="${users}" var="user">
            <p><a href="/useranswers/${user.id}">${user.firstName} ${user.lastName} (${user.username})</a></p>
        </c:forEach>

    </div>
</body>
</html>