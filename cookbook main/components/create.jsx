import React, { useState, useEffect } from "react";
import {
  Image,
  Text,
  TouchableOpacity,
  View,
  PermissionsAndroid,
  Platform,
  TextInput,
  ScrollView,
  FlatList,
  TouchableHighlight

} from "react-native";

import { launchImageLibrary } from "react-native-image-picker";
import Createstyle from "../styles/stylecreate";
import axios from 'axios';

export default function Createform({ navigation }) {
  const [imageUri, setImageUri] = useState(null);
  const [recipeName, setRecipeName] = useState('');
  const [ingredients, setIngredients] = useState('');
  const [ingredientsData, setIngredientsData] = useState([]);
  const [steps, setSteps] = useState('');
  const [stepsData, setStepsData] = useState([]);
  const [tags, setTags] = useState('');
  const [tagsData, setTagsData] = useState([]);

  const requestStoragePermission = async () => {
    if (Platform.OS === 'android') {
      try {
        const granted = await PermissionsAndroid.request(
          PermissionsAndroid.PERMISSIONS.READ_EXTERNAL_STORAGE,
          {
            title: "Storage Permission",
            message: "This app needs access to your storage to select images.",
            buttonNeutral: "Ask Me Later",
            buttonNegative: "Cancel",
            buttonPositive: "OK",
          }
        );
        return granted === PermissionsAndroid.RESULTS.GRANTED;
      } catch (err) {
        console.warn(err);
        return false;
      }
    } else {
      return true;
    }
  };

  const handleImagePicker = async () => {
    const hasPermission = await requestStoragePermission();
    if (!hasPermission) {
      console.warn("Storage permission denied");
      return;
    }

    const options = {
      mediaType: 'photo',
      quality: 1,
    };

    launchImageLibrary(options, (response) => {
      if (response.didCancel) {
        console.warn("User cancelled image picker");
      } else if (response.errorCode) {
        console.error("Image Picker Error: ", response.errorMessage);
      } else if (response.assets && response.assets.length > 0) {
        const uri = response.assets[0]?.uri;
        setImageUri(uri);
        navigation.navigate('create', { imageUri: uri })
      }
    });
  };

  const setInput = (text) => {
    setIngredients(text);
  };

  const setInput2 = (text) => {
    setSteps(text);
  };

  const setInput3 = (text) => {
    setTags(text);
  };

  const addData = () => {
    if (ingredients) {
      setIngredientsData([...ingredientsData, ingredients]);
      setIngredients('');
    }
    if (steps) {
      setStepsData([...stepsData, steps]);
      setSteps('');
    }
    if (tags) {
      setTagsData([...tagsData, tags]);
      setTags('');
    }
  };

  const submitRecipe = async () => {
    const recipeData = {
      photo_url: imageUri, 
      title: recipeName, 
      ingredients: ingredientsData,
      steps: stepsData, 
      tags: tagsData, 
    };

    console.warn('Submitting Recipe:', recipeData);

    try {
      const response = await axios.post('http://10.0.2.2:8080/recipes', recipeData);
      console.warn('Recipe submitted:', response.data);
      navigation.navigate('home');
    } catch (error) {
      console.error('Error submitting recipe:', error.response?.data || error.message);
    }
  };

  useEffect(() => {
    const imageUriFromParams = navigation.getState().routes[navigation.getState().index].params?.imageUri;
    if (imageUriFromParams) {
      setImageUri(imageUriFromParams);
    }
  }, [navigation]);

  return (
    <View style={Createstyle.bodyform}>
      <ScrollView>
        <View style={Createstyle.createheadingcontainer}>
          <TouchableOpacity onPress={() => navigation.navigate("home")}>
            <Image
              style={Createstyle.backimg}
              source={require("../asssets/backicon.png")}
            />
          </TouchableOpacity>
          <Text style={Createstyle.create}>Create</Text>
        </View>
        <View style={Createstyle.Form}>
          <Text style={Createstyle.imagename}>Image & name</Text>
          <View style={Createstyle.imagebox}>
            {imageUri ? (
              <Image
                source={{ uri: imageUri }}
                style={Createstyle.addimage}
              />
            ) : (
              <TouchableOpacity onPress={handleImagePicker}>
                <Image
                  style={Createstyle.addimage}
                  source={require("../asssets/addbutton.png")}
                />
              </TouchableOpacity>
            )}
          </View>
          <TextInput
            placeholderTextColor="#AEAEAE"
            placeholder="Recipe name"
            keyboardType="default"
            style={Createstyle.namebox}
            value={recipeName}
            onChangeText={setRecipeName} 
          />
          <Text style={Createstyle.iingredients}>Ingredients</Text>

          <View style={Createstyle.ingredientslist}>
            <FlatList
              style={{ marginTop: 15 }}
              data={ingredientsData}
              numColumns={1}
              keyExtractor={(item, index) => index.toString()}
              renderItem={({ item }) => (
                <View style={Createstyle.ingredientdsaddbutton}>
                  <Text style={Createstyle.ingredientitem}>{item}</Text>
                </View>
              )}
            />
            <TextInput
              placeholderTextColor="#AEAEAE"
              placeholder="Ingredient name"
              style={Createstyle.ingredientdsaddbutton}
              keyboardType="default"
              value={ingredients}
              onChangeText={setInput}
            />
            <TouchableOpacity onPress={addData}>
              <View style={Createstyle.ingredientdsaddbutton}>
                <Image
                  source={require("../asssets/addexsmall.png")}
                  style={Createstyle.adding}
                />
              </View>
            </TouchableOpacity>
          </View>

          <Text style={Createstyle.iingredients}>Recipe Steps</Text>
          <View style={Createstyle.ingredientslist}>
            <FlatList
              style={{ marginTop: 15 }}
              data={stepsData}
              numColumns={1}
              keyExtractor={(item, index) => index.toString()}
              renderItem={({ item }) => (
                <View style={Createstyle.ingredientdsaddbutton}>
                  <Text style={Createstyle.ingredientitem}>{item}</Text>
                </View>
              )}
            />
            <TextInput
              placeholderTextColor="#AEAEAE"
              placeholder="Step"
              style={Createstyle.ingredientdsaddbutton}
              keyboardType="default"
              value={steps}
              onChangeText={setInput2}
            />
            <TouchableHighlight onPress={addData}>
              <View style={Createstyle.ingredientdsaddbutton}>
                <Image
                  source={require("../asssets/addexsmall.png")}
                  style={Createstyle.adding}
                />
              </View>
            </TouchableHighlight>
          </View>

          <Text style={Createstyle.iingredients}>Tags</Text>
          <View style={Createstyle.ingredientslist}>
            <FlatList
              style={{ marginTop: 15 }}
              data={tagsData}
              numColumns={1}
              keyExtractor={(item, index) => index.toString()}
              renderItem={({ item }) => (
                <View style={Createstyle.ingredientdsaddbutton}>
                  <Text style={Createstyle.ingredientitem}>{item}</Text>
                </View>
              )}
            />
            <TextInput
              placeholderTextColor="#AEAEAE"
              placeholder="Tag"
              style={Createstyle.ingredientdsaddbutton}
              keyboardType="default"
              value={tags}
              onChangeText={setInput3}
            />
            <TouchableHighlight onPress={addData}>
              <View style={Createstyle.ingredientdsaddbutton}>
                <Image
                  source={require("../asssets/addexsmall.png")}
                  style={Createstyle.adding}
                />
              </View>
            </TouchableHighlight>
          </View>
          <View style={Createstyle.submitbox}>
            <TouchableHighlight onPress={submitRecipe}>
              <View style={Createstyle.submitbutton}>
                <Text style={Createstyle.submittext}>Submit</Text>
              </View>
            </TouchableHighlight>
          </View>
        </View>
      </ScrollView>
    </View>
  );
}
