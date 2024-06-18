package com.example.myapplication

data class placethane(var title: String)

lateinit var imgt: Array<Int>
object locationthane {
    var  placest  = listOf<placethane>(
        placethane("<u>MANSUDA LAKE</u><br><br>" +
                "Earlier the Masunda Lake extended up to the Kopineshwar Mandir in the east but in the..... <br>"
                ),
        placethane(" <u>KOPINESHWAR TEMPLE</u><<br><br>" +
                " The temple is believed to have been built in the 8th century by the Shilahara dynasty....<br>"
                ),
        placethane("<u>MAMACHA GOAN</u><br><br>" +
                " Mamacha Gaon is a resort and agrotourism destination located in Gundale village,<br>...."
                ),
    )
}
object ratingthane{
    var rating =  listOf<String>(
        "☆ 4.5",
        "☆ 3.2",
        "☆ 4.1",
    )
}
object  imageT {
    val imgt= arrayOf(
        R.drawable.masunda_lake_talao_pali_min,
        R.drawable.kopineshwartemplereal1,
        R.drawable.mamachagaonreal,
    )
}
