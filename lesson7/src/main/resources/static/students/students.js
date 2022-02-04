angular.module('webapp').controller('studentController', function ($scope, $http, $location) {
    const contextPath = 'http://localhost:8888/webapp/api/v1/students';

    $scope.getStudents = function () {
        $http({
            url: contextPath,
            method: 'GET'
        }).then(function (response) {
            console.log(response)
            $scope.students = response.data.content;
        });
    }

    $scope.deleteProduct = function (studentId) {
        $http({
            url: contextPath + studentId,
            method: 'DELETE'
        }).then(function successCallback(response) {
            $scope.getStudents();
        }, function failureCallback(response) {
            alert(response.data.userMessage);
        });
    }

    $scope.moveToViewStudent = function (studentId) {
        $location.path('/students/' + studentId);
    }

    $scope.getStudents();
});