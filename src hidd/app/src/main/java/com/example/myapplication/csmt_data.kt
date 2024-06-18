package com.example.myapplication

data class placecsmt(var title: String)

lateinit var imgsC: Array<Int>
object locationcsmt {
    val  places = listOf<placecsmt>(
        placecsmt("<u>KHADA-PARSI</u><br><br> " +
                "               The Khada Parsi is a popular local attraction in Mumbai. It is a statue of a Parsi man..... <br>"),
        placecsmt("<u>WADI-BUNDER</u><br><br>" +
                "Wadi Bunder is a railway yard in Mumbai, India. It is the oldest railway yard in the city, established in 1882...<br>"

        ),
        placecsmt("<u>KOTACHI-WADI</u><br><br>" +
                "Khotachiwadi is a heritage village located in the Girgaon neighborhood of Mumbai, India......"
        ),
        placecsmt("<u>SEWRI-FORT</u><br><br>" +
                "The Sewri Fort is a fort in Mumbai built by the British at Sewri....."),



        )}
object ratingcsmt{
    var rating =  listOf<String>(
        "☆ 4.5",
        "☆ 3.2",
        "☆ 4.1",
        "☆ 4.5",
    )
}
object  images {
    val imgc = arrayOf(
        R.drawable.khadaparsireal1,
        R.drawable.wadibunderreal,
        R.drawable.kotachiwadireal,
        R.drawable.sewrifortreal,)


}