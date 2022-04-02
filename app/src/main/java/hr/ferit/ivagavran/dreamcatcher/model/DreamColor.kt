package hr.ferit.ivagavran.dreamcatcher.model

sealed class DreamColor {
    object Red: DreamColor() {
        override fun toString(): String = "RED"
    }
    object Yellow: DreamColor() {
        override fun toString(): String = "YELLOW"
    }
    object Blue: DreamColor() {
        override fun toString(): String = "BLUE"
    }
    object Black: DreamColor() {
        override fun toString(): String = "BLACK"
    }
}