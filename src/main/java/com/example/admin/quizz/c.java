package com.example.admin.quizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class c extends AppCompatActivity {

    public RadioGroup q1,q2,q3,q4,q5;
    public RadioButton rb;
    public Button submit;
    public int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        count=0;
        q1=(RadioGroup)findViewById(R.id.r1);
        q2=(RadioGroup)findViewById(R.id.r2);
        q3=(RadioGroup)findViewById(R.id.r3);
        q4=(RadioGroup)findViewById(R.id.r4);
        q5=(RadioGroup)findViewById(R.id.r5);

        submit=(Button)findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=q1.getCheckedRadioButtonId();
                rb=(RadioButton)findViewById(id);
                if(rb.getText().equals("A.  AND OPERATOR"))
                {
                    count++;

                }

               id=q2.getCheckedRadioButtonId();
                rb=(RadioButton)findViewById(id);
                if(rb.getText().equals("B.  OR OPERATOR"))
                {
                    count++;
                }

                id=q3.getCheckedRadioButtonId();
                rb=(RadioButton)findViewById(id);
                if(rb.getText().equals("A.  Dennis Ritchie"))
                {
                    count++;
                }

                id=q4.getCheckedRadioButtonId();
                rb=(RadioButton)findViewById(id);
                if(rb.getText().equals("A.  TRUE"))
                {
                    count++;
                }

                id=q5.getCheckedRadioButtonId();
                rb=(RadioButton)findViewById(id);
                if(rb.getText().equals("D.  _"))
                {
                    count++;
                }
               String s=String.valueOf(count);
                Intent i=new Intent(getApplicationContext(),result.class);
                i.putExtra("value",s);
                startActivity(i);
            }

        });

    }
}
