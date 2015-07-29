/**
 * 
 */

var ReducerLinks = {};

var App = angular.module('ReducerLinks', ['ReducerLinks.filters', 'ReducerLinks.services', 'ReducerLinks.directives']);
//var app = angular.module('myapp', ['UserValidation']);
App.config(['$routeProvider', function($routeProvider) {

	 $routeProvider.when('/author', {
		 templateUrl: '/author/authorization',
		 controller: AuthorController
	 });
	 
	 $routeProvider.when('/author/registration', {
		    templateUrl: '/author/registration',
		    controller: AuthorController
	 });
	 
	 $routeProvider.when('/author/authorpage', {
		    templateUrl: '/author/authorpage',
		    controller: AuthorController
	 });
	 
	 $routeProvider.when('/author/failure', {
	     templateUrl: '/author/failure',
	     controller: AuthorController
	}); 
	 
	$routeProvider.when('/author/authorpage/addLink', {
	    templateUrl: '/link/addLink',
	    controller:LinkController
	});
	 
    $routeProvider.when('/author/authorpage/updateLink', {
	    templateUrl: '/link/updateLink',
	    controller: LinkController
	});
    
	$routeProvider.when('/author/authorpage/removeLink', {
	    templateUrl: '/link/removeLink',
	    controller: LinkController
	});
	
	$routeProvider.when('/link/tagpage', {
	     templateUrl: '/link/tagpage',
	     controller: LinkController
	}); 

	$routeProvider.when('/', {
	     templateUrl: '/index',
	     controller: AuthorController
	}); 
	
    $routeProvider.otherwise({redirectTo: '/' });
}]);


 
 
 
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