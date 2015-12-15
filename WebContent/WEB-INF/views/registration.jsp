<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@include file="header.jsp"%>

<h1>
	<spring:message code="registration" text="Registration" />
</h1>
<form:form commandName="user" method="post" action="registration">
	<table>
		<tr>
			<td><spring:message code="username" text="Username" />:</td>
			<td><form:input path="username" /></td>
			<td><form:errors path="username" /></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td colspan="3"><input type="submit" value="Submit" /></td>
		</tr>
	</table>
</form:form>


<%@include file="footer.jsp"%>