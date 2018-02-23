app.controller('Enseignant', ['$scope','$http',function($scope, $http) {
	  
	
	 $http.get('/enseignants').then(function(data) {
		    $scope.enseignants = data;
		    });
		  
	 
	 $scope.remove = function(id) {
	        $http.delete('/enseignants/'+id).then(function(){
	        
	   	 $http.get('/enseignants').then(function(response) {
	   		    $scope.enseignants = response;
	   		    });
	    })};
		 		 
		 $scope.rechercherEnseignant= function(NomE){
			 $http.get('/enseignants/nom/'+NomE).then(function(data) {
				    $scope.enseignants = data; });
		 };
}]);

