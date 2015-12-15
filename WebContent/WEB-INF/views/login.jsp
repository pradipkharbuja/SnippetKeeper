<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@include file="header.jsp"%>

<h1>Login Page</h1>
<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
	<font color="red"> Your login attempt was not successful due to
		<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />.
	</font>
</c:if>
<form action="login" method="post">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" /> <label for="username"><spring:message
			code="username" text="User Name" />: </label> <input id="username"
		type="text" name="username" /> <label for="password"><spring:message
			code="password" text="Password" />: </label><input type="password"
		id="password" name="password"> <input type="submit"
		value="Submit">
</form>

<%@include file="footer.jsp"%>