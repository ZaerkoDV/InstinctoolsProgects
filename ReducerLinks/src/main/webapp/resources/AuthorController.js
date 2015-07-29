/**
 * AuthorController
 */
var AuthorController = function($scope, $http) {
	$scope.author = {};
	$scope.editMode = false;

	//get all links list
	$scope.getAllLinkList = function() {
        $http.get('/index').success(function(allLinkList){
        	$scope.allLinkList = allLinkList;
        });
    };
	
	
	//load on index.jsp authors links
	$scope.getIndexPage = function() {
		$http.get('/index').success(function(){
			$scope.getAllLinkList();
		});
	};
	
	$scope.getFailurePage = function() {
		$http.get('/author/failure').success(function(){
		});
	};
	
	//get autorization page
	$scope.getAuthorizationPage = function() {
		$http.get('/author/authorization').success(function(){
		});
	};
	
	//Author authorization
	$scope.signInAuthor = function(author) {

		$scope.resetError();
		$http.post('/author/authorization', author).success(function() {
			$scope.author.login = '';
			$scope.author.password = '';
		}).error(function() {
			$scope.setError('Author could not authorization.');
		});
	};

	//get registration page
	$scope.getRegistrationPage = function() {
		$http.get('/author/registration').success(function(){
		});
	};
	
	//Registracion(add) new author
	$scope.addAuthor=function(author){

		$scope.resetError(); 
		$http.post('/author/registration', author).success(function() {
			$scope.author.name = '';
			$scope.author.surname = '';
			$scope.author.patronymic = '';
			$scope.author.email = '';
			$scope.author.login = '';
			$scope.author.password = '';
		}).error(function() {
			$scope.setError('Author registration failed.');
		}); 
	};

	//get author page and load all author links for add new and update old
	$scope.getAuthorPage=function(idAuthor){									
		$http.get('/author/authorpage/' + idAuthor).success(function(authorLinksList,idAuthor){
			$scope.authorLinksList = authorLinksList;
			$scope.idAuthor=idAuthor;
		});
	};

//	//Update author
//	$scope.updateAuthor=function(author){

//	$scope.resetError(); 
//	$http.post('author/update', author).success(function() {
//	$scope.author.name = '';
//	$scope.author.surname = '';
//	$scope.author.patronymic = '';
//	$scope.author.email = '';
//	$scope.author.login = '';
//	$scope.author.password = '';
//	}).error(function() {
//	$scope.setError('Author registration failed.');
//	}); 
//	};  	

	$scope.editAuthor= function(author) {
		$scope.resetError();
		$scope.author = author;
		$scope.editMode = true;
	};
	
	$scope.resetAuthorsForm = function() {
        $scope.resetError();
        $scope.author = {};
        $scope.editMode = false;
    };

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };
};

