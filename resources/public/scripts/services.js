app.service('dataService', function($location, $http) {
	var tableHeaderItems = [
		'id',
		'Title',
		'Desctiption',
		'Owner',
		'Priority',
		'Location',
		'Status',
		'Steps',
		'Expected results',
		'Assigned to',
		'Version',
		'',
		''
	];

	var baseUrl = $location.protocol() + "://" + $location.host() + ":" + $location.port();
	
	this.getTableHeaderItems = function() {
		return tableHeaderItems;
	};
	
	this.getTestCases = function(startWith, count) {
		return $http.get(baseUrl+"/api/v1/testcases/range/"+startWith+"/"+count);
	};
	
	this.getTestCaseCount = function() {
		return $http.get(baseUrl+"/api/v1/testcases/count");
	};
	
	this.createNewTestCase = function(testCase) {
		return $http.post(baseUrl+"/api/v1/testcases", testCase);
	};
	
	this.getTestCase = function(id) {
		return $http.get(baseUrl+"/api/v1/testcases/byid/"+id);
	};
	
	this.editTestCase = function(testCase) {
		return $http.put(baseUrl+"/api/v1/testcases", testCase);
	};
	
	this.deleteTestCase = function(id) {
		return $http.delete(baseUrl+"/api/v1/testcases/"+id);
	};
	
	this.findingTitle = "";
	
	this.getTestCaseByTitle = function() {
		return $http.post(baseUrl+"/api/v1/testcases/bytitle", this.findingTitle, {headers: {'X-HTTP-Method-Override' : "GET"}});
	};
});