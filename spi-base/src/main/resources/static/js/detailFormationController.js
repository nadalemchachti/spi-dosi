app.controller('detailFormation', ['$scope','$http','$routeParams',function($scope, $http , $routeParams) {
	  
	
	 $http.get('/formations/code/'+$routeParams.id).then(function(data) {
		    $scope.formation = data;
		    });
		  
}]);

