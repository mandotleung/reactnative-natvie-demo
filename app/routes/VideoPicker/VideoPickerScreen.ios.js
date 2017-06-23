/* @flow */

 import React, { Component } from 'react';
 import {
   StyleSheet,
   Text,
   View,
   Button,
   Alert
 } from 'react-native';

import { Platform } from 'react-native';

import {
  DemoPickerView
} from '../../NativeModules/iOS/index';

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
    this.setState({
      isEditorLaunch: false,
      videoPath: event.nativeEvent,
    });
    Alert.alert(
      '',
      JSON.stringify(event.nativeEvent),
      [
        {text: 'OK', onPress: () => {}},
      ]
    )
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
      console.log('ios');
      view =
        <View style={{flex:1}}>
          <Text>
            Below Yellow Frame is embedded video editor lib view
          </Text>
          <DemoPickerView
            stockInfo={{id:123}}
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

VideoPickerScreen.propTypes = {
  /**
   * Callback that is called continuously when the user is dragging the map.
   */
  onChange: React.PropTypes.func,
};
