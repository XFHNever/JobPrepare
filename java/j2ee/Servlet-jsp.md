##说出Servlet的生命周期，并说出Servlet和CGI的区别
Servlet的生命周期可以分为加载、实例化、初始化、处理客户请求和卸载五个阶段，体现在方法上主要是init（）、service（）和 destroy（）三个方法。生命周期的具体说明如下

- Servlet容器完成加载Servlet类和实例化一个Servlet对象
- init（）方法完成初始化工作，该方法由Servlet容器调用完成
- service（）方法处理客户端请求，并返回响应结果。当Servlet中有doGet（）或者doPost（）方法时，那么service方法就可以省略，默认为调用这两个方法。
- destroy（）方法在Servlet容器卸载Servlet之前被调用，释放一些资源


与cgi（Common Gateway Interface通用网关接口）的区别在于servlet处于服务器进程中，它通过多线程方式运行其service方法，一个实例可以服务于多个请求，并且其实例一般不会销毁，而CGI对每个请求都产生新的进程，服务完成后就销毁，所以效率上低于servlet。
##Servlet是否线程安全？为什么
##cookie和session的区别

##JSP中动态INCLUDE与静态INCLUDE的区别
动态INCLUDE用jsp:include（行为元素）动作实现 &lt;jsp:include page="included.jsp" flush="true" />它总是会检查所含文件中的变化，适合用于包含动态页面，并且可以带参数。
动态include的结构是两者独立,直到输出时才合并；动态include的jsp文件独立性很强,是一个单独的jsp文件,需要使用的对象,页面设置,都必须有自己创建,
当然,还好它和include它的页面的request范围是一致的

静态INCLUDE（指令元素）用include伪码实现,不会检查所含文件的变化，适用于包含静态页面&lt;%@ include file="included.htm" %> 
静态include的结果是把其他jsp引入当前jsp,两者合为一体（处于翻译阶段）；静态include纯粹是把代码写在外面的一种共享方法,所有的变量都是可以和include它的主文件共享,两者高度紧密结合,不能有变量同名的冲突.而页面设置也可以借用主文件的. 

##JSP的内置对象及方法
request表示HttpServletRequest对象。它包含了有关浏览器请求的信息，并且提供了几个用于获取cookie, header, 和session数据的有用的方法。 

response表示HttpServletResponse对象，并提供了几个用于设置送回 浏览器的响应的方法（如cookies,头信息等） 

out对象是javax.jsp.JspWriter的一个实例，并提供了几个方法使你能用于向浏览器回送输出结果。 

pageContext表示一个javax.servlet.jsp.PageContext对象。它是用于方便存取各种范围的名字空间、servlet相关的对象的API，并且包装了通用的servlet相关功能的方法。 

session表示一个请求的javax.servlet.http.HttpSession对象。Session可以存贮用户的状态信息 

applicaton 表示一个javax.servle.ServletContext对象。这有助于查找有关servlet引擎和servlet环境的信息 

config表示一个javax.servlet.ServletConfig对象。该对象用于存取servlet实例的初始化参数。 

page表示从该页面产生的一个servlet实例

##JSP的常用指令
&lt;%@page language="java" contenType="text/html;charset=gb2312" session="true" buffer="64kb" autoFlush="true" isThreadSafe="true" info="text" errorPage="error.jsp" isErrorPage="true" isELIgnored="true" pageEncoding="gb2312" import="java.sql.*"%>
isErrorPage(是否能使用Exception对象)，isELIgnored(是否忽略表达式)

&lt;%@include file="filename"%>

&lt;%@taglib prefix="c"uri=" http://......"%>

##如何现实servlet的单线程模式

    <%@ page isThreadSafe="false"%>
    
##页面间对象传递的方法
request，session，application，cookie等

##JSP和Servlet有哪些相同点和不同点，他们之间的联系是什么
JSP 是 Servlet 技术的扩展，本质上是 Servlet 的简易方式，更强调应用的外表表达。相同点：JSP和Servlet和本质上都是java类。Servlet 和 JSP 最主要的不同点在于， Servlet 的应用逻辑是在 Java 文件中，并且完全从表示层中的 HTML 里分离开来。

而 JSP 的情况是 Java和 HTML 可以组合成一个扩展名为.jsp 的文件。

JSP 侧重于视图，Servlet 主要用于控制逻辑。

##四种会话跟踪技术
URL重写、隐藏表单域、Cookie、Session

Cookie：服务器在一个应答首部传递给浏览器的名称/值对。浏览器保存的时间由cookie的过期时间属性来指定。当浏览器向某个服务器发送一个请求时，它会检查其保存的cookie，并在请求首部中包含从同一台服务器上接收到的所有cookie。

Session tracking:在浏览器和服务器之间不直接传送所有的状态信息，而只是传递表示符（session ID）。浏览器发送sessionID,服务器跟踪与该会话相关联的所有信息。传递sessionID可以通过cookie和URL复写技术，大部分容器都支持这两种技术。服务器无法分辨用户是否关闭了浏览器，因此关闭浏览器意味着与先前的会话关联的所有会话数据都保留在服务器上，直到会话超时，服务器销毁会话对像。
跟踪同一会话中的请求的会话ID可以有多种方法，主要有cookie和url复写。

URL复写：把会话ID编码在URL中。例：counter.jjsp;jsessionnid=be8d697876787876befdbde898789098980，这样，即使浏览器不支持cookie，也能够实现会话跟踪。
对于URL复写，服务器从请求的URI中提取出会话ID，并把该请求与相应的会话关联起来，然后在访问会话数据的时候，JSP页面所进行的处理方式就和使用cookie跟踪会话id时所使用的方式完全相同。所以sesssion的实现要依靠cookie或URL复写技术。
如果想为不支持cookie的浏览器提供会话跟踪，就必须使用<c:url>行为对应用程序中的所有URL进行复写。这意味着应用程序中的所有页面（至少是那些带有对其他页面引用的页面）都必须是JSP页面，这样页面引用才能以动态方式进行编码，如果遗漏了一个ur，那么服务就会失去对会话的跟踪。

隐藏表单域：隐藏表单域是将会话ID添加到HTML的隐藏表单中(类型为hidden的input)。 

##Request对象的主要方法
setAttribute(String name,Object)：设置名字为name的request的参数值

getAttribute(String name)：返回由name指定的属性值

getAttributeNames()：返回request对象所有属性的名字集合，结果是一个枚举的实例

getCookies()：返回客户端的所有Cookie对象，结果是一个Cookie数组

getCharacterEncoding()：返回请求中的字符编码方式

getContentLength()：返回请求的Body的长度

getHeader(String name)：获得HTTP协议定义的文件头信息

getHeaders(String name)：返回指定名字的request Header的所有值，结果是一个枚举的实例

getHeaderNames()：返回所以request Header的名字，结果是一个枚举的实例

getInputStream()：返回请求的输入流，用于获得请求中的数据

getMethod()：获得客户端向服务器端传送数据的方法

getParameter(String name)：获得客户端传送给服务器端的有name指定的参数值

getParameterNames()：获得客户端传送给服务器端的所有参数的名字，结果是一个枚举的实例

getParameterValues(String name)：获得有name指定的参数的所有值

getProtocol()：获取客户端向服务器端传送数据所依据的协议名称

getQueryString()：获得查询字符串

getRequestURI()：获取发出请求字符串的客户端地址

getRemoteAddr()：获取客户端的IP地址

getRemoteHost()：获取客户端的名字

getSession([Boolean create])：返回和请求相关Session

getServerName()：获取服务器的名字

getServletPath()：获取客户端所请求的脚本文件的路径

getServerPort()：获取服务器的端口号

removeAttribute(String name)：删除请求中的一个属性

##jsp有哪些动作?作用分别是什么
JSP共有以下6种基本动作

jsp:include：在页面被请求的时候引入一个文件。 

jsp:useBean：寻找或者实例化一个JavaBean。 

jsp:setProperty：设置JavaBean的属性。 

jsp:getProperty：输出某个JavaBean的属性。 

jsp:forward：把请求转到一个新的页面。 

jsp:plugin：根据浏览器类型为Java插件生成OBJECT或EMBED标记

##