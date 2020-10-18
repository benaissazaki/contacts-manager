package com.example.contactsmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.data.Contact;
import com.example.data.ContactDatabase;

public class ModifyContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_contact);
    }

    public void createContact(View view) {
        String name = ((EditText)findViewById(R.id.nameInput)).getText().toString();
        String phone = ((EditText)findViewById(R.id.phoneInput)).getText().toString();
        String email = ((EditText)findViewById(R.id.emailInput)).getText().toString();

        Contact contact = new Contact(name, phone, email);
        new ContactDatabase(this).updateContact(contact);

        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
        finish();
    }
}
