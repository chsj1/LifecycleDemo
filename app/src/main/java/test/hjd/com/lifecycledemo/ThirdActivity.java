package test.hjd.com.lifecycledemo;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * Created by allen on 2019-09-08.
 */

/*
如果直接继承Activity,那么这时候我们需要实现LifecycleOwner接口,
并提供LifecycleRegistry的成员变量.
 */
public class ThirdActivity extends Activity implements LifecycleOwner {

    private LifecycleRegistry lifecycleRegistry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lifecycleRegistry = new LifecycleRegistry(this);

        //这时候ReportFragment的注入是通过LifecyclePispatcher来实现的

        //监听声明周期的时间
        getLifecycle().addObserver(new MyLifecycleObserver3());

        
    }


    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return lifecycleRegistry;
    }
}
