package com.example.myapplication

data class placekalyan(var title: String)

lateinit var imgsk: Array<Int>
object locationkalyan{
    val places = listOf<placekalyan>(
        placekalyan("<u>KALYAN RIVERSIDE WALK</u><br><br>" +
                "This is one of the best development done by KDMC. A very nicely constructed River Front / Creak Front." +
                " You can have a nice morning walk with family and friends"),
       placekalyan("<u>KALYAN SMRUTI SAMARAK</u><br><br>"+
       "In the world first Smruti Smarak of Hindu Rudra samrat Balasaheb Thackeray in Kalyan at Kala Talav .." +
               " must visit.. also available memorial of Bala saheb store in the museum."),
        placekalyan("<u>UMBARDE TALAV</u><br><br>"+
            "Umbarde Lake is a fantastic cycling spot with stunning sunrises and sunsets." +
                " It's easily accessible and well-maintained, offering cyclists a serene and enjoyable experience. "
        )



    )
}
object ratingkalyan{
    var rating =  listOf<String>(
        "☆ 4.5",
        "☆ 3.2",
        "☆ 4.1",
    )
}
object imgkalyan {
    val imgka = arrayOf(
        R.drawable.kalyanriversude,
        R.drawable.kalyansmrutism1,
        R.drawable.umbardetalav,

        // Add more images if needed
    )
}
