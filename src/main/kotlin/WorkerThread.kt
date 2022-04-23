import java.util.concurrent.LinkedBlockingQueue

class WorkerThread(
    private val taskQueue: LinkedBlockingQueue<Runnable>
) : Thread() {

    @Volatile
    var isWaited = false

    @Volatile
    var isStop = false

    override fun run() {
        while (true) {
            var task: Runnable?

            synchronized(taskQueue) {

                while (taskQueue.isEmpty() && !isWaited) {
                    runCatching { (taskQueue as Object).wait() }.onFailure { isWaited = true }
                }
                task = taskQueue.poll()
            }
            task?.run()
            if (isStop) break
        }
    }
}