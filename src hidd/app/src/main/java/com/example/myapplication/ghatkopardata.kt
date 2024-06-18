package com.example.myapplication

data class placeghatkopar(var title: String)

lateinit var imgsG: Array<Int>
object locationGhatkopar{
    val places = listOf<placekalyan>(
        placekalyan("<u>KHANDOBA TEKADI</u><br><br>" +
                " Very nice place for track in monsoon, you can see lots of laces from the mountain . " +
                "In first point you can see CHATRAPATI SHIVAJI MAHARAJA International Airport," +
                " From 2nd point you can see the whole Powai lake & Vihar lake "),
        // Add more places if needed
    )
}
object ratingghatkopar{
    var rating =  listOf<String>(
        "☆ 4.5",
        "☆ 3.2",
        "☆ 4.1",
    )
}
object imgghatkopar {
    val imgka = arrayOf(
        R.drawable.khandobatekdi,
        // Add more images if needed
    )
}
