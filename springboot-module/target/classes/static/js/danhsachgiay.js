var app = angular.module('myApp', ['angular.filter']);
app.controller('myCtrl', function ($scope, $http) {
    $http({
        method: 'GET',
        url: '/get-list-loaigiay'
    }).then(function (response) {
        if (response) {
            $scope.LoaiGiay = response.data;
        }
    }, function (error) {

    });
});
$(document).ready(function () {
    $.fn.select2.defaults.set("theme", "bootstrap");
    $("#txtLoaiGiay").select2({
        placeholder: "",
        allowClear: true,
        width: "100%"
    });
    $("#txtNhaSanXuat").select2({
        placeholder: "",
        allowClear: true,
        width: "100%"
    });
    $('#table tr').hover(function () {
        $(this).addClass('hover');
    }, function () {
        $(this).removeClass('hover');
    });

    var table = $("#table").DataTable({
        "lengthMenu": [[10, 20, -1], ["10 dòng", "20 dòng", "Tất cả"]],
        "pagingType": "full_numbers",
        "oLanguage": {
            "sLengthMenu": "Hiển thị _MENU_ ",
            "oPaginate": {
                "sFirst": "<<",
                "sLast": ">>",
                "sNext": ">",
                "sPrevious": "<"
            },
            "sInfo": "(_START_/_END_)",
            "sInfoEmpty": "Không có dữ liệu để hiển thị",
            "sInfoFiltered": "",
            "sZeroRecords": "Không tìm thấy"
        }
    });
    $("#table").on('click', '.edit', function (e) {
        e.preventDefault();
        var $row = $(this).closest("tr"), $tds = $row.find("td:nth-child(1)");
        console.log($row.children(".data-id").data("id"));
        $.each($tds, function () {
            var magiay = $(this).children(".data-id").data("id");

            console.log(text_magiay + ' ' + magiay + ' ' + tengiay);
        });
    });
    var row_table, magiay;
    $("#table").on('click', '.delete', function (e) {
        e.preventDefault();
        var $row = $(this).closest("tr"), $tds = $row.find("td:nth-child(1)");
        $.each($tds, function () {
            magiay = $(this).children(".data-id").data("id");
        });
        row_table = $(this).parents('tr');
    });
    $('.btn-info').on('click', function () {
        var json = {
            id: magiay
        };
        $.ajax({
            url: '/delete-giay',
            type: 'post',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data) {
                table.row(row_table).remove().draw(false);
                alertify.success('Xóa thành công');
            },
            data: JSON.stringify(json),
            error: function (data, textStatus, errorThrown) {
                alertify.error('Xóa thất bại');
            }
        });

    });
    $('#txtMaGiay').on('keyup', function () {
        table.column(1).search(this.value).draw();
    });
    $('#txtTenGiay').on('keyup', function () {
        table.column(1).search(this.value).draw();
    });
    $('#txtGioiTinh').on('click', function () {
        table.column(2).search(this.value).draw();
    });
    $('#txtLoaiGiay').on('change', function () {
        table.column(3).search(this.value).draw();
    });
    $('#txtNhaSanXuat').on('change', function () {
        table.column(4).search(this.value).draw();
    });
});
