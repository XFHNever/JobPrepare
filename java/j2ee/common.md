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
##