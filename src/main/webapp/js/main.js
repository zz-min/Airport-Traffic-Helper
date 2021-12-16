$(window).load(function() {
	var a1=$('select[name=checkedAirline] option:selected').text().replace(/^\s+|\s+$/g, '');
	var a2 = $('#checkedDep_date_').val();
	var a3 = $('select[name=checkedOrigin] option:selected').text().replace(/^\s+|\s+$/g, '');
	var a4 = $('select[name=checkedDest] option:selected').text().replace(/^\s+|\s+$/g, '');
	//x = x.replace(/^\s+|\s+$/g, '');// 앞과 뒤의 공백 제거하기

	$("#sBtn").on("click", function() {
		var form = document.createElement('form');
		form.setAttribute('method', 'post');
		form.setAttribute('action', 'https://nud7xaugz5.execute-api.ap-northeast-2.amazonaws.com/inputData');
		document.charset = "utf-8";
		var a1=$('select[name=checkedAirline] option:selected').text().replace(/^\s+|\s+$/g, '');
		var a2=$('#checkedDep_date').val();
		var a3=$('select[name=checkedOrigin] option:selected').text().replace(/^\s+|\s+$/g, '');
		var a4=$('select[name=checkedDest] option:selected').text().replace(/^\s+|\s+$/g, '');
		
		var params=[a1,a2,a3,a4];
		for (var key in params) {
			var hiddenField = document.createElement('input');
			hiddenField.setAttribute('type', 'hidden');
			hiddenField.setAttribute('name', key);
			hiddenField.setAttribute('value', params[key]);
			form.appendChild(hiddenField);
		}
		document.body.appendChild(form);
		form.submit();
	});
	
});