class Dog(speed: Float, age: Int, satiety: Double) : Animal(speed, age, satiety) {
    override val nameOfType = "Wolf"
    override fun say(): String = "Oooooouuu 1c is very good"

    override fun go(distance: Int) {
        satiety -= speed * distance * 0.4 * age / 15
    }
}