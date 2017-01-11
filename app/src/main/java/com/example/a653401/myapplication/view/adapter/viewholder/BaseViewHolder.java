package com.example.a653401.myapplication.view.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by A653401 on 06-01-2017.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public BaseViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onViewHolderClick(view, getAdapterPosition());
        }
    }
    public interface OnViewHolderClickedListener {

        void onViewHolderClick(View view, int adapterPosition);
    }

    protected OnViewHolderClickedListener listener;

    public void setListener(OnViewHolderClickedListener listener)
    {
        this.listener = listener;
    }



}
