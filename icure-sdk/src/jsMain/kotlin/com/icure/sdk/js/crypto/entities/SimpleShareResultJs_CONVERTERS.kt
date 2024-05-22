package com.icure.sdk.js.crypto.entities

import com.icure.sdk.crypto.entities.FailedRequestDetails
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.base.HasEncryptionMetadataJs
import com.icure.sdk.model.base.HasEncryptionMetadata

public fun <T : HasEncryptionMetadata, T_JS : HasEncryptionMetadataJs>
		simpleShareResult_toJs(obj: SimpleShareResult<T>, convertT: (T) -> T_JS):
		SimpleShareResultJs<T_JS> = when (obj) {
	is SimpleShareResult.Success<T> -> simpleShareResult_Success_toJs(
		obj,
		{ x1: T ->
			convertT(x1)
		},
	) as SimpleShareResultJs<T_JS>
	is SimpleShareResult.Failure -> simpleShareResult_Failure_toJs(obj) as SimpleShareResultJs<T_JS>
	else -> throw
			IllegalArgumentException("""Unknown concrete implementation for com.icure.sdk.crypto.entities.SimpleShareResult: $obj""")
}

public fun <T : HasEncryptionMetadataJs, T_KT : HasEncryptionMetadata>
		simpleShareResult_fromJs(obj: SimpleShareResultJs<T>, convertT: (T) -> T_KT):
		SimpleShareResult<T_KT> = when {
	obj is SimpleShareResultJs_SuccessJs<T> || obj.ktClass ==
			"com.icure.sdk.crypto.entities.SimpleShareResult.Success" ->simpleShareResult_Success_fromJs(
		obj as com.icure.sdk.js.crypto.entities.SimpleShareResultJs_SuccessJs<T>,
		{ x1: T ->
			convertT(x1)
		},
	) as SimpleShareResult<T_KT>
	obj is SimpleShareResultJs_FailureJs || obj.ktClass ==
			"com.icure.sdk.crypto.entities.SimpleShareResult.Failure" ->simpleShareResult_Failure_fromJs(obj
			as com.icure.sdk.js.crypto.entities.SimpleShareResultJs_FailureJs) as SimpleShareResult<T_KT>
	else -> throw
			IllegalArgumentException("""Unknown concrete implementation for com.icure.sdk.crypto.entities.SimpleShareResult: $obj""")
}

public fun <T : HasEncryptionMetadata, T_JS : HasEncryptionMetadataJs>
		simpleShareResult_Success_toJs(obj: SimpleShareResult.Success<T>, convertT: (T) -> T_JS):
		SimpleShareResultJs_SuccessJs<T_JS> {
	val updatedEntity = convertT(obj.updatedEntity)
	return SimpleShareResultJs_SuccessJs<T_JS>(js("{" +
		"updatedEntity:updatedEntity," +
	"}"))
}

public fun <T : HasEncryptionMetadataJs, T_KT : HasEncryptionMetadata>
		simpleShareResult_Success_fromJs(obj: SimpleShareResultJs_SuccessJs<T>, convertT: (T) -> T_KT):
		SimpleShareResult.Success<T_KT> {
	val updatedEntity = convertT(obj.updatedEntity)
	return SimpleShareResult.Success<T_KT>(
		updatedEntity = updatedEntity,
	)
}

public fun simpleShareResult_Failure_toJs(obj: SimpleShareResult.Failure):
		SimpleShareResultJs_FailureJs {
	val errorsDetails = listToArray(
		obj.errorsDetails,
		{ x1: FailedRequestDetails ->
			failedRequestDetails_toJs(x1)
		},
	)
	return SimpleShareResultJs_FailureJs(js("{" +
		"errorsDetails:errorsDetails," +
	"}"))
}

public fun simpleShareResult_Failure_fromJs(obj: SimpleShareResultJs_FailureJs):
		SimpleShareResult.Failure {
	val errorsDetails = arrayToList(
		obj.errorsDetails,
		"obj.errorsDetails",
		{ x1: FailedRequestDetailsJs ->
			failedRequestDetails_fromJs(x1)
		},
	)
	return SimpleShareResult.Failure(
		errorsDetails = errorsDetails,
	)
}
