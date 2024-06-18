package com.example.myapplication

data class Stations(var title: String)
object supplies {
    val  station = listOf<Stations>(

        Stations("KHOPOLI"),
        Stations("THANE"),
        Stations("AMBERNATH"),
        Stations("CSMT"),
        Stations("BADLAPUR"),
        Stations("KALYAN"),
        Stations("DADAR"),
        Stations("NERAL"),
        Stations("GHATKOPAR")



    )
}

object imagstn {
    val imgst = arrayOf(
        R.drawable.khopoli,
        R.drawable.thane,
        R.drawable.ambernath,
        R.drawable.mumbai,
        R.drawable.badlapur,
        R.drawable.kalyan,
        R.drawable.dadar,
        R.drawable.thane,
        R.drawable.ghatkopar,

        // Add more images if needed
    )
}