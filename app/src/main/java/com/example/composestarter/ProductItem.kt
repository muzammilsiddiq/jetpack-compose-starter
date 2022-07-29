package com.example.composestarter

data class ProductItem(
    val id: Int,
    val title: String,
    val description: String = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
    val category: String,
    val price: Float,
    val imageURL: String,
)

fun getProducts() = listOf(
    ProductItem(
        id = 1001,
        title = "Peace Lily",
        category = "Indoor",
        price = 31.45f,
        imageURL = "https://cdn.shopify.com/s/files/1/0262/7875/6434/products/Peacelilyweb_1024x1024.png?v=1605840857"
    ),
    ProductItem(
        id = 1002,
        title = "Schefflera",
        category = "Outdoor",
        price = 14.82f,
        imageURL = "https://cdn.webshopapp.com/shops/30495/files/309500897/schefflera-compacta-braided-trunk-umbrella-tree.jpg"
    ),
    ProductItem(
        id = 1003,
        title = "Dracaena",
        category = "Indoor",
        price = 24.89f,
        imageURL = "https://leafy-life.com/wp-content/uploads/2020/12/buy-dracaena-fragrans-steudneri-leafy-life.png"
    ),
    ProductItem(
        id = 1004,
        title = "Yucca",
        category = "Outdoor",
        price = 42.98f,
        imageURL = "https://cdn.webshopapp.com/shops/30495/files/308867579/550x550x2/yucca-elephantipes-palm-lily.jpg"
    ),
    ProductItem(
        id = 1005,
        title = "Monstera",
        category = "Indoor",
        price = 234.89f,
        imageURL = "https://cdn.shopify.com/s/files/1/0262/7875/6434/products/MonsteraDeliciosa6in_1024x1024.png?v=1594413576"
    ),
    ProductItem(
        id = 1006,
        title = "Cactus",
        category = "Outdoor",
        price = 24.89f,
        imageURL = "https://cdn.webshopapp.com/shops/30495/files/337917902/cactus-euphorbia-ingens-xxl-80cm.jpg"
    )
)