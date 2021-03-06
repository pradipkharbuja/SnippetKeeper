<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%><%@ taglib prefix="tiles"
	uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Snippet Keeper - <tiles:insertAttribute name="title" /></title>
<base href="${pageContext.request.contextPath}/" />
<link rel="stylesheet" href="resources/css/style.css">
<script type="text/javascript" src="resources/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="resources/js/scripts.js"></script>
</head>
<body>
	<div class="container-fluid">
		<header>
			<div class="pull-left">
				<img class="logo" src="resources/images/logo.jpg" width="200" />
			</div>
			<div class="pull-right">

				<security:authorize access="isAuthenticated()">
					Welcome <span class="bold"><security:authentication
							property="principal.username" /></span> | 
					<a href="logout">Logout</a>
				</security:authorize>
				<security:authorize access="! isAuthenticated()">
					<a href="login">Login</a> | <a href="registration">Registration</a>
				</security:authorize>
			</div>
		</header>
		<div id="main-container">
			<tiles:insertAttribute name="body" />
		</div>
		<footer>
			<spring:message code="developed-by"
				text="Developed By Synergy @ 2015 December" />
			<br>
			<security:authorize access="hasRole('ROLE_USER')">
				<a href="bug/add">Report Bug</a> | <a href="snippet">Snippet</a> | <a
					href="logout">Log Out</a>
			</security:authorize>
			<security:authorize access="hasRole('ROLE_ADMIN')">
				<a href="bug/list">Bug Reports</a> | <a href="snippet">Snippet</a> | <a
					href="logout">Log Out</a>
			</security:authorize>
			<div id="language">
				<c:set var="link"
					value="${requestScope['javax.servlet.forward.request_uri']}?language=" />
				<a href="${link}en_US">English</a> | <a href="${link}ne_NP">नेपाली</a>
				| <a href="${link}zh_CN">中文</a>
			</div>
		</footer>
	</div>
</body>
</html>