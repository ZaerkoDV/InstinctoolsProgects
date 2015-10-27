'use strict';


//angular.module('ReducerLinks').controller('LinkController', ['$scope', '$http', function ($scope, $http) {
//}]);
var LinkController = function($scope, $http) {
	
	$scope.fetchAllLinkList = function() {
		$http.get('link/linkslist.json').success(function(linklist){
			$scope.links =linklist;
			$scope.showLinkTbl=true;
		});
	};
	$scope.fetchAllLinkList();

	$scope.fetchAllTagList = function() {
		$http.get('link/tagslist.json').success(function(taglist){
			$scope.tags =taglist;
		});
	};
	$scope.fetchAllTagList();

	//поиск по тегу
	//тут указывается путь до ресурса для принятия java контроллером
	$scope.searchTag = function(tag) {
		$http.get('link/searchTag/' + tag+ '/searchTagResult.json').success(function(searchTagResult) {
			$scope.linksByTag = searchTagResult;
			$scope.linksByAuthor='';
			$scope.showLinkTbl=false;
		}).error(function() {
			$scope.setError('Could not');
		});
	};
	
	//поиск по автору
	$scope.searchAuthor = function(id) {
		$http.get('link/searchAuthor/' + id+ '/searchAuthorResult.json').success(function(searchAuthorResult) {
			$scope.linksByAuthor = searchAuthorResult;
			$scope.linksByTag = '';
			$scope.showLinkTbl=false;
		}).error(function() {
			$scope.setError('Could not');
		});
	};
	
	//инкремент кликов по url
	$scope.increaseNumberLinkVisits = function(idLink) {
		$http.get('link/increaseNumberLinkVisits/'+idLink).success(function() {
		}).error(function() {
			$scope.setError('Could not increase number of link visits');
		});
	};
	
	
	$scope.id=1708;
	//save new link
	$scope.addLink=function(linkHistory){
		$http.post('link/addLink', linkHistory).success(function() {
		}).error(function() {
			$scope.setError('Could not save save');
		});
	};
	
	//$scope.id=1708;
	//get user links
	$scope.getAllUserLink=function(id){
		$http.get('link/getUserLinks/'+id+'/userLinks.json').success(function(links) {
			$scope.linksHistory=links;
			
		}).error(function() {
			$scope.setError('Could not load user link.');
		});
	};
	
		
	
};




