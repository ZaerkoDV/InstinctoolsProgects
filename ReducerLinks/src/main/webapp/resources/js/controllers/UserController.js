

var UserController = function($scope, $http) {
	$scope.user = {};
	
	$scope.addUser=function(user){
		$http.post('/user/signUp', user).success(function() {
			$scope.user.firstName = '';
			$scope.user.lastName = '';
		});
	};
	
};

