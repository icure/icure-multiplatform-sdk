import com.icure.cardinal.sdk.dart.Initializers
import com.icure.cardinal_sdk.api.dispatchApi
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

object InitializersPlugin : MethodChannel.MethodCallHandler {
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
        "initialize" -> Initializers.initializeSdk(
            resultCallback,
            parameters.getValue("authenticationMethod"),
        )
        else -> null
    }?.let { true } ?: false
}