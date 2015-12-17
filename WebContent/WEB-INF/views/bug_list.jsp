<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@include file="header.jsp"%>
<h1>Reported Bug List</h1>
<ol>
<c:forEach items="${bugs}" var="bug">
  <li><a href="<spring:url value="/bug/detail?id=${bug.id}"/>" > ${bug.title}</a> </li>
 </c:forEach>
</ol>
<%@include file="footer.jsp"%>