$(document).ready(function () {
	$.fn.select2.defaults.set("theme", "bootstrap");
	$("#txtLoaiGiay").select2({
		placeholder : "",
		allowClear : true,
		width: "100%"
	});
	$("#txtNhaSanXuat").select2({
		placeholder : "",
		allowClear : true,
		width: "100%"
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

	$.fn.dataTable.ext.search.push(function (settings, data, dataIndex) {
		var min = parseInt($('#txtMinSoLuong').val(), 10);
		var max = parseInt($('#txtMaxSoLuong').val(), 10);
		var soluong = parseFloat(data[7]) || 0;

		if ((isNaN(min) && isNaN(max)) || (isNaN(min) && soluong <= max)
			|| (min <= soluong && isNaN(max))
			|| (min <= soluong && soluong <= max)) {
			return true;
		}
		return false;
	});
	$('#txtMinSoLuong, #txtMaxSoLuong').on('keyup',function () {
		table.draw();
	});
	$('#txtMaGiay').on('keyup', function () {
		table.column(1).search(this.value).draw();
	});
	$('#txtTenGiay').on('keyup', function () {
		table.column(2).search(this.value).draw();
	});
	$('#txtGioiTinh').on('click', function () {
		table.column(3).search(this.value).draw();
	});
	$('#txtLoaiGiay').on('change', function() {		
		table.column(4).search(this.value).draw();
	});
	$('#txtNhaSanXuat').on('change', function() {
		table.column(5).search(this.value).draw();
	});
	$('#txtThongKeGiay').on('change',function(){
		if(this.value === '0'){
			$('#txtMinSoLuong').val("");
			$('#txtMaxSoLuong').val("");
		} else if(this.value === '1'){
			$('#txtMaxSoLuong').val(15+1);	
			$('#txtMinSoLuong').val("");		
		} else if(this.value === '2'){
			$('#txtMinSoLuong').val(100+1);
			$('#txtMaxSoLuong').val("");
		} else if(this.value === '3'){
			$('#txtMaxSoLuong').val(100);
			$('#txtMinSoLuong').val(15);
		}
		table.draw();
	});
});