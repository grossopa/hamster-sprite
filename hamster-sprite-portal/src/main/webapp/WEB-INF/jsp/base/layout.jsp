<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<base href="${context_path}/">
<tiles:insertAttribute name="head" />
<title></title>
</head>
<body>
${context_path} 

<div id="ng" ng-controller="QueryController"></div>
</body>
</html>