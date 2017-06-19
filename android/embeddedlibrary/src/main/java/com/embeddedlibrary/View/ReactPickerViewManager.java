package com.embeddedlibrary.View;

import android.support.annotation.Nullable;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.embeddedlibrary.View.DemoPickerView;
import com.facebook.react.uimanager.annotations.ReactProp;

import org.json.JSONObject;

/**
 * Created by manleung on 16/6/2017.
 */

public class ReactPickerViewManager extends ViewGroupManager<DemoPickerView> {
    public static final String REACT_CLASS = "DemoPickerView";
    private static final String TAG = "ReactPickerViewManager";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public DemoPickerView createViewInstance(ThemedReactContext context) {
        DemoPickerView v = new DemoPickerView(context);
        //LayoutInflater.from(context).inflate(R.layout.layout_video_editor_2, null, false);
        //Log.d(TAG, "createViewInstance: ");
        return v;

    }

    @ReactProp(name = "stock")
    public void setStockInfo(DemoPickerView view, @Nullable String stockInfo) {
        view.setStockInfo(stockInfo);
    }
}
