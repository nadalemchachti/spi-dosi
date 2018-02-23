app.controller('modifierFormation', ['$scope','$http','$routeParams','$location',function($scope, $http , $routeParams,$location) {
	  
	
	 $http.get('/formations/code/'+$routeParams.formation).then(function(data) {
		    $scope.formationAModifier = data.data;
		    });
	
	 $scope.modifierFormation = function() {
		 var formationAModifier = $scope.formationAModifier;
		 $http.put('/formations', formationAModifier).then(function(){
			 $location.path('/formation');
		 });
	 }; 
	 
	
}]);