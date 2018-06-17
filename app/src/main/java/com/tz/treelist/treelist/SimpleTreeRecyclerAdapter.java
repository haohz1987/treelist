package com.tz.treelist.treelist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tz.treelist.DebouncingOnClickListener;
import com.tz.treelist.R;

import java.util.List;

public abstract class SimpleTreeRecyclerAdapter extends TreeRecyclerAdapter {

    public SimpleTreeRecyclerAdapter(RecyclerView mTree, Context context, List<Node> datas, int defaultExpandLevel, int iconExpand, int iconNoExpand) {
        super(mTree, context, datas, defaultExpandLevel, iconExpand, iconNoExpand);
    }

    public SimpleTreeRecyclerAdapter(RecyclerView mTree, Context context, List<Node> datas, int defaultExpandLevel) {
        super(mTree, context, datas, defaultExpandLevel);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHoder(View.inflate(mContext, R.layout.list_item, null));
    }

    @Override
    public void onBindViewHolder(final Node node, RecyclerView.ViewHolder holder, final int position) {

        final MyHoder viewHolder = (MyHoder) holder;
        viewHolder.icon.setOnClickListener(new DebouncingOnClickListener() {
            @Override
            public void doClick(View v) {
                expandOrCollapse(position);
                onContentClicked(node, position);
            }
        });
        viewHolder.label.setOnClickListener(new DebouncingOnClickListener() {
            @Override
            public void doClick(View v) {
                expandOrCollapse(position);
                onContentClicked(node, position);
            }
        });
        viewHolder.more.setOnClickListener(new DebouncingOnClickListener() {
            @Override
            public void doClick(View v) {
                onMoreClicked(node, position);
            }
        });
        if (node.getIcon() == -1) {
            viewHolder.icon.setVisibility(View.INVISIBLE);
        } else {
            viewHolder.icon.setVisibility(View.VISIBLE);
            viewHolder.icon.setImageResource(node.getIcon());
        }
        viewHolder.label.setText(node.getName());
    }

    public abstract void onContentClicked(final Node node, int position);

    public abstract void onMoreClicked(final Node node, int position);

    class MyHoder extends RecyclerView.ViewHolder {
        public TextView label;
        public TextView more;
        public ImageView icon;

        public MyHoder(View itemView) {
            super(itemView);

            label = (TextView) itemView
                    .findViewById(R.id.tv_treenode_label);
            icon = (ImageView) itemView.findViewById(R.id.icon);
            more = (TextView) itemView.findViewById(R.id.tv_more);

        }
    }
}
