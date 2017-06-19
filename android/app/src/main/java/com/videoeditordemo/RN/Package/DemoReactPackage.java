package com.videoeditordemo.RN.Package;

import com.embeddedlibrary.View.ReactPickerViewManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.videoeditordemo.RN.Module.DemoToastModule;
import com.videoeditordemo.RN.Module.NativeLogModule;
import com.videoeditordemo.RN.Module.VideoPickerModule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by manleung on 15/6/2017.
 */

public class DemoReactPackage implements ReactPackage {
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> nativeModules = new ArrayList<>();
        nativeModules.add(new DemoToastModule(reactContext));
        nativeModules.add(new NativeLogModule(reactContext));
        nativeModules.add(new VideoPickerModule(reactContext));
        return nativeModules;
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Arrays.<ViewManager>asList(
                new ReactPickerViewManager()
        );
    }
}
