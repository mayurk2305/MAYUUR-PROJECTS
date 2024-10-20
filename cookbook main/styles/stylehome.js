import React from "react";
import { ScaledSheet } from "react-native-size-matters";

export default Homestyle = ScaledSheet.create({
  body: {
    backgroundColor: "#212121",
    flex: 1,
    height: '100%',
    width: '100%',
  },
  headingbox: {
    marginLeft: '20@s',
    marginTop: '30@vs',
    display: "flex",
    alignItems: "flex-start",
    justifyContent: 'flex-start',
    flexDirection: 'column',
  },
  heading: {
    fontStyle: "Poppins-Regular",
    fontWeight: "bold",
    fontSize: '32@ms',
    color: "white",
  },
  searchbox: {
    marginLeft: '20@s',
    marginTop: '30@vs',
    display: "flex",
    flexDirection: "row",
  },
  search: {
    width: '246@s',
    height: '46@vs',
    backgroundColor: "white",
    borderRadius: '40@ms',
    color: "black",
    display: "flex",
    flexDirection: "row",
    paddingHorizontal: '10@s',
  },
  searchicon: {
    height: '20@vs',
    width: '19@s',
    marginTop: '13@vs',
    color: "black",
  },
  searchinput: {
    marginLeft: "10@s",
    flex: 1,
    height: '44@vs',
    color: 'black',
    paddingHorizontal: '10@s',
    textAlignVertical: 'center',
    overflow: 'hidden',
    maxWidth: '80%',
    marginRight: 0,
    borderRadius: '40@ms',
    fontSize:"17@ms",
    textDecorationLine:"none"
    
  },
  filterbox: {
    alignItems: "center",
    justifyContent: "center",
    display: "flex",
    width: '52@s',
    height: '46@vs',
    marginLeft: '10@s',
    borderRadius: '26@ms',
    backgroundColor: "white",
  },
  filtericon: {
    height: '24@vs',
    width: '24@s',
  },
  filterscreen:{
    height:"100%",
    width:"100%",
    flex:1,
    backgroundColor:"#212121"
  },
  headingcontainer:{
    marginTop:"30@vs",
    marginBottom:"0@vs",
    marginLeft:"20@s",
    display:"flex",
    flexDirection:"row",
    alignItems:"start",
    justifyContent:"start"
  },
  backiconpref:{
    height:"24@vs",
    width:"24@s"
  },
  preferences:{
    fontStyle: "Poppins-Regular",
    fontWeight: "semibold",
    fontSize: '32@ms',
   textAlignVertical:"center",
    color:"white",
    marginLeft:"55@s",
    marginTop:"0@vs",
    marginBottom:"0@vs"
  },
  searchresults:{
    fontStyle: "Poppins-Regular",
    fontWeight: "semibold",
    fontSize: '32@ms',
   textAlignVertical:"center",
    color:"white",
    marginLeft:"35@s",
    marginTop:"0@vs",
    marginBottom:"0@vs"
  },
  preferencecontainer:{
    marginLeft:"20@s",
    marginTop:"20@vs",
    display:"flex",
    flexDirection:"column",
    alignItems:"start",
    justifyContent:"start"
  },
  time:{
    color:"white",
    fontFamily:"Poppins-SemiBold",
    fontSize:"24@ms",
    fontWeight:"semibold"
  },
  timecontainer:{
    
    marginTop: "12@vs",
    marginRight: "10@s",
    height:"37@vs",
    width:"128@s",
    borderRadius:"35@ms",
    backgroundColor:"#2D2D2D"
  },
  timetext:{
    textAlign:"center",
    color:"white",
    fontFamily:"Poppins-Semibold",
    fontSize:"14@ms",
    fontWeight:"semibold",
    marginTop:"10@vs"
  },
  Cuisine:{
    color:"white",
    fontFamily:"Poppins-SemiBold",
    fontSize:"24@ms",
    fontWeight:"semibold",
    marginTop: "20@vs",
  },
  Cusinecontainer:{
    
    marginTop: "12@vs",
    marginRight: "10@s",
    height:"37@vs",
    width:"70@s",
    borderRadius:"35@ms",
    backgroundColor:"#2D2D2D"
  },
 applyclear:{
  height:"170@vs",
  width:"310@s",
  backgroundColor:"#2D2D2D",
  borderRadius:"10@ms",
  marginTop: "17@vs",
  display:"flex",
  flexDirection:"column",
 
 },
 buttonapply:{
  marginLeft:"25@vs",
  marginTop: "30@s",
  height:"37@vs",
  width:"250@s",
  textAlign:"center",
  backgroundColor:"white",
  borderRadius: "30@ms",
 },
buttontext:{
  fontFamily:"Poppins-SemiBold",
  fontSize:"20@ms",
  color:"black",
  fontWeight:"semibold",
 textAlign:"center",
 marginTop:"7@vs",
 marginRight:"7@s"
},
buttonclear:{
  marginLeft:"25@vs",
  marginTop: "20@s",
  height:"37@vs",
  width:"250@s",
  textAlign:"center",
  backgroundColor:"white",
  borderRadius: "30@ms",
 },
 Newdishesbox: {
  marginTop: "25@vs",
  marginLeft: "20@s",
  display: "flex",
  flexDirection: "column",
  alignItems: "start",
  justifyContent: "start",
  marginBottom: 0,
},
Newdishestext: {
  color: "white",
  fontFamily: "Poppins-SemiBold",
  fontStyle: "normal",
  fontWeight: "semibold",
  fontSize: "32@ms",
},
Newdishescontainer: {
  width: "139@vs",
  height: "187@s", 
  borderRadius: "15@ms",
  backgroundColor: "#2D2D2D",
  marginTop: "15@vs",
  marginLeft: "15@s",
  marginBottom: 0,
  elevation: 10,
  shadowColor: "#000", 
  shadowOffset: { width: 0, height: 2 },
  shadowOpacity: 0.8,
  shadowRadius: 3,
  textAlign:"center"
},
popularbox: {
  marginTop: "20@vs", 
  marginLeft: "20@s",
  display: "flex",
  flexDirection: "column",
  alignItems: "start",
  justifyContent: "start",
},
populartext: {
  color: "white",
  fontFamily: "Poppins-SemiBold",
  fontStyle: "normal",
  fontWeight: "semibold",
  fontSize: "32@ms",
},
flatlist:{
  height:"190@vs",
  width:"auto"
},

popularcontainer: {
  width: "320@s",
  height: "160@vs",
  backgroundColor: "#2D2D2D",
  borderRadius: "30@ms",
  marginTop: "10@vs",
  marginLeft: "15@s",
  elevation: 10,
  shadowColor: "#000", 
  shadowOffset: { width: 0, height: 2 },
  shadowOpacity: 0.8,
  shadowRadius: 3,
  display:"flex",
  flexDirection:"row",
  alignItems:"flex-start",
  justifyContent:"flex-start",
  alignContent:"flex-start"
},
cookcreatebox:{
  marginTop: "10@vs",
  marginLeft:"20@s",
  height:"75@vs",
  width:"310@s",
  backgroundColor:"#2D2D2D",
  borderRadius:"15@ms",
  display:"flex",
  flexDirection:"row",
  justifyContent:"start",
  alignItems:"start"
},
cookbox:{
  display:"flex",
  flexDirection:"column",
  justifyContent:"start",
  alignItems:"start",
  marginTop: "20@vs",
  
},
cooktext:{
  marginLeft: "72@s",
  color:"#FFE598",
  fontFamily:"Poppins-Bold",
  fontWeight:"bold",
  fontStyle:"bold",
  fontSize:"20@ms"
},
createtext:{
  marginLeft: "72@s",
  color:"#8F8E8E",
  fontFamily:"Poppins-Regular",
  fontWeight:"regular",
  fontSize:"20@ms"
},
active: {
  height: "7@vs",
  width: "140@s",
  marginTop: "12@vs",
  position: 'absolute', 
  top: "17@vs", 
  left:"10@s",
  borderRadius:"5@ms"
},
deactive: {
  height: "7@vs",
  width: "140@s",
  marginTop: "12@vs",
  position: 'absolute', 
  top: "17@vs", 
  left:"41@s",
 
  borderRadius:"5@ms"
},
newdishesimg:{
  height:"100@vs",
  width:"125@s",
  borderRadius:"100@ms",
  marginLeft:"16@s",
  marginTop: "12@vs",
  elevation: 100,
  shadowColor: "#000", 
  shadowOffset: { width: 0, height: 2 },
  shadowOpacity: 0.8,
  shadowRadius: 3,
},
newdishestxt:{
color:"white",
fontSize:"16@ms",
fontFamily:"Poppins",
fontWeight:"semibold",
textAlign:'center',
marginTop: "8@vs",
},
populartextcontainer:{
  display:"flex",
  flexDirection:"column",
  alignItems:"flex-start",
  justifyContent:"flex-start",
  alignContent:"flex-start",
  marginLeft:"14@s",
  marginTop:"10@vs"
},
popularttxt1:{
  fontFamily:"Poppins",
  fontSize:"20@ms",
  fontWeight:"semibold",
  color:"white",
  marginLeft:"10@s",
  marginTop:"10@vs"

},
popularttxt2:{
  fontFamily:"Poppins",
  fontSize:"20@ms",
  fontWeight:"semibold",
  color:"white",
  marginLeft:"10@s",
  marginTop:"2@vs",
  

},
veg:{
  display:"flex",
  flexDirection:"row",
  alignItems:"flex-start",
  justifyContent:"flex-start",
  alignContent:"flex-start",
},
vegimg:{
  height:"12@vs",
  width:"12@s",
  marginLeft:"20@s",
  marginTop:"12@vs"
},
popularimg:{
  height:"132@vs",
  width:"125@s",
  borderRadius:"100@ms",
  marginLeft:"32@s",
  marginTop:"12@vs"
  
},
timecusinecontainer:{
  marginTop:"30@vs",
  marginLeft:"7@s",
  display:"flex",
  flexDirection:"row",
  alignItems:"flex-start",
  justifyContent:"flex-start",
  alignContent:"flex-start",
},
timetype:{
  fontSize:"14@ms",
  color:"white",
  fontFamily:"poppins",
  fontWeight:"semibold"
},
line:{
  height:"30@vs",
  width:"2@s",
  marginLeft:"10@s",
  marginRight:"10@vs"
},

searchedcontainer:{
  height:"160@vs",
  width:"320@s",
  marginTop:"40@vs",
  marginLeft:"15@s",
  borderRadius: "20@ms",
  backgroundColor:"#2D2D2D",
  elevation: 100,
  shadowColor: "#000", 
  shadowOffset: { width: 0, height: 2 },
  shadowOpacity: 0.8,
  shadowRadius: 3,
  display:"flex",
  flexDirection:"row",
  alignItems:"flex-start",
  justifyContent:"flex-start",
  alignContent:"flex-start"
},
noResultsContainer: {
  flex: 1,
  justifyContent: 'center',
  alignItems: 'center',
  padding: 20,
},
noResultsText: {
  fontSize: 18,
  color: 'gray',
  textAlign: 'center',
},


});