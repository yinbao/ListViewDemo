package com.yinbao.www.listviewstyle.ListView.group;


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

public class TextGroupRecyclerView extends BaseActivity {

    private RecyclerView mRecyclerView;
    private List<TypeDataBean> mData;
    private TextGroupRecyclerAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_recycler_view;
    }

    @Override
    protected void initListener() {
        mAdapter.setOnItemClickListener(new TextGroupRecyclerAdapter.OnItemListener() {
            @Override
            public void onItemClick(View view, int position) {
                TypeDataBean data=mData.get(position);
                if (data!=null&&data.getGroupId()==2){
                    GroupDataBean dataBean=data.getData();
                    MyToast.makeText(mContext,"当前点击的内容："+dataBean.getGroupName()+"-->"+dataBean.getData(), Toast.LENGTH_SHORT);
                }
            }
        });
    }

    @Override
    protected void initData() {
        mData=new ArrayList<>();
        mData.add(new TypeDataBean(1,new GroupDataBean("A组","A组")));
        mData.add(new TypeDataBean(2,new GroupDataBean("A组","text1")));
        mData.add(new TypeDataBean(2,new GroupDataBean("A组","text2")));
        mData.add(new TypeDataBean(2,new GroupDataBean("A组","text3")));
        mData.add(new TypeDataBean(2,new GroupDataBean("A组","text4")));
        mData.add(new TypeDataBean(2,new GroupDataBean("A组","text5")));
        mData.add(new TypeDataBean(1,new GroupDataBean("B组","B组")));
        mData.add(new TypeDataBean(2,new GroupDataBean("B组","text1")));
        mData.add(new TypeDataBean(2,new GroupDataBean("B组","text2")));
        mData.add(new TypeDataBean(2,new GroupDataBean("B组","text3")));
        mData.add(new TypeDataBean(2,new GroupDataBean("B组","text4")));
        mData.add(new TypeDataBean(2,new GroupDataBean("B组","text5")));
        mAdapter=new TextGroupRecyclerAdapter(mData,this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//ListView；列表的样式
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initView() {
        mRecyclerView= (RecyclerView) findViewById(R.id.id_rv_list_view);

    }
}
