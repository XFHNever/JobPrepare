##数组遍历同时执行删除操作问题
<a href="http://xfhnever.github.io/blog/2014/07/22/java-collectionremoveproblem/">java集合（一）-ArrayList遍历删除问题</a>

##说出ArrayList,Vector, LinkedList的存储性能和特性
ArrayList和Vector都是使用数组方式存储数据，此数组元素数大于实际存储的数据以便增加和插入元素，
它们都允许直接按序号索引元素，但是插入元素要涉及数组元素移动等内存操作，所以索引数据快而插入
数据慢，Vector由于使用了synchronized方法（线程安全），通常性能上较ArrayList差，

而LinkedList使用双向链表实现存储，按序号索引数据需要进行前向或后向遍历，但是插入数据时只需要记录本项的前
后项即可，所以插入速度较快。

##Collection 和 Collections的区别。
Collection是集合类的上级接口，继承与他的接口主要有Set 和List.

Collections是针对集合类的一个帮助类，他提供一系列静态方法实现对各种集合的搜索、排序、线程安全化等操作。

##HashMap和Hashtable的区别
Hashtable继承自Dictionary类，而HashMap是Java1.2引进的Map interface的一个实现。

最大的不同是，Hashtable的方法是Synchronize的，而HashMap不是，在多个线程访问Hashtable时，不需要自己为它的方法实现同步，而HashMap 就必须为之提供外同步。 

Hashtable和HashMap采用的hash/rehash算法都大概一样，所以性能不会有很大的差异。

HashMap允许将null作为一个entry的key或者value，而Hashtable不允许。

HashMap把Hashtable的contains方法去掉了，改成containsvalue和containsKey。因为contains方法容易让人引起误解。 

##List、Map、Set三个接口，存取元素时，各有什么特点
List 以特定次序来持有元素，可有重复元素。Set 无法拥有重复元素,内部排序。Map 保存key-value值，value可多值。


