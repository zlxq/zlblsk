ajax({
	method : 'POST',
	url : 'test.php',
	params : {
		name1 : 'value1',
		name2 : 'value2'
	},
	success : function(response) {
		console.log(response);
	}
});