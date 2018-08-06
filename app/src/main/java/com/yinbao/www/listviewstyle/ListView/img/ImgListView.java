package com.yinbao.www.listviewstyle.ListView.img;

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
 * 1,演示最常用普通的图片文字列表
 */

public class ImgListView extends BaseActivity {

    private ListView mListViewImg;
    private List<String> mData;
    private ImgAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_listview;
    }

    @Override
    protected void initListener() {
        MyListListener myListListener=new MyListListener();
        mListViewImg.setOnItemClickListener(myListListener);
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
        mData.add("img1");
        mData.add("img2");
        mData.add("img3");
        mData.add("img4");
        mData.add("img5");
        mData.add("img6");
        mAdapter=new ImgAdapter(this,mData);
        mListViewImg.setAdapter(mAdapter);
    }

    @Override
    protected void initView() {
        mListViewImg= (ListView) findViewById(R.id.id_lv_list_view);

    }
}
