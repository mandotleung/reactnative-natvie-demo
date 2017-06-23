//
//  DemoPickerView.h
//  VideoEditorDemo
//
//  Created by Man Leung on 22/6/2017.
//  Copyright © 2017 Facebook. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <React/RCTComponent.h>

//@protocol DemoPickerViewDelegate;

@interface DemoPickerView : UIView

//@property (nonatomic, weak) id<DemoPickerViewDelegate> delegate;

@property (nonatomic, copy) RCTBubblingEventBlock onChange;

-(void) setStockInfo:(NSDictionary*)stockInfo;

@end

//@protocol DemoPickerViewDelegate <NSObject>
//@required
//-(void) onVideoPathSelect:(DemoPickerView *) pickerView withData:(NSDictionary*) videoPath;
//
//@end
