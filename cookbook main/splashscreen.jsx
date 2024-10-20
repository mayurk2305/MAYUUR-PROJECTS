import React, { useEffect } from "react";
import { View, StyleSheet } from "react-native";
import Video from "react-native-video"; 

export default function Splashscreen({ navigation }) {
  useEffect(() => {
    const timeout = setTimeout(() => {
      navigation.navigate('home');
    }, 5000);
    return () => clearTimeout(timeout);
  }, [navigation]);

  return (
    <View style={styles.container}>
      <Video
        source={require('../cookbook/asssets/spalshscreen.mp4')}
        style={styles.video}
        resizeMode="cover"
        onEnd={() => navigation.navigate('home')} 
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "white",
  },
  video: {
    width: "100%",
    height: "100%",
  },
});
