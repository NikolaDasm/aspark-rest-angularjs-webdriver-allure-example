app.controller('ListController', function($scope, $location, dataService) {

	$scope.tableHeaderItems = dataService.getTableHeaderItems();
	
	var testCasesPerPage = 20;
	$scope.currentPage = 1;
	
	$scope.testCases = {};
	var testCaseCount = 1;
	$scope.pageCount = 1;
	$scope.pages = [];
	
	$scope.findingTitle == "";
	
	dataService.getTestCaseCount()
		.then(
			function(response) {
				testCaseCount = response.data;
				$scope.pageCount = testCaseCount/testCasesPerPage;
				if ($scope.pageCount < 1) $scope.pageCount = 1;
				$scope.pages = [];
				for (var i=0; i<$scope.pageCount; i++) {
					$scope.pages.push(i+1);
				}
			}
		);
	
	$scope.paginationDisabled = function() {
		return $scope.pageCount < 2 ? true : false;
	};
	
	$scope.isCurrentPage = function(page) {
		return page === $scope.currentPage;
	};
	
	$scope.setPage = function(page) {
		$scope.currentPage = page;
	};
	
	$scope.$watch("currentPage", function(newValue, oldValue) {
		dataService.getTestCases(testCasesPerPage*(newValue-1), testCasesPerPage)
			.then(
				function(response) {
					$scope.testCases = response.data;
				}
			);
	});
	
	$scope.findTestCase = function() {
		dataService.findingTitle = $scope.findingTitle;
		$location.path('/findtestcase');
	};
});

app.controller('AddController', function($scope, $location, dataService) {
	
	$scope.message = "Add test case";
	
	$scope.testCase = {}
	
	$scope.addTestCase = function() {
		dataService.createNewTestCase($scope.testCase)
			.success(function (data) {
				$location.path('/');
			})
			.error(function (data, status) {
				$scope.message = "Error! " + data;
			});
	};
});

app.controller('EditController', function($scope, $location, $routeParams, dataService) {
	
	$scope.message = "Edit test case";
	
	$scope.testCase = {};
	
	dataService.getTestCase(parseInt($routeParams.id, 10))
		.then(
			function(response) {
				$scope.testCase = response.data;
			}
		);
	
	$scope.editTestCase = function() {
		dataService.editTestCase($scope.testCase)
			.success(function (data) {
				$location.path('/');
			})
			.error(function (data, status) {
				$scope.message = "Error! " + data;
			});
	};
});

app.controller('DeleteController', function($scope, $location, $routeParams, dataService) {

	$scope.tableHeaderItems = dataService.getTableHeaderItems();
	
	$scope.testCase = {};
	
	dataService.getTestCase(parseInt($routeParams.id, 10))
		.then(
			function(response) {
				$scope.testCase = response.data;
			}
		);
	
	$scope.deleteTestCase = function() {
		dataService.deleteTestCase(parseInt($routeParams.id, 10))
			.then(function (data) {
				$location.path('/');
			});
	};
});

app.controller('FindController', function($scope, $location, dataService) {

	$scope.tableHeaderItems = dataService.getTableHeaderItems();
	
	$scope.testCase = {};
	
	dataService.getTestCaseByTitle()
		.then(
			function(response) {
				$scope.testCase = response.data;
			}
		);
});