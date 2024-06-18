package com.example.myapplication

data class cafe(var title: String)

lateinit var imgcafe: Array<Int>
object locationcafe {
    var  placecafe  = listOf<String>(
        "THE CUPID CAFE",

       " THE BOOKMARK CAFE",

        "KAFEEGA CAFE",
        "THE ZEP FOODS ",
        "FITTOO CAFE",
        "CAFÉ SNACK CHAT ",
        "CAFE ANECDOTE",
        "CAFÉ AMIGOS ",
        "LOVE LEAF CAFE",
        "CAFÉ ETC",
        "TIAMO CAFE",
        "PIZZA ON THE ROCKS",
        "CAFÉ BEATS",
        "CAFÉ 792",
        "GRANDMAMAS CAFE",
        " DREAM CAFE",
        "CAFE CREAM KUKA",
        "THE MANSUNDA CAFE",
        "THE CHOCLATEBAR",
        "CAFE DEZIRE",
        "KILL NO CALORIE",
        "WEE WAKE KAFFEE",
        "CAFE AMIGOS",
        "Y CAFE",
        "CALIFORNIA PIZZA AND CAFE",
        "BAKE HOUSE CAFE",
        "CHAOS CONTROL CAFE",
        "CAFE UNWIND",
        "CAFE UNIVERSAL",
        "CAFE EXCELSIOR",
        "CAFE USTADI",
        "CAFE LUCKY",

    )
}
object ratingcafe{
    var rating =  listOf<String>(
        "☆ 4.5",
        "☆ 3.2",
        "☆ 4.1",
        "☆ 4.1",
        "☆ 4.2",
        "☆ 4.4",
        "☆ 3.1",
        "☆ 3.9",
        "☆ 3.5",
        "☆ 4.5",
        "☆ 2.9",
        "☆ 4.1",
        "☆ 4.2",
        "☆ 3.7",
        "☆ 3.8",
        "☆ 4.8",
        "☆ 4.1",
        "☆ 4.2",
        "☆ 4.1",
        "☆ 3.2",
        "☆ 4.4",
        "☆ 4.2",
        "☆ 3.2",
        "☆ 4.4",
        "☆ 3.2",
        "☆ 4.4",
        "☆ 4.2",
        "☆ 4.1",
        "☆ 3.1",
        "☆ 4.4",
        "☆ 3.2",
        "☆ 3.8",
        "☆ 4.8",




    )
}

object cafeinfo{
    var info =  listOf<String>(
        "Address: Shop no.13, The Soman Sun City, Birla College Campus Rd,\n" +
                " opp. sky deck restaurant, Chikan Ghar, Kalyan, Maharashtra 421301",
        "Address: Shop no.4, Patil Bunglow, Gandhar Nagar Rd, near KM Agrwal college,\n" +
                " Gandhari, Kalyan, Maharashtra 421301",
        "Address: 64RX+M3X, Opp Heritage Residency, Vallabh Tower Purnima,\n" +
                " Syndicate, Kalyan, Maharashtra 421301",
        "Address: Sai Arcade, A 13, Phadke Rd, near Gsnesh Mandir, behind Chitale Xpress,\n" +
                " Pendse Nagar, Dombivli East, Mumbai, Dombivli,Maharashtra 421201",
        "Address: Shop no 1, second floor arcedia, above Burger King, opp.\n" +
                "Pendharkar college, Dombivli, Maharashtra 421201\n",
        "Address: Shop No. 2, Nakshatra Ashwini, Near Jondhale Highschool,\n" +
                "Shastri Nagar, Dombivli West, Dombivli, Maharashtra 421202\n",
        "Address: Shop No. 4, Mezzanine Floor, Amrapali Arcade, opp.\n" +
                "Jasmine Tower, opposite Vasant Vihar High School & Junior College,\n" +
                "Vasant Vihar, Thane West, Thane, Maharashtra 400610\n",
        "Address: 12, Sunrise Shopping Complex, Behind Hiranandani Meadows,\n" +
                " Off Ghodbunder Road, Manpada, Thane West, Thane,Maharashtra 400610",
        "Address: The Thane Club, Mohan Koppikar Road, Teen Hath Naka Flyover,\n" +
                " opposite Raheja Garden, Thane, Maharashtra 400601",
        "Address: Purshottam Kheraj Industrial Estate, G4 - Mehhal,\n" +
                "Devidayal Rd, near Fire Station, Mulund West, Mumbai, Maharashtra 400080\n",
        "Address: near Chedda Petrol Pump, near ESIS hospital, Veena Nagar,\n" +
                " mulund West, Mumbai, Maharashtra 400080",
        "Address: Shop no.04, Sarojini Naidu Rd, Siddharth Nagar,\n" +
                " Mulund West, Mumbai, Maharashtra 400080",
        "Address: Shop 2, Madhav Apartment, Jawahar Rd, Ghatkopar,\n" +
                " Saibaba Nagar, Pant Nagar, Ghatkopar East, Mumbai, Maharashtra 400077",
        "Address: 792, Outhouse, Dina Manzil, Jame Jamshed Rd, Central Railway Colony,\n" +
                " Mahavir Nagar, Parsee Colony, Dadar, Mumbai,Maharashtra 400014",
        "Address: Dharamputra Pritam Estate, 20 & 21, Dr Baba Saheb Ambedkar Rd,\n" +
                " Dadar East, Dadar, Mumbai, Maharashtra 400014",
        "Address: near to Nehru Garden, Shastrinagar, Sri Swami \n" +
                "Samarth Nagar, Khopoli, Maharashtra 410203\n",
        "Address: Luisa Apartment, Laxminagar, Khopoli, \n" +
                "Maharashtra 410203",
        "Address: Lakeview Compound, Dr Moose Marg, \n" +
                "Naupada, Thane West, Thane, Maharashtra 400601",
        "address: Jambhali Naka,The Chocolate Bar, \n" +
                "beside Bhavana Hotel, Talav Pali, Thane West, \n" +
                "Maharashtra 400601",
        "Address: Opposite Thane Jilha Sahakari Bank Mantri \n" +
                "plot, Shivaji Path, Thane Station Rd, W, Thane, \n" +
                "Maharashtra 400601",
        "Address: Kulkarni CHS, Ghantali Devi Rd, near Sai \n" +
                "Baba Mandir, Naupada, Thane West, Thane, \n" +
                "Maharashtra 400602",
        "Address: Shop No. 48, Samrin Heritage, Talav Pali, \n" +
                "Ganeshwadi, Thane West, Thane, Maharashtra 400602",
        "Address: 12, Sunrise Shopping Complex, Behind \n" +
                "Hiranandani Meadows, Off Ghodbunder Road, \n" +
                "Manpada, Thane West, Thane, Maharashtra 400610\n",
        "Address: Shop no 3 & 4 ground floor, Navre residency & \n" +
                "library Chinchpada Near fire brigade Ambernath (w, \n" +
                "Ambernath, Maharashtra 421505",
        "Address: Shop No-1, Building No 17, Kuntu Building, \n" +
                "Sarvodaya Nagar, Dattanagar, Thane, Badlapur, Maharashtra \n" +
                "421503\n",
        "Address: WRHJ+6XF, Chamber of Commerce Ln,Kala Ghoda, \n" +
                "Fort, Mumbai, Maharashtra 400001",
        "Address: Gr. Floor, Crystal Towers St. Xavier's Street, Parel, \n" +
                "Mumbai, Maharashtra 400012\n",
        "Address: WRVH+5H9, New Marine Lines, Marine Lines, \n" +
                "Mumbai, Maharashtra 400020",
        "Address:299, Shahid Bhagat Singh Rd, opp. Geo Chem \n" +
                "Laboratories, Ballard Estate, Fort, Mumbai, Maharashtra \n" +
                "400001\n",
        "Address: Kitab Mahal, 23, AK Nayak Marg, opp. Excelsior \n" +
                "Cinema, Azad Maidan, Fort, Mumbai, Maharashtra 400001",
        "Address:B Block Sitaram Bldg. Opp CID Office, Dr Dadabhai \n" +
                "Naoroji Rd, near Crawford Mkt, Mumbai, Maharashtra \n" +
                "400001\n",
        "Address:57, Maruti Keshav Chawl, Rafi Ahmed Kidwai Rd, \n" +
                "Sewri West, Azad Nagar, Wadala, Mumbai, Maharashtra \n" +
                "400015",
    )
}
object  imagecafe {
    val imgcafe= arrayOf(
        R.drawable.cupidcafe,
        R.drawable.bookmarkcafe,
        R.drawable.kafeegacafe,
        R.drawable.thezepfoodscafe,
        R.drawable.fitoocafe,
        R.drawable.cafesnackchat,
        R.drawable.cafeanecdote,
        R.drawable.cafeamigos,
        R.drawable.loveleafcafe,
        R.drawable.cafeetc,
        R.drawable.tiamocafe,
        R.drawable.cafepizzaontherocks,
        R.drawable.cafebeats,
        R.drawable.cafe792,
        R.drawable.grandmascafe,
        R.drawable.dreamcafe,
        R.drawable.cafecreme,
        R.drawable.mansudacafe,
        R.drawable.thechoclatear,
        R.drawable.cafedezire,
        R.drawable.nocalorie,
        R.drawable.wewalikafee,
        R.drawable.cafeamigos,
        R.drawable.ycafe,
        R.drawable.califoriniapizza,
        R.drawable.bakehouse,
        R.drawable.chaoscontrol,
        R.drawable.cafeunwind,
        R.drawable.cafeuniversal,
        R.drawable.cafeexcelizor,
        R.drawable.ustadi,
        R.drawable.cafelucky










    )
}
