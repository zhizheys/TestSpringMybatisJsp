$(function(){
	var urlBase=$("#urlBase").val();
	
	$("#btnSubmit").click(function(){
		
		var userId=$("#userId").val();
		
		$.ajax({
			url:urlBase+"/user/userinfo",
			type:"get",
			datatype:"json",
			data:{"id":userId},
			success:function(data){
				$("#userInfoDiv").text(data);
			},
			error:function(){
				alert("get user Id error");
			}
			
		});
		
	});
	
	
	$("#btnAddUser").click(function(){
		
		var userName=$("#userName").val();
		var userAge=$("#userAge").val();
		var userAddress=$("#userAddress").val();
		var userPassword=$("#userPassword").val();
		var userBirthday=$("#userBirthday").val();

		$.ajax({
			url:urlBase+"/user/addusertwo",
			type:"post",
			datatype:"json",
			data:{"userName":userName,"userAge":userAge,"userAddress":userAddress,"userPassword":userPassword,"userBirthday":userBirthday},
			success:function(data){
				$("#userIdDiv").text(data);
			},
			error:function(){
				alert("get user Id error");
			}
			
		});
		
	});
	
})
