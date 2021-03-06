//
//  VDVideoPickerManager.m
//  VideoEditorDemo
//
//  Created by Man Leung on 23/6/2017.
//  Copyright © 2017 Facebook. All rights reserved.
//

#import "VDDemoPickerVCManager.h"

#import "AppDelegate.h"
#import <embeddedframework/embeddedframework.h>

@implementation VDDemoPickerVCManager

RCT_EXPORT_MODULE();

- (NSArray<NSString *> *)supportedEvents
{
  return @[@"VideoPick", @"memoryWarning"];
}

RCT_EXPORT_METHOD(launchVideoEditor:(RCTResponseSenderBlock)callback)
{
  // There are two ways to push native vc
  // no matter with way, dispatch to main thread is required. RN use the JS thread other than main thread/bg thread
  dispatch_sync(dispatch_get_main_queue(), ^{
    // 1. post notification to app delegate
    //[[NSNotificationCenter defaultCenter] postNotificationName:@"LaunchVideoPicker" object:self];
    
    // 2. access the app delegate root vc(UINavigationController) and push vc
    AppDelegate *share = (AppDelegate *)[UIApplication sharedApplication].delegate;
    UINavigationController *nav = (UINavigationController *) share.window.rootViewController;
    
    VDDemoPickerViewController* controller = [[VDDemoPickerViewController alloc]
                                              initWithCallBack:^(NSArray* data){
                                                callback(data);
                                              }];
    [nav pushViewController:controller animated:YES];
  });
}

//- (void)startObserving
//{
//    [[NSNotificationCenter defaultCenter] addObserver:self
//                                             selector:@selector(VideoPickReceived:)
//                                                 name:@"VideoPick"
//                                               object:nil];
//  
//    [[NSNotificationCenter defaultCenter] addObserver:self
//                                           selector:@selector(handleMemoryWarning)
//                                               name:UIApplicationDidReceiveMemoryWarningNotification
//                                             object:nil];
//}
//
//- (void)stopObserving
//{
//  [[NSNotificationCenter defaultCenter] removeObserver:self];
//}
//
//- (void)handleMemoryWarning
//{
//  [self sendEventWithName:@"memoryWarning" body:nil];
//}


//- (void)VideoPickReceived:(NSNotification *)notification
//{
//  NSLog(@"VideoPickReceived");
//  //NSString *eventName = notification.userInfo[@"name"];
//  [self sendEventWithName:@"VideoPick" body:@{@"key": notification.userInfo[@"key"]}];
//}


@end
