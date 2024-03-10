package application.exception

private const val DEFAULT_EXCEPTION = "어플리케이션 예외가 발생했습니다."

open class ApplicationException(message: String? = DEFAULT_EXCEPTION) : RuntimeException(message)
