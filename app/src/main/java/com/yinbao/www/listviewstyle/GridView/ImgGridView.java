package com.yinbao.www.listviewstyle.GridView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.yinbao.www.listviewstyle.MyToast;
import com.yinbao.www.listviewstyle.R;
import com.yinbao.www.listviewstyle.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建时间:2018/8/8
 * 编写人:Administrator
 * 包名路径:com.yinbao.www.listviewstyle.ListView.img
 * 功能描述:
 */

public class ImgGridView extends BaseActivity {

    private GridView mGridView;
    private List<String> mData;
    private ImgAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_gridview;
    }

    @Override
    protected void initListener() {
        MyGVListener myListener=new MyGVListener();
        mGridView.setOnItemClickListener(myListener);
    }

    private class MyGVListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String data=mData.get(position);
            if (data!=null)
                MyToast.makeText(mContext,"当前点击的内容："+data, Toast.LENGTH_SHORT);
        }
    }



    @Override
    protected void initData() {
        mData=new ArrayList<>();
        mData.add("Name1");
        mData.add("Name2");
        mData.add("Name3");
        mData.add("Name4");
        mData.add("Name5");
        mAdapter=new ImgAdapter(this,mData);
        mGridView.setAdapter(mAdapter);
    }

    @Override
    protected void initView() {
        mGridView= (GridView) findViewById(R.id.id_lv_grid_view);
    }
}
