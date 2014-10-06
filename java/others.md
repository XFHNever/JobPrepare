##两个对象值相同(x.equals(y) == true)，但却可有不同的hash code，这句话对不对
不对，有相同的hash code

<a = href="http://www.cnblogs.com/qqzy168/p/3246057.html">http://www.cnblogs.com/qqzy168/p/3246057.html</a>

##当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递
是值传递。Java 编程语言只有值传递参数。当一个对象实例作为一个参数被传递到方法中时，参数的值就是对该对象的引用。对象的内容可以在被调用的方法中改变，但对象的引用是永远不会改变的

##描述一下JVM加载class文件的原理机制
JVM中类的装载是由ClassLoader和它的子类来实现的,Java ClassLoader 是一个重要的Java运行时系统组件。它负责在运行时查找和装入类文件的类

##java中有几种类型的流？JDK为每种类型的流提供了一些抽象类以供继承，请说出他们分别是哪些类？
字节流，字符流。字节流继承于InputStream OutputStream，字符流继承于InputStreamReader OutputStreamWriter。
在java.io包中还有许多其他的流，主要是为了提高性能和使用方便。

##什么是java序列化，如何实现java序列化
序列化就是一种用来处理对象流的机制，所谓对象流也就是将对象的内容进行流化。可以对流化后的对象进行读写操作，
也可将流化后的对象传输于网络之间。序列化是为了解决在对对象流进行读写操作时所引发的问题。

序列化的实现：将需要被序列化的类实现Serializable接口，该接口没有需要实现的方法，implements Serializable只是为了标注该对象是可被序列化的，然后使用一个输出流(如：FileOutputStream)来构造一个ObjectOutputStream(对象流)对象，
接着，使用ObjectOutputStream对象的writeObject(Object obj)方法就可以将参数为obj的对象写出(即保存其状态)，要恢复的话则用输入流。

##写clone()方法时，通常都有一行代码，是什么
Clone 有缺省行为，super.clone();他负责产生正确大小的空间，并逐位复制。

##说出一些常用的类，包，接口，请各举5个
常用的类：BufferedReader  BufferedWriter  FileReader  FileWirter  String  Integer

常用的包：java.lang  java.awt  java.io  java.util  java.sql

常用的接口：Remote  List  Map  Document  NodeList 

##JDK和JRE区别
JDK是java开发工具，它不仅提供了Java程序
