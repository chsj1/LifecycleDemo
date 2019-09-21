package test.hjd.com.lifecycledemo;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.ProcessLifecycleOwner;
import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * Created by allen on 2019-09-07.
 *
 * 直接继承Activity.
 *
 * 这时候如果需要监听生命周期的变化,需要自己进行相关的实现
 *
 *
 * 如果我们直接继承Activity.那么这时候就需要我们实现LifecycleOwner接口,
 * 并在Activity的生命周期函数中分发事件
 */
public class FirstActivity extends Activity implements LifecycleOwner {

    private LifecycleRegistry lifecycleRegistry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        lifecycleRegistry = new LifecycleRegistry(this);

        //发送消息
//        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);

        //添加了监听
        getLifecycle().addObserver(new MyLifecycleObserver1());

//        ProcessLifecycleOwner.get().getLifecycle().addObserver(new AppLifecycleObserver());

    }


    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return lifecycleRegistry;
    }


    @Override
    protected void onStart() {
        super.onStart();

//        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);

    }

    @Override
    protected void onResume() {
        super.onResume();

//        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);

    }

    @Override
    protected void onPause() {
        super.onPause();

//        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);

    }

    @Override
    protected void onStop() {
        super.onStop();

//        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

//        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);

    }
}
