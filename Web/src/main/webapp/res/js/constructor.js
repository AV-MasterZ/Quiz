let questionsCount = 1;
let answersCount = 1;

function addQuestion(qqq, qqqt, qqqid) {
    let table = document.getElementById("qtable");
    let row = table.insertRow(table.rows.length);
    let cell = row.insertCell(0);
    cell.innerHTML = document.getElementById("questiontmp").textContent;

    let question = document.getElementById("question");
    let qname = "q" + questionsCount;
    question.setAttribute("name", qname);
    question.setAttribute("id", qname);
    if (qqq != undefined) question.value = qqq;

    let questionid = document.getElementById("qid");
    let qidname = qname + "id";
    questionid.setAttribute("name", qidname);
    questionid.setAttribute("id", qidname);
    if (qqqid != undefined) questionid.value = qqqid;

    let type = document.getElementById("type");
    let tyname = qname + "type";
    type.setAttribute("name", tyname);
    type.setAttribute("id", tyname);
    if (qqqt != undefined) type.value = qqqt;

    let delButton = document.getElementById("delQuestion");
    let dname = "d" + questionsCount;
    let dclick = "deleteQuestion('" + dname + "');";
    delButton.setAttribute("onclick", dclick);
    delButton.setAttribute("id", dname);

    let addAnswerButton = document.getElementById("addanswer");
    let addname = "add" + questionsCount;
    let addclick = "addAnswer('" + qname + "');";
    addAnswerButton.setAttribute("onclick", addclick);
    addAnswerButton.setAttribute("id", addname);

    let tab = document.getElementById("atable");
    let at = "t" + qname + "a";
    tab.setAttribute("id", at);

    questionsCount++;

    return qname;
}

function deleteQuestion(id) {
    let row = document.getElementById(id).parentNode.parentNode.parentNode.rowIndex;
    document.getElementById("qtable").deleteRow(row);
}

function addAnswer(q, aaa, aaaid) {
    let aname = q + "a" + answersCount;
    let tname = "t" + q + "a";

    let atable = document.getElementById(tname);
    let arow = atable.insertRow(atable.rows.length);
    let acell = arow.insertCell(0);
    acell.innerHTML = document.getElementById("answertmp").textContent;

    let answer = document.getElementById("answer");
    answer.setAttribute("name", aname);
    answer.setAttribute("id", aname);
    if (aaa != undefined) answer.value = aaa;

    let answerid = document.getElementById("aid");
    let aidname = aname + "id";
    answerid.setAttribute("name", aidname);
    answerid.setAttribute("id", aidname);
    if (aaaid != undefined) answerid.value = aaaid;

    let delAButton = document.getElementById("delAnswer");
    let delaname = "dab" + answersCount;
    let daclick = "deleteAnswer('" + delaname + "', '" + tname + "');";
    delAButton.setAttribute("onclick", daclick);
    delAButton.setAttribute("id", delaname);

    answersCount++;
}

function deleteAnswer(dbut, tabl) {
    let r = document.getElementById(dbut).parentNode.parentNode.parentNode.rowIndex;
    document.getElementById(tabl).deleteRow(r);
}