package pfizer.wellness.handler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import pfizer.wellness.models.Customer;

import static android.R.attr.id;
import static android.content.ContentValues.TAG;

/**
 * Created by ROEL on 4/19/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // All static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "pfizerCustomerDetails";

    // Customer Details table name
    private static final String TABLE_CUSTOMER_DETAILS = "customer_details";

    // Customer Details column names
    private static final String KEY_ID = "id";
    private static final String KEY_UID = "unique_id";
    private static final String KEY_NAME = "customer_name";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_DATE_OF_BIRTH = "birth_date";
    private static final String KEY_CONDITION = "condition";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CUSTOMERS_TABLE = "CREATE TABLE " + TABLE_CUSTOMER_DETAILS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_UID + " TEXT,"
                + KEY_NAME + " TEXT,"
                + KEY_GENDER + " TEXT,"
                + KEY_DATE_OF_BIRTH + " DATE,"
                + KEY_CONDITION + " TEXT" + ")";
        db.execSQL(CREATE_CUSTOMERS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CUSTOMER_DETAILS);

        // Create tables again
        onCreate(db);
    }

    //Adding new customer
    public void addCustomer(Customer customer){

        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
        String datetime = ft.format(dNow);

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_UID, datetime);
        values.put(KEY_NAME, customer.getName());
        values.put(KEY_GENDER, customer.getGender());
        values.put(KEY_DATE_OF_BIRTH, customer.getDateOfBirth());
        values.put(KEY_CONDITION, customer.getPreExistingConditions());

        // Inserting rows
        db.insert(TABLE_CUSTOMER_DETAILS, null, values);
        db.close(); //Closing database connection
    }

    // Getting single contact
    public Customer getCustomer(String uid){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CUSTOMER_DETAILS, new String[] { KEY_ID,
                        KEY_UID, KEY_NAME, KEY_GENDER, KEY_DATE_OF_BIRTH, KEY_CONDITION }, KEY_ID + "=?",
                new String[] { uid }, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Customer customer = new Customer(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5));

        // return contact
        return customer;

    }

    // Getting All Contacts
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<Customer>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CUSTOMER_DETAILS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Customer customer = new Customer();
                customer.setID(Integer.parseInt(cursor.getString(0)));
                customer.setUID(cursor.getString(1));
                customer.setName(cursor.getString(2));
                customer.setGender(cursor.getString(3));
                customer.setDateOfBirth(cursor.getString(4));
                customer.setPreExistingConditions(cursor.getString(5));
                // Adding contact to list
                customerList.add(customer);
            } while (cursor.moveToNext());
        }

        // return contact list
        return customerList;
    }

    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CUSTOMER_DETAILS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    // Updating single contact
    public int updateContact(Customer customer) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, customer.getName());
        values.put(KEY_GENDER, customer.getGender());
        values.put(KEY_DATE_OF_BIRTH, customer.getDateOfBirth());
        values.put(KEY_CONDITION, customer.getPreExistingConditions());

        // updating row
        return db.update(TABLE_CUSTOMER_DETAILS, values, KEY_UID + " = ?",
                new String[] { String.valueOf(customer.getUID()) });
    }

    // Deleting single contact
    public void deleteContact(Customer customer) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CUSTOMER_DETAILS, KEY_ID + " = ?",
                new String[] { String.valueOf(customer.getUID()) });
        db.close();
    }
}
