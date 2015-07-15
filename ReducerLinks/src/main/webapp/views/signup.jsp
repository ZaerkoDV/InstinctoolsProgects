<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Author sign up page</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<link href="resources/lib/bootstrap.min.css" rel="stylesheet">
		<script src="resources/lib/jquery.min.js"/></script>
		<script src="resources/lib/bootstrap.min.js"/></script>
		<script src="resources/lib/angular.js"></script>
</head>
<body>

<div class="container-fluid">
    <div id="wrapper" class="row-fluid">
        <h3 class='menu'>Author signup</h3>
        <div class="alert alert-error" ng-show="error">{{errorMessage}}</div>
        <form class="form-horizontal">

            <div class="control-group">
                <label class="control-label" for="author_name">Name</label>

                <div class="controls">
                    <input type="text" id="author_name" ng-model="author.name" placeholder="name" required min="2">
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="author_surname">Surname</label>

                <div class="controls">
                    <input type="text" id="author_surname" ng-model="author.surname"  placeholder="Surname" required min="2">
                </div>
            </div>

			<div class="control-group">
                <label class="control-label" for="author_patronymic">Patronymic</label>

                <div class="controls">
                    <input type="text" id="author_patronymic" ng-model="author.patronymic"  placeholder="Patronymic" required min="2">
                </div>
            </div>
            
            <div class="control-group">
                <label class="control-label" for="author_email">Email</label>

                <div class="controls">
                    <input type="text" id="author_email" ng-model="author.email"  placeholder="Email" required min="2">
                </div>
            </div>

 			<div class="control-group">
                <label class="control-label" for="author_login">Login</label>

                <div class="controls">
                    <input type="text" id="author_login" ng-model="author.login"  placeholder="Login" required min="2">
                </div>
            </div>

			<div class="control-group">
                <label class="control-label" for="author_password">Password</label>

                <div class="controls">
                    <input type="text" id="author_password" ng-model="author.password"  placeholder="Password" required min="2">
                </div>
            </div>

            <div class="control-group">                                             
                <div class="controls">
                   <!--<a href="#" style="margin-right: 20px">Forgot password </a> -->
          
                    <button type="button" class="btn btn-primary" ng-disabled="!author.email || !author.password" ng-click="authorSignUp(author)">Save</button>    
                </div>
            </div>
        </form>

    </div>
</div>



</body>
</html>