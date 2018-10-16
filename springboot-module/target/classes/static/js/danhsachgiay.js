$(document).ready(function() {
	
//	$('button[class="delete"]').on('click', function(e) {
//		var $form = $(this).closest('form');
//		e.preventDefault();
//		$('#confirm').modal({
//			backdrop : 'static',
//			keyboard : false
//		}).one('click', '#delete', function(e) {
//			$form.trigger('submit');
//		});
//	});
	$('#table tr').hover(function() {
		$(this).addClass('hover');
	}, function() {
		$(this).removeClass('hover');
	});

	var table = $("#table").DataTable({
		// "columnDefs" : [ {
		// "targets" : [0],
		// "visible" : false,
		// "searchable" : false
		// } ],
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
	$("#table").on('click', '.edit', function(e) {
		e.preventDefault();
		var $row = $(this).closest("tr"), $tds = $row.find("td:nth-child(1)");
		$.each($tds, function() {
			var ID = $(this).text();
			var magiay = $(this).next().text();
			var tengiay = $(this).next().next().text();
			var gioitinh = $(this).next().next().next().text();
			var loaigiay = $(this).next().next().next().next().text();
			console.log(ID + ' ' + magiay + ' ' + tengiay);
		});
	});
	var row_table;
	$("#table").on('click', '.delete', function(e) {
		e.preventDefault();
		var $row = $(this).closest("tr"), $tds = $row.find("td:nth-child(1)");
		$.each($tds, function() {
			var ID = $(this).text();
			var magiay = $(this).next().text();
			var tengiay = $(this).next().next().text();
			var gioitinh = $(this).next().next().next().text();
			var loaigiay = $(this).next().next().next().next().text();
			console.log('del: ' + ID + ' ' + magiay + ' ' + tengiay);
		});
		row_table = $(this).parents('tr');	
	});
	$('.btn-info').on('click',function(){	
		table.row(row_table).remove().draw(false);
	});
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
	$('#txtNhaSanXuat').on('change', function() {
		table.column(5).search(this.value).draw();
	});
});
