<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Анкеты</title>
    <link href="/res/css/questionnaires.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <%@include file="/WEB-INF/pages/nav.jsp"%>

    <div class="container">

        <h1>Анкеты</h1>

        <sec:authorize access="hasRole('ADMIN')">
            <button onclick='location.href="constructor"' id="addbtn"><b>Добавить анкету</b></button>
        </sec:authorize>

        <c:forEach items="${questionnaires}" var="q">
            <div class="questionnaire">
                <a href="/questionnaires/${q.id}">${q.title}</a>
                <sec:authorize access="hasRole('ADMIN')">
                    <div class="buttons">
                        <button class="editbtn" onclick='location.href="/constructor/${q.id}"'><i class="fa fa-edit"></i></button>
                        <button class="deletebtn" onclick="del(${q.id});"><i class="fa fa-trash"></i></button>
                    </div>
                </sec:authorize>

            </div>
        </c:forEach>

    </div>

    <script>
          function del(id) {
                if (confirm('Удалить анкету?')) location.href = '/questionnaires/delete/' + id;
          }
    </script>
</body>
</html>