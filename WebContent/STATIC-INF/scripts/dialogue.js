$(function(){
	
	//返回按钮鼠标悬浮效果
	$("#goback").hover(function(){
        $(this).find("img").attr("src","../../../images/self/message/goback_hover.png");
	},function(){
		$(this).find("img").attr("src","../../../images/self/message/goback.png");
	});
	//发送消息按钮鼠标悬浮效果
	$("#send").hover(function(){
        $(this).find("img").attr("src","../../../images/self/message/sendout_hover.png");
	},function(){
		$(this).find("img").attr("src","../../../images/self/message/sendout.png");
	});
});
//设置卖家头像以及发送的消息
$(function(){
    var url=decodeURI(location.href);
    var tmp1=url.split("?")[1];
    var tmp2=tmp1.split("&")[0];
    var tmp3=tmp1.split("&")[1];
    var ico_src=tmp2.split("=")[1];
    var msg=tmp3.split("=")[1];   
    setDialogSize(msg.length);
    $(".dialog").find("img").attr("src", "../" + ico_src);
    $(".dialog").find("p").text(msg);
});
//设置消息背景图片基本适应文字长度
function setDialogSize(textSize){
    if(textSize<14){
    	$(".msg").css({width:'150px',height:'50px'});
    	$(".info").removeClass("info_normal").addClass("info_small");
    	$(".info").css({left:'26px',top:'10px'});
    	if(textSize<10)  $(".info").css('top','16px');
    }
    if(textSize>26&&textSize<35){
    	$(".msg").css({width:'260px',height:'70px'});
    	$(".info").removeClass("info_normal").addClass("info_big");
        $(".info").css({left:'36px',top:'16px'});
    } 
    if(textSize>=35&&textSize<57){
        $(".msg").css({width:'260px',height:'80px'});
    	$(".info").removeClass("info_normal").addClass("info_big");
    	$(".info").css({left:'36px',top:'16px'});
	}
    if(textSize>=57){
    	$(".msg").css({width:'350px',height:'80px'});
    	$(".info").removeClass("info_normal").addClass("info_xbig");
        $(".info").css({left:'40px',top:'16px'});
        if(textSize>=88)    $(".info").css('top','10px');
    }

}