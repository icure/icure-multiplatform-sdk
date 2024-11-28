package com.icure.cardinal.sdk.dart.utils

import kotlinx.serialization.builtins.serializer

object ResourceUtils {

	fun releasePlatformResource(
		dartResultCallback: (
			String?,
			String?,
			String?,
			String?,
		) -> Unit,
		resourceId: String,
	) {
		ApiScope.execute(
			dartResultCallback,
			Unit.serializer()
		) {
			NativeReferences.delete(resourceId)
		}
	}

}