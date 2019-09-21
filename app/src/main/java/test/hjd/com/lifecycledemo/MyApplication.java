package test.hjd.com.lifecycledemo;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.ProcessLifecycleOwner;
import android.os.Bundle;

/**
 * Created by allen on 2019-09-08.
 */
public class MyApplication extends Application {


    public static int forgroundNum = 0;

    @Override
    public void onCreate() {
        super.onCreate();


        //库的初始化方式——第一种方式
//        xxx.init(this);
        System.out.println("---------> xxx init");

        /*
        使用ProcessLifecycleOwner来监听应用前后台的切换.

        在Application的onCreate方法里面或者是入口Activity里面进行注册监听
         */
//        ProcessLifecycleOwner.get().getLifecycle().addObserver(new AppLifecycleObserver());


        /*
        使用application.registerActivityLifecycleCallbacks()来监听
        应用前后台切换
         */
//        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
//            @Override
//            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
//            }
//
//            @Override
//            public void onActivityStarted(Activity activity) {
//                if (forgroundNum == 0) {
//                    System.out.println("------->哈哈 应用切换到了前台");
//                }
//
//                forgroundNum++;
//            }
//
//            @Override
//            public void onActivityResumed(Activity activity) {
//
//            }
//
//            @Override
//            public void onActivityPaused(Activity activity) {
//
//            }
//
//            @Override
//            public void onActivityStopped(Activity activity) {
//                forgroundNum--;
//                if (forgroundNum == 0) {
//                    System.out.println("------------>应用切换到了后台");
//                }
//            }
//
//            @Override
//            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
//
//            }
//
//            @Override
//            public void onActivityDestroyed(Activity activity) {
//
//            }
//        });
    }
}
