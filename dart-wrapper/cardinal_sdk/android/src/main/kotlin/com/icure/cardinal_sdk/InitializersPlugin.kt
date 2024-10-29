package com.icure.cardinal_sdk

import android.content.Context
import com.icure.cardinal.sdk.dart.Initializers
import com.icure.cardinal.sdk.dart.options.StorageHelper
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

class InitializersPlugin(
    private val applicationContext: Context
) : MethodChannel.MethodCallHandler {
    @Suppress("UNCHECKED_CAST")
    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
        if (
            !dispatch(
                methodName = call.method,
                parameters = (call.arguments as Map<String, String>?).orEmpty()
            ) { success, errorCode, errorMessage ->
                if (errorCode != null)
                    result.error(errorCode, errorMessage, null)
                else
                    result.success(success)
            }
        ) result.notImplemented()
    }

    private fun dispatch(
        methodName: String,
        parameters: Map<String, String>,
        resultCallback: (
            String?,
            String?,
            String?,
        ) -> Unit,
    ): Boolean = when (methodName) {
        "initialize" -> initialize(parameters, resultCallback)
        "initializeWithAuthProcess" -> initializeWithAuthProcess(parameters, resultCallback)
        "completeAuthentication" -> completeAuthentication(parameters, resultCallback)
        else -> null
    }?.let { true } ?: false

    private fun initialize(
        parameters: Map<String, String>,
        resultCallback: (
            String?,
            String?,
            String?,
        ) -> Unit,
    ) {
        Initializers.initializeSdk(
            resultCallback,
            applicationIdString = parameters.getValue("applicationId"),
            baseUrlString = parameters.getValue("baseUrl"),
            authenticationMethodString = parameters.getValue("authenticationMethod"),
            storageFacade = StorageHelper.getStorage(
                parameters.getValue("storageOptions"),
                applicationContext
            ),
            optionsString = parameters.getValue("options")
        )
    }

    private fun initializeWithAuthProcess(
        parameters: Map<String, String>,
        resultCallback: (
            String?,
            String?,
            String?,
        ) -> Unit,
    ) {
        Initializers.initializeWithAuthProcess(
            resultCallback,
            applicationIdString = parameters.getValue("applicationId"),
            baseUrlString = parameters.getValue("baseUrl"),
            messageGatewayUrlString = parameters.getValue("messageGatewayUrl"),
            externalServicesSpecIdString = parameters.getValue("externalServicesSpecId"),
            processIdString = parameters.getValue("processId"),
            userTelecomTypeString = parameters.getValue("userTelecomType"),
            userTelecomString = parameters.getValue("userTelecom"),
            captchaOptionsString = parameters.getValue("captchaOptions"),
            baseStorage = StorageHelper.getStorage(
                parameters.getValue("storageOptions"),
                applicationContext
            ),
            authenticationProcessTemplateParametersString = parameters.getValue("authenticationProcessTemplateParameters"),
            optionsString = parameters.getValue("options"),
        )
    }

    private fun completeAuthentication(
        parameters: Map<String, String>,
        resultCallback: (
            String?,
            String?,
            String?,
        ) -> Unit,
    ) {
        Initializers.completeAuthentication(
            resultCallback,
            authenticationStepId = parameters.getValue("authenticationStepId"),
            validationCodeString = parameters.getValue("validationCode"),
        )
    }
}