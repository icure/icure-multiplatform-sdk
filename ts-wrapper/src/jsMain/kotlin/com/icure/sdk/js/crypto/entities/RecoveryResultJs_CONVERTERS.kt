package com.icure.sdk.js.crypto.entities

import com.icure.sdk.crypto.entities.RecoveryDataUseFailureReason
import com.icure.sdk.crypto.entities.RecoveryResult
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun <T, T_JS> recoveryResult_toJs(obj: RecoveryResult<T>, convertT: (T) -> T_JS):
		RecoveryResultJs<T_JS> = when (obj) {
	is RecoveryResult.Success<T> -> recoveryResult_Success_toJs(
		obj,
		{ x1: T ->
			convertT(x1)
		},
	) as RecoveryResultJs<T_JS>
	is RecoveryResult.Failure -> recoveryResult_Failure_toJs(obj) as RecoveryResultJs<T_JS>
}

public fun <T, T_KT> recoveryResult_fromJs(obj: RecoveryResultJs<T>, convertT: (T) -> T_KT):
		RecoveryResult<T_KT> = when {
	obj is RecoveryResultJs_SuccessJs<T> || obj.ktClass ==
			"com.icure.sdk.crypto.entities.RecoveryResult.Success" ->recoveryResult_Success_fromJs(
		obj as com.icure.sdk.js.crypto.entities.RecoveryResultJs_SuccessJs<T>,
		{ x1: T ->
			convertT(x1)
		},
	) as RecoveryResult<T_KT>
	obj is RecoveryResultJs_FailureJs || obj.ktClass ==
			"com.icure.sdk.crypto.entities.RecoveryResult.Failure" ->recoveryResult_Failure_fromJs(obj as
			com.icure.sdk.js.crypto.entities.RecoveryResultJs_FailureJs) as RecoveryResult<T_KT>
	else -> throw
			IllegalArgumentException("""Unknown concrete implementation for com.icure.sdk.crypto.entities.RecoveryResult: $obj""")
}

@Suppress("UNUSED_VARIABLE")
public fun <T, T_JS> recoveryResult_Success_toJs(obj: RecoveryResult.Success<T>,
		convertT: (T) -> T_JS): RecoveryResultJs_SuccessJs<T_JS> {
	val data = convertT(obj.data)
	return RecoveryResultJs_SuccessJs<T_JS>(js("{" +
		"data:data," +
	"}"))
}

public fun <T, T_KT> recoveryResult_Success_fromJs(obj: RecoveryResultJs_SuccessJs<T>,
		convertT: (T) -> T_KT): RecoveryResult.Success<T_KT> {
	val data = convertT(obj.data)
	return RecoveryResult.Success<T_KT>(
		data = data,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun recoveryResult_Failure_toJs(obj: RecoveryResult.Failure): RecoveryResultJs_FailureJs {
	val reason = obj.reason.name
	return RecoveryResultJs_FailureJs(js("{" +
		"reason:reason," +
	"}"))
}

public fun recoveryResult_Failure_fromJs(obj: RecoveryResultJs_FailureJs): RecoveryResult.Failure {
	val reason = RecoveryDataUseFailureReason.valueOf(obj.reason)
	return RecoveryResult.Failure(
		reason = reason,
	)
}
