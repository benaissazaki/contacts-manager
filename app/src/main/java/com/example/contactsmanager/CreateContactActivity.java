package com.example.contactsmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.data.Contact;
import com.example.data.ContactDatabase;

public class CreateContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);
    }

    public void createContact(View view) {
        TextView nameInp = findViewById(R.id.nameInp);
        TextView phoneInp = findViewById(R.id.phoneInp);
        TextView emailInp = findViewById(R.id.emailInp);

        String name = nameInp.getText().toString();
        String phone = phoneInp.getText().toString();
        String email = emailInp.getText().toString();

        new ContactDatabase(this).createContact(new Contact(name, phone, email));

        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
        finish();
    }
}
