import { DemoPickerView } from './PickerView'
import { NativeModules, NativeEventEmitter } from 'react-native';

module.exports.VideoPickerManager = NativeModules.VDVideoPickerManager;
module.exports.VideoPickerManagerEmitter = new NativeEventEmitter(NativeModules.VDVideoPickerManager);

module.exports.DemoPickerView = DemoPickerView;
