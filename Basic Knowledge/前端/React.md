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
  - [1.15 受控组件与非受控组件  ](#115-受控组件与非受控组件--)
    - [受控组件](#受控组件)
    - [非受控组件](#非受控组件)
  - [1.16 React Refs 理解 ](#116-react-refs-理解-)
    - [refs的使用](#refs的使用)
    - [回调refs](#回调refs)
  - [1.17 React绑定this的方式 ](#117-react绑定this的方式-)
  - [1.18 React组件构造函数？必须？ ](#118-react组件构造函数必须-)
  - [1.19 类组件与函数组件  ](#119-类组件与函数组件--)
- [2. 生命周期](#2-生命周期)
  - [2.1](#21)
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

### 1.15 受控组件与非受控组件  ![很多考察](https://img.shields.io/badge/-%E5%BE%88%E5%A4%9A%E8%80%83%E5%AF%9F-critical)

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


### 1.19 类组件与函数组件  ![很多考察](https://img.shields.io/badge/-%E5%BE%88%E5%A4%9A%E8%80%83%E5%AF%9F-critical)

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

### 2.1






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