package com.icure.sdk.storage.impl

import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.model.DecryptedAccessLog
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.embed.AccessLevel
import kotlin.js.Promise


@JsExport
interface AccessLogApi {
	fun createAccessLog(entity: DecryptedAccessLog): Promise<DecryptedAccessLog>
	fun withEncryptionMetadata(
		base: DecryptedAccessLog?,
		patient: Patient,
		user: User?,
		delegates: Map<String, AccessLevel> = emptyMap(),
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent,
	): Promise<DecryptedAccessLog>
}


