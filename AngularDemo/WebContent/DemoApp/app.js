/**
 * 
 */
var app = angular.module('demoApp',[]); //creates new module, [] can hold injected dependencies
app.run(function($rootScope){
	$rootScope.favoriteColor = 'red';
})