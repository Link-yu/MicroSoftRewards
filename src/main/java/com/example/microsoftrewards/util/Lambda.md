### 为什么学

- 看懂代码
- 大数据下处理数据合理
- 代码可读性高
- 消灭嵌套

### 函数式编程思想
函数式编程思想类似于数学中的函数，主要关注的是对数据进行了什么操作。

### Lambda表达式
  核心原则：可推导可省略
  
```java
例子：线程启动
new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("测试1");
    }
}).start();

Lmadba写法
new Thread(() -> {
    System.out.println("测试2");
}).start();
```
为什么可以这样写？
首先runnable要是一个接口，同时只有一个抽象方法。
函数式编程只关注参数和方法体。

### 省略规则
- 参数类型可以省略
- 方法只有一句代码时，大括号return可以省略
- 只有一个参数，小括号也可以省略