package com.yinbao.www.listviewstyle.ListView.select;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.yinbao.www.listviewstyle.R;
import com.yinbao.www.listviewstyle.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建时间:2018/8/4
 * 编写人:Administrator
 * 包名路径:com.yinbao.www.listviewstyle.ListView.select
 * 功能描述:
 * <p>
 * 1,选择列表
 */

public class SelectListView extends BaseActivity {

    private List<SelectDataBean> mList;
    private ListView mListView;
    private SelectAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_listview;
    }

    @Override
    protected void initListener() {
        MyItemListener listener=new MyItemListener();
        mListView.setOnItemClickListener(listener);

    }


    private class MyItemListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            SelectDataBean mSelectDataBean = mList.get(position);
            int a=mSelectDataBean.getStatus();
            if (a==1)
                a--;
            else
                a++;
            mSelectDataBean.setStatus(a);
            mAdapter.notifyDataSetChanged();//刷新列表

        }
    }


    @Override
    protected void initData() {
        if (mList == null)
            mList = new ArrayList<>();
        if (mList.size() > 0)
            mList.clear();
        mList.add(new SelectDataBean("text1", 0));
        mList.add(new SelectDataBean("text2", 0));
        mList.add(new SelectDataBean("text3", 0));
        mList.add(new SelectDataBean("text4", 0));
        mList.add(new SelectDataBean("text5", 0));
        mAdapter=new SelectAdapter(this,mList);
        mListView.setAdapter(mAdapter);
    }

    @Override
    protected void initView() {
        mListView = (ListView) findViewById(R.id.id_lv_list_view);

    }
}
