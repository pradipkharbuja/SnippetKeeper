<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${successMessage}">
	<div id="alertMessage" class="success">
		<spring:message code="bugDetails.sucessful" text="default" />
	</div>
</c:if>
<br>
<p>
	<b>Title: </b> ${bug.title}
</p>
<br>
<p>
	<b>Content: </b> ${bug.content}
</p>
<br>
<p>
	<b>Email: </b> ${bug.user.email}
</p>
<br>
<img src="<c:url value="/resource/images/${bug.imagePath}.png"></c:url>"
	alt="image" width="300" />
<br>
<br>
<a href="snippet" class="btn btn-warning">Go to Snippet</a>