$(function(){
    $("#goback").hover(function(){                           //设置返回按钮的鼠标悬浮效果
       $(this).find("img").attr("src","../images/details/goback_hover.png");
    },function(){
       $(this).find("img").attr("src","../images/details/goback.png"); 
    });
    $(".chatBtn a").click(function(){                        //打开聊天框
    	$("#chatFrame").css("visibility","visible");
    });
    $("#send").hover(function(){                            //设置发送信息按钮的鼠标悬浮效果
    	$(this).find("img").attr("src","../images/details/sendout_hover.png");
    },function(){
    	$(this).find("img").attr("src","../images/details/sendout.png");
    });                                          
    $(".close").click(function(){                           //关闭聊天框
    	$("#chatFrame").css("visibility","hidden");
    });
    $("#rightTit a").click(function(){                     //点击增加评论
        $("#state1").css("visibility","visible");
    });
    $("#inputcnd").focus(function(){                      //设置评论输入区域的动态
    	$("#state1").css("visibility","hidden");
        $("#state2").css("visibility","visible");
        $("#input_focus").focus();
    });
    $("#cancel1").click(function(){                      //取消评论
    	$("#state1").css("visibility","hidden");
    })
    $("#cancel2").click(function(){                      //取消评论
    	$("#state2").css("visibility","hidden");
    });
    $("#announce").hover(function(){                     //设置发送评论按钮的鼠标悬浮效果
    	$(this).find("img").attr("src","../images/details/say_hover.png");
    },function(){
    	$(this).find("img").attr("src","../images/details/say.png");
    });
});
$(function(){
    $(".collbtn").toggle(function(){                             //点击收藏
        $(this).find("img").attr("src","../images/details/collbtn_click.png");
        var p=$(".collnum");
        var count=addOne(p.text());
        p.text(count);
        //继续添加与后端交互的事件
    },function(){                                           //取消收藏
        $(this).find("img").attr("src","../images/details/collbtn.png");
        var p=$(".collnum");
        var count=lowerOne(p.text());
        p.text(count);
        //继续添加与后端交互的事件
    });
     $(".laudbtn").toggle(function(){                              //给商品点赞
        $(this).find("img").attr("src","../images/details/laudbtn_click.png");
        var p=$(".laudnum");
        var count=addOne(p.text());
        p.text(count);
        //继续添加与后端交互的事件
    },function(){                                          //取消点赞
        $(this).find("img").attr("src","../images/details/laudbtn.png");
        var p=$(".laudnum");
        var count=lowerOne(p.text());
        p.text(count);
        //继续添加与后端交互的事件
    });
    function addOne(text){                 //给人数加1       
       var num=parseInt(text);
       num=num+1;
       return num;
    }
    function lowerOne(text){                //给人数减1
       var num=parseInt(text);
       num=num-1;
       return num;
    }
});