<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Reported Bug List</h1>
<ol>
<c:forEach items="${bugs}" var="bug">
  <li><a href="<spring:url value="/bug/detail?id=${bug.id}"/>" > ${bug.title}</a> </li>
 </c:forEach>
</ol>