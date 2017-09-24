package learning.rohitdanda.sqllitedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {


            SQLiteDatabase heredatabase = this.openOrCreateDatabase("Login",MODE_PRIVATE,null);

            heredatabase.execSQL("CREATE TABLE IF NOT EXISTS events (name VARCHAR , year INT)");

            heredatabase.execSQL("INSERT INTO events (name,year) VALUES ('First Noble PRize',1901)");

            Cursor c = heredatabase.rawQuery("SELECT * FROM events",null);

            int numberofnameindex = c.getColumnIndex("name");

            int numberofageindex = c.getColumnIndex("year");

            c.moveToFirst();

            while (c != null){

                Log.i("name",c.getString(numberofnameindex));
                Log.i("Age",Integer.toString(c.getInt(numberofageindex)));
                c.moveToNext();
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
