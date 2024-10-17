package com.icure.cardinal_sdk

import com.icure.cardinal.sdk.dart.api.PatientApi

object PatientApiDispatcher {
    fun dispatch(
        methodName: String,
        parameters: Map<String, String>,
        callback: (String?, String?, String?) -> Unit
    ): Boolean = when (methodName) {
        "createPatient" -> createPatient(parameters, callback)
        "tryAndRecover.getPatient" -> tryAndRecover_getPatient(parameters, callback)
        else -> null
    }?.let { true } ?: false

    private fun createPatient(
        parameters: Map<String, String>,
        callback: (String?, String?, String?) -> Unit
    ) {
        PatientApi.createPatient(
            callback,
            parameters.getValue("sdkId"),
            parameters.getValue("patient"),
        )
    }

    private fun tryAndRecover_getPatient(
        parameters: Map<String, String>,
        callback: (String?, String?, String?) -> Unit
    ) {
        PatientApi.tryAndRecover.getPatient(
            callback,
            parameters.getValue("sdkId"),
            parameters.getValue("entityId"),
        )
    }
}