package com.icure.sdk.utils

import com.icure.kryptom.utils.base64Decode
import io.ktor.util.date.GMTDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

@Serializable
data class JwtPayload(
	val exp: Long,
	@SerialName("tac") val tokenAuthenticationClass: Int?
)

fun decodeClaims(jwt: String): JwtPayload {
	val parts = jwt.split(".").also {
		check(it.size == 3) { "Invalid JWT token" }
	}
	return Serialization.lenientJson.decodeFromString<JwtPayload>(base64Decode(parts[1]).decodeToString())
}

/**
 * Checks if a base-64 encoded JWT has an invalid format or is expired.
 */
fun isJwtExpiredOrInvalid(jwt: String, refreshPadding: Duration = 0L.seconds): Boolean = runCatching {
		val payload = decodeClaims(jwt)
		(payload.exp * 1000) < (GMTDate().timestamp - refreshPadding.inWholeMilliseconds)
	}.getOrDefault(false)

