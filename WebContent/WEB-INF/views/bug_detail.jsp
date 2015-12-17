<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p><spring:message code="bugDetails.sucessful" text="default"/></p>
<p>${bug.title}</p>
<p>${bug.content}</p>
<p>${bug.user.email}</p>

<img src="<c:url value="/resource/images/${bug.imagePath}.png"></c:url>" alt="image"  style = "width:100%"/> 