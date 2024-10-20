import React from "react";
import { ScaledSheet } from "react-native-size-matters";


export default Createrecipestyle = ScaledSheet.create({

    bodyrecipe: {
        backgroundColor: "#212121",
        flex: 1,
        height: '100%',
        width: '100%',

    },
    mainbox2: {
        display: "flex",
        flexDirection: "column",
        alignContent: "flex-start",
        justifyContent: "flex-start",
        alignItems: "flex-start"
    },
    headerbox2: {
        height: "250@vs",

        marginTop: "26@vs",
        marginLeft: "10@s",
        display: "flex",
        flexDirection: "row",
        alignContent: "flex-start",
        justifyContent: "flex-start",
        alignItems: "flex-start"
    },
    backImg2: {
        height: "24@vs",
        width: "24@s",
        marginTop: "20@vs",
        marginLeft: "7@s"
    },
    backImg3: {
        height: "24@vs",
        width: "24@s",
        marginTop: "20@vs",

    },
    dishimg12: {
        height: "250@vs",
        width: "260@s",
    
        marginTop: "40@vs",
        borderRadius: "100@ms"
    },
    ingredientsContainer: {
        height: "1100@vs",
        width: "307@s",
        marginLeft: "20@s",
        backgroundColor: "#272727",
        borderRadius: "20@ms",
        display: "flex",
        flexDirection: "column",
        marginTop:"25@vs"
        
        
    },
   
    listenbutton: {
       
        height: "36@vs",
        width: "123@s",
        backgroundColor: "#FFE598",
        borderRadius: "40@ms",
        marginLeft: "10@s",
        marginTop: "20@vs",
        textAlign: "center",
        display: "flex",
        flexDirection: "row",
        justifyContent: "center",
        alignContent: "center",
        alignItems: "center",
        zIndex: 2,  
      },
      topbuttons:{
        display: "flex",
        flexDirection: "row",
        justifyContent: "flex-start",
        alignContent: "flex-start",
        alignItems: "flex-start",
        marginLeft:"90@vs",
        marginTop:"30@vs"
      },
    listenicon:{
        height:"24@vs",
        width:"24@s"
    },
    listentext:{
        color:"#272727",
        fontFamily:"Poppins",
        marginLeft:"10@s",
        
        fontSize:"17@ms",
        fontWeight:"bold",
    },

    ingboxed:{
        height:"36@vs",
        width:"123@s",
        backgroundColor:"#FFE598",
        borderRadius:"40@ms",
        marginLeft:"7@s",
        marginTop:"20@vs",
        textAlign:"center"
   },
   ingText1:{
       color:"#272727",
       fontFamily:"Poppins",
       marginLeft:"35@s",
       marginTop:"7@vs",
       fontSize:"17@ms",
       fontWeight:"bold",

   },
recipecontainer:{
    zIndex: 0,
    display:"flex",
    flexDirection:"row",
    marginLeft:"10@s",
    marginTop:"20@vs",
},
visualcontainer:{
    display:"flex",
    flexDirection:"column",
   
},
pauseplayimg:{
marginLeft: "20@s",
marginTop:"17@vs"
},
check: {
    height: "14@vs",
    width: "14@s",
    color: "#272727",
    borderWidth: "3@ms",
    borderColor: "#FFE598",
    borderRadius:"100@ms"
},
setcheck: {
    height: "14@vs",
    width: "14@s",
    backgroundColor:"#FFE598",
    borderWidth: "3@ms",
    borderColor: "#FFE598",
    borderRadius: "100@ms",
    backgroundImage: "url('../asssets/image.png')",  
    backgroundSize: "cover", 
    backgroundPosition: "center",  
},
bigline:{
    width:"2@s",
height:"60@vs",
marginTop:"10@vs",

marginLeft:"7@s",
},
steps:{
   
    marginLeft:"16@s",
    width:"223@s",
},

stepsfont:{
    color:"white",
    fontFamily:"poppins",
    fontWeight:"semibold",
    fontSize:"14@ms"
}


})