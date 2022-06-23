import {NativeModules} from 'react-native';

class SampleModule {
  getCurrentTime = async () => {
    return NativeModules.Sample.getCurrentTime();
  };
}

export default new SampleModule();
