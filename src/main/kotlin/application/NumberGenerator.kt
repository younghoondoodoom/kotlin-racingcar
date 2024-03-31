package application

interface NumberGenerator<T : Number> {

    fun generate(from: T, util: T): T
}
