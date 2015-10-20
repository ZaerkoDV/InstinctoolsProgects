

var UserController = function($scope, $http) {

	$scope.addUser = function(userSecurity){
		$http.post('user/addUser', userSecurity).success(function() {
		}).error(function() {
			$scope.setError('Could not signUp');
		});
	};

	$scope.signIn = function(userSecurity){
		$http.post('user/signIn/userData.json', userSecurity).success(function(id) {
			$scope.getRedirectTo(id);
		}).error(function() {
			$scope.setError('Could not signIn');
		});
	};
	
//not work
//	$scope.getRedirectTo = function(id) {
//		$http.get('user/getRedirectTo/'+id).success(function() {
//			$scope.id=id;
//		}).error(function() {
//			$scope.setError('Could not redirect');
//		});
//	};
	
	$scope.id=1708;
	$scope.addUserCorespondence = function(userCorespondence){
		$http.post('user/addUserCorespondence', userCorespondence).success(function() {
		}).error(function() {
			$scope.setError('Could not save userCorespondence');
		});
	};
	
	
	
	
	
};

