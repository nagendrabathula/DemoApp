/**
  * DATATABLES
 */
$(document).ready(function() {
	
	var username = $("#vaultuserloginid").val();
	alert(username);
	if(username != ""){
	var formData={username:username};
	 $.ajax({        
       type: 'POST',
		cache : false,
       processData : false,
       contentType : false,
       beforeSend: beforeSendHandler,
       data : formData,
       url: '/getnotify?username='+username',
       
       success : function(result) {
			alert(result.msg);
			$("#vaultuserloginid").val(result.msg);
		}
     });
	}
	
});