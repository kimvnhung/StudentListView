package com.kimvan.hung.studentlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by h on 09/08/2017.
 */

public class StudentApdater extends BaseAdapter {
    Context context;
    ArrayList<RowItem> rowItems;

    public StudentApdater(Context context, ArrayList<RowItem> rowItems) {
        this.context = context;
        this.rowItems = rowItems;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }

    private class ViewHolder{
        TextView name;
        TextView age;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView==null){
            convertView = layoutInflater.inflate(R.layout.list_view_item,null);

            holder = new ViewHolder();

            holder.age = (TextView) convertView.findViewById(R.id.age_item);
            holder.name = (TextView) convertView.findViewById(R.id.name_item);

            RowItem row_pos = rowItems.get(position);

            holder.age.setText(String.valueOf(row_pos.getAge()));
            holder.name.setText(row_pos.getName());

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }
}
