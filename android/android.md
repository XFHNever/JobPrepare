##Android���Ĵ��������Щ�����ǵ�����?
- Activity��Activity��Android�������û������Ĵ��ڣ���Android��������������һ�֣�����ҪΪ���ָ������״̬�����ܶ�־û������飬���ƹ������������Լ�һЩ��ת�߼�
- service����̨������Activity����װ��һ�������Ĺ����߼�ʵ�֣������ϲ�ָ������ص�����������Ҫ���ܵ�Intent�ṩͬ�����첽�Ľӿ�
- Content Provider����Android�ṩ�ĵ�����Ӧ�����ݵķ��ʷ�������������Content Provider�࣬�����ṩ���ݣ����������ݿ�һ������ѡ�����������ڲ����ݵĴ洢ϸ�ڣ������ṩͳһ�Ľӿ�ģ�ͣ������ϲ�Ӧ�ã������ݵ������ṩ�˸������;��
- BroadCast Receiver������һ�ֻ��߶���Intent�������¼������������Ϣ����һЩ�򵥴���ת����һ��Notification��ͳһ��Android���¼��㲥ģ��

##�������Android�г��õ����ֲ��֡�
�������ֲ��ַ�ʽ���ֱ��ǣ�FrameLayout����ܲ��֣���LinearLayout �����Բ��֣���AbsoluteLayout�����Բ��֣���RelativeLayout����Բ��֣���TableLayout����񲼾֣���
- FrameLayout�����ж������ζ��������Ͻǣ����ص���������ֱȽϼ򵥣�Ҳֻ�ܷ�һ��Ƚϼ򵥵Ķ�����
- LinearLayout�����Բ��֣�ÿһ��LinearLayout�����ֿɷ�Ϊ��ֱ���֣�android:orientation="vertical"����ˮƽ���֣�android:orientation="horizontal" ��������ֱ����ʱ��ÿһ�о�ֻ��һ��Ԫ�أ����Ԫ�����δ�ֱ���£�
ˮƽ����ʱ��ֻ��һ�У�ÿһ��Ԫ�������������С�
- AbsoluteLayout�����Բ�����X,Y������ָ��Ԫ�ص�λ�ã����ֲ��ַ�ʽҲ�Ƚϼ򵥣���������Ļ��תʱ������������⣬���Ҷ��Ԫ�ص�ʱ�򣬼���Ƚ��鷳��
- RelativeLayout����Բ��ֿ������Ϊĳһ��Ԫ��Ϊ���������λ�Ĳ��ַ�ʽ����Ҫ�����У������ĳһ��Ԫ��android:layout_below�� android:layout_toLeftOf����ڸ�Ԫ�صĵط�android:layout_alignParentLeft��android:layout_alignParentRigh��
- TableLayout����񲼾֣�ÿһ��TableLayout�����б����TableRow��TableRow������Ծ��嶨��ÿһ��Ԫ�ء�

ÿһ�����ֶ����Լ��ʺϵķ�ʽ�����������Ԫ�ؿ����໥Ƕ��Ӧ�ã��������۵Ľ��档

##android�еĶ������ļ��࣬���ǵ��ص��������ʲô  
���֣�һ����Tween����������һ����Frame������Tween����������ʵ�ַ�ʽ����ʹ��ͼ����ƶ����Ŵ���С�Լ�����͸���ȵı仯;��һ��Frame��������ͳ�Ķ���������ͨ��˳��Ĳ������кõ�ͼƬ��ʵ�֣����Ƶ�Ӱ

##android �����ļ��ֽ���xml���ࣿ�ٷ��Ƽ����֣��Լ����ǵ�ԭ�������
XML������Ҫ�����ַ�ʽ��SAX��DOM��PULL��������PC�Ͽ�������ʹ��Dom�������Щ����һЩ�������е����ݿ���ֻ��ϻ�����Ҫ����SAX��ʽ
SAXSAX��ȡ�ǵ���ģ��ŵ�:��ռ�ڴ�ռ䡢�������Է��㣬��ȱ����Ƕ�����Ƕ�����֧��˵�����Ǻܷ��㡣��DOM��ʽ�������XML�ļ����ص��ڴ���ȥ��
DOM�����ڲ��ҷ�����Ժ�XPath�ܺõĽ��������������Ǻܴ��Ƽ�ʹ�ã���PULL��������J2ME���ڽڵ㴦��ȽϺã�����SAX��ʽ��ͬ���ܽ�ʡ�ڴ棬��J2ME�����Ǿ���ʹ�õ�KXML����������

##ListView���Ż�����
- ����Զ�������������ô��getView������Ҫ���Ƿ����������Ĳ���contentView�Ƿ�Ϊnull�����Ϊnull�ʹ���contentView�����أ������Ϊnull��ֱ��ʹ�á�����������о������ٴ���view��
- ��contentView����tag��setTag������������һ��viewHolder�������ڻ���Ҫ��ʾ�����ݣ����Դﵽͼ�������첽���ص�Ч����
- ���listview��Ҫ��ʾ��item�ܶ࣬��Ҫ���Ƿ�ҳ���ء�����һ��Ҫ��ʾ100�����߸����ʱ�����ǿ��Կ����ȼ���20�������û������б�ײ���ʱ����ȥ���ؽ�������20����

##�������Android�����ݴ洢��ʽ��
ʹ��SharedPreferences�洢���ݣ��ļ��洢���ݣ�SQLite���ݿ�洢���ݣ�ʹ��ContentProvider�洢���ݣ�����洢���ݣ�

Preference��File�� DataBase�����ַ�ʽ�ֱ��Ӧ��Ŀ¼��/data/data/Package Name/Shared_Pref, /data/data/Package Name/files, /data/data/Package Name/database ��

####ʹ��SharedPreferences�洢����
���� Android�ṩ�������洢һЩ��������Ϣ��һ�ֻ��ƣ����磺��¼�û����û��������롣�������Map���ݽṹ���洢���ݣ��Լ�ֵ�ķ�ʽ�洢�����Լ򵥵Ķ�ȡ��д�룬����ʵ�����£�

    void ReadSharedPreferences(){
        String strName,strPassword;
        SharedPreferences   user = getSharedPreferences(��user_info��,0);
        strName = user.getString(��NAME��,����);
        strPassword = user getString(��PASSWORD��,����);
    }
    void WriteSharedPreferences(String strName,String strPassword){
        SharedPreferences   user = getSharedPreferences(��user_info��,0);
        uer.edit();
        user.putString(��NAME��, strName);
        user.putString(��PASSWORD�� ,strPassword);
        user.commit();
    }
    
���ݶ�ȡ��д��ķ������ǳ��򵥣�ֻ����д���ʱ����Щ�����ȵ���edit()ʹ�䴦�ڱ༭״̬��Ȼ������޸����ݣ����ʹ��commit()�ύ�޸ĵ����ݡ�
ʵ����SharedPreferences�ǲ�����XML��ʽ�����ݴ洢���豸�У���DDMS�е�File Explorer�е�/data/data/&lt;package name>/shares_prefs�¡�ʹ��SharedPreferences����Щ���Ƶģ�ֻ����ͬһ������ʹ�ã������ڲ�ͬ�İ�֮��ʹ�á�
####�ļ��洢����
�ļ��洢��ʽ��һ�ֽϳ��õķ�������Android�ж�ȡ/д���ļ��ķ������� Java��ʵ��I/O�ĳ�������ȫһ���ģ��ṩ��openFileInput()��openFileOutput()��������ȡ�豸�ϵ��ļ�������ʵ������:

    String fn = ��moandroid.log��;
    FileInputStream fis = openFileInput(fn);
    FileOutputStream fos = openFileOutput(fn,Context.MODE_PRIVATE);

####����洢����
����洢��ʽ����Ҫ��Android �������ݰ��򽻵�,����Android �������ݰ�����ϸ˵�������Ķ�Android SDK������Java SDK����Щpackage
####ContentProvider
######ContentProvider���
��Ӧ�ü̳�ContentProvider�࣬����д���������ṩ���ݺʹ洢���ݵķ������Ϳ���������Ӧ�ù��������ݡ���Ȼʹ����������Ҳ���Զ��⹲�����ݣ������ݷ��ʷ�ʽ�������ݴ洢�ķ�ʽ����ͬ��
�磺�����ļ���ʽ���⹲�����ݣ���Ҫ�����ļ�������д���ݣ�����sharedpreferences�������ݣ���Ҫʹ��sharedpreferences API��д���ݡ���ʹ��ContentProvider�������ݵĺô���ͳһ�����ݷ��ʷ�ʽ��
######Uri����
Uri������Ҫ���������ݣ�Uri��Ҫ��������������Ϣ��

1. ��Ҫ������ContentProvider ��
2. ��ContentProvider�е�ʲô���ݽ��в���

һ��Uri�����¼�������ɣ�

1. scheme��ContentProvider�������ṩ�ߣ���scheme�Ѿ���Android���涨Ϊ��content://��
2. ����������Authority��������Ψһ��ʶ���ContentProvider���ⲿ�����߿��Ը��������ʶ���ҵ�����
3. ·����path��������������ʾ����Ҫ���������ݣ�·���Ĺ���Ӧ����ҵ����������£�

   Ҫ����contact����idΪ10�ļ�¼�����Թ���������·��:/contact/10
   
   Ҫ����contact����idΪ10�ļ�¼��name�ֶΣ� contact/10/name
    
   Ҫ����contact���е����м�¼�����Թ���������·��:/contact?
   
   Ҫ���������ݲ�һ���������ݿ⣬Ҳ�������ļ������洢��ʽ������:
    
   Ҫ����xml�ļ���contact�ڵ��µ�name�ڵ㣬���Թ���������·����/contact/name
   
   ���Ҫ��һ���ַ���ת����Uri������ʹ��Uri���е�parse()���������£�
    
        Uri uri = Uri.parse("content://com.changcheng.provider.contactprovider/contact")
        
######UriMatcher��ContentUris��ContentResolver���
��ΪUri������Ҫ���������ݣ��������Ǻܾ�����Ҫ����Uri������ Uri�л�ȡ���ݡ�Androidϵͳ�ṩ���������ڲ���Uri�Ĺ����࣬�ֱ�ΪUriMatcher ��ContentUris ���������ǵ�ʹ�ã���������ǵĿ���������

**UriMatcher**������ƥ��Uri�������÷����£�

1.���Ȱ�����Ҫƥ��Uri·��ȫ����ע���ϣ����£�

    //����UriMatcher.NO_MATCH��ʾ��ƥ���κ�·���ķ�����(-1)��
    UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    
    //���match()����ƥ��content://com.changcheng.sqlite.provider.contactprovider /contact ·��������ƥ����Ϊ1
     uriMatcher.addURI(��com.changcheng.sqlite.provider.contactprovider��, ��contact��, 1); //�����Ҫƥ��uri�����ƥ��ͻ᷵��ƥ����
    //���match()����ƥ�� content://com.changcheng.sqlite.provider.contactprovider/contact/230 ·��������ƥ����Ϊ2
    uriMatcher.addURI(��com.changcheng.sqlite.provider.contactprovider��, ��contact/#��, 2); //#��Ϊͨ���
2.ע������Ҫƥ���Uri�󣬾Ϳ���ʹ��uriMatcher.match(uri)�����������Uri����ƥ�䣬���ƥ��ͷ���ƥ���룬ƥ�����ǵ��� addURI()��������ĵ�����������
����ƥ�� content://com.changcheng.sqlite.provider.contactprovider/contact·�������ص�ƥ����Ϊ1��

**ContentUris**�����ڻ�ȡUri·�������ID���֣����������Ƚ�ʵ�õķ�����

1. withAppendedId(uri, id)����Ϊ·������ID����
2. parseId(uri)�������ڴ�·���л�ȡID����

**ContentResolver**�����ⲿӦ����Ҫ��ContentProvider�е����ݽ�����ӡ�ɾ�����޸ĺͲ�ѯ����ʱ������ʹ�� ContentResolver ������ɣ�Ҫ��ȡContentResolver ����
����ʹ��Activity�ṩ��getContentResolver()������ ContentResolverʹ��insert��delete��update��query���������������ݡ�

##activity������ģʽ����Щ����ʲô���壿
��android���4��activity������ģʽ���ֱ�Ϊ�� 

    ��standard�� (Ĭ��) 
    ��singleTop�� 
    ��singleTask�� 
    ��singleInstance��
    
������Ҫ�����²�ͬ��

1. ��ξ�������task 
��standard���͡�singleTop����activity��Ŀ��task�����յ���Intent�ķ�������ͬһ��task�ڣ�����intent��������FLAG_ACTIVITY_NEW_TASK�� 
����ṩ��FLAG_ACTIVITY_NEW_TASK�����������������task� 
��singleTask���͡�singleInstance�����ǰ�activity��Ϊһ��task�ĸ�Ԫ�أ����ǲ��ᱻ������һ������task�
2. �Ƿ�������ʵ�� 
��standard���͡�singleTop�����Ա�ʵ������Σ����Ҵ����ڲ�ͬ��task�У���һ��task���԰���һ��activity�Ķ��ʵ���� 
��singleTask���͡�singleInstance��������ֻ����һ��ʵ����������task�ĸ�Ԫ�ء� singleTopҪ���������intent��ʱ��ջ���Ѿ���Ҫ���� ��Activity��ʵ������intent���͸���ʵ�����������͸��µ�ʵ����
3. �Ƿ���������activity�����ڱ�task�� 
��singleInstance����ռһ��task������activity���ܴ����Ǹ�task������������һ���µ�activity�������µ�activity��launch mode ��Σ��µ�activity�����ᵽ���task�����У���ͬ����FLAG_ACTIVITY_NEW_TASK��������
����������ģʽ������Ժ�����activity���档
4. �Ƿ�ÿ�ζ�������ʵ�� 
��standard������ûһ������Intent��������һ��activity����ʵ���� 
��singleTop����activity�����task��ջ���Ļ����������µĸ�activity��ʵ����ֱ��ʹ��ջ����ʵ�����������ɸ�activity��ʵ���� 
��������taskջԪ��ΪA-B-C-D��D��ջ��������ʱ���D��һ������intent�����D�� ��standard���ģ�������D��һ����ʵ����ջ��ΪA��B��C��D��D�� 
���D��singleTop�Ļ����򲻻�����D����ʵ����ջ״̬��ΪA-B-C-D 
�����ʱ���B��Intent�Ļ�������B��launchmode�ǡ�standard�� ���� ��singleTop�� ����������B����ʵ����ջ״̬��ΪA-B-C-D-B��
��singleInstance����������ջ��Ψһactivity������ÿ�ζ������á�
��singleTask�������ջ���������intent�����򣬸�intent�ᱻ���������Ǹ�task�Ի�ص�ǰ̨��
���Ѿ����ڵ�activityʵ�������µ�intentʱ�򣬻����onNewIntent()���� ����յ�intent����һ��activityʵ������ô�û�����ͨ��back���ص���һ��״̬��������Ѿ����ڵ�һ��activity���������intent�Ļ����û�����ͨ����back�����ص���֮ǰ��״̬��

##��������Activity���������ڡ�
activity���������ڷ����У�onCreate()��onStart()��onReStart()��onResume()��onPause()��onStop()��onDestory()��

�ɼ��������ڣ���onStart()ֱ��ϵͳ����onStop()

ǰ̨�������ڣ���onResume()ֱ��ϵͳ����onPause()

##activity����Ļ��תʱ����������
������Activity��android:configChangesʱ�����������µ��ø����������ڣ��к���ʱ��ִ��һ�Σ�������ʱ��ִ�����Σ�����Activity��android:configChanges="orientation"ʱ���������ǻ����µ��ø����������ڣ�
�кᡢ����ʱֻ��ִ��һ�Σ�����Activity��android:configChanges="orientation|keyboardHidden"ʱ�������������µ��ø����������ڣ�ֻ��ִ��onConfigurationChanged����

##�������Service�����ͣ��Service��
1. �̳�Service��
2. ��AndroidManifest.xml�ļ��е�<application>�ڵ���Է����������


�������Լ����У���Ҫͨ������Context.startService()��Context.bindService()��������������������������������Service���������ǵ�ʹ�ó���������ͬ��ʹ��startService()�������÷��񣬵����������֮��û�й�������ʹ�������˳��ˣ�������Ȼ���С�ʹ��bindService()�������÷��񣬵���������������һ�𣬵�����һ���˳�������Ҳ����ֹ�����С�����ͬʱ��������ͬʱ�������ص㡣

����������Context.startService()�������������ڷ���δ������ʱ��ϵͳ���ȵ��÷����onCreate()���������ŵ���onStart()�������������startService()����ǰ�����Ѿ�����������ε���startService()���������ᵼ�¶�δ������񣬵��ᵼ�¶�ε���onStart()����������startService()���������ķ���ֻ�ܵ���Context.stopService()�����������񣬷������ʱ�����onDestroy()������

����������Context.bindService()�������������ڷ���δ������ʱ��ϵͳ���ȵ��÷����onCreate()���������ŵ���onBind()���������ʱ������ߺͷ������һ�𣬵������˳��ˣ�ϵͳ�ͻ��ȵ��÷����onUnbind()���������ŵ���onDestroy()�������������bindService()����ǰ�����Ѿ����󶨣���ε���bindService()���������ᵼ�¶�δ������񼰰�(Ҳ����˵onCreate()��onBind()���������ᱻ��ε���)�����������ϣ�������ڰ󶨵ķ������󶨣����Ե���unbindService()���������ø÷���Ҳ�ᵼ��ϵͳ���÷����onUnbind()-->onDestroy()������

�������������ڻص��������£� 

onCreate() �÷����ڷ��񱻴���ʱ���ã��÷���ֻ�ᱻ����һ�Σ����۵��ö��ٴ�startService()��bindService()����������Ҳֻ������һ�Ρ�

onDestroy()�÷����ڷ�����ֹʱ���á�

�����Context.startService()�������������йص��������ڷ���

onStart() ֻ�в���Context.startService()������������ʱ�Ż�ص��÷������÷����ڷ���ʼ����ʱ�����á���ε���startService()�������ܲ����δ������񣬵�onStart() �����ᱻ��ε��á�

�����Context.bindService()�������������йص��������ڷ���

onBind()ֻ�в���Context.bindService()������������ʱ�Ż�ص��÷������÷����ڵ�����������ʱ�����ã���������������Ѿ��󶨣���ε���Context.bindService()���������ᵼ�¸÷�������ε��á�

onUnbind()ֻ�в���Context.bindService()������������ʱ�Ż�ص��÷������÷����ڵ��������������ʱ������

##Android��Activity, Intent, Content Provider, Service����ʲô����
- Activity�� ������������androidӦ�ó��������һ�������һ����������Ļ��ÿһ�������ʵ��Ϊһ���������࣬���Ҵӻ����̳ж����� 
- Intent�� ��ͼ������Ӧ�����ʲô������Ҫ�Ĳ����Ƕ����Ͷ�����Ӧ�����ݡ� 
- Content Provider�������ṩ����androidӦ�ó����ܹ������ǵ����ݱ��浽�ļ���SQLite���ݿ��У��������κ���Ч���豸�С������뽫���Ӧ�����ݺ�����Ӧ�ù���ʱ�������ṩ���Ϳ��Է��������ˡ� 
- Service�����񣬾���һ�νϳ�����������û���û�����ĳ��� 

##View, surfaceView, GLSurfaceView��ʲô����
- view��������ģ�������UI���߳��ڸ��»��棬�ٶȽ����� 
- SurfaceView ��view�����࣬����ʹ��˫�����ƣ����µ��߳��и��»�������ˢ�½����ٶȱ�view�� 
- GLSurfaceView ��SurfaceView�����࣬opengl ר�õ� 

##Adapter��ʲô���ã�������Adapter����Щ��
Adapter�����Ӻ�����ݺ�ǰ����ʾ���������ӿڡ�������Adapter��ArrayAdapter, BaseAdapter, CursorAdapter, HeaderViewListAdapter,
ListAdapter, ResourceCursorAdapter, SimpleAdapter, SimpleCursorAdapter, SpinnerAdapter, WrapperListAdapter�� 

##Manifest.xml�ļ�����Ҫ������Щ��Ϣ
- manifest�����ڵ㣬������package�����е����ݡ� 
- uses-permission���������package�����������踳��İ�ȫ��ɡ� 
- permission�� �����˰�ȫ�����������Щ������ʹ����package�е�����͹��ܡ� 
- instrumentation���������������Դ�package������packageָ������Ĵ��롣 
- application������package��application������������ĸ��ڵ㡣 
- activity��Activity���������û���������Ҫ���ߡ� 
- receiver��IntentReceiver��ʹ��application������ݵĸı���߷����Ĳ�������ʹ����ǰ�������С� 
- service��Service�����ں�̨��������ʱ�������� 
- provider��ContentProvider����������־û����ݲ�����������Ӧ�ó���ʹ�õ����

##�����Լ������������Android����ǩ��
- ���е�Ӧ�ó��򶼱���������֤�飬Androidϵͳ���ᰲװһ��û������֤���Ӧ�ó��� 
- Android�����ʹ�õ�����֤���������ǩ���ģ�����Ҫһ��Ȩ��������֤�����ǩ����֤ 
- ���Ҫ��ʽ����һ��Android ������ʹ��һ�����ʵ�˽Կ���ɵ�����֤����������ǩ����������ʹ��adt�������ant�������ɵĵ���֤���������� 
- ����֤�鶼������Ч�ڵģ�Androidֻ����Ӧ�ó���װ��ʱ��Ż���֤�����Ч�ڡ���������Ѿ���װ��ϵͳ�У���ʹ֤�����Ҳ����Ӱ��������������

##ʲô��ANR ��α�����
ANR����

��Android�ϣ�������Ӧ�ó�����һ��ʱ����Ӧ����������ϵͳ�����û���ʾһ���Ի�������Ի������Ӧ�ó�������Ӧ��ANR��Application Not 
Responding���Ի����û�����ѡ���ó���������У����ǣ�������ʹ�����Ӧ�ó���ʱ������ϣ��ÿ�ζ�Ҫ��������Ի�����ˣ��ڳ��������Ӧ���ܵ���
�ƺ���Ҫ��������ϵͳ������ʾANR���û���

��������⣺

���������ANR���壬���������о�һ��Ϊʲô������AndroidӦ�ó����﷢����
�����ѹ���Ӧ�ó���������ANR��

AndroidӦ�ó���ͨ����������һ���������̣߳����磬main�������ζ����
��Ӧ�ó���������������������߳���ռ����̫����ʱ��Ļ����ͻ�����ANR��
������Ϊ���Ӧ�ó���û�и��Լ����������������¼�����Intent�㲥��
��ˣ����������߳�����κη������������������顣�ر��ǣ�ActivityӦ����
���Ĺؼ��������ڷ�������onCreate()��onResume()���ﾡ�����ٵ�ȥ��������
����Ǳ�ڵĺ�ʱ������������������ݿ���������߸ߺ�ʱ�ļ�����ı�λͼ��
�磬Ӧ�������߳�����������ݿ����Ϊ����ͨ���첽����ķ�ʽ������ɡ�
Ȼ��������˵������߳�����������ȴ����̵߳���ɡ���Ҳ���ǵ���
Thread.wait()����Thread.sleep()������ķ����ǣ����߳�Ӧ��Ϊ���߳��ṩ
һ��Handler���Ա����ʱ�ܹ��ύ�����̡߳������ַ�ʽ������Ӧ�ó���
���ܱ�֤������̱߳��ֶ��������Ӧ�Բ��ܱ�������5�������¼��ĳ�ʱ����
��ANR�Ի�����������Ӧ����������ʾUI���߳���Ч�£���Ϊ���Ƕ�����ͬ��
��ʱӰ�졣

IntentReceiverִ��ʱ�������������ζ����Ӧ�������ں�̨����С�ġ������
�����籣���趨����ע��һ��Notification���������߳�����õ���������һ��
��Ӧ�ó���Ӧ�ñ�����BroadcastReceiver������ʱ�Ĳ�������㡣����������
���߳�������Щ������ΪBroadcastReceiver���������ڶ̣���������ǣ���
����ӦIntent�㲥��Ҫִ��һ����ʱ�Ķ����Ļ���Ӧ�ó���Ӧ������һ��
Service��˳���ἰһ�䣬��ҲӦ�ñ�����Intent Receiver������һ��Activity
����Ϊ���ᴴ��һ���µĻ��棬���ӵ�ǰ�û��������еĳ��������ό�㡣���
���Ӧ�ó�������ӦIntent�㲥ʱ��Ҫ���û�չʾʲô����Ӧ��ʹ��
Notification Manager��ʵ�֡�

һ����˵����Ӧ�ó����100��200ms���û��ܸ�֪���͵�ʱ����ֵ����ˣ���
����һЩ����ļ���������ANR���������������Ӧ�ó�����������Ӧ�ԡ�
������Ӧ�ó���Ϊ��Ӧ�û��������ں�̨�����Ļ���������ʾ�����Ľ���
��ProgressBar��ProgressDialog�����������˵�����ã���
�ر�����Ϸ�������߳������ƶ��ļ��㡣
������Ӧ�ó�����һ����ʱ�ĳ�ʼ�����̵Ļ������ǿ�����ʾһ��Splash Screen���߿�����ʾ�����沢�첽�������Щ��Ϣ��������������£��㶼Ӧ��
��ʾ���ڽ��еĽ��ȣ������û���ΪӦ�ó��򱻶����ˡ�

##��Ҫ����һ��activity�� intent ��intent filter��service��Broadcast��BroadcastReceiver
####Activity
Android�У�Activity�����г���ĸ��������г�������̶�������Activity֮�У�Activity�����Լ�����������(��ϵͳ�����������ڣ������޷��ı䣬��������onSaveInstanceState������״̬����

����Activity���ؼ������������ڵİ��գ���ξ���״̬�ı���ͻָ���onSaveInstanceState onRestoreInstanceState�����Լ�Activity֮�����ת�����ݴ��䣨intent����

Activity�г��õĺ�����SetContentView()   findViewById()    finish()   startActivity()�������������漰�ĺ����У�

    void onCreate(Bundle savedInstanceState)
    void onStart()
    void onRestart()
    void onResume()
    void onPause()
    void onStop()
    void onDestroy()
Activity��ʹ����Ҫ��Manifest�ļ��������Ӧ��<Activity>�������������Ժ�intent-filter��

####Intent
Android���ṩ��Intent������Э��Ӧ�ü�Ľ�����ͨѶ��Intent�����Ӧ����һ�β����Ķ����������漰���ݡ��������ݽ���������Android����ݴ�Intent�������������ҵ���Ӧ��������� Intent���ݸ����õ���������������ĵ�
�á�Intent����������Ӧ�ó���֮�䣬Ҳ������Ӧ�ó����ڲ���Activity/Service֮��Ľ�������ˣ�Intent����������һ��ý���н�����ã�ר���ṩ���������õ������Ϣ��ʵ�ֵ������뱻������֮��Ľ����SDK
�и�����Intent���õı�����ʽΪ��

- ͨ��Context.startActivity() orActivity.startActivityForResult() ����һ��Activity�� 
- ͨ�� Context.startService() ����һ�����񣬻���ͨ�� Context.bindService() �ͺ�̨���񽻻��� 
- ͨ���㲥����(���� Context.sendBroadcast(),Context.sendOrderedBroadcast(),  Context.sendStickyBroadcast()) ����broadcast receivers��

Intent���Ե����ã��������¼��㣺������ΪXML�ж��壬��ȻҲ����ͨ��Intent��ķ�������ȡ�����ã�

- Action��Ҳ����Ҫִ�еĶ���SDk�ж�����һЩ��׼�Ķ���;Ҳ�����Զ��嶯�����Զ���Ķ�����ʹ��ʱ����Ҫ���ϰ�����Ϊǰ׺����"com.example.project.SHOW_COLOR���������ɶ�����Ӧ��Activity���������ǵ��Զ��嶯����
- Data��Ҳ����ִ�ж���Ҫ����������.Android�в���ָ�����ݵ�һ��URI����ʾ��������ϵ��Ӧ���У�һ��ָ��ĳ��ϵ�˵�URI����Ϊ��content://contacts/1�����ڲ�ͬ�Ķ�������URI���ݵ�������
       ��ͬ�ģ���������type����ָ���ض��������ݣ�����ACTION_EDITָ��DataΪ�ļ�URI����绰Ϊtel:URI����������Ϊhttp:URI������content provider�ṩ��������Ϊcontent: URIs��
- type���������ͣ�����ʽָ��Intent���������ͣ�MIME����һ��Intent�����������ܹ��������ݱ�������ж�������ͨ������������ԣ�����ǿ�Ʋ�����ʽָ�������Ͷ����ٽ����Ƶ���
- category����𣩣���ִ�ж����ĸ�����Ϣ������ LAUNCHER_CATEGORY ��ʾIntent �Ľ�����Ӧ����Launcher����Ϊ����Ӧ�ó��֣���ALTERNATIVE_CATEGORY��ʾ��ǰ��Intent��һϵ�еĿ�ѡ�����е�һ������Щ����������ͬһ��������ִ�С�
- component���������ָ��Intent�ĵ�Ŀ������������ơ�ͨ�� Android�����Intent �а������������Ե���Ϣ������action��data/type��category���в��ң������ҵ�һ����֮ƥ���Ŀ����������ǣ���� component���������ָ
   ���Ļ�����ֱ��ʹ����ָ���������������ִ���������ҹ��̡�ָ������������Ժ�Intent�������������Զ��ǿ�ѡ�ġ�
- extras��������Ϣ�������������и�����Ϣ�ļ��ϡ�ʹ��extras����Ϊ����ṩ��չ��Ϣ�����磬���Ҫִ�С����͵����ʼ���������������Խ������ʼ��ı��⡢���ĵȱ�����extras����������ʼ����������

���Intent�Ĺؼ�֮һ��������Intent�����ֻ����÷���һ������ʽ��Intent�����ڹ���Intent����ʱ��ָ�������ߣ���һ������ʽ��Intent����Intent�ķ������ڹ���Intent����ʱ������֪��Ҳ�����Ľ�������˭�������ڽ��ͷ����ߺ�
������֮�����ϡ�

������ʽIntent��Android����Ҫȥ����������ΪĿ������Ѿ�����ȷ��Android��Ҫ����������Щ��ʽIntent��ͨ���������� Intentӳ������Դ����Intent��Activity��IntentReceiver��Service��        

Intent����������Ҫ��ͨ��������ע����AndroidManifest.xml�е�����IntentFilter�����ж����Intent�������ҵ�ƥ���Intent����������������У�Android��ͨ��Intent��action��type��category�����������������жϵģ�
�жϷ������£�

- ���Intentָ������action����Ŀ�������IntentFilter��action�б��оͱ�����������action��������ƥ�䣻 
- ���Intentû���ṩtype��ϵͳ����data�еõ��������͡���actionһ����Ŀ����������������б��б������Intent���������ͣ�������ƥ�䡣 
- ���Intent�е����ݲ���content: ���͵�URI������IntentҲû����ȷָ������type��������Intent�����ݵ�scheme ������ http: ����mailto:�� ����ƥ�䡣ͬ�ϣ�Intent ��scheme���������Ŀ�������scheme�б��С� 
- ���Intentָ����һ������category����Щ������ȫ���������齨������б��С�����Intent�а������������LAUNCHER_CATEGORY �� ALTERNATIVE_CATEGORY�������õ���Ŀ������������ٰ������������



####Intent Filter
IntentFilter���ʾIntent������, �󲿷������, ÿһ��component���ᶨ��һ������IntentFilter, ���ڱ�����ɴ����Intent. 
####Service
service��û�н���ĳ��������ڵĴ��롣һ���ܺõ�������ý�岥�������б� �в��Ÿ�������һ��ý�岥���������У����Ҫ��һ���������activity�� �����û�ѡ���������������Ȼ�������ֵĻطžͲ���ʹ�û��activity���� 
����Ϊ�û�ϣ������������������ʱ���ּ������š���������£�ý�岥�������activity��Ҫ��Context.startService()����һ���������ں�̨���б����� �ֵĲ��š�ϵͳ������������ֻطŷ��������ֱ����������ע��һ�£���Ҫ�� 
Context.bindService()�������ӷ��������û�����У�Ҫ���������������� �ӵ�����������ͨ������¶��һ���ӿں���ͨ�š��������ַ�������������ͣ���������ȵȡ�

####Broadcast/BroadcastReceiver
 ��Android�У�Broadcast��һ�ֹ㷺���õ���Ӧ�ó���֮�䴫����Ϣ�Ļ��ơ���BroadcastReceiver�ǶԷ��ͳ����� Broadcast���й��˽��ܲ���Ӧ��һ����������潫��ϸ�Ĳ�����η���Broadcast��ʹ��BroadcastReceiver�� 
�˽��յĹ��̣� 

��������Ҫ������Ϣ�ĵط�����Ҫ���͵���Ϣ�����ڹ��˵���Ϣ(��Action��Category)װ��һ��Intent����Ȼ��ͨ������ Context.sendBroadcast()��sendOrderBroadcast()��sendStickyBroadcast()�������� Intent�����Թ㲥��
ʽ���ͳ�ȥ�� 
    
��Intent�����Ժ������Ѿ�ע���BroadcastReceiver����ע��ʱ��IntentFilter�Ƿ��뷢�͵�Intent��ƥ�䣬�� ƥ����ͻ����BroadcastReceiver��onReceive()���������Ե����Ƕ���һ��
BroadcastReceiver��ʱ�򣬶���Ҫ ʵ��onReceive()������

ע��BroadcastReceiver�����ַ�ʽ: 

һ�ַ�ʽ�ǣ���̬����AndroidManifest.xml����<receiver>��ǩ����ע�ᣬ���ڱ�ǩ����<intent- filter>��ǩ���ù������� 
    
��һ�ַ�ʽ�ǣ���̬���ڴ������ȶ��岢���ú�һ�� IntentFilter����Ȼ������Ҫע��ĵط��� Context.registerReceiver()���������ȡ��ʱ�͵���Context.unregisterReceiver()������

��������xmlע��Ļ����ô���ע���,�ڳ����˳���ʱ��û��������Ҫ����ע��,�����´�����������ܻ��ж�� BroadcastReceiver

���⣬����ʹ��sendBroadcast()�ķ�����ָ���˽���Ȩ�ޣ���ֻ����AndroidManifest.xml����<uses- permission>��ǩ������ӵ�д�Ȩ�޵�BroascastReceiver�Ż��п��ܽ��յ���������Broadcast�� 
    
ͬ��������ע��BroadcastReceiverʱָ���˿ɽ��յ�Broadcast��Ȩ�ޣ���ֻ���ڰ��ڵ�AndroidManifest.xml�� ��<uses-permission>��ǩ�����ˣ�ӵ�д�Ȩ�޵�Context���������͵�Broadcast���ܱ���� BroadcastReceiver�����ա� 

��̬ע�᣺

    IntentFilter intentFilter = new IntentFilter(); 
    intentFilter.addAction(String);--Ϊ BroadcastReceiverָ��action��
    ʹ֮���ڽ���ͬaction�Ĺ㲥 registerReceiver(BroadcastReceiver,intentFilter); 
    һ�㣺��onStart��ע�ᣬonStop��ȡ��unregisterReceiver 
    ���͹㲥��Ϣ��extends Service 
    ָ���㲥Ŀ��Action��Intent Intent = new Intent(action-String) 
    --ָ���˴�action��receiver����մ˹㲥 
    �贫�ݲ���(��ѡ) putExtra(); 
    ���ͣ�sendBroadcast(Intent);
    
##�����̨��Activity����ĳԭ��ϵͳ�����ˣ�����ڱ�ϵͳ����֮ǰ���浱ǰ״̬
��дonDestroy�������ڷ����б���

##��ν�һ��Activity���óɴ��ڵ���ʽ
����ֱ���������Ӧ��ҪչʾΪDialog style��Activity��android:theme����,ֵΪandroid:theme="@android:style/Theme.Dialog"��
##����˳�Activity����ΰ�ȫ�˳��ѵ��ö��Activity��Application
1. ���쳣ǿ���˳���
    �÷���ͨ�����쳣��ʹ����Force Close����֤���ԣ����ǣ���Ҫ����������ǣ����ʹ�������������������Force Close�Ĵ��ڡ�
2. ��¼�򿪵�Activity��
    ÿ��һ��Activity���ͼ�¼����������Ҫ�˳�ʱ���ر�ÿһ��Activity���ɡ�
3. �����ض��㲥��
    ����Ҫ����Ӧ��ʱ������һ���ض��Ĺ㲥��ÿ��Activity�յ��㲥�󣬹رռ��ɡ�
4. �ݹ��˳�
    �ڴ��µ�Activityʱʹ��startActivityForResult��Ȼ���Լ��ӱ�־����onActivityResult�д����ݹ�رա�

##







