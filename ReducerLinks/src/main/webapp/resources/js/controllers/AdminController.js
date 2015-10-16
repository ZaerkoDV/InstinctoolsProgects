/**
 * 
 */

var LinkController = function($scope, $http) {
	$scope.link = {};
	$scope.editMode = false;
    
	//author add link
	$scope.addLink=function(link,idAuthor){

		$scope.resetError(); 
		$http.post('link/addLink', link, idAuthor).success(function(){
			$scope.link.linkNote='';
			$scope.link.linkFullURL='';
			$scope.link.linkShortURL='';
			$scope.link.urlTag='';
			$scope.link.sumClick=0;
			$scope.link.author.idAuthor=idAuthor;
		}).error(function() {
			$scope.setError('Could not add a new link.');
		});
	};

	//author add link
	$scope.updateLink=function(link){

		$scope.resetError(); 
		$http.post('link/updateLink',link).success(function(){
			$scope.link.linkNote='';
			$scope.link.linkFullURL='';
			$scope.link.linkShortURL='';
			$scope.link.urlTag='';
			$scope.link.sumClick=0;

		}).error(function() {
			$scope.setError('Could not add a new link.');
		});
	};

	$scope.removeLink=function(idLink){

		$scope.resetError(); 
		$http.post('link/removeLink/' + idLink).success(function(){
		}).error(function() {
			$scope.setError('Could not add a new link.');
		});
		$scope.link = '';
	};

	//get link list by tag
	$scope.getLinkListByTag = function(urlTag) {
        $http.get('/link/tagpage/'+ urlTag).success(function(linkListByTag){
        	$scope.linkListByTag = linkListByTag;
        });
    };
	
    $scope.getTagPage = function(urlTag) {
		$http.get('/link/tagpage/'+ urlTag).success(function(){
			$scope.getLinkListByTag();
		});
	};
	
	
	$scope.editLink= function(link) {
		$scope.resetError();
		$scope.author = author;
		$scope.editMode = true;
	};

	$scope.resetLinksForm = function() {
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