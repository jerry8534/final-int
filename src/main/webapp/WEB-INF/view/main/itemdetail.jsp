<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>viewdetail</title>
    <link rel="stylesheet" href="css/itemdetail.css"/>
</head>
<body>
<main class="show detail">
    <c:set var="item" value="${result}"/>
    <div class="item-detail">
        <div class="item-name">${item.title}</div>
        <div class="item-image" style="background-image: url('${item.firstImage}')"></div>
        <div class="item-address">${item.addr1}</div>
        <div class="item-tel">${item.tel}</div>
        <div class="item-homepage">${item.homepage}</div>
    </div>
    <div class="item-detailBtnGroup">
        <input type="button" value="내 일정 보기" />
        <input type="button" value="일정에 추가" /> <!-- c:if 문으로 일정 추가 여부 확인 -->
    </div>
</main>
<%-- ${result} --%>
</body>
</html>