 import React, { Component } from 'react';
 import {
   StyleSheet,
   Text,
   View,
   Button
 } from 'react-native';

import {
  AndroidDemoToastModule,
  AndroidVideoPickerModule,
  Log,
  DemoPickerView
} from '../../NativeModules/Android/index';

export default class VideoPickerScreen extends Component{
  static navigationOptions = {
    title: 'PickerView',
  };

  constructor(){
    super();
    this._onChange=this._onChange.bind(this);
  }

  _onChange(event: Event){
    console.log(event.nativeEvent);
    AndroidDemoToastModule.show(JSON.stringify(event.nativeEvent), AndroidDemoToastModule.SHORT);
  }

  render() {
    return (
      <View style={{flex:1,backgroundColor:'#fa3'}}>
        <Text>
          Below Yellow Frame is embedded video editor lib view
        </Text>
        <DemoPickerView
          stock={JSON.stringify({id:123})}
          style={{flex:1,  backgroundColor:'#0af'}}
          onChange={this._onChange}
        />
      </View>
    )
  }
}
