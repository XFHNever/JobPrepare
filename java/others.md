##��������ֵ��ͬ(x.equals(y) == true)����ȴ���в�ͬ��hash code����仰�Բ���
���ԣ�����ͬ��hash code

<a = href="http://www.cnblogs.com/qqzy168/p/3246057.html">http://www.cnblogs.com/qqzy168/p/3246057.html</a>

##��һ�����󱻵����������ݵ�һ�������󣬴˷����ɸı������������ԣ����ɷ��ر仯��Ľ������ô���ﵽ����ֵ���ݻ������ô���
��ֵ���ݡ�Java �������ֻ��ֵ���ݲ�������һ������ʵ����Ϊһ�����������ݵ�������ʱ��������ֵ���ǶԸö�������á���������ݿ����ڱ����õķ����иı䣬���������������Զ����ı��

##����һ��JVM����class�ļ���ԭ�����
JVM�����װ������ClassLoader������������ʵ�ֵ�,Java ClassLoader ��һ����Ҫ��Java����ʱϵͳ�����������������ʱ���Һ�װ�����ļ�����

##java���м������͵�����JDKΪÿ�����͵����ṩ��һЩ�������Թ��̳У���˵�����Ƿֱ�����Щ�ࣿ
�ֽ������ַ������ֽ����̳���InputStream OutputStream���ַ����̳���InputStreamReader OutputStreamWriter��
��java.io���л������������������Ҫ��Ϊ��������ܺ�ʹ�÷��㡣

##ʲô��java���л������ʵ��java���л�
���л�����һ����������������Ļ��ƣ���ν������Ҳ���ǽ���������ݽ������������Զ�������Ķ�����ж�д������
Ҳ�ɽ�������Ķ�����������֮�䡣���л���Ϊ�˽���ڶԶ��������ж�д����ʱ�����������⡣

���л���ʵ�֣�����Ҫ�����л�����ʵ��Serializable�ӿڣ��ýӿ�û����Ҫʵ�ֵķ�����implements Serializableֻ��Ϊ�˱�ע�ö����ǿɱ����л��ģ�Ȼ��ʹ��һ�������(�磺FileOutputStream)������һ��ObjectOutputStream(������)����
���ţ�ʹ��ObjectOutputStream�����writeObject(Object obj)�����Ϳ��Խ�����Ϊobj�Ķ���д��(��������״̬)��Ҫ�ָ��Ļ�������������

##дclone()����ʱ��ͨ������һ�д��룬��ʲô
Clone ��ȱʡ��Ϊ��super.clone();�����������ȷ��С�Ŀռ䣬����λ���ơ�

##˵��һЩ���õ��࣬�����ӿڣ������5��
���õ��ࣺBufferedReader  BufferedWriter  FileReader  FileWirter  String  Integer

���õİ���java.lang  java.awt  java.io  java.util  java.sql

���õĽӿڣ�Remote  List  Map  Document  NodeList 

##JDK��JRE����
JDK��java�������ߣ��������ṩ��Java����
