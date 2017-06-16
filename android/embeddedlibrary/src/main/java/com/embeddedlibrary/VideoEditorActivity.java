package com.embeddedlibrary;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class VideoEditorActivity extends AppCompatActivity {

    private static final int IMAGE_PICKER_REQUEST = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_editor);

        ((Button)findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("key",((EditText)findViewById(R.id.editText)).getText().toString());
                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });
    }
}
