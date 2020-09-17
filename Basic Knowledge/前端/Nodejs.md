目录
- [1. 全局对象和全局变量](#1-全局对象和全局变量)
  - [1.1 全局对象](#11-全局对象)
  - [1.2 全局函数](#12-全局函数)
  - [1.3 全局变量](#13-全局变量)
- [2. Node特点](#2-node特点)
  - [2.1 单线程](#21-单线程)
  - [2.2 非阻塞I/O](#22-非阻塞io)
  - [2.3 事件驱动event-driven](#23-事件驱动event-driven)
- [3. 模块机制](#3-模块机制)
- [4. 事件循环](#4-事件循环)
  - [4.1 任务队列](#41-任务队列)
  - [4.2 async和await](#42-async和await)
  - [4.3 async/await 能代替Promise吗?](#43-asyncawait-能代替promise吗)
  - [4.4 setTimeout运行机制](#44-settimeout运行机制)


## 1. 全局对象和全局变量

### 1.1 全局对象

所有模块都可以调用的。

- global：表示Node所在的全局环境，类似于浏览器的window对象。

- process：该对象表示Node所处的当前进程，允许开发者与该进程互动。

- console：指向Node内置的console模块，提供命令行环境中的标准输入、标准输出功能。

### 1.2 全局函数

- 定时器函数：共有4个，分别是setTimeout(), clearTimeout(), setInterval(), clearInterval()；
- require：用于加载模块；
- Buffer()：用于操作二进制数据。

### 1.3 全局变量
- __filename：指向当前运行的脚本文件名。
- __dirname：指向当前运行的脚本所在的目录。

## 2. Node特点

### 2.1 单线程
Node.js不为每个客户连接创建一个新的线程，而仅仅使用一个线程。当有用户连接了，就触发一个内部事件，通过非阻塞I/O、事件驱动机制，让Node.js程序宏观上也是并行的。

### 2.2 非阻塞I/O
- 由于Node.js中采用了非阻塞型I/O机制，因此在执行了访问数据库的代码之后，将立即转而执行其后面的代码，把数据库返回结果的处理代码放在回调函数中，从而提高了程序的执行效率。

- 当某个I/O执行完毕时，将以事件的形式通知执行I/O操作的线程，线程执行这个事件的回调函数。为了处理异步I/O，线程必须有事件循环，不断的检查有没有未处理的事件，依次予以处理。

- 阻塞模式下，一个线程只能处理一项任务，要想提高吞吐量必须通过多线程。而非阻塞模式下，一个线程永远在执行计算操作，这个线程的CPU核心利用率永远是100%。所以，这是一种特别有哲理的解决方案：与其人多，但是好多人闲着；还不如一个人玩命，往死里干活儿。

### 2.3 事件驱动event-driven
- 在Node中，在一个时刻，只能执行一个事件回调函数，但是在执行一个事件回调函数的中途，可以转而处理其他事件（比如，又有新用户连接了），然后返回继续执行原事件的回调函数，这种处理机制，称为“事件环”机制。

- Node.js底层是C++（V8也是C++写的）。底层代码中，近半数都用于事件队列、回调函数队列的构建。

## 3. 模块机制

## 4. 事件循环

在执行代码过程中，如果遇到一些异步代码(比如setTimeout,ajax,promise.then以及用户点击等操作),那么浏览器就会将这些代码放到另一个线程(在这里我们叫做幕后线程)中去执行，在前端由浏览器底层执行，在 node 端由 libuv 执行，这个线程的执行不阻塞主线程的执行，主线程继续执行栈中剩余的代码。

当幕后线程（background thread）里的代码执行完成后(比如setTimeout时间到了，ajax请求得到响应),该线程就会将它的回调函数放到任务队列（又称作事件队列、消息队列）中等待执行。

而当主线程执行完栈中的所有代码后，它就会检查任务队列是否有任务要执行，如果有任务要执行的话，那么就将该任务放到执行栈中执行。如果当前任务队列为空的话，它就会一直循环等待任务到来。**因此，这叫做事件循环。**


### 4.1 任务队列

Macrotask（宏任务） 常见的任务：
- setTimeout
- setInterval
- setImmediate
- I/O
- 用户交互操作，UI渲染

Microtask（微任务） 常见的任务：

- Promise(重点)
- process.nextTick(nodejs)
- Object.observe(不推荐使用)
- MutationObserver

执行流程：

1.  检查 Macrotask 队列是否为空,若不为空，则进行下一步，若为空，则跳到3
2.  从 Macrotask 队列中取队首(在队列时间最长)的任务进去执行栈中执行(仅仅一个)，执行完后进入下一步
3.  检查 Microtask 队列是否为空，若不为空，则进入下一步，否则，跳到1（开始新的事件循环）
4.  从 Microtask 队列中取队首(在队列时间最长)的任务进去事件队列执行,执行完后，跳到3

其中，在执行代码过程中新增的microtask任务会在当前事件循环周期内执行，而新增的macrotask任务只能等到下一个事件循环才能执行了。

```
console.log(1)
setTimeout(function() {
  //settimeout1
  console.log(2)
}, 0);

const intervalId = setInterval(function() {
  //setinterval1
  console.log(3)
}, 0)

setTimeout(function() {
  //settimeout2
  console.log(10)
  new Promise(function(resolve) {
    //promise1
    console.log(11)
    resolve()
  })
  .then(function() {
    console.log(12)
  })
  .then(function() {
    console.log(13)
    clearInterval(intervalId)
  })
}, 0);

//promise2
Promise.resolve()
  .then(function() {
    console.log(7)
  })
  .then(function() {
    console.log(8)
  })
console.log(9)

```

第一次事件循环:

- console.log(1)被执行，输出1
- settimeout1执行，加入macrotask队列
- setinterval1执行，加入macrotask队列
- settimeout2执行，加入macrotask队列
- promise2执行，它的两个then函数加入microtask队列
- console.log(9)执行，输出9

根据事件循环的定义，接下来会执行新增的microtask任务，按照进入队列的顺序，执行console.log(7)和console.log(8),输出7和8
microtask队列为空，回到第一步，进入下一个事件循环，此时macrotask队列为: settimeout1,setinterval1,settimeout2

第二次事件循环:

从macrotask队列里取位于队首的任务(settimeout1)并执行，输出2
microtask队列为空，回到第一步，进入下一个事件循环，此时macrotask队列为: setinterval1,settimeout2

第三次事件循环:

从macrotask队列里取位于队首的任务(setinterval1)并执行，输出3,然后又将新生成的setinterval1加入macrotask队列
microtask队列为空，回到第一步，进入下一个事件循环，此时macrotask队列为: **settimeout2,setinterval1**

第四次事件循环:

从macrotask队列里取位于队首的任务(settimeout2)并执行,输出10，并且执行new Promise内的函数(new Promise内的函数是同步操作，并不是异步操作),输出11，并且将它的两个then函数加入microtask队列

从microtask队列中，取队首的任务执行，直到为空为止。因此，两个新增的microtask任务按顺序执行，输出12和13，并且将setinterval1清空。


### 4.2 async和await

async 函数是 Generator 函数的语法糖。使用 关键字 async 来表示，在函数内部使用await 表明当前函数是异步函数 不会阻塞线程导致后续代码停止运行。

```
async function name([param[, param[, ... param]]]) { statements }
```

async 函数的返回值很特殊: 不管在函数体内 return 了什么值, async 函数的实际**返回值总是一个 Promise 对象**.详细讲就是:若在 async 函数中 return 了一个值 a, 不管 a 值是什么类型, async 函数的实际返回值总是** Promise.resolve(a)**


await意思是async wait(异步等待)。这个关键字只能在使用**async定义的函数里面使用**。任何async函数都会默认返回promise，并且这个promise解析的值都将会是这个函数的返回值，而async函数必须等到内部所有的** await 命令的 Promise 对象执行完**，才会发生状态改变>。

```
async function async1(){
    console.log('async1 start')
    await async2()
    console.log('async1 end')
}
async function async2(){
    console.log('async2')
}
console.log('script start')
setTimeout(function(){
    console.log('setTimeout')
},0)
async1();
new Promise(function(resolve){
    console.log('promise1')
    resolve();
}).then(function(){
    console.log('promise2')
})
console.log('script end')
```
```
script start
async1 start
async2
promise1
script end
asycn1 end
promise2
setTimmeout
```

### 4.3 async/await 能代替Promise吗?
```
const timeoutFn = function(value,timeout){
    return new Promise(function(resolve){
        return setTimeout(()=>{resolve(value)},timeout);
    });
}

async function getABC() {
    let A = await timeoutFn(2,2000); // 2 second to finish
    let B = await timeoutFn(2,2000); // 4 second to finish
    let C = await timeoutFn(3,3000); // 3 second to finish
    return A*B*C;
}
getABC()
    .then((res)=>{
        console.log(res)
        //12
    })
```

上述7秒之后输出12，因为三个变量A，B和C不相互依赖,每个调用将等待前一个返回结果

Promise.all（）。这将允许我们同时发送所有请求。，但异步调用将并行触发，而不是一个接一个地触发,3秒之后返回借过12

```
const timeoutFn = function(value,timeout){
    return new Promise(function(resolve){
        return setTimeout(()=>{resolve(value)},timeout);
    });
}

async function getABC() {
    // Promise.all（）允许我们同时发送所有请求。
    let results = await Promise.all([ timeoutFn(2,2000), timeoutFn(2,2000), timeoutFn(3,3000) ]);
    return results.reduce((total,value) => total * value);
}
getABC()
    .then(res => {
        console.log(res)
        //12
    })
```

### 4.4 setTimeout运行机制
setTimeout和setInterval的运行机制是，将指定的代码移出本次执行，等到下一轮Event Loop时，再检查是否到了指定时间。如果到了，就执行对应的代码；如果不到，就等到再下一轮Event Loop时重新判断。这意味着，setTimeout指定的代码，必须等到本次执行的所有代码都执行完，才会执行。

每一轮Event Loop时，都会将“任务队列”中需要执行的任务，一次执行完。setTimeout和setInterval都是把任务添加到“任务队列”的尾部。因此，它们实际上要等到当前脚本的所有同步任务执行完，然后再等到本次Event Loop的“任务队列”的所有任务执行完，才会开始执行。由于前面的任务到底需要多少时间执行完，是不确定的，**所以没有办法保证，setTimeout和setInterval指定的任务，一定会按照预定时间执行。**

```
setTimeout(someTask,100);
veryLongTask();
```

上面代码的setTimeout，指定100毫秒以后运行一个任务。但是，如果后面立即运行的任务（当前脚本的同步任务））非常耗时，过了100毫秒还无法结束，那么被推迟运行的someTask就只有等着，等到前面的veryLongTask运行结束，才轮到它执行。