<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1>
	<spring:message code="registration" text="Registration" />
</h1>
<form:form commandName="user" method="post" action="registration"
	id="form-registration">
	<div id="errors"></div>
	<form:errors path="*" cssClass="error" />	
	<input type="hidden" name="enabled" value="1" />
	<input type="hidden" name="role" value="ROLE_USER" />
	<table>
		<tr>
			<td><spring:message code="username" text="Username" />:</td>
			<td><form:input path="username" /></td>
		</tr>
		<tr>
			<td><spring:message code="password" text="Password" />:</td>
			<td><form:password path="password" /></td>
		</tr>
		<tr>
			<td><spring:message code="fullName" text="Full Name" />:</td>
			<td><form:input path="fullName" /></td>
		</tr>
		<tr>
			<td><spring:message code="email" text="Email" />:</td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="Submit"
				id="btn-registration" /></td>
		</tr>
	</table>
</form:form>