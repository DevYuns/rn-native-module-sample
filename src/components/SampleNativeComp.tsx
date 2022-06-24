import {
  type StyleProp,
  type ViewStyle,
  requireNativeComponent,
} from 'react-native';

type SampleNativeViewProps = {
  myColor: string;
  style: StyleProp<ViewStyle>;
};

const component =
  requireNativeComponent<SampleNativeViewProps>('SampleComponent');

export default component;
