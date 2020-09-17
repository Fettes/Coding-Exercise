//1. 遍历法
//声明一个空数组，然后遍历数组中每一项，如果当前项是数组，则继续递归调用iterator方法,否则放入新数组中
function iterator(arr){
    let newarr = []
    arr.forEach(el => {
      if(el instanceof Array){
        newarr=newarr.concat(iterator(el))
      }else{
        newarr.push(el)
      }
    });
    return newarr
  }
  console.log(iterator(arr))


//2. flat()方法 (规定depth)
//flat()方法接受一个参数，表示要拍平的数组层数
//默认拍平一层
//用Infinity关键字作为参数,表示无论嵌套多少层都转为一维数组
arr.flat(Infinity)

//3. 数组reduce()
//reduce()方法会对数组进行从左到右遍历
//参数prev 表示上一次遍历的结果,cur表示遍历的当前项
 function Reduce(ar){
    return  ar.reduce((prev,cur)=>{
     return prev.concat(Array.isArray(cur)? Reduce(cur) : cur) 
        },[])
      }
      console.log(Reduce(arr))

