import React from "react";
import { ScaledSheet } from "react-native-size-matters";


export default Ingredientstyle = ScaledSheet.create({

    bodyingredients: {
        backgroundColor: "#212121",
        flex: 1,
        height: '100%',
        width: '100%',

    },
    mainbox: {
        display: "flex",
        flexDirection: "column",
        alignContent: "flex-start",
        justifyContent: "flex-start",
        alignItems: "flex-start"
    },
    headerbox: {
        height: "330@vs",

        marginTop: "26@vs",
        marginLeft: "10@s",
        display: "flex",
        flexDirection: "row",
        alignContent: "flex-start",
        justifyContent: "flex-start",
        alignItems: "flex-start"
    },
    backimg2: {
        height: "24@vs",
        width: "24@s",
        marginTop: "20@vs",
        marginLeft: "7@s"
    },
    backimg3: {
        height: "24@vs",
        width: "24@s",
        marginTop: "20@vs",

    },
    dishimg1: {
        height: "250@vs",
        width: "260@s",
    
        marginTop: "40@vs",
        borderRadius: "100@ms"
    },
    ingredientscontainer2: {
        height: "308@vs",
        width: "307@s",
        marginLeft: "20@s",
        backgroundColor: "#272727",
        borderRadius: "20@ms",
        display: "flex",
        flexDirection: "column",
        
        textAlign:"center"
    },
    TITLE:{
        fontFamily: "Poppins",
        fontWeight:"semibold",
        fontSize: "24@ms",
        color:"white",
       textAlign:"center",
        marginTop:"10@vs",
    },
    ingbox:{
         height:"36@vs",
         width:"143@s",
         backgroundColor:"#FFE598",
         borderRadius:"40@ms",
         marginLeft:"85@s",
         marginTop:"20@vs",
         textAlign:"center"
    },
    ingtext1:{
        color:"#272727",
        fontFamily:"Poppins",
        marginLeft:"35@s",
        marginTop:"7@vs",
        fontSize:"16@ms",
        fontWeight:"bold",

    },
    ingBox:{
        height:"144@vs",
        width:"277@s",
        backgroundColor:"#2D2D2D",
        borderRadius:"20@ms",
        marginLeft:"15@s",
        marginTop:"15@vs"
    },
    inglist:{

    },
    cookbutton:{
        marginTop: "10@vs",
        marginLeft: "18@s",
        height:"37@vs",
        width:"278@s",
        borderRadius: "40@ms",
        backgroundColor:"#FFE598",
        textAlign:"center"
    },
    cookText:{
        color:"#272727",
        fontFamily:"Poppins",
        marginLeft:"115@s",
        marginTop:"7@vs",
        fontSize:"20@ms",
        fontWeight:"bold",
    },
    listitembox:{
        marginTop: "10@vs",
        marginLeft: "10@s",
        display: "flex",
        flexDirection: "row",
        alignContent: "flex-start",
        justifyContent: "flex-start",
        alignItems: "flex-start"
    },
    listitem:{
        
        marginLeft: "7@s",
        color:"white",
        fontFamily:"Poppins",
        fontWeight:"semibold",
        fontSize:"13@ms"
    }
    

})