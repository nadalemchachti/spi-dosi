app.controller('ajoutEnseignantController', ['$scope','$http','$location',function($scope, $http,$location) {	    
	 $scope.creerEnseignant = function() {
		 var enseignantAcreer = $scope.enseignant;
		 $http.post('/enseignants', enseignantAcreer).then(function(){
			 $location.path('/enseignant');

		 });
	 }; 
	 
	
}]);

