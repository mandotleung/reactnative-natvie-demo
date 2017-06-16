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
  render() {
    return (
      <View style={{flex:1,backgroundColor:'#fa3'}}>
        <Text>
          Below Yellow Frame is embedded video editor lib view
        </Text>
        <DemoPickerView style={{flex:1,  backgroundColor:'#0af'}} />
      </View>
    )
  }
}
