/**
 * Author: secondriver
 * Created: 2019/4/22
 */
package com.bittech;

/*
线程的创建：

1.
1.1 自定义类继承java.lang.Thread类，覆写run方法
1.2 实例化自定义类对象，该对象就是一个具备线程执行的对象
1.3 线程类的对象run方法直接调用和普通类的对象调用没有区别
+ 直接调用run方法，实际还是同步执行，跟线程没关系
+ 调用start方法，才会异步执行，跟线程有关系，该方法不能多次调用
1.4 native修饰的方法称为本地方法，需要依赖平台实现 JNI(Java Native Interface)

2.

业务无返回结果：
2.1 自定义类实现java.lang.Runnable接口，实现run方法
2.2 实例化Thread类对象，通过构造方法传入Runnable接口的实现类的实例化对象或者一个Lambda表达式
2.3 线程的启动方式start

业务有返回结果：
2.1 自定义类实现java.util.concurrent.Callable接口，实现call方法
2.2 FutureTask 包装 Callable接口实现类的对象
2.3 实例化Thread类对象，通过构造方法传入FutureTask对象
2.4 通过Thread对象的start方法启动线程
2.5 通过FutureTask对象的get方法获取结果（阻塞方法）

继承Thread vs 实现Runnable/Callable
继承Thread:
+ 单继承缺陷
+ 业务逻辑和线程逻辑耦合
实现Runnable
+ 解决Thread的继承缺陷，实现多接口
+ 业务逻辑和线程逻辑无关
+ 创建Thread对象，传入业务对象
+ 业务逻辑能够复用

3. 创建线程池的方式使用线程

4. 线程方法
4.1 线程名称
+ 线程创建建议设置一个简明思议的名称（表示线程的功能）
+ 获取当前线程Thread.currentThread()
+ 获取线程名称thread.getName()
+ 线程名称：普通线程名称  thread-index , 主线程名称：main
+ Java程序启动，创建JVM进程，创建main线程，JVM进程中至少有一个线程（实际上JVM启动之后除了main线程外，还有其它线程，比如垃圾回收线程）
+ Java中线程是最小的执行单元，JVM进程线程不存在了，JVM进程退出

4.2 sleep
+ Thread类的静态方法
+ 让当前线程暂缓执行一定的时间，当时间到了继续执行
+ 交出CPU , 不释放对象锁，线程回到阻塞

4.3 yield
+ Thread类的静态方法
+ 让当前线程暂定执行
+ 交出CPU(想要获得该CPU权限的线程必须和当前线程优先级相同)，
  交出CPU的时间点不能控制，
  不释放对象锁，线程回到就绪

4.4 join
+ Thread类的成员方法，通过线程对象调用
+ 如果在一个线程A中调用另外一个线程B的join方法（指定时间），那么这个线程A将休眠，直到线程B的run方法执行完毕，线程A将继续执行

5. 线程退出

5.1 标记位法（常用）
5.2 线程对象的stop方法（不建议使用，弃用）
    stop会立即停止线程，容易导致同步失败问题，数据不完成等
5.3 中断（常用）
    thread对象的interrupted方法
    中断是信号，不会停止线程
    调用interrupted方法，修改线程的中断标识（true）
    1.如果线程非阻塞，中断标识true
    2.如果线程是阻塞，先中断标识true,然后分析引起阻塞的原因是wait,sleep,join方法引起，中断标识false,抛出中断异常
    中断的意义：让开发者跟进线程的中断标识来决定如何退出程序

6. 优先级
6.1 Java中线程具有优先级，优先级越高的线程约有可能先执行
6.2 线程的优先级 0-10
6.3 通过thread对象的setPriority(int v), getPriority()方法用来修改和获取线程的优先级
6.4 main线程的优先级是 5
6.5 线程的优先级具有继承性，比如：线程A的优先级是v,那么在线程A中创建的线程优先级默认就是v

7. 守护线程
7.1 Java中线程分为两类：用户线程（非守护线程），守护线程
7.2 守护线程用来守护用户线程，通常守护线程业务是持续执行的代码
7.3 当JVM中最后一个用户线程退出，守护线程将和JVM一同退出
7.4 Thread对象创建默认是用户线程，如果要设置守护线程，必须在start之前调用setDaemon(true)

8. 同步
8.1 synchronized关键字做同步处理
8.2 synchronized加在方法上表示同步方法
    synchronized(锁对象)加在代码块上表示同步代码块

8.3 synchronized
    加载成员方法上，对方法所属的对象加锁
    加载静态方法上，对方法所属的类的类对象加锁
    
    synchronized(对象)
    对象：
    this 表示当前对象
    Type object= new Type() ( new Object) 表示普通对象
    ClassType.class ( String.class)  表示类对象

*/