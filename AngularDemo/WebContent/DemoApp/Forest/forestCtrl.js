/**
 * 
 */
angular.module('demoApp').controller('forestCtrl', function forestCtrl($scope, $interval, $http) {
	
	$http({method: "GET",
        url:"http://localhost:8083/SpringDataDemo/cave/all"
    }).then(function(response){
        $scope.caves = response.data;
    }, function(response){
        return {
            name: "ERROR",
            description: "response.data"
        }
    });
	        

		$interval (function() {
			$http({method: "GET",
		        url:"http://localhost:8083/SpringDataDemo/cave/all"
		    }).then(function(response){
		        $scope.caves = response.data;
		    }, function(response){
		        return {
		            name: "ERROR",
		            description: "response.data"
		        }
		    });
		},10000);

	
	$scope.addCave = function(){
		if ($scope.newCaveName) {
			$http({
				method: 'POST',
				url: 'http://localhost:8083/SpringDataDemo/cave',
				data: {"name":$scope.newCaveName}
				});
			$scope.newCaveName = "";
			$scope.inputStyle = {background:'white'};
		}else {
			$scope.inputStyle = {background:'red'};
		}
	};
	$scope.remove = function (){
		var oldCaves = $scope.caves;
		angular.forEach(oldCaves, function(cave) {
			if ((cave.rm)) {
				$http.delete('http://localhost:8083/SpringDataDemo/cave/'+cave.id)
				.then(function(response) {
					console.log(response.data);
				});
			};
		});
	};
	
	// demonstrate $interval service
	 $scope.theTime = new Date().toLocaleTimeString();
	    $interval(function () {
	        $scope.theTime = new Date().toLocaleTimeString();
	    }, 1000);

});