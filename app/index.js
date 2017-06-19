/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

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
} from './NativeModules/Android/index';

import { StackNavigator } from 'react-navigation';

import { VideoPickerScreen } from './routes';

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
  button: {
    marginBottom: 15,
  },
});

class VideoEditorDemo extends Component{
  static navigationOptions = {
    title: 'VideoEditorDemo',
  };
   render() {
     const { navigate } = this.props.navigation;
     return (
       <View style={styles.container}>
         <Text style={styles.welcome}>
           Welcome to React Native!
         </Text>
         <Text style={styles.instructions}>
           To get started, edit index.android.js
           {'\n'}
           To get started, edit index.ios.js
         </Text>
         {/* <Text style={styles.instructions}>
           Android{'\n'}
           Double tap R on your keyboard to reload,{'\n'}
           Shake or press menu button for dev menu
           {'\n'}
           {'\n'}
           iOS{'\n'}
           Press Cmd+R to reload,{'\n'}
           Cmd+D or shake for dev menu
         </Text> */}
         <View  style={styles.button}>
           <Button title='RN call native module Toast'
             onPress={()=>{
               AndroidDemoToastModule.show('Awesome', AndroidDemoToastModule.SHORT);
             }}
           />
         </View>

         <View  style={styles.button}>
           <Button title='RN Launch Video Editor Lib as Activity'
             onPress={()=>{
               AndroidVideoPickerModule.pickNEditVideoAsActivity()
               .then((path) => {
                 console.log(path);
                 Log.i('index.js', path);
                 AndroidDemoToastModule.show('path: ' + path, AndroidDemoToastModule.SHORT);
               })
               .catch((err) => {
                 console.log(err);
                 Log.e('index.js', err.message);
                 AndroidDemoToastModule.show('err: ' + err, AndroidDemoToastModule.SHORT);
               })
             }}
           />
         </View>

         <View style={styles.button}>
           <Button title='RN Launch Video Editor Lib as View'
             onPress={()=>{
               navigate('VideoPickerScreen')
             }}
           />
         </View>
       </View>
     );
   }
 }

const DemoApp = StackNavigator({
  Home: { screen: VideoEditorDemo },
  VideoPickerScreen: { screen: VideoPickerScreen },
});

export default DemoApp;
