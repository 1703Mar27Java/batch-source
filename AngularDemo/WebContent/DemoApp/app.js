/**
 * 
 */
var app = angular.module('demoApp', ['ngRoute']); // creates new module, [] can hold
// injected dependencies
app.run(function($rootScope) {
	$rootScope.favoriteColor = 'red';
})
app.directive("customDirective", function() {
	'use strict';
	return {
		template : "{{caves.length}}"
	}
});
app.config(function($routeProvider){
    $routeProvider
        .when('/', {
            templateUrl: 'home.html'
        })
        .when('/demo', {
            templateUrl: 'Demo/demoView.html',
            controller: 'demoCtrl'
        })
        .when('/forest', {
        	templateUrl: 'Forest/forestView.html',
        	controller: 'forestCtrl'
        })
        .otherwise({redirectTo: '/'});
});