package com.example.contactsmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.data.ContactDatabase;

public class ContactDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        Intent intent = getIntent();
        ((TextView)findViewById(R.id.name1)).setText(intent.getStringExtra("name"));
        ((TextView)findViewById(R.id.email1)).setText(intent.getStringExtra("email"));
        ((TextView)findViewById(R.id.phone1)).setText(intent.getStringExtra("phone"));
    }

    public void send_mail(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"+getIntent().getStringExtra("email")));
        startActivity(intent);
    }

    public void call(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getIntent().getStringExtra("phone")));
        startActivity(intent);

    }

    public void delete(View view) {
        ContactDatabase db = new ContactDatabase(this);
        db.deleteContact(getIntent().getStringExtra("phone"));

        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);

        finish();
    }
}
