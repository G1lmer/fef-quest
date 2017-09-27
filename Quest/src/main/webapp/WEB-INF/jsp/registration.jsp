<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<%@page pageEncoding="UTF-8" %>

<html>
<head>
    <title> ЕНЕРГЕТИЧНИЙ ШТУРМ </title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="styles.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta name="description" content=""/>
    <link href="css/circle.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <script type="text/javascript" src="placeholder.js"></script>
    <link rel="stylesheet" type="text/css" href="modal-contact-form.css"/>
</head>
<body>
<canvas id="pixie"></canvas>
<script src="http://code.jquery.com/jquery-1.7.1.min.js" type="text/javascript"></script>
<script src="js/parallaxsoon3.js" type="text/javascript"></script>
<H1>ENERGY BRAINSTORMING</H1>

<div id="Navigation">
    <ul class="Navigation">
        <li><a href="index.html">ГЛАВНАЯ</a>
        <li><a href="game.html">ИГРА</a>
            <ul>
                <li><a href="table.html">ТАБЛИЦА</a></li>
                <li><a href="map.html">КАРТА</a></li>
            </ul>
        </li>
        <li><a href="registration.html">РЕГИСТРАЦИЯ</a></li>
        <li><a href="rules.html">ПАМЯТКА</a></li>
        <li><a href="help.html">ПОМОЩЬ</a></li>
    </ul>
</div>
<form id="slick-login2" action="<c:url value="/register"/>" method="post">
<label for="login">Название:</label><input type="text" name="name" class="placeholder" placeholder="Название команды">
<label for="login">Логин:</label><input type="text" name="login" class="placeholder" placeholder="Логин">
<label for="school">Школа:</label><input type="text" name="school" class="placeholder" placeholder="Школа">
<label for="members">Участники:</label><select name="members" class="placeholder">
    <option>3</option>
    <option>4</option>
    <option>5</option>
</select><br><br>
<label for="login">Имя:</label><input type="text" name="name1" class="placeholder" placeholder="Имя">
<label for="login">Логин:</label><input type="text" name="surname1" class="placeholder" placeholder="Фамилия">
<label for="login">Имя:</label><input type="text" name="father_name1" class="placeholder" placeholder="Отчество">
<label for="login">Имя:</label><input type="text" name="email1" class="placeholder" placeholder="Email">
<input type="submit" value="РЕГИСТРАЦИЯ">
</form>
</body>
<footer>
    <div id="footer"
         style="margin-left: -10px; background:rgba(238,238,238, 0.2); bottom: 0; width: 100%; padding: 20px 0 0 40px ; height:60px; color: #eee; font-family:'Arial Black', cursive; position:fixed; font-size: 20px;">
        © 2016 ENERGY BRAINSTORMING. ALL RIGHTS RESERVED.
        <a href="about.html"><img class="info" src="icon-alphanumeric.png" title="Об авторах"></a>
    </div>
</footer>
</html>