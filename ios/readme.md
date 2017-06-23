### introduction
Following this [guide](https://facebook.github.io/react-native/docs/native-components-ios.html) to build a native ui module within embedded framework. After built this sample, there is one things need to be noted.

#### guide
https://facebook.github.io/react-native/docs/native-components-ios.html

To control the view property form JS to native, use 
```
RCT_EXPORT_VIEW_PROPERTY
RCT_CUSTOM_VIEW_PROPERTY
```

To deal with events from the native module, use 
```
RCT_EXPORT_VIEW_PROPERTY(onChange, RCTBubblingEventBlock)
```

Add below line into the custom view
```
@property (nonatomic, copy) RCTBubblingEventBlock onChange;
```
which also require  
```
#import <React/RCTComponent.h>
```

Within a framework to import the header files from other framework, it need to   
"going Build Settings under "Target" and set "Allow Non-modular Includes in Framework Modules" to YES."  
from  
https://stackoverflow.com/questions/27776497/include-of-non-modular-header-inside-framework-module

