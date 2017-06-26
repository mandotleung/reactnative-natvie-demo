//
//  VDDemoPickerViewController.h
//  embeddedframework
//
//  Created by Man Leung on 26/6/2017.
//
//

#import <UIKit/UIKit.h>

@interface VDDemoPickerViewController : UIViewController

@property (copy) void (^callback)(NSArray*);
@property (weak, nonatomic) IBOutlet UITextField *pathTextField;
@property (weak, nonatomic) IBOutlet UIButton *returnButton;

- (instancetype)initWithCallBack:(void(^)(NSArray*))callback;

@end
