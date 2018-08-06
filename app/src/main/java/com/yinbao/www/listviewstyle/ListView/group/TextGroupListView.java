package com.yinbao.www.listviewstyle.ListView.group;

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

public class TextGroupListView extends BaseActivity {

    private ListView mListViewText;
    private List<TypeDataBean> mData;
    private TextGroupAdapter mAdapter;

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
            TypeDataBean data=mData.get(position);
            //不是分组标题才允许点击
            if (data!=null&&data.getGroupId()==2){
                GroupDataBean mGroupDataBean=data.getData();
                MyToast.makeText(mContext,"当前点击的内容："+mGroupDataBean.getGroupName()+"-->"+mGroupDataBean.getData(),Toast.LENGTH_SHORT);
            }
        }
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

        mAdapter=new TextGroupAdapter(this,mData);
        mListViewText.setAdapter(mAdapter);
    }

    @Override
    protected void initView() {
        mListViewText= (ListView) findViewById(R.id.id_lv_list_view);

    }
}
