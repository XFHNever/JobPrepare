##EJB�ǻ�����Щ����ʵ�ֵģ���˵��SessionBean��EntityBean������StatefulBean��StatelessBean������
EJB����Session Bean��Entity Bean��Message Driven Bean������JNDI��RMI��JAT�ȼ���ʵ�֡�

SessionBean��J2EEӦ�ó����б��������һЩ�������˵�ҵ�����������������ݿ⡢��������EJB�����

EntityBean����������Ӧ��ϵͳ���õ������ݡ�

���ڿͻ�����SessionBean��һ�ַǳ־��Զ�����ʵ��ĳЩ�ڷ����������е�ҵ���߼���

���ڿͻ�����EntityBean��һ�ֳ־��Զ���������һ���洢�ڳ־��Դ洢���е�ʵ��Ķ�����ͼ������һ����������ҵӦ�ó���ʵ�ֵ�ʵ�塣

Session Bean ��������ϸ��Ϊ Stateful Session Bean �� Stateless Session Bean �������ֵ� Session Bean�����Խ�ϵͳ�߼����� method֮��ִ�У���ͬ���� Stateful Session Bean ���Լ�¼�����ߵ�״̬�����ͨ��
��˵��һ��ʹ���߻���һ�����Ӧ�� Stateful Session Bean ��ʵ�塣Stateless Session Bean ��ȻҲ���߼������������ȴ�������¼ʹ����״̬��Ҳ����˵��ʹ���ߺ��� Stateless Session Bean ��ʱ��EJB Container 
��������Ѱ�ض��� Stateless Session Bean ��ʵ����ִ����� method������֮���ܿ�������ʹ������ִ��ĳ��Stateless Session Bean �� methods ʱ������ͬһ�� Bean �� Instance ��ִ�С����ڴ淽�������� 
Stateful Session Bean �� Stateless Session Bean �Ƚϣ� Stateful Session Bean ������ J2EE Server �϶���ڴ棬Ȼ�� Stateful Session Bean ������ȴ����������ά��ʹ���ߵ�״̬��

##EJB��JAVA BEAN������
Java Bean �ǿɸ��õ��������Java Bean��û���ϸ�Ĺ淶�������Ͻ����κ�һ��Java�඼������һ��Bean��
��ͨ������£�����Java Bean�Ǳ���������������Tomcat���ģ�����Java BeanӦ����һ���޲εĹ����������⣬
ͨ��Java Bean��Ҫʵ��Serializable�ӿ�����ʵ��Bean�ĳ־��ԡ�Java Beanʵ�����൱��΢��COMģ���еı��ؽ�����COM�����
���ǲ��ܱ�����̷��ʵġ�

Enterprise Java Bean �൱��DCOM�����ֲ�ʽ��������ǻ���Java��Զ�̷������ã�RMI�������ģ�
����EJB���Ա�Զ�̷��ʣ�����̡�������������EJB���뱻����������Webspere��WebLogic�����������У�
EJB�ͻ��Ӳ�ֱ�ӷ���������EJB���������ͨ�����������ʡ�EJB������EJB����Ĵ���EJB����������������͹���
�ͻ�ͨ������������������EJB�����

##EJB������SessionBean,EntityBean��˵�����ǵ��������ڣ�����ι�������ģ�
SessionBean��Stateless Session Bean����״̬�� �����������������������ģ����ͻ�����������Ҫ����һ��Bean��ʵ��ʱ��EJB������һ��Ҫ����һ���µ�Bean��ʵ�����ͻ������ã�
���������һ�����е�ʵ���ṩ���ͻ��������ͻ�����һ�ε���һ��Stateful(��״̬) Session Bean ʱ���������������ڷ������д���һ���µ�Beanʵ�������������ͻ����ϣ�
�Ժ�˿ͻ�������Stateful Session Bean �ķ���ʱ������ѵ��÷��ɵ���˿ͻ����������Beanʵ����

EntityBean��Entity Beans�ܴ����Խϳ���ʱ�䣬����״̬�ǳ����ġ�ֻҪ���ݿ��е����ݴ��ڣ�Entity beans��һֱ�������ǰ���Ӧ�ó�����߷��������˵�ġ�
��ʹEJB���������ˣ�Entity beansҲ�Ǵ��ġ�Entity Beans���������ܹ����������� Beans�Լ�����

EJBͨ�����¼����������񣺶��������֯��OMG���Ķ����������OTS����Sun Microsystems��Transaction Service��JTS����Java Transaction API��JTA���������飨X/Open����XA�ӿڡ�

##Ӧ�÷���������Щ
BEA WebLogic Server��IBM WebSphere Application Server��Oracle9i Application Server��jBoss��Tomcat

##EJB�Ľ�ɫ����������
һ�������Ļ���EJB�ķֲ�ʽ����ṹ��������ɫ��ɣ���������ɫ�����ɲ�ͬ�Ŀ������ṩ��
ÿ����ɫ�����Ĺ���������ѭSun��˾�ṩ��EJB�淶���Ա�֤�˴�֮��ļ����ԡ�
��������ɫ�ֱ���EJB��������ߣ�Enterprise Bean Provider�� ��Ӧ������ߣ�Application Assembler����
�����ߣ�Deployer����EJB �������ṩ�ߣ�EJB Server Provider����EJB �����ṩ�ߣ�EJB Container Provider����
ϵͳ����Ա��System Administrator��

����������Remote��Local���ӿڡ�Home��LocalHome���ӿڣ�Bean��

##EJB�����ṩ�ķ���
��Ҫ�ṩ�������ڹ�����������������Թ�����ȫ������������Ͳ�������ȷ���

##EJB�淶�涨EJB�н�ֹ�Ĳ�������Щ
1.���ܲ����̺߳��߳�API(�߳�APIָ���̶߳���ķ�����notify,wait��)��
2.���ܲ���awt��
3.����ʵ�ַ��������ܣ�
4.���ܶԾ�̬���Դ�ȡ��
5.����ʹ��IO����ֱ�Ӵ�ȡ�ļ�ϵͳ��
6.���ܼ��ر��ؿ�.��
7.���ܽ�this��Ϊ�����ͷ��أ�
8.����ѭ�����á�

##remote�ӿں�home�ӿ���Ҫ����
remote�ӿڶ�����ҵ�񷽷�������EJB�ͻ��˵���ҵ�񷽷���

home�ӿ���EJB�������ڴ������Ƴ�����EJBʵ��

##bean ʵ������������
����Stateless Session Bean��Entity Bean��Message Driven Beanһ����ڻ���ع���������Entity Bean��Statefull Session Bean����Cache����
ͨ����������ʵ�������������ġ�����EJB Object��create����ҵ�񷽷����á�remove�ȹ��̣����ڴ��ڻ���ع����Bean����create֮��ʵ���������ڴ������
���ǲ��û���ص��Ȼ��Ʋ�������ʵ���������ڴ���Cache�����Bean��ͨ�������ȥ������Ʊ���Bean��״̬�������ڴ���ʵ��������

##EJB�ļ������
��Stateful Session Bean Ϊ������Cache��С�������ڴ��п���ͬʱ���ڵ�Beanʵ��������������MRU��NRU�㷨��ʵ���ڼ����ȥ����״̬֮��Ǩ�ƣ�
��������ǵ��ͻ��˵���ĳ��EJBʵ��ҵ�񷽷�ʱ�������ӦEJB Object�����Լ�û�а󶨶�Ӧ��Beanʵ�������ȥ����Bean�洢�У�ͨ�����л����ƴ洢ʵ�����ظ��������ʵ����
״̬��Ǩǰ����ö�Ӧ��ejbActive��ejbPassivate������

##�ͷ��˵���EJB����ļ�����������
����JNDI���񹤳��Լ�JNDI�����ַϵͳ���ԣ�����Home�ӿڣ���Home�ӿڵ���Create��������Remote�ӿڣ�ͨ��Remote�ӿڵ�����ҵ�񷽷���

##

