package ca.javateacher.catmessage7;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class CatActivity extends AppCompatActivity {

    private static final String ABOUT_FRAGMENT_TAG = "aboutFragment";

    public static final String MESSAGE_TEXT_KEY = "message";
    public static final String IS_URGENT_KEY = "urgent";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.about:{
                showAbout();
                return true;
            }
            case R.id.settings:{
                showSettings();
                return true;
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }
    }

    protected void showSettings(){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    private void showAbout() {
        AboutFragment aboutFragment = AboutFragment.newInstance();
        aboutFragment.show(getSupportFragmentManager(), ABOUT_FRAGMENT_TAG);
    }

}
