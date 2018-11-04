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

	$("#giayForm").validate({
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
	// $("#btnLuu").click(function () {
	// 	$('#btnThemChiTiet').removeClass('btn-themchitiet');
	// 	$('#btnThemChiTiet').addClass('btn-themchitiet-show');
	// });
	$(".fileinput-upload-button").click(function () {
		$("#RequirementImg").attr({
			hidden: true
		});
	});
	$("#btnLuu").click(function () {

		if (!$("#giayForm").valid() || uploadURL.length == 0) {
			$("#RequirementImg").attr({
				hidden: false
			});
			$("#RequirementImg").addClass("invalid-text");
			console.log("invalid GiayForm");
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
		console.log(data_giay);
		$.ajax({
			url: '/giay',
			type: 'post',
			dataType: 'json',
			contentType: 'application/json',
			success: function (data) {
				console.log('success or errors',data);
			},
			data: JSON.stringify(data_giay)
		});
	});
	$.fn.select2.defaults.set("theme", "bootstrap");
	$("#txtLoaiGiay").select2({
		placeholder: "Chọn loại giày",
		allowClear: true,
		width: "100%"
	});
});