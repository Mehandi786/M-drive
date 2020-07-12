package com.hassan.sqlite;

import android.provider.BaseColumns;

public class PersonContract {
    private PersonContract() {}
    public static class Person implements BaseColumns{
        public static final String TABLE_NAME ="person";
        public static final String COLUMN_NAME_PERSON_NAME = "person_name";
        public static final String COLUMN_NAME_PERSON_AGE ="person_age";
    }
    public static final String SQL_CREATE_PERSON = "CREATE TABLE "+Person.TABLE_NAME+
            "("+Person._ID+"INTEGER PRIMARY KEY, "+Person.COLUMN_NAME_PERSON_NAME+" TEXT, "
            +Person.COLUMN_NAME_PERSON_AGE+" TEXT)";

    public static final String DELETE_TABLE_PERSON = "DROP TABLE IF EXISTS "+Person.TABLE_NAME;

}
