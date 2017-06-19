package com.embeddedlibrary.View;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.embeddedlibrary.R;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by manleung on 16/6/2017.
 */

public class DemoPickerView extends LinearLayout {

    private static final String TAG = "DemoPickerView";

    private static final String EVENT_ON_VIDEO_PICKED = "EVENT_ON_VIDEO_PICKED";

    public DemoPickerView(Context context) {
        super(context);
        init();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.d(TAG, "onLayout getChildCount: " + getChildCount());
        //Log.d(TAG, "onLayout changed:" + changed + " l:" + l + " t:" + t + " r:" + r + " b:" + b);
        super.onLayout(changed, l, t, r, b);
    }

    private void init() {
        //Log.d(TAG, "init getChildCount: " + getChildCount());
        //LayoutInflater.from(getContext()).inflate(R.layout.layout_video_editor, this, true);
        inflate(getContext(), R.layout.layout_video_editor_2, this);
        setOrientation(LinearLayout.VERTICAL);

        ((Button) findViewById(R.id.button)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();
                data.putString("key",((EditText)findViewById(R.id.editText)).getText().toString());
                onReceiveNativeEvent(EVENT_ON_VIDEO_PICKED, data);
            }
        });
    }

    public void setStockInfo(@Nullable String stockInfo){
        Log.d(TAG,"setStockInfo: "+ stockInfo);
        // Gson / JSONObject
        try {
            JSONObject stockData = new JSONObject(stockInfo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void onReceiveNativeEvent(String request, Bundle data) {
        switch (request){
            case EVENT_ON_VIDEO_PICKED:{
                WritableMap event = Arguments.createMap();
                event.putString("key", data.getString("key"));
                ReactContext reactContext = (ReactContext)getContext();
                reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
                        getId(),
                        "topChange",
                        event);
            }break;
        }
    }
}
