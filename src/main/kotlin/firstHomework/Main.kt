fun main(args: Array<String>) {
    var pushok: Animal = Cat(name = "Pushok", age = 2, satiety = 10.0, speed = 5F)
    var doggi: Animal = Dog(age = 4, satiety = 13.0, speed = 6F)

    println(pushok.returnInfo())
    pushok.go(10)
    println(pushok.returnInfo())
    if (pushok is Cat)
        pushok.breakGlass()
    println(doggi.returnInfo())
    doggi.go(10)
    println(doggi.returnInfo())

    doggi.eat(10F)
    println(doggi.returnInfo())

    pushok.eat(10F)
    println(pushok.returnInfo())

    var zoo = Zoo(pushok, doggi)
    println(zoo.allInfo())
    zoo.allGo(10)
    println(zoo.allInfo())
}