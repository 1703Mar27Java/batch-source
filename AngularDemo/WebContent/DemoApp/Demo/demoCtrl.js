/**
 * 
 */
angular.module('demoApp').controller('demoCtrl',function demoCtrl($scope) {
	$scope.firstName = "Blue";
	$scope.newFirstName = "Orange"
	$scope.favoriteColor = "green";
	$scope.people=[{name:'Robert',state:'North Carolina'},{name:'Luis',state:'Florida'},{name:'Jesse',state:'Nanopod'}];
	$scope.changeName = function(newFirstName){
		$scope.firstName = newFirstName;
	}
});