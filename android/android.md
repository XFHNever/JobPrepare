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







