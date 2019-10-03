package ca.javateacher.catmessage7;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

public class OutputActivity extends CatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // get and display the message data
        Intent intent = getIntent();

        boolean urgent = intent.getBooleanExtra(IS_URGENT_KEY, true);
        TextView urgentView = findViewById(R.id.is_urgent_output);
        urgentView.setText(urgent ? R.string.urgent : R.string.not_urgent);

        String message = intent.getStringExtra(MESSAGE_TEXT_KEY);
        TextView messageView = findViewById(R.id.message_text);
        messageView.setText(message);

        // make the close button work
        Button closeButton = findViewById(R.id.close_button);
        closeButton.setOnClickListener(v -> finish());
    }
}
