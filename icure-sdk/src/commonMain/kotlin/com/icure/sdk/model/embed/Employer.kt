package com.icure.sdk.model.embed

import com.icure.sdk.model.base.Named
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Employer(
    override val name: String? = null,
    public val addresse: Address? = null,
) : Named
