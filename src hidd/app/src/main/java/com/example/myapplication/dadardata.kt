package com.example.myapplication

data class placedadar(var title: String)

lateinit var imgsD: Array<Int>
object locationdadr{
    val places = listOf<placedadar>(
        placedadar("<u>DADAR BEACH</u><br><br>" +
                " Dadar Beach offers a refreshing escape from the hustle and bustle of Mumbai city life." +
                " While not as famous as some other beaches in Mumbai, it holds its own charm and allure. "),
        // Add more places if needed
    )
}
object ratingdadar{
    var rating =  listOf<String>(
        "☆ 4.5",
        "☆ 3.2",
        "☆ 4.1",
    )
}
object imgdadar {
    val imgka = arrayOf(
        R.drawable.dadarbeach,
        // Add more images if needed
    )
}
