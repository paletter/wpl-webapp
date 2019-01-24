$(function() {
	window.DateUtils = {
			
		formatDateYMD: function(date) {
			if (!date || date.toString() == 'Invalid Date')
				return '';
			
			var day = date.getDate() < 10 ? '0' + date.getDate() : date.getDate();
			var month = date.getMonth() + 1;
			month = month < 10 ? '0' + month : month;
			return date.getFullYear() + "-" + month + "-" + day;
		},
		
		formatDateYMDTMS: function(date) {
			if (!date || date.toString() == 'Invalid Date')
				return '';
			var day = date.getDate() < 10 ? '0' + date.getDate() : date.getDate();
			var month = date.getMonth() + 1;
			month = month < 10 ? '0' + month : month;
			var hour = date.getHours() < 10 ? '0' + date.getHours() : date.getHours();
			var min = date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes();
			var s = date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds();
			return date.getFullYear() + "-" + month + "-" + day + " " + hour + ":" + min + ":" + s;
		},
		
		initDatepicker: function() {
			$("input[datepicker]").each(function(i, v) {
				$(v).datepicker({
				    format: $(v).attr("format"),
				    todayBtn: "linked",
				    autoclose: true,
				    language: "zh-CN"
				});
			});
		}
	};
})