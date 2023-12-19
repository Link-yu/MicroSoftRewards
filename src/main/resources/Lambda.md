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

### 创建流
Collection转换流：list.stream()
数组转换流：Arrays.stream(arr) 或者 Stream.of(arr)
map转换流:map.entrySet().stream

### 中间操作
filter
map
distinct
sorted
limit
skip
flatMap:拆分展平流

### 终结操作
foreach
count
min&max
collect

anyMatch
findAny
findFirst
reduce归并：对流中的数据按照指定的计算方式计算出一个结果。

### 注意事项
惰性求值，如果没有终结操作，中间操作不会生效；
一次求值，进行过一次终结操作，流就无法继续使用；
不会影响原数据；

### Optional


### 方法引用 方法体中只有一行方法
类名或者对象名::方法名

Alt+enter

### 并行流
parallel()

### java.util.function



