package it.macgood.mathanalysisdevserver.demidovich

data class Task(
    var id: Long,
    var questionNumber: String,
    var questionText: String,
    var formula: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Task

        if (id != other.id) return false
        if (questionNumber != other.questionNumber) return false
        if (questionText != other.questionText) return false
        if (!formula.contentEquals(other.formula)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + questionNumber.hashCode()
        result = 31 * result + questionText.hashCode()
        result = 31 * result + formula.contentHashCode()
        return result
    }
}