目录
- [1. HTML的元素分类 ](#1-html的元素分类-)
  - [1.1 block（块）元素的特点](#11-block块元素的特点)
  - [1.2 inline元素的特点](#12-inline元素的特点)
  - [1.3 title与h1的区别、b与strong的区别、i与em的区别？](#13-title与h1的区别b与strong的区别i与em的区别)
  - [1.4 head 标签有什么作用，其中什么标签必不可少？](#14-head-标签有什么作用其中什么标签必不可少)
  - [常见的meta标签 ](#常见的meta标签-)
- [2. HTML5](#2-html5)
  - [2.1 HTML与XHTML——二者有什么区别？](#21-html与xhtml二者有什么区别)
  - [2.2 iframe的优缺点？](#22-iframe的优缺点)
  - [2.3 html5新增的元素](#23-html5新增的元素)
  - [2.4 canvas实现](#24-canvas实现)
  - [2.5 Canvas 和 SVG 的区别 ](#25-canvas-和-svg-的区别-)
- [3. 查漏补缺](#3-查漏补缺)
  - [3.1 src和href的区别 ](#31-src和href的区别-)
  - [3.2 script标签中defer和async的区别 ](#32-script标签中defer和async的区别-)
  - [3.3 HTML语义化的理解 ](#33-html语义化的理解-)
  - [3.4 DOCTYPE的作用与常见用法 ](#34-doctype的作用与常见用法-)
    - [DOCTYPE的作用](#doctype的作用)
    - [DOCTYPE的用法](#doctype的用法)
  - [3.5 Web worker ](#35-web-worker-)

## 1. HTML的元素分类 ![很多考察](https://img.shields.io/badge/-%E5%BE%88%E5%A4%9A%E8%80%83%E5%AF%9F-critical)

块级元素block（方块形状，占据一整行）：div ul ol li dl dt dd h1 h2 h3 h4…p

行内元素inline(一行中的某个位置)：a b span img input select strong

空元素: 
- 常见的：br、meta、hr、link、input、img、link（也是块级）
- 罕见的：area、base、col、embed、keygen、param、source

### 1.1 block（块）元素的特点
- 总是在新行上开始；
- 高度，行高以及外边距和内边距都可控制；
- 宽度默认是它的容器的100%，除非设定一个宽度。
- 它可以容纳内联元素和其他块元素

### 1.2 inline元素的特点
- 和其他元素都在一行上；
- 高，行高及外边距和内边距不可改变；
- 宽度就是它的文字或图片的宽度，不可改变
- 内联元素只能容纳文本或者其他内联元素

>对行内元素，需要注意如下
>- 设置宽度width 无效。
>- 设置高度height 无效，可以通过line-height来设置。
>- 设置margin 只有左右margin有效，上下无效。
>- 设置padding只有左右padding有效，上下则无效。注意元素范围是增大了，但是对元素周围的内容是没影响的。

### 1.3 title与h1的区别、b与strong的区别、i与em的区别？![较多考察](https://img.shields.io/badge/-%E8%BE%83%E5%A4%9A%E8%80%83%E5%AF%9F-important) 
- strong标签有语义，是起到加重语气的效果，而b标签是没有的，b标签只是一个简单加粗标签。b标签之间的字符都设为粗体，strong标签加强字符的语气都是通过粗体来实现的，而搜索引擎更侧重strong标签。
- title属性没有明确意义只表示是个标题，H1则表示层次明确的标题，对页面信息的抓取有很大的影响
- i内容展示为斜体，em表示强调的文本

### 1.4 head 标签有什么作用，其中什么标签必不可少？![较多考察](https://img.shields.io/badge/-%E8%BE%83%E5%A4%9A%E8%80%83%E5%AF%9F-important) 
- `<head>` 标签用于定义文档的头部，它是所有头部元素的容器。`<head>` 中的元素可以引用脚本、指示浏览器在哪里找到样式表、提供元信息等。
- 文档的头部描述了文档的各种属性和信息，包括文档的标题、在 Web 中的位置以及和其他文档的关系等。绝大多数文档头部包含的数据都不会真正作为内容显示给读者。
- 其中 `<title>` 定义文档的标题，它是 head 部分中唯一必需的元素。

### 常见的meta标签 ![较多考察](https://img.shields.io/badge/-%E8%BE%83%E5%A4%9A%E8%80%83%E5%AF%9F-important) 
>首先meta标签通常是由 name 和 content属性定义的，主要用于描述网页文档的属性，例如网页的作者，网页的描述，关键词等等，但是HTTP标准也固定了一些 name 作为大家使用的共识，当然开发者也可以自定义name。

- charset 用于描述HTML的编码类型
```html
<meta charset="UTF-8" >
```

- keywords, 用作页面关键词
```html
<meta name="keywords" content="关键词" />
```

-  description, 用于页面描述
```html
<meta name="description" content="页面描述内容" />
```

- refresh, 用于页面重定向和刷新
```html
<meta http-equiv="refresh" content="0; url=" />
```

- viewport 用于适配移动端，可以控制视口的大小比例
```html
<meta name="viewport" content="width-device-width, initial-scale=1, maximun-scale=1">

<!-- content选项
  width viewport ：宽度(数值/device-width)
  height viewport ：高度(数值/device-height)
  initial-scale ：初始缩放比例
  maximum-scale ：最大缩放比例
  minimum-scale ：最小缩放比例
  user-scalable ：是否允许用户缩放(yes/no）
-->

```




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

### 2.5 Canvas 和 SVG 的区别 ![较多考察](https://img.shields.io/badge/-%E8%BE%83%E5%A4%9A%E8%80%83%E5%AF%9F-important) 
Canvas

- 通过 js 来绘制 2D图形。
- canvas 图像单位是像素。
- canvas 图像绘制完毕之后，浏览器将不再关注它，如果位置发生变换，就需要重新绘制。

SVG

- svg 使用 XML 描述的2D图像。
- svg 是基于 xml 的，所以 svg 中绘制图形还是使用的元素，js 给元素任意添加事件。
- svg 绘制的图像是一个对象，如果对象的属性发生改变，浏览器将重新绘制图形。

>svg 是一种矢量图，而 canvas 依赖于分辨率。所以 svg 放大不会失真，但是 canvas 绘制的图形会失真。
>
>svg 支持事件处理器，而 canvas 不支持事件处理器。
>
>svg 中的文字独立于图像，文字可保留，可编辑和可搜索，canvas 的文本渲染能力弱。
>
>canvas 适合图像密集型的游戏，频繁地重绘图像，svg 绘制的复杂度高时减慢渲染的速度。
>
>canvas 绘制的图形可以多种格式 (jpg、png) 保存图片，但是 svg 绘制的只能以 .svg 格式保存，使用时可以引入 html 文件。
>



## 3. 查漏补缺

### 3.1 src和href的区别 ![很多考察](https://img.shields.io/badge/-%E5%BE%88%E5%A4%9A%E8%80%83%E5%AF%9F-critical)
src用于替代这个元素，而href用于建立这个标签与外部资源之间的关系。

**src (Source)源这个属性是将资源嵌入到当前文档中元素所在的位置。**
例如当我们写：
```
<script src="script.js"></script>
```

当浏览器解析到这句代码时，页面的加载和解析都会暂停直到浏览器拿到并执行完这个js文件。例如img，img标签是一个空标签，它的内容就是由src这个属性定义，浏览器会暂停加载直到这个图片加载完成。

href (Hypertext Reference) **超文本引用href这个属性指定web资源的位置**，从而定义当前元素（如锚点a）或当前文档（如链接）与目标锚点或目标资源之间的联系。
```
<link href="style.css" rel="stylesheet" />
```
浏览器知道这是个样式表文件，html的解析和渲染不会暂停，css文件的加载是同时进行的，这不同于在style标签里面的内置样式，用@import添加的样式是在页面载入之后再加载，这可能会导致页面因重新渲染而闪烁。所以我们建议使用link而不是@import。


### 3.2 script标签中defer和async的区别 ![很多考察](https://img.shields.io/badge/-%E5%BE%88%E5%A4%9A%E8%80%83%E5%AF%9F-critical)

当浏览器加载 HTML 并遇到`<script>...</script>`标签时，它无法继续构建 DOM。它必须立即执行脚本。外部脚本`<script src="..."></script>`也是如此：浏览器必须等待脚本下载，执行下载的脚本，然后才能处理页面的其余部分。

如果页面顶部有一个庞大的脚本，它会“阻塞页面”。在下载并运行之前，用户无法看到页面内容>。

```html
<script async src="example.js"></script>
```
有了async属性，表示后续文档的加载和渲染与js脚本的加载和执行是并行进行的，即异步执行；

```html
<script defer src="example.js"></script>
```
有了defer属性，加载后续文档的过程和js脚本的加载是并行进行的(异步)，此时的js脚本仅加载不
执行, js脚本的执行需要等到文档所有元素解析完成之后，DOMContentLoaded事件触发执行之
前。

1.defer和async在网络加载过程是一致的，都是异步执行的；(放在页面顶部,也不会阻塞页面的加
载,与页面加载同时进行)

2.两者的区别,脚本加载完成之后, async是立刻执行, defer会等一等 (等前面的defer脚本执行,等dom的加载)

所以, js脚本加上 async或 defer,放在头部可以减少网页的下载加载时间,如果不考虑兼容性,可以用于优化页面加载的性能



### 3.3 HTML语义化的理解 ![很多考察](https://img.shields.io/badge/-%E5%BE%88%E5%A4%9A%E8%80%83%E5%AF%9F-critical)

语义化是指根据内容的结构化（内容语义化），选择合适的标签（代码语义化）。通俗来讲就是用正确的标签做正确的事情。

>HTML语义化的有点
>1、对机器友好，带有语义的文字表现力丰富，更适合搜索引擎的爬虫爬取有效信息，有利于SEO（Search Engine Optimization）。除此之外，语义类还支持读屏软件，根据文章可以自动生成目录；
>2、对开发者友好，使用语义类标签增强了可读性，结构更加清晰，开发者能清晰的看出网页的结构，便于团队的开发与维护。

常见的 html5 语义化标签

```
<header></header>  头部

<nav></nav>  导航栏

<section></section>  区块（有语义化的div）

<main></main>  主要区域

<article></article>  主要内容

<aside></aside>  侧边栏

<footer></footer>  底部
```

### 3.4 DOCTYPE的作用与常见用法 ![较多考察](https://img.shields.io/badge/-%E8%BE%83%E5%A4%9A%E8%80%83%E5%AF%9F-important) 

#### DOCTYPE的作用

DOCTYPE是Document Type(文档类型的）的简写。在HTML代码中，用来说明当前代码用的XHTML或者HTML是哪一种规范。

在制作网页的时候，必须告诉浏览器你所写的HTML代码使用了哪一种规范，才可以正确的显示网页。如果没有说明自己HTML代码所采用的何种规范，浏览器将以怪异模式解析网页代码，这样就可能无法正常的将网页显示在浏览器上，不同的浏览器怪异模式差别不同，所显示出网页也不同。

#### DOCTYPE的用法

- <!DOCTYPE> 声明处于 <html> 标签之前
- DOCTYPE声明必须放在每一个XHTML文档最顶部，在所有代码和标识之上
- <!DOCTYPE> 声明没有结束标签
- <!DOCTYPE> 声明对大小写不敏感

### 3.5 Web worker ![较多考察](https://img.shields.io/badge/-%E8%BE%83%E5%A4%9A%E8%80%83%E5%AF%9F-important) 
JavaScript 语言是采用单线程模型，也就是任务只能在一个线程上完成，一次只能做一件事，前面任务没执行完，后面的任务只能排队等待，由于多核 CPU 的出现，单线程带来很大不便，无法充分发挥计算机的能力。

Web Worker 就是为了 javascript 创造多线程而生的，主线程创建 worker 子线程，将一些任务分配给后台运行，等到子线程完成计算任务，再把结果返回给主线程，好处是计算密集型或高延迟的任务被 worker 负担了，主线程就会很流畅。网页加载展示可分为两部分：主进程也叫 UI 进程，子进程也叫工作进程，子进程不能控制 UI 进程，只能进行数据交互。

Web Worker 子线程一旦创建成功，就会独立于其他脚本始终运行，不会被主线程上活动打断。这样有利于随时响应主线程的通信。但是这也造成 Worker 比较耗费资源，不应该过度使用，使用完毕之后应该关闭。

>
>当在 HTML 页面中执行脚本时，页面的状态是不可响应的，直到脚本已完成。
>
>web worker 是运行在后台的 JavaScript，独立于其他脚本，不会影响页面的性能。
>
>您可以继续做任何愿意做的事情：点击、选取内容等等，而此时 web worker 在后台运行。

```js
//在创建 web worker 之前，请检测用户的浏览器是否支持它：

if(typeof(Worker) !== "undefined") {
	// 是的! Web worker 支持!
}else{
	//抱歉! Web Worker 不支持
}
```
