package com.example.myapplication

data class placeambernath(var title: String)

lateinit var imgsA: Array<Int>
object locationambernath {
    val places = listOf<placeambernath>(
        placeambernath("<u>APTI DAM</u><br><br>" +
                "An hidden DAM having natural <br>beauty." +
                " You Can enjoy playing in flowing water as at some....."),
        placeambernath("<u>LOTUS POINT</u><br><br>" +
                "A beautiful lake with a  chinese restraunt ." +
                " You Can enjoy playing in flowing water as at some....."),
        // Add more places if needed
    )
}
object ratingambernath{
    var rating =  listOf<String>(
        "☆ 4.5",
        "☆ 3.2",
        "☆ 4.1",
    )
}
object imagess {
    val imga = arrayOf(
        R.drawable.apti_nadi,
        R.drawable.lotusppoinamber,
        // Add more images if needed
    )
}
