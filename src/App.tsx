import React, {useEffect, useState} from 'react';
import {StyleSheet, Text, View} from 'react-native';

import Sample from './modules/Sample';

const App = () => {
  const [date, setDate] = useState('');

  useEffect(() => {
    Sample.getCurrentTime().then((time: string) => {
      setDate(new Date(time).toDateString());
    });
  }, []);

  return (
    <View style={styles.container}>
      <Text>Sample Native module</Text>
      <Text>{date}</Text>
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
