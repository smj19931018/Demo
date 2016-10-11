package com.mycroft.skipdemo;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mycroft on 2016/10/10.
 */

public class TranforUitls {
    private static TranforUitls instance;
    private static float textSize1=-1;
    private static float textSize2=-1;
    private static float textSize3=-1;

    private Map<Class,List<View>> changesizeViews1;
    private Map<Class,List<View>> changesizeViews2;
    private Map<Class,List<View>> changesizeViews3;
    private Map<Class,List<View>> changefrontColorViews1;
    private Map<Class,List<View>> changefrontColorViews2;
    private Map<Class,List<View>> changefrontColorViews3;
    private Map<Class,List<View>> changeBackGroundColorViews1;
    private Map<Class,List<View>> changeBackGroundColorViews2;
    private Map<Class,List<View>> changeBackGroundColorViews3;
    private String backGroundColor1;
    private String backGroundColor2;
    private String backGroundColor3;
    private String frontColor1;
    private String frontColor2;
    private String frontColor3;
    private boolean needAnimator;
    public static TranforUitls getInstance(){
     if (instance==null){
         synchronized (TranforUitls.class){
            if (instance==null){
                instance=new TranforUitls();
            }
         }
     }
        return instance;
    }
    private TranforUitls(){
        changesizeViews1=new HashMap<>();
        changesizeViews2=new HashMap<>();
        changesizeViews3=new HashMap<>();
        changefrontColorViews1=new HashMap<>();
        changefrontColorViews2=new HashMap<>();
        changefrontColorViews3=new HashMap<>();
        changeBackGroundColorViews1=new HashMap<>();
        changeBackGroundColorViews2=new HashMap<>();
        changeBackGroundColorViews3=new HashMap<>();

    };

    public void initUitls(final Activity activity, final Class mclass) {
        final List<View> changesizeView1=new ArrayList<>();
        final List<View> changesizeView2=new ArrayList<>();
        final List<View> changesizeView3=new ArrayList<>();
        final List<View> changefrontColorView1=new ArrayList<>();
        final List<View> changefrontColorView2=new ArrayList<>();
        final List<View> changefrontColorView3=new ArrayList<>();
        final List<View> changeBackGroundColorView1=new ArrayList<>();
        final List<View> changeBackGroundColorView2=new ArrayList<>();
        final List<View> changeBackGroundColorView3=new ArrayList<>();
        LayoutInflaterCompat.setFactory(LayoutInflater.from(activity), new LayoutInflaterFactory() {
            @Override
            public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
                View view = null;
                try {
                if(name.indexOf('.') == -1){
                    if ("View".equals(name)) {

                        view = LayoutInflater.from(context).createView(name, "android.view.", attrs);

                    }
                    if (view == null) {
                        view = LayoutInflater.from(context).createView(name, "android.widget.", attrs);
                    }
                    if (view == null) {
                        view = LayoutInflater.from(context).createView(name, "android.webkit.", attrs);
                    }

                }else{
                    if (view == null&&!name.contains("android.support.v")){
                        view = LayoutInflater.from(context).createView(name, null, attrs);

                    }
                }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                /*AppCompatDelegate delegate = ((AppCompatActivity)activity).getDelegate();
                View view = delegate.createView(parent, name, context, attrs);*/
                /*Log.e("aaa",name);*/
                for (int i=0;i<attrs.getAttributeCount();i++){
                    String name1=attrs.getAttributeName(i);
                    String value=attrs.getAttributeValue(i);
                    String tag1=value.charAt(0)+"";
                    if (name1.equals("tag")&&(tag1).equals("c")){
                    parseTag(view,value,changesizeView1,changesizeView2,changesizeView3,changefrontColorView1,changefrontColorView2,changefrontColorView3,changeBackGroundColorView1,changeBackGroundColorView2,changeBackGroundColorView3);
                    }
                }

                changesizeViews1.put(mclass,changesizeView1);
                changesizeViews2.put(mclass,changesizeView2);
                changesizeViews3.put(mclass,changesizeView3);
                changefrontColorViews1.put(mclass,changefrontColorView1);
                changefrontColorViews2.put(mclass,changefrontColorView2);
                changefrontColorViews3.put(mclass,changefrontColorView3);
                changeBackGroundColorViews1.put(mclass,changeBackGroundColorView1);
                changeBackGroundColorViews2.put(mclass,changeBackGroundColorView2);
                changeBackGroundColorViews3.put(mclass,changeBackGroundColorView3);

                return view;
            }
        });

    }

    private void parseTag(View view, String value,List<View> changesizeView1,List<View> changesizeView2,final List<View> changesizeView3,final List<View> changefrontColorView1,final List<View> changefrontColorView2,final List<View> changefrontColorView3,final List<View> changeBackGroundColorView1, final List<View> changeBackGroundColorView2,final List<View> changeBackGroundColorView3) {
        String tag2=value.charAt(1)+"";
        String tag3=value.charAt(2)+"";
        String tag4=value.charAt(3)+"";



            switch (Integer.parseInt(tag2)){
                case 1:
                    changeBackGroundColorView1.add(view);
                    if (backGroundColor1!=null){
                        view.setBackgroundColor(Color.parseColor(backGroundColor1));
                    }
                    break;
                case 2:
                    changeBackGroundColorView2.add(view);
                    if (backGroundColor2!=null){
                        view.setBackgroundColor(Color.parseColor(backGroundColor2));
                    }
                    break;
                case 3:
                    changeBackGroundColorView3.add(view);
                    if (backGroundColor3!=null){
                        view.setBackgroundColor(Color.parseColor(backGroundColor3));
                    }
                    break;
            }
            if (view instanceof TextView){
                switch (Integer.parseInt(tag3)){
                    case 1:
                        changefrontColorView1.add(view);
                        if (frontColor1!=null){
                            ((TextView)view).setTextColor(Color.parseColor(frontColor1));
                        }
                        break;
                    case 2:
                        changefrontColorView2.add(view);
                        if (frontColor2!=null){
                            ((TextView)view).setTextColor(Color.parseColor(frontColor2));
                        }
                        break;
                    case 3:
                        changefrontColorView3.add(view);
                        if (frontColor3!=null){
                            ((TextView)view).setTextColor(Color.parseColor(frontColor3));
                        }
                        break;
                }
                switch (Integer.parseInt(tag4)){
                    case 1:
                        changesizeView1.add(view);
                        if (textSize1!=-1){
                            ((TextView)view).setTextSize(textSize1);
                        }
                        break;
                    case 2:
                        changesizeView2.add(view);
                        if (textSize2!=-1){
                            ((TextView)view).setTextSize(textSize2);
                        }
                        break;
                    case 3:
                        changesizeView3.add(view);
                        if (textSize3!=-1){
                            ((TextView)view).setTextSize(textSize3);
                        }
                        break;
                }
            }


        }


    public void openChangeAnimator(){
        needAnimator=true;

    }



    public void changeSize(float size1,float size2,float size3){
        if (size1>0){
            textSize1=size1;
        }
        if (size2>0){
            textSize2=size2;
        }
        if (size3>0){
            textSize3=size3;
        }
        listChangeSize(size1,changesizeViews1);
        listChangeSize(size2,changesizeViews2);
        listChangeSize(size3,changesizeViews3);

    }

    private void listChangeSize(float size,Map<Class,List<View>> changesizeViews) {
        for (Map.Entry<Class,List<View>> entry:changesizeViews.entrySet()){
            List<View> tempList=entry.getValue();
            for (int i=0;i<tempList.size();i++){
                View view=tempList.get(i);
                ((TextView)view).setTextSize(size);
            }

        }

    }

    public void changeBackGroundColor(String backGroundColor1,String backGroundColor2,String backGroundColor3,final View animatorView){
        if (backGroundColor1!=null){
            this.backGroundColor1=backGroundColor1;
        }
        if (backGroundColor2!=null){
            this.backGroundColor2=backGroundColor2;
        }
        if (backGroundColor3!=null){
            this.backGroundColor3=backGroundColor3;
        }
        listchangeBackGroundColor(backGroundColor1,changeBackGroundColorViews1);
        listchangeBackGroundColor(backGroundColor2,changeBackGroundColorViews2);
        listchangeBackGroundColor(backGroundColor3,changeBackGroundColorViews3);

        if (needAnimator==true&&animatorView!=null&&Build.VERSION.SDK_INT>Build.VERSION_CODES.LOLLIPOP){

            animatorView.post(new Runnable() {
                @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void run() {
                    Animator mAnimator= ViewAnimationUtils.createCircularReveal(animatorView,animatorView.getWidth()/2,animatorView.getHeight()/2,0,animatorView.getHeight());
                    mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                    mAnimator.setDuration(2000);
                    mAnimator.start();
                }
            });

        }
    }

    private void listchangeBackGroundColor(String backGroundColor, Map<Class, List<View>> changeBackGroundColorViews) {
        for (Map.Entry<Class,List<View>> entry:changeBackGroundColorViews.entrySet()) {
            List<View> tempList = entry.getValue();
            for (int i = 0; i < tempList.size(); i++) {
                View view = tempList.get(i);
                if (view != null) {
                    view.setBackgroundColor(Color.parseColor(backGroundColor.trim()));
                }

            }
        }
    }

    public void changefrontColor(String frontColor1,String frontColor2,String frontColor3){
        if (frontColor1!=null){
            this.frontColor1=frontColor1;
        }
        if (frontColor2!=null){
            this.frontColor2=frontColor2;
        }
        if (frontColor3!=null){
            this.frontColor3=frontColor3;
        }
        listchangefrontColor(frontColor1,changefrontColorViews1);
        listchangefrontColor(frontColor2,changefrontColorViews2);
        listchangefrontColor(frontColor3,changefrontColorViews3);

    }

    private void listchangefrontColor(String frontColor, Map<Class, List<View>> changefrontColorViews) {
        for (Map.Entry<Class,List<View>> entry:changefrontColorViews.entrySet()) {
            List<View> tempList = entry.getValue();
            for (int i = 0; i < tempList.size(); i++) {
                View view = tempList.get(i);
                if (view != null) {
                    ((TextView)view).setTextColor(Color.parseColor(frontColor.trim()));
                }

            }
        }
    }

    public void unRiger(Class mClass){
        changesizeViews1.remove(mClass);
        changesizeViews2.remove(mClass);
        changesizeViews3.remove(mClass);
        changefrontColorViews1.remove(mClass);
        changefrontColorViews2.remove(mClass);
        changefrontColorViews3.remove(mClass);
        changeBackGroundColorViews1.remove(mClass);
        changeBackGroundColorViews2.remove(mClass);
        changeBackGroundColorViews3.remove(mClass);
    }

}
