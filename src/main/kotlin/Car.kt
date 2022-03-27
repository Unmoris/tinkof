data class Car(
    var name: String,
    var price: Float,
    var brand: BrandCar
)

const val currency: Int = 100

val nameCar :Map<String,String> = mapOf(
    "Веста" to "Vesta",
    "Нива" to "Niva",
    "Ласточка" to "Swallow",
    "Бурундук" to "Chipmunk",
    "БТР" to "APC"
)