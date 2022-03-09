import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class TestZoo {


    @Test
    fun testZooSay() {
        var cot = mockk<Cat>()
        var zoo = Zoo(cot)
        every { cot.say() } returns "Meeoooo"

        zoo.say(0)

        verify(exactly = 1){ cot.say() }

    }

    @Test
    fun testZooGo() {
        var cot = mockk<Cat>()
        var zoo = Zoo(cot,cot)

        every { cot.go(20) } returns Unit

        zoo.allGo(20)

        verify(exactly = 2){ cot.go(20) }
    }
}

