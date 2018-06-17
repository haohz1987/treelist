package com.tz.treelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tz.treelist.treelist.Node;
import com.tz.treelist.treelist.SimpleTreeRecyclerAdapter;
import com.tz.treelist.treelist.TreeRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TreeRecyclerAdapter mAdapter;
    protected List<Node> mDatas = new ArrayList<Node>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.rv_list);
        rv.setLayoutManager(new LinearLayoutManager(this));
        initDatas();

        //第四个参数  默认展开层级数 0为不展开
        mAdapter = new SimpleTreeRecyclerAdapter(rv, MainActivity.this,
                mDatas, 0, R.mipmap.tree_ex, R.mipmap.tree_ec) {
            @Override
            public void onContentClicked(Node node, int position) {
                LogT.w("点击内容"+position+",node:"+node.getName());

            }

            @Override
            public void onMoreClicked(Node node, int position) {
                LogT.w("点击更多"+position+",node:"+node.getName());
            }
        };

        rv.setAdapter(mAdapter);
//        mAdapter.addData(0,mlist); //模拟添加数据
    }

    private void initDatas(){
//        mDatas.add(new Node("1", "-1", "文件管理系统"));//第二个参数表示指向第一个参数的位置
        mDatas.add(new Node(2+"", 1+"", "外层列表1-序号1"));
        mDatas.add(new Node(3+"", 1+"", "外层列表1-序号2"));
        mDatas.add(new Node(4+"", 1+"", "外层列表1-序号3"));

        mDatas.add(new Node(5+"", 2+"", "外层列表2-序号4"));
        mDatas.add(new Node(6+"", 2+"", "外层列表2-序号5"));

        mDatas.add(new Node(7+"", 4+"", "外层列表2-序号6"));
        mDatas.add(new Node(8+"", 4+"", "外层列表2-序号7"));

        mDatas.add(new Node(9+"", 7+"", "列表3-序号8"));
        mDatas.add(new Node(10+"", 7+"", "列表3-序号9"));

    }

}
