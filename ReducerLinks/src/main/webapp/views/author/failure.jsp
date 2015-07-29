<!doctype html>
<html lang="en" ng-app="ReducerLinks">
<head>
		<title>Failure page</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!--
		<link rel="stylesheet" href="resources/lib/css/bootstrap.min.css"/>
		<script src="resources/lib/js/jquery.min.js"></script>
		<script src="resources/lib/js/bootstrap.min.js"></script>
		<script src="resources/lib/angular/angular.js"></script>
		<script src="resources/lib/angular/angular-resource.js"></script>
		-->
		
		<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	  	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
		
</head>
<style>
	body {
		height: 100%;
		margin: 0;
		background: url(resources/pictures/error.jpg);
		background-size: 100% 400%;
		background-repeat: no-repeat;
		display: compact;
	}
	
	.container {
		top: 0px;
		left: 0px;
		margin-top: 0px;
		margin-left: 0px;
	}
</style>
</head>
<body>

	<div class="container">
		<div>
			<h1>
				<div class="alert alert-danger">
					<strong>Oh snap!</strong>
				</div>
			</h1>
			<h1>
				<div class="alert alert-danger">
					<strong>Something is wrong. Change a few things up and try again your operation.</strong>
				</div>
			</h1>
		</div>
		<div>
			<a class="btn btn-danger" href="/ReducerLinks/index.jsp">Return</a>
		</div>
	</div>

</body>
</html>
