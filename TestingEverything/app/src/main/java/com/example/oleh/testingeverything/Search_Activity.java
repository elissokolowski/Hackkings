package com.example.oleh.testingeverything;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;

public class Search_Activity extends AppCompatActivity {

    ArrayList<String> selectedTags = new ArrayList<String>();
    ArrayList<TableRow> selectedRows = new ArrayList<TableRow>();
    ArrayList<TableRow> resultsRows = new ArrayList<TableRow>();
    ScrollView deleteThismotherfucker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, tags);

        final AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.countries_list);

        textView.setAdapter(adapter);

        TableRow newRow = new TableRow(this);
        final Button showButton = (Button) findViewById(R.id.search);

        final TableLayout thisLayout = (TableLayout) findViewById(R.id.activity_search_);

        textView.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){


                for(TableRow tr : resultsRows){

                    thisLayout.removeView(tr);

                }

            }

        });

        showButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                if(showButton.getText().equals("Again?")){

                    thisLayout.removeView(deleteThismotherfucker);

                    textView.setEnabled(true);
                    showButton.setText("Search");
                    selectedTags.clear();
                    selectedRows.clear();
                    resultsRows.clear();

                }
                else {
                    ScrollView view1 = new ScrollView(Search_Activity.this);
                    TableLayout table = new TableLayout(Search_Activity.this);
                    for (int i = 0; i < 20; i++) {
                        //LinearLayout table = new LinearLayout(Search_Activity.this);
                        TableRow newRow = new TableRow(Search_Activity.this);
                        TextView textView = new TextView(Search_Activity.this);
                        textView.setText("Item \nFor you: £15.00 \nFor other: £20.00");
                        TextView textView1 = new TextView(Search_Activity.this);


                        ImageView imageView = new ImageView(Search_Activity.this);
                        imageView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                        imageView.setImageResource(R.mipmap.ic_launcher);
                        //newRow.setLayoutParams(new LinearLayout.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                        //imageView.setPadding(0,0,0,0);
                        textView.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));

                        imageView.setOnClickListener(new View.OnClickListener() {

                            public void onClick(View v) {

                                Intent i = new Intent(Search_Activity.this, Item_Activity.class);

                                startActivity(i);

                            }
                        });
                        newRow.setPadding(0, 0, 0, 10);
                        textView.setPadding(10, 0, 0, 0);

                        resultsRows.add(newRow);
                        newRow.addView(imageView);
                        newRow.addView(textView);
                        table.addView(newRow);
                        //resultsRows.add(newRow);

                    }
                    for (TableRow tr : selectedRows) {

                        thisLayout.removeView(tr);

                    }

                    showButton.setText("Again?");
                    textView.setEnabled(false);

                    view1.addView(table);
                    deleteThismotherfucker = view1;
                    thisLayout.addView(view1);
                }
            }

        });

        textView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                final String selectedItem =  adapter.getItem(position).toString();

                if(!selectedTags.contains(selectedItem)) {

                    final TableRow newRow = new TableRow(Search_Activity.this);
                    final TextView newText = new TextView(Search_Activity.this);
                    TextView cancelButton = new TextView(Search_Activity.this);

                    cancelButton.setText("x");
                    newText.setText(selectedItem);
                    newRow.addView(newText);
                    newRow.addView(cancelButton);

                    cancelButton.setOnClickListener( new View.OnClickListener(){

                        public void onClick(View v){


                            for(int i = 0; i < selectedTags.size();i++){

                                if(selectedTags.get(i).equals(selectedItem)){

                                    selectedTags.remove(i);

                                }

                            }

                            thisLayout.removeView(newRow);

                        }

                    });
                    thisLayout.addView(newRow);
                    selectedRows.add(newRow);


                    newRow.setPadding(30,10,0,0);
                    newText.setTextSize(20);
                    newText.setPadding(0,0,40,0);
                    cancelButton.setTextSize(20);
                    cancelButton.setTextColor(RED);

                    selectedTags.add(selectedItem);


                }

                textView.setText("");

            }

        });


    }

    public void onClick(View v) {
        Log.d("PIZZA", "");
    }


    private static final String[] tags = new String[] {
            "watch", "coffee", "dress", "jewelry", "shoes"
    };
}
