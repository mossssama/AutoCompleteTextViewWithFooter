package com.example.customautocompleteadaptermodule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.customautocompleteadaptermodule.databinding.ActivityMainBinding;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    static final String FOOTER = "Set Location on Map";
    String[] DROP_DOWN_LIST ={"ACADEMY","BEFOG","DEFOG","LEO MESSI","Mohamed Osama"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        /* M Osama: Initalize AutoCompleteTextView */
        CustomAutoCompleteAdapter list = new CustomAutoCompleteAdapter(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, DROP_DOWN_LIST, FOOTER);
        binding.autoCompleteTextView.setAdapter(list);

        /* M Osama: Footer onClick listener */
        list.setOnFooterClickListener(() -> Toast.makeText(MainActivity.this, "Footer is clicked", Toast.LENGTH_SHORT).show());

        /* M Osama: AnyOtherItem onClick listener */
        binding.autoCompleteTextView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) ->{
            String selectedItem = getSelectedItem(parent,position);
            int pos = getPositionInDataSource(DROP_DOWN_LIST,selectedItem);
            Toast.makeText(this, selectedItem, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, pos+"", Toast.LENGTH_SHORT).show();
        });



    }

   public String getSelectedItem(AdapterView parent , int positionInDropList){
        return (String) parent.getItemAtPosition(positionInDropList);
   }

   public int getPositionInDataSource(String[] dataSource , String selectedItem){
        return Arrays.asList(dataSource).indexOf(selectedItem);
   }
}