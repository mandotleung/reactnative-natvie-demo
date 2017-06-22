/* @flow */

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
      this._onChange = this._onChange.bind(this);
      this.launchEditor = this.launchEditor.bind(this);

      this.state = {
        isEditorLaunch : false,
      }
    }

  _onChange(event: Event){
    AndroidDemoToastModule.show(JSON.stringify(event.nativeEvent), AndroidDemoToastModule.SHORT);
    this.setState({
      isEditorLaunch: false,
      videoPath: event.nativeEvent,
    });
  }

  launchEditor = () => {
      this.setState({isEditorLaunch: true});
  }

  render() {
    console.log(this.state);
    let view =
    <View style={{flex:1}}>
      <Button title='Open Video Editor Lib as View'
        onPress={()=>{
          this.launchEditor();
        }}
      />
    </View>;

    if(this.state.isEditorLaunch)
    {
      view =
        <View style={{flex:1}}>
          <Text>
            Below Yellow Frame is embedded video editor lib view
          </Text>
          <DemoPickerView
            stock={JSON.stringify({id:123})}
            style={{flex:1, backgroundColor:'#ff0'}}
            onChange={this._onChange}
          />
        </View>;
    }

    return (
      <View style={{flex:1,backgroundColor:'#fa3'}}>
        {view}
      </View>
    )
  }
}
