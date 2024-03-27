package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Periodicity(
    public val relatedCode: CodeStub? = null,
    public val relatedPeriodicity: CodeStub? = null,
)
