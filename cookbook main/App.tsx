import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import React, { Fragment } from 'react';

import Homepage from './components/home';

import Splashscreen from './splashscreen';
import Createform from './components/create';
import Recipies from './components/recipe';
import Cookrecipe from './components/cookrecipe';


function App(): React.JSX.Element {
  const Stack = createNativeStackNavigator();

  return (
    <Fragment>
      <NavigationContainer>
        <Stack.Navigator initialRouteName="splash" screenOptions={{headerShown:false}}>
        
          <Stack.Screen name="splash" component={Splashscreen} />
          <Stack.Screen name="home" component={Homepage} />
          <Stack.Screen name="create" component={Createform} />
          <Stack.Screen name="recipe" component={Recipies} />
          <Stack.Screen name="cook" component={Cookrecipe} />
        </Stack.Navigator>
      </NavigationContainer>
    </Fragment>
  );
}

export default App;
