package com.icure.cardinal.sdk.auth

/**
 * Allows initializing processes for the registration and authentication of users.
 */
interface AuthenticationProcessApi {
	/**
	 * Executes an authentication process.
	 * @param messageGatewayUrl the url of the iCure message gateway you want to use. Usually this should be
	 * @param externalServicesSpecId an identifier that allows the message gateway to connect the request to your
	 * services for email / sms communication of the process tokens.
	 * @param processId the id of the process you want to execute.
	 * @param userTelecomType the type of telecom number used for the user.
	 * @param userTelecom the telecom number of the user for which you want to execute the process. This should be an
	 * email address or phone number depending on the type of process you are executing.
	 * @param captcha Captcha options for authentication. This is used to prevent abuse of the message gateway and
	 * connected external services.
	 * @param processTemplateParameters additional parameters needed by some process templates.
	 */
	suspend fun executeProcess(
		messageGatewayUrl: String,
		externalServicesSpecId: String,
		processId: String,
		userTelecomType: AuthenticationProcessTelecomType,
		userTelecom: String,
		captcha: CaptchaOptions,
		processTemplateParameters: AuthenticationProcessTemplateParameters = AuthenticationProcessTemplateParameters()
	): AuthenticationProcessRequest
}
