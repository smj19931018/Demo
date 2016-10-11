package com.mycroft.skipdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.mycroft.skipdemo.R;
import com.mycroft.skipdemo.TranforUitls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    private ListView mListView;

    private List<Map<String, String>> mMaps;
    private SimpleAdapter mAdapter;
    private int[] color=new int[]{545646,884654,156165,918564};
    private FrameLayout mFrameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TranforUitls.getInstance().initUitls(this,Main2Activity.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mMaps = new ArrayList<>();

        mListView = (ListView) findViewById(R.id.mListView);
        for (int i = 0; i < 20; i++) {
            Map map = new HashMap();
            map.put("content", "content" + i);
            mMaps.add(map);
        }
        mAdapter = new SimpleAdapter(this, mMaps, R.layout.item, new String[]{"content"}, new int[]{R.id.item_TextView});
        mListView.setAdapter(mAdapter);
        mFrameLayout= (FrameLayout) findViewById(R.id.activity_main2);
        TranforUitls.getInstance().openChangeAnimator();
    }

    @Override
    protected void onDestroy() {
        TranforUitls.getInstance().unRiger(Main2Activity.class);
        super.onDestroy();
    }

    public void changeBackGroundColor2(View view) {
        TranforUitls.getInstance().changeBackGroundColor("#"+color[new Random().nextInt(4)],"#"+color[new Random().nextInt(4)],"#"+color[new Random().nextInt(4)],mFrameLayout);
    }
}
