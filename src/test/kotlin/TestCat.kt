import io.mockk.impl.annotations.SpyK
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TestCat {
    @SpyK
    var cot = Cat(1.0f, 10, 100.0, "Kitty")

    @Test
    fun testCatGoDistance20() {

        cot.go(20)

        Assertions.assertEquals(98.0, cot.satiety)
    }

    @Test
    fun testCatGoDistance0() {

        cot.go(0)

        Assertions.assertEquals(100.0, cot.satiety)
    }
}