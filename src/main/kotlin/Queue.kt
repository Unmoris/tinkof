class Queue<T> {
    var size: Int = 0
    var head: Node<T>? = null
    var tail: Node<T>? = null

    protected fun addSize0(NewElem: T): Boolean {
        val newNode = Node(null, NewElem)
        head = newNode
        tail = newNode
        size++
        return true
    }

    protected fun addInTail(NewElem: T): Boolean {
        val newNode = Node(null, NewElem)
        tail?.Next = newNode
        size++
        return true
    }

    protected fun add(NewElem: T): Boolean {
        val result: Boolean = if (size == 0) {
            this.addSize0(NewElem)
        } else {
            this.addInTail(NewElem)
        }
        return result
    }

    protected fun returnValueHead(): T? {
        var returnValue: T? = null
        if (size != 0) {
            returnValue = head?.value
        } else
            throw NoSuchElementException("IS EMPTY")
        return returnValue
    }

    protected fun pushHead(): T? {
        var returnValue: T? = null
        if (size != 0) {
            returnValue = head?.value
            head = head?.Next
            if (head == null) {
                tail = null
            }
            size--
        }
        return returnValue
    }

    fun element(): T? {
        return this.returnValueHead()
    }

    fun remove(): T? {
        val temp: T? = this.returnValueHead()
        this.pushHead()
        return temp
    }

    fun peek(): T? {
        return head?.value
    }

    fun poll(): T? {
        return this.pushHead()
    }

    fun offer(newElement: T): Boolean {
        return this.add(newElement)
    }

}