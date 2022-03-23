import io.mockk.impl.annotations.SpyK
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class testQueue {
    @SpyK
    var queue: Queue<Int> = Queue<Int>()

    @Test
    fun testAddNewAndPollElement() {
        queue.offer(3)
        queue.offer(5)

        val firstResult = queue.poll()
        val secondResult = queue.poll()
        val thirdResult = queue.poll()

        Assertions.assertEquals(firstResult, 3)
        Assertions.assertEquals(secondResult, 5)
        Assertions.assertEquals(thirdResult, null)
    }

    @Test
    fun testAddNewAndElement() {
        queue.offer(3)

        val result = queue.element()

        Assertions.assertEquals(result, 3)
    }

    @Test
    fun testSizeElement() {
        queue.offer(3)

        val result = queue.size

        Assertions.assertEquals(result, 1)
    }

    @Test
    fun testPeekElement() {
        queue.offer(3)

        val resultFirst = queue.peek()
        val resultSecond = queue.peek()

        Assertions.assertEquals(resultFirst, 3)
        Assertions.assertEquals(resultSecond, 3)
    }

    @Test
    fun testOfferElement() {
        val result = queue.offer(3)

        Assertions.assertEquals(result, true)
    }

}