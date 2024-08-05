package com.icure.sdk.auth

/**
 * Allows initializing processes for the registration and authentication of users.
 */
interface AuthenticationProcessApi {
	/**
	 * Contains information about an authentication process request, result of the [executeProcess] method.
	 * You are not supposed to initialize this class yourself or use its content directly.
	 */
	class AuthenticationProcessRequest internal constructor(
		internal val messageGwUrl: String,
		internal val specId: String,
		internal val requestId: String
	)


	/**
	 * Executes an authentication process.
	 * @param messageGatewayUrl the url of the iCure message gateway you want to use. Usually this should be
	 * @param externalServicesSpecId an identifier that allows the message gateway to connect the request to your
	 * services for email / sms communication of the process tokens.
	 * @param processId the id of the process you want to execute.
	 * @param userTelecomType the type of telecom number used for the user.
	 * @param userTelecom the telecom number of the user for which you want to execute the process. This should be an
	 * email address or phone number depending on the type of process you are executing.
	 * @param captchaType the type of captcha you use with your processes.
	 * @param captchaKey the key obtained by resolving the captcha. Used to prevent abuse of the message gateway and
	 * connected external services.
	 */
	fun executeProcess(
		messageGatewayUrl: String,
		externalServicesSpecId: String,
		processId: String,
		userTelecomType: AuthenticationProcessTelecomType,
		userTelecom: String,
		captchaType: AuthenticationProcessCaptchaType,
		captchaKey: String,
		processTemplateParameters: Map<String, String>
	): AuthenticationProcessRequest
}