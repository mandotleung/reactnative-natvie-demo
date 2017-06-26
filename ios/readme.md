## Note for iOS sample
There are two type of implementation on iOS.  
1. Native UI Module and View (Recommended)  
2. Native Module and ViewController 

### Important notes
- **This is not allow the navigation like Page A(RN) > Page B(native) > Page C(RN).  The native view controller(s) must be the bottom leaf(s) of navigation stack and RN always is the root.**   

- **The callback block is the only way return data to RN no matter how many viewcontrollers pushed into the navigation stack.**  

- **Refer to the guideline [here](https://facebook.github.io/react-native/docs/native-modules-ios.html#callbacks), the callback block must be invoked exactly once. If the callback is never invoked, some memory is leaked. So please refer to this sample and implement the callback when pop from the lib VC and back to main app.**  

- **If it is require more interaction between main app and the framework, option 1 is the only choice.**  

## Note for Xcode configuration
Following this [guide](https://facebook.github.io/react-native/docs/native-components-ios.html) to build a native ui module within embedded framework. After built this sample, there is one things need to be noted.
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

Within a framework to import the header files from other framework, you need to   
"going Build Settings under "Target" and set "Allow Non-modular Includes in Framework Modules" to YES."  
from  
https://stackoverflow.com/questions/27776497/include-of-non-modular-header-inside-framework-module
