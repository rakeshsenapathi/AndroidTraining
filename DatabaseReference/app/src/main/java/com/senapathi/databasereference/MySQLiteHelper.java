package com.senapathi.databasereference;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {

	public static class ContactsContrast {

		public static final String TABLE_NAME = "contacts";
		private static final String DATABASE_NAME = "contacts.db";
		private static final int VERSION = 1;
		public static final String ID = "_id";
		public static final String CONTACT_NAME = "_name";
		public static final String CONTACT_EMAIL = "_email";
		public static final String CONTACT_NUMBER = "_number";
		public static final String CREATE_QUERY = "CREATE TABLE "
				+ TABLE_NAME + "(" + ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + CONTACT_NAME
				+ " TEXT NOT NULL, " + CONTACT_NUMBER + " NUMBER NOT NULL, "
				+ CONTACT_EMAIL + " TEXT NOT NULL);";

	}

	public MySQLiteHelper(Context context) {
		super(context, ContactsContrast.DATABASE_NAME, null,
				ContactsContrast.VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(ContactsContrast.CREATE_QUERY);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP IF EXISTS " + ContactsContrast.TABLE_NAME);
		onCreate(db);
	}

}
