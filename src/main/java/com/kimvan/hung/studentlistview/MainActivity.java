package com.kimvan.hung.studentlistview;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<RowItem> infoStudent = new ArrayList<>();
    ListView listView;
    StudentApdater studentApdater;
    Button create;
    Intent intent ;


    public static final String tag = "wrong";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create = (Button) findViewById(R.id.button_create);
        if (InfoStudent.infoStudent.size()<=1){
            setInfoStudent();
        }
        create.setVisibility(create.INVISIBLE);
        listView = (ListView) findViewById(R.id.list_view_main);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        onItemClicked(position);
                    }
                }
        );

        Log.i("wrong","onCreate");
        listView.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                        AlertDialog.Builder myDialog = new AlertDialog.Builder(MainActivity.this);
                        myDialog.setTitle(R.string.delete_title);
                        myDialog.setMessage(R.string.delete_message);
                        myDialog.setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                InfoStudent.infoStudent.remove(position);
                                showListView();
                                dialog.dismiss();
                            }
                        });
                        myDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        myDialog.show();

                        return true;
                    }
                }
        );
        showListView();
    }

    public void onItemClicked(int position){
        intent = new Intent(this,DetailsActivity.class);
        intent.putExtra("position",position);
        intent.putExtra("info",(RowItem)listView.getItemAtPosition(position));
        startActivity(intent);
    }

    public void showListView(){
        studentApdater = new StudentApdater(this,InfoStudent.infoStudent);
        listView.setAdapter(studentApdater);
    }
    public void setInfoStudent(){
        for (int i=0;i<5;i++) {
            RowItem para = new RowItem("Student " + i, i + 20, "District +" + (i * i) + "DC");
            infoStudent.add(para);
        }
        for (RowItem x:infoStudent){
            InfoStudent.infoStudent.add(x);
        }
    }
}
