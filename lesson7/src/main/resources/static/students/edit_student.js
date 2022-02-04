angular.module('webapp').controller('editStudentController', function ($scope, $http, $routeParams, $location) {
    const contextPath = 'http://localhost:8888/webapp/api/v1/students';

    $scope.prepareStudentForEdit = function () {
        $http.get(contextPath + '/' + $routeParams.studentId)
            .then(function successCallback (response) {
                console.log(response);
                $scope.updated_student = response.data;
            }, function failureCallback (response) {
                console.log(response);
                alert(response.data.userMessage);
                $location.path('/students');
            });
    }

    $scope.modifyStudent = function () {
        $http.put(contextPath, $scope.updated_student)
            .then(function successCallback(response) {
                $scope.updated_student = null;
                alert("Student was successful edited.")
                $location.path('/students');
            }, function failureCallback(response) {
                alert(response.data.userMessage);
            });
    }

    $scope.prepareStudentForEdit();
})