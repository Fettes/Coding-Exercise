
// <!DOCTYPE html>
// <html lang="en">
// <head>
//     <meta charset="UTF-8">
//     <meta name="viewport" content="width=device-width, initial-scale=1.0">
//     <meta http-equiv="X-UA-Compatible" content="ie=edge">
//     <title>Vdom与Html的相互转化</title>
// </head>
// <body>

//     <script src="vNode.js"></script>
// </body>
// </html>


// 设置对象属性的方法
var setAttr = function (node, key, value) {
    switch (key) {
        case 'style':
            node.style.cssText = value
            break
        case 'value':
            var tagName = node.tagName || ''
            tagName = tagName.toLowerCase()
            if (tagName === 'input' || tagName === 'textarea') {
                node.value = value
            } else {
                node.setAttribute(key, value)
            }
            break
        default:
            node.setAttribute(key, value)
            break
    }
}

// 虚拟的js对象节点
class VNode {
    // html to vnode
    constructor(tagName, props, children) {
        /*当前节点的标签名*/
        this.tagName = tagName
        /*当前节点的一些数据信息，比如props、attrs等数据*/
        this.props = props
        /*当前节点的子节点，是一个数组*/
        this.children = children
    }

    // vnode to html
    render() {
        // 创建标签
        var el = document.createElement(this.tagName)

        // 设置标签props属性
        var props = this.props
        for (var propName in props) {
            setAttr(el, propName, props[propName])
        }

        // 递归创建子节点children
        this.children.forEach(child => {
            var childNode = (child instanceof VNode) ? child.render() : document.createTextNode(child)
            el.appendChild(childNode)
        })

        return el
    }
}


// html to vNode
var vNode1 = new VNode('div', { 'id': 'container' }, [
    new VNode('h1', { style: 'color:red' }, ['vdom与html相互转换']),
    new VNode('p', {}, ['hello vdom and html']),
    new VNode('ul', {}, [new VNode('li', {}, ['item #1']), new VNode('li', {}, ['item #2'])]),
])

// vNode to html
var rootNode = vNode1.render()
document.body.appendChild(rootNode)