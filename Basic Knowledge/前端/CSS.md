目录
- [1. CSS 盒模型](#1-css-盒模型)
  - [1.1 Content-box (W3C)](#11-content-box-w3c)
  - [1.2 Border-box (IE)](#12-border-box-ie)
  - [1.3 BFC 规范](#13-bfc-规范)
    - [1.3.1 如何生成BFC](#131-如何生成bfc)
    - [1.3.2 BFC能用来做什么](#132-bfc能用来做什么)
- [2. CSS加载方式](#2-css加载方式)
  - [2.1 内部样式表](#21-内部样式表)
  - [2.2 内联样式表](#22-内联样式表)
  - [2.3 外部样式表](#23-外部样式表)
  - [2.4 加载方式的区别](#24-加载方式的区别)
  - [2.5 @import 和 link 的区别是什么呢？](#25-import-和-link-的区别是什么呢)
  - [2.6 src 和 href 的区别](#26-src-和-href-的区别)
- [3. 选择器](#3-选择器)
  - [3.1 优先级](#31-优先级)
  - [3.2 css继承](#32-css继承)
  - [3.3 伪类选择器](#33-伪类选择器)
    - [3.3.1 静态动态伪类选择器](#331-静态动态伪类选择器)
    - [3.3.2 UI 伪类选择器](#332-ui-伪类选择器)
    - [3.3.3 结构伪类选择器](#333-结构伪类选择器)
- [4. 布局](#4-布局)
  - [4.1 px，em，rem，vw 区别](#41-pxemremvw-区别)
  - [4.2 display的值和作用](#42-display的值和作用)
  - [4.3 position的值和作用](#43-position的值和作用)
  - [4.4 三栏布局](#44-三栏布局)
    - [4.4.1 圣杯布局](#441-圣杯布局)
    - [4.4.2 双飞翼布局](#442-双飞翼布局)
    - [4.4.3 float实现](#443-float实现)
    - [4.4.4 flex实现](#444-flex实现)
    - [4.4.5 gird，table](#445-girdtable)
  - [4.5 两栏布局](#45-两栏布局)
  - [4.6 水平居中和垂直居中](#46-水平居中和垂直居中)
    - [4.6.1 水平居中](#461-水平居中)
    - [4.6.2 垂直居中](#462-垂直居中)
  - [4.7 flex值和作用](#47-flex值和作用)
- [5. CSS3 新特性](#5-css3-新特性)
- [6. float元素特征，如何清除](#6-float元素特征如何清除)
- [7. display:none 与 visibility:hidden 的区别](#7-displaynone-与-visibilityhidden-的区别)
- [8.性能优化](#8性能优化)
- [9. CSS hack](#9-css-hack)


## 1. CSS 盒模型

标准模型由四部分组成：

- 内容区域: 可以放置元素的区域如文本,图像等，一般设置宽高指的是这个内容的宽高
- 内边距的区域：内容与边框之间的距离
- 边框区域: 边框
- 外边框区域：由外边框限制，用空白区域扩展边框区域，开分开相邻的元素

### 1.1 Content-box (W3C)
padding 和 border **不被包含**在定义的 width 和 height 之内。对象的实际宽度等于设置的width 值和border、padding 之和，即Elemenet width = width + border + padding。

```
.box1 {
    box-sizing: content-box;
    width: 200px;
    padding: 10px;
    border: 15px solid #eee;
}
```

### 1.2 Border-box (IE)
padding 和 border **包含**在定义的 width 和 height 之内。对象的实际宽度等于设置的width 值，即Elemenet width = width。
```
.box2 {
    box-sizing: border-box;
    width: 200px;
    padding: 10px;
    border: 15px solid #eee;
}
/*
一般都是使用标准的 W3C 盒子模型。可以使用box-sizing 属性进行修改。
```

> JS 如何设置获取盒模型对应的宽和高？
>```dom.style.width/height;//设置获取的是内联样式
>dom.currentStyle.width/height;//只有IE支持
>window.getComputedStyle(dom).width/height;//兼容性好
>dom.getBoundingClientRect().width/height;//适用场所：计算一个元素的绝对位置
>```

### 1.3 BFC 规范

（W3C CSS 2.1 规范中的一个概念,它是一个独立容器，决定了元素如何对其内容进行定位,以及与其他元素的关系和相互作用。）

一个页面是由很多个 Box 组成的， 元素的类型和 display 属性， 决定了这个 Box 的类型。

不同类型的 Box，会参与不同的 Formatting Context（决定如何渲染文档的容器），因此Box内的元素会以不同的方式渲染，也就是说BFC内部的元素和外部的元素不会互相影响。**Block Formatting Context提供了一个环境，HTML元素在这个环境中按照一定规则进行布局。一个环境中的元素不会影响到其它环境中的布局。比如浮动元素会形成BFC，浮动元素内部子元素的主要受该浮动元素影响，两个浮动元素之间是互不影响的。**

#### 1.3.1 如何生成BFC

- 根元素或包含根元素的元素；
- 浮动元素（元素的 float 不是 none）；
- 绝对定位元素（元素的 position 为 absolute 或 fixed）；
- 行内块元素（元素的 display 为 inline-block ）；
- 表格单元格（元素的 display 为 table-cell ，HTML 表格单元格默认为该值）；
- 表格标题（元素的 display 为 table-caption ，HTML 表格标题默认为该值）；
- 弹性元素（display 为 flex 或 inline-flex **元素的直接子元素**）；
- 网格元素（display 为 grid 或 inline-grid **元素的直接子元素**）；
- 匿名表格单元格元素（元素的 display 为 table、 table-row 、 table-row-group 、table-header-group 、table-footer-group （分别是 HTML table、row、tbody、thead、tfoot 的默认属性）或 inline-table ）；
- **overflow 值不为 visible 的块元素；**
- display 值为 flow-root 的元素；
- contain 值为 layout、content 或 strict 的元素；
- 多列容器（元素的 column-count 或 column-width 不为 auto，包括 column-count 为 1）；
- column-span 为 all 的元素始终会创建一个新的 BFC，即使该元素没有包裹在一个多列容器
中。

#### 1.3.2 BFC能用来做什么
- 清除元素内部浮动：通过给父元素创建 BFC ，添加 overflow: hidden; 样式；
  <img src="../Assets/css4.png" width="300">

  只要把父元素设为 BFC 就可以清理子元素的浮动了，最常见的用法就是在父元素上设置  overflow : hidden 样式，对于 IE6 加上 zoom :1 就可以了( IE Haslayout )。

  根据 CSS2.1 规范第 10.6.3 部分的高度计算规则，在进行普通流中的块级非替换元素的高度计算时，浮动子元素不参与计算。同时 CSS2.1 规范第10.6.7部分的高度计算规则，在计算生成了 block formatting context 的元素的高度时，其浮动子元素应该参与计算。**所以，触发外部容器BFC，高度将重新计算。比如给outer加上属性overflow:hidden触发其BFC。**

  结果：

  <img src="../Assets/css5.png" width="300">


- 解决外边距合并问题：将垂直方向上的盒子放在不同的 BFC 中，margin 就不会重叠了；
  <img src="../Assets/css2.png" width="500">

  如果一个浮动元素后面跟着一个非浮动的元素，那么就会产生一个覆盖的现象，很多自适应的两栏布局就是这么做的。**上面已经说过创建 BFC 的方法，可以根据具体情况选用不同的方法，这里我选用的是加 overflow:hidden。**

  结果：

  <img src="../Assets/css3.png" width="500">

- 制作自适应两栏布局：要求两栏布局中间没有缝隙时，通过触发 main 生成 BFC ，来实现自适应无缝隙两栏布局。
  
  <img src="../Assets/css6.png" width="300">

  根据 CSS 2.1 8.3.1 Collapsing margins 第一条，两个相邻的普通流中的块框在垂直位置的空白边会发生折叠现象。也就是处于同一个BFC中的两个垂直窗口的margin会重叠。根据 CSS 2.1 8.3.1 Collapsing margins 第三条，生成 block formatting context 的元素不会和在流中的子元素发生空白边折叠。所以解决这种问题的办法是要为两个容器添加具有BFC的包裹容器。**所以解这个问题的办法就是,把两个容器分别放在两个据有 BFC 的包裹容器中，IE 里就是触发layout 的两个包裹容器中！**

  结果：

  <img src="../Assets/css7.png" width="300">

## 2. CSS加载方式

### 2.1 内部样式表

通过style标签将CSS的样式写在style属性当中，链入内部的CSS文件。
<img src="../Assets/css1.png" width="500">

### 2.2 内联样式表
样式通过style属性内嵌在css的样式当中，写在标签当中。

### 2.3 外部样式表
通过link标签或者是在style中通过@import的方式引入外部的CSS样式文件。

```
<link rel="stylesheet" herf="style.css">

<style>
@import url("style.css")
@import url(style.css)
@import "style.css";
</style>
```

### 2.4 加载方式的区别

1） 优先级不同，内联样式表的优先级最高，而内部样式表和外部样式表的优先级与书写顺序有关，后书写的优先级高。

2） 作用域不同，内联样式表的作用域最小，只能应用于当前的元素，内部样式表的作用域其次，只能应用于当前的HTML文件，最后是外部样式表的作用域最大，能够适用于所有链接的HTML文件。

3）书写顺序不同，内联样式表写在标签当中，内部样式表写在style标签中来链入内部的CSS文件，外部样式表是通过link或者是@import的方式来链入外部的CSS文件。

### 2.5 @import 和 link 的区别是什么呢？

1）本质的差别：link是属于XHTML的标签，而@import是CSS提供的一种方式。

2）加载顺序的差别：当页面进行加载的时候，link引用的CSS时会被加载，而@import引用的CSS会等页面加载完成以后才被加载，所以在 @import加载CSS的时候，一开始会没有样式。

3）兼容性的差别：@import在老的浏览器上不兼容，只有在IE5以上的浏览器才可以被识别，但是link可以在任意浏览器的版本上进行加载执行。

4）使用DOM文档对象模型控制样式的差别：当使用JavaScript控制DOM区改变样式的时候，只能使用link标签，而@import是不可以的。

5）作用不同：link是属于XHTML，除了可以加载css,还可以定义RSS等其它事务，而@import是属于css范畴，只能加载css。

6）权重不同：link方式的权重高于@import的权重值。

7）标签不同：import在html使用的时候需要标签，而link在html使用的时候不需要标签。

### 2.6 src 和 href 的区别

href 是指向网络资源所在位置，建立和当前元素（锚点）或当前文档（链接）之间的链接，用于超链接。浏览器会识别该文档，并**行下载该文档**，并且不会停止对文档的处理。

src是指向外部资源的位置，指向的内容将会嵌入到文档中当前标签所在位置；在请求src资源时会将其指向的资源下载并应用到文档内，例如js脚本，img图片和frame等元素。浏览器解析到该元素时，会暂停浏览器的渲染，直到该资源加载完毕。**这也就是js脚本放在底部而不是头部的原因。**


## 3. 选择器

- id选择器(#myid)
- 类选择器(.myclassName)
- 标签/元素选择器(p,h1,p)
- 组合选择器：
  - 子元素选择器(ul>li)
  - 后代选择器(li a)
  - 直接相邻元素选择器(h1 + p)
  - 普通相邻元素选择器
  - 
- 通配符选择器(*)
- 属性选择器(a[rel="external"])
- 伪类选择器(a:hover,li:nth-child)
  - UI元素伪类选择器
  - 结构伪类选择器

### 3.1 优先级

元素选择符： 1
class选择符： 10
id选择符：100
元素标签：1000

- 同权重： 内联样式(标签内部) > 内部样式表(当前文件中) > 外部样式(外部文件中)
- !important > id > class > tag
- !important 比内联优先级高
- 如果优先级相同，则选择最后出现的样式。
- 继承得到的样式的优先级最低。

### 3.2 css继承
可继承的样式： 
- font-size 
- font-family 
- font-weight 
- font-style
- color

不可继承的样式： 
- border
- padding 
- margin
- height 
- width

### 3.3 伪类选择器

**伪元素**是创造文档树之外的对象。例如文档不能提供访问元素内容第一字或者第一行的机制。

伪元素还提供一些在源文档中不存在的内容分配样式，例如 `:before` 和 `:after` 能够访问产生的内容。

伪元素的内容实际上和普通 DOM 元素是相同的，但是它本身只是基于元素的抽象，并不存在于文档中，所以叫伪元素。

**伪类**是基于元素的特征而不是它们的 id、class、属性或者内容。一般来说，元素的特征是不可以从DOM 树上推断得到的，而且其是动态的，当用户和 DOM 进行交互的时候，元素可以获得或者失去一个伪类（这里有一个例外，就是 `:first-child` 和 `:lang` 是可以从 DOM 树中推断出来的）。

#### 3.3.1 静态动态伪类选择器

- a:link 没有访问之前a标签的样式
- a:visited 已访问a标签的样式
- a:hover a标签鼠标移上的样式
- a:actived a标签鼠标按下的样式
- input:focus input表单元素获取焦点
- input:blur input表单元素失去焦点

#### 3.3.2 UI 伪类选择器
- :checked 被选中 主要用在input表单元素上 (新增)
- ::selection
- enabled 控制表单控件的禁用状态。
- disabled 控制表单控件的禁用状态。
- read-write
- read-only

#### 3.3.3 结构伪类选择器
- :root 
- E:not 排除 (新增)
- :empty 空内容 (新增)
- E:target
  
    ---------------
- :last-child 最后一个元素  (新增)
- :nth-child(n)  n表示具体的第几个  odd/2n+1 奇数 even/2n 偶数 (新增)
- :only-child 仅仅/唯一的元素 (新增)
- :nth-last-child(n) 倒数第几个元素  :nth-last-child(1) <=> :last-child (新增)
  
    ---------------
- :first-of-type 第一个同级兄弟元素 (新增)
- :last-of-type 最后一个同级兄弟元素 (新增)
- :only-of-type 只有一个同级兄弟元素 (新增)
- :nth-of-type(n) 第几个同级兄弟元素 (新增)
- :nth-last-of-type(n) 倒数第几个同级兄弟元素 (新增)

## 4. 布局

### 4.1 px，em，rem，vw 区别

- px 像素（Pixel）：相对长度单位。像素 px 是相对于显示器屏幕分辨率而言的。
- em : 相对长度单位，相对于父元素字体大小，1em 被定义为一种给定字体的 font-size 值。如当前对行内文本的字体尺寸未被人为设置，则相对于浏览器的默认字体尺寸。
- rem : rem——root em，是相对于根元素 <html> 的字体大小单位。
- vw : 1vw 为视口宽度的 1%。

### 4.2 display的值和作用
| 值 | 作用 |
| -- | --- |
|block | 此元素将显示为块级元素，此元素前后会带有换行符。默认宽度为父元素宽度，可设置宽高，换行显示 |
|none | 元素不显示，并从文档流中移除 |
|inline | 行内元素，默认宽度为内容宽度，不可设置宽高，同行显示
|inline-block (CSS2.1新增) | 默认宽度为内容宽度，可以设置宽高，像行内元素一样显示，但其内容像块类型元素一样显示 |
|list-item | 此元素会作为列表显示 |
|table | 此元素会作为块级表格来显示（类似table），表格前后带有换行符

### 4.3 position的值和作用
| 值 | 作用 |
| -- | --- |
|absolute | 生成绝对定位的元素，相对于 static 定位以外的第一个父元素进行定位。元素的位置通过 "left", "top", "right" 以及 "bottom" 属性进行规定。而其层叠通过css z-index属性定义。此时对象**不具有边距**，宽度由元素里面的内容决定，效果和用float方法一样，但仍有补白和边框 |
|fixed | 生成固定定位的元素，相对于浏览器窗口进行定位。（老IE不支持）元素的位置通过 "left", "top", "right" 以及 "bottom" 属性进行规定。
|relative | 生成相对定位的元素，相对于其正常位置进行定位，不脱离文档流。因此，"left:20" 会向元素的 LEFT 位置添加 20 像素。
|static | 默认值。没有定位，元素出现在正常的文档流中（忽略 top, bottom, left, right 或者 z-index 声明）。
|inherit | 规定应该从父元素继承 position 属性的值。
|sticky (新增) | 它主要用在对 scroll 事件的监听上；粘性定位可以被认为是相对定位和固定定位的混合。元素在跨越特定阈值前为相对定位，之后为固定定位。例如：#one { position: sticky; top: 10px; } 在 viewport 视口滚动到元素 top 距离小于 10px 之前，元素为相对定位。之后，元素将固定在与顶部距离 10px 的位置，直到 viewport 视口回滚到阈值以下。

### 4.4 三栏布局

#### 4.4.1 圣杯布局
HTML结构设置

- 新建一个父元素，包含三个子元素：left、main、right（注意，main在写在前面，这样在页面渲染时会先加载中间，针对面试
题优先加载中间部分）

CSS样式设置

- 父元素设置高度
- 三个元素均设置浮动
- 中间main部分定宽100%：width: 100%，左右两边按产品需求设置宽高
- 左边设置margin-left: -100%；右边设置margin-right: -右盒子宽
- 父元素设置padding-left: 左盒子宽；padding-right: 右盒子宽
- 左右盒子相对定位

```
<div class="container">
  <div class="main f">go aheadgo aheadvgo aheadgo aheadgo aheadgo aheadgo aheadgo aheadgo aheadgo aheadgo aheadgo aheadgo aheadgo aheadgo aheadgo ahead</div>
 <div class="left f"></div>
 <div class="right f"></div>
</div>

<style>
 body {
 min-width: 700px;
 }
 .container {
 height: 300px;
 padding: 0 200px 0 200px;
 }
 .f {
 float: left;
 }
 .main {
 width: 100%;
 height: 300px;
 background-color: cornflowerblue;
 }
 .left {
 width: 200px;
 height: 300px;
 background-color: indianred;
 margin-left:-100%;
 /*postion:relative;*/
 right:-200px;
 }
 .right {
 width: 200px;
 height: 300px;
 background-color: lightgreen;
 margin-left:-200px;
 /*postion:relative;*/
 right:-200px;
 }
 </style>
 ```

该布局受内部元素影响而破坏布局的概率低，但是当浏览器屏幕缩小的一定程度时，左右两侧的内容会掉下来，或发生重叠现象。解决方案，给body加一个最小宽度（起码大于左右两侧宽度之和）

#### 4.4.2 双飞翼布局
HTML结构设置

- 新建一个父元素，包含三个子元素：left、main、right（注意，main在写在前面，这样在页面渲染时会先加载中间，针对面试
题优先加载中间部分）

CSS样式设置

- 父元素设置高度
- 三个元素均设置浮动
- 中间main部分定宽100%：width: 100%，左右两边按产品需求设置宽高
- 中间main部分再加一个盒子inner，放置内容（与圣杯布局的不同点）
- 左边设置margin-left: -100%；右边设置margin-right: -右盒子宽
- 新添加盒子，inner，设置左右padding或margin

```
<div class="container">
 <div class="main f">
 <div class=inner>go aheadgo aheadvgo aheadgo aheadgo aheadgo aheadgo aheadgo aheadgo aheadgo aheadgo
aheadgo aheadgo aheadgo aheadgo aheadgo ahead</div>
 </div>
 <div class="left f"></div>
 <div class="right f"></div>
</div>

<style>
.container {
height: 300px;
}
.f {
float: left;
}
.main {
width: 100%;
height: 300px;
background-color: cornflowerblue;
}
.left {
width: 200px;
height: 300px;
background-color: indianred;
margin-left: -100%;
}
.right {
width: 200px;
height: 300px;
background-color: indianred;
margin-left: -200px;
}
.inner {
  padding: 0 200px 0 200px;
}
 ```

#### 4.4.3 float实现
HTML结构设置

- 新建三个元素：left、right、main（注意，main写在后面）
  
CSS样式设置

- 左盒子左浮动，右盒子右浮动
- 中间部分设置margin或padding值

```
<div class="left"></div>
<div class="right"></div>
<div class="main">go aheadgo aheadvgo aheadgo aheadgo aheadgo aheadgo aheadgo aheadgo aheadgo aheadgo
aheadgo aheadgo aheadgo aheadgo aheadgo ahead</div>

<style>
 .main {
 margin: 0 200px 0 200px;
 background-color: red;
 height: 200px;
 }
 .left {
 float: left;
 width: 200px;
 background-color: blue;
 height: 200px;
 }
 .right {
 float: right;
 width: 200px;
 background-color: pink;
 height: 200px;
 }
</style>
```

#### 4.4.4 flex实现
HTML结构设置

- 新建一个父元素，包含三个子元素：main、left、right（注意，main写在前面）

CSS样式设置

- 父元素设置宽度为100%，display: flex；
- main中间部分设置flex: 1；
- 左右两则按产品需求设置宽高；
- left设置order: -1；
  
```
<div class="container">
 <div class="main">go aheadgo aheadvgo aheadgo aheadgo aheadgo aheadgo aheadgo aheadgo aheadgo aheadgo
aheadgo aheadgo aheadgo aheadgo aheadgo ahead</div>
 <div class="left"></div>
 <div class="right"></div>
</div>
<style>
 .container {
 width: 100%;
 height: 200px;
 display: flex;
 }
 .main {
 flex: 1;
 background-color: red;
 height: 200px;
 }
 .left {
 width: 200px;
 background-color: blue;
 height: 200px;
 order: -1;
 }
 .right {
 width: 200px;
 background-color: pink;
 height:200px;
 }
 </style>
 ```

order属性是调整或设置盒模型对象的子元素出现的顺序，数值越小排列越靠前，默认为0。在上面的布局中，left想要排在前面，就
需要比0小，所以设置order: -1，left盒子会跑到前面。需要注意的是，如果父元素没有设置flex，则 order 属性不起作用。

#### 4.4.5 gird，table

### 4.5 两栏布局
实现两栏布局，左栏固定宽度，右栏宽度与父级容器宽度一致，随父级容器宽度改变而改变。

给父级容器设置padding-left为左栏的宽度，给左栏设置绝对定位，定位至父级容器的左边left：0px，右栏设置宽度为100%，此时右栏的宽度随父级的宽度改变，右栏的宽度始终等于父级的宽度。

```
<div class="box">
	<div class="box1">left</div>
	<div class="box2">right</div>
</div>

<style type="text/css">
.box{
width: 800px;
position: relative;
padding-left: 200px;
}
.box1{
  width: 200px;
  height: 500px;
  background: red;
  position: absolute;
  left: 0;
}
.box2{
  width: 100%;
  height: 500px;
  background: green;
}
</style>
```

### 4.6 水平居中和垂直居中

#### 4.6.1 水平居中
- 在父元素上设置 text-align: center; 使文字/图片水平居中：

```
.container {
  text-align: center;
}
```

- margin 居中

```
.container {
  width: 80%;
  margin: 0 auto;
}
```

#### 4.6.2 垂直居中
- 未知元素宽高
```
<div class="outer">
    <span>我想居中显示</span>
</div>

<style>
.outer{
    width:300px;
    height:300px;
    position:relative;
    background-color:#ccc;
}
span{
    float:left;
    position:absolute;
    backgroond-color:red;
    top:50%;
    left:50%;
    transform:translate(-50%,-50%);
}
</style>
```
或者

```
.main {
  width: 400px;
  height: 400px;
  background-color: #aaa;
  display: table; /* 父元素设置表格属性 */
  text-align: center;
}
.main span {
  display: table-cell; /* img 设置成表格元素属性 */
  vertical-align: middle; /* 两个 display 设置后这个属性就起作用 */
}
```

- 已知元素宽高

```
<div class="outer">
    <span>我想居中显示</span>
</div>

<style>
.outer{
    width:300px;
    height:300px;
    position:relative;
    background-color:#ccc;
}
span{
    float:left;
    position:absolute;
    backgroond-color:red;
    width:150px;
    height:50px;
    top:50%;
    left:50%;
    margin:-25px 0px 0px -75px;
}
</style>
```

- 如何垂直居中一个img（display : table-cell 或者 position定位）

```
<div class="outer">        
    <img src="nz.jpg" alt="">    
</div>

<style>        
.outer{            
    width: 300px;           
    height: 300px;            
    border: 1px solid #cccccc;            
    display: table-cell;            
    text-align: center;            
    vertical-align: middle;        
}        
img{            
    width: 150px;            
    height: 150px;        
}    
</style>

```

- flex布局
``` 
父级元素：{
display: flex;
flex-direction: row;
justify-content: center;
align-items: center;
}
子级元素：{
flex: 1;
}
```


### 4.7 flex值和作用
- 设置盒子的display属性为flex，或者line-flex，其对应还有六个css属性。

  | 值 | 作用 |
  | -- | --- |
  |flex-direction | 设置子元素的排列方式（row，column，row-reverse，column-reverse） |
  |flex-warp | 设置子元素的是否换行（nowarp，warp，warp-reverse） |
  |flex-flow | flex-direction和flex-warp的缩写，默认为row nowarp
  |justify-content | 设置子元素的水平排列方式（flex-start，flex-end，center，span-around，span-between） |
  |align-items | 设置子元素的垂直方式（flex-start，flex-end，center，stretch，baseline） |
  |align-content | 设置多个轴线的排列方式（flex-start，flex-end，center，spand-around，spand-between，stretch）


- 对应的子元素项目也拥有自身的六个css属性。

  | 值 | 作用 |
  | -- | --- |
  |order | 设置元素的排列权重 值越大越在后 |
  |flex-grow | 设置元素的放大比例
  |flex-shrink | 设置元素的缩小比例
  |flex-basis | 设置多余空间项目主轴所占比例空间
  |flex | flex-grow和flex-shrink和flex-basis的缩写方式 默认为0 1 auto
  |align-self | 设置子元素自己的垂直排列方式，默认为盒子的align-items的值

:warning:：设置flex布局后，子元素的float，clear，vertical-align都无效

## 5. CSS3 [新特性](https://juejin.im/post/6844903829679390728)

- 新增各种 CSS 选择器  
  - :not(p)  选择每个非p的元素； 
  - p:empty 选择每个没有任何子级的p元素（包括文本节点）
- 边框：
  
  ```
  div{ 
      border:2px solid; 
      border-radius:25px; //用于设置圆角
      box-shadow: 10px 10px 5px #888888; //水平阴影 垂直阴影 模糊距离 阴影颜色
      border-image:url(border.png) 30 30 round;// 设置所有边框图像的速记属性。
  }
  ```
- 背景 background-clip（规定背景图的绘制区域），background-origin，background-size

  ```
  div{ 
      background:url(img_flwr.gif); 
      background-repeat:no-repeat; 
      background-size:100% 100%; //规定背景图的尺寸
      background-origin:content-box;//规定背景图的定位区域
  } 
  多背景 
  body{ 
      background-image:url(img_flwr.gif),url(img_tree.gif); 
  }
  ```
- 线性渐变 （Linear Gradients） 向下/向上/向左/向右/对角方向
  ```
  background: linear-gradient(direction, color-stop1, color-stop2, ...);
  ```
- 文本效果 
  
  阴影text-shadow，textwrap，word-break，word-wrap;

- 2D 转换 
  
  transform:scale(0.85,0.90) | translate(0px,-30px) | skew(-9deg,0deg) |rotate()  

- 3D转换 
  
  perspective()；transform是向元素应用 2D 或者 3D 转换；

- 过渡 transition
  
  transition：定义了元素在变化过程中是怎么样的，包含transition-property、transition-duration、transition-timing-function、transition-delay。

- 动画 animation
  
  animation：动画定义了动作的每一帧（@keyframes）有什么效果，包括animation-name，animation-duration、animation-timing-function、animation-delay、animation-iteration-count、animation-direction

- 多列布局 （multi-column layout）
- [盒模型](#1-css-盒模型)
- [flex 布局](#47-flex值和作用)
- 多媒体查询 定义两套css，当浏览器的尺寸变化时会采用不同的属性

>Transition 和 Animation 对比
>
>Transition 强调过渡，Transition ＋ Transform ＝ 两个关键帧的Animation
>
>Animation 强调流程与控制，Duration ＋ TransformLib ＋ Control ＝ 多个关键帧的Animation

## 6. float元素特征，如何清除 

- 出现浮动的原因：浮动元素碰到包含它的边框或者浮动元素的边框停留。在CSS规范中，浮动定位不属于正常的页面流，而是独立定位的，所以文档流的块框表现得就像浮动框不存在一样。浮动元素会漂浮在文档流的块框上。

- 关于css的定位机制：普通流，浮动，绝对定位（position：fixed是position：absolute的一个子类）。浮动的框可以左右移动，直到它的外边缘遇到包含框或者另一个浮动框的边缘，所以才说**浮动定位不属于正常的页面流**。文档中的普通流就会表现得和浮动框不存在一样，当浮动框高度超出包含框的时候，就会出现包含框**不会自动伸缩高度类笔盒浮动元素**。所以，只含有浮动元素的父容器在显示时不需要考虑子元素的位置，就造成显示父容器像空容器一样。

- 浮动带来的问题：
  - 对其父元素的影响

    对于其父元素来说，元素浮动之后，它脱离当前正常的文档流，所以它也无法撑开其父元素，造成父元素的塌陷。

  - 对其兄弟元素（非浮动）的影响

    如果兄弟元素为块级元素，该元素会忽视浮动元素的而占据它的位置，并且元素会处在浮动元素的下层（并且无法通过 z-index 属性改变它们的层叠位置），但它的内部文字和其他行内元素都会环绕浮动元素。

    如果兄弟元素为内联元素，则元素会环绕浮动元素排列。

  - 对其兄弟元素（浮动）的影响
  
    同一个方向的浮动元素：当一个浮动元素在浮动过程中碰到同一个方向的浮动元素时，它会紧跟在它们后面反方向的浮动元素：互不影响，位于同一条水平线上，当空间不够时会被挤下。

  - 对子元素的影响
  
    当一个元素浮动时，在没有清除浮动的情况下，它无法撑开其父元素，但它可以让自己的浮动子元素撑开它自身，并且在没有定义具体宽度情况下，使自身的宽度从 100% 变为自适应（浮动元素display: block; ）。其高度和宽度均为浮动元素高度和非浮动元素高度之间的最大值。
 
- 清除浮动的方式：

1.  父级div定义height

    原理：父级div手动定义height，就解决了父级div无法自动获取到高度的问题

    优点：简单，代码少，容易掌握

    缺点：只适合高度固定的布局，要给出精确的高度，如果高度和父级div不一样时，会产生问题

    建议：不推荐使用，只建议高度固定的布局时使用

------
2.  最后一个浮动元素后加空 div 标签 并添加样式 clear:both。（理论上能清除任何标签，增加无意义的标签）
  
    原理：添加一个空div，利用css提高的clear:both清除浮动，让父级div能自动获取到高度

    优点：简单，代码少，浏览器支持好，不容易出现怪问题

    缺点：不少初学者不理解原理；如果页面浮动布局多，就要增加很多空div，让人感觉很不爽

    建议：不推荐使用，但此方法是以前主要使用的一种清除浮动方法
------
3.  包含浮动元素的父标签添加样式 overflow 为 hidden 或 auto。

    原理：必须定义width或zoom:1，同时不能定义height，使用overflow:hidden时，浏览器会自动检查浮动区域的高度

    优点：简单，代码少，浏览器支持好

    缺点：不能和position配合使用，因为超出的尺寸的会被隐藏

    建议：只推荐没有使用position或对overflow:hidden理解比较深的朋友使用
------
4.  父级div定义伪类 :after 和 zoom（空标签元素清除浮动而不得不增加无意义代码的弊端，使用zoom:1用于兼容IE）
   
    原理：IE8以上和非IE浏览器才支持:after，原理和方法2有点类似，zoom(IE转有属性)可解决ie6,ie7浮动问题

    优点：浏览器支持好，不容易出现怪问题（目前：大型网站都有使用，如：腾迅，网易，新浪等等）

    缺点：代码多，不少初学者不理解原理，要两句代码结合使用，才能让主流浏览器都支持

    建议：推荐使用，建议定义公共类，以减少CSS代码


    (1) 在子元素后添加一个空div
     ```
     div{clear:both;}
     ```
    (2) 在父元素中{overflow:hidden|auto;zoom:1}

    (3) :after伪选择符，在父容器的尾部自动创建一个子元素
    ```
    .clearfix:after {
      content: "\0020";display: block;height: 0;clear: both;
    }
    .clearfix {
        zoom: 1;
    }
    ```
    "clearfix"是父容器的class名称，"content:"020";"是在父容器的结尾处放一个空白符.
    
    "height:0;"是让这个这个空白字符不显示出来。
    
    "display:block; clear: both;"是确保这个空白字符是非浮动的独立区块。
    
    :after选择符IE 6不支持,添加一条IE 6的独有命令"zoom:1;"就行了.

## 7. display:none 与 visibility:hidden 的区别

display : none 隐藏对应的元素，在文档布局中不再分配空间（回流+重绘）

visibility:hideen 隐藏对应的元素，在文档布局中仍保留原来的空间（重绘）

使用 CSS display:none 属性后，HTML 元素（对象）的宽度、高度等各种属性值都将“丢失”;而使用 visibility:hidden 属性后，HTML元素（对象）仅仅是在视觉上看不见（完全透明），而它所占据的空间位置仍然存在。

## 8.性能优化

  （1） 减少http请求次数：CSS Sprites, JS、CSS源码压缩、图片大小控制合适；网页Gzip，CDN托管，data缓存 ，图片服务器。

  （2） 前端模板 JS+数据，减少由于HTML标签导致的带宽浪费，前端用变量保存AJAX请求结果，每次操作本地变量，不用请求，减少请求次数

  （3） 用innerHTML代替DOM操作，减少DOM操作次数，优化javascript性能。

  （4） 当需要设置的样式很多时设置className而不是直接操作style。

  （5） 少用全局变量、缓存DOM节点查找的结果。减少IO读取操作。

  （6） 避免使用CSS Expression（css表达式)又称Dynamic properties(动态属性)。

  （7） 图片预加载，将样式表放在顶部，将脚本放在底部  加上时间戳。

## 9. CSS hack