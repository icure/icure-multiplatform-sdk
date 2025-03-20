package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.DecryptedDocument
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.toHexString
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import kotlin.random.Random

class DocumentTest : StringSpec({
	beforeAny {
		initializeTestEnvironment()
	}

	"Should be able to create document and set attachment with chosen uti" {
		val api = createHcpUser().api(this)
		val doc = api.document.createDocument(
			api.document.withEncryptionMetadata(
				base = DecryptedDocument(
					id = defaultCryptoService.strongRandom.randomUUID()
				),
				message = null
			)
		)
		val mainUti = "public.plain-text"
		val otherUtis = listOf("public.text", "icure.text")
		val textAttachment = Random.Default.nextBytes(32).toHexString()
		val updatedDoc = api.document.encryptAndSetMainAttachment(
			doc,
			listOf(mainUti) + otherUtis,
			textAttachment.encodeToByteArray()
		)
		updatedDoc.rev shouldNotBe doc.rev
		updatedDoc.mainUti shouldBe mainUti
		updatedDoc.otherUtis shouldBe otherUtis
		api.document.getRawMainAttachment(doc.id).toList() shouldNotBe textAttachment.encodeToByteArray().toList()
		api.document.getAndDecryptMainAttachment(doc).decodeToString() shouldBe textAttachment
	}
})
