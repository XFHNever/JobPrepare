##IP地址分类
现在的IP网络使用32位地址，以点分十进制表示，如172.16.0.0。地址格式为：IP地址=网络地址＋主机地址 或 IP地址=主机地址＋子网地址＋主机地址。

最初设计互联网络时，为了便于寻址以及层次化构造网络，每个IP地址包括两个标识码（ID），即网络ID和主机ID。同一个物理网络上的所有主机都使用同一个网络ID，网络上的一个主机（包括网络上工作站，服务器和路由器等）有一个主机ID与其对应。IP地址根据网络ID的不同分为5种类型，A类地址、B类地址、C类地址、D类地址和E类地址。

- A类：一个A类IP地址由1字节的网络地址和3字节主机地址组成，网络地址的最高位必须是“0”， 地址范围从1.0.0.0 到126.255.255.255。可用的A类网络有126个，每个网络能容纳1亿多个主机。

- B类：一个B类IP地址由2个字节的网络地址和2个字节的主机地址组成，网络地址的最高位必须是“10”，地址范围从128.0.0.0到191.255.255.255。可用的B类网络有16382个，每个网络能容纳6万多个主机 。

- C类：一个C类IP地址由3字节的网络地址和1字节的主机地址组成，网络地址的最高位必须是“110”。范围从192.0.0.0到223.255.255.255。C类网络可达209万余个，每个网络能容纳254个主机。

- D类用于多点广播（Multicast）：224.0.0.0～239.255.255.255
D类IP地址是保留的，用做组播地址.

- E类：240.0.0.0～255.255.255.255,用于科学实验。

####特殊IP地址
私有地址（不可路由的IP地址）有：

	10.0.0.1～10.255.255.254  A类
	172.13.0.1～172.32.255.254  B类
	192.168.0.1～192.168.255.254  C类
IP地址中不能以十进制“127”作为开头，127．X．X．X用于回路测试，

同时网络ID的第一个6位组也不能全置为“0”，全“0”表示本地网络。IP地址中的每一个字节都为0的地址（“0.0.0.0”）对应于当前主机；

IP地址中的每一个字节都为1的IP地址（“255．255．255．255”）是当前子网的广播地址；

IP地址中如果主机地址为全0，则IP地址表示为网络地址或子网地址；如：192.168.1.0，其主机地址为0，表示一个网络地址。

##IP子网掩码
子网掩码是一个32位地址，用于屏蔽IP地址的一部分以区别网络标识和主机标识，并说明该IP地址是在局域网上，还是在远程网上。

例如，假设IP地址为192.160.4.1，子网掩码为255.255.255.0，则网络ID为192.160.4.0,主机ID为0.0.0.1。计算机网络ID的不同，则说明他们不在同一个物理子网内，需通过路由器转发才能进行数据交换。

每类地址具有默认的子网掩码:对于A类为255.0.0.0，对于B类为255.255.0.0，对于C类为255.255.255.0。除了使用上述的表示方法之外，还有使用子网掩码中"1"的位数来表示的，在默认情况下，A类地址为8位，B类地址为16位，C类地址为24位。例如，A类的某个地址为 12.10.10.3/8，这里的最后一个"8"说明该地址的子网掩码为8位，而199.42.26.0/28表示网络199.42.26.0的子网掩码位数有28位。

如果希望在一个网络中建立子网，就要在这个默认的子网掩码中加入一些位，它减少了用于主机地址的位数。加入到掩码中的位数决定了可以配置的子网。因而，在一个划分了子网的网络中，每个地址包含一个网络地址、一个子网位数和一个主机地址