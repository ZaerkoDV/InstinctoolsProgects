/**
 * operationStatus-this is result of operation which set after each cheak request(object) 
 */
function LoginController($scope, $http, $location, $rootScope) {

	$scope.author = {};
	$scope.author.name = '';
	$scope.author.surname = '';
	$scope.author.patronymic = '';
	$scope.author.email = '';
	$scope.author.login = '';
	$scope.author.password = '';

	//Create new author
	$scope.authorSignUp = function(author) {
		$http.post('author/signup', author)

		.success(function(operationStatus) {   
			//if operation status is null get error
			if(operationStatus===null) {
				$scope.resetError();
				$scope.setError('Author sign up is failure.Try again.Because operation status is null.');
				return;
			}
			//if operation status is ok redurect to start page=link page
			if(operationStatus==='ok'){
				$scope.author.name = '';
				$scope.author.surname = '';
				$scope.author.patronymic = '';
				$scope.author.email = '';
				$scope.author.login = '';
				$scope.author.password = '';

				$rootScope.operationStatus=operationStatus;
				$location.path("/link");	
			}
		})

		.error(function() {
			$scope.resetError();
			$scope.setError('Author sign up is failure.Because operation status is empty.');
		});
	};

//	$scope.authorSignIn = function(author) {

//	};


	$scope.resetError = function() {
		$scope.error = false;
		$scope.errorMessage = '';
	};

	$scope.setError = function(message) {
		$scope.error = true;
		$scope.errorMessage = message;
		$rootScope.operationStatus='';
	};
};