package com.yinbao.www.listviewstyle.ListView.twoList;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.yinbao.www.listviewstyle.MyToast;
import com.yinbao.www.listviewstyle.R;
import com.yinbao.www.listviewstyle.base.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建时间:2018/7/28
 * 编写人:Administrator
 * 包名路径:com.yinbao.www.listviewstyle.ListView
 * 功能描述:
 * 1,演示最常用普通的图片文字列表
 */

public class TwoListView extends BaseActivity {

    private ExpandableListView mExpListView;
    private List<String> mData;
    private List<String> mList1,mList2,mList3;//子分组数据
    private Map<String , List<String>> mListMap;
    private TwoListAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_two_listview;
    }

    @Override
    protected void initListener() {
        mExpListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition,
                                        long id) {
                if (mExpListView.isGroupExpanded(groupPosition))//当前子分组是否显示
                    mExpListView.collapseGroup(groupPosition);//不显示子分组
                else
                    mExpListView.expandGroup(groupPosition);//显示子分组
                return true;
            }
        });


        mExpListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int
                childPosition, long id) {
                String data= (String) mAdapter.getChild(groupPosition,childPosition);
                if (data!=null)
                    MyToast.makeText(mContext,"当前点击的内容："+data, Toast.LENGTH_SHORT);
                return true;
            }
        });





    }






    @Override
    protected void initData() {
        mListMap=new HashMap<>();
        mList1=new ArrayList<>();
        mList2=new ArrayList<>();
        mList3=new ArrayList<>();
        mData=new ArrayList<>();
        //----------分组--------------
        mData.add("List1");
        mData.add("List2");
        mData.add("List3");
        //----------分组1子分组数据--------------
        if (mList1.size()>0)
            mList1.clear();
        mList1.add("List1->Text1");
        mList1.add("List1->Text2");
        mList1.add("List1->Text3");
        mListMap.put(mData.get(0),mList1);//添加

        //----------分组2子分组数据--------------
        if (mList2.size()>0)
            mList2.clear();
        mList2.add("List2->Text1");
        mList2.add("List2->Text2");
        mList2.add("List2->Text3");
        mListMap.put(mData.get(1),mList2);//添加

        //----------分组3子分组数据--------------
        if (mList3.size()>0)
            mList3.clear();
        mList3.add("List3->Text1");
        mList3.add("List3->Text2");
        mList3.add("List3->Text3");
        mListMap.put(mData.get(2),mList3);//添加



        mAdapter=new TwoListAdapter(this,mData,mListMap);
        mExpListView.setAdapter(mAdapter);
    }

    @Override
    protected void initView() {
        mExpListView= (ExpandableListView) findViewById(R.id.id_elv_list_view);

    }
}
