package com.rahul.serverupdation;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EditActivity extends AppCompatActivity {

    private EditText name,email,phone;
    String email1,name1,phone1;
    private Button edit;
    JSONParser jsonParser;
    String  url="http://www.antireservation.co.in/rahul/rahul_update_info.php";
    ProgressDialog progressDialog;
    int id2;
    String email12,name2,phone2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        name=(EditText) findViewById(R.id.EnterName);
        email=(EditText) findViewById(R.id.EnterEmail);
        phone=(EditText) findViewById(R.id.EnterPhone);
        edit=(Button) findViewById(R.id.Edit);

        name1=getIntent().getStringExtra("name");
        email1=getIntent().getStringExtra("email");
        phone1=getIntent().getStringExtra("mobno");
        id2=getIntent().getIntExtra("id",0);
        Log.d("id",""+id2);

        name.setText(name1);
        email.setText(email1);
        phone.setText(phone1);
        jsonParser = new JSONParser();



        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name2=name.getText().toString();
                email12=email.getText().toString();
                phone2=phone.getText().toString();
                new Jadu().execute();

            }
        });



    }


    public class Jadu extends AsyncTask<String,String,String> {


        @Override
        protected String doInBackground(String... params) {
            List<NameValuePair> parms = new ArrayList<NameValuePair>();
            parms.add(new BasicNameValuePair("name",name2));
            parms.add(new BasicNameValuePair("email",email12));
            parms.add(new BasicNameValuePair("mobno",phone2));
            parms.add(new BasicNameValuePair("id",String.valueOf(id2)));


            JSONObject jsonObject = jsonParser.makeHttpRequest(url,"POST",parms);

            Log.d("CREATE REPONSE", jsonObject.toString()+name1+email1+" "+id2);

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);

            progressDialog.dismiss();
            Toast.makeText(EditActivity.this,"Successfully change",Toast.LENGTH_LONG).show();


        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            progressDialog = new ProgressDialog(EditActivity.this);

            progressDialog.setMessage("Loading");
            progressDialog.show();
        }


    }
}
