##Java Exception是什么
异常情形是指阻止当前方法或者作用域继续执行的问题。在java中，异常功能是通过实现比如Throwable，Exception，RuntimeException之类的类，然后还有一些处理异常时候的关键字，
比如throw，throws，try，catch，finally之类的。 所有的异常都是通过Throwable衍生出来的。Throwable把错误进一步划分为 java.lang.Exception 和 java.lang.Error.  java.lang.Error 用来处理系统错误，
例如java.lang.StackOverFlowError 或者 Java.lang.OutOfMemoryError 之类的。然后 Exception用来处理程序错误，请求的资源不可用等等。


那么什么时候才会出现异常呢？只有在你当前的环境下程序无法正常运行下去，也就是说程序已经无法来正确解决问题了，这时它所就会从当前环境中跳出，并抛出异常。抛出异常后，它首先会做几件事。
首先，它会使用new创建一个异常对象，然后在产生异常的位置终止程序，并且从当前环境中弹出对异常对象的引用，这时。异常处理机制就会接管程序，并开始寻找一个恰当的地方来继续执行程序，这个恰当的地方就是异常处理程序，
它的任务就是将程序从错误状态恢复，以使程序要么换一种方法执行，要么继续执行下去。

总的来说异常处理机制就是当程序发生异常时，它强制终止程序运行，记录异常信息并将这些信息反馈给我们，由我们来确定是否处理异常。

![Exception](https://github.com/XFHNever/JobPrepare/blob/master/images/exception1-1.png)

##error和exception区别
Error为错误，表示恢复不是不可能但很困难的情况下的一种严重问题，如OutOfMemoryError、ThreadDeath等，出现这种情况你唯一能做的就是听之任之，交由JVM来处理，不过JVM在大多数情况下会选择终止线程。

Exception是程序可以处理的异常，表示一种设计或实现问题。也就是说，它表示如果程序运行正常，从不会发生的情况。
## Java中的检查型异常和非检查型异常有什么区别
CheckException发生在编译阶段，必须要使用try…catch（或者throws）否则编译不通过。

而UncheckedException发生在运行期，具有不确定性，主要是由于程序的逻辑问题所引起的，难以排查，我们一般都需要纵观全局才能够发现这类的异常错误，
所以在程序设计中我们需要认真考虑，好好写代码，尽量处理异常，即使产生了异常，也能尽量保证程序朝着有利方向发展。

所以：对于可恢复的条件使用被检查的异常（CheckedException），对于程序错误（言外之意不可恢复，大错已经酿成）使用运行时异常（RuntimeException）。

##throw 和 throws这两个关键字在java中有什么不同
throws总是出现在一个函数头中，用来标明该成员函数可能抛出的各种异常, 你也可以申明未检查的异常，但这不是编译器强制的。如果方法抛出了异常那么调用这个方法的时候就需要将这个异常处理。
另一个关键字  throw 是用来抛出任意异常的，按照语法你可以抛出任意 Throwable (i.e. Throwable 或任何Throwable的衍生类) , throw可以中断程序运行，因此可以用来代替return . 
最常见的例子是用 throw 在一个空方法中需要return的地方抛出 UnSupportedOperationException 代码如下 :

    private static voidshow() {  
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
##Java中异常处理机制的简单原理
异常是指java程序运行时（非编译）所发生的非正常情况或错误，与现实生活中的事件很相似，现实生活中的事件可以包含事件发生的时间、地点、人物、情节等信息，
可以用一个对象来表示，Java使用面向对象的方式来处理异常，它把程序中发生的每个异常也都分别封装到一个对象来表示的，该对象中包含有异常的信息。

Java对异常进行了分类，不同类型的异常分别用不同的Java类表示，所有异常的根类为java.lang.Throwable，Throwable下面又派生了两个子类：Error和Exception，
Error 表示应用程序本身无法克服和恢复的一种严重问题，程序只有死的份了，例如，说内存溢出和线程死锁等系统问题。Exception表示程序还能够克服和恢复的问题，
其中又分为系统异常和普通异常，系统异常是软件本身缺陷所导致的问题，也就是软件开发人员考虑不周所导致的问题，软件使用者无法克服和恢复这种问题，但在这种问题下还可以让软件系统继续运行或者让软件死掉，
例如，数组脚本越界（ArrayIndexOutOfBoundsException），空指针异常（NullPointerException）、类转换异常（ClassCastException）；普通异常是运行环境的变化或异常所导致的问题，是用户能够克服的问题，
例如，网络断线，硬盘空间不够，发生这样的异常后，程序不应该死掉。

##try{}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，在return前还是后？
会执行，实际上是在return过程中执行的。

Return并不是让函数马上返回，而是return语句执行后，将把返回结果放置进函数栈中，此时函数并不是马上返回，它要执行finally语句后才真正开始返回。

只有在try里面是有System.exit(0)来退出JVM的情况下finally块中的代码才不会执行。

##既然我们可以用RuntimeException来处理错误，那么你认为为什么Java中还存在检查型异常?
存在检查型异常是一个设计上的决定，受到了诸如C++等比Java更早的编程语言设计经验的影响。绝大多数检查型异常位于java.io包内，这是合乎情理的，因为在你请求了不存在的系统资源的时候，一段强壮的程序必须能够优雅的处理这种情况。通过把IOException声明为检查型异常，Java 确保了你能够优雅的对异常进行处理。

另一个可能的理由是，可以使用catch或finally来确保数量受限的系统资源（比如文件描述符）在你使用后尽早得到释放。
##在Java异常处理的过程中，你遵循的那些最好的实践是什么
- 调用方法的时候返回布尔值来代替返回null，这样可以 NullPointerException。由于空指针是java异常里最恶心的异常.
- catch块里别不写代码。空catch块是异常处理里的错误事件，因为它只是捕获了异常，却没有任何处理或者提示。通常你起码要打印出异常信息，当然你最好根据需求对异常信息进行处理。
- catch语句应当尽量指定具体的异常类型，而不应该指定涵盖范围太广的Exception类。 不要一个Exception试图处理所有可能出现的异常。
- 能抛受控异常（checked Exception）就尽量不抛受非控异常(checked Exception)。通过去掉重复的异常处理代码，可以提高代码的可读性。
- 绝对不要让你的数据库相关异常显示到客户端。由于绝大多数数据库和SQLException异常都是受控异常，在Java中，你应该在DAO层把异常信息处理，然后返回处理过的能让用户看懂并根据异常提示信息改正操作的异常信息。
- 在Java中，一定要在数据库连接，数据库查询，流处理后，在finally块中调用close()方法。

##什么是“异常链”
“异常链”是Java中非常流行的异常处理概念，是指在进行一个异常处理时抛出了另外一个异常，由此产生了一个异常链条。该技术大多用于将“ 受检查异常” （ checked exception）封装成为“非受检查异常”（unchecked exception)或者RuntimeException。顺便说一下，
如果因为因为异常你决定抛出一个新的异常，你一定要包含原有的异常，这样，处理程序才可以通过getCause()和initCause()方法来访问异常最终的根源。

在异常链的使用中，throw抛出的是一个新的异常信息，这样势必会导致原有的异常信息丢失，如何保持？在Throwable及其子类中的构造器中都可以接受一个cause参数，该参数保存了原有的异常信息，通过getCause()就可以获取该原始异常信息。

##有木有遇见过OutOfMemory异常
OutOfMemory的三种情况：

- 永久区溢出 Exception in thread "main" java.lang.OutOfMemoryError: PermGen space

    这一部分用于存放Class和Meta的信息，Class在被 Load的时候被放入PermGen space区域(包括常量池: 静态变量)，它和存放Instance的Heap区域不同，GC(Garbage Collection)不会在主程序运行期对PermGen space进行清理，
    所以如果你的APP会LOAD很多CLASS的话,就很可能出现PermGen space错误。
    
    这种错误常见在web服务器对JSP进行pre compile的时候。
    
    可以通过设置jvm启动参数来解决： -XX:MaxPermSize=256m
- 堆溢出 java.lang.OutOfMemoryError: Java heap space

    这部分用于存放类的实例。被缓存的实例(Cache)对象，大的map,list引用大的对象等等，都会保存于此。
    
    堆内存会在jvm启动时自动设置，初始值 -Xms为物理内存的1/64，最大值-Xmx为1/4;可以通过参数-Xmn、-Xms、-Xmx设置，一般-Xms和-Xmx不超过80%，-Xmn为-Xmx的1/4;
- 栈溢出 Exception in thread "main" java.lang.StackOverflowError

    这部分用于存放局部变量、方法栈帧信息。栈帧太多，也就是函数调用层级过多时就会出现此异常，检查是否有死递归的情况。
    
    对应的启动参数为：-Xss ( JDK1.5以后默认是1M,之前是256K)
    
    实例，以下是1G内存环境下java jvm 的参数设置参考：
        
           JAVA_OPTS="-server -Xms800m -Xmx800m -XX:PermSize=64M -XX:MaxNewSize=256m -XX:MaxPermSize=128m -Djava.awt.headless=true
           
内存调试一般要给出Dump文件进行调试


