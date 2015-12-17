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
	<div id="main-container">
		<!-- Its closing is in footer.jsp -->
		<header>
			<c:set var="link"
				value="${requestScope['javax.servlet.forward.request_uri']}?language=" />
			<a href="${link}en_US">English</a> | <a href="${link}ne_NP">नेपाली</a>
			| <a href="${link}zh_CN">中文</a>

			<div class="right">

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

		<tiles:insertAttribute name="body" />

		<footer>
			<spring:message code="developed-by" text="Developed By Synergy @ 2015 December"/>
		</footer>
	</div>
</body>
</html>