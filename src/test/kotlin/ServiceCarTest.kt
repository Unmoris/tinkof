import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ServiceCarTest {

    val service = ServiceCar()

    val listCars = listOf<Car>(
        Car("Веста", 103F, BrandCar.FIAT),
        Car("Ласточка", 200F, BrandCar.NISSAN),
        Car("Бурундук", 300F, BrandCar.LADA),
        Car("Нива", 1000F, BrandCar.MITSUBISHI),
        Car("БТР", 10000F, BrandCar.FIAT)
    )

    val translateCarsAndPriceToCurrency = listOf<Car>(
        Car("Vesta", 10300F, BrandCar.FIAT),
        Car("Swallow", 20000F, BrandCar.NISSAN),
        Car("Chipmunk", 30000F, BrandCar.LADA),
        Car("Niva", 100000F, BrandCar.MITSUBISHI),
        Car("APC", 1000000F, BrandCar.FIAT)
    )

    @Test
    fun translateNameToEngAndCurrency() {

        val resultlist = service.translateNameToEngAndCurrency(listCars)
        Assertions.assertEquals(resultlist, translateCarsAndPriceToCurrency)
    }

    val fiatList = listOf<Car>(
        Car("Веста", 103F, BrandCar.FIAT),
        Car("БТР", 10000F, BrandCar.FIAT)
    )

    @Test
    fun groupByBrand() {
        val resultlist = service.groupByBrand(listCars, BrandCar.FIAT)

        Assertions.assertEquals(resultlist, fiatList)
    }

    val nameList = listOf<String>(
        "Веста",
        "Ласточка",
        "Бурундук",
    )

    @Test
    fun conditionCarCount3NameList() {
        val resultlist = service.conditionCarCount3NameList(listCars) { it: Car -> it.price < 1000 }

        Assertions.assertEquals(resultlist,nameList)
    }


}