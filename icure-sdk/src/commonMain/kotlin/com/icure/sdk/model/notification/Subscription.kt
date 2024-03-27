package com.icure.sdk.model.notification

import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.specializations.AccessControlKeyHexString
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Subscription<O : Identifiable<String>>(
    public val eventTypes: List<SubscriptionEventType> = emptyList(),
    public val entityClass: String,
    public val filter: FilterChain<O>? = null,
    public val accessControlKeys: List<AccessControlKeyHexString>? = null,
)
