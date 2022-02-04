angular.module('webapp').controller('createStudentController', function ($scope, $http, $location) {
    const contextPath = 'http://localhost:8888/webapp/api/v1/students';

    $scope.createNewProduct = function () {
        if ($scope.new_student == null) {
            alert("Form is not completed");
            return;
        }
        $http.post(contextPath, $scope.new_student)
            .then(function successCallback(response) {
                alert("Product was successful created.")
                $location.path('/products');
            }, function failureCallback(response) {
                alert(response.data.userMessage);
            });
    };
})