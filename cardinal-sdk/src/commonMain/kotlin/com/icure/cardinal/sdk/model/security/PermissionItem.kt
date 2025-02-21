package com.icure.cardinal.sdk.model.security

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator
import org.taktik.icure.services.`external`.rest.v2.dto.filter.predicate.Predicate
import org.taktik.icure.services.`external`.rest.v2.dto.security.PermissionTypeDto
import kotlin.OptIn
import com.icure.cardinal.sdk.model.filter.predicate.Predicate
import org.taktik.icure.services.`external`.rest.v2.dto.filter.predicate.Predicate
import org.taktik.icure.services.`external`.rest.v2.dto.security.PermissionTypeDto
import kotlin.OptIn

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("itemType")
@Serializable
sealed interface PermissionItem {
	public val type: PermissionTypeDto

	public val predicate: Predicate
	// region PermissionItem-PermissionItem

	// endregion
}
