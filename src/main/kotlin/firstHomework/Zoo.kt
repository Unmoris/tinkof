class Zoo(vararg animals: Animal) {
    private var zooList: ArrayList<Animal> = ArrayList(animals.toList())

    fun addAnimal(newAnimal: Animal) {
        zooList.add(newAnimal)
    }

    fun say(indexAnimal: Int): String = zooList[indexAnimal].say()
    fun allGo(distance: Int) {
        for (it in zooList)
            it.go(distance)
    }

    fun getSatiety(indexAnimal: Int): Double = zooList.get(indexAnimal).satiety
    fun allInfo(): String {
        var allInformation: ArrayList<String> = ArrayList()
        allInformation.add("Information of ZOO")
        for (it in zooList)
            allInformation.add(it.returnInfo())
        return allInformation.joinToString("\n")
    }
}