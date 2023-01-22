package com.example.final5;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterMask extends BaseAdapter {
    private Context mContext;
    private List<Mask> maskList;

    public AdapterMask(Context mContext, List<Mask> maskList){
        this.mContext = mContext;
        this.maskList = maskList;
    }

    @Override
    public int getCount() {
        return maskList.size();
    }

    @Override
    public Object getItem(int position) {
        return maskList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return maskList.get(position).getID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.activity_mask, null);
        TextView textView = v.findViewById(R.id.textView);
        TextView textView2 = v.findViewById(R.id.textView2);

        Mask mask = maskList.get(position);
        textView.setText(mask.getDog());
        textView2.setText(mask.getInfo());

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Details.class);
                intent.putExtra("Dogs", mask);
                mContext.startActivity(intent);
            }
        });

        return v;
    }
}
