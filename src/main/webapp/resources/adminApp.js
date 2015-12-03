angular.module('adminApp', [ 'ngRoute' ])

.config(function($routeProvider,$locationProvider) {
	
	$routeProvider.when('/upload/', {
		controller : 'UploadController',
		template : '<div></div>'
	}).when('/admin/', {
		controller : 'HomeContentController',
		template : '<div></div>'
	}).when('/userListView/', {
		controller : 'UserListContentController',
		templateUrl : "admin/userListView"
	}).otherwise({
		redirectTo : '/admin/'
	});
	
})

.controller('MainContorller', ['$route', '$routeParams', '$location',
function($scope) {
	
}])

.controller('HomeContentController', function($scope) {
	
})

.controller('UploadController', function($scope,$http) {
    alert("ksdfkhsd");
})

.controller('UserListContentController', function($scope,$http) {
	$http.get('admin/userList').success(function(data, status, headers, config) {
	    $scope.users = data;
	}).error(function(data, status, headers, config) {
	    console.log(data);
	});

	$scope.deleteUser = function(user){
		if(user&&user.id){
			var c = confirm("Do you want to delete User with username : " + user.username);
			if(c){
				$http.get('admin/user/' + user.id + '/delete').success(function(data, status, headers, config) {
					if(angular.isString(data)){
						alert(data);
						return;
					}
					alert(angular.toJson(data));
					$scope.users = data;
				}).error(function(data, status, headers, config) {
					console.log(data);
				});
			}
		}
	}
})

