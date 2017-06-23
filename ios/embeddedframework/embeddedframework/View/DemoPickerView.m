//
//  DemoPickerView.m
//  VideoEditorDemo
//
//  Created by Man Leung on 22/6/2017.
//  Copyright © 2017 Facebook. All rights reserved.
//

#import "DemoPickerView.h"

@implementation DemoPickerView

/*
// Only override drawRect: if you perform custom drawing.
// An empty implementation adversely affects performance during animation.
- (void)drawRect:(CGRect)rect {
    // Drawing code
}
*/


- (id)initWithFrame:(CGRect)frame
{
    self = [super initWithFrame:frame];
    
    if (self) {
        
//        self = [[NSBundle bundleForClass:self.class] loadNibNamed:@"DemoPickerView" owner:self options:nil] objectAtIndex:0];

//        self = [[NSBundle mainBundle] loadNibNamed:@"DemoPickerView"
//                                                          owner:self
//                                                        options:nil];
        
        self = [[[NSBundle bundleWithIdentifier:@"com.embeddedframework"] loadNibNamed:@"DemoPickerView"
                                                                                 owner:self options:nil] objectAtIndex:0];
        
        [self setFrame:frame];
    }
    return self;
}

-(void) setStockInfo:(NSDictionary*)stockInfo{
    NSLog(@"%@", stockInfo);
}

- (IBAction)onButtonClick:(id)sender {
    NSLog(@"%@", self.onChange);
    if(self.onChange)
        self.onChange(@{@"key":@"123"});
//    if([self.delegate respondsToSelector:@selector(onVideoPathSelect:withData:)])
//        [self.delegate onVideoPathSelect:self withData:@{@"key":@"123"}];
}

@end
