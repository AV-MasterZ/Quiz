<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
    <title>Ответы</title>
    <link href="/res/css/useranswers.css" rel="stylesheet" type="text/css" />
</head>
<body onload="fill();">
    <%@include file="/WEB-INF/pages/nav.jsp"%>

    <h1>${user.firstName} ${user.lastName} (${user.username})</h1>

    <div style="width: 800px; margin: auto;">
        <table id="container"></table>
    </div>

    <script type='text/javascript'>
        function fill() {
            let type;
            let table;
            let row;
            let cell;
            <c:forEach items="${userAnswers}" var="ua">
                if (document.getElementById("que${ua.answer.question.questionnaire.id}") === null) {
                    table = document.getElementById("container");
                    row = table.insertRow(table.rows.length);
                    cell = row.insertCell(0);
                    cell.innerHTML = "<table class='questionnaire' id='que${ua.answer.question.questionnaire.id}'><caption><b>${ua.answer.question.questionnaire.title}</b><caption></table>";
                }

                if (document.getElementById("q${ua.answer.question.id}") === null) {
                    table = document.getElementById("que${ua.answer.question.questionnaire.id}");
                    row = table.insertRow(table.rows.length);
                    cell = row.insertCell(0);
                    cell.innerHTML = "<table class='question' id='q${ua.answer.question.id}'><caption><b>${ua.answer.question.question}</b><caption></table>";
                }

                table = document.getElementById("q${ua.answer.question.id}");
                row = table.insertRow(table.rows.length);
                cell = row.insertCell(0);
                cell.innerHTML = "${ua.answer.answer}";

            </c:forEach>
        }
    </script>
</body>
</html>