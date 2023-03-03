# AutoCompleteTextView with Footer
AutoCompleteText View with constant appearing Footer for Android in Java

# **Usage** 
***
[1] **Put [CustomAutoCompleteAdapter class](https://github.com/mossssama/AutoCompleteTextViewWithFooter/blob/main/CustomAutoCompleteAdapterModule/app/src/main/java/com/example/customautocompleteadaptermodule/CustomAutoCompleteAdapter.java) in your project folder** 
***
[2] **Create your Footer object** as the following

    static final String FOOTER = "Set Location on Map";
***
[3] **Create an object to feed your dropDownList** you can feed your dropDownList using SQLite, Room, API & so on 

    String[] DROP_DOWN_LIST ={"ACADEMY","BEFOG","DEFOG","LEO MESSI","Mohamed Osama"};
***
[4] **Write the following in the activity/fragment which its layout has the AutoCompleteTextView view** 

        /* M Osama: Initalize AutoCompleteTextView */
        CustomAutoCompleteAdapter list = new CustomAutoCompleteAdapter(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, DROP_DOWN_LIST, FOOTER);
        binding.autoCompleteTextView.setAdapter(list);
***
[6] **Some Helping Functions that you might need to use with AutoCompleteTextView**
        
      public String getSelectedItem(AdapterView parent , int positionInDropList){
            return (String) parent.getItemAtPosition(positionInDropList);
       }

       public int getPositionInDataSource(String[] dataSource , String selectedItem){
            return Arrays.asList(dataSource).indexOf(selectedItem);
       }
***        
[7]  **Footer onClick Listener**    
        
        /* M Osama: Footer onClick listener */
        list.setOnFooterClickListener(() -> Toast.makeText(MainActivity.this, "Footer is clicked", Toast.LENGTH_SHORT).show());
***
[8] **Any other Item onClick Listener**
      
      /* M Osama: AnyOtherItem onClick listener */
        binding.autoCompleteTextView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) ->{
            String selectedItem = getSelectedItem(parent,position);
            int pos = getPositionInDataSource(DROP_DOWN_LIST,selectedItem);
            Toast.makeText(this, selectedItem, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, pos+"", Toast.LENGTH_SHORT).show();
        });
***

