package com.yinbao.www.listviewstyle.ListView.text;


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
 * 1,演示最常用普通的文字列表(Rv控件)
 */

public class TextRecyclerView extends BaseActivity {

    private RecyclerView mRecyclerView;
    private List<String> mData;
    private TextRecyclerAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_recycler_view;
    }

    @Override
    protected void initListener() {
        mAdapter.setOnItemClickListener(new TextRecyclerAdapter.OnItemListener() {
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
        mData.add("text1");
        mData.add("text2");
        mData.add("text3");
        mData.add("text4");
        mData.add("text5");
        mData.add("text6");
        mAdapter=new TextRecyclerAdapter(mData,this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//ListView；列表的样式
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initView() {
        mRecyclerView= (RecyclerView) findViewById(R.id.id_rv_list_view);

    }
}
