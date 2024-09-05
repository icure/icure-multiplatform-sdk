package com.icure.cardinal.sdk.api

import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.cardinal.sdk.model.DecryptedDocument
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.uuid
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

class ByteArrayPayloadTest : StringSpec({

	beforeAny {
		initializeTestEnvironment()
	}

	"It is possible to send a ByteArray payload and retrieve it" {
		val hcpDetails = createHcpUser()
		val api = hcpDetails.api()
		val hcpUser = api.user.getCurrentUser()

		val newDocument = api.document.withEncryptionMetadata(
			base = DecryptedDocument(id = uuid(), name = uuid()),
			message = null,
			user = hcpUser
		)
		val createdDocument = api.document.createDocument(newDocument)

		val payload = defaultCryptoService.strongRandom.randomBytes(2000)
		val uti = "com.microsoft.windows-executable"

		val updatedDocument = api.document.setRawMainAttachment(
			documentId = createdDocument.id,
			rev = createdDocument.rev.shouldNotBeNull(),
			utis = listOf(uti),
			attachment = payload,
			encrypted = false
		)

		val retrievedRawPayload = api.document.getRawMainAttachment(
			documentId = updatedDocument.id,
		)

		retrievedRawPayload.toList() shouldBe payload.toList()
	}

})
