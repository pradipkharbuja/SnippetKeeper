<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div class="container">
	<form:form commandName="newSnippet" action="add" method="post">

		<form:errors path="*" cssStyle="color: red" />

		<div class="form-element">
			<label for="title">Title</label>
			<form:input path="title" />
		</div>

		<div class="form-element">
			<label for="language.langName">Language</label>
			<form:select path="language">
				<form:option value="" label='-- SELECT LANGUAGE --' />
				<form:options items="${languagesAvilable}" itemLabel="langName"
					itemValue="langName" />
			</form:select>
		</div>

		<div class="form-element">
			<label for="categories">Category</label>
			<form:select path="categories" items="${formCategories}"
				itemLabel="categoryName" itemValue="categoryId" multiple="true"
				size="5" />
		</div>
		<div class="form-element">
			<input type="button" value="Add Category" onclick="newCategory();" />
		</div>
		<div class="form-element">
			<label for="snippet">Snippet</label>
			<form:textarea path="snippet" htmlEscape="true" />
		</div>

		<div class="form-element">
			<input type="submit" value="Add Snippet" />
		</div>
	</form:form>
</div>
