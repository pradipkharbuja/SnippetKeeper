<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@include file="header.jsp"%>
<div class="container">
	<h2>${snippet.title}</h2>

	<textarea rows="20" cols="50">
		${snippet.snippet}
	</textarea>



</div>
<%@include file="footer.jsp"%>