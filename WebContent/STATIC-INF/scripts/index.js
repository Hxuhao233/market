//设置页面的瀑布流效果
$(function(){
	var box=$(".box");
	var boxWidth=box.eq(0).innerWidth();
	var num=Math.floor($("#warefList").width()/boxWidth);     //获取一行最多能放置的box的个数
	var boxArr=[];
	box.each(function(index,value){
		var boxHeight=box.eq(index).innerHeight();           //获取对应下标的box的高度
		if(index<num){
			boxArr[index]=boxHeight;
		}else{
            var minboxHeight=Math.min.apply(null,boxArr);      //获取最小高度
            var minboxIndex=$.inArray(minboxHeight,boxArr);    //获取最小高度对应的列下标
            $(value).css({
            	"position":"absolute",
            	"top":minboxHeight,
            	"left":box.eq(minboxIndex).position().left
            });
            boxArr[minboxIndex]+=box.eq(index).innerHeight();  //更新所在列的高度
		}
	});
});

//设置遮罩层的样式
$(function(){
   var detail=$(".detail");
   detail.each(function(index,value){
      var parentHeight=$(value).parent().height();
      var top1=parseInt(parentHeight*0.1);      //获取商品信息位于遮罩层的位置
      var top2=parseInt(parentHeight*0.8);      //获取卖家信息位于遮罩层的位置
      $(this).css("height",parentHeight);
      $(this).children().filter(".introscr").css("top",top1);
      $(this).children().filter(".sellerInfo").css("top",top2);
   });
});
//设置遮罩层的鼠标悬浮效果
$(function(){
	var mdpho=$(".mdpho");
	mdpho.each(function(index,value){
       $(value).hover(function(){
       	$(this).find(".detail").css("visibility","visible");
       },function(){
        $(this).find(".detail").css("visibility","hidden");
       });
	});
});
//设置查看详情按钮的悬浮效果
$(function(){
	$(".seeDetail").each(function(index,value){
        $(this).hover(function(){
        	$(this).find("img").attr("src","images/main/see_hover.png");
        },function(){
        	$(this).find("img").attr("src","images/main/see.png");
        });
        $(this).click(function(){
           window.location.href="about/details.html";
           //添加与后端交互的事件
        });
	});
});
//设置顶部浮动栏的浮动效果
$(function(){
	$(window).scroll(function(){
       var scrollTop=$(document).scrollTop();
       if(scrollTop<500){
    	   $("#topNavBar").hide();
        }else{
    	   $("#topNavBar").show();
        }
   });
});
//设置侧边浮动栏的效果
$(function(){
	$("input[name='sortStyle'][value='synsort']").attr("checked",true)
	   .parent().removeClass("li_default").addClass("li_click");          //页面加载完成时默认选中综合排序按钮
	var choice=$("input[name='sortStyle']");
    choice.each(function(index,val){
       $(this).click(function(){
            if($(this).is(":checked")){ 
               // alert($("input[type='radio']:checked").val());
        	    $(this).parent().removeClass("li_default").addClass("li_click")    //设置选中按钮的样式
        	   .parent().siblings().children().removeClass("li_click").addClass("li_default");   //设置其他未选中按钮的样式
        	//继续添加与后端交互的动作
            }
        });
    });
});
//设置分类展示框的效果
$(function(){
    $("#classifyTitle>p").hover(function(){
        $(this).prev().attr("src","images/main/doubleArrow_hover.png");
        $("#classifyContent").css("visibility","visible");
    },function(){
    	setTimeout(function(){                                         //延时100毫秒再执行判断
    		if(!$("#classifyContent").hasClass('hover')){
                $("#classifyTitle>img").attr("src","images/main/doubleArrow.png");
                $("#classifyContent").css("visibility","hidden");
              }
        },100);
    });
    $("#classifyContent").hover(function(){
         $(this).addClass("hover");
         $(this).css("visibility","visible");
    },function(){
         $(this).removeClass("hover");
         $(this).css("visibility","hidden");
        $("#classifyTitle>img").attr("src","images/main/doubleArrow.png");
    });
});
//设置图片轮播效果
var sWidth=$("#focus").width();
var len=$("#focus ul li").length;
var index=0;
var picTimer=null;
$(function(){                                               
    $("#focus ul").css("width",sWidth*(len+1));
    $("#focus").mouseenter(function(){                           //鼠标滑上焦点图时停止自动播放，滑出时开始自动播放
    	if(picTimer){
    	clearTimeout(picTimer);
        }
    }).mouseleave(function(){
         takeTurns();
    }).triggerHandler("mouseleave");
    $('#focus').hover(function(){                               //图片鼠标滑过
    	$('#focus .preNext').animate({opacity:'0.7'},500);
    },function(){
    	$('#focus .preNext').animate({opacity:'0'},500);
    });
    $('#focus .pre').click(function(){                         //上一页按钮
    	if(index==-1){index=len-1;}
    	showPics(index);
    	index--;
    });
    $('#focus .next').click(function(){                       //下一页按钮
        if(index==len){
        	index=0;
        	showFirstPic();
        }else{
        	showPics(index);
        }
        index++;
    });
});
function takeTurns(){                                          //设置轮播事件
    if(index==len){
        index=0;
        showFirstPic();
    }else{
        showPics(index);
    }
    index++;
    picTimer=setTimeout("takeTurns()",3000);
}
function showPics(index){                                       //显示图片函数
    var nowLeft=-index*sWidth;
    $("#focus ul").stop(true,false).animate({"left":nowLeft},500);
}
function showFirstPic(){                                       //最后一张图片切换到第一张图片时调用
    $("#focus ul").append($("#focus ul li:first").clone());    //为了达到从最右边到最左边还是往左移动效果，而不是往右移动 
    var nowLeft=-len*sWidth;                                   //通过li元素个数计算ul元素的left值，也就是最后一个li元素的右边 
    $("#focus ul").stop(true,false).animate({"left":nowLeft},500,function(){      
    //通过callback，在动画结束后把ul元素重新定位到起点，然后删除最后一个复制过去的元素  
    $("#focus ul").css("left","0");
    $("#focus ul li:last").remove();
    });
}
//实现收藏与点赞功能
$(function(){
  var collbtn=$(".collbtn");
  var laudbtn=$(".laudbtn");
  collbtn.each(function(index,value){       
    $(this).toggle(function(){                             //点击收藏
      $(this).find("img").attr("src","images/main/collbtn_click.png");
      var p=$(this).find("p");
      var count=addOne(p.text());
      p.text(count);
      //继续添加与后端交互的事件
    },function(){                                           //取消收藏
      $(this).find("img").attr("src","images/main/collbtn.png");
      var p=$(this).find("p");
      var count=lowerOne(p.text());
      p.text(count);
      //继续添加与后端交互的事件
    });
  });
  laudbtn.each(function(index,value){
    $(this).toggle(function(){                              //给商品点赞
      $(this).find("img").attr("src","images/main/laudbtn_click.png");
      var p=$(this).find("p");
      var count=addOne(p.text());
      p.text(count);
      //继续添加与后端交互的事件
    },function(){                                          //取消点赞
      $(this).find("img").attr("src","images/main/laudbtn.png");
      var p=$(this).find("p");
      var count=lowerOne(p.text());
      p.text(count);
      //继续添加与后端交互的事件
    });
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