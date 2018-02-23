'use strict';

var app = angular.module("myApp", ["ngRoute"]);

app.config(['$routeProvider',
    function($routeProvider) { 
		$routeProvider
			.when('/formation', {
				templateUrl: './views/formation.html',
				controller: 'Formation'
			})
		.when('/ajoutFormation', {
			templateUrl: './views/ajoutFormation.html',
			controller: 'ajoutFormationController'
		})
		.when('/detailFormation/:id', {
			templateUrl: './views/detailFormation.html',
			controller: 'detailFormation'
		})
		.when('/modifierFormation/:formation', {
			templateUrl: './views/modifierFormation.html',
			controller: 'modifierFormation'
		})
		.when('/enseignant', {
				templateUrl: './views/enseignant.html',
				controller: 'Enseignant'
			})
			.when('/detailEnseignant/:id', {
			templateUrl: './views/detailEnseignant.html',
			controller: 'detailEnseignant'
		})
			.when('/ajoutEnseignant', {
			templateUrl: './views/ajoutEnseignant.html',
			controller: 'ajoutEnseignantController'
		})
		.when('/modifierEnseignant/:id', {
			templateUrl: './views/modifierEnseignant.html',
			controller: 'modifierEnseignantController'
		})
		.when('/home', {
			templateUrl: './views/dash.html',
			controller: 'dash'
		})
	}]);