<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- css -->
<link rel="stylesheet" href="resources/js/libs/node_modules/bootstrap/dist/css/bootstrap.css" media="all" />

<!-- js -->
<script src="resources/js/libs/node_modules/angular/angular.js"></script>
<script src="resources/js/libs/node_modules/requirejs/require.js" data-main="resources/js/<t:getAsString name="application" />/index.js"></script>

<script>
var CXT = {
  contextPath : '${context_path}',
  web_api : {<c:forEach var="api" items="${web_api}">${api.key} : '${api.value}',</c:forEach>}
};
</script>

