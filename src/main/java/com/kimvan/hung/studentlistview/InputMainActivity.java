package com.kimvan.hung.studentlistview;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class InputMainActivity extends AppCompatActivity {

    EditText inputName;
    EditText inputAge;
    EditText inputAdress;
    Button send;
    Button show;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_main);

        khaibao();
        clickButton();

    }

    public void sendClick(){
        try{
            InfoStudent.infoStudent.add(new RowItem(inputName.getText().toString(),Integer.parseInt(inputAge.getText().toString()),
                    inputAdress.getText().toString()));
        }catch (Exception e){
            Toast toast =Toast.makeText(getApplicationContext(),"Please refill!",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void clickButton(){
        show.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showClick();
                    }
                }
        );

        send.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sendClick();
                    }
                }
        );
    }
    public void khaibao(){
        inputName = (EditText) findViewById(R.id.input_name);
        inputAdress = (EditText) findViewById(R.id.input_adress);
        inputAge = (EditText) findViewById(R.id.input_age);
        send = (Button) findViewById(R.id.send_button);
        show = (Button) findViewById(R.id.show_button);
    }
    public void showClick(){
        for (RowItem x:InfoStudent.infoStudent){
            String clgt = x.getName()+" "+String.valueOf(x.getAge())+" "+x.getAdress();
            Log.i(MainActivity.tag,clgt);
        }
        intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
