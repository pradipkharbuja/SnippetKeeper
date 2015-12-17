<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<div class="snapper">
		<h1>Snippet</h1>
		<a class="btn btn-success" href="snippet/add">Add Snippet</a>
	</div>
	<c:if test="${noSnippets}">
		<div class="emptyMessage">
			<p>No Snippet Found</p>
		</div>
	</c:if>

	<c:if test="${!noSnippets}">
		<ul id="snippetList">
			<c:forEach var="snippet" items="${snippets}">
				<li>
					<div class="snippet">
						<span><a
							href="snippet/${snippet.snippetId}">${snippet.title}</a> <span
							class="pull-right">${snippet.language.langName}</span>
					</div>
				</li>

			</c:forEach>
		</ul>
	</c:if>
</div>