	function getData() {
	var data = {			
		name: $("input[name='nickName']").val(),
		universityid: $("select[name='school']").val(),
		password: $("input[name='password']").val(),
		account: $("input[name='contactInfo']").val()
	};
		return data;
	}

	function validAccount() {
		var account = $("input[name='contactInfo']").val();
		if(account == ""){
			$("#account").html("手机号码/邮箱<span class='highlighted'>&nbsp&nbsp不可为空</span>");
		$("#account .highlighted").animate({opacity: '1'}, "normal");
		$("#account .highlighted").animate({opacity: '1'}, 3000);
		$("#account .highlighted").animate({opacity: '0'}, "normal");
        return false;
    } else {
        if(!/.+@.+\.[a-zA-Z]{2,4}$/.test(account)) {
            if(!/^1\d{10}$/.test(account)) {
	 			$("#account").html("手机号码/邮箱<span class='highlighted'>&nbsp&nbsp格式错误</span>");
				$("#account .highlighted").animate({opacity: '1'}, "normal");
				$("#account .highlighted").animate({opacity: '1'}, 3000);
				$("#account .highlighted").animate({opacity: '0'}, "normal");
	            return false;
            }
        }
    }
	
	$("#account").html("手机号码/邮箱");
    return true;
	}

	function validPwd() {
	var pwd1 = $("input[name='password']").val();
	var pwd2 = $("input[name='passwordConfirm']").val();
	if (pwd1 == "") {
		$("#password").html("密码<span class='highlighted'>&nbsp&nbsp不可为空</span>");
		$("#password .highlighted").animate({opacity: '1'}, "normal");
		$("#password .highlighted").animate({opacity: '1'}, 3000);
		$("#password .highlighted").animate({opacity: '0'}, "normal");
		return false;				
	} else {
		if (pwd1 != pwd2) {
			console.log(pwd1 + " != " + pwd2);
			$("#pwdConfirm").html("确认密码<span class='highlighted'>&nbsp&nbsp两次密码不相同</span>");
			$("#pwdConfirm .highlighted").animate({opacity: '1'}, "normal");
			$("#pwdConfirm .highlighted").animate({opacity: '1'}, 3000);
			$("#pwdConfirm .highlighted").animate({opacity: '0'}, "normal");
			return false;
		} else {
			$("#pwdConfirm").html("确认密码");
			return true;
		}			
	} 

	return true;
	}

function register() {
	if (validPwd() && validAccount()) {
    	$.ajax({
			type: "POST",
			contentType: "application/json; charset=utf-8",
			url: "http://115.28.158.106:8080/market/User/signup",
    		data: JSON.stringify(getData()),
    		dataType: "json",
    		success: function(message) {
    			//window.location.href = "../index.html";
    			console.log(message.code);
    			if (message.code == "200") {
    				window.location.href = "about/register_html/register_Success.html?account=" + $("input[name='contactInfo']").val();
    			} else if (message.code == "406") {
    				alert("手机号/邮箱: " + $("input[name='contactInfo']").val() + "已注册");
    			} else {
    				alert("发生错误，稍后重试!");
    			}
    			console.log("Success" + message);
    		},
    		error: function(err) {
    			console.log("Error" + err);
    		}
    	});
	}
}

function clearInputs() {
	$("#register_Form :input").each(function() {
		$(this).val('');
	});
}

$('Document').ready(function(){
	$("input[name='passwordConfirm']").blur(function() {
		validPwd();
	});

	$("input[name='password']").blur(function() {
		validPwd();
	});

	$("input[name='contactInfo']").blur(function() {
		validAccount();
	});

	$("#back_Btn").find('img').mouseover(function(){
		$(this).rotate({
			animateTo: 90
		});
	}).mouseout(function(){
		$(this).rotate({
			animateTo: 0
		});
	});

	$("input, select").mouseover(function() {
			$(this).addClass('hover');
		}).mouseout(function() {
			$(this).removeClass('hover');
	});

	$("#register_Btn").mouseover(function() {
		$(this).addClass('hover');
	}).mouseout(function() {
		$(this).removeClass('hover');
	});
});