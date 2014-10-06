##forward和redicrect区别
######从地址显示来说
forward是服务器请求资源，比如你转向的地址为2.jsp，这时服务器先自己直接访问2.jsp，把这个地址的内容读出来，然后把这些内容再发给浏览器。所以地址栏还是你访问servlet那个地址栏（如果你用jsp实现地址就不变），它不会变成2.jsp。浏览器不知道这些内容是服务器从地址2.jsp拿过来的。

redirect则相反，是服务端根据逻辑，发送一个状态码高速浏览器重新去请求那个2.jsp地址，所以地址栏显示的是新的URL。 
######从数据共享来说
forward转发页面和转发到的页面可以共享request里面的内容；redirect不能共享数据。 
######从运用地方来说
forward一般用于用户登录时候，根据角色转发到相应的模块（因为这时可能需要共享些数据）。

redirect一般用于用户注销登录时返回主页面和跳转到其他的网站。
######从协议的角度来说
forward的实现与协议无关。从原理上看，forward是container内部在response之前对request的处理。

而redirect方式是利用http协议中的redirect机制让客户发起新的请求，转向新的url。
######实例
forward方式：

	request.getRequestDispatcher("/somePage.jsp").forward(request, response);

redirect方式：
	response.sendRedirect("/somePage.jsp");

##Forward与include的区别 
<jsp:include>标签用于把另外一个资源的输出内容插入进当前JSP页面的输出内容之中，这种在JSP页面执行时的引入方式称之为动态引入。

<jsp:forward>从一个JSP文件传递request信息到另外一个JSP文件，<jsp:forward>后面的部分将不会被执行。

可以使用 <jsp:param> 传递参数。

<jsp:include>将包含的文件放在JSP中和其他一起执行。

<jsp:forward>标签用于把请求转发给另外一个资源。

forward在调用者程序中设置的响应状态码和响应头不会被忽略,在被调用者程序中设置的响应状态码和响应头也不会被忽略.
include会被忽略..

这也是乱码的一个原因..使用include时候,要要调用程序中写上response.setContentType("text/html;charset=utf-8")
不管你是不是用filter统一处理过字符.

**调用forward()方法时必须注意下列两点：**

在HTTP回应被“确认”（committed）以前才能调用forward()方法（这里的“确认”是指将HTTP回应的内容主体送回用户端），否则将拋出IllegalStateException异常。[include没有这种情况]

调用forward()方法后，原先存放在HttpResponse对象中的内容将会自动被清除(也就是在forward方法前,使用PrintWriter,ServletOutputStream输出的内容都被忽略)
[include不会] 

##说出数据连接池的工作机制是什么
J2EE服务器启动时会建立一定数量的池连接，并一直维持不少于此数目的池连接。客户端程序需要连接时，池驱动程序会返回一个未使用的池连接并将其表记为忙。
如果当前没有空闲连接，池驱动程序就新建一定数量的连接，新建连接的数量有配置参数决定。当使用的池连接调用完成后，池驱动程序将此连接表记为空闲，
其他调用就可以使用这个连接。

##J2EE是技术还是平台还是框架？
J2EE是Sun公司提出的多层(multi-diered),分布式(distributed),基于组件(component-base)的企业级应用模型(enterpriese application model).

J2EE本身是一个标准，一个为企业分布式应用的开发提供的标准平台。

J2EE也是一个框架，包括JDBC、JNDI、RMI、JMS、EJB、JTA等技术

##我们在web应用开发过程中经常遇到输出某种编码的字符，如iso8859-1等，如何输出一个某种编码的字符串？
    tempStr = new String(str.getBytes("ISO-8859-1"), "GBK")
    
##XML文档定义有几种形式？它们之间有何本质区别？解析XML文档有哪几种方式
两种形式 dtd  schema，

本质区别:schema本身是xml的，可以被XML解析器解析(这也是从DTD上发展schema的根本目的)，

有DOM,SAX,STAX等

DOM:处理大型文件时其性能下降的非常厉害。这个问题是由DOM的树结构所造成的，这种结构占用的内存较多，而且DOM必须在解析文件之前把整个文档装入内存,适合对XML的随机访问

SAX:不现于DOM,SAX是事件驱动型的XML解析方式。它顺序读取XML文件，不需要一次全部装载整个文件。当遇到像文件开头，文档结束，或者标签开头与标签结束时，它会触发一个事件，用户通过在其回调事件中写入处理代码来处理XML文件，适合对XML的顺序访问 

STAX:Streaming API for XML (StAX)

##说说你所熟悉或听说过的j2ee中的几种常用模式?及对设计模式的一些看法
Session Facade Pattern：使用SessionBean访问EntityBean

Message Facade Pattern：实现异步调用

EJB Command Pattern：使用Command JavaBeans取代SessionBean，实现轻量级访问

Data Transfer Object Factory：通过DTO Factory简化EntityBean数据提供特性

Generic Attribute Access：通过AttibuteAccess接口简化EntityBean数据提供特性

Business Interface：通过远程（本地）接口和Bean类实现相同接口规范业务逻辑一致性

ＥＪＢ架构的设计好坏将直接影响系统的性能、可扩展性、可维护性、组件可重用性及开发效率。项目越复杂，项目队伍越庞大则越能体现良好设计的重要性。

##请对以下在J2EE中常用的名词进行解释(或简单描述)
web容器：给处于其中的应用程序组件（JSP，SERVLET）提供一个环境，使JSP,SERVLET直接跟容器中的环境变量交互，不必关注其它系统问题。主要有WEB服务器来实现。例如：TOMCAT,WEBLOGIC,WEBSPHERE等。该容器提供的接口严格遵守J2EE规范中的WEB APPLICATION 标准。我们把遵守以上标准的WEB服务器就叫做J2EE中的WEB容器。

EJB容器：Enterprise java bean 容器。更具有行业领域特色。他提供给运行在其中的组件EJB各种管理功能。只要满足J2EE规范的EJB放入该容器，马上就会被容器进行高效率的管理。并且可以通过现成的接口来获得系统级别的服务。例如邮件服务、事务管理。

JNDI：（Java Naming & Directory Interface）JAVA命名目录服务。主要提供的功能是：提供一个目录系统，让其它各地的应用程序在其上面留下自己的索引，从而满足快速查找和定位分布式应用程序的功能。

JMS：（Java Message Service）JAVA消息服务。主要实现各个应用程序之间的通讯。包括点对点和广播。

JTA：（Java Transaction API）JAVA事务服务。提供各种分布式事务服务。应用程序只需调用其提供的接口即可。

JAF：（Java Action FrameWork）JAVA安全认证框架。提供一些安全控制方面的框架。让开发者通过各种部署和自定义实现自己的个性安全控制策略。

RMI/IIOP:（Remote Method Invocation /internet对象请求中介协议）他们主要用于通过远程调用服务。例如，远程有一台计算机上运行一个程序，它提供股票分析服务，我们可以在本地计算机上实现对其直接调用。当然这是要通过一定的规范才能在异构的系统之间进行通信。RMI是JAVA特有的。

##BS与CS的联系与区别
C/S是Client/Server的缩写。服务器通常采用高性能的PC、工作站或小型机，并采用大型数据库系统，如Oracle、Sybase、Informix或 SQL Server。客户端需要安装专用的客户端软件。

B/Ｓ是Brower/Server的缩写，客户机上只要安装一个浏览器（Browser），如Netscape Navigator或Internet Explorer，服务器安装Oracle、Sybase、Informix或 SQL Server等数据库。在这种结构下，用户界面完全通过WWW浏览器实现，一部分事务逻辑在前端实现，但是主要事务逻辑在服务器端实现。浏览器通过Ｗeb Server 同数据库进行数据交互。

C/S 与 B/S 区别： 

1. 硬件环境不同: 
　　C/S 一般建立在专用的网络上, 小范围里的网络环境, 局域网之间再通过专门服务器提供连接和数据交换服务.
　　B/S 建立在广域网之上的, 不必是专门的网络硬件环境,例与电话上网, 租用设备. 信息自己管理. 有比C/S更强的适应范围, 一般只要有操作系统和浏览器就行 
2. 对安全要求不同 
　　C/S 一般面向相对固定的用户群, 对信息安全的控制能力很强. 一般高度机密的信息系统采用C/S 结构适宜. 可以通过B/S发布部分可公开信息.
　　B/S 建立在广域网之上, 对安全的控制能力相对弱, 可能面向不可知的用户。
3. 对程序架构不同 
　　C/S 程序可以更加注重流程, 可以对权限多层次校验, 对系统运行速度可以较少考虑.
　　B/S 对安全以及访问速度的多重的考虑, 建立在需要更加优化的基础之上. 比C/S有更高的要求 B/S结构的程序架构是发展的趋势, 从MS的.Net系列的BizTalk 2000 Exchange 2000等, 全面支持网络的构件搭建的系统. SUN 和IBM推的JavaBean 构件技术等,使 B/S更加成熟. 
4. 软件重用不同 
　　C/S 程序可以不可避免的整体性考虑, 构件的重用性不如在B/S要求下的构件的重用性好.
　　B/S 对的多重结构,要求构件相对独立的功能. 能够相对较好的重用.就如买来的餐桌可以再利用,而不是做在墙上的石头桌子 
5. 系统维护不同  
　　C/S 程序由于整体性, 必须整体考察, 处理出现的问题以及系统升级. 升级难. 可能是再做一个全新的系统
　　B/S 构件组成,方面构件个别的更换,实现系统的无缝升级. 系统维护开销减到最小.用户从网上自己下载安装就可以实现升级. 
6. 处理问题不同 
　　C/S 程序可以处理用户面固定, 并且在相同区域, 安全要求高需求, 与操作系统相关. 应该都是相同的系统
　　B/S 建立在广域网上, 面向不同的用户群, 分散地域, 这是C/S无法作到的. 与操作系统平台关系最小. 
7. 用户接口不同 
　　C/S 多是建立的Window平台上,表现方法有限,对程序员普遍要求较高
　　B/S 建立在浏览器上, 有更加丰富和生动的表现方式与用户交流. 并且大部分难度减低,减低开发成本. 
8. 信息流不同 
　　C/S 程序一般是典型的中央集权的机械式处理, 交互性相对低
　　B/S 信息流向可变化, B-B B-C B-G等信息、流向的变化, 更像交易中心。

##Jdo是什么
JDO是Java对象持久化的新的规范，为java data object的简称,也是一个用于存取某种数据仓库中的对象的标准化API。
JDO提供了透明的对象存储，因此对开发人员来说，存储数据对象完全不需要额外的代码（如JDBC API的使用）。
这些繁琐的例行工作已经转移到JDO产品提供商身上，使开发人员解脱出来，从而集中时间和精力在业务逻辑上。
另外，JDO很灵活，因为它可以在任何数据底层上运行。JDBC只是面向关系数据库（RDBMS）JDO更通用，提供到任何数据底层的存储功能，
比如关系数据库、文件、XML以及对象数据库（ODBMS）等等，使得应用可移植性更强。

##