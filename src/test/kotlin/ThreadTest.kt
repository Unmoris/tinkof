import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ThreadsTest {


    @Test
    fun threadPoolTest() {

        val threadPool = ThreadPool(8)

        Assertions.assertDoesNotThrow {
            for (i in 0..8) {
                threadPool.execute {
                    println("$i - задача выполняется...")
                }
            }
            threadPool.shutdown()
        }
    }

    @Test
    fun exceptionWhenThreadsQuantityIsUnavailable() {
        val result = assertThrows<IllegalArgumentException> {
            ThreadPool(20)
        }
        Assertions.assertEquals("Недоступное количество потоков!", result.message)
    }
}