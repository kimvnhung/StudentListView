package com.kimvan.hung.studentlistview;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class DetailsActivity extends AppCompatActivity {

    TextView NameDetailsTitle;
    EditText fullName;
    EditText age;
    EditText adress;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        NameDetailsTitle = (TextView) findViewById(R.id.name_detail_title);
        fullName = (EditText) findViewById(R.id.fullname_edit);
        age = (EditText) findViewById(R.id.age_edit);
        adress = (EditText) findViewById(R.id.adress_edit);
        saveButton = (Button) findViewById(R.id.save_button);

        RowItem mInfo = (RowItem) getIntent().getSerializableExtra("info");
        final Bundle position = getIntent().getExtras();

        NameDetailsTitle.setText("Thông tin sinh viên "+mInfo.getName());
        fullName.setText(mInfo.getName());
        age.setText(String.valueOf(mInfo.getAge()));
        adress.setText(mInfo.getAdress());

        saveButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setSaveButton((int)position.get("position"));
                    }
                }
        );
    }
    public void setSaveButton(int position){
        try{

            InfoStudent.infoStudent.add(position,new RowItem(fullName.getText().toString(),
                    Integer.parseInt(age.getText().toString()),adress.getText().toString()));
            InfoStudent.infoStudent.remove(position+1);
        }catch (Exception e){
            Toast toast = Toast.makeText(getApplicationContext(),"the value is not changed!",Toast.LENGTH_LONG);
            toast.show();
        }
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
