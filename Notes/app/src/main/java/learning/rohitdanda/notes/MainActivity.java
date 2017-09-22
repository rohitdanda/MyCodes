package learning.rohitdanda.notes;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    ListView listViewhere;

    static ArrayAdapter arrayAdapter;


    static ArrayList<String> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewhere = (ListView)findViewById(R.id.listview);

        SharedPreferences sharedPreferences = getSharedPreferences("learning.rohitdanda.notes", Context.MODE_PRIVATE);

        HashSet<String> setfirst =  (HashSet)sharedPreferences.getStringSet("notes",null);

        if(setfirst==null) {

            notes.add("To Add note click the top right menu \nTo delete the Note long press the Notes ");
        }
        else
        {
            notes = new ArrayList(setfirst);
        }

        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,notes);

        listViewhere.setAdapter(arrayAdapter);

        listViewhere.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(),Editor.class);

                intent.putExtra("notesid",i);

                startActivity(intent);

            }
        });

        listViewhere.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> adapterView, View view, int i, long l) {


                final int hereint = i;

                new AlertDialog.Builder(adapterView.getContext()).
                        setIcon(android.R.drawable.ic_delete).
                        setTitle("Want to Delete it ?").
                        setMessage("Sure want to Discard it ?").
                        setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                notes.remove(hereint);

                                arrayAdapter.notifyDataSetChanged();

                                SharedPreferences sharedPreferences = getSharedPreferences("learning.rohitdanda.notes", Context.MODE_PRIVATE);

                                HashSet<String> set = new HashSet<String>(MainActivity.notes);

                                sharedPreferences.edit().putStringSet("notes",set).apply();


                            }
                        }).
                        setNegativeButton("No",null).show();

                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_addnote,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        int menuitem = item.getItemId();

        if(menuitem==R.id.addnotes){

            Intent intent = new Intent(getApplicationContext(),Editor.class);

            startActivity(intent);



            return true;
        }
        if(menuitem==R.id.exit){

            SharedPreferences sharedPreferences = getSharedPreferences("learning.rohitdanda.notes", Context.MODE_PRIVATE);

            HashSet<String> set = new HashSet<String>(MainActivity.notes);

            sharedPreferences.edit().putStringSet("notes",set).apply();

            finish();
        }

        return false;
    }
}
