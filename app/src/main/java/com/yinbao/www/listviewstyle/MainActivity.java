package com.yinbao.www.listviewstyle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.yinbao.www.listviewstyle.GridView.ImgGridView;
import com.yinbao.www.listviewstyle.ListView.group.TextGroupListView;
import com.yinbao.www.listviewstyle.ListView.group.TextGroupRecyclerView;
import com.yinbao.www.listviewstyle.ListView.img.ImgListView;
import com.yinbao.www.listviewstyle.ListView.img.ImgRecyclerView;
import com.yinbao.www.listviewstyle.ListView.select.SelectListView;
import com.yinbao.www.listviewstyle.ListView.text.TextAdapter;
import com.yinbao.www.listviewstyle.ListView.text.TextListView;
import com.yinbao.www.listviewstyle.ListView.text.TextRecyclerView;
import com.yinbao.www.listviewstyle.ListView.twoList.TwoListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private List<String> mData;
    private TextAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        MyListener myListener = new MyListener();
        mListView.setOnItemClickListener(myListener);

    }


    private class MyListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position) {
                case 0:
                    startActivity(new Intent(MainActivity.this, TextListView.class));
                    break;
                case 1:
                    startActivity(new Intent(MainActivity.this, TextRecyclerView.class));

                    break;

                case 2:
                    startActivity(new Intent(MainActivity.this, ImgListView.class));
                    break;

                case 3:

                    startActivity(new Intent(MainActivity.this, ImgGridView.class));
                    break;
                case 4:

                    startActivity(new Intent(MainActivity.this, ImgRecyclerView.class));
                    break;
                case 5:

                    startActivity(new Intent(MainActivity.this, TextGroupListView.class));
                    break;
                case 6:
                    startActivity(new Intent(MainActivity.this, TextGroupRecyclerView.class));

                    break;
                case 7:
                    startActivity(new Intent(MainActivity.this, SelectListView.class));

                    break;
                case 8:
                    startActivity(new Intent(MainActivity.this, TwoListView.class));

                    break;
            }
        }
    }


    private void initData() {
        mData = new ArrayList<>();
        mData.add("文字LV列表");
        mData.add("文字RV列表");
        mData.add("图片文字LV列表");
        mData.add("图片文字GV列表");
        mData.add("图片文字RV列表");
        mData.add("分组LV列表");
        mData.add("分组RV列表");
        mData.add("选择列表");
        mData.add("二级列表");
        mAdapter = new TextAdapter(this, mData);
        mListView.setAdapter(mAdapter);

    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.id_lv_main);

    }
}
