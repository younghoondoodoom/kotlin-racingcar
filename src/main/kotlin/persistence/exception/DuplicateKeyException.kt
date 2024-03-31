package persistence.exception

private const val DEFAULT_MESSAGE = "키가 중복되었습니다."

class DuplicateKeyException(message: String? = DEFAULT_MESSAGE) : PersistenceException(message)
