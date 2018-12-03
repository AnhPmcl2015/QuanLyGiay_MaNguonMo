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

    $http({
        method: 'GET',
        url: '/get-list-gioitinh'
    }).then(function (response) {
        if (response) {
            $scope.GioiTinh = response.data;
        }
    }, function (error) {

    });
});
$(document).ready(function () {

    var validator = $("#giayForm").validate({
        onclick: false,
        errorElement: "span",
        errorClass: "invalid-control",
        validClass: 'valid-control',
        highlight: function (element, errorClass, validClass) {
            $(element).addClass(errorClass).removeClass(validClass);

        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).removeClass(errorClass).addClass(validClass);

        },
        errorPlacement: function (error, element) {
            if (element.parent('.input-group').length) {
                error.insertAfter(element.parent());
            } else if (element.hasClass('select2')) {
                error.insertAfter(element.next('span'));
            } else {
                error.insertAfter(element);
            }
        },
        rules: {
            txtMaGiay: {
                required: true,
                maxlength: 50
            },
            txtTenGiay: {
                required: true,
                maxlength: 50
            },
            txtLoaiGiay: {
                required: true
            },
            txtGiaBan: {
                required: true,
                digits: true
            },
            txtGhiChu: {
                maxlength: 186
            },
            txtGioiTinh: {
                required: true
            }

        },
        messages: {
            txtMaGiay: {
                required: "Yêu cầu nhập mã giày",
                maxlength: "Nhập tối đa 50 ký tự"
            },
            txtTenGiay: {
                required: "Yêu cầu nhập tên giày",
                minlength: "Nhập tối đa 50 ký tự"
            },
            txtLoaiGiay: {
                required: "Yêu cầu chọn loại giày"
            },
            txtGiaBan: {
                required: 'Yêu cầu nhập giá bán',
                digits: 'Chỉ được nhập số'
            },
            txtGhiChu: {
                maxlength: 'Nhập tối đa 186 kí tự'
            },
            txtGioiTinh: {
                required: 'Yêu cầu chọn giới tính'
            }
        }
    });
    $('#txtLoaiGiay').on('change', function () {
        $(this).valid();
    });

    $('#addbtn').click(function (e) {
        var newitem = $('#add').val();
        if (newitem === '' || newitem === null) {
            return false;
        }
        var uniqid = Math.round(new Date().getTime() + (Math.random() * 100));
        $('#list').append('<div id="' + uniqid + '" style="margin-top: 5px;"><input type="text" class="form-control" style="width: 60%; float:left;" name ="listSize[]"value ="' + newitem + '"/><input type="hidden" name="listed[]" value="' + newitem + '"/>&nbsp;<button data-id="' + uniqid + '" class="btn btn-light listelement"><i class="fas fa-trash-alt"></i></button></div>');
        $('#add').val('');
        return false;
    });
    $('#list').delegate(".listelement", "click", function () {
        var elemid = $(this).attr('data-id');
        $("#" + elemid).remove();
    });
    $(".fileinput-upload-button").click(function () {
        $("#RequirementImg").attr({
            hidden: true
        });
    });

    function resetForm() {
        validator.resetForm();
        $('#txtLoaiGiay').val(1).trigger('change.select2');
        $("#divAlert").attr('hidden', 'true');
        $("#txtMaGiay").val('');
        $("#txtTenGiay").val('');
        $("#txtGhiChu").val('');
        $("#txtGiaBan").val('');
        $("#RequirementImg").attr({
            hidden: true
        });
    }

    $("#btnReset").click(function () {
        resetForm();
    });
    $("#btnLuu").click(function () {
        if (!$("#giayForm").valid() || uploadURL.length == 0 || uploadURL.length > 4) {
            $("#RequirementImg").attr({
                hidden: false
            });
            $("#RequirementImg").addClass("invalid-text");
            return;
        }

        var data_giay = {
            "maGiay": $("#txtMaGiay").val().trim(),
            "tenGiay": $("#txtTenGiay").val().trim(),
            "id_gioi_tinh": $("#txtGioiTinh").val().trim(),
            "id_loai_giay": $("#txtLoaiGiay").val().trim(),
            "ghiChu": $("#txtGhiChu").val().trim(),
            "giaBan": $("#txtGiaBan").val().trim(),
            "img1": uploadURL[0],
            "img2": uploadURL[1],
            "img3": uploadURL[2],
            "img4": uploadURL[3]
        };
        var json = JSON.stringify(data_giay);
        $.ajax({
            url: '/giay',
            type: 'post',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data) {
                resetForm();
                alertify.success('Thêm thành công');
            },
            data: json,
            error: function (data, textStatus, errorThrown) {
                console.log('errors', data.responseJSON);
                if (data.responseJSON.status === 'unique') {
                    alertify.warning('Đã tồn tại mã giày');
                } else {
                    alertify.error('Thêm thất bại');
                }

            }
        });
    });

    $.fn.select2.defaults.set("theme", "bootstrap");
    $("#txtLoaiGiay").select2({
        width: "100%",
        allowClear: true,
        placeholder: 'Chọn loại giày'
    });
});