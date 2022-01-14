
class Tomteland{

    var hashMap : HashMap<String, List<String>> = HashMap()
    init {
        hashMap.put("Tomten", listOf( "Glader", "Butter",
            "Tröger", "Trötter", "Blyger", "Rådjuret", "Nyckelpigan", "Haren", "Räven",
            "Skumtomten", "Gråsuggan", "Butter", "Myran",
            "Dammråttan", "Bladlusen"))

        hashMap.put("Glader", listOf("Tröger", "Trötter", "Blyger", "Dammråttan", "Skumtomten"))

            hashMap.put("Butter", listOf("Rådjuret", "Nyckelpigan", "Haren", "Räven", "Gråsuggan", "Myran", "Bladlusen"))

                hashMap.put("Trötter", listOf("Dammråttan", "Skumtomten"))

                    hashMap.put("Skumtomten", listOf("Dammråttan"))

                        hashMap.put("Räven", listOf("Gråsuggan", "Myran", "Bladlusen"))

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
        return res.distinct()
    }
}

fun main() {
    val tomteland = Tomteland()

    val list: MutableList<String> = mutableListOf()
    println(tomteland.getUnderlings("Glader", list))
}