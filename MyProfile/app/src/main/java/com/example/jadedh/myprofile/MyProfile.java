package com.example.jadedh.myprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.Toast;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;



import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class MyProfile extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myprofile.MESSAGE";
    public static final int PICK_IMAGE = 1;
    private static int RESULT_LOAD_IMG = 1;
    String imgDecodableString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(DisplayMessageActivity.EXTRA_MESSAGE);
        String bloodgroup= intent.getStringExtra("bloodgroup");
        String education= intent.getStringExtra("education");
        String work= intent.getStringExtra("work");
        String mobile= intent.getStringExtra("mobile");
        String gender= intent.getStringExtra("gender");
        String marriage= intent.getStringExtra("marriage");
        String dob= intent.getStringExtra("dob");
        String email= intent.getStringExtra("email");

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.name);
        TextView tv_bloodGroup = findViewById(R.id.blood_group);
        TextView tv_education = findViewById(R.id.education);
        TextView tv_work = findViewById(R.id.occupation);
        TextView tv_mobile = findViewById(R.id.mobileNumber);
        TextView tv_gender = findViewById(R.id.gender);
        TextView tv_marriage = findViewById(R.id.marriage);
        TextView tv_dob = findViewById(R.id.dob);
        TextView tv_email = findViewById(R.id.email);

        textView.setText(message);
        tv_bloodGroup.setText(bloodgroup);
        tv_education.setText(education);
        tv_work.setText(work);
        tv_mobile.setText(mobile);
        tv_gender.setText(gender);
        tv_marriage.setText(marriage);
        tv_dob.setText(dob);
        tv_email.setText(email);

    }

    public void EditPage(View view)
    {
        Intent intent = new Intent(MyProfile.this, DisplayMessageActivity.class);
        startActivity(intent);
    }

    public void loadImagefromGallery(View view) {
        // Create intent to Open Image applications like Gallery, Google Photos
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        // Start the Intent
        startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK && null != data) {
                // Get the Image from data
                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };
                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();
                ImageView imgView = (ImageView) findViewById(R.id.imgView);
                // Set the Image in ImageView after decoding the String
                imgView.setImageBitmap(BitmapFactory.decodeFile(imgDecodableString));
            } else {
                Toast.makeText(this, "You haven't picked Image",Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }
    }



}
