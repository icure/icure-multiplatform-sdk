package com.icure.cardinal.sdk

import com.icure.cardinal.sdk.test.DataOwnerDetails
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class SdkScopeTest : StringSpec({
	lateinit var hcp: DataOwnerDetails

	beforeSpec {
		initializeTestEnvironment()
		hcp = createHcpUser()
	}

	"When providing a parent job if the parent job gets canceled the SDK scope should be canceled too" {
		val parentJob = Job()
		val sdk = hcp.api(parentJob)
		sdk.scope.isActive shouldBe true
		parentJob.cancel()
		sdk.scope.isActive shouldBe false
	}

	"When providing a parent job if the SDK scope gets canceled the parent job shouldn't be canceled" {
		val parentJob = Job()
		val sdk = hcp.api(parentJob)
		sdk.scope.isActive shouldBe true
		sdk.scope.cancel()
		sdk.scope.isActive shouldBe false
		parentJob.isActive shouldBe true
	}

	"If a child job of the SDK scope fails or is cancelled the SDK scope and parent job shouldn't be canceled" {
		val parentJob = Job()
		val sdk = hcp.api(parentJob)
		sdk.scope.isActive shouldBe true
		sdk.scope.launch { throw Exception("This is completely normal") }
		val jobToCancel = sdk.scope.launch { delay(1000) }
		delay(50)
		jobToCancel.cancel()
		delay(50)
		sdk.scope.isActive shouldBe true
		parentJob.isActive shouldBe true
	}
})