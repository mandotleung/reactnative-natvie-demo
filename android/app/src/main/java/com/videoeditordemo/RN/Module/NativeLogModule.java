package com.videoeditordemo.RN.Module;

import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Created by manleung on 16/6/2017.
 */

public class NativeLogModule extends ReactContextBaseJavaModule {
    public NativeLogModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "AndroidNativeModule";
    }

    @ReactMethod
    public void w(String tag, String message){
        Log.w(tag, message);
    }

    @ReactMethod
    public void d(String tag, String message){
        Log.d(tag, message);
    }

    @ReactMethod
    public void i(String tag, String message){
        Log.i(tag, message);
    }

    @ReactMethod
    public void e(String tag, String message){
        Log.e(tag, message);
    }

    @ReactMethod
    public void v(String tag, String message){
        Log.v(tag, message);
    }
}
