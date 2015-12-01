angular.module('userApp', [ 'ngRoute' ])

.config(function($routeProvider,$locationProvider) {
	
	$routeProvider.when('/user/', {
		controller : 'HomeContentController',
		template : '<div></div>'
	}).when('/addSensorView/', {
		controller : 'AddSensorViewController',
		templateUrl : "user/addSensorView"
	}).when('/sensorListView/', {
		controller : 'SensorListViewController',
		templateUrl : "user/sensorListView"
	}).when('/sensorDataListView/:sensorId', {
		controller : 'SensorDataListViewController',
		templateUrl : "user/sensorDataListView"
	}).otherwise({
		redirectTo : '/user/'
	});
	
})

.controller('AddSensorViewController', function($scope,$http,$location) {

	$scope.sensor = {};

	$scope.addSensor = function(){
		if($scope.sensor.sensorName){
			$http.post('user/sensor/',$scope.sensor.sensorName ).success(function(data, status, headers, config) {
				$location.path("/sensorListView/");
			}).error(function(data, status, headers, config) {
				console.log(data);
			});
		}
	}

})

.controller('SensorListViewController', function($scope,$http,$location) {

	$http.get('user/sensor').success(function(data, status, headers, config) {
		$scope.sensors = data;
	}).error(function(data, status, headers, config) {
		console.log(data);
	});

	$scope.deleteSensor = function(sensor){
		if(!sensor){
			return;
		}
		var c = confirm("Do you need to delete sensor with sensor id : " + sensor.id);
		if(c){
			$http.get('user/sensor/' + sensor.id + "/delete").success(function(data, status, headers, config) {
				$scope.sensors = data;
			}).error(function(data, status, headers, config) {
				console.log(data);
			});
		}
	}

	$scope.viewData = function(sensor){
		if(!sensor){
			return;
		}
		$location.path('/sensorDataListView/' + sensor.id);
	}

	$scope.stopSensor = function(sensor){
		alert(sensor.id);
	}

})

.controller('SensorDataListViewController', function($scope,$routeParams,$http) {

	$scope.params = $routeParams;

	$http.get('user/sensor/' + $scope.params.sensorId + '/data').success(function(data, status, headers, config) {
		$scope.sensorData = data;
	}).error(function(data, status, headers, config) {
		console.log(data);
	});

})

.controller('HomeContentController', function($scope) {
	
})


.controller('MainContorller', function($scope,$http) {

})

