<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Registration new author.</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
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
 
  .well {
	  top: 0px;
	  left: 0px;
	  margin-top: 20px;
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
				<div class="col-lg-5">
					<form class="authorRegistrationForm">
						<fieldset>
							<legend>
								<center>
									<p><h4>Weclome in reducer link system!	<h4></p>
									<h6>Pleace fill the form and press button ok.</h6>
								</center>
							</legend>

							<div class="form-group">
								<label for="authorNameInput">Name</label> <input type="text"
									class="form-control" id="authorNameInput"
									name="authorNameInput" ng-model="author.name"
									placeholder="longer then 1 symbol" ng-minlength="1" required />

								<span
									ng-show="authorRegistrationForm.authorNameInput.$error.required &&
							       authorRegistrationForm.authorNameInput.$dirty">required</span>

								<span
									ng-show="!authorRegistrationForm.$error.required &&
								  authorRegistrationForm.authorNameInput.$error.minlength &&
								  authorRegistrationForm.authorNameInput.$dirty">Name
									must be more 1 characters.</span>
							</div>


							<div class="form-group">
								<label for="authorSurnameInput">Surname</label> <input
									type="text" class="form-control" id="authorSurnameInput"
									name="authorSurnameInput" ng-model="author.surname"
									placeholder="longer then 1 symbol" ng-minlength="1" required />

								<span ng-show="authorRegistrationForm.authorSurnameInput.$error.required &&
							      authorRegistrationForm.authorSurnameInput.$dirty">required</span>

								<span ng-show="!authorRegistrationForm.$error.required &&
								  authorRegistrationForm.authorSurnameInput.$error.minlength &&
								  authorRegistrationForm.authorSurnameInput.$dirty">Surname
									must be more 1 characters.</span>
							</div>

							<div class="form-group">
								<label for="authorPatronymicInput">Patronymic</label> <input
									type="text" class="form-control" id="authorPatronymicInput"
									name="authorPatronymicInput" ng-model="author.patronymic"
									placeholder="" />
							</div>

							<div class="form-group">
								<label for="authorEmailInput">Email</label>
								<input type="text" class="form-control" id="authorEmailInput"
									name="authorEmailInput" ng-model="author.email"
									placeholder="longer then 4 symbol" ng-minlength="4" required />

								<span ng-show="authorRegistrationForm.authorEmailInput.$error.required &&
							      authorRegistrationForm.authorEmailInput.$dirty">required</span>

								<span ng-show="!authorRegistrationForm.authorEmailInput.$error.required &&
   								   authorRegistrationForm.authorEmailInput.$error.email &&
   								   authorRegistrationForm.authorEmailInput.$dirty">Invalid email</span>
							</div>

							<div class="form-group">
								<label for="authorLoginInput">Login</label> <input type="text"
									class="form-control" id="authorLoginInput"
									name="authorLoginInput" ng-model="author.login"
									placeholder="longer then 4 symbol"
									ng-pattern="/^[A-z][A-z0-9]*$/" ng-minlength="4" required /> <span
									ng-show="authorRegistrationForm.authorLoginInput.$error.required &&
								  authorRegistrationForm.authorLoginInput.$dirty">required</span>

								<span
									ng-show="!authorRegistrationForm.$error.required &&
								  authorRegistrationForm.authorLoginInput.$error.minlength &&
								  authorRegistrationForm.authorLoginInput.$dirty">Login
									must be more 5 characters.</span> <span
									ng-show="!authorRegistrationForm.authorLoginInput.$error.required &&
								  authorRegistrationForm.authorLoginInput.$error.authorLoginInput &&
								  authorRegistrationForm.authorLoginInput.$dirty">Invalid
									login</span>
							</div>


							<div class="form-group">
								<label for="authorPasswordInput">Password</label> <input
									type="text" class="form-control" id="authorPasswordInput"
									name="authorPasswordInput" ng-model="author.password"
									placeholder="longer then 4 symbol"
									ng-pattern="/^[A-z][A-z0-9]*$/" ng-minlength="4" required /> <span
									ng-show="authorRegistrationForm.authorPasswordInput.$error.required &&
								  authorRegistrationForm.authorPasswordInput.$dirty">required</span>

								<span
									ng-show="!authorRegistrationForm.$error.required &&
								  authorRegistrationForm.authorPasswordInput.$error.minlength &&
								  authorRegistrationForm.authorPasswordInput.$dirty">Password
									must be more 4 characters.</span> <span
									ng-show="!authorRegistrationForm.authorPasswordInput.$error.required &&
								  authorRegistrationForm.authorPasswordInput.$error.authorPasswordInput &&
								  authorRegistrationForm.authorPasswordInput.$dirty">Invalid
									password</span>
							</div>

							<div class="control-group">
								<div class="controls">
									<button type="submit" class="btn btn-primary"
										ng-disabled="!author.name || !author.surname ||  !author.email || !author.login || !author.password"
										ng-hide="editMode" ng-click="addAuthor(author)">Ok</button>

									<a href="/ReducerLinks/index.jsp" class="btn btn-primary"
										role="button">Cancel</a>
								</div>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>