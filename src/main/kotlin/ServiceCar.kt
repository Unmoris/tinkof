class ServiceCar {
    fun translateNameToEngAndCurrency(cars: List<Car>): List<Car> {
        val seqCar = cars.asSequence()
        val list = seqCar.map { Car(nameCar.getValue(it.name), it.price * currency, it.brand) }
        return list.toList().sortedBy { it.price }
    }

    fun groupByBrand(cars: List<Car>, brand: BrandCar): List<Car> {
        val seqCar = cars.asSequence()
        val list = seqCar.filter { it.brand == brand }
        return list.toList()
    }

    fun conditionCarCount3NameList(cars: List<Car>, conditionCar: (Car) -> Boolean): List<String> {
        val seqCar = cars.asSequence()
        val list = seqCar.filter { conditionCar(it)}.take(3).map { it.name }
        return list.toList()

    }
}