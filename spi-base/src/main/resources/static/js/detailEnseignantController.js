app.controller('detailEnseignant', ['$scope','$http','$routeParams',function($scope, $http , $routeParams) {
	  
	
	 $http.get('/enseignants/'+$routeParams.id).then(function(data) {
		    $scope.enseignants = data;
		    });
		  
}]);

