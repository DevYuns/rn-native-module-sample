import {
  type StyleProp,
  type ViewStyle,
  requireNativeComponent,
  NativeSyntheticEvent,
} from 'react-native';

type SampleNativeViewProps = {
  myColor: string;
  style: StyleProp<ViewStyle>;
  onUpdate: (e: NativeSyntheticEvent<{isPressed: boolean}>) => void;
};

const component =
  requireNativeComponent<SampleNativeViewProps>('SampleComponent');

export default component;
