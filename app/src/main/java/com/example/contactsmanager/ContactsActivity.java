package com.example.contactsmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.data.Contact;
import com.example.data.ContactAdapter;
import com.example.data.ContactDatabase;

import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        setUpListView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.contacts_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.addContact:
                Intent intent = new Intent(this, CreateContactActivity.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.modifyContact:
                Intent intent1 = new Intent(this, ModifyContact.class);
                startActivity(intent1);
                finish();
                return true;
            default:
                return false;
        }

    }

    protected void setUpListView() {
        ContactDatabase db = new ContactDatabase(this);
        Cursor cursor = db.listContacts();
        ContactAdapter contactsAdapter = new ContactAdapter(this, cursor);

        ListView lv = findViewById(R.id.contactsList);
        lv.setAdapter(contactsAdapter);

        lv.setOnItemClickListener( new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> adapterView , View view , int position ,long id)
            {
                String name = ((TextView)view.findViewById(R.id.name)).getText().toString();
                String phone = ((TextView)view.findViewById(R.id.phone)).getText().toString();
                String email = ((TextView)view.findViewById(R.id.email)).getText().toString();

                Intent intent = new Intent(ContactsActivity.this, ContactDetail.class);
                intent.putExtra("name", name);
                intent.putExtra("phone", phone);
                intent.putExtra("email", email);

                startActivity(intent);
                ContactsActivity.this.finish();
            }
        });
    }
}
