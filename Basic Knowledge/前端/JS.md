目录
- [1. 数据类型](#1-数据类型)
  - [1.1 typeof可以及检测的数据类型](#11-typeof可以及检测的数据类型)
  - [1.2 instanceof](#12-instanceof)
  - [1.3 JS中===和==的区别 和类型转换？](#13-js中和的区别-和类型转换)
  - [1.4 判断 `[] == ![]`](#14-判断---)
- [2. prototype](#2-prototype)
  - [2.1 原型链](#21-原型链)
  - [2.2 new一个对象的过程](#22-new一个对象的过程)
- [3. 继承](#3-继承)
  - [3.1 原型继承](#31-原型继承)
  - [3.2 构造继承](#32-构造继承)
  - [3.3 寄生组合式继承](#33-寄生组合式继承)
  - [3.4 实例继承](#34-实例继承)
- [4. 闭包](#4-闭包)
  - [4.1 循环中使用闭包解决`var`定义函数的问题](#41-循环中使用闭包解决var定义函数的问题)
- [5. 作用域](#5-作用域)
  - [5.1 js作用域](#51-js作用域)
  - [5.2 变量的查找是就近原则去寻找，定义的var变量](#52-变量的查找是就近原则去寻找定义的var变量)
  - [5.3 作用域链](#53-作用域链)
  - [5.4 判断结果函数名和变量名一样](#54-判断结果函数名和变量名一样)
- [6. this的理解](#6-this的理解)
  - [6.1 setTimeout、setInterval中的this](#61-settimeoutsetinterval中的this)
  - [6.2 严格模式下的this](#62-严格模式下的this)
  - [6.3 call,apply,bind的区别](#63-callapplybind的区别)
- [7. 什么是变量提升？什么是暂时性死区？](#7-什么是变量提升什么是暂时性死区)
- [8. arguments](#8-arguments)
- [9. 循环体](#9-循环体)
  - [9.1 for...of、for...in 和 forEach、map](#91-forofforin-和-foreachmap)
  - [9.2 swtich语句](#92-swtich语句)
- [10. 深拷贝和浅拷贝](#10-深拷贝和浅拷贝)
- [11. 数组](#11-数组)
  - [11.1 判断数组](#111-判断数组)
  - [11.2 类数组](#112-类数组)
  - [11.3 常用方法](#113-常用方法)
  - [11.4 数组去重](#114-数组去重)
  - [11.5 数组最大值](#115-数组最大值)
  - [11.6 数组扁平化](#116-数组扁平化)
- [12. parseInt](#12-parseint)
  - [12.1 ["1", "2", "3"].map(parseInt)](#121-1-2-3mapparseint)
  - [12.2 实现](#122-实现)
- [13. Ajax](#13-ajax)
  - [13.1 自己实现](#131-自己实现)
- [14. ES6](#14-es6)
  - [14.1 let、const 以及 var 的区别](#141-letconst-以及-var-的区别)
  - [14.2 Promise](#142-promise)
  - [14.3 Promise 实现](#143-promise-实现)
    - [14.3.1 主体实现](#1431-主体实现)
    - [14.3.2 then()方法](#1432-then方法)
    - [14.3.3 resolvePromise方法](#1433-resolvepromise方法)
    - [14.3.4 catch()方法](#1434-catch方法)
    - [14.3.5 deferred()方法](#1435-deferred方法)
    - [14.3.6 all()方法](#1436-all方法)
    - [14.3.7 racel()方法](#1437-racel方法)
    - [14.3.8 resolve()方法](#1438-resolve方法)
    - [14.3.9 reject()方法](#1439-reject方法)
  - [14.4 箭头函数](#144-箭头函数)
- [15.Set、Map、WeakSet 和 WeakMap 的区别？](#15setmapweakset-和-weakmap-的区别)
- [16. 事件流和事件委托](#16-事件流和事件委托)
  - [16.1 DOM事件流](#161-dom事件流)
  - [16.2 事件对象](#162-事件对象)
  - [16.3 事件类型](#163-事件类型)
  - [16.4 事件委托](#164-事件委托)

## 1. 数据类型

JavaScript 定义了 7 种数据类型。

原始类型：
1. 数值（Number）
2. 字符串（String）
3. 布尔值（Boolean）
4. undefined
5. null
6. Symbol (ES6新增)

引⽤类型：
- Object 类，如 Date、Array、Function 等。

⾸先原始类型**存储的都是值**，存储在栈内存。是没有函数可以调⽤的，⽐如 undefined.toString()

此时你肯定会有疑问，这不对呀，明明 '1'.toString() 是可以使 ⽤的。其实在这种情况下，'1' 已经不是原始类型了，⽽是被强制 转换成了 String 类型也就是对象类型，所以可以调⽤ toString 函数。

复杂数据类型**存储在堆内存，存储的是地址**。当我们把对象赋值给另外一个变量的时候，复制的是地址，指向同一块内存空间，当其中一个对象改变时，另一个对象也会变化。

在参数传递⽅式上，值类型是按值传递，引⽤类型是按共享传递。

### 1.1 typeof可以及检测的数据类型

- 基本数据类型：Undefined null bool string number
- 关键点：typeof只能区分值类型，不能区分引用类型
- JS中的基本数据类型：null, undefined, bool, string, number（typeof可以区分除了null以外的四种值类型）
- typeof 6种类型：Object({},[],null), Undefined, Boolean, Number, Function, String
- typeof可以区分值类型，typeof null = Object
  - 虽然 typeof null 返回 "object" ，但是 null 不是对象，它是“原始类型”之一。

>总结：
>A. null instanceof Object //false
>
>B. null === undefined  //false
>
>C. null == undefined //true
>
>D. NaN == NaN //false

### 1.2 instanceof
首先 typeof 能够正确的判断基本数据类型，但是除了 null, typeof null输出的是对象。

但是对象来说，typeof 不能正确的判断其类型， typeof 一个函数可以输出 'function',而除此之外，输出的全是 object,这种情况下，我们无法准确的知道对象的类型。

instanceof可以准确的判断复杂数据类型，但是不能正确判断基本数据类型。

instanceof **是通过原型链判断的**，A instanceof B, 在A的原型链中层层查找，是否有原型等于B.prototype，如果一直找到A的原型链的顶端`(null;即Object.prototype.__proto__)`,仍然不等于B.prototype，那么返回false，否则返回true.

```
// L instanceof R
function instance_of(L, R) {//L 表示左表达式，R 表示右表达式
    var O = R.prototype;// 取 R 的显式原型
    L = L.__proto__;    // 取 L 的隐式原型
    while (true) { 
        if (L === null) //已经找到顶层
            return false;  
        if (O === L)   //当 O 严格等于 L 时，返回 true
            return true; 
        L = L.__proto__;  //继续向上一层原型链查找
    } 
}
```

### 1.3 JS中===和==的区别 和类型转换？

== 会进行强制类型转换之后再比较，=== 不会进行强制类型转换的，只有类型相同并且值相等时，才返回 true.

== 如果两者类型不同，首先需要进行类型转换。具体流程如下:

- 首先判断两者类型是否相同，如果相等，判断值是否相等.
- 如果类型不同，进行类型转换
- 判断比较的是否是 null 或者是 undefined, 如果是, 返回 true .
- 判断两者类型是否为 string 和 number, 如果是, 将字符串转换成 number
- 判断其中一方是否为 boolean, 如果是, 将 boolean 转为 number 再进行判断
- 判断其中一方是否为 object 且另一方为 string、number 或者 symbol , 如果是, 将 object 转为原始类型再进行判断

```
let person1 = {
    age: 25
}
let person2 = person1;
person2.gae = 20;
console.log(person1 === person2); //true,注意复杂数据类型，比较的是引用地址
```

### 1.4 判断 `[] == ![]`

我们来分析一下: [] == ![] 是true还是false？

首先，我们需要知道 ! 优先级是高于 == (更多运算符优先级可查看: 运算符优先级)

![] **引用类型转换成布尔值都是true**,因此![]的是false

根据上面的比较步骤中的第五条，其中一方是 boolean，将 boolean 转为 number 再进行判断，false转换成 number，对应的值是 0.

根据上面比较步骤中的第六条，有一方是 number，那么将object也转换成Number,空数组转换成数字，对应的值是0.(空数组转换成数字，对应的值是0，如果数组中只有一个数字，那么转成number就是这个数字，其它情况，均为**NaN**)

0 == 0; 为true


## 2. prototype

JavaScript是一种通过原型实现继承的语言与别的高级语言是有区别的，像java，C#是通过类型决定继承关系的，JavaScript是的动态的弱类型语言。

总之可以认为JavaScript中所有都是对象，在JavaScript中，原型也是一个对象，通过原型可以实现对象的属性继承，JavaScript的对象中都包含了一个"prototype"内部属性，这个属性所对应的就是该对象的原型。

"prototype"作为对象的内部属性，是不能被直接访问的。所以为了方便查看一个对象的原型，Firefox和Chrome内核的JavaScript引擎中提供了"__proto__"这个非标准的访问器（ECMA新标准中引入了标准对象原型访问器"Object.getPrototype(object)"）。原型的主要作用就是**为了实现继承与扩展对象**。

### 2.1 原型链

原型链解决的主要是继承问题。

每个对象拥有一个原型对象，通过 proto (读音: dunder proto) 指针指向其原型对象，并从中继承方法和属性，同时原型对象也可能拥有原型，这样一层一层，最终指向 null(Object.proptotype.__proto__ 指向的是null)。这种关系被称为原型链 (prototype chain)，通过原型链一个对象可以拥有定义在其他对象中的属性和方法。

构造函数 Parent、Parent.prototype 和 实例 p 的关系如下:(p.__proto__ === Parent.prototype)

>原型链的5条规则:
>所有的引用类型（数组，对象，函数），都是具有对象特性的，即可以自由扩展属性（除了null以外）
>
>所有的引用类型（数组、对象、函数），都有一个proto 属性（隐式原型），这个属性的值是一个普通对象
>
>所有的函数，都有一个prototype属性（显式原型），这个属性值是一个普通的对象
>
>所有的引用类型（数组、对象、函数），proto的属性值指向（完全相等）它的构造函数的“prototype”的属性值
>
>当试图得到一个对象的某一个属性的时候，如果一个对象本身没有这个属性的话，就会去它的proto( 也就是它的构造函数中去寻找这个属性)

### 2.2 new一个对象的过程

- 创建一个新对象
- this指向这个新对象
- 执行代码（对this赋值）
- 返回this
```
// v1
  function objectFactory() {
      var obj = new Object(),
          // 因为 shift 会修改原数组，所以 arguments 会被去除第一个参数
          Constructor = [].shift.call(arguments);     // 拿到伪数组中的第一个参数
      // 取出参数中的第一个参数，就是我们要传入的构造函数，建立继承关系
      obj.__proto__ = Constructor.prototype;
      Constructor.apply(obj, arguments);
      return obj;
  }

  // v2 : 还需要判断返回的值是不是一个对象，如果是一个对象，我们就返回这个对象，如果没有，我们该返回什么就返回什么。
  function objectFactory() {
      var obj = new Object(),
          Constructor = [].shift.call(arguments);
      // 建立继承关系(二者之间的关系)
      obj.__proto__ = Constructor.prototype;
      // 开始执行这个构造函数
      var ret = Constructor.apply(obj, arguments);
      // 看一下构造函数的返回值，是对象还是一个基本数据类型?
      return typeof ret === 'object' ? ret : obj;
  }


  // v4：Object.create的原理 (自定义new)
    // var obj = Object.create(Constructor.prototype);
    // 等价于：
    // var obj = new Object();
    // obj.__proto__ = Constructor.prototype;
    const _new = function () {
        var Constructor = [].shift.call(arguments);
        // 1. 创建一个对象，这个对象要继承与构造函数的原型对象
        var obj = Object.create(Constructor.prototype);
        // 2. 执行这个构造函数
        var ret = Constructor.apply(obj, arguments);
        return typeof ret === 'object' ? ret || obj : obj;
    }

    // v5: 实现一个自己的new构造函数
    const _new = function() {
        // 从Object.prototype上克隆一个对象 
        var obj = new Object();
        // 取出来外部传入的构造器
        var Constructor = [].shift.call(arguments);

        // 使用一个中间的函数来维护原型的关系
        var F = function(){};
        F.prototype = Constructor.prototype;
        obj = new F();

        // 开始执行这个构造函数
        var res = Constructor.apply(obj, arguments);
        // 确保构造器总是返回一个对象(使用res || obj 的方式来防止返回null参数)
        return typeof res === 'object' ? res || obj : obj;
    }
```
## 3. 继承

### 3.1 原型继承
基本方法就是一个父类的实例赋值给子类的原型。
```
/**
* 动物类
* @constructor
* */
function Animal (name){
    this.name = name;
    this.eat = function () {
        console.log('My name is ', name, ' I am eating Foods…………');
    }
}

/**
    * 小狗类
    * @constructor
    */
function Dog(){
    this.furColor = furColor;
    this.bark = function () {
        console.log("I am a dog, I am barking……");
    }
}

// 如何让这个小狗继承这个Animal的属性呢？
// 实现思路：每一个函数都有一个prototype属性，这个属性值是一个普通的对象
Dog.prototype = new Animal();
var dog = new Dog('black');

// 这个小狗有eat() 这个属性吗？发现自身没有，那么就会去dog这个对象的__proto__里面去寻找，也就是他的构造函数Dog的prototype上面去寻找

// 发现这个对象Dog构造函数的prototype的值是一个对象new Animal(), 这个对象里面是有eat这个属性的，因此就找到了
dog.eat(); // My name is  undefined  I am eating Foods…………
console.log(dog.__proto__ === Dog.prototype);       // true
```

这个继承方式是通过__proto__建立和子类之间的原型链，当子类的实例需要使用父类的属性和方法的时候，可以通过__proto__一级级向上找；

缺点：

1. 创建子类实例时，无法向父类构造函数传参。Animal类中的name属性为undefined，说明没有被赋值。因为无法调用父类的构造函数并传参。

2. Animal类的私有属性被所有实例共享。来自父类Animal中的私有属性name被放到了Dog类的原型，导致name属性被所有实例所共享。

```
//....省略dog和Animal类
let blackTom = new Dog('black');
let whiteTtom = new Dog('white');

blackTom.__proto__.name = 'blackTom';
whiteTtom.__proto__.name  = 'whiteTtom';
console.log(blackTom.name) //whiteTtom
console.log(whiteTtom.name)//whiteTtom
```

而我们希望达到的效果是**继承父类的私有属性到子类的私有属性**和**继承父类的原型属性到子类的原型属性**。

**为了解决这两种问题，我们还有一种方法就是在构造函数继承。**

### 3.2 构造继承
```
function Animal(name) {
  this.name = name; 
}

Animal.prototype.eat= function () {
  console.log(this.name + '正在吃东西')
};
function Cat(furColor){ 
   Animal.call(this,'小花猫');
   this.furColor = furColor ;
};

let tom = new Cat('black');
console.log(tom);
```

这里解决了上述的两个问题，第一无法向构造函数传参的问题，第二Animal的私有属性被共享的问题。但是又产生了新的问题

缺点：
1. 没有继承父类的原型，有些方法比如eat方法无法使用
2. 实例并不是父类的实例，只是子类的实例，原因也是因为没有继承Animal的原型

```
console.log(tom instanceof Animal); // false
console.log(tom instanceof Cat); // true
```

### 3.3 寄生组合式继承
```
function Animal(name = 'animal') {
  this.name = name ; 
}
Animal.prototype.eat= function () {
  console.log(this.name + '正在吃东西')
};
function Cat(furColor){ 
   Animal.call(this,'小花猫');
   this.furColor = furColor ;
};

(function (subType,superType){
	let prototype = Object.create(superType.prototype);//创建对象
	prototype.constructor = subType;//还原它本身构造指向
	subType.prototype = prototype;//赋值原型
})(Cat,Animal)

let tom = new Cat('black');
console.log(tom);
```

通过再制造一个临时对象的方式，然后把它的私有属性清除，只指向它自己的原型属性，这样就完美了~

### 3.4 实例继承
```
function Animal(name = 'animal') {
  this.name = name ; 
}
Animal.prototype.eat= function () {
  console.log(this.name + '正在吃东西')
};
function Cat(furColor){ 
   let instance  = new Animal("小花猫")
   instance .furColor = furColor ;
   return instance ;
};
let tom = new Cat('black');
console.log(tom);
```
实例继承的基本思路是创建父类实例，然后再做修改返回。

缺点：

实例是父类的实例，不是子类的实例。
```
console.log(tom instanceof Animal); // true
console.log(tom instanceof Cat); // false
```
## 4. 闭包

闭包的定义其实很简单：函数 A 内部有一个函数 B，函数 B 可以访问到函数 A 中的变量，那么函数 B 就是闭包。

```
function A(){                 
    let a=1;                 
    window.B=function(){                     
        console.log(a)                 
    }            
}            
A();            
B();//1
```
**在 JS 中，闭包存在的意义就是让我们可以间接访问函数内部的变量。**

### 4.1 循环中使用闭包解决`var`定义函数的问题

需求：每隔一秒输出一个数字，从 0 - 5；
```
for(var i=0;i<=5;i++){            
    setTimeout(function timer(){                
        console.log(i)            
    },i*1000)        
}        
console.log(i)

```
输出结果：立即输出一个6，然后每隔一秒输出一个6；

首先因为 setTimeout 是个异步函数，所以会先把循环全部执行完毕，这时候 i 就是 6 了，所以会输出一堆 6。

解决办法有3种。

1. 闭包

```
for(var i=0;i<=5;i++){            
    (function(j){                
        setTimeout(function timer(){                    
            console.log(j)                
        },j*1000)            
    })(i)        
}
```

在上述代码中，我们首先使用了立即执行函数将 i 传入函数内部，这个时候值就被固定在了参数 j上面不会改变，当下次执行 timer 这个闭包的时候，就可以使用外部函数的变量 j，从而达到目的。

2. 使用 setTimeout 的第三个参数

```
for(var i=0;i<=5;i++){           
    setTimeout((j) => {                
        console.log(j);            
    },i*1000,i)        
}

```

3. let 定义 i
```
for(let i=0;i<=5;i++){                
    setTimeout(() => {                    
        console.log(i)                
    },i*1000)            
}

```
## 5. 作用域
ES6 之前 JS 没有块级作⽤域。例如 
```
if (true) {
    var name = 'zhangsan'
}
console.log(name)
```

从上⾯的例⼦可以体会到作⽤域的概念，作⽤域就是⼀个独⽴的地盘，让变量不会外泄、暴露出去。

上⾯的 name 就被暴露出去了，因此，JS 没有块级作⽤域，只有全局作⽤域和函数作⽤域。

但是 ES6 中开始加⼊了块级作⽤域，使⽤ let 定义变量即可。
```
if (true) {
 let name1 = 'zhangsan'
}
console.log(name1) // 报错，因为let定义的name是在if这个块级作⽤域
```

### 5.1 js作用域
全局作用域和函数作用域。内部可以访问外部，但外部的不能访问内部的。
```
var a=10;        
function aaa(){             
    alert(a);        
};        
aaa();//10
```
```
function aaa(){            
    var a=10;          
};        
aaa();        
console.log(a)//Uncaught ReferenceError: a is not defined
```
```
var a=10;         
function aaa(){             
    console.log(a);//10        
};                    
function bbb(){            
    var a=20;            
    aaa();        
}        
bbb();//10
```
```
function aaa(){            
    a=10;         
}        
aaa();        
function aaa(){            
    var a=b=10;         
}      
aaa();      
console.log(b)//10    
console.log(a)//Uncaught ReferenceError: a is not defined
```
### 5.2 变量的查找是就近原则去寻找，定义的var变量
```
function aaa(){            
console.log(a);//undefined            
var a=20;        
}        
aaa(); 
```
```
var a=10;        
function aaa(){            
    console.log(a);//undefined            
    var a=20;        
}        
aaa();
```
```
var a=10;        
function aaa(a){             
    console.log(a);//10            
    var a=20;  //因为 a 是形参，优先级高于 var a; 所以 局部变量a的声明其实被忽略了。        
}         
aaa(a);
```

### 5.3 作用域链
⾸先认识⼀下什么叫做**自由变量**。如下代码中， console.log(a) 要得到 a 变量，但是在当前的作⽤域中没有定义 a （可对⽐⼀下 b ）。当前作⽤域没有定义的变量，这成为 ⾃由变量 。⾃由变量如何得到 —— 向⽗级作⽤域寻找。

```
var a = 100;
function fn() {
    var b = 200;
    console.log(a);
    console.log(b);
};
fn();
```
如果⽗级也没呢？再⼀层⼀层向上寻找，直到找到全局作⽤域还是没找到，就宣布放弃。这种⼀层⼀ 层的关系，就是 作⽤域链 。
```
var a = 100;
function F1() {
    var b = 200;
    function F2() {
        var c = 300;
        console.log(a) // ⾃由变量，顺作⽤域链向⽗作⽤域找
        console.log(b) // ⾃由变量，顺作⽤域链向⽗作⽤域找
        console.log(c) // 本作⽤域的变量
    };
    F2();
};
F1();
```

### 5.4 判断结果函数名和变量名一样
```
var a = 1;        
(function a () {            
    a = 2;            
    console.log(a);        
})();
// 输出结果
ƒ a () {
           a = 2;
           console.log(a);
       }
```

立即调用的函数表达式（IIFE） 有一个 自己独立的 作用域，如果函数名称与内部变量名称冲突，就会永远执行函数本身；所以上面的结果输出是函数本身；

函数表达式中的函数名称，只有自己独立的作用域可以拿到，不会影响全局

```
var a = 1;        
(function a () {            
    a = 2;            
    console.log(window.a);        
})();
// 1
```
```
var a = 1;        
(function x () {            
    a = 2;            
    console.log(a);        
})();
// 2
```
     
## 6. this的理解
- 作为构造函数执行
- 作为对象属性执行
- 作为普通函数执行
- call apply bind

### 6.1 setTimeout、setInterval中的this
```
var obj ={ 
    fn:function(){
        console.log(this);
    }
}
function fn2(){
    console.log(this);
}
setTimeout(obj.fn, 0);   //Window
setTimeout(fn2, 0);//Window
setInterval( obj.fn,1000 );//Window
```

从上述例子中可以看到setTimeout,setInterval中函数内的this是指向了window对象，这是由于setTimeout()，setInterval()调用的代码运行在与所在函数完全分离的执行环境上。这会导致这些代码中包含的 this 关键字会指向**window (或全局)对象。**

### 6.2 严格模式下的this
- 全局作用域中的this: 在严格模式下的全局作用域中 this 指向window对象
- 全局作用域中函数中的this: 严格模式下： 在全局作用域中函数的 this 指向 undefined
- 对象的方法中的this: 严格模式下，对象的函数中的this指向该对象
- 构造函数中的this: 严格模式下，构造函数中的this指向new出来的对象

### 6.3 call,apply,bind的区别
- 相同点：
  
  - 三个函数都会改变this的指向（调用这三个函数的函数内部的this）

- 不同点
  - bind会产生新的函数，（把对象和函数绑定死后，产生新的函数）
  - call和apply不会产生新的函数，只是在调用时，绑定一下而已。
  - call和apply的区别，第一个参数都是要绑定的this，apply第二个参数是数组（是函数的所有参数），call把apply的第二个参数单列出来。

## 7. 什么是变量提升？什么是暂时性死区？

变量提升就是变量在声明之前就可以使用，值为undefined。

在代码块内，使用 let/const 命令声明变量之前，该变量都是不可用的(会抛出错误)。这在语法上，称为“暂时性死区”。暂时性死区也意味着 typeof 不再是一个百分百安全的操作。
```
typeof x; // ReferenceError(暂时性死区，抛错)
let x;
```
```
typeof y; // 值是undefined,不会报错
```
暂时性死区的本质就是，只要一进入当前作用域，所要使用的变量就已经存在了，但是不可获取，只有等到声明变量的那一行代码出现，才可以获取和使用该变量。

## 8. arguments
由于 JavaScript 允许函数有不定数目的参数，所以需要一种机制，可以在函数体内部读取所有参数。这就是arguments对象的由来。

arguments对象包含了函数运行时的所有参数，arguments[0]就是第一个参数，arguments[1]就是第二个参数，以此类推。这个对象只有在函数体内部，才可以使用。

还可以进行修改：

<img src="../Assets/arguments_1.png" width="300">

严格模式下，arguments对象与函数参数不具有联动关系。也就是说，修改arguments对象不会影响到实际的函数参数。

<img src="../Assets/arguments_2.png" width="300">

通过arguments对象的length属性，可以判断函数调用时到底带几个参数。

## 9. 循环体
### 9.1 for...of、for...in 和 forEach、map
- for...of 循环：
  - 具有 iterator 接口，就可以用 for...of 循环遍历它的成员（属性值）。
  - for...of 循环可以使用的范围包括数组、Set 和 Map 结构、某些类似数组的对象、Generator 对象，以及字符串。 
  - for...of 循环调用遍历器接口，数组的遍历器接口只返回具有数字索引的属性。对于普通的对象， for...of 结构不能直接使用，会报错，必须部署了Iterator 接口后才能使用。可以中断循环。
- for...in 循环：遍历对象自身的和继承的可枚举的属性, 不能直接获取属性值。可以中断循环。
- forEach: 只能遍历数组，不能中断，没有返回值(或认为返回值是undefined)。
    ```
    const a = [1, 2, 3];
    const doubled = a.forEach((num, index) => {
    // 执行与 num、index 相关的代码
    });

    console.log(doubled) // undefined
    ```
- 只能遍历数组，不能中断，返回值是修改后的数组。
    ```
    const a = [1, 2, 3];
    const doubled = a.map(num => {
    return num * 2;
    });

    console.log(doubled) // [2, 4, 6]
    ```
### 9.2 swtich语句
```
var   x=prompt("请输入1-5的数字","");                     
switch (x) {                            
    case “1”:alert(“one”);                            
    case “2”:alert(“two”);                            
    case “3”:alert(“three”);                            
    case “4”:alert(“four”);                            
    case “5”:alert(“five”);                            
    default:alert(“none”);
}
//four,five,none
```

因为执行完之后，没有加break，会一直往下执行代码。

## 10. 深拷贝和浅拷贝
浅拷贝是指只复制第一层对象，但是当对象的属性是引用类型时，实质复制的是其引用，当引用指向的值改变时也会跟着变化。

深拷贝复制变量值，对于非基本类型的变量，则递归至基本类型变量后，再复制。深拷贝后的对象与原来的对象是完全隔离的，互不影响，对一个对象的修改并不会影响另一个对象。

实现一个深拷贝:
```
function deepClone(obj) { //递归拷贝
    if(obj === null) return null; //null 的情况
    if(obj instanceof RegExp) return new RegExp(obj);
    if(obj instanceof Date) return new Date(obj);
    if(typeof obj !== 'object') {
        //如果不是复杂数据类型，直接返回
        return obj;
    }
    /**
     * 如果obj是数组，那么 obj.constructor 是 [Function: Array]
     * 如果obj是对象，那么 obj.constructor 是 [Function: Object]
     */
    let t = new obj.constructor();
    for(let key in obj) {
        //如果 obj[key] 是复杂数据类型，递归
        t[key] = deepClone(obj[key]);
    }
    return t;
}
```

## 11. 数组

### 11.1 判断数组

- 使用 Array.isArray 判断，如果返回 true, 说明是数组
- 使用 instanceof Array 判断，如果返回true, 说明是数组
- 使用 Object.prototype.toString.call 判断，如果值是 [object Array], 说明是数组
- 通过 constructor 来判断，如果是数组，那么 arr.constructor === Array. (不准确，因为我们可以指定 obj.constructor = Array)

```
function fn() {
    console.log(Array.isArray(arguments));   //false; 因为arguments是类数组，但不是数组
    console.log(Array.isArray([1,2,3,4]));   //true
    console.log(arguments instanceof Array); //false
    console.log([1,2,3,4] instanceof Array); //true
    console.log(Object.prototype.toString.call(arguments)); //[object Arguments]
    console.log(Object.prototype.toString.call([1,2,3,4])); //[object Array]
    console.log(arguments.constructor === Array); //false
    arguments.constructor = Array;
    console.log(arguments.constructor === Array); //true
    console.log(Array.isArray(arguments));        //false
}
fn(1,2,3,4);
```

### 11.2 类数组

1）拥有length属性，其它属性（索引）为非负整数（对象中的索引会被当做字符串来处理）;

2）不具有数组所具有的方法；

- 类数组是一个普通对象，而真实的数组是Array类型。
- 常见的类数组有: 函数的参数 arugments, DOM 对象列表(比如通过 document.querySelectorAll 得到的列表), jQuery 对象 (比如 $("div")).

类数组可以转换为数组:
```
//第一种方法
Array.prototype.slice.call(arrayLike, start);
//第二种方法
[...arrayLike];
//第三种方法:
Array.from(arrayLike);
```

PS: 任何定义了遍历器（Iterator）接口的对象，都可以用扩展运算符转为真正的数组。

Array.from方法用于将两类对象转为真正的数组：类似数组的对象（array-like object）和可遍历（iterable）的对象。

### 11.3 常用方法

修改原数组的API有:

splice/reverse/fill/copyWithin/sort/push/pop/unshift/shift

不修改原数组的API有:

slice/map/forEach/every/filter/reduce/entries/find


### 11.4 数组去重

```
function qc(arr1) {
    let arr = [];
    for(let i=0; i<arr1.length; i++) {
        if(arr.indexOf(arr1[i]) == -1) {
            arr.push(arr1[i])
        }
    }
    return arr;
}
arr1 = ["1", "1", "3", "5", "2", "24", "4", "4", "a", "a", "b"];
console.log(qc(arr1)); // ["1", "3", "5", "2", "24", "4", "a", "b"]
```

### 11.5 数组最大值
```
// ES5 的写法
Math.max.apply(null, [14, 3, 77, 30]);

// ES6 的写法
Math.max(...[14, 3, 77, 30]);

// reduce
[14, 3, 77, 30].reduce((accumulator, currentValue) => {
return accumulator = accumulator > currentValue ? accumulator : currentValu
});
```

### 11.6 数组扁平化
```
var array = [1, [2], [3, [4, [5]]]]

function flat(arr) {
// 补全
}

console.log(flat(array)) // [1, 2, 3, 4, 5]
```
```
// 原始方法
var array = [1, [2], [3, [4, [5]]]]
function flat() {
    var flatArr = []
    return function flatten(arr) {
        for(var index=0; index<arr.length; index++) {
            Array.isArray(arr[index]) ? flatten(arr[index]) : flatArr.push(arr[index])
        }
        return flatArr
    }
}

console.log(flat()(array))

// toString 方法
var array = [1, [2], [3, [4, [5]]]]
function flat(arr) {
    return arr.toString().split(",").map(function(val) {return +val;})
    // “+val”：如果只有一个“字符串”操作数的时候，会尝试将这个“字符串”转换为“数字”。
}

console.log(flat(array))
```

## 12. parseInt

### 12.1 ["1", "2", "3"].map(parseInt)

答案是 [1, NaN, NaN] 。因为 parseInt 需要两个参数 (val, radix) ，其中 radix 表示解析时用的基数。

map 传了 3 个 (element, index, array) ，对应的 radix 不合法导致解析失败。


### 12.2 实现
```
function _parseInt(str, radix) {
    let str_type = typeof str;
    let res = 0;
    if (str_type !== 'string' && str_type !== 'number') {
        // 如果类型不是 string 或 number 类型返回NaN
        return NaN
    }

    // 字符串处理
    str = String(str).trim().split('.')[0]
    let length = str.length;
    if (!length) {
        // 如果为空则返回 NaN
        return NaN
    }

    if (!radix) {
        // 如果 radix 为0 null undefined
        // 则转化为 10
        radix = 10;
    }
    if (typeof radix !== 'number' || radix < 2 || radix > 36) {
        return NaN
    }

    for (let i = 0; i < length; i++) {
        let arr = str.split('').reverse().join('');
        res += Math.floor(arr[i]) * Math.pow(radix, i)
    }

    return res;
}
```

## 13. Ajax
AJAX全称为“Asynchronous JavaScript And XML”（异步JavaScript和XML） 是指一种创建交互式网页应用的开发技术、改善用户体验，实现无刷新效果。

优点

a、不需要插件支持

b、优秀的用户体验

c、提高Web程序的性能

d、减轻服务器和带宽的负担

缺点

a、浏览器对XMLHttpRequest对象的支持度不足，几乎所有浏览器现在都支持

b、破坏浏览器“前进”、“后退”按钮的正常功能，可以通过简单的插件弥补

c、对搜索引擎的支持不足


### 13.1 自己实现
```
// 创建对象
var xhr = new XMLHttpRequest();

// 打开连接GET请求，请求地址，是否同步
xhr.open('GET', '/JS-Professional/data.json', false);

xhr.onreadyStateChange = function () {
// readyState状态码：
    // 0- （未初始化）：还没有调用send（）方法
    // 1- （载入）：已经调用send（）方法，正在发送请求
    // 2- （载入完成）：send（）方法执行完成，已经接收到全部响应内容
    // 3. （交互）正在解析响应的内容
    // 4. （完成）响应内容解析完成，可以在客户端调用了

    // 2** - 表示成功处理请求，如200
    // 3** - 需要重定向，浏览器直接跳转，如301
    // 4** - 客户端请求错误，如404
    // 5** - 服务端错误，如500

    if (xhr.readyState === 4){
        //  此时表示请求已经发送成功(已经接受到服务端返回的信息)
        if (xhr.status === 200){
            console.log('请求发送成功', xhr.responseText)
        }
    }
}
xhr.send(null);
```


## 14. ES6

### 14.1 let、const 以及 var 的区别

- let 和 const 定义的变量不会出现变量提升，而 var 定义的变量会提升。
- let 和 const 是JS中的块级作用域
- let 和 const 不允许重复声明(会抛出错误)
- let 和 const 定义的变量在定义语句之前，如果使用会抛出错误(形成了暂时性死区)，而 var 不会。
- const 声明一个只读的常量。一旦声明，常量的值就不能改变(如果声明是一个对象，那么不能改变的是对象的引用地址)

### 14.2 Promise

ES6 原生提供了Promise 对象。

所谓 Promise，就是一个对象，用来传递异步操作的消息。它代表了某个未来才会知道结果的事件（通常是一个异步操作），并且这个事件提供统一的 API，可供进一步处理。

Promise 对象有以下两个特点。
1.  对象的状态不受外界影响。Promise 对象代表一个异步操作，有三种状态：Pending（进行中）、Resolved（已完成，又称 Fulfilled）和 Rejected（已失败）。只有异步操作的结果，可以决定当前是哪一种状态，任何其他操作都无法改变这个状态。这也是 Promise 这个名字的由来，它的英语意思就是「承诺」，表示其他手段无法改变。
   
2.  一旦状态改变，就不会再变，任何时候都可以得到这个结果。Promise 对象的状态改变，只有两种可能：从 Pending 变为 Resolved 和从 Pending 变为 Rejected。只要这两种情况发生，状态就凝固了，不会再变了，会一直保持这个结果。就算改变已经发生了，你再对 Promise 对象添加回调函数，也会立即得到这个结果。这与事件（Event）完全不同，事件的特点是，如果你错过了它，再去监听，是得不到结果的。
   
有了 Promise对象，就可以将异步操作以同步操作的流程表达出来，避免了层层嵌套的回调函数。此外，Promise 对象提供统一的接口，使得控制异步操作更加容易。

Promise 也有一些缺点。首先，无法取消 Promise，一旦新建它就会立即执行，无法中途取消。其次，如果不设置回调函数，Promise 内部抛出的错误，不会反应到外部。第三，当处于 Pending 状态时，无法得知目前进展到哪一个阶段（刚刚开始还是即将完成）。

### 14.3 Promise 实现

#### 14.3.1 主体实现
```
const PENDING =  'pending';//初始态
const FULFILLED =  'fulfilled';//初始态
const REJECTED =  'rejected';//初始态

function Promise(executor){
  let self = this; //先缓存当前promise实例
  self.status = PENDING;//设置状态
  //定义存放成功的回调的数组
  self.onResolvedCallbacks = [];
  //定义存放失败回调的数组
  self.onRejectedCallbacks = [];
  //当调用此方法的时候，如果promise状态为pending,的话可以转成成功态,如果已经是成功态或者失败态了，则什么都不做
 
  //2.1 定义resolve方法;
  function resolve(value){  
    if(value!=null &&value.then&&typeof value.then == 'function'){
      return value.then(resolve,reject);
    }
    //如果是初始态，则转成成功态
    //为什么要把它用setTimeout包起来
    setTimeout(function(){
      if(self.status == PENDING){
        self.status = FULFILLED;
        self.value = value;//成功后会得到一个值，这个值不能改
        //调用所有成功的回调
        self.onResolvedCallbacks.forEach(cb=>cb(self.value));
      }
    })
  }

  //2.1.2 定义reject方法;
  function reject(reason){ 
    setTimeout(function(){
      //如果是初始态，则转成失败态
      if(self.status == PENDING){
        self.status = REJECTED;
        self.value = reason;//失败的原因给了value
        self.onRejectedCallbacks.forEach(cb=>cb(self.value));
      }
    });
  }
  try{
    //因为此函数执行可能会异常，所以需要捕获，如果出错了，需要用错误 对象reject
    executor(resolve,reject);
  }catch(e){
    //如果这函数执行失败了，则用失败的原因reject这个promise
    reject(e);
  };
}

```

#### 14.3.2 then()方法
```
//onFulfilled 是用来接收promise成功的值或者失败的原因
Promise.prototype.then = function(onFulfilled,onRejected){
  //如果成功和失败的回调没有传，则表示这个then没有任何逻辑，只会把值往后抛
  //2.2.1
  onFulfilled = typeof onFulfilled == 'function'?onFulfilled:function(value){return  value};
  onRejected = typeof onRejected == 'function'?onRejected:reason=>{throw reason};
  //如果当前promise状态已经是成功态了，onFulfilled直接取值
  let self = this;
  let promise2;
  if(self.status == FULFILLED){
    return promise2 = new Promise(function(resolve,reject){
      setTimeout(function(){
        try{
          let x =onFulfilled(self.value);
          //如果获取到了返回值x,会走解析promise的过程
          resolvePromise(promise2,x,resolve,reject);
        }catch(e){
          //如果执行成功的回调过程中出错了，用错误原因把promise2 reject
          reject(e);
        }
      })

    });
  }
  if(self.status == REJECTED){
    return promise2 = new Promise(function(resolve,reject){
      setTimeout(function(){
        try{
          let x =onRejected(self.value);
          resolvePromise(promise2,x,resolve,reject);
        }catch(e){
          reject(e);
        }
      })
    });
  }
  if(self.status == PENDING){
   return promise2 = new Promise(function(resolve,reject){
     self.onResolvedCallbacks.push(function(){
         try{
           let x =onFulfilled(self.value);
           //如果获取到了返回值x,会走解析promise的过程
           resolvePromise(promise2,x,resolve,reject);
         }catch(e){
           reject(e);
         }

     });
     self.onRejectedCallbacks.push(function(){
         try{
           let x =onRejected(self.value);
           resolvePromise(promise2,x,resolve,reject);
         }catch(e){
           reject(e);
         }
     });
   });
  }

}

```

#### 14.3.3 resolvePromise方法

```
function resolvePromise(promise2,x,resolve,reject){
  if(promise2 === x){
    return reject(new TypeError('循环引用'));
  }
  let called = false;//promise2是否已经resolve 或reject了
  if(x instanceof Promise){
    if(x.status == PENDING){
      x.then(function(y){
        resolvePromise(promise2,y,resolve,reject);
      },reject);
    }else{
      x.then(resolve,reject);
    }
  //x是一个thenable对象或函数，只要有then方法的对象，
  }else if(x!= null &&((typeof x=='object')||(typeof x == 'function'))){
    //当我们的promise和别的promise进行交互，编写这段代码的时候尽量的考虑兼容性，允许别人瞎写
   try{
     let then = x.then;
     if(typeof then == 'function'){
       //有些promise会同时执行成功和失败的回调
       then.call(x,function(y){
         //如果promise2已经成功或失败了，则不会再处理了
          if(called)return;
          called = true;
          resolvePromise(promise2,y,resolve,reject)
       },function(err){
         if(called)return;
         called = true;
         reject(err);
       });
     }else{
       //到此的话x不是一个thenable对象，那直接把它当成值resolve promise2就可以了
       resolve(x);
     }
   }catch(e){
     if(called)return;
     called = true;
     reject(e);
   }

  }else{
    //如果X是一个普通 的值，则用x的值去resolve promise2
    resolve(x);
  }
}

```

#### 14.3.4 catch()方法
```
//catch原理就是只传失败的回调
Promise.prototype.catch = function(onRejected){
  this.then(null,onRejected);
}
```

#### 14.3.5 deferred()方法
```
Promise.deferred = Promise.defer = function(){
  let defer = {};
  defer.promise = new Promise(function(resolve,reject){
    defer.resolve = resolve;
    defer.reject = reject;
  });
  return defer;
}
```

#### 14.3.6 all()方法
```
//Promise的all方法提供了并行执行异步操作的能力，并且在所有异步操作执行完后才执行回调。

Promise.all = function(promises){
 return new Promise(function(resolve,reject){
   let done = gen(promises.length,resolve);
   for(let i=0;i<promises.length;i++){
     promises[i].then(function(data){
       done(i,data);
     },reject);
   }
 });
}

function gen(times,cb){
  let result = [],count=0;
  return function(i,data){
    result[i] = data;
    if(++count==times){
      cb(result);
    }
  }
}
```

#### 14.3.7 racel()方法
```
Promise.race = function(promises){
  return new Promise(function(resolve,reject){
    for(let i=0;i<promises.length;i++){
      promises[i].then(resolve,reject);
    }
  });
}

//返回一个立刻成功的promise
//别人提供 给你一个方法，需要你传入一个promise,但你只有一个普通的值，你就可以通过这个方法把这个普通的值(string number object)转成一个promise对象
```

#### 14.3.8 resolve()方法
```
Promise.resolve = function(value){
  return new Promise(function(resolve){
    resolve(value);
  });
}
```

#### 14.3.9 reject()方法
```
//返回一个立刻失败的promise
Promise.reject = function(reason){
  return new Promise(function(resolve,reject){
    reject(reason);
  });
}
```

### 14.4 箭头函数

箭头函数
```
let sum = (a, b) => {
    return a + b;
}
```

普通函数
```
var sum = function (a, b){
    return a + b;
}
```
- 14.4.1 this的指向

    箭头函数的this指向的是父级作用域的this，是通过查找作用域链来确定 this 的值也就是说，看的是上下文的this，指向的是定义它的对象，而不是使用时所在的对象；普通函数指向的是它的直接调用者。
    ```
    let obj = {
            a: 1,
            b: () => {
                console.log(this.a); // undefined
            },
            c: function() {
                console.log(this.a); // 1 
            },
        };
    obj.b();
    obj.c();
    ```
    箭头函数没有this，它的this是继承来的，默认指向定义它的时候的对象，就是我们说的宿主对象，而不是执行它的对象。这里通过obj.b()，此时this指向的window对象，上面没有a，所以返回undefined。通过obj.c(),this指向的是它的直接调用者，就是obj，所以返回1。

- 不可以被当作构造函数
  
    不能被当作构造函数来使用，通过new命令来作为构造函数会报错，这里没有构建原型的说法，不存在prototype这个属性，也不能通过super访问原型的属性，而且new target也是不能用的。

- arguments问题
不可以使用arguments对象，该对象在函数体内不存在，如果要用就用rest参数替代。

- 不可以使用yield命令，因此箭头函数不能用作 Generator 函数。

## 15.Set、Map、WeakSet 和 WeakMap 的区别？
1、Set

- 成员唯一、无序且不重复；
- [value, value]，键值与键名是一致的（或者说只有键值，没有键名）；
- 可以遍历，方法有：add、delete、has、clear、entries、forEach、keys、values
- Set 也能用来保存 NaN 和 undefined， 如果有重复的 NaN， Set 会认为就一个 NaN(实际上 NaN!=NaN);

2、Map

- 本质上是键值对的集合，类似集合；
- 可以遍历，方法很多，可以跟各种数据格式转换。

3、WeakSet

- 成员都是对象；
- 成员都是弱引用，可以被垃圾回收机制回收，可以用来保存 DOM 节点，不容易造成内存泄漏；
- 不能遍历，方法有 add、delete、has。

4、WeakMap

- 只接受对象作为键名（null 除外），不接受其他类型的值作为键名；
- 键名是弱引用，键值可以是任意的，键名所指向的对象可以被垃圾回收，此时键名是无效的；
- 不能遍历，方法有 get、set、has、delete。

## 16. 事件流和事件委托

javascript和HTML之间的交互是通过事件实现的。

事件就是用户或浏览器自身执行的某种动作，比如点击、加载，鼠标移入移出等等。

### 16.1 DOM事件流

DOM(文档对象模型)结构是一个树形结构，当一个HTML元素产生一个事件时，该事件会在元素结点与根节点之间按特定的顺序传播，路径所经过的节点都会收到该事件，这个传播过程可称为DOM事件流。

事件流描述的是从页面中接收事件的顺序。

事件冒泡：IE的事件流叫 事件冒泡，即事件开始时由最具体的元素接收，然后逐级向上传播到较为不具体的节点。自下而上。

事件捕获：是不太具体的节点先接收到事件，而最具体的节点应该最后接收到事件。自上而下。

DOM事件流：包括三个阶段：

- 事件捕获阶段：该阶段的主要作用是捕获截取事件
- 处于目标阶段：一般地，该阶段具有双重范围，即捕获阶段的结束，冒泡阶段的开始；
- 事件冒泡阶段：主要作用是将目标元素绑定事件执行的结果返回给浏览器，处理不同浏览器之间的差异，主要在该阶段完成

<img src="../Assets/event.png" width="500">

### 16.2 事件对象
在触发DOM上的某个事件时，会产生一个事件对象event，该对象包含所有与事件有关的信息。
```
var btn = document.getElementById("juejin")
btn.onclick = function(event){
  console.log(event) 
}
```

常用属性：

- target 事件的目标
- currentTarget 绑定事件的元素，与 'this' 的指向相同
- stopPropagation() 取消事件的进一步捕获或冒泡。如果bubbles为true，则可以使用这个方法
- stopImmediatePropagation() 取消事件的进一步捕获或冒泡，同时阻止任何事件处理程序被调用（DOM3级事件中新增）
- preventDefault() 取消事件的默认行为，比如点击链接跳转。如果 cancelable 是 true，则可以使用这个方法
- type 被触发的事件类型
- eventPhase 调用事件处理程序的阶段：0表示这个时间没有事件正在被处理，1表示捕获阶段，2表示“处于目标”，3表示冒泡阶段

### 16.3 事件类型

- UI (User Interface) 事件，当用户与页面上的元素交互时触发
  - load、unload、error、select、resize、scroll

- 焦点事件，在页面获得或失去焦点时触发
  - blur、focusout  失去焦点
  - focus、focusin  获得焦点

- 鼠标事件，用户通过鼠标在页面执行操作时触发
    - click、dbclick、mousedown、mouseup
    - mouseenter、mouserleave
    - mousemove
    - mouseout、mouseover
    点击和双击事件触发的顺序如下
    - mousedown
    - mouseup
    - click
    - mousedown
    - mouseup
    - dbclick

- 滚轮事件，当使用鼠标滚轮操作时触发
    - mousewheel
- 文本事件，在文档中输入文本时触发
    - textInput 当用户在可编辑区域中输入字符时，就会触发这个事件
- 键盘事件，当用户通过键盘在页面上执行操作时触发
    - keydown 按下键盘任意键时触发，不松开，则一直触发
    - keypress 按下键盘上的字符键时触发，不松开，则一直触发
    - Keyup 用户释放键盘上的建时触发
- HTML5事件
    - contextmenu 事件：单价鼠标右键可以调出上下文菜单
    - beforeunload 事件：在浏览器卸载页面之前触发
    - DOMContentLoad 事件：在形成完整的DOM树之后就会触发。
    - readystatechange 事件：提供与文档加载状态有关的信息
    - pageshow和pagehide 事件：页面显示和隐藏时触发
    - hashchange 事件 : hash改变时触发

### 16.4 事件委托
事件委托是为了解决事件处理程序过多造成的内存和性能问题。那么什么是事件委托呢？

就是利用事件冒泡,只指定一个事件处理程序，就可以管理某一类型的所有事件。

作用：

- 支持为同一个DOM元素注册多个同类型事件
- 可将事件分为事件捕获和事件冒泡

用addEventListener(type,listener,useCapture)实现

- type: 必须,String类型,事件类型
- listener: 必须,函数体或者JS方法
- useCapture: 可选,boolean类型。指定事件是否发生在捕获阶段。默认为false,事件发生在冒泡阶段

```
<div id="div1"></div>

window.onload = function(){
    let div1 = document.getElementById('div1');
    div1.addEventListener('click',function(){
        console.log('打印第一次')
    })
    div1.addEventListener('click',function(){
        console.log('打印第二次')
    })
}
```

事件委托的优点:
- 可以大量节省内存占用，减少事件注册
- 可以实现当新增子对象时无需再次对其绑定（动态绑定事件）

使用事件委托注意事项:
- 使用“事件委托”时，并不是说把事件委托给的元素越靠近顶层就越好。
- 事件冒泡的过程也需要耗时，越靠近顶层，事件的”事件传播链”越长，也就越耗时。
- 如果DOM嵌套结构很深，事件冒泡通过大量祖先元素会导致性能损失。

