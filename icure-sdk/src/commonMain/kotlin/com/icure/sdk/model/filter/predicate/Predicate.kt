package com.icure.sdk.model.filter.predicate

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@JsonClassDiscriminator("${'$'}type")
@Serializable
public sealed interface Predicate
