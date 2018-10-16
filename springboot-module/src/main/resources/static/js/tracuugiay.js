$(document).ready(function() {
	var table = $("#table").DataTable({
		"lengthMenu" : [ [ 10, 20, -1 ], [ "10 dòng", "20 dòng", "Tất cả" ] ],
		"pagingType" : "full_numbers",
		"oLanguage" : {
			"sLengthMenu" : "Hiển thị _MENU_ ",
			"oPaginate" : {
				"sFirst" : "<<",
				"sLast" : ">>",
				"sNext" : ">",
				"sPrevious" : "<"
			},
			"sInfo" : "(_START_/_END_)",
			"sInfoEmpty" : "Không có dữ liệu để hiển thị",
			"sInfoFiltered" : "",
			"sZeroRecords" : "Không tìm thấy"
		}
	});
		
	$.fn.dataTable.ext.search.push(function(settings, data, dataIndex) {
		var min = parseInt($('#txtMinSoLuong').val(), 10);
		var max = parseInt($('#txtMaxSoLuong').val(), 10);
		var soluong = parseFloat(data[6]) || 0; // use data for the age column

		if ((isNaN(min) && isNaN(max)) || (isNaN(min) && soluong <= max)
				|| (min <= soluong && isNaN(max))
				|| (min <= soluong && soluong <= max)) {
			return true;
		}
		return false;
	});
	$('#txtMinSoLuong, #txtMaxSoLuong').keyup( function() {
		table.draw();
    } );
	$('#txtMaGiay').on('keyup', function() {
		table.column(1).search(this.value).draw();
	});
	$('#txtTenGiay').on('keyup', function() {
		table.column(2).search(this.value).draw();
	});
	$('#txtGioiTinh').on('click', function() {
		table.column(3).search(this.value).draw();
	});
	$('.selectpicker').on('change', function() {
		table.column(4).search($('.selectpicker').val()).draw();
	});
	$('#txtNhaSanXuat').on('click', function() {
		table.column(5).search(this.value).draw();
	});

});
