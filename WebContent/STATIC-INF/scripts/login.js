$(function(){
    $("#goback").hover(function(){                //为返回按钮添加鼠标悬浮效果
      $(this).find("img").attr("src","../images/登录/goback_hover.png");
    },function(){
      $(this).find("img").attr("src","../images/登录/goback.png");
    });
    $('#goback').click(function(){                //点击返回首页
        window.location.href="../index.html";
    });
});

function getData() {
    var data = {
        data: [{
            account: $("#username").val(),
            password: $("#password").val()
        }]
    };
    return data;
}

function getJsonData(data) {
    var jsonData = data;
    var dataKey = jsonData.data;
    var dataInfo = jsonData.info;
    var dataCode = jsonData.code;

    for(var i=0; i<dataKey.length; i++) {
        console.log("code:" + dataCode + " info:" + dataInfo + " name:" + dataKey[i].name);
    }
}

$(function(){
    $("#submit").click(function(){
        if(validateAccount()&&validatePassword()){               //判断账号是否合法
        $.ajax({                                                 //使用post方法向服务器传送json字符串
            type:"POST",
            url:"http://192.168.1.174:8080/market/User/login",
            contentType:"application/json;charset=utf-8",
            data:JSON.stringify(getData()),
            dataType:"json",
            cache:false,
            success:function(data){              //请求成功后的返回函数
            var jsonData = data;
            var dataKey = jsonData.data;
            var dataInfo = jsonData.info;
            var dataCode = jsonData.code;

             if(dataCode=="200"){
             //   alert(data.info);
                window.location.href=encodeURI("self.html"+"?"+"account="+dataKey[0].name);  //登录成功时默认返回首页并向首页传送用户昵称
             }else if(dataCode=="203"){
              //  alert("success");
                $("#maincontainer").find(".failTips").remove();      //将以前的提醒元素删除
                $("#maincontainer").append('<span class="failTips">' + dataInfo + '</span>');     //登录失败时向用户显示错误信息
             }
            },
            error:function(data){                          //请求失败时调用此函数
                alert("error:" + data);
            }
        });
       }
    });
});
//一旦输入框失去焦点便验证用户输入信息
$(function(){
    $("#username").blur(function(){
       validateAccount();
    });
    $("#password").blur(function(){
       validatePassword();
    });
});
function validateAccount(){
    var $parent=$("#username").parent();
    $parent.find(".formTips1").remove();                    //将以前的提醒元素删除
    var account=$("#username").val();
    if(account==""){
        var errorMsg="请输入用户名";                      //判断账号是否为空
        $parent.append('<span class="formTips1">'+errorMsg+'</span>');
        return false;
    }else{
        if(!/.+@.+\.[a-zA-Z]{2,4}$/.test(account)){       //判断是否为合法邮箱
            if(!/^1\d{10}$/.test(account)){               //判断是否为合法手机号码
                var errorMsg="账号格式错误";  
                $parent.append('<span class="formTips1">'+errorMsg+'</span>');
                return false;
            }
        }
    }
    return true;
}
function validatePassword(){                              //判断密码是否为空（不知道密码长度要求，所以没有判断长度）
    var password=$('#password').val();
    $('form').find(".formTips2").remove();      
    if(password==""){
        var errorMsg="请输入密码";
        $('form').append('<span class="formTips2">'+errorMsg+'</span>');
        return false;
    }
    return true;
}