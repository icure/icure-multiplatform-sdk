package com.icure.sdk.py.utils

import com.icure.sdk.utils.Serialization
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.StableRef
import kotlinx.cinterop.cstr
import kotlinx.cinterop.invoke
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive


private fun Throwable.stringForPy() =
	stackTraceToString()

/**
 * Converts the kotlin result to a json representation of result understandable by python.
 * Used by method that only returns data entities without any logic / entities that can be safely serialized.
 *
 * The caller of the method will be in charge of disposing the string.
 */
internal fun <T : Any> Result<T?>.toPyString(
	serializer: KSerializer<T>,
) =
	fold(
		onSuccess = { res ->
			JsonObject(mapOf("success" to (res?.let { Serialization.fullJson.encodeToJsonElement(serializer, it) } ?: JsonNull)))
		},
		onFailure = { e ->
			JsonObject(mapOf("failure" to JsonPrimitive(e.stringForPy())))
		}
	).toString()

/**
 * Calls the python callback with the result as a string.
 * Used by method that only returns data entities without any logic / entities that can be safely serialized.
 *
 * The string should not be used after the callback terminates, since the strings will be automatically disposed by
 * kotlin after the callback completes (they should be copied or decoded before the callback returns).
 */
@OptIn(ExperimentalForeignApi::class)
internal fun <T : Any> Result<T?>.toPyStringAsyncCallback(
	serializer: KSerializer<T>,
	callback: CPointer<CFunction<(result: CValues<ByteVarOf<Byte>>?, error: CValues<ByteVarOf<Byte>>?) -> Unit>>,
) =
	fold(
		onSuccess = { res ->
			callback.invoke(
				res?.let { Serialization.fullJson.encodeToString(serializer, it).cstr } ?: "null".cstr,
				null
			)
		},
		onFailure = { e ->
			callback.invoke(null, e.stringForPy().cstr)
		}
	).toString()

/**
 * Same as [toPyString] but the successful result is already encoded to json
 */
internal fun Result<JsonElement>.toPyJson() =
	fold(
		onSuccess = { res ->
			JsonObject(mapOf("success" to res))
		},
		onFailure = { e ->
			JsonObject(mapOf("failure" to JsonPrimitive(e.stringForPy())))
		}
	).toString()

/**
 * Same as [toPyStringAsyncCallback] but the successful result is already encoded to json
 */
@OptIn(ExperimentalForeignApi::class)
internal fun Result<JsonElement>.toPyJsonAsyncCallback(
	callback: CPointer<CFunction<(result: CValues<ByteVarOf<Byte>>?, error: CValues<ByteVarOf<Byte>>?) -> Unit>>,
) =
	fold(
		onSuccess = { res ->
			callback.invoke(res.toString().cstr, null)
		},
		onFailure = { e ->
			callback.invoke(null, e.stringForPy().cstr)
		}
	).toString()

/**
 * If the result is a failure calls the callback providing the error.
 *
 * The error string should not be used after the callback terminates, since it will be automatically disposed by
 * kotlin after the callback completes (it should be copied or decoded before the callback returns).
 */
@OptIn(ExperimentalForeignApi::class)
internal fun Result<*>.failureToPyStringAsyncCallback(
	callback: CPointer<CFunction<(result: CValues<ByteVarOf<Byte>>?, error: CValues<ByteVarOf<Byte>>?) -> Unit>>,
) {
	onFailure { e ->
		callback.invoke(null, e.stringForPy().cstr)
	}
}


@OptIn(ExperimentalForeignApi::class)
class PyResult internal constructor(
	val success: COpaquePointer?,
	val failure: String?
)

/**
 * Converts the kotlin result to a result in an appropriate format for python. If this result is a success it contains a
 * direct reference to the kotlin object instance, and therefore is suitable for cases where the output has some logic.
 *
 * The caller will be in charge of disposing the PyResult by:
 * - Using the DisposeStablePointer utility method on the result itself
 * - Using the DisposeString utility method on the failure component if not null
 * - Using the DisposeStablePointer on the success if not null (will be not null only if failure is not null, but may
 *   be null if failure is null). This value may still be use after it is not needed anymore.
 */
@OptIn(ExperimentalForeignApi::class)
internal fun <M : Any, P : Any> Result<M?>.toPyResult(
	multiplatformToPythonType: (M) -> P
) =
	fold(
		onSuccess = { res ->
			PyResult(res?.let { StableRef.create(multiplatformToPythonType(it)).asCPointer() }, null)
		},
		onFailure = { e ->
			PyResult(null, e.stringForPy())
		}
	)

/**
 * Converts the kotlin result to a result in an appropriate format for python. This result contains a direct reference
 * to the kotlin object instance, and therefore is suitable for cases where the output has some logic.
 *
 * The error string will be disposed automatically by kotlin after the callback completes, but the successful result (if
 * not null) needs to be disposed manually by the caller.
 */
@OptIn(ExperimentalForeignApi::class)
internal fun <M : Any, P : Any> Result<M?>.toPyResultAsyncCallback(
	callback: CPointer<CFunction<(result: COpaquePointer?, error: CValues<ByteVarOf<Byte>>?) -> Unit>>,
	multiplatformToPythonType: (M) -> P
) =
	fold(
		onSuccess = { res ->
			callback.invoke(res?.let { StableRef.create(multiplatformToPythonType(it)).asCPointer() }, null)
		},
		onFailure = { e ->
			callback.invoke(null, e.stringForPy().cstr)
		}
	)

/**
 * If the result is a failure calls the callback providing the error.
 *
 * The error string should not be used after the callback terminates, since it will be automatically disposed by
 * kotlin after the callback completes (it should be copied or decoded before the callback returns).
 */
@OptIn(ExperimentalForeignApi::class)
internal fun Result<*>.failureToPyResultAsyncCallback(
	callback: CPointer<CFunction<(result: COpaquePointer?, error: CValues<ByteVarOf<Byte>>?) -> Unit>>,
) {
	onFailure { e ->
		callback.invoke(null, e.stringForPy().cstr)
	}
}
