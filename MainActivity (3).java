package com.mani.session4ass1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends Activity implements View.OnClickListener {
    Button btasc,btdesc;
    ListView lvitems;
    String month[];
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        month=getResources().getStringArray(R.array.month);
        setContentView(R.layout.activity_main);
        btasc=(Button)findViewById(R.id.btasc);
        btdesc=(Button)findViewById(R.id.btdesc);
        lvitems= (ListView) findViewById(R.id.lvitems);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.custom,month);
        lvitems.setAdapter(adapter);
        btasc.setOnClickListener(this);
        btdesc.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btasc:
              Arrays.sort(month);
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.custom,month);
                lvitems.setAdapter(adapter);
                break;
            case R.id.btdesc:
                ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,R.layout.custom,month);

                adapter1.sort(Collections.<String>reverseOrder());
                        lvitems.setAdapter(adapter1);
                break;
        }
    }
}
