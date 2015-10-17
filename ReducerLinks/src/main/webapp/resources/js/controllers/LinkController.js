'use strict';


//angular.module('ReducerLinks').controller('LinkController', ['$scope', '$http', function ($scope, $http) {
var LinkController = function($scope, $http) {
	$scope.links = [];
	$http.get('link/linkslist.json').success(function(list){
		$scope.links =list;
	});
};
//}]);


//angular.module('ReducerLinks').controller('LinkController', ['$scope', '$http', function ($scope, $http) {
//	$scope.links = [];
//	$http({
//		  method: 'GET',
//		  url: '/ReducerLinks/link/links'
//		}).then(function successCallback(response) {
//			console.log("FFFF");
//			$scope.links = [{
//			                	idLink: 1,
//			                	tag: 'foo 1',
//			                	comment: 'comment 1',
//			                	shortUrl: 'short url 1'
//			                },
//			                {
//			                	idLink: 2,
//			                	tag: 'foo 2 ',
//			                	comment: 'comment 2',
//			                	shortUrl: 'short url 2'
//			                },
//			                {
//			                	idLink: 3,
//			                	tag: 'foo 3',
//			                	comment: 'comment 3',
//			                	shortUrl: 'short url 3'
//			                }];
//		  }, function errorCallback(response) {
//		  });
//}]);


