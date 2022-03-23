class Stack<T> {
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

    protected fun addInHead(NewElem: T): Boolean {
        val newNode = Node(head, NewElem)
        head = newNode
        size++
        return true
    }

    protected fun add(NewElem: T): Boolean {
        val result: Boolean = if (size == 0) {
            this.addSize0(NewElem)
        } else {
            this.addInHead(NewElem)
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

    protected fun deleteHead() {
        head = head?.Next
    }

    protected fun deleteTail() {
        tail = null
    }

    protected fun pushHead(): T? {
        var returnValue: T? = null
        if (size != 0) {
            returnValue = head?.value
            deleteHead()
            if (head == null) {
                deleteTail()
            }
            size--
        }
        return returnValue
    }

    fun push(newElement: T) {
        this.add(newElement)
    }

    fun pop(): T? {
        return this.pushHead()
    }

    fun peek(): T? {
        return this.returnValueHead()
    }
}