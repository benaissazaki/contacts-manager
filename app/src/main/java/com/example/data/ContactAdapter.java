package com.example.data;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.contactsmanager.R;

public class ContactAdapter extends CursorAdapter {
    public ContactAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.contact_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nameView = view.findViewById(R.id.name);
        TextView phoneView = view.findViewById(R.id.phone);
        TextView emailView = view.findViewById(R.id.email);

        nameView.setText(cursor.getString(1));
        phoneView.setText(cursor.getString(2));
        emailView.setText(cursor.getString(3));
    }

}
