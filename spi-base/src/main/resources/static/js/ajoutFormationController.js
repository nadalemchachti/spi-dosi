app.controller('ajoutFormationController', ['$scope','$http','$location',function($scope, $http,$location) {	    
		 $scope.creerFormation = function() {
			 var formationAcreer = $scope.formationACreer;
			 $http.post('/formations', formationAcreer).then(function(){
				 $location.path('/formation');
			 });
		 }; 
		 
		
}]);

