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

##什么是ANR 如何避免它
ANR定义

在Android上，如果你的应用程序有一段时间响应不够灵敏，系统会向用户显示一个对话框，这个对话框称作应用程序无响应（ANR：Application Not 
Responding）对话框。用户可以选择让程序继续运行，但是，他们在使用你的应用程序时，并不希望每次都要处理这个对话框。因此，在程序里对响应性能的设
计很重要，这样，系统不会显示ANR给用户。

如何来避免：

考虑上面的ANR定义，让我们来研究一下为什么它会在Android应用程序里发生和
如何最佳构建应用程序来避免ANR。

Android应用程序通常是运行在一个单独的线程（例如，main）里。这意味着你
的应用程序所做的事情如果在主线程里占用了太长的时间的话，就会引发ANR对
话框，因为你的应用程序并没有给自己机会来处理输入事件或者Intent广播。
因此，运行在主线程里的任何方法都尽可能少做事情。特别是，Activity应该在
它的关键生命周期方法（如onCreate()和onResume()）里尽可能少的去做创建操
作。潜在的耗时操作，例如网络或数据库操作，或者高耗时的计算如改变位图尺
寸，应该在子线程里（或者以数据库操作为例，通过异步请求的方式）来完成。
然而，不是说你的主线程阻塞在那里等待子线程的完成——也不是调用
Thread.wait()或是Thread.sleep()。替代的方法是，主线程应该为子线程提供
一个Handler，以便完成时能够提交给主线程。以这种方式设计你的应用程序，
将能保证你的主线程保持对输入的响应性并能避免由于5秒输入事件的超时引发
的ANR对话框。这种做法应该在其它显示UI的线程里效仿，因为它们都受相同的
超时影响。

IntentReceiver执行时间的特殊限制意味着它应该做：在后台里做小的、琐碎的
工作如保存设定或者注册一个Notification。和在主线程里调用的其它方法一样
，应用程序应该避免在BroadcastReceiver里做耗时的操作或计算。但不再是在
子线程里做这些任务（因为BroadcastReceiver的生命周期短），替代的是，如
果响应Intent广播需要执行一个耗时的动作的话，应用程序应该启动一个
Service。顺便提及一句，你也应该避免在Intent Receiver里启动一个Activity
，因为它会创建一个新的画面，并从当前用户正在运行的程序上抢夺焦点。如果
你的应用程序在响应Intent广播时需要向用户展示什么，你应该使用
Notification Manager来实现。

一般来说，在应用程序里，100到200ms是用户能感知阻滞的时间阈值。因此，这
里有一些额外的技巧来避免ANR，并有助于让你的应用程序看起来有响应性。
如果你的应用程序为响应用户输入正在后台工作的话，可以显示工作的进度
（ProgressBar和ProgressDialog对这种情况来说很有用）。
特别是游戏，在子线程里做移动的计算。
如果你的应用程序有一个耗时的初始化过程的话，考虑可以显示一个Splash Screen或者快速显示主画面并异步来填充这些信息。在这两种情况下，你都应该
显示正在进行的进度，以免用户认为应用程序被冻结了。

##简要解释一下activity、 intent 、intent filter、service、Broadcast、BroadcastReceiver
####Activity
Android中，Activity是所有程序的根本，所有程序的流程都运行在Activity之中，Activity具有自己的生命周期(由系统控制生命周期，程序无法改变，但可以用onSaveInstanceState保存其状态）。

对于Activity，关键是其生命周期的把握，其次就是状态的保存和恢复（onSaveInstanceState onRestoreInstanceState），以及Activity之间的跳转和数据传输（intent）。

Activity中常用的函数有SetContentView()   findViewById()    finish()   startActivity()，其生命周期涉及的函数有：

    void onCreate(Bundle savedInstanceState)
    void onStart()
    void onRestart()
    void onResume()
    void onPause()
    void onStop()
    void onDestroy()
Activity的使用需要在Manifest文件中添加相应的<Activity>，并设置其属性和intent-filter。

####Intent
Android中提供了Intent机制来协助应用间的交互与通讯，Intent负责对应用中一次操作的动作、动作涉及数据、附加数据进行描述，Android则根据此Intent的描述，负责找到对应的组件，将 Intent传递给调用的组件，并完成组件的调
用。Intent不仅可用于应用程序之间，也可用于应用程序内部的Activity/Service之间的交互。因此，Intent在这里起着一个媒体中介的作用，专门提供组件互相调用的相关信息，实现调用者与被调用者之间的解耦。在SDK
中给出了Intent作用的表现形式为：

- 通过Context.startActivity() orActivity.startActivityForResult() 启动一个Activity； 
- 通过 Context.startService() 启动一个服务，或者通过 Context.bindService() 和后台服务交互； 
- 通过广播方法(比如 Context.sendBroadcast(),Context.sendOrderedBroadcast(),  Context.sendStickyBroadcast()) 发给broadcast receivers。

Intent属性的设置，包括以下几点：（以下为XML中定义，当然也可以通过Intent类的方法来获取和设置）

- Action，也就是要执行的动作SDk中定义了一些标准的动作;也可以自定义动作（自定义的动作在使用时，需要加上包名作为前缀，如"com.example.project.SHOW_COLOR”），并可定义相应的Activity来处理我们的自定义动作。
- Data，也就是执行动作要操作的数据.Android中采用指向数据的一个URI来表示，如在联系人应用中，一个指向某联系人的URI可能为：content://contacts/1。对于不同的动作，其URI数据的类型是
       不同的（可以设置type属性指定特定类型数据），如ACTION_EDIT指定Data为文件URI，打电话为tel:URI，访问网络为http:URI，而由content provider提供的数据则为content: URIs。
- type（数据类型），显式指定Intent的数据类型（MIME）。一般Intent的数据类型能够根据数据本身进行判定，但是通过设置这个属性，可以强制采用显式指定的类型而不再进行推导。
- category（类别），被执行动作的附加信息。例如 LAUNCHER_CATEGORY 表示Intent 的接受者应该在Launcher中作为顶级应用出现；而ALTERNATIVE_CATEGORY表示当前的Intent是一系列的可选动作中的一个，这些动作可以在同一块数据上执行。
- component（组件），指定Intent的的目标组件的类名称。通常 Android会根据Intent 中包含的其它属性的信息，比如action、data/type、category进行查找，最终找到一个与之匹配的目标组件。但是，如果 component这个属性有指
   定的话，将直接使用它指定的组件，而不再执行上述查找过程。指定了这个属性以后，Intent的其它所有属性都是可选的。
- extras（附加信息），是其它所有附加信息的集合。使用extras可以为组件提供扩展信息，比如，如果要执行“发送电子邮件”这个动作，可以将电子邮件的标题、正文等保存在extras里，传给电子邮件发送组件。

理解Intent的关键之一是理解清楚Intent的两种基本用法：一种是显式的Intent，即在构造Intent对象时就指定接收者；另一种是隐式的Intent，即Intent的发送者在构造Intent对象时，并不知道也不关心接收者是谁，有利于降低发送者和
接收者之间的耦合。

对于显式Intent，Android不需要去做解析，因为目标组件已经很明确，Android需要解析的是那些隐式Intent，通过解析，将 Intent映射给可以处理此Intent的Activity、IntentReceiver或Service。        

Intent解析机制主要是通过查找已注册在AndroidManifest.xml中的所有IntentFilter及其中定义的Intent，最终找到匹配的Intent。在这个解析过程中，Android是通过Intent的action、type、category这三个属性来进行判断的，
判断方法如下：

- 如果Intent指明定了action，则目标组件的IntentFilter的action列表中就必须包含有这个action，否则不能匹配； 
- 如果Intent没有提供type，系统将从data中得到数据类型。和action一样，目标组件的数据类型列表中必须包含Intent的数据类型，否则不能匹配。 
- 如果Intent中的数据不是content: 类型的URI，而且Intent也没有明确指定它的type，将根据Intent中数据的scheme （比如 http: 或者mailto:） 进行匹配。同上，Intent 的scheme必须出现在目标组件的scheme列表中。 
- 如果Intent指定了一个或多个category，这些类别必须全部出现在组建的类别列表中。比如Intent中包含了两个类别：LAUNCHER_CATEGORY 和 ALTERNATIVE_CATEGORY，解析得到的目标组件必须至少包含这两个类别。



####Intent Filter
IntentFilter类表示Intent过滤器, 大部分情况下, 每一个component都会定义一个或多个IntentFilter, 用于表明其可处理的Intent. 
####Service
service是没有界面的长生命周期的代码。一个很好的例子是媒体播放器从列表 中播放歌曲。在一个媒体播放器程序中，大概要有一个或多个活动（activity） 来供用户选择歌曲并播放它。然而，音乐的回放就不能使用活动（activity）了 
，因为用户希望他导航到其他界面时音乐继续播放。这种情况下，媒体播放器活动（activity）要用Context.startService()启动一个服务来在后台运行保持音 乐的播放。系统将保持这个音乐回放服务的运行直到它结束。注意一下，你要用 
Context.bindService()方法连接服务（如果它没有运行，要先启动它）。当连 接到服务后，你可以通过服务暴露的一个接口和它通信。对于音乐服务，它允许你暂停、倒带，等等。

####Broadcast/BroadcastReceiver
 在Android中，Broadcast是一种广泛运用的在应用程序之间传输信息的机制。而BroadcastReceiver是对发送出来的 Broadcast进行过滤接受并响应的一类组件。下面将详细的阐述如何发送Broadcast和使用BroadcastReceiver过 
滤接收的过程： 

首先在需要发送信息的地方，把要发送的信息和用于过滤的信息(如Action、Category)装入一个Intent对象，然后通过调用 Context.sendBroadcast()、sendOrderBroadcast()或sendStickyBroadcast()方法，把 Intent对象以广播方
式发送出去。 
    
当Intent发送以后，所有已经注册的BroadcastReceiver会检查注册时的IntentFilter是否与发送的Intent相匹配，若 匹配则就会调用BroadcastReceiver的onReceive()方法。所以当我们定义一个
BroadcastReceiver的时候，都需要 实现onReceive()方法。

注册BroadcastReceiver有两种方式: 

一种方式是，静态的在AndroidManifest.xml中用<receiver>标签生命注册，并在标签内用<intent- filter>标签设置过滤器。 
    
另一种方式是，动态的在代码中先定义并设置好一个 IntentFilter对象，然后在需要注册的地方调 Context.registerReceiver()方法，如果取消时就调用Context.unregisterReceiver()方法。

不管是用xml注册的还是用代码注册的,在程序退出的时候没有特殊需要都得注销,否则下次启动程序可能会有多个 BroadcastReceiver

另外，若在使用sendBroadcast()的方法是指定了接收权限，则只有在AndroidManifest.xml中用<uses- permission>标签声明了拥有此权限的BroascastReceiver才会有可能接收到发送来的Broadcast。 
    
同样，若在注册BroadcastReceiver时指定了可接收的Broadcast的权限，则只有在包内的AndroidManifest.xml中 用<uses-permission>标签声明了，拥有此权限的Context对象所发送的Broadcast才能被这个 BroadcastReceiver所接收。 

动态注册：

    IntentFilter intentFilter = new IntentFilter(); 
    intentFilter.addAction(String);--为 BroadcastReceiver指定action，
    使之用于接收同action的广播 registerReceiver(BroadcastReceiver,intentFilter); 
    一般：在onStart中注册，onStop中取消unregisterReceiver 
    发送广播消息：extends Service 
    指定广播目标Action：Intent Intent = new Intent(action-String) 
    --指定了此action的receiver会接收此广播 
    需传递参数(可选) putExtra(); 
    发送：sendBroadcast(Intent);
    
##如果后台的Activity由于某原因被系统回收了，如何在被系统回收之前保存当前状态
重写onDestroy方法，在方法中保存

##如何将一个Activity设置成窗口的样式
可以直接添加您对应需要展示为Dialog style的Activity的android:theme属性,值为android:theme="@android:style/Theme.Dialog"。
##如何退出Activity？如何安全退出已调用多个Activity的Application
1. 抛异常强制退出：
    该方法通过抛异常，使程序Force Close。验证可以，但是，需要解决的问题是，如何使程序结束掉，而不弹出Force Close的窗口。
2. 记录打开的Activity：
    每打开一个Activity，就记录下来。在需要退出时，关闭每一个Activity即可。
3. 发送特定广播：
    在需要结束应用时，发送一个特定的广播，每个Activity收到广播后，关闭即可。
4. 递归退出
    在打开新的Activity时使用startActivityForResult，然后自己加标志，在onActivityResult中处理，递归关闭。

##







