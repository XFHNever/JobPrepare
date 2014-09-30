##说出Servlet的生命周期，并说出Servlet和CGI的区别
Servlet的生命周期可以分为加载、实例化、初始化、处理客户请求和卸载五个阶段，体现在方法上主要是init（）、service（）和 destroy（）三个方法。生命周期的具体说明如下

- Servlet容器完成加载Servlet类和实例化一个Servlet对象
- init（）方法完成初始化工作，该方法由Servlet容器调用完成
- service（）方法处理客户端请求，并返回响应结果。当Servlet中有doGet（）或者doPost（）方法时，那么service方法就可以省略，默认为调用这两个方法。
- destroy（）方法在Servlet容器卸载Servlet之前被调用，释放一些资源


与cgi（Common Gateway Interface通用网关接口）的区别在于servlet处于服务器进程中，它通过多线程方式运行其service方法，一个实例可以服务于多个请求，并且其实例一般不会销毁，而CGI对每个请求都产生新的进程，服务完成后就销毁，所以效率上低于servlet。
##Servlet是否线程安全？为什么
##cookie和session的区别
