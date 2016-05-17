package com.senapathi.databasereference;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
public class ContactsActivity extends Activity implements OnClickListener{

    private Contact contact;
    private MySQLiteHelper mHelper;
    private ListView listView;
    private ContactsAdapter contactsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        listView = (ListView) findViewById(R.id.listview);

        Button saveBtn = (Button) findViewById(R.id.save);
        Button showBtn = (Button) findViewById(R.id.display);
        Button deleteBtn = (Button) findViewById(R.id.delete);

        contactsAdapter = new ContactsAdapter(this);
        contact = new Contact();

        contactsAdapter = new ContactsAdapter(this);

        saveBtn.setOnClickListener(this);
        showBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);

    }
    //



    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.save:
                EditText nameEdt = (EditText) findViewById(R.id.name);
                EditText numberEdt = (EditText) findViewById(R.id.number);
                EditText emailEdt = (EditText) findViewById(R.id.email);

                contact.setName(nameEdt.getText().toString());
                contact.setNumber(numberEdt.getText().toString());
                contact.setEmail(emailEdt.getText().toString());

                if(contact!=null){
                    contactsAdapter.addContact(contact);
                }
                else
                    Toast.makeText(ContactsActivity.this,"Null reached", 2).show();

                break;

            case R.id.display:

                SimpleCursorAdapter adapter = contactsAdapter.showContacts();
                listView.setAdapter(adapter);

                break;

            case R.id.delete:
                break;
        }

    }

}
