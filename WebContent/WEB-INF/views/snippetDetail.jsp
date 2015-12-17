<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<link rel="stylesheet" href="resources/prism/lib/codemirror.css">
<script src="resources/prism/lib/codemirror.js"></script>

<c:if test = '${snippet.language.langName eq "java"}'>
	<script src="resources/prism/mode/clike/clike.js"></script>
	<c:set var="lang" value="text/x-java"></c:set>
</c:if>
<c:if test = '${snippet.language.langName eq "xml"}'>
	<script src="resources/prism/mode/xml/xml.js"></script>
	<c:set var="lang" value="text/xml"></c:set>
</c:if>
<script src="resources/prism/addon/selection/active-line.js"></script>
<script src="resources/prism/addon/edit/matchbrackets.js"></script>
<div class="container">
	<h2>${snippet.title}</h2>

	<textarea id="code" name="code" rows="60" cols="50" data-lang='<c:out value="${lang}" />'>
		${snippet.snippet}
	</textarea>


</div>

<script>
var config = {
		lineNumbers : true,
		styleActiveLine : true,
		matchBrackets : true,
		width: 500,
		height: 700,
}
var lang = $("#code").data("lang");
config.mode = lang;

var editor = CodeMirror.fromTextArea(document.getElementById("code"), config);
</script>
