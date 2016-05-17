package com.senapathi.databasereference;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;


public class ContactsAdapter {

	private SQLiteDatabase mDataBase;
	private SimpleCursorAdapter cursorAdapter;
	private MySQLiteHelper mHelper;
	private Context mContext;
	
	public ContactsAdapter(Context context){
		mContext = context;
		mHelper = new MySQLiteHelper(mContext);
	}
	
	public void addContact(Contact contact) throws SQLException {

		mDataBase = mHelper.getWritableDatabase();

		ContentValues mValues = new ContentValues();
		mValues.put(MySQLiteHelper.ContactsContrast.CONTACT_NAME, contact.getName());
		mValues.put(MySQLiteHelper.ContactsContrast.CONTACT_EMAIL, contact.getEmail());
		mValues.put(MySQLiteHelper.ContactsContrast.CONTACT_NUMBER, contact.getNumber());

		mDataBase.insert(MySQLiteHelper.ContactsContrast.TABLE_NAME, null, mValues);
		

	}

	public SimpleCursorAdapter showContacts() {

		Cursor mCursor = mDataBase.query(MySQLiteHelper.ContactsContrast.TABLE_NAME, null,
				null, null, null, null, null);

		if (mCursor != null) {
			cursorAdapter = new SimpleCursorAdapter(mContext,
					R.layout.listview, mCursor, new String[] { "_id", "_name",
							"_number", "_email" }, new int[] { R.id.display_id,
							R.id.display_name, R.id.display_number,
							R.id.display_email });

		}
		
		return cursorAdapter;
	}

}
