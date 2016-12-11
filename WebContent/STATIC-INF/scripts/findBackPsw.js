$(function(){
    $("#goback").hover(function(){
        $(this).find("img").attr("src","../images/pwdBack/goback_hover.png");
    },function(){
        $(this).find("img").attr("src","../images/pwdBack/goback.png");

    });

    $("#goback").click(function(){
        window.location.href="../about/login.html";
    });
});


var wait=10;
function time(o) {
        if (wait == 0) {
            o.removeAttribute("disabled");			
            o.value="重新获取验证码";
            wait = 10;
        } else {
            o.setAttribute("disabled", true);
            o.value="重新发送" + wait + "(s)";
            wait--;
            setTimeout(function() {
                time(o)
            },
            1000)
        }
}
document.getElementById("getCode").onclick=function(){time(document.getElementById("resendCode"));}
document.getElementById("resendCode").onclick=function(){time(this);}

function validateAccount(){
    var $parent= $("#username").parent();
    $parent.find(".formTips1").remove();
    var account = $("#username").val();
    if(account==""){
        var errorMsg = "请输入用户名";
        $parent.append('<span class="formTips1">'+errorMsg+'</span>');
        return false;
    }else{
        if(!/.+@.+\.[a-zA-Z]{2,4}$/.test(account)){       
            if(!/^1\d{10}$/.test(account)){               
                var errorMsg="账号格式错误";  
                $parent.append('<span class="formTips1">'+errorMsg+'</span>');
                return false;
            }
        }
    }
    return true;
}

function validatePassword(){                              
    var password=$('#password').val();
    $('form').find(".formTips2").remove();      
    if(password==""){
        var errorMsg="请输入密码";
        $('form').append('<span class="formTips2">'+errorMsg+'</span>');
        return false;
    }
    return true;
}

function validateReInputPsw(){

    var $parent= $("#reInputPsw").parent();
    $parent.find(".formTips5").remove();
    var reInputPsw = $("#reInputPsw").val();
    var password=$('#password').val();
    if(reInputPsw==""){
        var errorMsg = "请重新输入密码";
        $parent.append('<span class="formTips5">'+errorMsg+'</span>');
        return false;
    }else{
        if(reInputPsw!==password){                   
            var errorMsg="请输入相同密码";
            $parent.append('<span class="formTips5">'+errorMsg+'</span>');
            return false;
        }
    }
    return true;
 
   
}

function validateVariCode(){
    var variCode=$('#variCode').val();
    $('form').find(".formTips4").remove();
    if(variCode==""){
        var errorMsg="请输入验证码";
        //$("#resendCode").append('<span class="formTips4">'+errorMsg+'</span>');
        $('form').append('<span class="formTips4">'+errorMsg+'</span>');
        return false;

    }
    return true;
}

$(function(){
    $("#username").blur(function(){
       validateAccount();
    });
    $("#password").blur(function(){
       validatePassword();
    });
    $("#reInputPsw").blur(function(){
       validateReInputPsw();
    });
    $("#variCode").blur(function(){
       validateVariCode();
    });
});


/*$(function(){
    $("#getCode").click(function(){
        $.ajax({
            type:"GET",
            dataType:"json",
            success:function(data,textStatus){
               if(data.code=="200"){
                        window.location.href=encodeURI("../index.html"+"?"+"nickname="+data.nickname);
                }else if(data.code=="203"){
                    //获取到验证码的代码

                } 
            },
            error:function(data){ //请求失败调用
                    alert("error:"+data);
            }
        });     

    });
});*/

function getData() {
    var data = {
        data: 
            [{
                account:$("#username").val(),//向服务器传递用户名密码重新输入的密码及验证码
                password:$("#password").val(),
                variCode:$("#variCode").val()
            }]
    };
    return data;
}

$(function(){
    $("#submit").click(function(){
        if(validateAccount()&&validatePassword()&&validateReInputPsw()&&validateVariCode()){
            $.ajax({
                type:"POST",//请求方式
                url:"../../User/forgetpwd",//发送请求的地址
                contentType: "application/json; charset=utf-8",
                data:JSON.stringify(getData()),//js数据值转成json格式
                dataType:"json",//预期服务器返回的数据类型
                cache:false,//不从浏览器缓存中加载信息
                success:function(data,textStatus){//请求成功调用
                    if(data.code=="200"){
                        window.location.href=encodeURI("../about/login.html"+"?"+"account="+data.nickname);//不是很清楚成功后跳转到哪里
                    }else if(data.code=="205"){
                        $("#maincontainer").find(".failTips").remove();
                        $("#maincontainer").apend('<span class= "failTips">'+data.info+'</span>');

                    } else if(data.code=="207") {
                        alert("用户不存在");
                    }
                },
                error:function(data){ //请求失败调用
                    alert("error:"+data);
                }

            });
        }
    });

});



