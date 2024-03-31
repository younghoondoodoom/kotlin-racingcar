package application.exception

private const val DEFAULT_EXCEPTION = "잘못된 요청입니다."

class ClientException(message: String? = DEFAULT_EXCEPTION) : ApplicationException(message)
