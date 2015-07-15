<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en" ng-app="App">
	<head>
		<title>index</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link href="resources/lib/bootstrap.min.css" rel="stylesheet">
		<script src="resources/lib/jquery.min.js"/></script>
		<script src="resources/lib/bootstrap.min.js"/></script>
		
		<script src="resources/lib/angular.js"></script>
		<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular-route.js"></script>
		<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.18/angular-resource.js"></script>
		
		<script src="resources/AuthorController.js"></script>
	    <script src="resources/LinkController.js"></script>
		<script src="resources/app.js"></script>
   </head>
   <body>
	 	<div ng-view></div> 
   </body>
</html>