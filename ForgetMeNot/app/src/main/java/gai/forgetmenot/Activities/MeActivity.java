package gai.forgetmenot.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.Toast;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import gai.forgetmenot.Helpers.MeUpdate;
import gai.forgetmenot.R;

public class MeActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "gai.forgetmenot.me.MESSAGE";
    public static final int PICK_IMAGE = 1;
    private static int RESULT_LOAD_IMG = 1;
    String imgDecodableString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_main);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MeUpdate.EXTRA_MESSAGE);
        String name = intent.getStringExtra("name");
        String dob = intent.getStringExtra("dob");
        String home = intent.getStringExtra("home");

        // Capture the layout's TextView and set the string as its text
        TextView tv_name = findViewById(R.id.name);
        TextView tv_dob = findViewById(R.id.dob);
        TextView tv_home = findViewById(R.id.home);

        tv_name.setText(message);
        tv_dob.setText(dob);
        tv_home.setText(home);
    }

    public void EditPage(View view) {
        Intent intent = new Intent(MeActivity.this, MeUpdate.class);
        startActivity(intent);
    }

    public void loadImagefromGallery(View view) {
        // Create intent to Open Image applications like Gallery, Google Photos
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        // Start the Intent
        startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK && null != data) {
                // Get the Image from data
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();
                ImageView imgView = (ImageView) findViewById(R.id.profileImage);
                // Set the Image in ImageView after decoding the String
                imgView.setImageBitmap(BitmapFactory.decodeFile(imgDecodableString));
            } else {
                Toast.makeText(this, "You haven't picked Image", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }
    }


}
