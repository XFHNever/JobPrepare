##Android的四大组件是哪些，它们的作用?
- Activity：Activity是Android程序与用户交互的窗口，是Android构造块中最基本的一种，它需要为保持各界面的状态，做很多持久化的事情，妥善管理生命周期以及一些跳转逻辑
- service：后台服务于Activity，封装有一个完整的功能逻辑实现，接受上层指令，完成相关的事物，定义好需要接受的Intent提供同步和异步的接口
- Content Provider：是Android提供的第三方应用数据的访问方案，可以派生Content Provider类，对外提供数据，可以像数据库一样进行选择排序，屏蔽内部数据的存储细节，向外提供统一的接口模型，大大简化上层应用，对数据的整合提供了更方便的途径
- BroadCast Receiver：接受一种或者多种Intent作触发事件，接受相关消息，做一些简单处理，转换成一条Notification，统一了Android的事件广播模型

##请介绍下Android中常用的五种布局。
常用五种布局方式，分别是：FrameLayout（框架布局），LinearLayout （线性布局），AbsoluteLayout（绝对布局），RelativeLayout（相对布局），TableLayout（表格布局）。
- FrameLayout：所有东西依次都放在左上角，会重叠，这个布局比较简单，也只能放一点比较简单的东西。
- LinearLayout：线性布局，每一个LinearLayout里面又可分为垂直布局（android:orientation="vertical"）和水平布局（android:orientation="horizontal" ）。当垂直布局时，每一行就只有一个元素，多个元素依次垂直往下；
水平布局时，只有一行，每一个元素依次向右排列。
- AbsoluteLayout：绝对布局用X,Y坐标来指定元素的位置，这种布局方式也比较简单，但是在屏幕旋转时，往往会出问题，而且多个元素的时候，计算比较麻烦。
- RelativeLayout：相对布局可以理解为某一个元素为参照物，来定位的布局方式。主要属性有：相对于某一个元素android:layout_below、 android:layout_toLeftOf相对于父元素的地方android:layout_alignParentLeft、android:layout_alignParentRigh；
- TableLayout：表格布局，每一个TableLayout里面有表格行TableRow，TableRow里面可以具体定义每一个元素。

每一个布局都有自己适合的方式，这五个布局元素可以相互嵌套应用，做出美观的界面。

##android中的动画有哪几类，它们的特点和区别是什么  
两种，一种是Tween动画、还有一种是Frame动画。Tween动画，这种实现方式可以使视图组件移动、放大、缩小以及产生透明度的变化;另一种Frame动画，传统的动画方法，通过顺序的播放排列好的图片来实现，类似电影

##android 中有哪几种解析xml的类？官方推荐哪种？以及它们的原理和区别。
XML解析主要有三种方式，SAX、DOM、PULL。常规在PC上开发我们使用Dom相对轻松些，但一些性能敏感的数据库或手机上还是主要采用SAX方式
SAXSAX读取是单向的，优点:不占内存空间、解析属性方便，但缺点就是对于套嵌多个分支来说处理不是很方便。而DOM方式会把整个XML文件加载到内存中去，
DOM方法在查找方面可以和XPath很好的结合如果数据量不是很大推荐使用，而PULL常常用在J2ME对于节点处理比较好，类似SAX方式，同样很节省内存，在J2ME中我们经常使用的KXML库来解析。

##ListView的优化方案
- 如果自定义适配器，那么在getView方法中要考虑方法传进来的参数contentView是否为null，如果为null就创建contentView并返回，如果不为null则直接使用。在这个方法中尽可能少创建view。
- 给contentView设置tag（setTag（）），传入一个viewHolder对象，用于缓存要显示的数据，可以达到图像数据异步加载的效果。
- 如果listview需要显示的item很多，就要考虑分页加载。比如一共要显示100条或者更多的时候，我们可以考虑先加载20条，等用户拉到列表底部的时候再去加载接下来的20条。

##请介绍下Android的数据存储方式。
使用SharedPreferences存储数据；文件存储数据；SQLite数据库存储数据；使用ContentProvider存储数据；网络存储数据；

Preference，File， DataBase这三种方式分别对应的目录是/data/data/Package Name/Shared_Pref, /data/data/Package Name/files, /data/data/Package Name/database 。

####使用SharedPreferences存储数据
它是 Android提供的用来存储一些简单配置信息的一种机制，例如：登录用户的用户名与密码。其采用了Map数据结构来存储数据，以键值的方式存储，可以简单的读取与写入，具体实例如下：

    void ReadSharedPreferences(){
        String strName,strPassword;
        SharedPreferences   user = getSharedPreferences(“user_info”,0);
        strName = user.getString(“NAME”,””);
        strPassword = user getString(“PASSWORD”,””);
    }
    void WriteSharedPreferences(String strName,String strPassword){
        SharedPreferences   user = getSharedPreferences(“user_info”,0);
        uer.edit();
        user.putString(“NAME”, strName);
        user.putString(“PASSWORD” ,strPassword);
        user.commit();
    }
    
数据读取与写入的方法都非常简单，只是在写入的时候有些区别：先调用edit()使其处于编辑状态，然后才能修改数据，最后使用commit()提交修改的数据。
实际上SharedPreferences是采用了XML格式将数据存储到设备中，在DDMS中的File Explorer中的/data/data/&lt;package name>/shares_prefs下。使用SharedPreferences是有些限制的：只能在同一个包内使用，不能在不同的包之间使用。
####文件存储数据
文件存储方式是一种较常用的方法，在Android中读取/写入文件的方法，与 Java中实现I/O的程序是完全一样的，提供了openFileInput()和openFileOutput()方法来读取设备上的文件。具体实例如下:

    String fn = “moandroid.log”;
    FileInputStream fis = openFileInput(fn);
    FileOutputStream fos = openFileOutput(fn,Context.MODE_PRIVATE);

####网络存储数据
网络存储方式，需要与Android 网络数据包打交道,关于Android 网络数据包的详细说明，请阅读Android SDK引用了Java SDK的哪些package
####ContentProvider
######ContentProvider简介
当应用继承ContentProvider类，并重写该类用于提供数据和存储数据的方法，就可以向其他应用共享其数据。虽然使用其他方法也可以对外共享数据，但数据访问方式会因数据存储的方式而不同，
如：采用文件方式对外共享数据，需要进行文件操作读写数据；采用sharedpreferences共享数据，需要使用sharedpreferences API读写数据。而使用ContentProvider共享数据的好处是统一了数据访问方式。
######Uri类简介
Uri代表了要操作的数据，Uri主要包含了两部分信息：

1. 需要操作的ContentProvider ，
2. 对ContentProvider中的什么数据进行操作

一个Uri由以下几部分组成：

1. scheme：ContentProvider（内容提供者）的scheme已经由Android所规定为：content://…
2. 主机名（或Authority）：用于唯一标识这个ContentProvider，外部调用者可以根据这个标识来找到它。
3. 路径（path）：可以用来表示我们要操作的数据，路径的构建应根据业务而定，如下：

   要操作contact表中id为10的记录，可以构建这样的路径:/contact/10
   
   要操作contact表中id为10的记录的name字段， contact/10/name
    
   要操作contact表中的所有记录，可以构建这样的路径:/contact?
   
   要操作的数据不一定来自数据库，也可以是文件等他存储方式，如下:
    
   要操作xml文件中contact节点下的name节点，可以构建这样的路径：/contact/name
   
   如果要把一个字符串转换成Uri，可以使用Uri类中的parse()方法，如下：
    
        Uri uri = Uri.parse("content://com.changcheng.provider.contactprovider/contact")
        
######UriMatcher、ContentUris和ContentResolver简介
因为Uri代表了要操作的数据，所以我们很经常需要解析Uri，并从 Uri中获取数据。Android系统提供了两个用于操作Uri的工具类，分别为UriMatcher 和ContentUris 。掌握它们的使用，会便于我们的开发工作。

**UriMatcher**：用于匹配Uri，它的用法如下：

1.首先把你需要匹配Uri路径全部给注册上，如下：

    //常量UriMatcher.NO_MATCH表示不匹配任何路径的返回码(-1)。
    UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    
    //如果match()方法匹配content://com.changcheng.sqlite.provider.contactprovider /contact 路径，返回匹配码为1
     uriMatcher.addURI(“com.changcheng.sqlite.provider.contactprovider”, “contact”, 1); //添加需要匹配uri，如果匹配就会返回匹配码
    //如果match()方法匹配 content://com.changcheng.sqlite.provider.contactprovider/contact/230 路径，返回匹配码为2
    uriMatcher.addURI(“com.changcheng.sqlite.provider.contactprovider”, “contact/#”, 2); //#号为通配符
2.注册完需要匹配的Uri后，就可以使用uriMatcher.match(uri)方法对输入的Uri进行匹配，如果匹配就返回匹配码，匹配码是调用 addURI()方法传入的第三个参数，
假设匹配 content://com.changcheng.sqlite.provider.contactprovider/contact路径，返回的匹配码为1。

**ContentUris**：用于获取Uri路径后面的ID部分，它有两个比较实用的方法：

1. withAppendedId(uri, id)用于为路径加上ID部分
2. parseId(uri)方法用于从路径中获取ID部分

**ContentResolver**：当外部应用需要对ContentProvider中的数据进行添加、删除、修改和查询操作时，可以使用 ContentResolver 类来完成，要获取ContentResolver 对象，
可以使用Activity提供的getContentResolver()方法。 ContentResolver使用insert、delete、update、query方法，来操作数据。

##activity的启动模式有哪些？是什么含义？
在android里，有4种activity的启动模式，分别为： 

    “standard” (默认) 
    “singleTop” 
    “singleTask” 
    “singleInstance”
    
它们主要有如下不同：

1. 如何决定所属task 
“standard”和”singleTop”的activity的目标task，和收到的Intent的发送者在同一个task内，除非intent包括参数FLAG_ACTIVITY_NEW_TASK。 
如果提供了FLAG_ACTIVITY_NEW_TASK参数，会启动到别的task里。 
“singleTask”和”singleInstance”总是把activity作为一个task的根元素，他们不会被启动到一个其他task里。
2. 是否允许多个实例 
“standard”和”singleTop”可以被实例化多次，并且存在于不同的task中，且一个task可以包括一个activity的多个实例； 
“singleTask”和”singleInstance”则限制只生成一个实例，并且是task的根元素。 singleTop要求如果创建intent的时候栈顶已经有要创建 的Activity的实例，则将intent发送给该实例，而不发送给新的实例。
3. 是否允许其它activity存在于本task内 
“singleInstance”独占一个task，其它activity不能存在那个task里；如果它启动了一个新的activity，不管新的activity的launch mode 如何，新的activity都将会到别的task里运行（如同加了FLAG_ACTIVITY_NEW_TASK参数）。
而另外三种模式，则可以和其它activity共存。
4. 是否每次都生成新实例 
“standard”对于没一个启动Intent都会生成一个activity的新实例； 
“singleTop”的activity如果在task的栈顶的话，则不生成新的该activity的实例，直接使用栈顶的实例，否则，生成该activity的实例。 
比如现在task栈元素为A-B-C-D（D在栈顶），这时候给D发一个启动intent，如果D是 “standard”的，则生成D的一个新实例，栈变为A－B－C－D－D。 
如果D是singleTop的话，则不会生产D的新实例，栈状态仍为A-B-C-D 
如果这时候给B发Intent的话，不管B的launchmode是”standard” 还是 “singleTop” ，都会生成B的新实例，栈状态变为A-B-C-D-B。
“singleInstance”是其所在栈的唯一activity，它会每次都被重用。
“singleTask”如果在栈顶，则接受intent，否则，该intent会被丢弃，但是该task仍会回到前台。
当已经存在的activity实例处理新的intent时候，会调用onNewIntent()方法 如果收到intent生成一个activity实例，那么用户可以通过back键回到上一个状态；如果是已经存在的一个activity来处理这个intent的话，用户不能通过按back键返回到这之前的状态。

##请描述下Activity的生命周期。
activity的生命周期方法有：onCreate()、onStart()、onReStart()、onResume()、onPause()、onStop()、onDestory()；

可见生命周期：从onStart()直到系统调用onStop()

前台生命周期：从onResume()直到系统调用onPause()

##activity在屏幕旋转时的生命周期
不设置Activity的android:configChanges时，切屏会重新调用各个生命周期，切横屏时会执行一次，切竖屏时会执行两次；设置Activity的android:configChanges="orientation"时，切屏还是会重新调用各个生命周期，
切横、竖屏时只会执行一次；设置Activity的android:configChanges="orientation|keyboardHidden"时，切屏不会重新调用各个生命周期，只会执行onConfigurationChanged方法

##如何启用Service，如何停用Service。
1. 继承Service类
2. 在AndroidManifest.xml文件中的<application>节点里对服务进行配置


服务不能自己运行，需要通过调用Context.startService()或Context.bindService()方法启动服务。这两个方法都可以启动Service，但是它们的使用场合有所不同。使用startService()方法启用服务，调用者与服务之间没有关连，即使调用者退出了，服务仍然运行。使用bindService()方法启用服务，调用者与服务绑定在了一起，调用者一旦退出，服务也就终止，大有“不求同时生，必须同时死”的特点。

如果打算采用Context.startService()方法启动服务，在服务未被创建时，系统会先调用服务的onCreate()方法，接着调用onStart()方法。如果调用startService()方法前服务已经被创建，多次调用startService()方法并不会导致多次创建服务，但会导致多次调用onStart()方法。采用startService()方法启动的服务，只能调用Context.stopService()方法结束服务，服务结束时会调用onDestroy()方法。

如果打算采用Context.bindService()方法启动服务，在服务未被创建时，系统会先调用服务的onCreate()方法，接着调用onBind()方法。这个时候调用者和服务绑定在一起，调用者退出了，系统就会先调用服务的onUnbind()方法，接着调用onDestroy()方法。如果调用bindService()方法前服务已经被绑定，多次调用bindService()方法并不会导致多次创建服务及绑定(也就是说onCreate()和onBind()方法并不会被多次调用)。如果调用者希望与正在绑定的服务解除绑定，可以调用unbindService()方法，调用该方法也会导致系统调用服务的onUnbind()-->onDestroy()方法。

服务常用生命周期回调方法如下： 

onCreate() 该方法在服务被创建时调用，该方法只会被调用一次，无论调用多少次startService()或bindService()方法，服务也只被创建一次。

onDestroy()该方法在服务被终止时调用。

与采用Context.startService()方法启动服务有关的生命周期方法

onStart() 只有采用Context.startService()方法启动服务时才会回调该方法。该方法在服务开始运行时被调用。多次调用startService()方法尽管不会多次创建服务，但onStart() 方法会被多次调用。

与采用Context.bindService()方法启动服务有关的生命周期方法

onBind()只有采用Context.bindService()方法启动服务时才会回调该方法。该方法在调用者与服务绑定时被调用，当调用者与服务已经绑定，多次调用Context.bindService()方法并不会导致该方法被多次调用。

onUnbind()只有采用Context.bindService()方法启动服务时才会回调该方法。该方法在调用者与服务解除绑定时被调用

##Android中Activity, Intent, Content Provider, Service各有什么区别
- Activity： 活动，是最基本的android应用程序组件。一个活动就是一个单独的屏幕，每一个活动都被实现为一个独立的类，并且从活动基类继承而来。 
- Intent： 意图，描述应用想干什么。最重要的部分是动作和动作对应的数据。 
- Content Provider：内容提供器，android应用程序能够将它们的数据保存到文件、SQLite数据库中，甚至是任何有效的设备中。当你想将你的应用数据和其他应用共享时，内容提供器就可以发挥作用了。 
- Service：服务，具有一段较长生命周期且没有用户界面的程序。 

##View, surfaceView, GLSurfaceView有什么区别
- view是最基础的，必须在UI主线程内更新画面，速度较慢。 
- SurfaceView 是view的子类，类似使用双缓机制，在新的线程中更新画面所以刷新界面速度比view快 
- GLSurfaceView 是SurfaceView的子类，opengl 专用的 

##Adapter有什么作用？常见的Adapter有哪些？
Adapter是连接后端数据和前端显示的适配器接口。常见的Adapter有ArrayAdapter, BaseAdapter, CursorAdapter, HeaderViewListAdapter,
ListAdapter, ResourceCursorAdapter, SimpleAdapter, SimpleCursorAdapter, SpinnerAdapter, WrapperListAdapter等 

##Manifest.xml文件中主要包括哪些信息
- manifest：根节点，描述了package中所有的内容。 
- uses-permission：请求你的package正常运作所需赋予的安全许可。 
- permission： 声明了安全许可来限制哪些程序能使用你package中的组件和功能。 
- instrumentation：声明了用来测试此package或其他package指令组件的代码。 
- application：包含package中application级别组件声明的根节点。 
- activity：Activity是用来与用户交互的主要工具。 
- receiver：IntentReceiver能使的application获得数据的改变或者发生的操作，即使它当前不在运行。 
- service：Service是能在后台运行任意时间的组件。 
- provider：ContentProvider是用来管理持久化数据并发布给其他应用程序使用的组件

##根据自己的理解描述下Android数字签名
- 所有的应用程序都必须有数字证书，Android系统不会安装一个没有数字证书的应用程序 
- Android程序包使用的数字证书可以是自签名的，不需要一个权威的数字证书机构签名认证 
- 如果要正式发布一个Android ，必须使用一个合适的私钥生成的数字证书来给程序签名，而不能使用adt插件或者ant工具生成的调试证书来发布。 
- 数字证书都是有有效期的，Android只是在应用程序安装的时候才会检查证书的有效期。如果程序已经安装在系统中，即使证书过期也不会影响程序的正常功能







