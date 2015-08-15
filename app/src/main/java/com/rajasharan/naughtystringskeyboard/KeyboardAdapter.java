package com.rajasharan.naughtystringskeyboard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajasharan on 8/15/15.
 */
public class KeyboardAdapter extends RecyclerView.Adapter<KeyboardAdapter.Holder> {
    private List<String> mStrings;
    private ViewGroup.LayoutParams mLayoutParams;
    private NaughtyStringsIME mIME;

    public KeyboardAdapter(Context context, NaughtyStringsIME ime) {
        mStrings = new ArrayList<>();
        mStrings.add("hello 1");
        mStrings.add("hello 2");
        mStrings.add("hello 3");
        mStrings.add("hello 4");
        mStrings.add("hello 5");
        mStrings.add("hello 6");
        mStrings.add("hello 7");

        mLayoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        mIME = ime;
    }
    @Override
    public Holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        TextView string = new TextView(viewGroup.getContext());
        string.setPadding(10, 10, 0, 10);
        string.setLayoutParams(mLayoutParams);
        string.setOnClickListener(mIME);
        Holder holder = new Holder(string);
        return holder;
    }
    @Override
    public void onBindViewHolder(Holder holder, int i) {
        holder.mStringView.setText(mStrings.get(i));
    }
    @Override
    public int getItemCount() {
        return mStrings.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        TextView mStringView;
        public Holder(View itemView) {
            super(itemView);
            mStringView = (TextView) itemView;
        }
    }
}