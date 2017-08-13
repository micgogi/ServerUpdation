package com.rahul.serverupdation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {


    TextView name,email,mobno;
    Button edit;
    int id1;
    String n,e,m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        name=(TextView) findViewById(R.id.show_name);
        email=(TextView) findViewById(R.id.show_email);
        mobno = (TextView) findViewById(R.id.show_mob);
        edit = (Button) findViewById(R.id.btn_detail);
        name.setText(getIntent().getStringExtra("name"));
        email.setText(getIntent().getStringExtra("email"));
        mobno.setText(getIntent().getStringExtra("mobno"));
        id1=getIntent().getIntExtra("id",0);
        Log.d("id No"," "+id1);
        n=getIntent().getStringExtra("name");
        e=getIntent().getStringExtra("email");
        m=getIntent().getStringExtra("mobno");


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this,EditActivity.class);
                intent.putExtra("name",n);
                intent.putExtra("email",e);
                intent.putExtra("mobno",m);
                intent.putExtra("id",id1);
                startActivity(intent);
            }
        });
    }


}
