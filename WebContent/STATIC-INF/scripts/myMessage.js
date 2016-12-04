$(function(){	
  //window.open("dialogue.html",window);
  //将卖家头像参数以及发送消息参数追加到对话框地址后
    $.each($(".btn"),function(i,val){
 		$(this).bind("click",function(){
 		var ico_src=$(this).parent().children("img").attr("src");
 		var msg=$(this).parent().children().filter(".message").text();
 		window.location.href=encodeURI("dialogue.html"+"?"+"src="+ico_src+"&msg="+msg);  //打开对话框并将卖家头像和消息传递到对话框页面
 		});
 	});
	$(".btn").hover(function(){
      $(this).removeClass("btn_default").addClass("btn_hover");
    },function(){
      $(this).removeClass("btn_hover").addClass("btn_default");
    });
});


