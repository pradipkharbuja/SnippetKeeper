<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="workflow-box">
<h1>Report Bug</h1>
<form:form modelAttribute="bug" enctype="multipart/form-data">

	<table>
		<tr>
			<td><spring:message code="addBug.form.title" text="Title" />:</td>
			<td><form:input id="title" path="title" /></td>
			<td><form:errors path="title" cssStyle="color: red"/></td>
		</tr>
		<tr>
			<td><spring:message code="addBug.form.content" text="Content" />:</td>
			<td><div class="form-element">
						<form:textarea id="content" path="content" cols="5" rows="20" />
					</div></td>
			<td><form:errors path="content" cssStyle="color: red"/></td>
		</tr>
	<%-- 	<tr>
			<td><spring:message code="addBug.form.email" text="Email" />:</td>
			<td><form:input id="email" path="email" /></td>
			<td><form:errors path="email" /></td>
		</tr> --%>
		<tr>
			<td><spring:message code="addBug.form.bugImage" text="Image" /></td>
			<td><form:input id="file" path="file" type="file"
					class="form:input-large" /></td>
			<td></td>
		</tr>

		<tr>
			<td colspan="3"><input type="submit" value="Submit" /></td>
		</tr>
	</table>
</form:form>
</div>