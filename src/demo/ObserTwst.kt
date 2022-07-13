package demo

interface IObserver {
    fun update(message: Int)
}

interface ISubject {
    fun add(observable: IObserver)
    fun remove(observable: IObserver)
    fun notify(message: Int)
}

class Observer: IObserver {
    override fun update(message: Int) {}
}

class SubjectService: ISubject {
    val list = mutableListOf<IObserver>()
    override fun add(observable: IObserver) {
        list.add(observable)
    }

    override fun remove(observable: IObserver) {
        list.remove(observable)
    }



    override fun notify(message: Int) {
        list.forEach {
            it.update(message)
        }
    }

}