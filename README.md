* aspect-lib 模块内需配置 proguard-rules.pro 混淆相关，将 aspect-lib 内相关代码的包名添加进配置中，防止混淆
```
-dontwarn com.wangpeiyuan.aspect_lib.**
-keep class com.wangpeiyuan.aspect_lib.**{*;}
```

* 其它模块如果需要在编译时期使用 aspectj 代码织入功能，需要加入gradle脚本 ajc 配置
```
app		 : apply from : '../aspect_lib/aspectj-configure-app.gradle'
library	 : apply from : '../aspect_lib/aspectj-configure-lib.gradle'
```

* 编写 aspect 相关的模块不能打成 aar ,需要模块项目引用，否则编译打包后会找不到类java.lang.NoClassDefFoundError: Failed resolution of: xxx/xxx/具体类

* 引入的第三方 library aar 或者是 .class 文件是不能进行织入代码的。

* 根目录的 gradle 需要添加以下依赖否则会同步错误，无法找到 import org.aspectj.bridge.IMessage
```
dependencies {
        ...
        classpath 'org.aspectj:aspectjtools:1.9.3'
        classpath 'org.aspectj:aspectjweaver:1.9.3'
    }
```

* 此项目不支持 Kotlin。需要支持的话，可以使用第三方插件 https://github.com/HujiangTechnology/gradle_plugin_android_aspectjx