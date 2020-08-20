<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
    <title>Анкета</title>
    <link href="/res/css/questionnaire.css" rel="stylesheet" type="text/css" />
</head>
<body onload="fill();">
    <%@include file="/WEB-INF/pages/nav.jsp"%>

    <form action="/questionnaires/${questionnaire.id}" method="POST">
        <h1>${questionnaire.title}</h1>
        <table id="container"></table>
        <button type="submit" id="submitbtn"><b>Отправить</b></button>
    </form>

    <script type='text/javascript'>
        function fill() {
            let type;
            let table = document.getElementById("container");
            let row;
            let cell;
            <c:forEach items="${questionnaire.questions}" var="question">
                row = table.insertRow(table.rows.length);
                cell = row.insertCell(0);
                cell.innerHTML = "<p><b>${question.question}</b></p>";
                if ("${question.type.type}" === "one") type = "radio";
                if ("${question.type.type}" === "few") type = "checkbox";
                <c:forEach items="${question.answers}" var="answer">
                    row = table.insertRow(table.rows.length);
                    cell = row.insertCell(0);
                    cell.innerHTML = '<p><input name="${question.id}" type="' + type + '" value="${answer.id}"/> ${answer.answer}</p>';
                </c:forEach>
            </c:forEach>
        }
    </script>
</body>
</html>