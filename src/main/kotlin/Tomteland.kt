
class Tomteland{

    var hashMap : HashMap<String, List<String>> = HashMap()
    init {
        hashMap.put("Tomten", listOf( "Glader", "Butter"))

        hashMap.put("Glader", listOf("Tröger", "Trötter", "Blyger"))

            hashMap.put("Butter", listOf("Rådjuret", "Nyckelpigan", "Haren", "Räven"))

                hashMap.put("Trötter", listOf("Skumtomten"))

                    hashMap.put("Skumtomten", listOf("Dammråttan"))

                        hashMap.put("Räven", listOf("Gråsuggan", "Myran"))

                            hashMap.put("Myran", listOf("Bladlusen"))
    }

    fun getUnderlings(currentName: String, res: MutableList<String>): List<String> {
        hashMap.get(currentName)?.forEach {
            res.add(it)
            if(hashMap.contains(it)) {
                hashMap.get(it)!!.forEach {
                    res += getUnderlings(it, res)
                }
            }
        }
        return res
    }
}

fun main() {
    val tomteland = Tomteland()

    val list: MutableList<String> = mutableListOf()
    println(tomteland.getUnderlings("Glader", list))
}