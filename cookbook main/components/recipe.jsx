import React, { Fragment, useEffect } from "react";
import Ingredientstyle from '../styles/recipiesstyles';
import { Text, View, Image, TouchableHighlight, FlatList, TouchableOpacity } from "react-native";
import { useRoute, useNavigation, useFocusEffect } from "@react-navigation/native";

export default function Recipies() {
  const route = useRoute();
  const navigation = useNavigation();
  const [recipe, setRecipe] = React.useState(route.params?.recipe); 


  useFocusEffect(
    React.useCallback(() => {
      if (!recipe && route.params?.recipe) {
        setRecipe(route.params.recipe);
      }
    }, [route.params?.recipe])
  );

  const goTocook = () => {
    navigation.navigate("cook", { recipe2: recipe });
  };

  if (!recipe) {
    return <Text>Loading...</Text>; 
  }

  return (
    <Fragment>
      <View style={Ingredientstyle.bodyingredients}>
        <View style={Ingredientstyle.mainbox}>
          <View style={Ingredientstyle.headerbox}>
            <TouchableOpacity onPress={() => navigation.navigate("home")}>
              <Image
                style={Ingredientstyle.backimg2}
                source={require("../asssets/backicon.png")}
              />
            </TouchableOpacity>
            <Image
              style={Ingredientstyle.dishimg1}
              source={{ uri: recipe.photo_url }}
            />
            <TouchableOpacity onPress={() => navigation.navigate("home")}>
              <Image
                style={Ingredientstyle.backimg3}
                source={require("../asssets/homeicon.png")}
              />
            </TouchableOpacity>
          </View>
          <View style={Ingredientstyle.ingredientscontainer2}>
            <Text style={Ingredientstyle.TITLE}>{recipe.title}</Text>
            <View style={Ingredientstyle.ingbox}>
              <Text style={Ingredientstyle.ingtext1}>Ingredients</Text>
            </View>
            <View style={Ingredientstyle.ingBox}>
              <FlatList
                data={recipe.ingredients}
                keyExtractor={(item, index) => index.toString()}
                renderItem={({ item }) => (
                  <View style={Ingredientstyle.listitembox}>
                    <Text style={Ingredientstyle.listitem}>•</Text>
                    <Text style={Ingredientstyle.listitem}>{item}</Text>
                  </View>
                )}
                horizontal={false}
                contentContainerStyle={{ paddingBottom: 30 }}
              />
            </View>
            <TouchableOpacity onPress={goTocook}>
              <View style={Ingredientstyle.cookbutton}>
                <Text style={Ingredientstyle.cookText}>Cook</Text>
              </View>
            </TouchableOpacity>
          </View>
        </View>
      </View>
    </Fragment>
  );
}
