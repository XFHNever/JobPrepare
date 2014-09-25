##如何清除浮动，bootstrap的clearfix
[CSS（十一）-清除浮动](http://xfhnever.github.io/blog/2014/07/29/css-clearfloat/)
##CSS Sprite
[]()
##如何实现圆角
border-radius
##html语义化

##垂直居中
[CSS（十五）-垂直居中](http://xfhnever.github.io/blog/2014/08/14/css-verticalcenter/)
##水平居中
- 文本，图片等行内元素水平居中：给父元素设置text-align:center
- 确定宽度的块级元素的水平居中：对块级元素设置： margin:0 auto;
- 不确定宽度的块级元素的水平居中：
    
    1. 将块级元素包含在table标签内，对table设置      margin:0 auto;
    2. 改变块级元素的display为inline类型，然后使用text-align:center来实现居中
    3. 给父元素设置float，然后设置position:relative和left:50%,子元素设置position:relative和left:-50%来实现水平居中

##列举html标签中的行内元素、块级元素
[CSS(十二)-行内元素和块级元素](http://xfhnever.github.io/blog/2014/07/29/css-inline-and-block/)
##引入样式表CSS的四种实现方式
- 使用STYLE属性：将STYLE属性直接加在个别的元件标签里

        <p style=""></p>
    这种用法的优点是可灵巧应用样式于各标签中，但是缺点则是没有整篇文件的『统一性』。        
  
- 使用STYLE标签：将CSS样式规则写在&lt;STYLE>...&lt;/STYLE>标签之中。
    通常是将整个的&lt;STYLE>...&lt;/STYLE>结构写在网页的<HEAD></HEAD>部份之中。这种用法的优点就是在於整篇文件的统一性，
    只要是有声明的的元件即会套用该样式规则。缺点就是在个别元件的灵活度不足。

- 使用LINK标签：将CSS样式规则写在.css的样式档案中，再以&lt;LINK>标签引入
    用法的优点就是在於可以把要套用相同样式规则的数篇文件都指定到同一个样式档案即可。缺点也是在个别文件或元件的灵活度不足。
- 使用@import引入：跟LINK用法很像，但必　放在&lt;STYLE>...&lt;/STYLE>中。

        <style>
            @import url('a.css');
        </style>

####不推荐使用@import
- link属于XHTML标签，而@import是CSS提供的;
- 页面被加载的时，link会同时被加载，而@import引用的CSS会等到页面被加载完再加载;
- import只在IE5以上才能识别，而link是XHTML标签，无兼容问题;
- link方式的样式的权重 高于@import的权重.
- 在一个样式文件中使用@import会为页面总体加载时间增加更多一个返程（也就是增加页面的总体加载时间）
- 在IE中使用@import 将会引起文件的下载顺序被改变。这更会引起样式文件花费更长的时间来下载，这会阻碍页面的渲染，让人感到页面比较慢。

##你对 html5、css3的理解，都有什么新增功能?如何处理HTML5新标签的浏览器兼容问题？
HTML5 现在已经不是 SGML 的子集，主要是关于图像，位置，存储，地理定位等功能的增加。

新增功能:

- 绘画 canvas 元素
- 用于媒介回放的 video 和 audio 元素
- 本地离线存储 localStorage 长期存储数据，浏览器关闭后数据不丢失；sessionStorage 的数据在浏览器关闭后自动删除
- 语意化更好的内容元素，比如 article、footer、header、nav、section
- 表单控件，calendar、date、time、email、url、search
- CSS3实现圆角，阴影，对文字加特效，增加了更多的CSS选择器  多背景 rgba 
- 新的技术webworker, websockt, Geolocation

####兼容
最好的方式是直接使用成熟的框架、使用最多的是html5shim框架

    <!--[if lt IE 9]> 
        <script> src="http://html5shim.googlecode.com/svn/trunk/html5.js"</script> 
    <![endif]--> 
    
##设计一个阿里巴巴的左侧导航栏html+css实现
##css的position属性，fixed的兼容性
[CSS（一）-一些属性介绍](http://xfhnever.github.io/blog/2014/07/24/css-introduction/)

##CSS的display属性
[CSS（一）-一些属性介绍](http://xfhnever.github.io/blog/2014/07/24/css-introduction/)

其中，inline-block可以使我们能够对行内元素进行一些块级元素的操作，比如设置width等；

display:none ：隐藏对象。与 visibility 属性的hidden值不同，其不为被隐藏的对象保留其物理空间。

##css的display行内块之间空白间隙的问题
空格符本质上就是个字符，与a,b,c,d这些字符是个同一个属性的东西，只是他是空格，透明的看不见而已（但可以选中）。
所以，只要我们使用让文字宽度为0的那些方法，不就可以解决inline-block元素间换行符间隙的问题啦！

    {font-size:0;}   //chrome兼容问题
    letter-spaceing:-4px;   //让文字水平方向上重叠

##css盒模型
[CSS（十）-盒式模型](http://xfhnever.github.io/blog/2014/07/29/css-box/)
##css自适应高度的 方法有几种，怎么写 
- 一定最小高度，内容加多时自适应高度，而内容少时DIV有一定最小高度

        div{ 
            _height:200px;  //仅IE6识别，当高度超过200px时，IE6会自动撑高。
            min-height:200px 
        } 
- CSS默认自适应高度
    不对DIV设置固定高度或不设置CSS高度样式，其DIV盒子默认是自适应高度。
    
- height
        
         html,body{
             margin:0px;
             height:100%;
         }
         #center{
         width:200px;
         height:100%;
         background-color:#666666;
         border:1px solid red;
         }
   一个对象的高度是否可以使用百分之比显示，取决于对象的父类对象，在页面中，#center直接放在body属性中，因此它的父类对象是body，而在默认状态下，
   浏览器并没有给body一个高度属性，因此我们所设置的#centere为height：100%并不会产生任何效果，但是一点我们给body设置了100%之后，
   他的子类对象#center的height:100%便发生作用了，这便是浏览器解析规则引发的高度自适应的问题。
         
   代码中除了给出body的定义属性之外，还给html对象也应用了相同的样式定义，这样做的好处是使IE与firefox浏览器都能够高度自适应，
   Ie与firefox对页面的解析存在一定的差异，ie中html对象默认为100%的高度，而body不是，而在firefox中html标签就不是100%的高度，
   因此两个标签都设置为100%,可以保证两款浏览器都能正常工作。

##怎么解决 IE 6、7、8 不支持 placeholder 的问题
[CSS(十六)-设置input Placeholder样式](http://xfhnever.github.io/blog/2014/08/20/css-placeholder/)
##如何实现鼠标悬浮在某个元素上时在这个位置出现一个 tooltip
- title属性
- Jquery tooltip()函数
- JS实现：

<script type="text/javascript">
    jQuery(function($) {
    var $liveTip = $('<div id="livetip"></div>').hide().appendTo('body');
    var tipTitle = '';
    $('#mytable').bind('mouseover mouseout mousemove', function(event) {
        var $link = $(event.target).closest('a');
        if (!$link.length) { return; }
        var link = $link[0];
        if (event.type == 'mouseover' || event.type == 'mousemove') {
            $liveTip.css({
                top: event.pageY + 12,
                left: event.pageX + 12
            });
        };
        if (event.type == 'mouseover') {
            tipTitle = link.title;
            link.title = '';
            $liveTip.html('<div>' + tipTitle + '</div><div>' + link.href + '</div>')
            .show();
        };
        if (event.type == 'mouseout') {
            $liveTip.hide();
            if (tipTitle) {
                link.title = tipTitle;
            };
        };
    });
    });
</script>
##如何管理一个页面中多个虚拟窗口（div，通过 z-index 进行区分），实现点击任意一个将其提升到最前（用户完全可见，不会被遮挡）
##如何实现九宫格
##经典的一侧定宽、另一侧自动扩展的布局如何设计
##介绍所知道的CSS hack技巧(如：_， *， +， \9， !important 之类)

[CSS（十三）-CSS Hack](http://xfhnever.github.io/blog/2014/07/30/css-hack/)
##CSS层叠是什么？介绍一下。
CSS有两大特性:层叠性和继承性

层叠性是指当有多个选择器都作用于同一个元素时，即多个选择器的作用范围发生了重叠，CSS怎样处理？CSS处理原则是：

- 如果多个选择器定义的规则不发生冲突，则元素将应用所有选择器定义的样式。
- 如果多个选择器定义的规则发生了冲突，则CSS按选择器的优先级让元素应用优先级高的选择器定义的样式。

##都知道哪些CSS浏览器兼容性问题
##如何居中一个浮动元素? 
        width:500px;
        height:300px; 
        float:left; 
        margin-left:50%;  
        position:relative; 
        left:-250px; 
        background-color:#CCC; 
        
首先设置块元素的宽度和高度，这里宽度是必须的，高度可以不设。实现居中关键在于 margin-left:50%; position:relative; left:-250px;

设置margin-left:50%;后浮动元素左边正好位于文档中间，设置块相对定位position:relative;然后左移宽度的二分之一，即可实现元素居中。在这个实例中宽度500，left设置为-250px.

#####another：
css:
   
    .bb1{width:500px;border:1px solid #333;padding:10px;margin:20px auto;}
    .bb2{float:left;position:relative;left:50%;}
    .bb2 a{position:relative;right:50%;}

xhtml:

    <div class="bb1 clearfix">
    <div class="bb2">
    <a href="">导航1</a>
    <a href="">导航2</a>
    <a href="">导航3</a>
    <a href="">导航4</a>
    <a href="">导航5</a>
    </div>
    </div>
