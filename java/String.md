##为什么针对安全保密高的信息，char[]比String更好?
因为String是不可变的，就是说它一旦创建，就不能更改了，直到垃圾收集器将它回收走。而字符数组中的元素是可以更改的（译者注：这就意味着你就可以在使用完之后将其更改，而不会保留原始的数据）。所以使用字符数组的话，安全保密性高的信息(如密码之类的)将不会存在于系统中被他人看到。
##我们可以针对字符串使用switch条件语句吗？
可以。

Switch支持的数据类型：

- Before JDK7：byte、char、short、int、枚举

- After JDK7（including）：byte、char、short、int、枚举、String
##substring()方法到底做了什么？
在JDK 6中, substring()的做法是，用一个字符数组来表示现存的字符串，然后给这个字符数组提供一个“窗口”，但实际并没有创建一个新的字符数组。要创建一个新的字符串对象由新的字符串数组表示的话，你需要加上一个空字符串，如下所示：
	
	str.substring(m, n) + ""

这会创建一个新的字符数组，用来表示新的字符串。这种方法会让你的代码更快，因为垃圾收集器会收集不用的长字符串，而仅保存要使用的子字符串。

JDK6中String类包含3个域，char[] value、int offset、int count。分别用于存储真实的字符数组、数组的偏移量，以及String所包含的字符的个数。当substring()时，它会创建一个新的字符串对象，但是这个字符串的值在java 堆中仍然指向的是同一个数组，这两个字符串的不同在于他们的count和offset的值。

在Oracle JDK 7中，substring()会创建新的字符数组，而不是使用现存的字符数组。

##如何将字符串转换成时间
	String str = "Sep 17, 2013";
	Date date = new SimpleDateFormat("MMMM d, yy", Locale.ENGLISH).parse(str);
	System.out.println(date);
##String、StringBuffer和StringBuilder
<a href="http://xfhnever.github.io/blog/2014/03/29/string/">【转】String、StringBuffer和StringBuilder的区别</a>
##String.intern()
返回字符串对象的规范化表示形式。

一个初始时为空的字符串池，它由类 String 私有地维护。

当调用 intern 方法时，如果池已经包含一个等于此 String 对象的字符串（该对象由 equals(Object) 方法确定），则返回池中的字符串。否则，将此 String 对象添加到池中，并且返回此 String 对象的引用。 

它遵循对于任何两个字符串 s 和 t，当且仅当 s.equals(t) 为 true 时，s.intern() == t.intern() 才为 true。 

- new产生的string在堆中，而不在字符串池中，即CONSTANT_String_info中。
- intern()去字符串池中查找是否存在该内容为指定字符串的string对象，如果有，则返回一个已有的引用，否则，创建在字符串池中创建新的引用，并返回该引用。
- 采用new 创建的字符串对象不进入字符串池，字符串相加的时候，都是静态字符串的结果会添加到字符串池，如果其中含有变量不会进入字符串池中。但是字符串一旦进入字符串池中，就会先查找池中有无此对象。如果有此对象，则让对象引用指向此对象。如果无此对象，则先创建此对象，再让对象引用指向此对象。

######优点
- 执行非常快，在多线程模式中（仍然使用全局字符串池）几乎没有性能损失
- 节省内存，允许你的数据集更小，（通常会）让你的程序运行更快

######缺点
- 需要提前设置JVM的-XX:StringTableSize=N参数，字符串池使用这个固定的值（要扩展JVM的字符串池，需要重启虚拟机）
- 在整个程序的很多地方需要加入String.intern的调用（可能通过你自己的封装去调用）——这增加了代码的维护代价

##为什么String设计成不可变
- 字符串常量池的需要
- 允许String对象缓存HashCode
		
	Java中String对象的哈希码被频繁地使用, 比如在hashMap 等容器中。
	
	字符串不变性保证了hash码的唯一性,因此可以放心地进行缓存.这也是一种性能优化手段,意味着不必每次都去计算新的哈希码. 、
- 安全性

	String被许多的Java类(库)用来当做参数,例如 网络连接地址URL,文件路径path,还有反射机制所需要的String参数等, 假若String不是固定不变的,将会引起各种安全隐患。

##==和equals的区别
- 基本数据类型，也称为原始数据类型（byte、char、short、int、long、float、double、boolean）它们之间的比较用双等号（==），比较的是它们的值。

- 对象的比较，当对象用==进行比较的时候比较的是它们的内存中的存放地址，所以，new出的两个相同对象用==比较是不相等的，因为它们在内存中存放的地址不同，所以对象的比较要用equals进行比较，值得注意的是，其实Object类中定义的equals方法也是基于==的,源代码如下：

		public boolean equals(Object obj) {
		    return (this == obj);
		}
在Object类中equals比较的也是内存地址，但是在String、Integer、Date等类中覆写了Object类中的equals方法，我们拿String类中的equals方法看一下：

		public boolean equals(Object anObject) {
		    if (this == anObject) {
		        return true;
		    }
		    if (anObject instanceof String) {
		        String anotherString = (String) anObject;
		        int n = value.length;//本身字符串长度
		        if (n == anotherString.value.length) {//如果本身字符串长度与传递进来的字符串长度相等就继续向下比较
		            char v1[] = value;//取每一个位置的字符
		            char v2[] = anotherString.value;
		            int i = 0;
		            while (n-- != 0) {
		                if (v1[i] != v2[i])//对每一个位置的字符进行逐一比较
		                        return false;
		                i++;
		            }
		            return true;
		        }
		    }
		    return false;
		}