import {Dispatch, SetStateAction} from 'react';
import {NativeEventEmitter, NativeModules} from 'react-native';

class SampleModule {
  getCurrentTime = async () => {
    return NativeModules.Sample.getCurrentTime();
  };

  dispatchEventEverySecond = () => {
    NativeModules.Sample.dispatchEventEverySecond();
  };

  getCurrentTimeEvents = (callback: Dispatch<SetStateAction<number>>): void => {
    const clockEvents = new NativeEventEmitter(NativeModules.Clock);

    clockEvents.addListener('onTimeUpdated', (time: {count: number}) => {
      callback(time.count);
    });
  };
}

export default new SampleModule();
