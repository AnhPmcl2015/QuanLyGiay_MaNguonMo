var app = angular.module('myApp', [ 'angular.filter' ]);
app.controller('myCtrl', function($scope) {
	$scope.Farm = [ {
		"Type" : "Flower",
		"NSX" : "Group1",
		"Hu" : "123"
	}, {
		"Type" : "Apple",
		"NSX" : "Group1",
		"Hu" : "456"
	}, {
		"Type" : "Grape",
		"NSX" : "Group1",
		"Hu" : "789"
	}, {
		"Type" : "Orange",
		"NSX" : "Group2",
		"Hu" : "ghj"
	} ];
});
$(document).ready(function(){
	$('#addbtn').click(function(e){		
		var newitem = $('#add').val();
		if(newitem === '' || newitem===null){
			return false;
		}
		var uniqid = Math.round(new Date().getTime() + (Math.random() * 100));
		$('#list').append('<div id="'+uniqid+'"><input type="text" name ="listSize[]"value ="'+newitem+'"/><input type="hidden" name="listed[]" value="'+newitem+'"/><button data-id="'+uniqid+'" class="listelement"><i class="fas fa-trash-alt"></i></button></div>');
		$('#add').val('');
		return false;
	});
    $('#list').delegate(".listelement", "click", function() {
		var elemid = $(this).attr('data-id');
		$("#"+elemid).remove();
    });
//    $("#btnLuu").click(function(){
//        $('#btnThemChiTiet').removeClass('btn-themchitiet');
//        $('#btnThemChiTiet').addClass('btn-themchitiet-show');
//     });
    $.fn.select2.defaults.set("theme", "bootstrap");
    $("#txtLoaiGiay").select2({
        placeholder: "Chọn loại giày",
        allowClear: true,
        maximumSelectionLength: 4
    });
});
