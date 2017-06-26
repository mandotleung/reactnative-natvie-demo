//
//  VDDemoPickerViewController.m
//  embeddedframework
//
//  Created by Man Leung on 26/6/2017.
//
//

#import "VDDemoPickerViewController.h"

@interface VDDemoPickerViewController ()

@end

@implementation VDDemoPickerViewController

- (instancetype)init{
    if(self){
        self = [self initWithNibName:@"VDDemoPickerViewController" bundle:[NSBundle bundleWithIdentifier:@"com.embeddedframework"]];
    }
    return self;
}

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view from its nib.
    self.navigationController.navigationBar.hidden = false;
    
    //NSLog(@"%@", self.navigationController.topLayoutGuide);
    [self.view addConstraint: [NSLayoutConstraint constraintWithItem:self.pathTextField
                                                           attribute:NSLayoutAttributeTop
                                                           relatedBy:NSLayoutRelationEqual
                                                              toItem:self.topLayoutGuide
                                                           attribute:NSLayoutAttributeBottom
                                                          multiplier:1.0
                                                            constant:20.0]];
}

- (void) viewWillDisappear:(BOOL)animated{
    self.navigationController.navigationBar.hidden = true;
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)onReturnClick:(id)sender {
    [[NSNotificationCenter defaultCenter] postNotificationName:@"VideoPick" object:self userInfo:@{@"key":self.pathTextField.text}];
    [self.navigationController popViewControllerAnimated:YES];
}

/*
 #pragma mark - Navigation
 
 // In a storyboard-based application, you will often want to do a little preparation before navigation
 - (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
 // Get the new view controller using [segue destinationViewController].
 // Pass the selected object to the new view controller.
 }
 */
@end
