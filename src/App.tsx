import React, {useEffect, useState} from 'react';
import {StyleSheet, Text, View} from 'react-native';

import Sample from './modules/Sample';

const App = () => {
  const [date, setDate] = useState('');
  const [seconds, setSeconds] = useState(0);

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
