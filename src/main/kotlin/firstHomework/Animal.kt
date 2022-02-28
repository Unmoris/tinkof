abstract class Animal(var speed: Float, var age: Int, var satiety: Double) {
    abstract val nameOfType: String

    open fun returnInfo(): String {
        return "$nameOfType  \n" +
                "age: $age \n" +
                "speed: $speed \n" +
                "satiety: $satiety\n"
    }

    open fun go(distance: Int) {
        satiety -= speed * distance * 0.2 * age / 100
    }

    open fun eat(food: Float) {
        satiety += food * 0.7
    }

    abstract fun say(): String
}