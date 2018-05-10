package com.sie.dethi1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    EditText edten;
    CheckBox ck1, ck2, ck3;
    Button btnadd, btnup;
    Myadapter myadapter;
    int position=0;
    ArrayList<Sach> list= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);
        edten=findViewById(R.id.edten);
        ck1=findViewById(R.id.ck1);
        ck2=findViewById(R.id.ck2);
        ck3=findViewById(R.id.ck3);
        btnadd=findViewById(R.id.btnadd);
        btnup=findViewById(R.id.btnup);

        myadapter= new Myadapter(list, this);
        listView.setAdapter(myadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                position=i;
                edten.setText(list.get(i).getTen());
                if (list.get(i).getTheloai().equals("1")){
                    ck1.setChecked(true);
                    ck2.setChecked(false);
                    ck3.setChecked(false);
                }else if (list.get(i).getTheloai().equals("2")){
                    ck1.setChecked(false);
                    ck2.setChecked(true);
                    ck3.setChecked(false);
                }else {
                    ck1.setChecked(false);
                    ck2.setChecked(false);
                    ck3.setChecked(true);
                }

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                for (int c=listView.getChildCount()-1; c>=0; c--){
                    View v = listView.getChildAt(c);
                    list.remove(c);
                }
                myadapter.notifyDataSetChanged();
                return true;
            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String abc= kq();
                Sach s= new Sach(edten.getText().toString(), abc);
                list.add(s);
                myadapter.notifyDataSetChanged();
            }
        });
        btnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String abc= kq();
                Sach s= new Sach(edten.getText().toString(), abc);
                list.set(position, s);
                myadapter.notifyDataSetChanged();
            }
        });
    }
    public String kq(){
        String abc="1";
        if (ck1.isChecked()){
            abc="1";
        }else if (ck2.isChecked()){
            abc="2";
        }else {
            abc="3";
        }
        return abc;
    }

}
