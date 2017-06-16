//flow

import { PropTypes } from 'react';
import { requireNativeComponent, View } from 'react-native';

var iface = {
  name: 'DemoPickerView',
  propTypes: {
    //stock: PropTypes.object
    ...View.propTypes // include the default view properties
  },
};

module.exports.DemoPickerView = requireNativeComponent('DemoPickerView', iface);
