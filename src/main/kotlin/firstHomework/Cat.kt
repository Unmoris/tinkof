class Cat(speed: Float, age: Int, satiety: Double, val name: String) : Animal(speed, age, satiety) {
    override val nameOfType = "Cat"
    override fun say(): String = "Meeoooo"

    //Перегрузка методов
    override fun go(distance: Int) {
        satiety -= speed * distance * 0.2 * age / 20
    }

    override fun returnInfo(): String {
        return super.returnInfo() + "name: " + name + '\n'
    }

    fun breakGlass(): String = "You lost a glass. :{"
}