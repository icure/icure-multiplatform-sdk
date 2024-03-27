package com.icure.sdk.model.embed.form.template

import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
class State(
    public val name: String,
    public val stateToUpdate: StateToUpdate,
    public val canLaunchLauncher: Boolean,
) {
	// region State-State

	// endregion
}
