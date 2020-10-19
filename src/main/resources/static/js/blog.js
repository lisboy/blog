window.onload=function(){
    var oDiv=document.getElementById('div1');
    var oUl=oDiv.getElementsByTagName('ul')[0];
    var aLi=oUl.getElementsByTagName('li');
    var aA=document.getElementsByTagName('a');//获取向右向左的箭头
    var timer=null;
    var iSpeed=10;
    oUl.innerHTML+=oUl.innerHTML;//定义图片可以循环播放
    oUl.style.width=aLi.length*aLi[0].offsetWidth+'px';//定义外层ul的宽度，根据图片的个数和每个图片的宽度计算，保证总宽度是可调整的
    function fnMove(){
        if(oUl.offsetLeft<-oUl.offsetWidth/2){
            oUl.style.left=0;
        }else if(oUl.offsetLeft>0){
            oUl.style.left=-oUl.offsetWidth/2+'px';
        }//定义到边界的时候，实现无缝衔接

        oUl.style.left=oUl.offsetLeft+iSpeed+'px';

//定义图片的右边距随着速度不断不断增加，或减小，实现运动的效果
    }
    timer=setInterval(fnMove,60);
    aA[0].onclick=function(){
        iSpeed=-10;

//按下左箭头，定义向左运动

    }
    aA[1].onclick=function(){
        iSpeed=10;

//按下右箭头，定义向右运动
    }
    oDiv.onmouseover=function(){
        clearInterval(timer);

//鼠标移动到图片上，清除定时器，停止运动
    }
    oDiv.onmouseout=function(){
        timer=setInterval(fnMove,60);

//鼠标移出，重新开启定时器，重新运动
    }
};


var w = document.documentElement.clientWidth*1.2;
var h = document.documentElement.clientHeight*1.2;
var star = document.getElementsByClassName("stars")[0];
var n = 1000;
//随机函数
function randomNum(m, n) {
    return Math.floor(Math.random() * (n - m + 1) + m);
}
var str = '';
for (var i = 0; i < n; i++) {
    var numX = randomNum(-w, w);
    var numY = randomNum(-h, h);
    var color = 'rgb(' + randomNum(0, 255) + ',' + randomNum(0, 255) + ',' + randomNum(0, 255) + ')';
    str += numX +'px'+' ' + numY+'px'+' '+ color+',';
}
str = str.slice(0,-1);
star.style.boxShadow = str;


$(function(){

    $('#main').fadeOut();

    $('#main').fadeIn('slow');

})
//页面滚动至指定的位置