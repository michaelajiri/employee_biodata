$(document).ready(function () {
    // $('.table .editButton').on('click', function (event) {
    //     event.preventDefault();
    //     var href = $(this).attr('href');
    //     $.get(href, function (employee, status) {
    //         $('#id').val(employee.id);
    //         $('#firstName').val(employee.firstName);
    //         $('#middleName').val(employee.middleName);
    //         $('#lastName').val(employee.lastName);
    //         $('#email').val(employee.email);
    //         $('#username').val(employee.username);
    //         $('#phoneNumber').val(employee.phoneNumber);
    //         $('#address').val(employee.address);
    //         $('#height').val(employee.height);
    //         $('#weight').val(employee.weight);
    //     });
    //     $('#editModal').modal();
    // });
    
    $('.table .deleteButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #deleteId').attr('href', href)
        $('#deleteModal').modal();
    });
});