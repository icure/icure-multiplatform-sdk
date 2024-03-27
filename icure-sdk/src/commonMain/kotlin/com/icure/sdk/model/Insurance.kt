package com.icure.sdk.model

import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.Address
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Insurance(
    override val id: String,
    override val rev: String? = null,
    override val deletionDate: Long? = null,
    public val name: Map<String, String> = emptyMap(),
    public val privateInsurance: Boolean,
    public val hospitalisationInsurance: Boolean,
    public val ambulatoryInsurance: Boolean,
    public val code: String? = null,
    public val agreementNumber: String? = null,
    public val parent: String? = null,
    public val address: Address,
) : StoredDocument {
	// region Insurance-Insurance

	// endregion
}
