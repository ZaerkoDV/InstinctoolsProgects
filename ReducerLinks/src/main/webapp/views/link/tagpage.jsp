<!DOCTYPE html>
<html lang="en" ng-app="ReducerLinks" >
<head>
		<title>Links by tag</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<!--
		<link rel="stylesheet" href="resources/lib/css/bootstrap.min.css"/>
		<script src="resources/lib/js/bootstrap.min.js"></script>
		<script src="resources/lib/angular/angular.js"></script>
		<script src="resources/lib/angular/angular-resource.js"></script>
		-->
		<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	  	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<style>
body {
	height: 100%;
	margin: 0;
	background: url(resources/pictures/weblinkpic.jpg) repeat-y;
	background-size: 100% 200%;
	display: compact;
}

.jumbotron {
	position: relative;
	background: #FEFEFE center center;
	border-radius: 6px;
}

.navbar-inverse {
	background: #000333;
}
</style>
</head>

<body>
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div>
	      <ul class="nav navbar-nav">        
	       <!--
	      	<li><a href="#">Tag list</a></li>
	        <li><a href="#">Author list</a></li>
	        --> 
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
	        <li><a href="author/registration"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
	        <li><a href="author/authorization"><span class="glyphicon glyphicon-log-in"></span> Sign In</a></li>
	      </ul>
	    </div>
	  </div>
	</nav>
	 
	<div class="container">	
	  <div class="jumbotron">    
	     <h2>Link list by tag</h2>
	  		<p>Click on link and redurect to...</p>           
			  <table class="table table-hover" ng-show="linkListByTag.length > 0">

			    <thead>
			      <tr>
			      	<th>Note</th>	    
			        <th>URL</th>
			        <th>Tag</th>
			        <th>Author</th>
			      </tr>
			    </thead>
			      		    
			    <tbody>
			      <tr ng-repeat="item in linksListByTag">
			        <td>{{item.link.linkNote}}</td>
			        <td><a href={{item.link.linkFullURL}}>{{item.link.linkShortURL}}</a></td>
			        <td>{{item.link.urlTag}}</td>
			        <td>{{item.link.author.login}}</td>
			      </tr> 
			    </tbody>
			    
			  </table> 
	  </div>
	 </div>

	<div ng-view></div>
</body>
</html>