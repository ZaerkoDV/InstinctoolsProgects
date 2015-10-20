'use strict';

var ReducerLinks = {};
var App = angular.module('ReducerLinks',['ngRoute']);
App.config(function($routeProvider) {//'$routeProvider',
	
	 $routeProvider.when('/link', {
		 templateUrl: 'link/links',
		 controller: LinkController
	 });
	 
	 $routeProvider.when('/tag', {
		 templateUrl: 'link/tags',
		 controller: LinkController
	 });
	 
	 $routeProvider.when('/link/userLinks', {
		 templateUrl: 'link/userLinks',
		 controller: LinkController
	 });
	 
	 $routeProvider.when('/link/newLink', {
		 templateUrl: 'link/newLink',
		 controller: LinkController
	 });
	 
//	 $routeProvider.when('/searchtag', {
//		 templateUrl: 'link/searchTag',
//		 controller: LinkController
//	 });
	 
	 $routeProvider.when('/user/signUp', {
		 templateUrl: 'user/signUp',
		 controller: UserController
	 });
	 
	 $routeProvider.when('/user/signIn', {
		    templateUrl: 'user/signIn',
		    controller: UserController
	 });
	 
	 $routeProvider.when('/user/userAccount', {
		    templateUrl: 'user/userAccount',
		    controller: UserController
	 });
	 
	 $routeProvider.when('/user/addCorespondence', {
		    templateUrl: 'user/addCorespondence',
		    controller: UserController
	 });
	 
	 
//	 $routeProvider.when('/admin/adminAccount', {
//		    templateUrl: 'admin/adminAccount',
//		    controller: AdminController
//	 });
	 
	 
	 
	 
	 
	 $routeProvider.otherwise({redirectTo: '/'});
});


//var App={};
//var App = angular.module('App',[]);
//
//App.config(['$routeProvider', '$locationProvider', function($routeProvider) {
//
//    $routeProvider.when('/link', {
//        templateUrl: 'link/startPage',
//        controller: LinkController
//    });
//    
//    $routeProvider.when('/author/signup', {
//        templateUrl: 'author/signup',
//        controller: AuthorController
//    });
//
//    $routeProvider.otherwise({redirectTo: '/link'});
//}]);
//
////Author signin or signup validation
//App.run(function($rootScope, $location) {
//	
//    	// register listener to watch route changes
//		$rootScope.$on("$routeChangeStart", function(event, next, current) {
//        console.log("Operation status="+$rootScope.operationStatus);
//
//        //operationStatus-this is result of operation which set after each cheak request(object)
//        if ($rootScope.operationStatus == '' || $rootScope.operationStatus == null) {
//            // no logged user, we should be going to #login
//            if (next.templateUrl == "author/failure.jsp") {
//                // already going to failure, no redirect needed
//            } else {
//                // not going to failure, we should redirect now
//                $location.path("/author/failure.jsp");
//            }
//        }
//    });
//});