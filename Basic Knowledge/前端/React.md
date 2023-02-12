目录
- [1. React 组件和架构](#1-react-组件和架构)
  - [1.1 React 事件机制 ](#11-react-事件机制-)
    - [1.1.1 合成事件层 （SyntheticEvent）](#111-合成事件层-syntheticevent)
    - [1.1.2 React事件和普通HTML事件 优点？](#112-react事件和普通html事件-优点)
  - [1.2 React 高阶组件、Render props 和 hooks ](#12-react-高阶组件render-props-和-hooks-)
    - [高阶组件](#高阶组件)
    - [Render props](#render-props)
    - [Hooks](#hooks)
    - [为什么要不断迭代？](#为什么要不断迭代)
  - [1.3 React Fiber架构 ](#13-react-fiber架构-)
    - [Fiber 如何解决问题的](#fiber-如何解决问题的)
    - [Fiber 架构核心](#fiber-架构核心)
  - [1.4 Component 和 PureComponent ](#14-component-和-purecomponent-)
  - [1.5 Component, Element, Instance ](#15-component-element-instance-)
  - [1.6 React声明组件方法 不同？](#16-react声明组件方法-不同)
    - [1.6.1 React.createClass 与 extends React.Component ](#161-reactcreateclass-与-extends-reactcomponent-)
    - [1.6.2 有状态和无状态组件 ](#162-有状态和无状态组件-)
  - [1.7 react 重新渲染触发方式和过程 ](#17-react-重新渲染触发方式和过程-)
  - [1.8 React Fragment理解 ](#18-react-fragment理解-)
  - [1.9 React 获取DOM元素 ](#19-react-获取dom元素-)
  - [1.10 React中可以在render访问refs吗? ](#110-react中可以在render访问refs吗-)
  - [1.11 React Portals(插槽) ](#111-react-portals插槽-)
  - [1.12 React避免不必要的render ](#112-react避免不必要的render-)
  - [1.13 React-Intl 的理解 ](#113-react-intl-的理解-)
  - [1.14 React.Context理解 ](#114-reactcontext理解-)
    - [1.14.1 React并不推荐优先使用Context？ ](#1141-react并不推荐优先使用context-)
  - [1.15 受控组件与非受控组件 ](#115-受控组件与非受控组件-)
    - [受控组件](#受控组件)
    - [非受控组件](#非受控组件)
  - [1.16 React Refs 理解 ](#116-react-refs-理解-)
    - [refs的使用](#refs的使用)
    - [回调refs](#回调refs)
  - [1.17 React绑定this的方式 ](#117-react绑定this的方式-)
  - [1.18 React组件构造函数？必须？ ](#118-react组件构造函数必须-)
  - [1.19 类组件与函数组件 ](#119-类组件与函数组件-)
- [2. 生命周期](#2-生命周期)
  - [2.1 详细介绍](#21-详细介绍)
    - [挂载](#挂载)
    - [组件更新](#组件更新)
    - [卸载阶段](#卸载阶段)
    - [错误处理阶段](#错误处理阶段)
  - [2.2 废弃了哪些生命周期](#22-废弃了哪些生命周期)
  - [2.3 React 16.X 中 props 改变后在哪个生命周期中处理](#23-react-16x-中-props-改变后在哪个生命周期中处理)
  - [2.4 state 和 props 触发更新的生命周期分别有什么区别？](#24-state-和-props-触发更新的生命周期分别有什么区别)
    - [state 更新流程：](#state-更新流程)
  - [2.5 React中发起网络请求应该在哪个生命周期中进行？为什么？](#25-react中发起网络请求应该在哪个生命周期中进行为什么)
- [3. 组件通信](#3-组件通信)
  - [3.1 父子组件的通信方式](#31-父子组件的通信方式)
  - [3.2 跨级组件的通信方式？](#32-跨级组件的通信方式)
  - [3.3 非嵌套关系组件的通信方式？](#33-非嵌套关系组件的通信方式)
  - [3.4 如何解决 props 层级过深的问题](#34-如何解决-props-层级过深的问题)
    - [3.5 组件通信的方式有哪些](#35-组件通信的方式有哪些)
- [4. 路由 React Router](#4-路由-react-router)
  - [4.1 实现原理](#41-实现原理)
    - [history模式原理](#history模式原理)
    - [hash模式原理](#hash模式原理)
  - [4.2 路由切换](#42-路由切换)
    - [v5可以通过以下方式获取路由状态](#v5可以通过以下方式获取路由状态)
    - [v5通过以下方式实现路由跳转](#v5通过以下方式实现路由跳转)
    - [v6 状态获取：](#v6-状态获取)
    - [v6 路由跳转：](#v6-路由跳转)
  - [4.3 React-Router怎么设置重定向？](#43-react-router怎么设置重定向)
  - [4.4 react-router 里的 Link 标签和 a 标签的区别](#44-react-router-里的-link-标签和-a-标签的区别)
  - [4.5 React-Router如何获取URL的参数和历史对象？](#45-react-router如何获取url的参数和历史对象)
    - [获取URL的参数](#获取url的参数)
    - [获取历史对象](#获取历史对象)
  - [4.6. React-Router 4怎样在路由变化时重新渲染同一个组件？](#46-react-router-4怎样在路由变化时重新渲染同一个组件)
  - [4.7 React-Router的路由有几种模式？](#47-react-router的路由有几种模式)
    - [BrowserRouter](#browserrouter)
    - [HashRouter](#hashrouter)
  - [4.8 React-Router 4的Switch有什么用？](#48-react-router-4的switch有什么用)
- [5. Redux 和 Mobx](#5-redux-和-mobx)
  - [5.1 Redux 的理解？解决什么问题](#51-redux-的理解解决什么问题)
  - [5.2 Redux 原理及工作流程](#52-redux-原理及工作流程)
    - [原理](#原理)
    - [工作流程](#工作流程)
  - [5.3 Redux 中异步的请求怎么处理](#53-redux-中异步的请求怎么处理)
    - [5.3.1 使用react-thunk中间件](#531-使用react-thunk中间件)
    - [5.3.2 使用redux-saga中间件](#532-使用redux-saga中间件)
  - [5.4 Redux 怎么实现属性传递](#54-redux-怎么实现属性传递)
  - [5.5 Redux 请求中间件如何处理并发](#55-redux-请求中间件如何处理并发)
  - [5.6 mobx 和 redux 有什么区别？](#56-mobx-和-redux-有什么区别)
  - [5.7 Redux 和 Vuex 有什么区别，它们的共同思想](#57-redux-和-vuex-有什么区别它们的共同思想)
  - [5.8 Redux 中间件是怎么拿到store 和 action? 然后怎么处理?](#58-redux-中间件是怎么拿到store-和-action-然后怎么处理)
  - [5.9 Redux中的connect有什么作用](#59-redux中的connect有什么作用)
- [6. Hooks](#6-hooks)
  - [6.1 Hook的理解](#61-hook的理解)
  - [6.2 useState()](#62-usestate)


## 1. React 组件和架构

### 1.1 React 事件机制 ![很多考察](https://img.shields.io/badge/-%E5%BE%88%E5%A4%9A%E8%80%83%E5%AF%9F-critical)

JSX 上写的事件并没有绑定在对应的真实 DOM 上，而是通过事件代理的方式，将所有的事件都统一绑定在了`document` (React 17 是root）上。这样的方式不仅减少了内存消耗，还能在组件挂载销毁时统一订阅和移除事件。

另外冒泡到 document 上的事件也不是原生浏览器事件，而是 React 自己实现的合成事件（SyntheticEvent）。因此我们如果不想要事件冒泡的话，调用`event.stopPropagation`是无效的，而应该调用`event.preventDefault`。

#### 1.1.1 合成事件层 （SyntheticEvent）![较少考察](https://img.shields.io/badge/-%E8%BE%83%E5%B0%91%E8%80%83%E5%AF%9F-informational)

React基于 Virtual DOM 实现了一个SyntheticEvent层（合成事件层），定义的事件处理器会接收到一个合成事件对象的实例，它符合W3C标准，且与原生的浏览器事件拥有同样的接口，支持冒泡机制，所有的事件都自动绑定在最外层上。

在React底层，主要对合成事件做了两件事：

- 事件委派：React会把所有的事件绑定到结构的最外层，使用统一的事件监听器，这个事件监听器上维持了一个映射来保存所有组件内部事件监听和处理函数。
- 自动绑定：React组件中，每个方法的上下文都会指向该组件的实例，即自动绑定this为当前组件。

#### 1.1.2 React事件和普通HTML事件 优点？![较多考察](https://img.shields.io/badge/-%E8%BE%83%E5%A4%9A%E8%80%83%E5%AF%9F-important)

区别：
- 对于事件名称命名方式，原生事件为全小写，react 事件采用小驼峰；
- 对于事件函数处理语法，原生事件为字符串，react 事件为函数；
- react 事件不能采用 return false 的方式来阻止浏览器的默认行为，而必须要地明确地调用preventDefault()来阻止默认行为。

合成事件是 react 模拟原生 DOM 事件所有能力的一个事件对象，其优点如下：
- 兼容所有浏览器，更好的跨平台
- 将事件统一存放在一个数组，避免频繁的新增与删除（垃圾回收）。
- 方便 react 统一管理和事务机制。
  
**事件的执行顺序为原生事件先执行，合成事件后执行**，合成事件会冒泡绑定到 document 上，所以尽量避免原生事件与合成事件混用，如果原生事件阻止冒泡，可能会导致合成事件不执行，因为需要冒泡到document 上合成事件才会执行。


### 1.2 React 高阶组件、Render props 和 hooks ![很多考察](https://img.shields.io/badge/-%E5%BE%88%E5%A4%9A%E8%80%83%E5%AF%9F-critical)

#### 高阶组件

高阶组件（HOC）是 React 中用于复用组件逻辑的一种技巧。其本质是：

接收一个组件作为参数，返回一个组件的函数

简言之，HOC是一种组件的设计模式，HOC接受一个组件和额外的参数（如果需要），返回一个新的组件。HOC 是纯函数，没有副作用。

``` 
// hoc的定义
function withSubscription(WrappedComponent, selectData) { return class extends React.Component {   
    constructor(props) {
    super(props);
    this.state = {
        data: selectData(DataSource, props)
    };
   }
   // 一些通用的逻辑处理
   render() {
     // ... 并使用新数据渲染被包装的组件!
     return <WrappedComponent data={this.state.data} {...this.props} />;
   }
 };
 
 // 使用
 const BlogPostWithSubscription = withSubscription(BlogPost, (DataSource, props) => DataSource.getBlogPost(props.id));
```
>高阶组件具有以下优缺点：
>
>优点
>- 逻辑复用，不影响被包裹的组件的内部逻辑
>
>缺点
>- 高阶组件传递给被包裹组件的 props 如果重名的话，会发生覆盖

#### Render props 

Render props 是一种在 React 组件之间使用一个值为函数的 prop 共享代码的技术，具体来说就是：

Render prop 是一个 告知组件需要渲染什么内容的函数 prop

```
Class DataProvider extends React.Components {
    state = {
        name: "Alice"
    }   
    render() {
        return (
            <div>
                <p>共享数据组件自己内部的 render</p>
                { this.props.render(this.state) }
            <div/>
        )
    }
}

<DataProvider render={data => (<p>共享的 render {data.name}</>)} />
```
>由此可以看到，render props的优缺点也很明显∶
>- 优点：数据共享、代码复用，将组件内的state作为props传递给调用者，将渲染逻辑交给调用者。
>- 缺点：无法在 return 语句外访问数据、嵌套写法不够优雅
>
>

#### Hooks

Hooks 是 React 16.8 中新增的特性。它可以让你在不编写 class 的情况下使用 state，lifecycle 等 React 特性。

通过自定义 hook，可以很轻松的实现逻辑复用。

```
function useSubscription() {
    const data = DataSource.getComments()
    return [data]
}

function CommentList(props) {
    const {data} = props
    const [subData] = useSubscription()
    return (
    <div>
        this is data: {data},
        this is subData: {subData}
    <div/>
    )
}
```
> 可以看到 hooks 结构清晰明了，具有以下优点：
>- 使用直观
>- 不存在 hoc 的重名问题
>- 不存在 render props 的嵌套问题
>- 能在 return 之外访问数据

**三者都能用来进行逻辑复用。区别在于高阶组件为接收组件，对其进行包装，Render props 为在 render 中渲染共享数据，而 hooks 是以函数调用的形式共享数据。**

#### 为什么要不断迭代？
在大部分情况下，高阶组件和 Render props 都存在各自的缺陷：

- 重名问题
- 嵌套问题
- 无法在 return 之外访问数据的问题
- 数据来源不清晰的问题

不断迭代是为了解决上述问题，让我们可以用更加简洁的方式实现组件逻辑复用，让写代码变得更加轻松和愉快。


### 1.3 React Fiber架构 ![很多考察](https://img.shields.io/badge/-%E5%BE%88%E5%A4%9A%E8%80%83%E5%AF%9F-critical)

React V15 在渲染时，会递归比对 VirtualDOM 树，找出需要变动的节点，然后同步更新它们， 一气呵成。这个过程期间， React 会占据浏览器资源，这会导致用户触发的事件得不到响应，并且会导致掉帧，**导致用户感觉到卡顿**。

实现的方式是requestIdleCallback这一 API。

#### Fiber 如何解决问题的
Fiber 把一个渲染任务分解为多个渲染任务，而不是一次性完成，把每一个分割得很细的任务视作一个"执行单元"，React 就会检查现在还剩多少时间，如果没有时间就将控制权让出去，故任务会被分散到多个帧里面，中间可以返回至主进程控制执行其他任务，最终实现更流畅的用户体验。

即是实现了"增量渲染"，实现了可中断与恢复，恢复后也可以复用之前的中间状态，并给不同的任务赋予不同的优先级，其中每个任务更新单元为 React Element 对应的 Fiber 节点。

#### Fiber 架构核心
Fiber 架构可以分为三层：

Scheduler 调度器 —— 调度任务的优先级，高优任务优先进入 Reconciler
Reconciler 协调器 —— 负责找出变化的组件
Renderer 渲染器 —— 负责将变化的组件渲染到页面上

相比 React15，React16 多了Scheduler（调度器），调度器的作用是调度更新的优先级。
在新的架构模式下，工作流如下：

- 每个更新任务都会被赋予一个优先级。
- 当更新任务抵达调度器时，高优先级的更新任务（记为 A）会更快地被调度进 Reconciler 层；
- 此时若有新的更新任务（记为 B）抵达调度器，调度器会检查它的优先级，若发现 B 的优先级高于当前任务 A，那么当前处于 Reconciler 层的 A 任务就会被中断，调度器会将 B 任务推入 Reconciler 层。
- 当 B 任务完成渲染后，新一轮的调度开始，之前被中断的 A 任务将会被重新推入 Reconciler 层，继续它的渲染之旅，即“可恢复”。

**Fiber 架构的核心即是"可中断"、"可恢复"、"优先级"**

### 1.4 Component 和 PureComponent ![较少考察](https://img.shields.io/badge/-%E8%BE%83%E5%B0%91%E8%80%83%E5%AF%9F-informational)

React.Component 和 React.PureComponent很相似，两则的区别在于，PureComponent类帮我们以浅比较的方式对比props和state，实现了shouldComponentUpdate()函数，在某些情况下，使用PureComponent可以减少render函数的执行，提升性能。

在React中，当prop或者state发生变化时，可以通过在`shouldComponentUpdate`生命周期函数中执行`return false`来阻止页面的更新，从而减少不必要的render执行。React.PureComponent会自动执行 `shouldComponentUpdate`。

不过，pureComponent中的 shouldComponentUpdate() 进行的是浅比较，也就是说如果**是引用数据类型的数据，只会比较不是同一个地址，而不会比较这个地址里面的数据是否一致**。

浅比较会忽略属性和或状态突变情况，其实也就是数据引用指针没有变化，而数据发生改变的时候render是不会执行的。如果需要重新渲染那么就需要重新开辟空间引用数据。PureComponent一般会用在一些纯展示组件上。

使用pureComponent的好处：当组件更新时，如果组件的props或者state都没有改变，render函数就不会触发。省去虚拟DOM的生成和对比过程，达到提升性能的目的。这是因为react自动做了一层浅比较。

### 1.5 Component, Element, Instance ![较少考察](https://img.shields.io/badge/-%E8%BE%83%E5%B0%91%E8%80%83%E5%AF%9F-informational)

- 元素：一个元素element是一个普通对象(plain object)，描述了对于一个DOM节点或者其他组件component，你想让它在屏幕上呈现成什么样子。元素element可以在它的属性props中包含其他元素(译注:用于形成元素树)。创建一个React元素element成本很低。元素element创建之后是不可变的。

- 组件：一个组件component可以通过多种方式声明。可以是带有一个render()方法的类，简单点也可以定义为一个函数。这两种情况下，它都把属性props作为输入，把返回的一棵元素树作为输出。

- 实例：一个实例instance是你在所写的组件类component class中使用关键字this所指向的东西(译注:组件实例)。它用来存储本地状态和响应生命周期事件很有用。

>函数式组件(Functional component)根本没有实例instance。类组件(Class component)有实例instance，但是永远也不需要直接创建一个组件的实例，因为React帮我们做了这些。

### 1.6 React声明组件方法 不同？![较多考察](https://img.shields.io/badge/-%E8%BE%83%E5%A4%9A%E8%80%83%E5%AF%9F-important)

1、函数式定义的无状态组件；

2、es5原生方式`React.createClass`定义的组件；

3、es6形式的`extends React.Component`定义的组件。

#### 1.6.1 React.createClass 与 extends React.Component ![较多考察](https://img.shields.io/badge/-%E8%BE%83%E5%A4%9A%E8%80%83%E5%AF%9F-important)

```
import React from 'react';

const Example = React.createClass({
  render() {
    return (
      <div></div>
    );
  }
});
export default Example;

-----------------------

class Example extends React.Component {
  constructor(props) {
    super(props);
  }
  render() {
    return (
      <div></div>
    );
  }
}
export default Example;
```

- 赋值属性

    在调用 React.createClass 时，添加 propTypes 的对象，给它的属性进行赋值来声明对应属性的类型。 getDefaultProps 这个函数返回了一个对象，这个对象的所有属性将会作为组件的初始化属性。

    React.Component ，我们通过给 Example 类添加一个名为 propTypes 属性的方式来达到和上面同样的效果。 getDefaultProps 函数也变成了一个名为 defaultProps 的属性。

- state区别
  
  创建 getInitialState 的函数，返回一个包含初始化状态的对象。

  转换以后 getInitialState 函数被抛弃了，而是在 constructor 中像创建初始化属性一样声明了所有状态。

- this绑定

    我们在 onClick 属性上绑定了 this.handleClick。当点击事件被触发时，React 会切换到正确的上下文中去执行 handleClick。

    由于使用了 ES6，这里会有些微不同，属性并不会自动绑定到 React 类的实例上。需要用bind绑定。

- Mixins

    使用 React.createClass 的话，我们可以在创建组件时添加一个叫做 mixins 的属性，并将可供混合的类的集合以数组的形式赋给 mixins。

    但在 ES6 中，mixins 特性不被支持。

#### 1.6.2 有状态和无状态组件 ![很多考察](https://img.shields.io/badge/-%E5%BE%88%E5%A4%9A%E8%80%83%E5%AF%9F-critical)
通常来说，使用class关键字创建的组件，有自己的私有数据this.state和生命周期函数就是有状态组件，使用function创建的组件，只有props没有自己的私有数据和生命周期函数就是无状态组件。

无状态组件

无状态组件Stateless Component是最基础的组件形式，由于没有状态的影响所以就是纯静态展示的作用。一般来说，各种UI库里也是最开始会开发的组件类别，例如按钮、标签、输入框等。其的基本组成结构就是属性props以及事件函数调用。由于不涉及到状态的更新，所以这种组件的复用性也最强，无状态组件由于没有自己的state和生命周期函数，所以运行效率高。

- 只负责接收props渲染DOM，不维护自己的state。
- 不能访问生命周期方法。
- 不需要声明类，可以避免extends或constructor之类的代码，语法上更加简洁。
- 不会被实例化，因此不能直接传ref，可以使用React.forwardRef包装后再传ref。
- 不需要显示声明this关键字，在ES6的类声明中往往需要将函数的this关键字绑定到当前作用域，而因为函数式声明的特性，我们不需要再强制绑定。
- 更好的性能表现，因为函数式组件中并不需要进行生命周期的管理与状态管理，因此React并不需要进行某些特定的检查或者内存分配，从而保证了更好地性能表现。

>优点
>- 简化代码、专注于 render
>- 组件不需要被实例化，无生命周期，提升性能。 输出（渲染）只取决于输入（属性），无副作用
>- 视图和数据的解耦分离
> 
>缺点：
>- 无法使用 ref 
>- 无生命周期方法
>- 无法控制组件的重渲染，因为无法使用shouldComponentUpdate 方法，当组件接受到新的属性时则会重渲染


有状态组件

特点：
- 是类组件
- 有继承
- 可以使用this
- 可以使用react的生命周期
- 使用较多，容易频繁触发生命周期钩子函数，影响性能
- 内部使用 state，维护自身状态的变化，有状态组件根据外部组件传入的 props 和自身的 state进行渲染。

使用场景：
- 需要使用到状态的。
- 需要使用状态操作组件的（无状态组件的也可以实现新版本react hooks也可实现）

### 1.7 react 重新渲染触发方式和过程 ![很多考察](https://img.shields.io/badge/-%E5%BE%88%E5%A4%9A%E8%80%83%E5%AF%9F-critical)

组件状态的改变可以因为props的改变，或者直接通过setState方法改变。组件获得新的状态，然后React决定是否应该重新渲染组件。只要组件的state发生变化，React就会对组件进行重新渲染。这是因为React中的shouldComponentUpdate方法默认返回true，这就是导致每次更新都重新渲染的原因。

当React将要渲染组件时会执行shouldComponentUpdate方法来看它是否返回true（组件应该更新，也就是重新渲染）。所以需要重写shouldComponentUpdate方法让它根据情况返回true或者false来告诉React什么时候重新渲染什么时候跳过重新渲染。

- setState() 方法被调用
  
    setState 是 React 中最常用的命令，通常情况下，执行 setState 会触发 render。

    **但是当 setState 传入 null 的时候，并不会触发 render。**(this.setState(null))

- 父组件重新渲染
  
    只要父组件重新渲染了，即使传入子组件的 props 未发生变化，那么子组件也会重新渲染，进而触发 render。

- forceUpdate()

    默认情况下，当组件的 state 或 props 改变时，组件将重新渲染。如果你的 render()方法依赖于一些其他的数据，你可以告诉 React 组件需要通过调用 forceUpdate()重新渲染。

    调用 forceUpdate()会导致组件跳过 shouldComponentUpdate(),直接调用 render()。这将触发组件的正常生命周期方法,包括每个子组件的 shouldComponentUpdate()方法。

>重新渲染 render 会做些什么
>- 会对新旧 VNode 进行对比，也就是我们所说的 Dom diff。
>- 对新旧两棵树进行一个深度优先遍历，这样每一个节点都会一个标记，在到深度遍历的时候，每遍历到一和个节点，就把该节点和新的节点树进行对比，如果有差异就放到一个对象里面
>- 遍历差异对象，根据差异的类型，根据对应对规则更新 VNode
>
>React 的处理 render 的基本思维模式是每次一有变动就会去重新渲染整个应用。在 Virtual DOM 没有出现之前，最简单的方法就是直接调用 innerHTML。
>
>Virtual DOM 厉害的地方并不是说它比直接操作 DOM 快，而是说不管数据怎么变，都会尽量以最小的代价去更新 DOM。React 将 render 函数返回的虚拟 DOM 树与老的进行比较，从而确定 DOM 要不要更新、怎么更新。
>
>当 DOM 树很大时，遍历两棵树进行各种比对还是相当耗性能的，特别是在顶层 setState 一个微小的修改，默认会去遍历整棵树。尽管 React 使用高度优化的 Diff 算法 ，但是这个过程仍然会损耗性能。
>

### 1.8 React Fragment理解 ![较多考察](https://img.shields.io/badge/-%E8%BE%83%E5%A4%9A%E8%80%83%E5%AF%9F-important)

在React中，组件返回的元素只能有一个根元素。为了不添加多余的DOM节点，我们可以使用Fragment标签来包裹所有的元素，Fragment标签不会渲染出任何元素。

>React官方对Fragment的解释：
>
>React 中的一个常见模式是一个组件返回多个元素。Fragments 允许你将子列表分组，而无需向 DOM 添加额外节点。

### 1.9 React 获取DOM元素 ![较多考察](https://img.shields.io/badge/-%E8%BE%83%E5%A4%9A%E8%80%83%E5%AF%9F-important) 

- 类组件
  - React.createRef()
  - 函数格式：ref对应一个方法，该方法有一个参数，也就是对应的节点实例，例如：<p ref={ele => this.info = ele}></p>
  - 字符串格式：字符串格式，这是React16版本之前用得最多的，例如：<p ref="info">span</p>

- 函数组件： useRef() 钩子

### 1.10 React中可以在render访问refs吗? ![较少考察](https://img.shields.io/badge/-%E8%BE%83%E5%B0%91%E8%80%83%E5%AF%9F-informational)

不可以，render 阶段 DOM 还没有生成，无法获取 DOM。DOM 的获取需要在 pre-commit 阶段和 commit 阶段。

### 1.11 React Portals(插槽) ![较多考察](https://img.shields.io/badge/-%E8%BE%83%E5%A4%9A%E8%80%83%E5%AF%9F-important)

Portals语法如下：
```
ReactDOM.createPortal(child, container);
```

- 第一个参数 child 是可渲染的 React 子项，比如元素，字符串或者片段等;
- 第二个参数 container 是一个 DOM 元素。

一个 portal 的典型用例是当父组件有 overflow: hidden 或 z-index 样式时，但你需要子组件能够在视觉上“跳出”其容器。例如，对话框、悬浮卡以及提示框 

```
import DemoComponent from './DemoComponent';
render() {
  // react会将DemoComponent组件直接挂载在真实的 dom 节点 domNode 上，生命周期还和16版本之前相同。
  return ReactDOM.createPortal(
    <DemoComponent />,
    domNode,
  );
}
```

### 1.12 React避免不必要的render ![较多考察](https://img.shields.io/badge/-%E8%BE%83%E5%A4%9A%E8%80%83%E5%AF%9F-important)

- shouldComponentUpdate 和 PureComponent

    在 React 类组件中，可以利用 shouldComponentUpdate或者 PureComponent 来减少因父组件更新而触发子组件的 render，从而达到目的。shouldComponentUpdate 来决定是否组件是否重新渲染，如果不希望组件重新渲染，返回 false 即可。

- 利用高阶组件
  
    在函数组件中，并没有 shouldComponentUpdate 这个生命周期，可以利用高阶组件，封装一个类似 PureComponet 的功能
    
- 使用 React.memo
  
  React.memo 是 React 16.6 新的一个 API，用来缓存组件的渲染，避免不必要的更新，其实也是一个高阶组件，与 PureComponent 十分类似，但不同的是， React.memo只能用于函数组件。

### 1.13 React-Intl 的理解 ![较多考察](https://img.shields.io/badge/-%E8%BE%83%E5%A4%9A%E8%80%83%E5%AF%9F-important)

React Intl允许我们在React应用中设置国际化。

React-intl提供了两种使用方法，一种是引用React组件，另一种是直接调取API，官方更加推荐在React项目中使用前者，只有在无法使用React组件的地方，才应该调用框架提供的API。它提供了一系列的React组件，包括数字格式化、字符串格式化、日期格式化等。

在React-intl中，可以配置不同的语言包，他的工作原理就是根据需要，在语言包之间进行切换。

### 1.14 React.Context理解 ![较多考察](https://img.shields.io/badge/-%E8%BE%83%E5%A4%9A%E8%80%83%E5%AF%9F-important)

Context 提供了一个无需为每层组件手动添加 props，就能在组件树间进行数据传递的方法。

通常，数据是通过 props 属性自上而下（由父到子）进行传递，但这种做法对于某些类型的属性而言是极其繁琐的（例如：地区偏好，UI 主题），这些属性是应用程序中许多组件都需要的。

Context 提供了一种在组件之间共享此类值的方式，而不必显式地通过组件树的逐层传递 props。

```
const Context = React.createContext(null);

const Child = () => {
  const value = React.useContext(Context);
  return (
    <div>theme: {value.theme}</div>
  )
}

const App = () => {
  const [count, setCount] = React.useState(0);
  return (
    <Context.Provider value={{ theme: 'light' }}>
      <div onClick={() => setCount(count + 1)}>触发更新</div>
      <Child />
    </Context.Provider>
  )
}

ReactDOM.render(<App />, document.getElementById('root'));
```
JS的代码块在执行期间，会创建一个相应的作用域链，这个作用域链记录着运行时JS代码块执行期间所能访问的活动对象，包括变量和函数，JS程序通过作用域链访问到代码块内部或者外部的变量和函数。

假如以JS的作用域链作为类比，React组件提供的Context对象其实就好比一个提供给子组件访问的作用域，而Context对象的属性可以看成作用域上的活动对象。由于组件的Context由其父节点链上所有组件通过getChildContext()返回的Context对象组合而成，所以，组件通过Context是可以访问到其父组件链上所有节点组件提供的Context的属性。

#### 1.14.1 React并不推荐优先使用Context？ ![较少考察](https://img.shields.io/badge/-%E8%BE%83%E5%B0%91%E8%80%83%E5%AF%9F-informational)

context的更新需要通过setState()触发，这存在问题。Context支持跨组件的访问，但是如果中间的子组件通过一些方法不影响更新，比如 shouldComponentUpdate() 返回false 那么不能保证Context更新Context的子组件。

Context 主要应用场景在于很多不同层级的组件需要访问同样一些的数据。请谨慎使用，因为这会使得组件的复用性变差。

### 1.15 受控组件与非受控组件 ![很多考察](https://img.shields.io/badge/-%E5%BE%88%E5%A4%9A%E8%80%83%E5%AF%9F-critical)

#### 受控组件
在使用表单来收集用户输入时，例如`<input>`，`<select>`，`<textearea>`等元素都要绑定一个change事件，当表单的状态发生变化，就会触发onChange事件，更新组件的state。这种组件在React中被称为受控组件。

在受控组件中，组件渲染出的状态与它的value或checked属性相对应，react通过这种方式消除了组件的局部状态，使整个状态可控。

受控组件更新state的流程：

- 可以通过初始state中设置表单的默认值
- 每当表单的值发生变化时，调用onChange事件处理器
- 事件处理器通过事件对象e拿到改变后的状态，并更新组件的state
- 一旦通过setState方法更新state，就会触发视图的重新渲染，完成表单组件的更新

#### 非受控组件

表单数据由DOM本身处理。即不受setState()的控制，与传统的HTML表单输入相似，input输入值即显示最新值（使用 ref从DOM获取表单值）
```
export default function App() {
    const eleRef = useRef(null);
    const [submitContent, setSubmitContent] = useState("");
  
    const handleSubmit = () => {
      // 通过ref获取输入框的值
      const content = eleRef.current?.value;
      setSubmitContent(content);
    };
  
    return (
      <div className="App">
        <input ref={eleRef} />
        <Button type="primary" onClick={handleSubmit}>
          提交
        </Button>
        <div>{submitContent ?? ""}</div>
      </div>
    );
  }
```


1、受控组件使用场景：一般用在需要动态设置其初始值的情况。例如：某些form表单信息编辑时，input表单元素需要初始显示服务器返回的某个值然后进行编辑。

2、非受控组件使用场景：一般用于无任何动态初始值信息的情况。例如：form表单创建信息时，input表单元素都没有初始值，需要用户输入的情况。


### 1.16 React Refs 理解 ![较少考察](https://img.shields.io/badge/-%E8%BE%83%E5%B0%91%E8%80%83%E5%AF%9F-informational)

Refs 是一个 获取 DOM节点或 React元素实例的工具。在 React 中 Refs 提供了一种方式，允许用户访问DOM 节点或者在render方法中创建的React元素。

在 React单项数据流中，props是父子组件交互的唯一方式。要修改一个子组件，需要通过的新的props来重新渲染。

但是在某些情况下，需要在数据流之外强制修改子组件。被修改的子组件可能是一个React组件实例，也可能是一个DOM元素。对于这两种情况，React 都通过 Refs的使用提供了具体的解决方案。

>refs 通常适合在一下场景中使用：
>
>- 对 DOM 元素焦点的控制、内容选择或者媒体播放；
>- 通过对 DOM 元素控制，触发动画特效；
>- 通第三方 DOM 库的集成。

#### refs的使用

- React.createRef()
  
    Refs 是使用 React.createRef() 创建的，并通过 ref 属性附加到 React 元素。

    在构造组件时，通常将 Refs 分配给实例属性，以便可以在整个组件中引用它们。

- 添加到类组件上 

    refs不能添加到函数组件上，因为函数组件没有实例。

    使用forwardRef，进行Refs转发；将该组件转为类组件；将 ref 作为特殊名字的 prop 比如 cref 直接传递 

#### 回调refs

能助你更精细地控制何时 refs 被设置和解除。

不同于传递 createRef() 创建的 ref 属性，你会传递一个函数。这个函数中接受 React 组件实例或 HTML DOM 元素作为参数，以使它们能在其他地方被存储和访问。

我的理解：其实回调形式的Refs就是一个普通的回调函数。真实作用，就是对Refs进行赋值。

- 通过这个回调函数获取元素或实例。
- 获取元素或实例之后，对Refs真正赋值。
- 然后在其他地方访问Refs.

### 1.17 React绑定this的方式 ![较多考察](https://img.shields.io/badge/-%E8%BE%83%E5%A4%9A%E8%80%83%E5%AF%9F-important)

- bind()
```
return (
    <div>
        <button onClick={ this.handleClick.bind(this, '赵四') }>Say Hello</button>
    </div>
```

- 构造函数内绑定
```
constructor (props) {
    super(props)
    this.state = {message: 'Allo!'}
    this.handleClick = this.handleClick.bind(this)
}
```

- 箭头函数
```
<div>
    <button onClick={ ()=>{ this.handleClick() } }>Say Hello</button>
</div>
```

### 1.18 React组件构造函数？必须？ ![较少考察](https://img.shields.io/badge/-%E8%BE%83%E5%B0%91%E8%80%83%E5%AF%9F-informational)
构造函数主要用于两个目的：

- 通过将对象分配给this.state来初始化本地状态 
- 将事件处理程序方法绑定到实例上

所以，当在React class中需要设置state的初始值或者绑定事件时，需要加上构造函数。

构造函数用来新建父类的this对象；子类必须在constructor方法中调用super方法；否则新建实例时会报错；因为子类没有自己的this对象，而是继承父类的this对象，然后对其进行加工。如果不调用super方法；子类就得不到this对象。

注意：

- constructor () 必须配上 super(), 如果要在constructor 内部使用 this.props 就要 传入props , 否则不用
- JavaScript中的 bind 每次都会返回一个新的函数, 为了性能等考虑, 尽量在constructor中绑定事件


### 1.19 类组件与函数组件 ![很多考察](https://img.shields.io/badge/-%E5%BE%88%E5%A4%9A%E8%80%83%E5%AF%9F-critical)

1. 函数组件是一个纯函数，它接收一个props对象返回一个react元素；而类组件需要去继承React.Component并且创建render函数返回react元素。
2. 函数组件没有生命周期和状态state，而类组件有。

语法：

数组件是一个纯函数，它接收一个props对象返回一个react元素。而类组件需要去继承React.Component并且创建render函数返回react元素，这将会要更多的代码。

状态:

因为函数组件是一个纯函数，你不能在组件中使用setState()，这也是为什么把函数组件称作为无状态组件。

如果你需要在你的组件中使用state，你可以选择创建一个类组件或者将state提升到你的父组件中，然后通过props对象传递到子组件。

生命周期钩子：

你不能在函数组件中使用生命周期钩子，原因和不能使用state一样，所有的生命周期钩子都来自于继承的React.Component中。

在react16.8版本中添加了hooks，使得我们可以在函数组件中使用useState钩子去管理state，使用useEffect钩子去使用生命周期函数。

## 2. 生命周期

### 2.1 详细介绍

[生命周期图解](https://projects.wojtekmaj.pl/react-lifecycle-methods-diagram/)

#### 挂载 

当组件实例被创建并插入 DOM 中时，其生命周期调用顺序如下：

>constructor()
>
>static getDerivedStateFromProps()
>
>render()
>
>componentDidMount()

- getDerivedStateFromProps

  该方法是新增的生命周期方法，是一个静态的方法，因此不能访问到组件的实例。

  执行时机：组件创建和更新阶段，不论是props变化还是state变化，都会调用。

  在每次render方法前调用，第一个参数为即将更新的props，第二个参数为上一个状态的state，可以比较props 和 state来加一些限制条件，防止无用的state更新。

  该方法需要返回一个新的对象作为新的state或者返回null表示state状态不需要更新。

- render
  
  render是React 中最核心的方法，一个组件中必须要有这个方法，它会根据状态 `state` 和属性 `props` 渲染组件。这个函数只做一件事，就是返回需要渲染的内容: 
  - React 元素：这里包括原生的 DOM 以及 React 组件；
  - 数组和 Fragment（片段）：可以返回多个元素；
  - Portals（插槽）：可以将子元素渲染到不同的 DOM 子树种；
  - 字符串和数字：被渲染成 DOM 中的 text 节点；
  - 布尔值或 null：不渲染任何内容。


- componentDidMount() 
  
  componentDidMount()会在组件挂载后（插入 DOM 树中）立即调。该阶段通常进行以下操作：

  执行依赖于DOM的操作；
  - 发送网络请求；（官方建议）
  - 添加订阅消息（会在componentWillUnmount取消订阅）；

  如果在 `componentDidMount` 中调用 `setState` ，就会触发一次额外的渲染，多调用了一次 render 函数，由于它是在浏览器刷新屏幕前执行的，所以用户对此是没有感知的，但是我应当避免这样使用，这样会带来一定的性能问题，尽量是在 `constructor` 中初始化 `state` 对象。

#### 组件更新

当组件的 `props`  改变了，或组件内部调用了  `setState/forceUpdate`，会触发更新重新渲染，这个过程可能会发生多次。这个阶段会依次调用下面这些方法：
 
>getDerivedStateFromProps
> 
>shouldComponentUpdate
> 
>render
>
>getSnapshotBeforeUpdate
>
>componentDidUpdate

- shouldComponentUpdate

  ```
  shouldComponentUpdate(nextProps, nextState)
  ```
  在说这个生命周期函数之前，来看两个问题：
  
  setState 函数在任何情况下都会导致组件重新渲染吗？例如下面这种情况：

  父组件重新渲染或者setState时，不管传入的 props 有没有变化，都会引起子组件的重新渲染。

  那么有没有什么方法解决在这两个场景下不让组件重新渲染进而提升性能呢？这个时候 `shouldComponentUpdate` 登场了，这个生命周期函数是用来提升速度的，它是在重新渲染组件开始前触发的，默认返回 `true`，可以比较 `this.props` 和 `nextProps` ，`this.state` 和 `nextState` 值是否变化，来确认返回 `true` 或者 `false`。当返回 `false` 时，组件的更新过程停止，后续的 `render`、`componentDidUpdate` 也不会被调用。

  >注意：添加 `shouldComponentUpdate` 方法时，不建议使用深度相等检查（如使用 `JSON.stringify()`），因为深比较效率很低，可能会比重新渲染组件效率还低。而且该方法维护比较困难，建议使用该方法会产生明显的性能提升时使用。

- getSnapshotBeforeUpdate

  ```
  getSnapshotBeforeUpdate(prevProps, prevState)
  ```

  这个方法在 `render` 之后，`componentDidUpdate` 之前调用，有两个参数 `prevProps` 和 `prevState`，表示更新之前的 `props` 和 `state`，这个函数必须要和 `componentDidUpdate` 一起使用，并且要有一个返回值，默认是 `null`，这个返回值作为第三个参数传给 `componentDidUpdate`。

  此方法的目的在于获取组件更新前的一些信息，比如组件的滚动位置之类的，在组件更新后可以根据这些信息恢复一些UI视觉上的状态

- componentDidUpdate
  
  componentDidUpdate() 会在更新后会被立即调用，首次渲染不会执行此方法。 该阶段通常进行以下操作：
  
  - 当组件更新后，对 DOM 进行操作； 
  
  - 如果你对更新前后的 props 进行了比较，也可以选择在此处进行网络请求；（例如，当 props 未发生变化时，则不会执行网络请求）。 

  ```
  componentDidUpdate(prevProps, prevState, snapshot){}
  ```

  该方法有三个参数：
  
  prevProps: 更新前的props
  
  prevState: 更新前的state
  
  snapshot: getSnapshotBeforeUpdate()生命周期的返回值

#### 卸载阶段

卸载阶段只有一个生命周期函数，componentWillUnmount() 会在组件卸载及销毁之前直接调用。在此方法中执行必要的清理操作：

- 清除 timer，取消网络请求或清除
- 取消在 componentDidMount() 中创建的订阅等；
  
这个生命周期在一个组件被卸载和销毁之前被调用，因此你不应该再这个方法中使用 `setState`，因为组件一旦被卸载，就不会再装载，也就不会重新渲染。

#### 错误处理阶段
componentDidCatch(error, info)，此生命周期在后代组件抛出错误后被调用。 它接收两个参数∶
- error：抛出的错误。
- info：带有 componentStack key 的对象，其中包含有关组件引发错误的栈信息

**React常见生命周期的过程大致如下：**

- 挂载阶段，首先执行constructor构造方法，来创建组件
- 创建完成之后，就会执行render方法，该方法会返回需要渲染的内容
- 随后，React会将需要渲染的内容挂载到DOM树上
- 挂载完成之后就会执行componentDidMount生命周期函数
- 如果我们给组件创建一个props（用于组件通信）、调用setState（更改state中的数据）、调用forceUpdate（强制更新组件）时，都会重新调用render函数
- render函数重新执行之后，就会重新进行DOM树的挂载
- 挂载完成之后就会执行componentDidUpdate生命周期函数
- 当移除组件时，就会执行componentWillUnmount生命周期函数

### 2.2 废弃了哪些生命周期

被废弃的三个函数都是在render之前，因为fiber的出现，很可能因为高优先级任务的出现而打断现有任务导致它们会被执行多次。

- componentWillMount
  
  首先这个函数的功能完全可以使用componentDidMount和 constructor来代替，异步获取的数据的情况上面已经说明了，而如果抛去异步获取数据，其余的即是初始化而已，这些功能都可以在constructor中执行，除此之外，如果在 willMount 中订阅事件，但在服务端这并不会执行 willUnMount事件，也就是说服务端会导致内存泄漏所以componentWilIMount完全可以不使用，但使用者有时候难免因为各种各样的情况在 componentWilMount中做一些操作，那么React为了约束开发者，干脆就抛掉了这个API 

- componentWillReceiveProps
  
  在老版本的 React 中，如果组件自身的某个 state 跟其 props 密切相关的话，一直都没有一种很优雅的处理方式去更新 state，而是需要在 componentWilReceiveProps 中判断前后两个 props 是否相同，如果不同再将新的 props更新到相应的 state 上去。这样做一来会破坏 state 数据的单一数据源，导致组件状态变得不可预测，另一方面也会增加组件的重绘次数。

  类似的业务需求也有很多，如一个可以横向滑动的列表，当前高亮的 Tab 显然隶属于列表自身的时，根据传入的某个值，直接定位到某个 Tab。为了解决这些问题，React引入了第一个新的生命周期：getDerivedStateFromProps。它有以下的优点∶

  - getDSFP是静态方法，在这里不能使用this，也就是一个纯函数，开发者不能写出副作用的代码
  - 开发者只能通过prevState而不是prevProps来做对比，保证了state和props之间的简单关系以及不需要处理第一次渲染时prevProps为空的情况。
    
  基于第一点，将状态变化（setState）和昂贵操作（tabChange）区分开，更加便于 render 和 commit 阶段操作或者说优化。 

- componentWillUpdate
  
  与 componentWillReceiveProps 类似，许多开发者也会在 componentWillUpdate 中根据 props 的变化去触发一些回调 。 但不论是 componentWilReceiveProps 还是 componentWilUpdate，都有可能在一次更新中被调用多次，也就是说写在这里的回调函数也有可能会被调用多次，这显然是不可取的。

  与 componentDidMount 类 似， componentDidUpdate 也不存在这样的问题，一次更新中 componentDidUpdate 只会被调用一次，所以将原先写在 componentWillUpdate 中的回调迁移至 componentDidUpdate 就可以解决这个问题。


  另外一种情况则是需要获取DOM元素状态，但是由于在fiber中，render可打断，可能在wilMount中获取到的元素状态很可能与实际需要的不同，这个通常可以使用第二个新增的生命函数的解决 


### 2.3 React 16.X 中 props 改变后在哪个生命周期中处理
在getDerivedStateFromProps中进行处理。

这个生命周期函数是为了替代`componentWillReceiveProps`存在的，所以在需要使用`componentWillReceiveProps`时，就可以考虑使用`getDerivedStateFromProps`来进行替代。
两者的参数是不相同的，而`getDerivedStateFromProps`是一个静态函数，也就是这个函数不能通过this访问到class的属性，也并不推荐直接访问属性。而是应该通过参数提供的nextProps以及prevState来进行判断，根据新传入的props来映射到state。

需要注意的是，如果props传入的内容不需要影响到你的state，那么就需要返回一个null，这个返回值是必须的，所以尽量将其写到函数的末尾：

```
static getDerivedStateFromProps(nextProps, prevState) {
    const {type} = nextProps;
    // 当传入的type发生变化的时候，更新state
    if (type !== prevState.type) {
        return {
            type,
        };
    }
    // 否则，对于state不进行任何操作
    return null;
}
```

### 2.4 state 和 props 触发更新的生命周期分别有什么区别？

#### state 更新流程：

这个过程当中涉及的函数：

  - shouldComponentUpdate: 当组件的 state 或 props 发生改变时，都会首先触发这个生命周期函数。它会接收两个参数：nextProps, nextState——它们分别代表传入的新 props 和新的 state 值。拿到这两个值之后，我们就可以通过一些对比逻辑来决定是否有 re-render（重渲染）的必要了。如果该函数的返回值为 false，则生命周期终止，反之继续；

  - componentWillUpdate。componentWillUpdate 是 React16 废弃的三个生命周期之一。过去，我们可能希望能在这个阶段去收集一些必要的信息（比如更新前的 DOM 信息等等），现在我们完全可以在 React16 的 getSnapshotBeforeUpdate 中去做这些事；

  - componentDidUpdate：componentDidUpdate() 会在UI更新后会被立即调用。它接收 prevProps（上一次的 props 值）作为入参，也就是说在此处我们仍然可以进行 props 值对比（再次说明 componentWillUpdate 确实鸡肋哈）。
  

props 更新流程：

相对于 state 更新，props 更新后**唯一的区别是增加了对 componentWillReceiveProps 的调用**。

componentWillReceiveProps：它在Component接受到新的 props 时被触发。

componentWillReceiveProps 会接收一个名为 nextProps 的参数（对应新的 props 值）。该生命周期是 React16 废弃掉的三个生命周期之一。在它被废弃前，可以用它来比较 this.props 和 nextProps 来重新setState。在 React16 中，用一个类似的新生命周期 getDerivedStateFromProps 来代替它。


### 2.5 React中发起网络请求应该在哪个生命周期中进行？为什么？

对于异步请求，最好放在componentDidMount中去操作，对于同步的状态改变，可以放在componentWillMount中，一般用的比较少。

如果认为在componentWillMount里发起请求能提早获得结果，这种想法其实是错误的，通常componentWillMount比componentDidMount早不了多少微秒，网络上任何一点延迟，这一点差异都可忽略不计。

react的生命周期：constructor() -> componentWillMount() -> render() -> componentDidMount()

上面这些方法的调用是有次序的，由上而下依次调用。

constructor被调用是在组件准备要挂载的最开始，此时组件尚未挂载到网页上。

componentWillMount方法的调用在constructor之后，在render之前，在这方法里的代码调用setState方法不会触发重新render，所以它一般不会用来作加载数据之用。

componentDidMount方法中的代码，是在组件已经完全挂载到网页上才会调用被执行，所以可以保证数据的加载。此外，在这方法中调用setState方法，会触发重新渲染。所以，官方设计这个方法就是用来加载外部数据用的，或处理其他的副作用代码。与组件上的数据无关的加载，也可以在constructor里做，但constructor是做组件state初绐化工作，并不是做加载数据这工作的，constructor里也不能setState，还有加载的时间太长或者出错，页面就无法加载出来。所以有副作用的代码都会集中在componentDidMount方法里。

总结：

跟服务器端渲染（同构）有关系，如果在componentWillMount里面获取数据，fetch data会执行两次，一次在服务器端一次在客户端。在componentDidMount中可以解决这个问题，componentWillMount同样也会render两次。

在componentWillMount中fetch data，数据一定在render后才能到达，如果忘记了设置初始状态，用户体验不好。

react16.0以后，componentWillMount可能会被执行多次。


## 3. 组件通信

### 3.1 父子组件的通信方式

父组件向子组件通信：父组件通过 props 向子组件传递需要的信息。
```
// 子组件: Child
const Child = props =>{
  return <p>{props.name}</p>
}
// 父组件 Parent
const Parent = ()=>{
    return <Child name="react"></Child>
}
```

子组件向父组件通信：: props+回调的方式。
```
// 子组件: Child
const Child = props =>{
  const cb = msg =>{
      return ()=>{
          props.callback(msg)
      }
  }
  return (
      <button onClick={cb("你好!")}>你好</button>
  )
}
// 父组件 Parent
class Parent extends Component {
    callback(msg){
        console.log(msg)
    }
    render(){
        return <Child callback={this.callback.bind(this)}></Child>    
    }
}
```


### 3.2 跨级组件的通信方式？

父组件向子组件的子组件通信，向更深层子组件通信

- 使用props，利用中间组件层层传递,但是如果父组件结构较深，那么中间每一层组件都要去传递props，增加了复杂度，并且这些props并不是中间组件自己需要的。
- 使用context，context相当于一个大容器，可以把要通信的内容放在这个容器中，这样不管嵌套多深，都可以随意取用，对于跨越多层的全局数据可以使用context实现。
```
// context方式实现跨级组件通信 
// Context 设计目的是为了共享那些对于一个组件树而言是“全局”的数据
const BatteryContext = createContext();
//  子组件的子组件 
class GrandChild extends Component {
  render(){
      return (
          <BatteryContext.Consumer>
              {
                  color => <h1 style={{"color":color}}>我是红色的:{color}</h1>
              }
          </BatteryContext.Consumer>
      )
  }
}
//  子组件
const Child = () =>{
  return (
      <GrandChild/>
  )
}
// 父组件
class Parent extends Component {
    state = {
        color:"red"
    }
    render(){
        const {color} = this.state
        return (
        <BatteryContext.Provider value={color}>
            <Child></Child>
        </BatteryContext.Provider>
        )
    }
}
```


### 3.3 非嵌套关系组件的通信方式？
即没有任何包含关系的组件，包括兄弟组件以及不在同一个父级中的非兄弟组件。

- 可以使用自定义事件通信（发布订阅模式）
- 可以通过redux等进行全局状态管理
- 如果是兄弟组件通信，可以找到这两个兄弟节点共同的父节点, 结合父子间通信方式进行通信。


### 3.4 如何解决 props 层级过深的问题

- 使用Context API：提供一种组件之间的状态共享，而不必通过显式组件树逐层传递props；
- 使用Redux等状态库。


#### 3.5 组件通信的方式有哪些

- ⽗组件向⼦组件通讯: ⽗组件可以向⼦组件通过传 props 的⽅式，向⼦组件进⾏通讯 
- ⼦组件向⽗组件通讯: props+回调的⽅式，⽗组件向⼦组件传递props进⾏通讯，此props为作⽤域为⽗组件⾃身的函 数，⼦组件调⽤该函数，将⼦组件想要传递的信息，作为参数，传递到⽗组件的作⽤域中 
- 兄弟组件通信: 找到这两个兄弟节点共同的⽗节点,结合上⾯两种⽅式由⽗节点转发信息进⾏通信 
- 跨层级通信: Context 设计⽬的是为了共享那些对于⼀个组件树⽽⾔是“全局”的数据，例如当前认证的⽤户、主题或⾸选语⾔，对于跨越多层的全局数据通过 Context 通信再适合不过 
- 发布订阅模式: 发布者发布事件，订阅者监听事件并做出反应,我们可以通过引⼊event模块进⾏通信 
- 全局状态管理⼯具: 借助Redux或者Mobx等全局状态管理⼯具进⾏通信,这种⼯具会维护⼀个全局状态中⼼Store,并根据不同的事件产⽣新的状态

## 4. 路由 React Router
### 4.1 实现原理

单页面应用路由实现原理是，切换url，监听url变化，从而渲染不同的页面组件。
主要的方式有history模式和hash模式。

#### history模式原理

- 改变路由 
    - history.pushState
    ```
    history.pushState(state,title,path)
    ````

    state：一个与指定网址相关的状态对象， popstate 事件触发时，该对象会传入回调函数。如果不需要可填 null。

    title：新页面的标题，但是所有浏览器目前都忽略这个值，可填 null。

    path：新的网址，必须与当前页面处在同一个域。浏览器的地址栏将显示这个地址。


    - history.replaceState
    ```
    history.replaceState(state,title,path)
    ```

    参数和pushState一样，这个方法会修改当前的 history 对象记录， history.length 的长度不会改变。

- 监听路由
    - popstate事件
    ```
    window.addEventListener('popstate',function(e){
        /* 监听改变 */
    })
    ```

    同一个文档的 history 对象出现变化时，就会触发 popstate 事件

    history.pushState 可以使浏览器地址改变，但是无需刷新页面。
    
    **注意⚠️的是**：用 history.pushState() 或者 history.replaceState() 不会触发 popstate 事件。 popstate 事件只会在浏览器某些行为下触发, 比如点击后退、前进按钮或者调用 history.back()、history.forward()、history.go()方法。

#### hash模式原理
- 改变路由 (window.location.hash)
  
    通过window.location.hash  属性获取和设置 hash 值。

- 监听路由 (onhashchange)
    ```
    window.addEventListener('hashchange',function(e){
        /* 监听改变 */
    })
    ```

### 4.2 路由切换

#### v5可以通过以下方式获取路由状态

- props + Route： Route 承载的 ui 组件可以通过 props 来获取路由状态，如果想要把路由状态传递给子孙组件，那么可以通过 props 逐层传递的方式。
- withRouter ： withRouter 是一个高阶组件 HOC ，因为默认只有被 Route 包裹的组件才能获取到路由状态，如果当前非路由组件想要获取状态，那么可以通过 withRouter 包裹来获取 history ，location 等信息。
- useHistory ：函数组件可以通过 useHistory 获取 history 对象。
- useLocation ：函数组件可以通过 useLocation 获取 location 对象。

#### v5通过以下方式实现路由跳转
上面介绍了路由状态获取，那么还有一个场景就是切换路由，那么 v5 主要是通过两种方式改变路由：

- 通过 react-router-dom 内置的 Link， NavLink 组件来实现路由跳转。

    `<Link>` 组件来在你的应用程序中创建链接。无论你在何处渲染一个 `<Link>` ，都会在应用程序的 HTML 中渲染锚（`<a>`）。

    ```
    <Link to="/">Home</Link>   
    // <a href='/'>Home</a>
    ```

    `<NavLink>` 是一种特殊类型的 `<Link>` 当它的 to属性与当前地址匹配时，可以将其定义为"活跃的"。
    ```
    // location = { pathname: '/react' }
    <NavLink to="/react" activeClassName="hurray">
        React
    </NavLink>
    // <a href='/react' className='hurray'>React</a>
    ```

    当我们想强制导航时，可以渲染一个`<Redirect>`，当一个`<Redirect>`渲染时，它将使用它的to属性进行定向。

- 通过 history 对象下面的路由跳转方法，比如 push 等，来实现路由的跳转。

#### v6 状态获取： 

对于路由状态 location 的获取 ，可以用自定义 hooks 中 **useLocation** 。location 里面保存了 hash | key | pathname | search | state 等状态。


#### v6 路由跳转：

新版路由提供了 useNavigate ，实现路由的跳转。具体用法参考如下代码：

```
function Home (){
    const navigate = useNavigate()
    return <div>
       <button onClick={() => navigate('/list',{ state:'alien' })  }  >
         跳转列表页
      </button>
    </div>
}
```

navigate： 第一参数是跳转路径，第二个参数是描述的路由状态信息，可以传递 state 等信息。

### 4.3 React-Router怎么设置重定向？
使用`<Redirect>`组件实现路由的重定向：
```
<Switch>
  <Redirect from='/users/:id' to='/users/profile/:id'/>
  <Route path='/users/profile/:id' component={Profile}/>
</Switch>
```
当请求  `/users/:id ` 被重定向去  `'/users/profile/:id' `：

- 属性  `from: string `：需要匹配的将要被重定向路径。
- 属性  `to: string `：重定向的 URL 字符串
- 属性  `to: object `：重定向的 location 对象
- 属性  `push: bool `：若为真，重定向操作将会把新地址加入到访问历史记录里面，并且无法回退到前面的页面。

### 4.4 react-router 里的 Link 标签和 a 标签的区别

从最终渲染的 DOM 来看，这两者都是链接，都是标签，区别是∶ 

`<Link>`是react-router 里实现路由跳转的链接，一般配合`<Route> `使用，react-router接管了其默认的链接跳转行为，区别于传统的页面跳转，`<Link>` 的“跳转”行为只会触发相匹配的`<Route>`对应的页面内容更新，而不会刷新整个页面。

`<Link>`做了3件事情:

- 有onclick那就执行onclick
- click的时候阻止a标签默认事件
- 根据跳转href(即是to)，用history (web前端路由两种方式之一，history & hash)跳转，此时只是链接变了，并没有刷新页面而`<a>`标签就是普通的超链接了，用于从当前页面跳转到href指向的另一 个页面(非锚点情况)。

### 4.5 React-Router如何获取URL的参数和历史对象？

#### 获取URL的参数
- get传值
  
  路由配置还是普通的配置，如：`admin`，传参方式如：`admin?id='1111'`。通过`this.props.location.search`获取url获取到一个字符串`?id='1111`
  可以用url，qs，querystring，浏览器提供的api URLSearchParams对象或者自己封装的方法去解析出id的值。
- 动态路由传值
  
  路由需要配置成动态路由：如`path='/admin/:id'`，传参方式，如`'admin/111'`。通过`this.props.match.params.id` 取得url中的动态路由id部分的值，除此之外还可以通过`useParams（Hooks）`来获取
- 通过query或state传值
  
  传参方式如：在Link组件的to属性中可以传递对象`{pathname:'/admin',query:'111',state:'111'};`。通过`this.props.location.state`或`this.props.location.query`来获取即可，传递的参数可以是对象、数组等，但是存在缺点就是只要刷新页面，参数就会丢失。

#### 获取历史对象

如果React >= 16.8 时可以使用 React Router中提供的Hooks
```
import { useHistory } from "react-router-dom";
let history = useHistory();
```

使用this.props.history获取历史对象
```
let history = this.props.history;
```

### 4.6. React-Router 4怎样在路由变化时重新渲染同一个组件？
当路由变化时，即组件的props发生了变化，会调用componentWillReceiveProps等生命周期钩子。那需要做的只是： 当路由改变时，根据路由，也去请求数据：

```
class NewsList extends Component {
  componentDidMount () {
     this.fetchData(this.props.location);
  }
  
  fetchData(location) {
    const type = location.pathname.replace('/', '') || 'top'
    this.props.dispatch(fetchListData(type))
  }
  componentWillReceiveProps(nextProps) {
     if (nextProps.location.pathname != this.props.location.pathname) {
         this.fetchData(nextProps.location);
     } 
  }
  render () {
    ...
  }
}
```

利用生命周期componentWillReceiveProps，进行重新render的预处理操作。

### 4.7 React-Router的路由有几种模式？
React-Router 支持使用 hash（对应 HashRouter）和 browser（对应 BrowserRouter） 两种路由规则， react-router-dom 提供了 BrowserRouter 和 HashRouter 两个组件来实现应用的 UI 和 URL 同步：

- BrowserRouter 创建的 URL 格式：http://xxx.com/path
- HashRouter 创建的 URL 格式：http://xxx.com/#/path

#### BrowserRouter
它使用 HTML5 提供的 history API（pushState、replaceState 和 popstate 事件）来保持 UI 和 URL 的同步。由此可以看出，BrowserRouter 是使用 HTML 5 的 history API 来控制路由跳转的：
```
<BrowserRouter
    basename={string}
    forceRefresh={bool}
    getUserConfirmation={func}
    keyLength={number}
/>
```
其中的属性如下：
- basename 所有路由的基准 URL。basename 的正确格式是前面有一个前导斜杠，但不能有尾部斜杠；
  ```
  <BrowserRouter basename="/calendar">
      <Link to="/today" />
  </BrowserRouter>
  ```
  等同于
  ```
  <a href="/calendar/today" />
  ```
- forceRefresh 如果为 true，在导航的过程中整个页面将会刷新。一般情况下，只有在不支持 HTML5 history API 的浏览器中使用此功能；
- getUserConfirmation 用于确认导航的函数，默认使用 window.confirm。例如，当从 /a 导航至 /b 时，会使用默认的 confirm 函数弹出一个提示，用户点击确定后才进行导航，否则不做任何处理；

```
// 这是默认的确认函数
const getConfirmation = (message, callback) => {
  const allowTransition = window.confirm(message);
  callback(allowTransition);
}
<BrowserRouter getUserConfirmation={getConfirmation} />
```
> 需要配合`<Prompt>` 一起使用。
- KeyLength 用来设置 Location.Key 的长度。

#### HashRouter
使用 URL 的 hash 部分（即 window.location.hash）来保持 UI 和 URL 的同步。由此可以看出，HashRouter 是通过 URL 的 hash 属性来控制路由跳转的：
```
<HashRouter
    basename={string}
    getUserConfirmation={func}
    hashType={string}  
/>
```
其中的参数如下：
- basename, getUserConfirmation 和 `BrowserRouter` 功能一样；
- hashType window.location.hash 使用的 hash 类型，有如下几种：
- slash - 后面跟一个斜杠，例如 #/ 和 #/sunshine/lollipops；
- noslash - 后面没有斜杠，例如 # 和 #sunshine/lollipops；
- hashbang - Google 风格的 ajax crawlable，例如 #!/ 和 #!/sunshine/lollipops。

### 4.8 React-Router 4的Switch有什么用？
Switch 通常被用来包裹 Route，用于渲染与路径匹配的第一个子 `<Route>` 或 `<Redirect>`，它里面不能放其他元素。
假如不加 `<Switch>` ：
```
import { Route } from 'react-router-dom'
<Route path="/" component={Home}></Route>
<Route path="/login" component={Login}></Route>
```
Route 组件的 path 属性用于匹配路径，因为需要匹配 `/` 到 `Home`，匹配 `/login` 到 `Login`，所以需要两个 Route，但是不能这么写。

这样写的话，当 URL 的 path 为 “/login” 时，`<Route path="/" />`和`<Route path="/login" />` 都会被匹配，因此页面会展示 Home 和 Login 两个组件。这时就需要借助 `<Switch>` 来做到只显示一个匹配组件：
```
import { Switch, Route} from 'react-router-dom'
    
<Switch>
    <Route path="/" component={Home}></Route>
    <Route path="/login" component={Login}></Route>
</Switch>
```
此时，再访问 “/login” 路径时，却只显示了 Home 组件。这是就用到了exact属性，它的作用就是精确匹配路径，经常与`<Switch>` 联合使用。只有当 URL 和该 `<Route>` 的 path 属性**完全一致**的情况下才能匹配上：
```
import { Switch, Route} from 'react-router-dom'
   
<Switch>
   <Route exact path="/" component={Home}></Route>
   <Route exact path="/login" component={Login}></Route>
</Switch>
```

## 5. Redux 和 Mobx

### 5.1 Redux 的理解？解决什么问题
React是视图层框架。Redux是一个用来管理数据状态和UI状态的JavaScript应用工具。随着JavaScript单页应用（SPA）开发日趋复杂， JavaScript需要管理比任何时候都要多的state（状态）， Redux就是降低管理难度的。（Redux支持React、Angular、jQuery甚至纯JavaScript）。

在 React 中，UI 以组件的形式来搭建，组件之间可以嵌套组合。但 React 中组件间通信的数据流是单向的，顶层组件可以通过 props 属性向下层组件传递数据，而下层组件不能向上层组件传递数据，兄弟组件之间同样不能。这样简单的单向数据流支撑起了 React 中的数据可控性。

当项目越来越大的时候，管理数据的事件或回调函数将越来越多，也将越来越不好管理。管理不断变化的 state 非常困难。如果一个 model 的变化会引起另一个 model 变化，那么当 view 变化时，就可能引起对应 model 以及另一个 model 的变化，依次地，可能会引起另一个 view 的变化。直至你搞不清楚到底发生了什么。state 在什么时候，由于什么原因，如何变化已然不受控制。 

当系统变得错综复杂的时候，想重现问题或者添加新功能就会变得举步维艰。如果这还不够糟糕，考虑一些来自前端开发领域的新需求，如更新调优、服务端渲染、路由跳转前请求数据等。state 的管理在大项目中相当复杂。

Redux 提供了一个叫 store 的统一仓储库，组件通过 dispatch 将 state 直接传入store，不用通过其他的组件。并且组件通过 subscribe 从 store获取到 state 的改变。使用了 Redux，所有的组件都可以从 store 中获取到所需的 state，他们也能从store 获取到 state 的改变。这比组件之间互相传递数据清晰明朗的多。

主要解决的问题：
单纯的Redux只是一个状态机，是没有UI呈现的，react-redux作用是将Redux的状态机和React的UI呈现绑定在一起，当你dispatch action改变state的时候，会自动更新页面。

### 5.2 Redux 原理及工作流程

#### 原理
Redux源码主要分为以下几个模块文件
- compose.js 提供从右到左进行函数式编程
- createStore.js 提供作为生成唯一store的函数
- combineReducers.js 提供合并多个reducer的函数，保证store的唯一性
- bindActionCreators.js 可以让开发者在不直接接触dispacth的前提下进行更改state的操作
- applyMiddleware.js 这个方法通过中间件来增强dispatch的功能
  
#### 工作流程
- const store= createStore（fn）生成数据; 
- action: {type: Symble('action01), payload:'payload' }定义行为; 
- dispatch发起action：store.dispatch(doSomething('action001')); 
- reducer：处理action，返回新的state;


通俗点解释：
- 首先，用户（通过View）发出Action，发出方式就用到了dispatch方法
- 然后，Store自动调用Reducer，并且传入两个参数：当前State和收到的Action，Reducer会返回新的State
- State—旦有变化，Store就会调用监听函数，来更新View


以 store 为核心，可以把它看成数据存储中心，但是他要更改数据的时候不能直接修改，数据修改更新的角色由Reducers来担任，store只做存储，中间人，当Reducers的更新完成以后会通过store的订阅来通知react component，组件把新的状态重新获取渲染，组件中也能主动发送action，创建action后这个动作是不会执行的，所以要dispatch这个action，让store通过reducers去做更新React Component 就是react的每个组件。

### 5.3 Redux 中异步的请求怎么处理
可以在 componentDidmount 中直接进⾏请求⽆须借助redux。但是在⼀定规模的项⽬中,上述⽅法很难进⾏异步流的管理,通常情况下我们会借助redux的异步中间件进⾏异步处理。redux异步流中间件其实有很多，当下主流的异步中间件有两种redux-thunk、redux-saga。

Redux 的中间件提供的是位于 action 被发起之后，到达 reducer 之前的扩展点，换而言之，原本 view -→> action -> reducer -> store 的数据流加上中间件后变成了 view -> action -> middleware -> reducer -> store ，在这一环节可以做一些"副作用"的操作，如异步请求、打印日志等。


#### 5.3.1 使用react-thunk中间件
使用步骤：

配置中间件，在store的创建中配置
```
import {createStore, applyMiddleware, compose} from 'redux';
import reducer from './reducer';
import thunk from 'redux-thunk'
// 设置调试工具
const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ ? window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__({}) : compose;
// 设置中间件
const enhancer = composeEnhancers(
  applyMiddleware(thunk)
);
const store = createStore(reducer, enhancer);
export default store;

```
添加一个返回函数的actionCreator，将异步请求逻辑放在里面
```
/**
  发送get请求，并生成相应action，更新store的函数
  @param url {string} 请求地址
  @param func {function} 真正需要生成的action对应的actionCreator
  @return {function} 
// dispatch为自动接收的store.dispatch函数 
export const getHttpAction = (url, func) => (dispatch) => {
    axios.get(url).then(function(res){
        const action = func(res.data)
        dispatch(action)
    })
  }
```

生成action，并发送action
```
componentDidMount(){
    var action = getHttpAction('/getData', getInitTodoItemAction)
    // 发送函数类型的action时，该action的函数体会自动执行
    store.dispatch(action)
}

```

>redux-thunk优点: 
>
>- 体积⼩: redux-thunk的实现⽅式很简单,只有不到20⾏代码 
>- 使⽤简单: redux-thunk没有引⼊像redux-saga或者redux-observable额外的范式,上⼿简单 
>
>redux-thunk缺陷: 
>
>- 样板代码过多: 与redux本身⼀样,通常⼀个请求需要⼤量的代码,⽽且很多都是重复性质的 
>- 耦合严重: 异步操作与redux的action偶合在⼀起,不⽅便管理 
>- 功能孱弱: 有⼀些实际开发中常⽤的功能需要⾃⼰进⾏封装 


#### 5.3.2 使用redux-saga中间件
redux-saga优点: 
- 异步解耦: 异步操作被被转移到单独 saga.js 中，不再是掺杂在 action.js 或 component.js 中 
- action摆脱thunk function: dispatch 的参数依然是⼀个纯粹的 action (FSA)，⽽不是充满 “⿊魔法” thunk function 
- 异常处理: 受益于 generator function 的 saga 实现，代码异常/请求失败 都可以直接通过 try/catch 语法直接捕获处理
- 功能强⼤: redux-saga提供了⼤量的Saga 辅助函数和Effect 创建器供开发者使⽤,开发者⽆须封装或者简单封装即可使⽤ 
- 灵活: redux-saga可以将多个Saga可以串⾏/并⾏组合起来,形成⼀个⾮常实⽤的异步flow 
- 易测试，提供了各种case的测试⽅案，包括mock task，分⽀覆盖等等 
redux-saga缺陷: 
- 额外的学习成本: redux-saga不仅在使⽤难以理解的 generator function,⽽且有数⼗个API,学习成本远超redux-thunk,最重要的是你的额外学习成本是只服务于这个库的,与redux-observable不同,redux-observable虽然也有额外学习成本但是背后是rxjs和⼀整套思想 
- 体积庞⼤: 体积略⼤,代码近2000⾏，min版25KB左右 
- 功能过剩: 实际上并发控制等功能很难⽤到,但是我们依然需要引⼊这些代码 
- ts⽀持不友好: yield⽆法返回TS类型 


redux-saga可以捕获action，然后执行一个函数，那么可以把异步代码放在这个函数中，使用步骤如下：

配置中间件
```
import {createStore, applyMiddleware, compose} from 'redux';
import reducer from './reducer';
import createSagaMiddleware from 'redux-saga'
import TodoListSaga from './sagas'
const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ ? window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__({}) : compose;
const sagaMiddleware = createSagaMiddleware()
const enhancer = composeEnhancers(
  applyMiddleware(sagaMiddleware)
);
const store = createStore(reducer, enhancer);
sagaMiddleware.run(TodoListSaga)
export default store;

```

将异步请求放在sagas.js中
```
import {takeEvery, put} from 'redux-saga/effects'
import {initTodoList} from './actionCreator'
import {GET_INIT_ITEM} from './actionTypes'
import axios from 'axios'
function* func(){
    try{
        // 可以获取异步返回数据
        const res = yield axios.get('/getData')
        const action = initTodoList(res.data)
        // 将action发送到reducer
        yield put(action)
    }catch(e){
        console.log('网络请求失败')
    }
}
function* mySaga(){
    // 自动捕获GET_INIT_ITEM类型的action，并执行func
    yield takeEvery(GET_INIT_ITEM, func)
}
export default mySaga

```

发送action
```
componentDidMount(){
  const action = getInitTodoItemAction()
  store.dispatch(action)
}
```

### 5.4 Redux 怎么实现属性传递 
react-redux 数据传输∶ view-->action-->reducer-->store-->view。看下点击事件的数据是如何通过redux传到view上：
- view 上的AddClick 事件通过mapDispatchToProps 把数据传到action ---> click:()=>dispatch(ADD)
- action 的ADD 传到reducer上
- reducer传到store上 const store = createStore(reducer);
- store再通过 mapStateToProps 映射穿到view上text:State.text

代码示例∶
```
import React from 'react';
import ReactDOM from 'react-dom';
import { createStore } from 'redux';
import { Provider, connect } from 'react-redux';
class App extends React.Component{
    render(){
        let { text, click, clickR } = this.props;
        return(
            <div>
                <div>数据:已有人{text}</div>
                <div onClick={click}>加人</div>
                <div onClick={clickR}>减人</div>
            </div>
        )
    }
}
const initialState = {
    text:5
}
const reducer = function(state,action){
    switch(action.type){
        case 'ADD':
            return {text:state.text+1}
        case 'REMOVE':
            return {text:state.text-1}
        default:
            return initialState;
    }
}
    type:'ADD'
}
let Remove = {
    type:'REMOVE'
}
const store = createStore(reducer);
let mapStateToProps = function (state){
    return{
        text:state.text
    }
}
let mapDispatchToProps = function(dispatch){
    return{
        click:()=>dispatch(ADD),
        clickR:()=>dispatch(Remove)
    }
}
const App1 = connect(mapStateToProps,mapDispatchToProps)(App);
ReactDOM.render(
    <Provider store = {store}>
        <App1></App1>
    </Provider>,document.getElementById('root')
)
```

### 5.5 Redux 请求中间件如何处理并发
使用redux-Saga

redux-saga是一个管理redux应用异步操作的中间件，用于代替 redux-thunk 的。它通过创建 Sagas 将所有异步操作逻辑存放在一个地方进行集中处理，以此将react中的同步操作与异步操作区分开来，以便于后期的管理与维护。 redux-saga如何处理并发：
- takeEvery
可以让多个 saga 任务并行被 fork 执行。
```
import {
    fork,
    take
} from "redux-saga/effects"
const takeEvery = (pattern, saga, ...args) => fork(function*() {
    while (true) {
        const action = yield take(pattern)
        yield fork(saga, ...args.concat(action))
    }
```

- takeLatest
takeLatest 不允许多个 saga 任务并行地执行。一旦接收到新的发起的 action，它就会取消前面所有 fork 过的任务（如果这些任务还在执行的话）。
在处理 AJAX 请求的时候，如果只希望获取最后那个请求的响应， takeLatest 就会非常有用。
```
import {
    cancel,
    fork,
    take
} from "redux-saga/effects"
const takeLatest = (pattern, saga, ...args) => fork(function*() {
    let lastTask
    while (true) {
        const action = yield take(pattern)
        if (lastTask) {
            yield cancel(lastTask) // 如果任务已经结束，则 cancel 为空操作
        }
        lastTask = yield fork(saga, ...args.concat(action))
    }
})
```

### 5.6 mobx 和 redux 有什么区别？

共同点

- 为了解决状态管理混乱，无法有效同步的问题统一维护管理应用状态;
- 某一状态只有一个可信数据来源（通常命名为store，指状态容器）;
- 操作更新状态方式统一，并且可控（通常以action方式提供更新状态的途径）;
- 支持将store与React组件连接，如react-redux，mobx- react;

区别

Redux更多的是遵循Flux模式的一种实现，是一个 JavaScript库，它关注点主要是以下几方面∶ 
- Action 
  一个JavaScript对象，描述动作相关信息，主要包含type属性和payload属性∶ 
  - type∶ action 类型; 
  - payload∶ 负载数据;

- Reducer∶ 定义应用状态如何响应不同动作（action），如何更新状态;
- Store∶ 
    管理action和reducer及其关系的对象，主要提供以下功能∶ 
  - 维护应用状态并支持访问状态(getState());
  - 支持监听action的分发，更新状态(dispatch(action)); 
  - 支持订阅store的变更(subscribe(listener));

- 异步流∶ 由于Redux所有对store状态的变更，都应该通过action触发，异步任务（通常都是业务或获取数据任务）也不例外，而为了不将业务或数据相关的任务混入React组件中，就需要使用其他框架配合管理异步任务流程，如redux-thunk，redux-saga等; 
  
Mobx是一个透明函数响应式编程的状态管理库，它使得状态管理简单可伸缩∶
- Action∶定义改变状态的动作函数，包括如何变更状态;
- Store∶ 集中管理模块状态（State）和动作(action)
- Derivation（衍生）∶ 从应用状态中派生而出，且没有任何其他影响的数据


对比总结：
- redux将数据保存在单一的store中，mobx将数据保存在分散的多个store中
- redux使用plain object保存数据，需要手动处理变化后的操作;mobx适用observable保存数据，数据变化后自动处理响应的操作
- redux使用不可变状态，这意味着状态是只读的，不能直接去修改它，而是应该返回一个新的状态，同时使用纯函数;**mobx中的状态是可变的，可以直接对其进行修改**
- mobx相对来说比较简单，在其中有很多的抽象，mobx更多的使用面向对象的编程思维;redux会比较复杂，因为其中的函数式编程思想掌握起来不是那么容易，同时需要借助一系列的中间件来处理异步和副作用
- mobx中有更多的抽象和封装，调试会比较困难，同时结果也难以预测;而redux提供能够进行时间回溯的开发工具，同时其纯函数以及更少的抽象，让调试变得更加的容易

### 5.7 Redux 和 Vuex 有什么区别，它们的共同思想

Redux 和 Vuex 区别

- Vuex改进了Redux中的Action和Reducer函数，以mutations变化函数取代Reducer，无需switch，只需在对应的mutation函数里改变state值即可
- Vuex由于Vue自动重新渲染的特性，无需订阅重新渲染函数，只要生成新的State即可
- Vuex数据流的顺序是∶View调用store.commit提交对应的请求到Store中对应的mutation函数->store改变（vue检测到数据变化自动渲染）

通俗点理解就是，vuex 弱化 dispatch，通过commit进行 store状态的一次更变；取消了action概念，不必传入特定的 action形式进行指定变更；弱化reducer，基于commit参数直接对数据进行转变，使得框架更加简易; 

Redux 使用的是不可变数据，而Vuex的数据是可变的。Redux每次都是用新的state替换旧的state，而Vuex是直接修改
Redux 在检测数据变化的时候，是通过 diff 的方式比较差异的，而Vuex其实和Vue的原理一样，是通过 getter/setter来比较的（如果看Vuex源码会知道，其实他内部直接创建一个Vue实例用来跟踪数据变化）

共同思想

- 单一的数据源 
- 变化可以预测
  
本质上∶ redux与vuex都是对mvvm思想的服务，将数据从视图中抽离的一种方案。

### 5.8 Redux 中间件是怎么拿到store 和 action? 然后怎么处理?

Redux 的中间件提供的是位于 action 被发起之后，到达 reducer 之前的扩展点，换而言之，原本 view -→> action -> reducer -> store 的数据流加上中间件后变成了 view -> action -> middleware -> reducer -> store ，在这一环节可以做一些"副作用"的操作，如异步请求、打印日志等。

applyMiddleware源码：
```
export default function applyMiddleware(...middlewares) {
    return createStore => (...args) => {
        // 利用传入的createStore和reducer和创建一个store
        const store = createStore(...args)
        let dispatch = () => {
            throw new Error()
        }
        const middlewareAPI = {
            getState: store.getState,
            dispatch: (...args) => dispatch(...args)
        }
        // 让每个 middleware 带着 middlewareAPI 这个参数分别执行一遍
        const chain = middlewares.map(middleware => middleware(middlewareAPI))
        // 接着 compose 将 chain 中的所有匿名函数，组装成一个新的函数，即新的 dispatch
        dispatch = compose(...chain)(store.dispatch)
        return {
            ...store,
            dispatch
        }
    }
}
```

redux中间件本质就是一个函数柯里化。redux applyMiddleware Api 源码中每个middleware 接受2个参数， Store 的getState 函数和dispatch 函数，分别获得store和action，最终返回一个函数。

该函数会被传入 next 的下一个 middleware 的 dispatch 方法，并返回一个接收 action 的新函数，这个函数可以直接调用 next（action），或者在其他需要的时刻调用，甚至根本不去调用它。

调用链中最后一个 middleware 会接受真实的 store的 dispatch 方法作为 next 参数，并借此结束调用链。所以，middleware 的函数签名是（{ getState，dispatch })=> next => action。

### 5.9 Redux中的connect有什么作用
connect负责连接React和Redux

- 获取state

connect 通过 context获取 Provider 中的 store，通过`store.getState()` 获取整个store tree 上所有state 

- 包装原组件

将state和action通过props的方式传入到原组件内部 wrapWithConnect 返回—个 ReactComponent 对 象 Connect，Connect 重 新 render 外部传入的原组件 WrappedComponent ，并把 connect 中传入的 mapStateToProps，mapDispatchToProps与组件上原有的 props合并后，通过属性的方式传给WrappedComponent 

- 监听store tree变化

connect缓存了store tree中state的状态，通过当前state状态 和变更前 state 状态进行比较，从而确定是否调用 `this.setState()`方法触发Connect及其子组件的重新渲染

## 6. Hooks

### 6.1 Hook的理解
Hook 是 React 16.8 的新增特性。它可以让你在不编写 class 的情况下使用 state 以及其他的 React 特性

至于为什么引入hook，官方给出的动机是解决长时间使用和维护react过程中常遇到的问题，例如：

- 难以重用和共享组件中的与状态相关的逻辑
- 逻辑复杂的组件难以开发与维护，当我们的组件需要处理多个互不相关的 local state 时，每个生命周期函数中可能会包含着各种互不相关的逻辑在里面
- 类组件中的this增加学习成本，类组件在基于现有工具的优化上存在些许问题
- 由于业务变动，函数组件不得不改为类组件等等
- 在以前，函数组件也被称为无状态的组件，只负责渲染的一些工作

因此，现在的函数组件也可以是有状态的组件，内部也可以维护自身的状态以及做一些逻辑方面的处理

### 6.2 useState()

