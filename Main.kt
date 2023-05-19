fun main() {
    println("Hello World!")

    val superHashMap = SuperHashMap<String, String>()
    superHashMap.put("No", "Nooooooooooooo")
    superHashMap.put("Yes", "Si")
    superHashMap.put("I'm", "a human")
    superHashMap.put("Hi", "man")
    superHashMap.put("Lol", "Kek")

    println(superHashMap.get("No"))
    println(superHashMap.get("Yes"))
    println(superHashMap.get("I'm"))
    println(superHashMap.get("Lol"))
    println(superHashMap.get("Hi"))
}
