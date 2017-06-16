package com.videoeditordemo.View;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.videoeditordemo.R;

import org.json.JSONObject;

/**
 * Created by manleung on 16/6/2017.
 */

public class DemoPickerView extends FrameLayout {

    private static final String TAG = "DemoPickerView";

    public DemoPickerView(Context context) {
        super(context);
        init();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //Log.d(TAG, "onLayout getChildCount: " + getChildCount());
        //Log.d(TAG, "onLayout changed:" + changed + " l:" + l + " t:" + t + " r:" + r + " b:" + b);
        super.onLayout(changed, l, t, r, b);
    }

    private void init() {
        Log.d(TAG, "init getChildCount: " + getChildCount());
        inflate(getContext(), R.layout.layout_video_editor_2, this);
        //LayoutInflater.from(getContext()).inflate(R.layout.layout_video_editor, this, true);
    }

    public void setStockInfo(@Nullable JSONObject stockInfo){

    }

    public void onReceiveNativeEvent() {
        WritableMap event = Arguments.createMap();
        event.putString("message", "MyMessage");
        ReactContext reactContext = (ReactContext)getContext();
        reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
                getId(),
                "topChange",
                event);
    }
}
