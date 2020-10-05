package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    private EditText editUrlWeb;
    private EditText editLocation;
    private EditText editShareText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editUrlWeb = findViewById(R.id.website_edittext);
        editLocation = findViewById(R.id.loc_edittext);
        editShareText = findViewById(R.id.share_edittext);
    }

    public void openWebsite(View view) {
        String url = editUrlWeb.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
        else {
            Log.d("ImplicitIntent","Can't handle this intent!" );

        }
    }
    public void openLocation(View view) {
        String location = editLocation.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + location);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
        else {
            Log.d("ImplicitIntent","Can't handle this intent!" );

        }
    }

    public void shareText(View view) {
        String shareText = editShareText.getText().toString();
        ShareCompat.IntentBuilder
                .from(this)
                .setChooserTitle("Share Text with:")
                .setText(shareText)
                .setType("text/plain")
                .startChooser();
    }
}