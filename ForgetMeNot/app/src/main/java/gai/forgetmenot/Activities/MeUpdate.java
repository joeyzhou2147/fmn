package gai.forgetmenot.Activities;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.app.AlertDialog;
import android.database.Cursor;
//import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.Toast;

import gai.forgetmenot.R;

public class MeUpdate extends AppCompatActivity {
    MeHelper myDb;
    EditText editName, editDob, editHome;
    String userId;
    Button btnAddData;
    Button btnviewAll;
    Button btnDelete;

    Button btnviewUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_display_message);
        myDb = new MeHelper(this);
        editName = (EditText) findViewById(R.id.editText_name);
        editDob = (EditText) findViewById(R.id.editText_dob);
        editHome = (EditText) findViewById(R.id.editText_home);
        btnAddData = (Button) findViewById(R.id.button_add);
        btnviewAll = (Button) findViewById(R.id.button_viewAll);
        btnviewUpdate = (Button) findViewById(R.id.button_update);
        btnDelete = (Button) findViewById(R.id.button_delete);
        AddData();
        viewAll();
        UpdateData();
        //DeleteData();

        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_display_message);
    }

    /*public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(editTextId.getText().toString());
                        if (deletedRows > 0)
                            Toast.makeText(MeUpdate.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MeUpdate.this, "Data not Deleted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }*/

    public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(userId, editName.getText().toString(),
                                editDob.getText().toString(),editHome.getText().toString());
                        if (isUpdate == true)
                            Toast.makeText(MeUpdate.this, "Data Update", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MeUpdate.this, "Data not Updated", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(userId, editName.getText().toString(),
                                editDob.getText().toString(),editHome.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(MeUpdate.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MeUpdate.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if (res.getCount() == 0) {
                            // show message
                            showMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :" + res.getString(0) + "\n");
                            buffer.append("Name :" + res.getString(1) + "\n");
                            buffer.append("Date of Birth :" + res.getString(2) + "\n");
                            buffer.append("Home Address :" + res.getString(3) + "\n\n");
                        }

                        // Show all data
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/


    public static final String EXTRA_MESSAGE = "gai.forgetmenot.Activities.MeActivity.MESSAGE";

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
    }*/

    /**
     * Called when the user taps the Send button
     */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, MeActivity.class);

        EditText et_name = (EditText) findViewById(R.id.editText_name);
        EditText et_dob = (EditText) findViewById(R.id.editText_dob);
        EditText et_home = (EditText) findViewById(R.id.editText_home);

        String name = et_name.getText().toString();
        String dob = et_dob.getText().toString();
        String home = et_home.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, name);
        intent.putExtra("dob", dob);
        intent.putExtra("home", home);

        startActivity(intent);
    }
}