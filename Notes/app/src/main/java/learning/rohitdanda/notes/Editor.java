package learning.rohitdanda.notes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.HashSet;

public class Editor extends AppCompatActivity {

    int noteidhere;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        EditText editText = (EditText)findViewById(R.id.editor);

        Intent intenthere = getIntent();

        noteidhere = intenthere.getIntExtra("notesid",-1);

        if(noteidhere != -1) {

            editText.setText(MainActivity.notes.get(noteidhere));


        }
        else {


            MainActivity.notes.add("");

            noteidhere = MainActivity.notes.size()-1;

            MainActivity.arrayAdapter.notifyDataSetChanged();






        }

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                MainActivity.notes.set(noteidhere,String.valueOf(charSequence));

                MainActivity.arrayAdapter.notifyDataSetChanged();

                SharedPreferences sharedPreferences = getSharedPreferences("learning.rohitdanda.notes", Context.MODE_PRIVATE);

                HashSet<String> set = new HashSet<String>(MainActivity.notes);

                sharedPreferences.edit().putStringSet("notes",set).apply();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



    }
}
