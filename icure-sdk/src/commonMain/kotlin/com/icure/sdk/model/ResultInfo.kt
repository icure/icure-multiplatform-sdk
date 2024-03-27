package com.icure.sdk.model

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.embed.Service
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
class ResultInfo(
    public val ssin: String? = null,
    public val lastName: String? = null,
    public val firstName: String? = null,
    public val dateOfBirth: Long? = null,
    public val sex: String? = null,
    public val documentId: String? = null,
    public val protocol: String? = null,
    public val complete: Boolean? = null,
    public val demandDate: Long? = null,
    public val labo: String? = null,
    public val engine: String? = null,
    public val codes: Set<CodeStub> = emptySet(),
    public val services: List<Service>? = null,
)
