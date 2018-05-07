package com.example.admin.quizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {
    public static String username;
    public EditText l_uname;
    public EditText l_pass;
    public Button l_login;
    myDbAdapter helper;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
         l_uname=(EditText) findViewById(R.id.l_uname);
         l_pass=(EditText) findViewById(R.id.l_pass);
        l_login = (Button) findViewById(R.id.l_login);
        helper = new myDbAdapter(this);
        l_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username=l_uname.getText().toString();
                String password=l_pass.getText().toString();
               int flag = helper.getData(username,password);

                if(flag==1)
                {
                    startActivity(new Intent(login.this, domain.class));
                }
                else
                {
                    Message.message(getApplicationContext(),"Username or Password Invalid");
                }

            }
        });
    }
}
