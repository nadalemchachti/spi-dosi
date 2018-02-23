app.controller('Formation', ['$scope','$http',function($scope, $http) {
	  
	
	 $http.get('/formations').then(function(data) {
		    $scope.formations = data;
		    });
		  
	 
	 $scope.remove = function(id) {
	        $http.delete('/formations/delete/'+id).then(function(){$http.get('/formations').then(function(data) {
			    $scope.formations = data;})
	        
			    });
	    };
		 		 
		 $scope.rechercherFormation= function(NomFormation){
			 $http.get('/formations/nom/'+NomFormation).then(function(data) {
				    $scope.formations = data; });
		 };
}]);

