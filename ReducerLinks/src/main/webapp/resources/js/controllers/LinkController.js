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

	//����� �� ����
	//��� ����������� ���� �� ������� ��� �������� java ������������
	$scope.searchTag = function(tag) {
		$http.get('link/searchTag/' + tag+ '/searchTagResult.json').success(function(searchTagResult) {
			$scope.linksByTag = searchTagResult;
			$scope.linksByAuthor='';
			$scope.showLinkTbl=false;
		}).error(function() {
			$scope.setError('Could not');
		});
	};
	
	//����� �� ������
	$scope.searchAuthor = function(id) {
		$http.get('link/searchAuthor/' + id+ '/searchAuthorResult.json').success(function(searchAuthorResult) {
			$scope.linksByAuthor = searchAuthorResult;
			$scope.linksByTag = '';
			$scope.showLinkTbl=false;
		}).error(function() {
			$scope.setError('Could not');
		});
	};

//	//save new link
//	$scope.saveLink=function(linkHistory){
//		$http.post('link/saveLink', linkHistory).success(function() {
//			$scope.getRedirectTo(id);
//		}).error(function() {
//			$scope.setError('Could not save');
//		});
//	};
//	
//	//get all user links
//	$scope.getAllUserLink=function(id){
//		$http.post('link/saveLink', linkHistory).success(function() {
//			$scope.getRedirectTo(id);
//		}).error(function() {
//			$scope.setError('Could not load');
//		});
//	};
	
	
};




