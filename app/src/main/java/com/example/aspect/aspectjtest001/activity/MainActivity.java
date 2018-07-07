package com.example.aspect.aspectjtest001.activity;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.aspect.aoplib.ClassTrace;
import com.example.aspect.aoplib.MethodTrace;
import com.example.aspect.aspectjtest001.R;
import com.example.aspect.aspectjtest001.fragment.Fragment1;
import com.example.aspect.aspectjtest001.fragment.Fragment2;
import com.example.aspect.aspectjtest001.view.BezierView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

@ClassTrace(001)
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "!!!!MainActivity";
    Unbinder unbinder;
    @BindView(R.id.container)
    FrameLayout container;

    BezierView bezierView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        bezierView = new BezierView(this);
        testAnnotationAspect();


        final Fragment1 fragment1 = new Fragment1();
        final Fragment2 fragment2 = new Fragment2();
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container,fragment1).addToBackStack("fragment1").commit();
            }
        });

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container,fragment2).addToBackStack("fragment2").commit();
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ViewPagerActivity.class));
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bezierView.getParent() == null) {
                    container.addView(bezierView);
                } else {
                    container.removeAllViews();
                }
            }
        });

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });

        setTestBoolean(true);
    }

    @MethodTrace
    public void testAnnotationAspect() {
        Log.e(TAG, "testAnnotationAspect: =====================");
    }

    public void setTestBoolean(boolean testBoolean) {

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
