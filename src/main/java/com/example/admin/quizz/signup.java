package com.example.admin.quizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class signup extends AppCompatActivity {

    public EditText Name, Pass;
    myDbAdapter helper;
    public Button s_signup;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Name = (EditText) findViewById(R.id.s_uname);
        Pass = (EditText) findViewById(R.id.s_pass);

        helper = new myDbAdapter(this);


    s_signup=(Button)findViewById(R.id.s_signup);


        s_signup.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View view){
        String t1 = Name.getText().toString();
        String t2 = Pass.getText().toString();
        if (t1.isEmpty() || t2.isEmpty()) {
            Message.message(getApplicationContext(), "Enter Both Name and Password");
        } else {
            long id = helper.insertData(t1,t2);
            if (id <= 0) {
                Message.message(getApplicationContext(), "Insertion Unsuccessful");
                Name.setText("");
                Pass.setText("");
            } else {
                Message.message(getApplicationContext(), "Insertion Successful");
                Name.setText("");
                Pass.setText("");

                startActivity(new Intent(signup.this, dash.class));
            }
        }

    }
    });

}
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.s_male:
                if (checked)

                    break;
            case R.id.s_female:
                if (checked)

                    break;
        }
    }

}

