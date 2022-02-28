class Dog(speed: Float, age: Int, satiety: Double) : Animal(speed, age, satiety) {
    override val nameOfType = "Wolf"
    override fun say(): String = "Oooooouuu 1c is very good"
    fun go(distance: Float) {
        satiety -= speed * distance * 0.4 * age / 15
    }
}