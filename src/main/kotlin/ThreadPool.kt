import java.util.*
import java.util.concurrent.Executor
import java.util.concurrent.LinkedBlockingQueue

class ThreadPool(threadQuantity: Int) : Executor {

    val threadList = LinkedList<WorkerThread>()

    private val taskQueue = LinkedBlockingQueue<Runnable>()

    init {
        if (threadQuantity < 1 || threadQuantity > MAX_THREADS_QUANTITY)
            throw IllegalArgumentException("Недоступное количество потоков!")
        repeat(threadQuantity) {
            val thread = WorkerThread(taskQueue)
            threadList.add(thread)
            thread.start()
        }
        println("Queue is ready!")
    }

    override fun execute(command: Runnable) {
        synchronized(taskQueue) {
            taskQueue.add(command)
            (taskQueue as Object).notify()
        }
    }

    fun shutdown() {
        threadList.forEach {
            it.interrupt()
            it.isStopped = true
        }
    }

    companion object {
        const val MAX_THREADS_QUANTITY = 8
    }
}