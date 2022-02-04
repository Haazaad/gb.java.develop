(function () {
    angular.module('webapp', ['ngRoute', 'ngStorage'])
        .config(config)
        .run(run);

    function config($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'welcome/index.html',
                controller: 'startController'
            })
            .when('/students', {
                templateUrl: 'students/students.html',
                controller: 'studentsController'
            })
            .when('/create_student', {
                templateUrl: 'students/create_student.html',
                controller: 'createStudentController'
            })
            .when('/edit_student/:studentId', {
                templateUrl: 'students/edit_student.html',
                controller: 'editStudentController'
            })
            .when('/students/:studentId', {
                templateUrl: 'students/student.html',
                controller: 'studentController'
            })
            .otherwise({
                redirectTo: '/'
            });
    }

    function run($rootScope, $http, $localStorage) {
    }
})();

angular.module('webapp').controller('indexController', function ($rootScope, $http, $scope, $location, $localStorage) {

});