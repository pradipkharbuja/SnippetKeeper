<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Snippet Keeper</title>
<base href="${pageContext.request.contextPath}/" />
<link rel="stylesheet" href="resources/css/style.css">
<script type="text/javascript" src="resources/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="resources/js/scripts.js"></script>
</head>
<body>
	<div id="main-container">
		<!-- Its closing is in footer.jsp -->
		<header>
			<c:set var="link"
				value="${requestScope['javax.servlet.forward.request_uri']}?language=" />
			<a href="${link}en_US">English</a> | <a href="${link}ne_NP">नेपाली</a>
			| <a href="${link}zh_CN">中文</a>
		</header>