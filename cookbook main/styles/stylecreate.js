import React from "react";
import { ScaledSheet } from "react-native-size-matters";



export default Createstyle = ScaledSheet.create({
bodyform:{
    backgroundColor:"#212121",
    flex:1,
    height:"100%",
    width:"100%",
    display:"flex",
    alignContent:"start",
    alignItems:"start",
    justifyContent: "start",
    flexDirection:"column"
},
createheadingcontainer:{
    marginTop:"30@vs",
    marginBottom:"0@vs",
    marginLeft:"20@s",
    display:"flex",
    flexDirection:"row",
    alignItems:"start",
    justifyContent:"start"
},
backimg:{
    height:"24@vs",
    width:"24@s"
},
create:{
    fontStyle: "Poppins-Regular",
    fontWeight: "semibold",
    fontSize: '32@ms',
   textAlignVertical:"center",
    color:"white",
    marginLeft:"87@s",
    marginTop:"0@vs",
    marginBottom:"0@vs"
},
Form:{
    height:"100%",
    width:"100%",
    display:"flex",
    alignContent:"start",
    alignItems:"start",
    justifyContent: "start",
    flexDirection:"column",
    marginTop:"35@vs",
    marginLeft:"20@s",
},
imagename:{
    color:"white",
    fontFamily:"Poppins-SemiBold",
    fontSize:"24@ms",
    fontWeight:"semibold"
},
imagebox:{
    height:"185@vs",
    width:"185@s",
    borderRadius:"20@ms",
    marginTop: "15@vs",
    marginLeft:"65@s",
    backgroundColor:"#2D2D2D"
},
addimage:{
    height:"123@vs",
    width:"123@s",
    marginLeft: "25@s",
    marginTop:"25@vs",
},
namebox:{
marginTop: "15@vs",
height:"44@vs",
width:"310@s",
borderRadius:"20@ms",
backgroundColor:"#2D2D2D",
color:"#AEAEAE",
textAlign:"center",
fontFamily:"poppins",
fontSize:"14@ms"
},
iingredients:{
    color:"white",
    fontFamily:"Poppins-SemiBold",
    fontSize:"24@ms",
    fontWeight:"semibold",
    marginTop:"35@vs"
},
ingredientslist:{
    marginTop: "15@vs",
    display:"flex",
    flexDirection:"column",
    alignContent:"start",
    justifyContent:"start",
    alignItems:"start"
},
ingredientdsaddbutton:{
    marginTop: "15@vs",
    height:"44@vs",
    width:"310@s",
    borderRadius:"20@ms",
    backgroundColor:"#2D2D2D",
    color:"#AEAEAE",
    textAlign:"center",
    fontFamily:"poppins",
    fontSize:"14@ms"

},
adding:{
    textAlign:"center",
    color:"#AEAEAE",
    height:"27@vs",
    width:"27@s",
    marginLeft:"140@s",
    marginTop: "7@vs",
},
ingredientitem:{
color:"#AEAEAE",
fontFamily:"Poppins",
fontSize:"14@ms",
fontWeight:"semibold",
textAlign:"center",
marginTop:"12@vs"
},
submitbox:{
    height:"87@vs",
    width:"310@s",
    marginTop:"27@vs",
    backgroundColor:"#2D2D2D",
    display:"flex",
    justifyContent:"center",
    alignContent:"center",
    alignItems:"center",
    borderRadius:"20@ms"
},
submitbutton:{
    textAlign:"center",
    backgroundColor:"white",
    borderRadius:"20@ms",
    height:"37@vs",
    width:"250@s",
},
submittext:{
    marginLeft: "100@s",
    marginTop:"10@vs",
    color:"#272727",
    fontFamily:"Poppins",
    fontSize:"14@ms",
    fontWeight:"semibold"
}

})