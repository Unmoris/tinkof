import io.mockk.impl.annotations.SpyK
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class StackTest {
    @SpyK
    var stack = Stack<String>()

    @Test
    fun pushString() {
        stack.push("Hello world")
        Assertions.assertEquals("Hello world", stack.peek())
    }

    @Test
    fun popStringAndNull() {
        stack.push("Hello world")

        Assertions.assertEquals("Hello world", stack.pop())
        Assertions.assertEquals(null, stack.pop())
    }

    @Test
    fun sizeStack() {
        stack.push("Hello world")
        stack.push("Hello world")
        Assertions.assertEquals(2, stack.size)
    }
}