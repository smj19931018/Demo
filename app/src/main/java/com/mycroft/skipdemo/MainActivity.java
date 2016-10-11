package com.mycroft.skipdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.mycroft.skipdemo.activity.Main2Activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ListView mListView2;
    private List<Map<String,String>> mMaps;
    private SimpleAdapter mAdapter;
    private float[] textSize=new float[]{10.0f,20.0f,30.0f};
    private int[] color=new int[]{545646,884654,156165,918564};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TranforUitls.getInstance().initUitls(this,MainActivity.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        mMaps=new ArrayList<>();
        mListView2= (ListView) findViewById(R.id.mListView2);
        for (int i=0;i<20;i++){
            Map map=new HashMap();
            map.put("content","content"+i);
            mMaps.add(map);
        }
        mAdapter=new SimpleAdapter(this,mMaps,R.layout.item,new String[]{"content"},new int[]{R.id.item_TextView});
        mListView2.setAdapter(mAdapter);

    }

    public void skip(View view) {
        startActivity(new Intent(this, Main2Activity.class));
    }

    public void tranfor(View view) {
        TranforUitls.getInstance().changeSize(textSize[new Random().nextInt(3)],textSize[new Random().nextInt(3)],textSize[new Random().nextInt(3)]);
    }

    public void changeBackGroundColor(View view) {
        TranforUitls.getInstance().changeBackGroundColor("#"+color[new Random().nextInt(4)],"#"+color[new Random().nextInt(4)],"#"+color[new Random().nextInt(4)],null);
    }

    public void changefrintColor(View view) {
        TranforUitls.getInstance().changefrontColor("#"+color[new Random().nextInt(4)],"#"+color[new Random().nextInt(4)],"#"+color[new Random().nextInt(4)]);
    }

    @Override
    protected void onDestroy() {
        TranforUitls.getInstance().unRiger(MainActivity.class);
        super.onDestroy();
    }
}
