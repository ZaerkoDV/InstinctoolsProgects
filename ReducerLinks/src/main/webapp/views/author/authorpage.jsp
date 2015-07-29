<!doctype html>
<html lang="en" ng-app="ReducerLinks" >
<head>

<title>Welcome author!</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">

<!--
	<link rel="stylesheet" href="resources/lib/css/bootstrap.min.css" />
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
	background: url(resources/pictures/authorpagethema.jpg) repeat-y;
	background-size: 100% 200%;
	display: compact;
}

.jumbotron {
	position: relative;
	background: #FFFFFF center center;
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
	        <li><a href="/index"><span class="glyphicon glyphicon-log-out"></span>Sign out</a></li>
	      </ul>
	    </div>
	  </div>
	</nav>

	<div class="container">
		<div class="jumbotron">
			<div class="row">
				<form class="authorPageForm">
					<fieldset>
						<h2>Your link. Create,delete or add new link...</h2>
						<table class="table table-hover"
							ng-show="authorLinksList.length>0">

							<thead>
								<tr>
									<th>Number</th>
									<th>Note</th>
									<th>URL</th>
									<th>Tag</th>
									<th>Rating</th>
								</tr>
							</thead>

							<tbody>
								<!-- display all author links-->
								<tr ng-repeat="item in authorLinksList">
									<td>{{item.link.idLink}}</td>
									<td>{{item.link.linkNote}}</td>
									<td>{{item.link.linkFullURL}}</td>
									<td>{{item.link.urlTag}}</td>
									<td>{{item.link.sumClick}}</td>
									<td><button class="btn btn-link"
											ng-click="removeLink(item.link.idLink)">Delete</button></td>
									<td><button class="btn btn-link"
											ng-click="updateLink(item.link)">Edit</button></td>
								</tr>
								<!--add new link  -->
								<tr>
									<td></td>
									<td>
										<div class="control-group">
											<div class="controls">
												<input type="text" id="linkNoteInput" name="linkNoteInput"
													ng-model="link.linkNote" placeholder="Link note" required>
											</div>
											<span style="color: red" ng-show="authorPageForm.linkNoteInput.$error.required &&
											authorPageForm.linkNoteInput.$dirty">required</span>
										</div>
									</td>
									<td>
										<div class="form-group">
											<div class="controls">
												<input type="url" id="urlInput" name="urlInput"
													ng-model="link.linkFullURL" placeholder="URL" required>
											</div>
											<span style="color: red" ng-show="authorPageForm.urlInput.$error.required &&
											authorPageForm.urlInput.$dirty">required</span>
											<span style="color: red" ng-show="authorPageForm.urlInput.$error.url">Invalid URL</span>
										</div>
									</td>
									<td>
										<div class="form-group">
											<div class="controls">
												<input type="text" id="urlTagInput" name="urlTagInput" ng-model="link.urlTag" placeholder="Tag" required>
											</div>
											<span style="color: red" ng-show="authorPageForm.urlTagInput.$error.required &&
							     				 authorPageForm.urlTagInput.$dirty">required</span>
										</div>
									</td>
									<td>0</td>
									<!--Save if all fields is filled.-->
									<td>
										<button class="btn btn-primary"
											ng-disabled="!link.linkFullURL || !link.urlTag"
											ng-hide="editMode" ng-click="addLink(link,idAuthor)">Save</button>
									</td>
								</tr>
							</tbody>

						</table>
					</fieldset>
				</form>
			</div>
		</div>
	</div>

	<div ng-view></div>
</body>
</html>