<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 08.10.15
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Привет, ${username}</h1>
<br>
История обращения юзернемов вот такая:
<br>
${history}

<a href="../test?result=${username}">Переход на другую страницу с подставленным параметром</a>

</body>
</html>
