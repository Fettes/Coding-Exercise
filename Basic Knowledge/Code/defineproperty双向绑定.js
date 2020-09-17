function defineReactive (data, key, val) {
    let dep = new Dep()        // 修改
    Object.defineProperty(data, key, {
        enumerable: true,
        configurable: true,
        get: function () {
            dep.depend() // 修改
            return val
        },
        set: function (newVal) {
            if(val === newVal){
                return
            }

            dep.notify() // 新增
            val = newVal
        }
    })
}


export default class Dep {
    static target: ?Watcher;
    id: number;
    subs: Array<Watcher>;
  
    constructor () {
      this.id = uid++
      this.subs = []
    }
  
    addSub (sub: Watcher) {
      this.subs.push(sub)
    }
  
    removeSub (sub: Watcher) {
      remove(this.subs, sub)
    }
  
    depend () {
      if (Dep.target) {
        this.addSub(Dep.target)
      }
    }
  
    notify () {
      // stabilize the subscriber list first
      const subs = this.subs.slice()
      for (let i = 0, l = subs.length; i < l; i++) {
        subs[i].update()
      }
    }
  }

  class Watch {
    constructor (expOrFn, cb) {
        // 执行 this.getter() 就可以拿到 data.a.b.c
        this.getter = parsePath(expOrFn)
        this.cb = cb
        this.value = this.get()
    }

    get () {
        Dep.target = this
        value = this.getter.call(vm, vm)
        Dep.target = undefined
    }

    update () {
        const oldValue = this.value
        this.value = this.get()
        this.cb.call(this.vm, this.value, oldValue)
    }
}


// 新增
function walk (obj: Object) {
    const keys = Object.keys(obj)
    for (let i = 0; i < keys.length; i++) {
      defineReactive(obj, keys[i], obj[keys[i]])
    }
  }
  
  function defineReactive (data, key, val) {
      walk(val) // 新增
      let dep = new Dep()
      Object.defineProperty(data, key, {
          enumerable: true,
          configurable: true,
          get: function () {
              dep.depend()
              return val
          },
          set: function (newVal) {
              if(val === newVal){
                  return
              }
  
              dep.notify()
              val = newVal
          }
      })
  }