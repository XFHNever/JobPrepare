##EJB是基于哪些技术实现的？并说出SessionBean和EntityBean的区别，StatefulBean和StatelessBean的区别。
EJB包括Session Bean、Entity Bean、Message Driven Bean，基于JNDI、RMI、JAT等技术实现。

SessionBean在J2EE应用程序中被用来完成一些服务器端的业务操作，例如访问数据库、调用其他EJB组件。

EntityBean被用来代表应用系统中用到的数据。

对于客户机，SessionBean是一种非持久性对象，它实现某些在服务器上运行的业务逻辑。

对于客户机，EntityBean是一种持久性对象，它代表一个存储在持久性存储器中的实体的对象视图，或是一个由现有企业应用程序实现的实体。

Session Bean 还可以再细分为 Stateful Session Bean 与 Stateless Session Bean ，这两种的 Session Bean都可以将系统逻辑放在 method之中执行，不同的是 Stateful Session Bean 可以记录呼叫者的状态，因此通常
来说，一个使用者会有一个相对应的 Stateful Session Bean 的实体。Stateless Session Bean 虽然也是逻辑组件，但是他却不负责记录使用者状态，也就是说当使用者呼叫 Stateless Session Bean 的时候，EJB Container 
并不会找寻特定的 Stateless Session Bean 的实体来执行这个 method。换言之，很可能数个使用者在执行某个Stateless Session Bean 的 methods 时，会是同一个 Bean 的 Instance 在执行。从内存方面来看， 
Stateful Session Bean 与 Stateless Session Bean 比较， Stateful Session Bean 会消耗 J2EE Server 较多的内存，然而 Stateful Session Bean 的优势却在于他可以维持使用者的状态。

##EJB与JAVA BEAN的区别
Java Bean 是可复用的组件，对Java Bean并没有严格的规范，理论上讲，任何一个Java类都可以是一个Bean。
但通常情况下，由于Java Bean是被容器所创建（如Tomcat）的，所以Java Bean应具有一个无参的构造器，另外，
通常Java Bean还要实现Serializable接口用于实现Bean的持久性。Java Bean实际上相当于微软COM模型中的本地进程内COM组件，
它是不能被跨进程访问的。

Enterprise Java Bean 相当于DCOM，即分布式组件。它是基于Java的远程方法调用（RMI）技术的，
所以EJB可以被远程访问（跨进程、跨计算机）。但EJB必须被布署在诸如Webspere、WebLogic这样的容器中，
EJB客户从不直接访问真正的EJB组件，而是通过其容器访问。EJB容器是EJB组件的代理，EJB组件由容器所创建和管理。
客户通过容器来访问真正的EJB组件。

##EJB包括（SessionBean,EntityBean）说出他们的生命周期，及如何管理事务的？
SessionBean：Stateless Session Bean（无状态） 的生命周期是由容器决定的，当客户机发出请求要建立一个Bean的实例时，EJB容器不一定要创建一个新的Bean的实例供客户机调用，
而是随便找一个现有的实例提供给客户机。当客户机第一次调用一个Stateful(有状态) Session Bean 时，容器必须立即在服务器中创建一个新的Bean实例，并关联到客户机上，
以后此客户机调用Stateful Session Bean 的方法时容器会把调用分派到与此客户机相关联的Bean实例。

EntityBean：Entity Beans能存活相对较长的时间，并且状态是持续的。只要数据库中的数据存在，Entity beans就一直存活。而不是按照应用程序或者服务进程来说的。
即使EJB容器崩溃了，Entity beans也是存活的。Entity Beans生命周期能够被容器或者 Beans自己管理。

EJB通过以下技术管理事务：对象管理组织（OMG）的对象事务服务（OTS），Sun Microsystems的Transaction Service（JTS）、Java Transaction API（JTA），开发组（X/Open）的XA接口。

##应用服务器有那些
BEA WebLogic Server，IBM WebSphere Application Server，Oracle9i Application Server，jBoss，Tomcat

##EJB的角色和三个对象
一个完整的基于EJB的分布式计算结构由六个角色组成，这六个角色可以由不同的开发商提供，
每个角色所作的工作必须遵循Sun公司提供的EJB规范，以保证彼此之间的兼容性。
这六个角色分别是EJB组件开发者（Enterprise Bean Provider） 、应用组合者（Application Assembler）、
部署者（Deployer）、EJB 服务器提供者（EJB Server Provider）、EJB 容器提供者（EJB Container Provider）、
系统管理员（System Administrator）

三个对象是Remote（Local）接口、Home（LocalHome）接口，Bean类

##EJB容器提供的服务
主要提供声明周期管理、代码产生、持续性管理、安全、事务管理、锁和并发管理等服务。

##EJB规范规定EJB中禁止的操作有哪些
1.不能操作线程和线程API(线程API指非线程对象的方法如notify,wait等)，
2.不能操作awt，
3.不能实现服务器功能，
4.不能对静态属性存取，
5.不能使用IO操作直接存取文件系统，
6.不能加载本地库.，
7.不能将this作为变量和返回，
8.不能循环调用。

##remote接口和home接口主要作用
remote接口定义了业务方法，用于EJB客户端调用业务方法。

home接口是EJB工厂用于创建和移除查找EJB实例

##bean 实例的生命周期
对于Stateless Session Bean、Entity Bean、Message Driven Bean一般存在缓冲池管理，而对于Entity Bean和Statefull Session Bean存在Cache管理，
通常包含创建实例，设置上下文、创建EJB Object（create）、业务方法调用、remove等过程，对于存在缓冲池管理的Bean，在create之后实例并不从内存清除，
而是采用缓冲池调度机制不断重用实例，而对于存在Cache管理的Bean则通过激活和去激活机制保持Bean的状态并限制内存中实例数量。

##EJB的激活机制
以Stateful Session Bean 为例：其Cache大小决定了内存中可以同时存在的Bean实例的数量，根据MRU或NRU算法，实例在激活和去激活状态之间迁移，
激活机制是当客户端调用某个EJB实例业务方法时，如果对应EJB Object发现自己没有绑定对应的Bean实例则从其去激活Bean存储中（通过序列化机制存储实例）回复（激活）此实例。
状态变迁前会调用对应的ejbActive和ejbPassivate方法。

##客服端调用EJB对象的几个基本步骤
设置JNDI服务工厂以及JNDI服务地址系统属性，查找Home接口，从Home接口调用Create方法创建Remote接口，通过Remote接口调用其业务方法。

##

