package com.icure.sdk.model.base

import com.icure.sdk.model.PropertyStub
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
interface Principal : Identifiable<String>, Named {
    public val properties: Set<PropertyStub>
}
