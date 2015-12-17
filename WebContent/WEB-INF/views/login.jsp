<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h1>
	<spring:message code="login-page" text="Login Page" />
</h1>
<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
	<font color="red"> Your login attempt was not successful due to
		<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />.
	</font>
</c:if>
<form action="login" method="post">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />

	<div id="success">${message}</div>

	<table>
		<tr>
			<td><label for="username"><spring:message
						code="username" text="User Name" />: </label></td>
			<td><input id="username" type="text" name="username" /></td>
		</tr>
		<tr>
			<td><label for="password"><spring:message
						code="password" text="Password" />: </label></td>
			<td><input type="password" id="password" name="password"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"
				value='<spring:message code="submit" text="Submit" />'></td>
		</tr>
	</table>
</form>