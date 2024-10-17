package com.icure.cardinal_sdk

fun dispatchApi(
    methodName: String,
    arguments: Map<String, String>,
    resultCallback: (String?, String?, String?) -> Unit
): Boolean {
    val methodNameSplit = methodName.split(".")
    val actualMethodName = methodNameSplit.drop(1).joinToString(".")
    val apiName = methodNameSplit.first()
    return when (apiName) {
        "Patient" -> PatientApiDispatcher.dispatch(actualMethodName, arguments, resultCallback)
        // Rest
        else -> false
    }
}