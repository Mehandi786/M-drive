package com.hassan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.hassan.model.ContactDetails;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    boolean permissionStatus = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.myList);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkPermission();
        } else {
            permissionStatus = true;
        }
    }

    private void checkPermission() {
        int value = ContextCompat.checkSelfPermission(this,Manifest.permission.READ_CONTACTS);
        if( value == PackageManager.PERMISSION_GRANTED) {
            permissionStatus = true;
        }else {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS},1);
            permissionStatus = false;
        }
    }

    public void fetchContacts(View view) {
        if(permissionStatus) {
            ArrayList<ContactDetails> contactDetails = populateContactsIntoList();
            if(contactDetails.size() > 0) {
                ArrayList<String> arrayList = new ArrayList<>();
                for(ContactDetails contactDetails1 : contactDetails) {
                    arrayList.add("Name: "+contactDetails1.getContactName()+"\n Email: "+contactDetails1.getContactEmail()+"\n Phone: "+contactDetails1.getContactNumber());
                }
                ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,arrayList);
                listView.setAdapter(arrayAdapter);
            }else{
                Toast.makeText(this,"No contacts available..!",Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(this, "No permission given for contacts", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public ArrayList<ContactDetails> populateContactsIntoList() {
        ArrayList<ContactDetails> contactDetailsList = new ArrayList<>();

        Uri uri = ContactsContract.Contacts.CONTENT_URI;

        Cursor contactsCursor = getContentResolver().query(uri,null,null,null,ContactsContract.Contacts.DISPLAY_NAME+" ASC");

        if(contactsCursor.moveToFirst()) {
            Log.d("MainActivity","Count contacts: "+contactsCursor.getCount());
            do {
                long contactID = contactsCursor.getLong(contactsCursor.getColumnIndex("_ID"));
                String displayName = "";
                String phone="";
                String email="";
                Uri dataUri = ContactsContract.Data.CONTENT_URI;
                Cursor dataCursor = getContentResolver().query(dataUri,null,ContactsContract.Data.CONTACT_ID+"="+contactID,null,null);
                if(dataCursor.moveToFirst()) {
                    do{
                        displayName = dataCursor.getString(dataCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                        if(dataCursor.getString(dataCursor.getColumnIndex("mimetype")).equals(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE))  {
                            //                        switch (dataCursor.getInt(dataCursor.getColumnIndex("data2"))) {
//                            case ContactsContract.CommonDataKinds.Phone.TYPE_HOME :
//                                pho
//                        }
                            phone = dataCursor.getString(dataCursor.getColumnIndex("data1"));
                        }
                        if(dataCursor.getString(dataCursor.getColumnIndex("mimetype")).equals(ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE))  {
                            email = dataCursor.getString(dataCursor.getColumnIndex("data1"));
                        }
                    }while(dataCursor.moveToNext());
                    contactDetailsList.add(new ContactDetails(""+contactID,displayName,phone,email,null,null));
                }
            }while(contactsCursor.moveToNext());
        }
        return contactDetailsList;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if( requestCode == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            permissionStatus = true;
        } else {
            permissionStatus = false;
        }
    }
}