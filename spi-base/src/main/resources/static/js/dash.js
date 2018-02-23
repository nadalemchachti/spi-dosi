app.controller('dash', ['$scope','$http',function($scope, $http) {
	  
	
	 $http.get('/formations/count/').then(function(data) {
		    $scope.CF = data.data;
		    
		    });
	 
	 $http.get('/enseignants/count/').then(function(data) {
		    $scope.CE = data.data;
		    });
		  
	 
	
}]);

