import React, { Fragment, useEffect, useState } from "react";
import { FlatList, Image, ScrollView, Text, TouchableOpacity, View } from "react-native";
import Tts from 'react-native-tts';
import Createrecipestyle from "../styles/cookrecipestyle";
import { useRoute } from "@react-navigation/native";
import { useNavigation } from "@react-navigation/native";

export default function Cookrecipe() {
    const route = useRoute();
    const navigation2 = useNavigation();
    const { recipe2 } = route.params;

    const [checkValues, setCheckValues] = useState(Array(recipe2.steps.length).fill(false));
    const [isSpeaking, setIsSpeaking] = useState(false); 
    useEffect(() => {
        const initializeTts = async () => {
            try {
                await Tts.setDefaultLanguage("hi-IN");
            } catch (error) {
                console.warn("Error initializing TTS: ", error);
            }
        };
        initializeTts();


        return () => {
            Tts.stop();
        };
    }, []);

    const toggleCheck = (index) => {
        const updatedCheckValues = [...checkValues];
        updatedCheckValues[index] = !updatedCheckValues[index];
        setCheckValues(updatedCheckValues);
    };

    const toggleTTS = () => {
        if (isSpeaking) {
            Tts.stop(); 
        } else {
            const stepsText = recipe2.steps.join('. '); 
            Tts.speak(stepsText);
        }
        setIsSpeaking(!isSpeaking); 
    };

    return (
        <Fragment>
            <View style={Createrecipestyle.bodyrecipe}>
                <View style={Createrecipestyle.mainbox2}>
                    <View style={Createrecipestyle.headerbox2}>
                        <TouchableOpacity onPress={() => navigation2.navigate("recipe")}>
                            <Image
                                style={Createrecipestyle.backImg2}
                                source={require("../asssets/backicon.png")}
                            />
                        </TouchableOpacity>
                        <Image
                            style={Createrecipestyle.dishimg12}
                            source={{ uri: recipe2.photo_url }}
                        />
                        <TouchableOpacity onPress={() => navigation2.navigate("home")}>
                            <Image
                                style={Createrecipestyle.backImg3}
                                source={require("../asssets/homeicon.png")}
                            />
                        </TouchableOpacity>
                    </View>
                    <View style={Createrecipestyle.topbuttons}>
                        <View style={Createrecipestyle.ingboxed}>
                            <Text style={Createrecipestyle.ingText1}>Recipe</Text>
                        </View>
                        <TouchableOpacity onPress={toggleTTS}>
                            <Image
                            style={Createrecipestyle.pauseplayimg}
                            source={isSpeaking?require("../asssets/pause.png"):require("../asssets/play.png")}
                            />
                        </TouchableOpacity>
                    </View>
                    <ScrollView>
                        <View style={Createrecipestyle.ingredientsContainer}>
                            <FlatList
                                data={recipe2.steps}
                                keyExtractor={(item, index) => index.toString()}
                                renderItem={({ item, index }) => (
                                    <View style={Createrecipestyle.recipecontainer}>
                                        <View style={Createrecipestyle.visualcontainer}>
                                            <TouchableOpacity onPress={() => toggleCheck(index)}>
                                                <View style={checkValues[index] ? Createrecipestyle.setcheck : Createrecipestyle.check} />
                                            </TouchableOpacity>
                                            <Image
                                                style={Createrecipestyle.bigline}
                                                source={require("../asssets/bigline.png")}
                                            />
                                        </View>
                                        <View style={Createrecipestyle.steps}>
                                            <Text style={Createrecipestyle.stepsfont}>
                                                {item}
                                            </Text>
                                        </View>
                                    </View>
                                )}
                                horizontal={false}
                                contentContainerStyle={{ paddingBottom: 10 }}
                            />
                        </View>
                    </ScrollView>
                </View>
            </View>
        </Fragment>
    );
}
