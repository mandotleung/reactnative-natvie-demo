import { DemoPickerView } from './PickerView'
import { NativeModules, NativeEventEmitter } from 'react-native';

module.exports.VideoPickerManager = NativeModules.VDDemoPickerVCManager;
// module.exports.VideoPickerManagerEmitter = new NativeEventEmitter(NativeModules.VDDemoPickerVCManager);

module.exports.DemoPickerView = DemoPickerView;
