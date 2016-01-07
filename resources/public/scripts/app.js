var app = angular.module('TestCasesApp',['ngRoute']);

app.config(function($routeProvider) {

	$routeProvider
		.when('/', {
			templateUrl : 'templates/main.html',
			controller : 'ListController'
		})
		.when('/addtestcase', {
			templateUrl : 'templates/addtestcase.html',
			controller : 'AddController'
		})
		.when('/edittestcase/:id', {
			templateUrl : 'templates/edittestcase.html',
			controller : 'EditController'
		})
		.when('/deletetestcase/:id', {
			templateUrl : 'templates/deletetestcase.html',
			controller : 'DeleteController'
		})
		.when('/findtestcase', {
			templateUrl : 'templates/findtestcase.html',
			controller : 'FindController'
		})
		.otherwise('/');

});