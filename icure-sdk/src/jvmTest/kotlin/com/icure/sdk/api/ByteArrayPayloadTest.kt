package com.icure.sdk.api

import com.icure.sdk.model.DecryptedDocument
import com.icure.sdk.model.DecryptedMessage
import com.icure.sdk.model.Message
import com.icure.sdk.test.createHcpUser
import com.icure.sdk.test.initialiseTestEnvironment
import com.icure.sdk.test.uuid
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

class ByteArrayPayloadTest : StringSpec({

	beforeAny {
		initialiseTestEnvironment()
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

		val payload = "Some text document that is actually a simple string"
		val uti = "public.plain-text"

		val updatedDocument = api.document.setRawMainAttachment(
			documentId = createdDocument.id,
			rev = createdDocument.rev.shouldNotBeNull(),
			utis = listOf(uti),
			blobType = uti,
			attachment = payload.toByteArray(),
			encrypted = false
		)

		val retrievedRawPayload = api.document.getRawMainAttachment(
			documentId = updatedDocument.id,
			attachmentId = updatedDocument.attachmentId.shouldNotBeNull()
		)

		String(retrievedRawPayload) shouldBe payload
	}

})
