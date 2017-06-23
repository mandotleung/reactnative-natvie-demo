//
//  RNTPickerViewManager.m
//  VideoEditorDemo
//
//  Created by Man Leung on 22/6/2017.
//  Copyright © 2017 Facebook. All rights reserved.
//

#import "RNTPickerViewManager.h"
#import <React/RCTComponent.h>


@implementation RNTPickerViewManager

RCT_EXPORT_MODULE()

- (UIView *)view
{
  DemoPickerView* pickerView = [[DemoPickerView alloc] init];
//  pickerView.delegate = self;
  
  return pickerView;
}

RCT_EXPORT_VIEW_PROPERTY(onChange, RCTBubblingEventBlock)

RCT_CUSTOM_VIEW_PROPERTY(stockInfo, NSDictionary, DemoPickerView)
{
  [view setStockInfo: json];
}

//-(void) onVideoPathSelect:(DemoPickerView *) pickerView withData:(NSDictionary*) videoPath{
//  pickerView.onChange(videoPath);
//  NSLog(@"%@", videoPath);
//}

@end
