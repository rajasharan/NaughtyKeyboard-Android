package com.rajasharan.naughtystringskeyboard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajasharan on 8/15/15.
 */
public class KeyboardAdapter extends RecyclerView.Adapter<KeyboardAdapter.Holder> {
    private static final String TAG = "KeyboardAdapter";

    private List<String> mStrings;
    private LayoutParams mLayoutParams;
    private NaughtyStringsIME mIME;

    public KeyboardAdapter(Context context, NaughtyStringsIME ime) {
        mStrings = new ArrayList<>();
        try {
            JsonReader reader = new JsonReader(new InputStreamReader(context.getAssets().open("blns.json"), "UTF-8"));
            reader.beginArray();
            while (reader.hasNext()) {
                mStrings.add(reader.nextString());
            }
            reader.endArray();
            reader.close();
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "", e);
        } catch (IOException e) {
            Log.e(TAG, "", e);
        } catch (Exception e) {
            Log.e(TAG, "", e);
        }

        mLayoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

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