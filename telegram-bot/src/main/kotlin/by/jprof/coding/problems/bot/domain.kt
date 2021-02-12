package by.jprof.coding.problems.bot

data class Problem(
    val number: Int,
    val link: String,
    val id: String = link.split("/").last(),
    val title: String,
    val acceptance: String,
    val difficulty: String,
    val question: String = "",
    val tags: List<Tag> = emptyList(),
    val hints: List<Hint> = emptyList()
)

data class Tag(val link : String, val title: String)

data class Hint(val id: String, val content: String)

enum class Platform {
    LEETCODE
}