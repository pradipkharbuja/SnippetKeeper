<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script type="text/javascript"
	src="<spring:url value="resources/js/ajax.js"/>"></script>

<div class="container">
	<div class="workflow-box">
		<h1>Add a Snippet</h1>
		<form:form commandName="newSnippet" action="snippet/add" method="post">
			<div id="alertMessage">
				<form:errors path="*" cssStyle="color: red" />
			</div>
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
				<input type="submit" class="btn btn-success" value="Add Snippet" />
				<a class="btn btn-warning" href="snippet">Back</a>
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


				<div class="form-element">
					<label for="categoryName"> Name : </label> <input type="text"
						name="categoryName" id="categoryName" value="" />
				</div>
				<div class="form-element">
					<input type="button" value="Add Category"
						onclick="categorySubmit();return false;">
				</div>

			</form>
			<h4 align="center">
				<a onclick="make_hidden('formInput'); make_hidden('result');"> <b>EXIT</b>
				</a>
			</h4>
		</div>
	</div>
</div>
<script>
	function showCategoryForm() {
		make_visible('formInput');
		return false;
	}

	$(function() {
		$("#categories > option:nth-child(1)").attr("selected", "true");
	});
</script>
