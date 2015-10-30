package com.kgbt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.finishAffinity;
import static android.support.v4.app.ActivityCompat.startActivity;

/**
 * Created by ssangkmm on 2015-10-14.
 */
public class custom_aldinfo extends BaseAdapter {
    private ArrayList<aldinfo> m_List;

    public custom_aldinfo(){
        m_List = new ArrayList<aldinfo>();
    }

    @Override
    public int getCount() {
        return m_List.size();
    }

    @Override
    public Object getItem(int position) {
        return m_List.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int pos = position;
        final String name = "name";
        final String data = "data";
        final String DEBUG = "";
        final Context context = parent.getContext();

        if(convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_aldinfo, parent, false);

            final Button ed_mret = (Button) convertView.findViewById(R.id.editText_mret);
            ed_mret.setText(m_List.get(pos).Mret);
            final Button tv_title = (Button)convertView.findViewById(R.id.tv_title_mret);
            tv_title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = null;
                    i = new Intent(context, MultiRetInformation.class);
                    i.putExtra(name, ed_mret.getText().toString() + DEBUG);
                    i.putExtra(data, tv_title.getText().toString() + DEBUG);
                    context.startActivity(i);
                    ((Activity) context).finish();
                }
            });
            ed_mret.setFocusable(false);
            ed_mret.setClickable(false);

            final Button ed_sret = (Button)convertView.findViewById(R.id.editText_sret);
            ed_sret.setText(m_List.get(pos).Sret);
            final Button tv_titleSret = (Button)convertView.findViewById(R.id.tv_title_sret);
            tv_titleSret.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = null;
                    i = new Intent(context, Single_ret_information.class);
                    i.putExtra(name, ed_sret.getText().toString() + DEBUG);
                    i.putExtra(data, tv_titleSret.getText().toString() + DEBUG);
                    context.startActivity(i);
                    ((Activity) context).finish();
                }
            });
            ed_sret.setFocusable(false);
            ed_sret.setClickable(false);

            final Button ed_TMA = (Button)convertView.findViewById(R.id.editText_tma);
            ed_TMA.setText(m_List.get(pos).Tma);
            final Button tv_titleTma = (Button)convertView.findViewById(R.id.tv_title_TMA);
            tv_titleTma.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = null;

                    i = new Intent(context, Single_ret_information.class);
                    i.putExtra(name, ed_TMA.getText().toString() + DEBUG);
                    i.putExtra(data, tv_titleTma.getText().toString() + DEBUG);
                    context.startActivity(i);
                    ((Activity) context).finish();
                }
            });
            ed_TMA.setFocusable(false);
            ed_TMA.setClickable(false);

            final Button ed_ras = (Button)convertView.findViewById(R.id.editText_ras);
            ed_ras.setText(m_List.get(pos).Ras);
            final Button tv_titleras = (Button)convertView.findViewById(R.id.tv_title_RAS);
            tv_titleras.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = null;
                    i = new Intent(context, Single_ret_information.class);
                    i.putExtra(name,ed_ras.getText().toString()+DEBUG);
                    i.putExtra(data,tv_titleras.getText().toString()+DEBUG);
                    context.startActivity(i);
                    ((Activity)context).finish();
                }
            });
            ed_ras.setFocusable(false);
            ed_ras.setClickable(false);

        }

        return convertView;
    }

    public void add(aldinfo _aldinfo){
        m_List.add(_aldinfo);
    }

    public void remove(int _position){
        m_List.remove(_position);
    }
}
