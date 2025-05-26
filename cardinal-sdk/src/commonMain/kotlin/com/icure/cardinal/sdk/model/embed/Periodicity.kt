package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import kotlinx.serialization.Serializable

@Serializable
public data class Periodicity(
	public val relatedCode: CodeStub? = null,
	public val relatedPeriodicity: CodeStub? = null,
)
