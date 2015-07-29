<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Authorization</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<!--
	<link rel="stylesheet" href="resources/lib/css/bootstrap.min.css"/>
	<script src="resources/lib/js/bootstrap.min.js"></script>
	<script src="resources/lib/angular/angular.js"></script>
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
  
  .well {
	  top: 0px;
	  left: 0px;
	  margin-top: 100px;
	  margin-left: 50px;
	}
	
	.errorblock {
		color: #000;
		background-color: #ffEEEE;
		border: 3px solid #ff0000;
		padding: 8px;
		margin: 16px;
	}
	
 </style> 
</head>
<body>

	<div class="col-lg-6 col-lg-offset-3">
		<div class="well">
			<div class="container">
			  <div class="row">
				 <div class="col-lg-6">
				    <form name="authorAuthorizationForm">
					   <fieldset>
						<legend>Pleace enter login and password</legend>	

						<div class="form-group">
							 <label for="authorLoginInput">Login</label>
							 
							 <input type="text" class="form-control" id="authorLoginInput" name="authorLoginInput" 
							  placeholder="Login" ng-model="author.login" ng-pattern="/^[A-z][A-z0-9]*$/" ng-minlength="4" required/>
							  
							  <span style="color:red" ng-show="authorAuthorizationForm.authorLoginInput.$error.required &&
							  authorAuthorizationForm.authorLoginInput.$dirty">required</span>
							  
							  <span style="color:red" ng-show="!authorAuthorizationForm.$error.required &&
							  authorAuthorizationForm.authorLoginInput.$error.minlength &&
							  authorAuthorizationForm.authorLoginInput.$dirty">Login must be more 4 characters.</span>
							  
							  <span style="color:red" ng-show="!authorAuthorizationForm.authorLoginInput.$error.required &&
							  authorAuthorizationForm.authorLoginInput.$error.authorLoginInput &&
							  authorAuthorizationForm.authorLoginInput.$dirty">Invalid login</span>
							  
						 </div>
							
						 <div class="form-group">
							 <label for="authorPasswordInput">Password</label>
							 
							 <input type="text" class="form-control" id="authorPasswordInput" name="authorPasswordInput" 
							  placeholder="Password" ng-model="author.password" ng-pattern="/^[A-z][A-z0-9]*$/" ng-minlength="4" required/>
							 
							  <span style="color:red" ng-show="authorAuthorizationForm.authorPasswordInput.$error.required &&
							  authorAuthorizationForm.authorPasswordInput.$dirty">required</span>
							  
							  <span style="color:red" ng-show="!authorAuthorizationForm.$error.required &&
							  authorAuthorizationForm.authorPasswordInput.$error.minlength &&
							  authorAuthorizationForm.authorPasswordInput.$dirty">Password must be more 4 characters.</span>
							  
							  <span style="color:red" ng-show="!authorAuthorizationForm.authorPasswordInput.$error.required &&
							  authorAuthorizationForm.authorPasswordInput.$error.authorPasswordInput &&
							  authorAuthorizationForm.authorPasswordInput.$dirty">Invalid password</span>
						 </div>

							<div class="control-group">
								<div class="controls">
									<button type="submit" class="btn btn-primary"
										ng-disabled="!author.login || !author.password"
										ng-hide="editMode"ng-submit="signInAuthor(author)">Ok</button>

									<a href="/ReducerLinks/index.jsp" class="btn btn-primary" role="button">Cancel</a>
								</div>
							</div>

						  </fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>