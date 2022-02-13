angular.module('webapp').controller('studentController', function ($scope, $http, $location, $routeParams, $localStorage) {
    const contextPath = 'http://localhost:8888/webapp/api/v1/students';
    let curStudentId = $routeParams.studentId

    $scope.prepareStudentForView = function () {
        $http.get(contextPath + '/' + curProductId)
            .then(function successCallback (response) {
                console.log(response);
                $scope.view_student = response.data;
            }, function failureCallback (response) {
                alert(response.data.userMessage);
                $location.path('/students');
            });
    }

    $scope.moveToEditProduct = function (productId) {
        $location.path('/edit_student/' + productId);
    }

    $scope.prepareStudentForView();
});