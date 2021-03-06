##OSI参考模型

![OSI](https://github.com/XFHNever/JobPrepare/blob/master/images/net1-5.jpg)

Open System Interconnect,开发系统互联，是一个七层的计算机网络模型，分别为：

- 物理层： 在网络上透明地传送比特流
- 数据链路层： 管理物理层的比特数据，并将正确的数据传送到没有传输错误的路线中。重要协议:点对点协议PPP（点对点通信方式）、CSMA/CD协议（一对多的广播通信方式）
- 网络层：网络层的作用是决定如何将发送方的数据传到接收方。该层通过考虑网络拥塞程度、服务质量、发送优先权、每次路由的耗费来决定节点X到节点Y的最佳路径。我们熟知的路由器就工作在这一层，通过不断的接收与传送数据使得网络变得相互联通。重要的协议：IP协议、ARP协议、RARP协议、ICMP协议、IGMP协议
- 传输层：为两个主机中进程之间的通信提供服务，负责数据分割（传送端）和数据组合（接收端）以及控制数据流量，并且进行调试及错误处理，以确保通信顺利。常见的协议：TCP协议、UDP协议
- 会话层：为网络中两个结点（通信双方）制定通信方式，并建立、维护、控制、注销会话等。
- 表示层：负责数据的编码和转化，确保一个系统的应用层所发送的信息可以被另一个系统的应用层读取（相互识别）。同时，也能提供数据的压缩、解压、加密、解密。
- 应用层：应用层能与应用程序界面沟通，以达到展示给用户的目的。 在此常见的协议有: HTTP，HTTPS，FTP，TELNET，SSH，SMTP，POP3等。

####注
- OSI的七层协议只是理论上的协议，实际上没有用到。
- TCP/IP的四层协议在真正在实际中用到的体系结构。

##网络层协议
- IP协议

	根据目的IP地址，找一条路径，将发送方的数据传到接收方
- ARP协议：地址解析协议

	根据对方的IP地址，找到对方的物理地址
- RARP协议：逆地址解析协议

	根据对方的硬件地址，找到对方的IP地址
- ICMP协议：网际控制报文协议(Internet Control Message Protocol)

	数据报发送错误时，发送提示信息

	它是 TCP/IP 协议族的一个子协议，用于在 IP 主机、路由器之间传递控制消息。控制消息是指网络通不通、主机是否可达、路由器是否可用等网络本身的消息。这些控制消息虽然并不传输用户数据，但是对于用户数据的传递起着重要的作用。 ICMP 报文有两种：差错报告报文和询问报文。
- IGMP协议：网际组管理协议

	发送多播协议
- OSPF协议：开放最短路径优先

	发送数据找一条最短路径发送

##ARP工作原理
1. 首先，每个主机都会在自己的 ARP 缓冲区中建立一个 ARP 列表，以表示 IP 地址和 MAC 地址之间的对应关系。
2. 当源主机要发送数据时，首先检查 ARP 列表中是否有对应 IP 地址的目的主机的 MAC 地址，如果有，则直接发送数据，如果没有，就向本网段的所有主机发送 ARP 数据包，该数据包包括的内容有：源主机 IP 地址，源主机 MAC 地址，目的主机的 IP 地址。
3. 当本网络的所有主机收到该 ARP 数据包时，首先检查数据包中的 IP 地址是否是自己的 IP 地址，如果不是，则忽略该数据包，如果是，则首先从数据包中取出源主机的 IP 和 MAC 地址写入到 ARP 列表中，如果已经存在，则覆盖，然后将自己的 MAC 地址写入 ARP 响应包中，告诉源主机自己是它想要找的 MAC 地址。
4. 源主机收到 ARP 响应包后。将目的主机的 IP 和 MAC 地址写入 ARP 列表，并利用此信息发送数据。如果源主机一直没有收到 ARP 响应数据包，表示 ARP 查询失败。

广播发送 ARP 请求，单播发送 ARP 响应。 

## DNS （ Domain Name System ）域名系统，简单描述其工作原理。
当 DNS 客户机需要在程序中使用名称时，它会查询 DNS 服务器来解析该名称。客户机发送的每条查询信息包括三条信息：包括：指定的 DNS 域名，指定的查询类型， DNS 域名的指定类别。基于 UDP 服务，端口 53. 该应用一般不直接为用户使用，而是为其他应用服务，如 HTTP ， SMTP 等在其中需要完成主机名到 IP 地址的转换。

##ping命令作用？使用的什么协议？
作用:它测试两个主机之间的连通性。

使用网络层协议ICMP协议
##TCP和UDP区别
TCP是传输控制协议，提供的是面向连接、可靠的字节流服务。当客户端和服务器彼此交换数据前，必须先在双方之间建立一个TCP连接，之后才能传输数据。TCP提供超时重发、丢弃重复数据、检验数据、流量控制等功能。保证数据能从一端传到另一端。

UDP是用户数据报协议，是一个简单的面向数据报的传输层协议。UDP不提供可靠性，它只是把应用程序传给IP层的数据报发送出去，但是并不保证它们能够到达目的地。由于UDP在传输数据报前不用在客户和服务器之间建立一个连接，且没有超时重发机制，故而传输速度很快。

##TCP的3次握手和4次挥手
TCP报文格式：

![TCP报文格式](https://github.com/XFHNever/JobPrepare/blob/master/images/net1-1.png)

上图中有几个字段需要重点介绍下：

1. 序号：Seq序号，占32位，用来标识从TCP源端向目的端发送的字节流，发起方发送数据时对此进行标记。
2. 确认序号：Ack序号，占32位，只有ACK标志位为1时，确认序号字段才有效，Ack=Seq+1。
3. 标志位：共6个，即URG、ACK、PSH、RST、SYN、FIN等，具体含义如下：

		（A）URG：紧急指针（urgent pointer）有效。
		（B）ACK：确认序号有效。
		（C）PSH：接收方应该尽快将这个报文交给应用层。
		（D）RST：重置连接。
		（E）SYN：发起一个新连接。
		（F）FIN：释放一个连接。

####三次握手
所谓三次握手（Three-Way Handshake）即建立TCP连接，就是指建立一个TCP连接时，需要客户端和服务端总共发送3个包以确认连接的建立。在socket编程中，这一过程由客户端执行connect来触发，整个流程如下图所示：

![三次握手](https://github.com/XFHNever/JobPrepare/blob/master/images/net1-2.png)

- 第一次握手：Client将标志位SYN置为1，随机产生一个值seq=J，并将该数据包发送给Server，Client进入SYN_SENT状态，等待Server确认。
- 第二次握手：Server收到数据包后由标志位SYN=1知道Client请求建立连接，Server将标志位SYN和ACK都置为1，ack=J+1，随机产生一个值seq=K，并将该数据包发送给Client以确认连接请求，Server进入SYN_RCVD状态。
- 第三次握手：Client收到确认后，检查ack是否为J+1，ACK是否为1，如果正确则将标志位ACK置为1，ack=K+1，并将该数据包发送给Server，Server检查ack是否为K+1，ACK是否为1，如果正确则连接建立成功，Client和Server进入ESTABLISHED状态，完成三次握手，随后Client与Server之间可以开始传输数据了。

######SYN攻击：

在三次握手过程中，Server发送SYN-ACK之后，收到Client的ACK之前的TCP连接称为半连接（half-open connect），此时Server处于SYN_RCVD状态，当收到ACK后，Server转入ESTABLISHED状态。SYN攻击就是Client在短时间内伪造大量不存在的IP地址，并向Server不断地发送SYN包，Server回复确认包，并等待Client的确认，由于源地址是不存在的，因此，Server需要不断重发直至超时，这些伪造的SYN包将产时间占用未连接队列，导致正常的SYN请求因为队列满而被丢弃，从而引起网络堵塞甚至系统瘫痪。SYN攻击时一种典型的DDOS攻击，检测SYN攻击的方式非常简单，即当Server上有大量半连接状态且源IP地址是随机的，则可以断定遭到SYN攻击了，使用如下命令可以让之现行：

	#netstat -nap | grep SYN_RECV

######为什么是三次握手
采用三次握手是为了防止失效的连接请求报文段突然又传送到主机 B ，因而产生错误。失效的连接请求报文段是指：主机 A 发出的连接请求没有收到主机 B 的确认，于是经过一段时间后，
主机 A 又重新向主机 B 发送连接请求，且建立成功，顺序完成数据传输。考虑这样一种特殊情况，主机 A 第一次发送的连接请求并没有丢失，而是因为网络节点导致延迟达到主机 B ，主机 B 以为是主机 A 又发起的新连接，于是主机 B 同意连接，并向主机 A 发回确认，但是此时主机 A 根本不会理会，主机 B 就一直在等待主机 A 发送数据，导致主机 B 的资源浪费。

####四次挥手
四次挥手（Four-Way Wavehand）即终止TCP连接，就是指断开一个TCP连接时，需要客户端和服务端总共发送4个包以确认连接的断开。在socket编程中，这一过程由客户端或服务端任一方执行close来触发，整个流程如下图所示：

![四次挥手](https://github.com/XFHNever/JobPrepare/blob/master/images/net1-3.png)

由于TCP连接时全双工的，因此，每个方向都必须要单独进行关闭，这一原则是当一方完成数据发送任务后，发送一个FIN来终止这一方向的连接，收到一个FIN只是意味着这一方向上没有数据流动了，即不会再收到数据了，但是在这个TCP连接上仍然能够发送数据，直到这一方向也发送了FIN。首先进行关闭的一方将执行主动关闭，而另一方则执行被动关闭，上图描述的即是如此。

- 第一次挥手：Client发送一个FIN，用来关闭Client到Server的数据传送，Client进入FIN_WAIT_1状态。
- 第二次挥手：Server收到FIN后，发送一个ACK给Client，确认序号为收到序号+1（与SYN相同，一个FIN占用一个序号），Server进入CLOSE_WAIT状态。
- 第三次挥手：Server发送一个FIN，用来关闭Server到Client的数据传送，Server进入LAST_ACK状态。
- 第四次挥手：Client收到FIN后，Client进入TIME_WAIT状态，接着发送一个ACK给Server，确认序号为收到序号+1，Server进入CLOSED状态，完成四次挥手。

######为什么建立连接是三次握手，而关闭连接却是四次挥手呢？
这是因为服务端的LISTEN状态下的SOCKET当收到SYN报文的建连请求后，它可以把ACK和SYN（ACK起应答作用，而SYN起同步作用）放在一个报文里来发送。但关闭连接时，当收到对方的FIN报文通知时，它仅仅表示对方没有数据发送给你了；但未必你所有的数据都全部发送给对方了，所以你可以未必会马上会关闭SOCKET,也即你可能还需要发送一些数据给对方之后，再发送FIN报文给对方来表示你同意现在可以关闭连接了，所以它这里的ACK报文和FIN报文多数情况下都是分开发送的。

##IP报文格式

![IP报文](https://github.com/XFHNever/JobPrepare/blob/master/images/net1-6.jpg)
##UDP报文
UDP报文比较简单。只有源端口、目的端口、长度、校验和四个字段。后面就是数据。

##如何编写socket套接字
sockets（套接字）编程有三种，流式套接字（SOCK_STREAM），数据报套接字（SOCK_DGRAM），原始套接字（SOCK_RAW）；基于TCP的socket编程是采用的流式套接字。

####服务器端程序编写
1. 加载套接字库，创建套接字(socket)；
2. 绑定套接字到一个IP地址和一个端口上(bind)；
3. 将套接字设置为监听模式等待连接请求(listen)；
4. 请求到来后，接受连接请求，返回一个新的对应于此次连接的套接字(accept)；
5. 用返回的套接字和客户端进行通信（send/recv）
6. 返回，等待另一连接请求；
7. 关闭套接字，关闭加载的套接字库（close）

####客户端程序编写
1. 加载套接字库，创建套接字（socket）
2. 向服务器发出连接请求（connect）
3. 和服务器端进行通信（send/recv）
4. 关闭套接字 

##网关的作用
通过它可以访问外网。

## ipconfig 的作用是什么？
显示当前 TCP/IP 配置的信息。

##运行 net share 返回的结果是什么？
列出共享资源相关信息。

##net use 和 net user 分别指什么？
net user 是对用户进行管理，如添加删除网络使用用户等。

net use 是对网络设备进行管理。 

##如何查看当前系统开放的服务？
在命令提示符下执行 net services 命令。 Windows 下是用 net start 

##列出一些其他的命令
	taskkill ：用于结束至少一个进程

	tasklist ：用于显示在本地或远程计算机上运行的所有进程
	
	net view ：显示计算机列表
	
	netstat ：显示网络连接、路由表和网络接口信息 

##端口及对应的服务

![端口及其服务](https://github.com/XFHNever/JobPrepare/blob/master/images/net1-4.png)

##TFTP 协议
Trivial File Transfer Protocol ，是 TCP/IP 协议族中的一个用来在客户机与服务器之间进行简单文件传输的协议，提供不复杂、开销不大的文件传输服务。
##HTTP 协议
HTTP 超文本传输协议，是一个属于应用层的面向对象的协议，由于其简捷、快速的方式，适用于分布式超媒体信息系统。
##DHCP 协议
动态主机配置协议，是一种让系统得以连接到网络上，并获取所需要的配置参数手段
##详细解释一下 IP 协议的定义，在哪个层上面，主要有什么作用？ TCP 和 UDP 呢
IP 协议是网络层的协议，它是为了实现相互连接的计算机进行通信设计的协议，它实现了自动路由功能，即自动寻径功能。 TCP 是传输层的协议，它向下屏蔽 IP 协议的不可靠传输的特性，向上提供一种面向连接的、可靠的点到点数据传输。 TCP 在可靠性和安全性上等更有保证。 UDP 也是传输层协议，它提供的是一种非面向连接的，不可靠的数据传输，这主要是有些应用需要更快速的数据传输，比如局域网内的大多数文件传输都是基于 UDP 的。 UDP 在传输速率上更快，开销更小。
##请问交换机和路由器分别的实现原理是什么？分别在哪个层次上面实现的
交换机用于局域网，利用主机的 MAC 地址进行数据传输，而不需要关心 IP 数据包中的 IP 地址，它工作于数据链路层。路由器识别网络是通过 IP 数据包中 IP 地址的网络号进行的，所以为了保证数据包路由的正确性，每个网络都必须有一个唯一的网络号。路由器通过 IP 数据包的 IP 地址进行路由的（将数据包递交给哪个下一跳路由器）。路由器工作于网络层。由于设备现在的发展，现在很多设备既具有交换又具有路由功能，两者的界限越来越模糊。

## Internet 上保留了哪些 IP 地址用于内部
10.0.0 .0   172.16. 到 172.31   192.168.0. 到 192.168.255 。
##网桥的作用
网桥是一个局域网与另一个局域网之间建立连接的桥梁。
##防火墙的端口防护是指
指通过对防火墙的端口开关的设置，关闭一些非必需端口，达到一定安全防护目的的行为
##TTL 是什么？作用是什么？哪些工具会用到它（ ping traceroute ifconfig  netstat ）
TTL 是指生存时间，简单来说，它表示了数据包在网络中的时间，经过一个路由器后 TTL 就减一，这样 TTL 最终会减为 0 ，当 TTL 为 0 时，则将数据包丢弃，这样也就是因为两个路由器之间可能形成环，如果没有 TTL 的限制，则数据包将会在这个环上一直死转，由于有了 TTL ，最终 TTL 为 0 后，则将数据包丢弃。 ping 发送数据包里面有 TTL ，但是并非是必须的，即是没有 TTL 也是能正常工作的， traceroute 正是因为有了 TTL 才能正常工作， ifconfig 是用来配置网卡信息的，不需要 TTL ， netstat 是用来显示路由表的，也是不需要 TTL 的。
##路由表是做什么用的？在 Linux 环境中怎么配置一条默认路由
路由表是用来决定如何将一个数据包从一个子网传送到另一个子网的，换句话说就是用来决定从一个网卡接收到的包应该送到哪一个网卡上去。路由表的每一行至少 有目标网络号、子网掩码、到这个子网应该使用的网卡这三条信息。当路由器从一个网卡接收到一个包时，它扫描路由表的每一行，用里面的子网掩码与数据包中的 目标 IP 地址做逻辑与运算（ & ）找出目标网络号。如果得出的结果网络号与这一行的网络号相同，就将这条路由表六下来作为备用路由。如果已经有备用路由了，就载这两条路由里将网络号最长的留下来，另一条丢掉（这是用无分类编址 CIDR 的情况才是匹配网络号最长的，其他的情况是找到第一条匹配的行时就可以进行转发了 ）。如此接着扫描下一行直到结束。如果扫描结束仍没有找到任何路由，就用默认路由。确定路由后，直接将数据包送到对应的网卡上去。在具体的实现中，路由表可能包含更多的信息为选路由算法的细节所用。

在 Linux 上可以用“ route add default gw< 默认路由器 IP> ”命令配置一条默认路由。
##每个路由器在寻找路由时需要知道哪 5 部分信息
	目的地址：报文发送的目的地址
	邻站的确定：指明谁直接连接到路由器的接口上
	路由的发现：发现邻站知道哪些网络
	选择路由：通过从邻站学习到的信息，提供最优的到达目的地的路径
	保持路由信息：路由器保存一张路由表，它存储所知道的所有路由信息。
