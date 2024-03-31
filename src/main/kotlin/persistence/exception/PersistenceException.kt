package persistence.exception

private const val DEFAULT_MESSAGE = "저장소 예외가 발생했습니다."

open class PersistenceException(message: String? = DEFAULT_MESSAGE) : RuntimeException(message)
