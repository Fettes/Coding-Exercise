目录
- [1. webpack与grunt、gulp的不同](#1-webpack与gruntgulp的不同)
- [2. 常见的Loader和解决问题](#2-常见的loader和解决问题)
- [3. 常见的Plugin和解决问题](#3-常见的plugin和解决问题)
- [4. Loader和Plugin的不同](#4-loader和plugin的不同)
- [5. Webpack构建流程](#5-webpack构建流程)
- [6. 如何自动生成webpack配置？](#6-如何自动生成webpack配置)
  - [6.1 如何配置单页面和多页面的应用程序](#61-如何配置单页面和多页面的应用程序)
- [7. Webpack打包原理](#7-webpack打包原理)
- [8. Webpack热更新原理](#8-webpack热更新原理)
- [9. Webpack构建速度优化](#9-webpack构建速度优化)
- [10. 防抖与节流](#10-防抖与节流)
  - [10.1 防抖代码](#101-防抖代码)
  - [10.2 节流代码](#102-节流代码)
- [11. 重绘和回流](#11-重绘和回流)
  - [11.1 避免重绘与回流](#111-避免重绘与回流)
  - [11.2 渲染过程](#112-渲染过程)
- [12. 渲染URL](#12-渲染url)

## 1. webpack与grunt、gulp的不同

三者都是前端构建工具，grunt和gulp在早期比较流行，现在webpack相对来说比较主流，不过一些轻量化的任务还是会用gulp来处理，比如单独打包CSS文件等。

grunt和gulp是基于任务和流（Task、Stream）的。类似jQuery，找到一个（或一类）文件，对其做一系列链式操作，更新流上的数据， 整条链式操作构成了一个任务，多个任务就构成了整个web的构建流程。

webpack是基于入口的。webpack会自动地递归解析入口所需要加载的所有资源文件，然后用不同的Loader来处理不同的文件，用Plugin来扩展webpack功能。

## 2. 常见的Loader和解决问题

- file-loader：把文件输出到一个文件夹中，在代码中通过相对 URL 去引用输出的文件
- url-loader：和 file-loader 类似，但是能在文件很小的情况下以 base64 的方式把文件内容注入到代码中去
- source-map-loader：加载额外的 Source Map 文件，以方便断点调试
- image-loader：加载并且压缩图片文件
- babel-loader：把 ES6 转换成 ES5
- css-loader：加载 CSS，支持模块化、压缩、文件导入等特性
- style-loader：把 CSS 代码注入到 JavaScript 中，通过 DOM 操作去加载 CSS。
- eslint-loader：通过 ESLint 检查 JavaScript 代码
- vue-loader：加载 Vue.js 单文件组件

## 3. 常见的Plugin和解决问题
- define-plugin：定义环境变量
- commons-chunk-plugin：提取公共代码
- uglifyjs-webpack-plugin：通过UglifyES压缩ES6代码

## 4. Loader和Plugin的不同

Loader 本质就是一个函数，在该函数中对接收到的内容进行转换，返回转换后的结果。
因为 Webpack 只认识 JavaScript，所以 Loader 就成了翻译官，对其他类型的资源进行转译的预处理工作。

Plugin 就是插件，基于事件流框架 Tapable，插件可以扩展 Webpack 的功能，在 Webpack 运行的生命周期中会广播出许多事件，Plugin 可以监听这些事件，在合适的时机通过 Webpack 提供的 API 改变输出结果。

Loader 在 module.rules 中配置，作为模块的解析规则，类型为数组。每一项都是一个 Object，内部包含了 test(类型文件)、loader、options (参数)等属性。

Plugin 在 plugins 中单独配置，类型为数组，每一项是一个 Plugin 的实例，参数都通过构造函数传入。

## 5. Webpack构建流程
- 初始化参数：从配置文件和 Shell 语句中读取与合并参数，得出最终的参数
- 开始编译：用上一步得到的参数初始化 Compiler 对象，加载所有配置的插件，执行对象的 run 方法开始执行编译
- 确定入口：根据配置中的 entry 找出所有的入口文件
- 编译模块：从入口文件出发，调用所有配置的 Loader 对模块进行翻译，再找出该模块依赖的模块，再递归本步骤直到所有入口依赖的文件都经过了本步骤的处理
- 完成模块编译：在经过第4步使用 Loader 翻译完所有模块后，得到了每个模块被翻译后的最终内容以及它们之间的依赖关系
- 输出资源：根据入口和模块之间的依赖关系，组装成一个个包含多个模块的 Chunk，再把每个 Chunk 转换成一个单独的文件加入到输出列表，这步是可以修改输出内容的最后机会
- 输出完成：在确定好输出内容后，根据配置确定输出的路径和文件名，把文件内容写入到文件系统

在以上过程中，Webpack 会在特定的时间点广播出特定的事件，插件在监听到感兴趣的事件后会执行特定的逻辑，并且插件可以调用 Webpack 提供的 API 改变 Webpack 的运行结果。

>entry 入口，告诉webpack要使用哪个模块作为构建项目的起点，默认为./src/index.js
>
>output 出口，告诉webpack在哪里输出它打包好的代码以及如何命名，默认为./dist

## 6. 如何自动生成webpack配置？
可以用一些官方脚手架

- webpack-cli
- vue-cli
```
// 首先安装
npm install -g @vue/cli
// 新建项目hello
vue create hello
```

- nuxt-cli
```
// 确保安装了npx,npx在npm5.2.0默认安装了
// 新建项目hello
npx create-nuxt-app hello
```

### 6.1 如何配置单页面和多页面的应用程序

- 单个页面
```
module.exports = {
    entry: './path/to/my/entry/file.js'
}
```

- 多页面应用程序
```
module.entrys = {
    entry: {
        pageOne: './src/pageOne/index.js',
        pageTwo: './src/pageTwo/index.js'
    }
}
```


## 7. Webpack打包原理
将所有依赖打包成一个bundle.js，通过代码分割成单元片段按需加载。

Webpack 实际上为每个模块创造了一个可以导出和导入的环境，本质上并没有修改 代码的执行逻辑，代码执行顺序与模块加载顺序也完全一致。

## 8. Webpack热更新原理
Webpack 的热更新又称热替换（Hot Module Replacement），缩写为 HMR。 这个机制可以做到不用刷新浏览器而将新变更的模块替换掉旧的模块。

HMR的核心就是客户端从服务端拉去更新后的文件，准确的说是 chunk diff (chunk 需要更新的部分)，实际上 WDS（webpack-dev-server） 与浏览器之间维护了一个 Websocket，当本地资源发生变化时，WDS 会向浏览器推送更新，并带上构建时的 hash，让客户端与上一次资源进行对比。客户端对比出差异后会向 WDS 发起 Ajax 请求来获取更改内容(文件列表、hash)，这样客户端就可以再借助这些信息继续向 WDS 发起 jsonp 请求获取该chunk的增量更新。

后续的部分(拿到增量更新之后如何处理？哪些状态该保留？哪些又需要更新？)由 HotModulePlugin 来完成，提供了相关 API 以供开发者针对自身场景进行处理，像react-hot-loader 和 vue-loader 都是借助这些 API 实现 HMR。

## 9. Webpack构建速度优化
- 使用高版本的 Webpack 和 Node.js
- 使用多线程加速编译：HappyPack(不维护了)、thread-loader

- 压缩代码
  - 多进程并行压缩
    - webpack-paralle-uglify-plugin
    - uglifyjs-webpack-plugin 开启 parallel 参数 (不支持ES6)
    - terser-webpack-plugin 开启 parallel 参数
  - 通过 mini-css-extract-plugin 提取 Chunk 中的 CSS 代码到单独文件，通过 css-loader 的 minimize 选项开启 cssnano 压缩 CSS。
  
- 图片压缩
  - 使用基于 Node 库的 imagemin (很多定制选项、可以处理多种图片格式)
  - 配置 image-webpack-loader
  
- 使用Tree-shaking和Scope Hoisting来剔除多余代码

- 缩小打包作用域：

  - exclude/include (确定 loader 规则范围)
  - resolve.modules 指明第三方模块的绝对路径 (减少不必要的查找)
  - resolve.mainFields 只采用 main 字段作为入口文件描述字段 (减少搜索步骤，需要考虑到所有运行时依赖的第三方模块的入口文件描述字段)
  - resolve.extensions 尽可能减少后缀尝试的可能性
  - noParse 对完全不需要解析的库进行忽略 (不去解析但仍会打包到 bundle 中，注意被忽略掉的文件里不应该包含 import、require、define 等模块化语句)
  - IgnorePlugin (完全排除模块)合理使用alias

- DLL：

  - 使用 DllPlugin 进行分包，使用 DllReferencePlugin(索引链接) 对 manifest.json 引用，让一些基本不会改动的代码先打包成静态资源，避免反复编译浪费时间。
  - HashedModuleIdsPlugin 可以解决模块数字id问题


>- Tree shaking
>
>   - 打包过程中检测工程中没有引用过的模块并进行标记，在资源压缩时将它们从最终的bundle中去掉(只能对ES6 Modlue生效) 开发中尽可能使用ES6 Module的模块，提高tree shaking效率
>   - 禁用 babel-loader 的模块依赖解析，否则 Webpack 接收到的就都是转换过的 CommonJS 形式的模块，无法进行 tree-shaking
>   - 使用 PurifyCSS(不在维护) 或者 uncss 去除无用 CSS 代码
>       - purgecss-webpack-plugin 和 mini-css-extract-plugin配合使用(建议)
>
>- Scope hoisting
>
>   - 构建后的代码会存在大量闭包，造成体积增大，运行代码时创建的函数作用域变多，内存开销变大。Scope hoisting 将所有模块的代码按照引用顺序放在一个函数作用域里，然后适当的重命名一些变量以防止变量名冲突。
>   - 必须是ES6的语法，因为有很多第三方库仍采用 CommonJS 语法，为了充分发挥 Scope hoisting 的作用，需要配置 mainFields 对第三方模块优先采用 jsnext:main 中指向的ES6模块化语法

## 10. 防抖与节流

在工作中，我们可能碰到这样的问题：

- 用户在搜索的时候，在不停敲字，如果每敲一个字我们就要调一次接口，接口调用太频繁，给卡住了。
- 用户在阅读文章的时候，我们需要监听用户滚动到了哪个标题，但是每滚动一下就监听，那样会太过频繁从而占内存，如果再加上其他的业务代码，就卡住了。

所以，这时候，我们就要用到 防抖与节流 了。

### 10.1 防抖代码
[完整代码](https://github.com/Fettes/Coding-Exercise/blob/master/Basic%20Knowledge/Code/%E9%98%B2%E6%8A%96.html)

```
    // 2、防抖功能函数，接受传参
    function debounce(fn) {
      // 4、创建一个标记用来存放定时器的返回值
      let timeout = null;
      return function() {
        // 5、每次当用户点击/输入的时候，把前一个定时器清除
        clearTimeout(timeout);
        // 6、然后创建一个新的 setTimeout，
        // 这样就能保证点击按钮后的 interval 间隔内
        // 如果用户还点击了的话，就不会执行 fn 函数
        timeout = setTimeout(() => {
          fn.call(this, arguments);
        }, 1000);
      };
    }
```

**防抖：任务频繁触发的情况下，只有任务触发的间隔超过指定间隔的时候，任务才会执行。**

结合上面的代码，我们可以了解到，在触发点击事件后，如果用户再次点击了，我们会清空之前的定时器，重新生成一个定时器。意思就是：这件事儿需要等待，如果你反复催促，我就重新计时！

实例：有个输入框，输入之后会调用接口，获取联想词。但是，因为频繁调用接口不太好，所以我们在代码中使用防抖功能，只有在用户输入完毕的一段时间后，才会调用接口，出现联想词。

### 10.2 节流代码
[完整代码](https://github.com/Fettes/Coding-Exercise/blob/master/Basic%20Knowledge/Code/%E8%8A%82%E6%B5%81.html)
```
    // 2、节流函数体
    function throttle(fn) {
      // 4、通过闭包保存一个标记
      let canRun = true;
      return function() {
        // 5、在函数开头判断标志是否为 true，不为 true 则中断函数
        if(!canRun) {
          return;
        }
        // 6、将 canRun 设置为 false，防止执行之前再被执行
        canRun = false;
        // 7、定时器
        setTimeout( () => {
          fn.call(this, arguments);
          // 8、执行完事件（比如调用完接口）之后，重新将这个标志设置为 true
          canRun = true;
        }, 1000);
      };
    }
```
**节流：指定时间间隔内只会执行一次任务。**

实例：

- 监听计算滚动条的位置，使用节流按一定时间的频率获取。
- 用户点击提交按钮，假设我们知道接口大致的返回时间的情况下，我们使用节流，只允许一定时间内点击一次。

这样，在某些特定的工作场景，我们就可以使用防抖与节流来减少不必要的损耗。

## 11. 重绘和回流

- 重绘(repaint)：当元素样式的改变不影响布局时，浏览器将使用重绘对元素进行更新，此时由于只需要 UI 层面的重新像素绘制，因此损耗较少。

    常见的重绘操作有：
    - 改变元素颜色
    - 改变元素背景色

- 回流(reflow)：又叫重排（layout）。当元素的尺寸、结构或者触发某些属性时，浏览器会重新渲染页面，称为回流。此时，浏览器需要重新经过计算，计算后还需要重新页面布局，因此是较重的操作。

    常见的回流操作有：

    - 页面初次渲染
    - 浏览器窗口大小改变
    - 元素尺寸/位置/内容发生改变
    - 元素字体大小变化
    - 添加或者删除可见的 DOM 元素
    - 激活 CSS 伪类（:hover……）


**重点：回流必定会触发重绘，重绘不一定会触发回流。重绘的开销较小，回流的代价较高。**

实例：界面上有个 div 框，用户可以在 input 框中输入 div 框的一些信息，例如宽、高等，输入完毕立即改变属性。但是，因为改变之后还要随时存储到数据库中，所以需要调用接口。如果不加限制……

>为什么需要节流，因为有些事情会造成浏览器的**回流**，而回流会使浏览器开销增大，所以我们通过节流来防止这种增大浏览器开销的事情。

### 11.1 避免重绘与回流

- 避免频繁操作样式，可汇总后统一一次修改
- 尽量使用 class 进行样式修改，而不是直接操作样式
- 减少 DOM 的操作，可使用字符串一次性插入

### 11.2 渲染过程

- 浏览器通过 HTMLParser 根据深度遍历的原则把 HTML 解析成 DOM Tree。
- 浏览器通过 CSSParser 将 CSS 解析成 CSS Rule Tree（CSSOM Tree）。
- 浏览器将 JavaScript 通过 DOM API 或者 CSSOM API 将 JS 代码解析并应用到布局中，按要求呈现响应的结果。
- 根据 DOM 树和 CSSOM 树来构造 render Tree。
- layout：重排（也可以叫回流），当 render tree 中任一节点的几何尺寸发生改变，render tree 就会重新布局，重新来计算所有节点在屏幕的位置。
- repaint：重绘，当 render tree 中任一元素样式属性（几何尺寸没改变）发生改变时，render tree 都会重新画，比如字体颜色，背景等变化。
- paint：遍历 render tree，并调动硬件图形 API 来绘制每个节点。

![paint](../Assets/paint.png)

## 12. 渲染URL 

[跳转](https://github.com/Fettes/Coding-Exercise/blob/master/Basic%20Knowledge/%E5%90%8E%E5%8F%B0%E5%BC%80%E5%8F%91/Computer%20Network.md#5-%E5%9C%A8%E6%B5%8F%E8%A7%88%E5%99%A8%E4%B8%AD%E8%BE%93%E5%85%A5url%E5%9C%B0%E5%9D%80---%E6%98%BE%E7%A4%BA%E4%B8%BB%E9%A1%B5%E7%9A%84%E8%BF%87%E7%A8%8B)
