<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script type="text/javascript"
	src="<spring:url value="resources/js/ajax.js"/>"></script>

<div class="container">
	<form:form commandName="newSnippet" action="snippet/add" method="post">

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
			<input type="button" value="Add Category"
				onclick="showCategoryForm();" />
		</div>
		<div class="form-element">
			<label for="snippet">Snippet</label>
			<form:textarea path="snippet" htmlEscape="true" />
		</div>

		<div class="form-element">
			<input type="submit" value="Add Snippet" />
		</div>
	</form:form>


	<!-- Success - or Validation errors -->
	<div id="result" style="display: none">
		<p id="success"></p>
		<p id="errors"></p>
	</div>

	<div id="formInput" style="display: none">

		<h3 align="center">Category</h3>

		<!-- No action method handled by AJAX-->
		<form id="categoryForm" method="post">


			<p>
				<label for="categoryName"> Name : </label> <input type="text" name="categoryName"
					id="categoryName" value="" />
			</p>

			<input type="button" value="Add Category"
				onclick="categorySubmit();return false;">

		</form>
		<h4 align="center">
			<a href="#"
				onclick="make_hidden('formInput'); make_hidden('result');resetForm('categoryForm');">
				<b>EXIT</b>
			</a>
		</h4>
	</div>
</div>
<script>
	function showCategoryForm() {
		make_visible('formInput');
		return false;
	}
</script>
