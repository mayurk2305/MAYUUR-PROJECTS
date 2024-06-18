package com.example.myapplication

data class placeneral(var title: String)

lateinit var imgsN: Array<Int>
object locationneral{
    val places = listOf<placekalyan>(
        placekalyan("<u>ONE HILL POINT MATHERAN</u><br><br>" +
                " the prominent hill points in Matheran is \"Panorama Point\" (also known as \"Sunset Point\"). " +
                "It offers breathtaking panoramic views of the surrounding valleys and lush greenery, especially during sunset"),
        placekalyan("<u>CHARLOTTE LAKE</u><br><br>" +
                "n the vicinity of Charlotte Lake, a picturesque hill point to visit is Louisa Point. Located in Matheran," +
                " Louisa Point offers stunning views of the surrounding valleys, hills, and Charlotte Lake itself.")
        // Add more places if needed
    )
}
object ratingneral{
    var rating =  listOf<String>(
        "☆ 4.5",
        "☆ 3.2",
        "☆ 4.1",
    )
}
object imgneral {
    val imgka = arrayOf(
        R.drawable.onehillpoint,
        R.drawable.chorletlake,
        // Add more images if needed
    )
}
