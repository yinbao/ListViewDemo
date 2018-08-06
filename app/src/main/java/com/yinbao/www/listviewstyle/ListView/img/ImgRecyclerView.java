package com.yinbao.www.listviewstyle.ListView.img;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.yinbao.www.listviewstyle.MyToast;
import com.yinbao.www.listviewstyle.R;
import com.yinbao.www.listviewstyle.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建时间:2018/7/30
 * 编写人:Administrator
 * 包名路径:com.yinbao.www.listviewstyle.ListView.text
 * 功能描述:
 * 1,演示最常用普通的图片文字列表(Rv控件)
 */

public class ImgRecyclerView extends BaseActivity {

    private RecyclerView mRecyclerView;
    private List<String> mData;
    private ImgRecyclerAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_recycler_view;
    }

    @Override
    protected void initListener() {
        mAdapter.setOnItemClickListener(new ImgRecyclerAdapter.OnItemListener() {
            @Override
            public void onItemClick(View view, int position) {
                String data=mData.get(position);
                if (data!=null)
                    MyToast.makeText(mContext,"当前点击的内容："+data, Toast.LENGTH_SHORT);
            }
        });
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
        mAdapter=new ImgRecyclerAdapter(mData,this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//ListView；列表的样式
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initView() {
        mRecyclerView= (RecyclerView) findViewById(R.id.id_rv_list_view);

    }
}
