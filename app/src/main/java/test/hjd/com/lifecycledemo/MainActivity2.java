package test.hjd.com.lifecycledemo;

import android.arch.lifecycle.ProcessLifecycleOwner;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


/*
SupportActivity帮我们实现了Lifecycleregistry的创建,
和生命周期事件的分发
 */
public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        如果我们需要监听某一个组件的生命周期,
        我们就在需要监听的组件里面添加Observer
         */
        getLifecycle().addObserver(new MyLifecycleObserver());

//        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity2.this, FirstActivity.class);
//                startActivity(intent);
//            }
//        });

        ProcessLifecycleOwner.get().getLifecycle().addObserver(new AppLifecycleObserver());


    }
}
