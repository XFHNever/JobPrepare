##OSI参考模型
Open System Interconnect,开发系统互联，是一个七层的计算机网络模型，分别为：

- 物理层： 在网络上透明地传送比特流
- 数据链路层： 管理物理层的比特数据，并将正确的数据传送到没有传输错误的路线中。重要协议:点对点协议PPP（点对点通信方式）、CSMA/CD协议（一对多的广播通信方式）
- 网络层：网络层的作用是决定如何将发送方的数据传到接收方。该层通过考虑网络拥塞程度、服务质量、发送优先权、每次路由的耗费来决定节点X到节点Y的最佳路径。我们熟知的路由器就工作在这一层，通过不断的接收与传送数据使得网络变得相互联通。重要的协议：IP协议、ARP协议、RARP协议、ICMP协议、IGMP协议
- 传输层：为两个主机中进程之间的通信提供服务，负责数据分割（传送端）和数据组合（接收端）以及控制数据流量，并且进行调试及错误处理，以确保通信顺利。常见的协议：TCP协议、UDP协议
- 会话层：为网络中两个结点（通信双方）制定通信方式，并建立、维护、控制、注销会话等。
- 表示层：负责数据的编码和转化，确保一个系统的应用层所发送的信息可以被另一个系统的应用层读取（相互识别）。同时，也能提供数据的压缩、解压、加密、解密。
- 应用层：应用层能与应用程序界面沟通，以达到展示给用户的目的。 在此常见的协议有: HTTP，HTTPS，FTP，TELNET，SSH，SMTP，POP3等。

##网络层协议
- IP协议

	根据目的IP地址，找一条路径，将发送方的数据传到接收方
- ARP协议：地址解析协议

	根据对方的IP地址，找到对方的物理地址
- RARP协议：逆地址解析协议

	根据对方的硬件地址，找到对方的IP地址
- ICMP协议：网际控制报文协议(Internet Control Message Protocol)

	数据报发送错误时，发送提示信息
- IGMP协议：网际组管理协议

	发送多播协议
- OSPF协议：开放最短路径优先

	发送数据找一条最短路径发送

##ping命令作用？使用的什么协议？
作用:它测试两个主机之间的连通性。

使用网络层协议ICMP协议
##TCP和UDP区别

##