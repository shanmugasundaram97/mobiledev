package com.example.admin.quizz;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class domain extends AppCompatActivity {
ListView listView1;
    myDbAdapter helper;
String info[]={"C","Java","Data Structures"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domain);
        helper = new myDbAdapter(this);
        listView1=(ListView)findViewById(R.id.listView1);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,info);
        listView1.setAdapter(adapter);
    registerForContextMenu(listView1);

    listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(domain.this,info[i],Toast.LENGTH_SHORT).show();
            if(info[i].equals("C"))
            {
                startActivity(new Intent(domain.this, c.class));

            }
            else if(info[i].equals("Java"))
            {
                startActivity(new Intent(domain.this, java.class));
            }
            else if(info[i].equals("Data Structures"))
            {
                startActivity(new Intent(domain.this, ds.class));
            }


        }
    });

    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuinfo)
    {
        super.onCreateContextMenu(menu,v,menuinfo);
       // menu.add(0,v.getId(),0,"Score");
        menu.add(0,v.getId(),0,"Help");
    }
    public boolean onContextItemSelected(MenuItem item)
    {
        if(item.getTitle()=="Help")
        {
            //Toast.makeText(getApplicationContext(),"You will be provided with MCQ's and you have to answer the multiple choice questions, result will be shown at the end of the quiz.", Toast.LENGTH_LONG).show();

            final Toast toast = Toast.makeText(getApplicationContext(), "You will be provided with MCQ's and you have to answer the multiple choice questions, result will be shown at the end of the quiz.", Toast.LENGTH_LONG);
            toast.show();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    toast.cancel();
                }
            }, 5000);
        }


      /*  else if(item.getTitle()=="Details"){
            //Toast.makeText(getApplicationContext(),"getting details",Toast.LENGTH_LONG).show();
            listView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(domain.this, details.class));
                }
            });
        }*/else{
            return false;
        }
        return true;
    }
}