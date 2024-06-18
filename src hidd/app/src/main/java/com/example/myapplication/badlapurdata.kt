package com.example.myapplication


data class placebadlapur(var title: String)

lateinit var imgsB: Array<Int>
object locationbadlapur {
    val places = listOf<placebadlapur>(
        placebadlapur("<u>BARVI DAM</u><br><br>" +
                " A beautiful Dam having attractive scenary located in badlapur." +
                " It is a beautiful peace of construction....."),
        placebadlapur("<u>CHIKLOLI DAM</u><br><br>"+
            "Attractive place for photoshoot and best time to visit is in monsoon" +
                "you can play in flowing water"),
        placebadlapur("<u>KONDESHWAR TEMPLE</u><br><br>"+
        "It is a old shiv temple temple located in badlapur at the edge of the mountain." +
                "THere meet of two rivers there . It is beautiful pace for photoshoot")

        // Add more places if needed
    )
}
object ratingbadlapur{
    var rating =  listOf<String>(
        "☆ 4.5",
        "☆ 3.2",
        "☆ 4.1",
    )
}
object imagbadlapur {
    val imgb = arrayOf(
        R.drawable.barvidam,
        R.drawable.chikholidam,
        R.drawable.kondeshwatempl,
        // Add more images if needed
    )
}
