import {NativeSyntheticEvent, StyleSheet, Text, View} from 'react-native';
import React, {useEffect, useState} from 'react';

import Sample from './modules/Sample';
import SampleComponent from './components/SampleNativeComp';

const App = () => {
  const [date, setDate] = useState('');
  const [seconds, setSeconds] = useState(0);
  const [color, setColor] = useState('red');

  const onUpdate = (e: NativeSyntheticEvent<{isPressed: boolean}>) => {
    if (e.nativeEvent.isPressed) {
      setColor(color === 'red' ? 'blue' : 'red');
    }
  };

  useEffect(() => {
    Sample.getCurrentTime().then((time: string) => {
      setDate(new Date(time).toDateString());
    });

    Sample.getCurrentTimeEvents(setSeconds);
    Sample.dispatchEventEverySecond();
  }, []);

  return (
    <View style={styles.container}>
      <Text>Sample Native module</Text>
      <Text>{date}</Text>
      <Text>The Seconds count is: {seconds}</Text>
      <SampleComponent
        myColor={color}
        style={{height: 75, width: 500}}
        onUpdate={onUpdate}
      />
    </View>
  );
};

export default App;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignSelf: 'stretch',
    justifyContent: 'center',
    alignItems: 'center',
  },
});
