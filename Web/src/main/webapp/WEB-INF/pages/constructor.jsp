<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>

<html>
<head>
    <title>Конструктор</title>
    <link href="/res/css/constructor.css" rel="stylesheet" type="text/css" />
</head>
<body onload="fill();">

    <form action="/constructor" method="POST">
        <h1>Конструктор</h1>
        <input type="text" name="title" placeholder="Название анкеты" id="title" required/>
        <table id="qtable"></table>
        <button type="button" onclick='addQuestion();' class="addquestionbtn">Добавить вопрос</button>
        <button type="submit" id="submitbtn">Сохранить анкету</button>
        <div class="hiddenInput">
            <input type="text" id="id" name="id" value="${questionnaire.id}"/>
        </div>
    </form>

    <script type="text/template" id="questiontmp">
        <div class="question">
            <input type="text" name="question" placeholder="Вопрос" class="qtitle" id="question" required/>
            <select name="qtype" class="qtype" id="type">
                <option value="one">Один ответ</option>
                <option value="few">Несколько ответов</option>
            </select>
            <button type="button" class="qdelbtn" id="delQuestion"><b>-</b></button>
            <div class="hiddenInput">
                <input type="text" id="qid" name="qid" value=""/>
            </div>
        </div>
        <table class="atable" id="atable"></table>
        <button type="button" onclick='addAnswer();' class="addanswerbtn" id="addanswer">Добавить ответ</button>
    </script>
    <script type="text/template" id="answertmp">
        <div class="answer">
            <input type="text" name="answer" placeholder="Ответ" class="atitle" id="answer" required/>
            <button type="button" class="adelbtn" id="delAnswer"><b>-</b></button>
            <div class="hiddenInput">
                <input type="text" id="aid" name="aid" value=""/>
            </div>
        </div>
    </script>
    <script src="/res/js/constructor.js"></script>
    <script>
        function fill() {
            document.getElementById('title').value = '${questionnaire.title}';
            document.getElementById('id').value = '${questionnaire.id}';

            let qtag;
            <c:forEach items="${questionnaire.questions}" var="question">
                qtag = addQuestion('<c:out value="${question.question}"/>',
                                        '<c:out value="${question.type.type}"/>',
                                        '<c:out value="${question.id}"/>');

                <c:forEach items="${question.answers}" var="answer">
                    addAnswer(qtag,
                              '<c:out value="${answer.answer}"/>',
                              '<c:out value="${answer.id}"/>');
                </c:forEach>
            </c:forEach>
        }
    </script>
</body>
</html>