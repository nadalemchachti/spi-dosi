app.controller('modifierEnseignantController', ['$scope','$http','$routeParams','$location',function($scope, $http , $routeParams,$location) {
	  
	
	$http.get('/enseignants/'+$routeParams.id).then(function(data) {
	    $scope.enseignant = data.data;
	    });
	
	 $scope.modifierEnseignant = function() {
		 var enseignantAModifier = $scope.enseignant;
		 $http.put('/enseignants', enseignantAModifier).then(function(){
			 $location.path('/enseignant');
	 });}
	 
	
}]);