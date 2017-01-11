package com.example.a653401.myapplication.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.a653401.myapplication.view.adapter.viewholder.BaseViewHolder;

/**
 * Created by A653401 on 06-01-2017.
 */

public abstract class BaseRecyclerViewAdapter <T extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<T> implements BaseViewHolder.OnViewHolderClickedListener{

    private RecyclerView recycleView;
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recycleView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.recycleView = null;
    }

    @Override
    public void onViewHolderClick(View view, int adapterPosition) {
        listItemClickListener.OnRecyclerViewItemClick(recycleView,view,adapterPosition);
    }

    public interface ListItemClickListener{
        void OnRecyclerViewItemClick(RecyclerView recycleView,View view, int adapterPosition);
    }

    private ListItemClickListener listItemClickListener;

    public void setListener(ListItemClickListener listItemClickListener)
    {
        this.listItemClickListener = listItemClickListener;
    }

}
