package com.hassan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hassan.sqlite.PersonContract;
import com.hassan.sqlite.PersonDBHelper;

public class MainActivity extends AppCompatActivity {
    EditText nameText, ageText;
    TextView diplayText;
    PersonDBHelper personDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameText = (EditText) findViewById(R.id.nameET);
        ageText = (EditText) findViewById(R.id.AgeET);
        diplayText = (TextView) findViewById(R.id.displayTV);
        personDBHelper = new PersonDBHelper(this);
    }
    public void saveClicked(View view) {
        String name = nameText.getText().toString();
        String age = ageText.getText().toString();

        SQLiteDatabase sqLiteDatabase = personDBHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(PersonContract.Person.COLUMN_NAME_PERSON_NAME,name);
        contentValues.put(PersonContract.Person.COLUMN_NAME_PERSON_AGE,age);

        long personID = sqLiteDatabase.insert(PersonContract.Person.TABLE_NAME,null,contentValues);

        Toast.makeText(this,"Person created and id: "+personID,Toast.LENGTH_LONG).show();
    }

    public void fetchClicked(View view) {
        SQLiteDatabase sqLiteDatabase = personDBHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(PersonContract.Person.TABLE_NAME,null,null,null,null,null,null);
        boolean status = cursor.moveToFirst();
        if(status == true) {
            do {
                String name = cursor.getString(1);
                String age = cursor.getString(2);
                Log.d("MainActivity", "Name: " + name + ", Age: " + age);
                diplayText.setText("Name: "+name+ ",Age"+age);
            }while(cursor.moveToNext());
        }else {
            diplayText.setText("No data found");
        }

    }
}
