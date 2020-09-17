目录
- [1. HTML的元素分类](#1-html的元素分类)
  - [1.1 block（块）元素的特点](#11-block块元素的特点)
  - [1.2 inline元素的特点](#12-inline元素的特点)
- [2. HTML5](#2-html5)
  - [2.1 HTML与XHTML——二者有什么区别？](#21-html与xhtml二者有什么区别)
  - [2.2 iframe的优缺点？](#22-iframe的优缺点)
  - [2.3 html5新增的元素](#23-html5新增的元素)
  - [2.4 canvas实现](#24-canvas实现)

## 1. HTML的元素分类

块级元素block（方块形状，占据一整行）：div ul ol li dl dt dd h1 h2 h3 h4…p

行内元素inline(一行中的某个位置)：a b span img input select strong（强调的语气）

inline-block(行内，有宽高属性)：selection

- 行内元素：a、b、span、img、input、strong、select、label、em、button、textarea 
- 块级元素：div、ul、li、dl、dt、dd、p、h1-h6、blockquote 
- 空元素:br、meta、hr、link、input、img（也是块级）

### 1.1 block（块）元素的特点
①、总是在新行上开始；

②、高度，行高以及外边距和内边距都可控制；

③、宽度缺省是它的容器的100%，除非设定一个宽度。

④、它可以容纳内联元素和其他块元素

### 1.2 inline元素的特点
①、和其他元素都在一行上；

②、高，行高及外边距和内边距不可改变；

③、宽度就是它的文字或图片的宽度，不可改变

④、内联元素只能容纳文本或者其他内联元素

>对行内元素，需要注意如下
>
>- 设置宽度width 无效。
>- 设置高度height 无效，可以通过line-height来设置。
>- 设置margin 只有左右margin有效，上下无效。
>- 设置padding只有左右padding有效，上下则无效。注意元素范围是增大了，但是对元素周围的内容是没影响的。

## 2. HTML5

### 2.1 HTML与XHTML——二者有什么区别？
答案：1、HTML 元素必须被正确地嵌套。2、XHTML 元素必须被关闭。3、标签名必须用小写字母。4、XHTML 文档必须拥有根元素。

### 2.2 iframe的优缺点？
答案：优点：a. 解决加载缓慢的第三方内容如图标和广告等的加载问题b. iframe无刷新文件上传 c. iframe跨域通信
缺点：a. iframe会阻塞主页面的Onload事件 b. 无法被一些搜索引擎索引到c. 页面会增加服务器的http请求 d. 会产生很多页面，不容易管理。

### 2.3 html5新增的元素

html5新增了一些语义化更好的标签元素。

结构元素
- article元素，表示页面中的一块与上下文不相关的独立内容，比如博客中的一篇文章。
- aside元素，表示article内容之外的内容，辅助信息。
- header元素，表示页面中一个内容区块或整个页面的页眉。
- hgroup元素，用于对页面中一个区块或整个页面的标题进行组合。
- footer元素，表示页面中一个内容区块或整个页面的页脚。
- figure元素，表示媒介内容的分组，以及它们的标题。
- section元素，表示页面中一个内容区块，比如章节。
- nav元素，表示页面中的导航链接。

其他元素
- video元素，用来定义视频。
- audio元素，用来定义音频。
- canvas元素，用来展示图形，该元素本身没有行为，仅提供一块画布。
- embed元素，用来插入各种多媒体，格式可以是Midi、Wav、AIFF、AU、MP3等。
- mark元素，用来展示高亮的文字。
- progress元素，用来展示任何类型的任务的进度。
- meter元素，表示度量衡，定义预定义范围内的度量。
- time元素，用来展示日期或者时间。

### 2.4 canvas实现
上文提到的canvas元素可以为页面提供一块画布来展示图形。结合Canvas API，就可以在这块画布上动态生成和展示各种图形、图表、图像以及动画了。Canvas本质上是位图画布，不可缩放，绘制出来的对象不属于页面DOM结构或者任何命名空间。不需要将每个图元当做对象存储，执行性能非常好。

利用Canvas API进行绘图，首先要获取canvas元素的上下文，然后用该上下文中封装的各种绘图功能进行绘图。

```
<canvas id="canvas">替代内容</canvas>
<script>
var canvas = document.getElementById('canvas');
var context =canvas.getContext("2d"); // 获取上下文
//设置纯色
context.fillStyle = "red";
context.strokeStyle = "blue";
// 实践表明在不设置fillStyle下的默认fillStyle为black
context.fillRect(0, 0, 100, 100);
// 实践表明在不设置strokeStyle下的默认strokeStyle为black
context.strokeRect(120, 0, 100, 100);
</script>
```