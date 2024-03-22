package com.kotlin.recyclerview.models

data class ObjectModel(
    var title: String,
    var image: String
)

object ObjectData {
    val titleObject = arrayOf(
        "Kucing",
        "Anjing",
        "Bebek",
        "Ayam",
        "Sapi"
    )

    val imageObject = arrayOf(
        "https://d1vbn70lmn1nqe.cloudfront.net/prod/wp-content/uploads/2021/10/28064854/12.-Tips-Merawat-Anak-Kucing-Munchkin.jpg",
        "https://asset-a.grid.id/crop/0x0:0x0/700x465/photo/2021/08/25/menjulurkan-lidahjpg-20210825050556.jpg",
        "https://cdn1-production-images-kly.akamaized.net/wgGjKmRNL075b8CZ9U6MV-chA_g=/1200x900/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/3300522/original/027832800_1605753409-BEBEK_Mandarin.jpg",
        "https://cdn0-production-images-kly.akamaized.net/41bW5ObIKY8_oV-8o_GoXx6QImg=/1200x900/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/3571062/original/037149900_1631598580-chicken-1719349_640.jpg",
        "https://www.duniasapi.com/media/k2/items/cache/75b44b0e9c2e5d305fa323c6c51d3476_XL.jpg"
    )

    val listObjectAnimal: ArrayList<ObjectModel>
        get() {
            val list = arrayListOf<ObjectModel>()
            for (position in titleObject.indices) {
                val news = ObjectModel(
                    title = titleObject[position],
                    image = imageObject[position]
                )
                list.add(news)
            }
            return list
        }
}