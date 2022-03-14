import io.mockk.*
import io.mockk.impl.annotations.AdditionalInterface
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TestZoo {


    @Test
    fun testZooSay() {
        var cot = mockk<Cat>()
        var zoo = Zoo(cot)
        every() { cot.say() } returns "Meeoooo"

        zoo.say(0)

        verify(exactly = 1){ cot.say() }

    }


    @Test
    fun testZooGo() {
        var cot = mockk<Cat>( relaxed = true)

        var zoo = Zoo(cot,cot)


        every{ cot.go(20)} returns Unit

        zoo.allGo(20)

        verify(exactly = 2){ cot.go(20) }
    }

    @Test
    fun testZooManySay() {
        var zoo = mockk<Zoo>()

        every{ zoo.say(1)} returns "ODIN"
        every{ zoo.say(2)} returns "DVA"

        Assertions.assertEquals("ODIN", zoo.say(1))
        Assertions.assertEquals("DVA", zoo.say(2))
    }
}




