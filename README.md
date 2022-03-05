# POS in Shell

The demo shows a simple POS system with command line interface. Currently it implements three commands which you can see using the `help` command.

```shell
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.5.7)
 
shell:>help
AVAILABLE COMMANDS

Built-In Commands
        clear: Clear the shell screen.
        exit, quit: Exit the shell.
        help: Display help about available commands.
        history: Display or save the history of previously run commands
        script: Read and execute commands from a file.
        stacktrace: Display the full stacktrace of the last error.

Pos Command
        a: Add a Product to Cart
        n: New Cart
        p: List Products
```

Everytime a customer come to make a purchase, use `n` to create a new cart and then use `a ${productid} ${amount}` to add a product to the cart.

Please make the POS system robust and fully functional by implementing more commands, for instance, print/empty/modify cart.

Implementing a PosDB with real database is very much welcome.

Please elaborate your understanding in layered systems via this homework in your README.md.



## 	关于分层系统的理解

**计算机的所有问题都可以用缓存和再加一层抽象来解决。**

这个简单的demo基本是三层体系结构。数据层直接使用堆里的对象实现，业务层使用`PosService`实现，基本是对数据层的增删查改以及一些检查。而表示层是用的命令行形式，仿照shell命令进行交互。

这样的好处是可以清楚地看到层和层之间的差异。由于每个组件都是相互独立的，因此它们很容易维护，无需更改整个代码。

当我们考虑为项目编写测试用例时，由于它就像一个模块化架构，因此测试每个模块并跟踪错误非常方便，而无需遍历整个代码。

我也尝试用`redis`来实现它的数据库（我感觉它不适合干这个，只是最近找实习有必要学习才来试试手的），倘若用它来读取Cart会面临序列化的问题，倒是可以用来存Product，但是需要改动Product那边的不少逻辑。



