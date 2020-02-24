package com.example.searchviewoutactionbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SearchView searchView;
    ListView listView;
   // ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Demo");
        searchView=findViewById(R.id.searchViewId);
        listView=findViewById(R.id.listViewId);
        String[]name=getResources().getStringArray(R.array.country_names);

        //arrayList=new ArrayList<String>();
       /* arrayList.add("Noman");
        arrayList.add("Noman");
        arrayList.add("Noman");
        arrayList.add("Noman");
        arrayList.add("Noman");
        arrayList.add("Rubi");
        arrayList.add("Lija");*/
        arrayAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,name);
        listView.setAdapter(arrayAdapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                arrayAdapter.getFilter().filter(s);
                return false;
            }
        });




    }
}
