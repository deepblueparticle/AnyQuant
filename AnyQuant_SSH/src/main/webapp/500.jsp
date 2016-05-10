<%--Page 500--%>
<%--若异常未被处理,则最终会转到这个界面--%>


<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Page Not Found</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
	line-height: 1.2;
	margin: 0;
}

html {
	color: #888;
	display: table;
	font-family: sans-serif;
	height: 100%;
	text-align: center;
	width: 100%;
}

body {
	display: table-cell;
	vertical-align: middle;
	margin: 2em auto;
}

h1 {
	color: #555;
	font-size: 2em;
	font-weight: 400;
}

p {
	margin: 0 auto;
	width: 280px;
}

@media only screen and (max-width: 280px) {
	body, p {
		width: 95%;
	}
	h1 {
		font-size: 1.5em;
		margin: 0 0 0.3em;
	}
}
</style>
</head>
<body>
	<h1>Server Error!</h1>
	<p>Sorry, 服务器遇到了一些异常~</p>
	<h1>${ sessionScope.name}</h1>

</body>
</html>
