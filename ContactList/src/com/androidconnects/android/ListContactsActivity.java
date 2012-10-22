package com.androidconnects.android;

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidconnect.android.R;

public class ListContactsActivity extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		DatabaseHandler db = new DatabaseHandler(this);
		
		
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
       // db.addContact(new Contact("Gyan", "9100000000"));
        //db.addContact(new Contact("Gunjan", "9199999999"));
       // db.addContact(new Contact("Chetan", "9522222222"));
       // db.addContact(new Contact("Vivek", "9533333333"));
      // db.addContact(new Contact("amit", "9100000000"));
 
		
		 
        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();      
        int conts=contacts.size();
        int i=0;
        String[] Contacts = new String[conts];
        for (Contact cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            
        
        // Writing Contacts to log
        Contacts[i]=cn.getName();   
        i++;
        Log.d("Name: ", log);
        
        }

		// no more this
		// setContentView(R.layout.list_fruit);

		setListAdapter(new ArrayAdapter<String>(this, R.layout.contact_list,
				Contacts));

		ListView listView = getListView();
		listView.setTextFilterEnabled(true);

		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
		// When clicked, show a toast with the TextView text
				Toast.makeText(getApplicationContext(),
						((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			}
		});

	}

}