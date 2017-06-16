import { NativeModules } from 'react-native';

import { DemoPickerView } from './PickerView'

module.exports.AndroidDemoToastModule = NativeModules.AndroidDemoToastModule;
module.exports.AndroidVideoPickerModule = NativeModules.AndroidVideoPickerModule;
module.exports.Log = NativeModules.AndroidNativeModule;

module.exports.DemoPickerView = DemoPickerView;
