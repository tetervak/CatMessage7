package ca.javateacher.catmessage7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends CatActivity {

    private CheckBox mUrgentCheckBox;
    private RadioGroup mMessageGroup;

    private SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // lookup the views
        mUrgentCheckBox = findViewById(R.id.urgent_check_box);
        mMessageGroup = findViewById(R.id.message_group);

        // make the button work
        Button sendButton = findViewById(R.id.send_button);
        sendButton.setOnClickListener(v -> showOutput());

        // lookup the preferences object
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    private void showOutput() {
        // get urgent flag value
        boolean urgent = mUrgentCheckBox.isChecked();
        // get the selected message text
        String message;
        switch (mMessageGroup.getCheckedRadioButtonId()) {
            case R.id.purr_button:
                message = getString(R.string.cat_purr);
                break;
            case R.id.mew_button:
                message = getString(R.string.cat_mew);
                break;
            case R.id.hiss_button:
                message = getString(R.string.cat_hiss);
                break;
            default:
                message = getString(R.string.undefined);
        }
        // open the activity, showing the message
        Intent intent = new Intent(this, OutputActivity.class);
        intent.putExtra(IS_URGENT_KEY, urgent);
        intent.putExtra(MESSAGE_TEXT_KEY, message);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        boolean urgent = mPreferences.getBoolean("urgent", false);
        mUrgentCheckBox.setChecked(urgent);
        String message = mPreferences.getString("message_text","purr");
        switch(message){
            case "purr":{
                mMessageGroup.check(R.id.purr_button);
                break;
            }
            case "mew":{
                mMessageGroup.check(R.id.mew_button);
                break;
            }
            case "hiss":{
                mMessageGroup.check(R.id.hiss_button);
                break;
            }
        }
    }
}
