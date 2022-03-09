import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TestDog {
    @Test
    fun testGodDistance0() {
        var dog = Dog(1.0f, 10, 100.0)

        dog.go(0)

        Assertions.assertEquals(100.0, dog.satiety)
    }

    @Test
    fun testGodDistance15() {
        var dog = Dog(1.0f, 10, 100.0)

        dog.go(15)

        Assertions.assertEquals(96.0, dog.satiety)
    }
}