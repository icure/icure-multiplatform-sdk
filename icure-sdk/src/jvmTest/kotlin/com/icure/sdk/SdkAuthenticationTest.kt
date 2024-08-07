package com.icure.sdk

import com.icure.sdk.auth.AuthenticationProcessCaptchaType
import com.icure.sdk.auth.AuthenticationProcessTelecomType
import com.icure.sdk.crypto.impl.BasicCryptoStrategies
import com.icure.sdk.storage.impl.VolatileStorageFacade
import com.icure.sdk.test.MockMessageGatewayUtils
import com.icure.sdk.test.baseUrl
import com.icure.sdk.test.createHcpUser
import com.icure.sdk.test.initializeTestEnvironment
import com.icure.sdk.test.mockMessageGatewayUrl
import com.icure.sdk.test.mockSpecId
import com.icure.sdk.test.testGroupId
import io.kotest.core.spec.style.StringSpec

class SdkAuthenticationTest : StringSpec({
	beforeAny { initializeTestEnvironment() }

	"A user should be able to initialize an sdk using an authentication process" {
		val hcpDetails = createHcpUser()
		val processId = MockMessageGatewayUtils.createTestProcess(
			groupId = testGroupId,
			hcpId = hcpDetails.dataOwnerId,
			userType = MockMessageGatewayUtils.UserType.Hcp
		)
		val authStep = IcureSdk.initializeWithProcess(
			null,
			baseUrl,
			mockMessageGatewayUrl,
			mockSpecId,
			processId,
			AuthenticationProcessTelecomType.Email,
			hcpDetails.testEmail,
			AuthenticationProcessCaptchaType.Recaptcha,
			"onmock",
			VolatileStorageFacade(),
			BasicCryptoStrategies
		)
		val authCode = MockMessageGatewayUtils.getLatestEmailTo(hcpDetails.testEmail).subject
		val sdk = authStep.completeAuthentication(authCode)
		sdk.user.getCurrentUser()
	}
})