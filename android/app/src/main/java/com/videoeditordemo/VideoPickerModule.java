package com.videoeditordemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.embeddedlibrary.VideoEditorActivity;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Created by manleung on 15/6/2017.
 */

public class VideoPickerModule extends ReactContextBaseJavaModule {

    private static final int IMAGE_PICKER_REQUEST = 111;
    private static final String PICKER_CANCELLED = "E_PICKER_CANCELLED";
    private static final String E_FAILED_TO_SHOW_PICKER = "E_FAILED_TO_SHOW_PICKER";
    private static final String E_ACTIVITY_DOES_NOT_EXIST = "E_ACTIVITY_DOES_NOT_EXIST";
    private static final String TAG = "VideoPickerModule";

    private Promise mPickerPromise;
    private final ActivityEventListener mActivityEventListener = new BaseActivityEventListener() {

        @Override
        public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent intent) {
            Log.d(TAG, "onActivityResult: " + requestCode);
            if (requestCode == IMAGE_PICKER_REQUEST) {
                if (mPickerPromise != null) {
                    if (resultCode == Activity.RESULT_CANCELED) {
                        mPickerPromise.reject(PICKER_CANCELLED, "Video picker was cancelled");
                    } else if (resultCode == Activity.RESULT_OK) {
                        //Return the Uri from Lib
                        Uri uri = intent.getData();

                        //Return the url from Lib
                        String url = intent.getStringExtra("key");

                        //Return a Bundle of key/values from Lib
                        Bundle bundle = intent.getExtras();

                        mPickerPromise.resolve(url);
                    }
                    else{
                        mPickerPromise.reject(PICKER_CANCELLED, "Video picker was cancelled");
                    }
                    mPickerPromise = null;
                }
            }
        }
    };

    public VideoPickerModule(ReactApplicationContext context){
        super(context);
        context.addActivityEventListener(mActivityEventListener);
    }

    @Override
    public String getName() {
        return "AndroidVideoPickerModule";
    }

    @ReactMethod
    public void pickNEditVideoAsActivity(final Promise promise) {
        Activity currentActivity = getCurrentActivity();

        if (currentActivity == null) {
            promise.reject(E_ACTIVITY_DOES_NOT_EXIST, "Activity doesn't exist");
            return;
        }

        // Store the promise to resolve/reject when picker returns data
        mPickerPromise = promise;

        try {
            final Intent launchLibIntent = new Intent(currentActivity, VideoEditorActivity.class);
            currentActivity.startActivityForResult(launchLibIntent, IMAGE_PICKER_REQUEST);
        } catch (Exception e) {
            mPickerPromise.reject(E_FAILED_TO_SHOW_PICKER, e);
            mPickerPromise = null;
        }
    }
}
