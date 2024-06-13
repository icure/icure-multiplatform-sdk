package com.icure.sdk.js.crypto.entities

import com.icure.sdk.crypto.entities.FailedRequestDetails
import com.icure.sdk.crypto.entities.ShareAllPatientDataOptions
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.patient_fromJs
import com.icure.sdk.js.model.patient_toJs
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public
		fun shareAllPatientDataOptions_SharePatientDataError_toJs(obj: ShareAllPatientDataOptions.SharePatientDataError):
		ShareAllPatientDataOptionsJs_SharePatientDataErrorJs = when (obj) {
	is ShareAllPatientDataOptions.BulkShareFailure ->
			shareAllPatientDataOptions_BulkShareFailure_toJs(obj)
	is ShareAllPatientDataOptions.FailedRequest -> shareAllPatientDataOptions_FailedRequest_toJs(obj)
}

public
		fun shareAllPatientDataOptions_SharePatientDataError_fromJs(obj: ShareAllPatientDataOptionsJs_SharePatientDataErrorJs):
		ShareAllPatientDataOptions.SharePatientDataError = when {
	obj is ShareAllPatientDataOptionsJs_BulkShareFailureJs || obj.ktClass ==
			"com.icure.sdk.crypto.entities.ShareAllPatientDataOptions.BulkShareFailure" ->shareAllPatientDataOptions_BulkShareFailure_fromJs(obj
			as com.icure.sdk.js.crypto.entities.ShareAllPatientDataOptionsJs_BulkShareFailureJs)
	obj is ShareAllPatientDataOptionsJs_FailedRequestJs || obj.ktClass ==
			"com.icure.sdk.crypto.entities.ShareAllPatientDataOptions.FailedRequest" ->shareAllPatientDataOptions_FailedRequest_fromJs(obj
			as com.icure.sdk.js.crypto.entities.ShareAllPatientDataOptionsJs_FailedRequestJs)
	else -> throw
			IllegalArgumentException("""Unknown concrete implementation for com.icure.sdk.crypto.entities.ShareAllPatientDataOptions.SharePatientDataError: $obj""")
}

@Suppress("UNUSED_VARIABLE")
public
		fun shareAllPatientDataOptions_EntityResult_toJs(obj: ShareAllPatientDataOptions.EntityResult):
		ShareAllPatientDataOptionsJs_EntityResultJs {
	val success = obj.success
	val error = obj.error?.let { nonNull1 ->
		shareAllPatientDataOptions_SharePatientDataError_toJs(nonNull1)
	}
	val modified = intToNumber(obj.modified)
	return ShareAllPatientDataOptionsJs_EntityResultJs(js("{" +
		"success:success," +
		"error:error," +
		"modified:modified" +
	"}"))
}

public
		fun shareAllPatientDataOptions_EntityResult_fromJs(obj: ShareAllPatientDataOptionsJs_EntityResultJs):
		ShareAllPatientDataOptions.EntityResult {
	val success = obj.success
	val error = obj.error?.let { nonNull1 ->
		shareAllPatientDataOptions_SharePatientDataError_fromJs(nonNull1)
	}
	val modified = numberToInt(obj.modified, "obj.modified")
	return ShareAllPatientDataOptions.EntityResult(
		success = success,
		error = error,
		modified = modified,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun shareAllPatientDataOptions_Result_toJs(obj: ShareAllPatientDataOptions.Result):
		ShareAllPatientDataOptionsJs_ResultJs {
	val patient = patient_toJs(obj.patient)
	val statuses = mapToObject(
		obj.statuses,
		{ x1: ShareAllPatientDataOptions.ShareableEntity ->
			x1.name
		},
		{ x1: ShareAllPatientDataOptions.EntityResult ->
			shareAllPatientDataOptions_EntityResult_toJs(x1)
		},
	)
	return ShareAllPatientDataOptionsJs_ResultJs(js("{" +
		"patient:patient," +
		"statuses:statuses" +
	"}"))
}

public fun shareAllPatientDataOptions_Result_fromJs(obj: ShareAllPatientDataOptionsJs_ResultJs):
		ShareAllPatientDataOptions.Result {
	val patient = patient_fromJs(obj.patient)
	val statuses = objectToMap(
		obj.statuses,
		"obj.statuses",
		{ x1: String ->
			ShareAllPatientDataOptions.ShareableEntity.valueOf(x1)
		},
		{ x1: ShareAllPatientDataOptionsJs_EntityResultJs ->
			shareAllPatientDataOptions_EntityResult_fromJs(x1)
		},
	)
	return ShareAllPatientDataOptions.Result(
		patient = patient,
		statuses = statuses,
	)
}

@Suppress("UNUSED_VARIABLE")
public
		fun shareAllPatientDataOptions_BulkShareFailure_toJs(obj: ShareAllPatientDataOptions.BulkShareFailure):
		ShareAllPatientDataOptionsJs_BulkShareFailureJs {
	val errors = listToArray(
		obj.errors,
		{ x1: FailedRequestDetails ->
			failedRequestDetails_toJs(x1)
		},
	)
	val message = obj.message
	return ShareAllPatientDataOptionsJs_BulkShareFailureJs(js("{" +
		"errors:errors," +
		"message:message" +
	"}"))
}

public
		fun shareAllPatientDataOptions_BulkShareFailure_fromJs(obj: ShareAllPatientDataOptionsJs_BulkShareFailureJs):
		ShareAllPatientDataOptions.BulkShareFailure {
	val errors = arrayToList(
		obj.errors,
		"obj.errors",
		{ x1: FailedRequestDetailsJs ->
			failedRequestDetails_fromJs(x1)
		},
	)
	val message = obj.message
	return ShareAllPatientDataOptions.BulkShareFailure(
		errors = errors,
		message = message,
	)
}

@Suppress("UNUSED_VARIABLE")
public
		fun shareAllPatientDataOptions_FailedRequest_toJs(obj: ShareAllPatientDataOptions.FailedRequest):
		ShareAllPatientDataOptionsJs_FailedRequestJs {
	val exception = obj.exception
	return ShareAllPatientDataOptionsJs_FailedRequestJs(js("{" +
		"exception:exception" +
	"}"))
}

public
		fun shareAllPatientDataOptions_FailedRequest_fromJs(obj: ShareAllPatientDataOptionsJs_FailedRequestJs):
		ShareAllPatientDataOptions.FailedRequest {
	val exception = obj.exception
	return ShareAllPatientDataOptions.FailedRequest(
		exception = exception,
	)
}
