package com.yinbao.www.listviewstyle.ListView.text;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.yinbao.www.listviewstyle.MyToast;
import com.yinbao.www.listviewstyle.R;
import com.yinbao.www.listviewstyle.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建时间:2018/7/28
 * 编写人:Administrator
 * 包名路径:com.yinbao.www.listviewstyle.ListView
 * 功能描述:
 * 1,演示最常用普通的文字列表
 */

public class TextListView extends BaseActivity {

    private ListView mListViewText;
    private List<String> mData;
    private TextAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_listview;
    }

    @Override
    protected void initListener() {
        MyListListener myListListener=new MyListListener();
        mListViewText.setOnItemClickListener(myListListener);
    }


    private class MyListListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String data=mData.get(position);
            if (data!=null)
                MyToast.makeText(mContext,"当前点击的内容："+data,Toast.LENGTH_SHORT);
        }
    }



    @Override
    protected void initData() {
        mData=new ArrayList<>();
        mData.add("text1");
        mData.add("text2");
        mData.add("text3");
        mData.add("text4");
        mData.add("text5");
        mData.add("text6");
        mAdapter=new TextAdapter(this,mData);
        mListViewText.setAdapter(mAdapter);
    }

    @Override
    protected void initView() {
        mListViewText= (ListView) findViewById(R.id.id_lv_list_view);

    }
}
