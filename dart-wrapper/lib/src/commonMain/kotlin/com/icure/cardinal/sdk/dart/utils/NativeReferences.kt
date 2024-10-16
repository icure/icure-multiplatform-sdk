package com.icure.cardinal.sdk.dart.utils

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.random.Random

/**
 * Allows using native objects over method channels, by tying an instance to a unique identifier.
 */
object NativeReferences {
	private var references = mapOf<String, Any>()
	private val writeMutex = Mutex(locked = false)

	@OptIn(ExperimentalStdlibApi::class)
	suspend fun create(obj: Any): String = writeMutex.withLock {
		var id: String
		do {
			id = Random.nextBytes(16).toHexString().let { hex ->
				"${hex.substring(0, 8)}-${hex.substring(8, 12)}-${hex.substring(12, 16)}-${hex.substring(16, 20)}-${hex.substring(20)}"
			}
		}  while (references.containsKey(id))
		references += (id to obj)
		id
	}

	suspend fun delete(referenceId: String): Unit = writeMutex.withLock {
		require (references.containsKey(referenceId)) {
			"Native object for reference id $referenceId not found"
		}
		references -= referenceId
	}

	fun getAsAny(referenceId: String): Any =
		references[referenceId] ?: throw IllegalArgumentException(
			"Native object for reference id $referenceId not found"
		)

	inline fun <reified T : Any> get(referenceId: String): T =
		getAsAny(referenceId).let { reference ->
			require (reference is T) {
				"Native object for reference id $referenceId does not conform to expected type ${T::class.simpleName}"
			}
			reference
		}
}


