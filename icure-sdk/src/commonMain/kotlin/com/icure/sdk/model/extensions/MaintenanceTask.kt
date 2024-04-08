package com.icure.sdk.model.extensions

import com.icure.sdk.model.DecryptedMaintenanceTask
import com.icure.sdk.model.DecryptedPropertyStub
import com.icure.sdk.model.embed.TypedValuesType

internal fun DecryptedMaintenanceTask.tryFindStringProperty(
	propertyId: String
) = tryFindProperty(propertyId)?.tryAsString()

internal fun DecryptedMaintenanceTask.tryFindProperty(
	propertyId: String
) = properties.firstOrNull { it.id == propertyId }

internal fun DecryptedMaintenanceTask.findProperty(
	propertyId: String
) = requireNotNull(tryFindProperty(propertyId)) {
	"Property with id $propertyId not found in task ${this.id}"
}

private fun DecryptedPropertyStub.tryAsString() =
	if (typedValue?.type == TypedValuesType.String)
		typedValue.stringValue
	else
		null

private fun DecryptedPropertyStub.asString() =
	requireNotNull(tryAsString()) {
		"Property $this does not have a string value"
	}