class SuperHashMap<K, V>(
    private val initialSize: Int = 16,
    private val loadFactor: Float = 0.75F
) {

    private var list: MutableList<V?> = MutableList(initialSize) { null }

    fun put(key: K, value: V) {
        if (needResize()) resize()
        val hashCode = key.hashCode()
        val sizeWithZero = list.size - 1
        val intKey = (sizeWithZero).and(hashCode)
        println("hashCode = $hashCode, intKey = $intKey")
        if (intKey > sizeWithZero) throw IllegalStateException("intKey out of bounds")
        list[intKey] = value
    }

    fun get(key: K): V? {
        val hashCode = key.hashCode()
        val sizeWithZero = list.size - 1
        val intKey = (sizeWithZero).and(hashCode)
        if (intKey > sizeWithZero) return null
        return list[intKey]
    }

    private fun needResize(): Boolean {
        return (list.filterNotNull().size / list.size) >= loadFactor
    }

    private fun resize() {
        val newList: MutableList<V?> = MutableList((initialSize * loadFactor).toInt()) {
            if (it > list.size) null else list[it]
        }
        list = newList
    }
}