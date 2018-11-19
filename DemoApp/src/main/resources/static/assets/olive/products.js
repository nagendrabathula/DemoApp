$(document).ready(function() {
	alert("Hi");
	var table = $('table#products').DataTable({
		'ajax' : '/data/products',
		'serverSide' : true,
		columns : [ {
			data : 'id'
		}, {
			data : 'name'
		}, {
			data : 'description'
		} ]
	});
	$("button#txnsearchbutton").click(function() {
		var txnid = $("#txnid").val();
		var refid = $("#refid").val();
		
	var table = $('table#tranlog').DataTable({
		'ajax' : '/data/transactions?txnid='+txnid+"&refid="+refid,
		'serverSide' : true,
		columns : [ {
			data : 'stan'
		}, {
			data : 'rrn'
		}, {
			data : 'RC'
		} ]
	});
	});
	$("button#exportbutton").click(function(){
		var txnid = $("#txnid").val();
		  
	   window.location ="/txntimeline/export?txnid="+txnid;
	});
	$('select#role_selector').change(function() {
		var filter = '';
		$('select#role_selector option:selected').each(function() {
			filter += $(this).text() + "+";
		});
		filter = filter.substring(0, filter.length - 1);
		table.columns(2).search(filter).draw();
	});

	$('select#status_selector').change(function() {
		var filter = '';
		$('select#status_selector option:selected').each(function() {
			filter += $(this).text() + "+";
		});
		filter = filter.substring(0, filter.length - 1);
		table.columns(3).search(filter).draw();
	});
	
   $("#btnSearch").click(function(){
     //  table.columns(2).search('ADMIN'); 
      // table.columns(3).search('ACTIVE').draw();
       table.column(4).search('town0').draw();
    }); 
   
  
});