package com.icure.sdk.crypto.entities

import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
interface SimpleDelegateShareOptions {
	val shareSecretIds: Set<String>?
	val shareEncryptionKey: ShareMetadataBehaviour
	val shareOwningEntityIds: ShareMetadataBehaviour
	val requestedPermissions: RequestedPermission
}

@InternalIcureApi
internal data class SimpleDelegateShareOptionsImpl(
	override val shareSecretIds: Set<String>?,
	override val shareEncryptionKey: ShareMetadataBehaviour,
	override val shareOwningEntityIds: ShareMetadataBehaviour,
	override val requestedPermissions: RequestedPermission
) : SimpleDelegateShareOptions

@OptIn(InternalIcureApi::class)
data class AccessLogShareOptions(
	override val requestedPermissions: RequestedPermission = RequestedPermission.MaxWrite,
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
data class CalendarItemShareOptions(
	override val requestedPermissions: RequestedPermission = RequestedPermission.MaxWrite,
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
data class ClassificationShareOptions(
	override val requestedPermissions: RequestedPermission = RequestedPermission.MaxWrite,
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
data class ContactShareOptions(
	override val requestedPermissions: RequestedPermission,
	override val shareEncryptionKey: ShareMetadataBehaviour,
	val sharePatientId: ShareMetadataBehaviour
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
data class DocumentShareOptions(
	override val requestedPermissions: RequestedPermission,
	override val shareEncryptionKey: ShareMetadataBehaviour,
	val shareMessageId: ShareMetadataBehaviour
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = shareMessageId
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
data class FormShareOptions(
	override val requestedPermissions: RequestedPermission,
	override val shareEncryptionKey: ShareMetadataBehaviour,
	val sharePatientId: ShareMetadataBehaviour
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
data class HealthElementShareOptions(
	override val requestedPermissions: RequestedPermission,
	override val shareEncryptionKey: ShareMetadataBehaviour,
	val sharePatientId: ShareMetadataBehaviour
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
data class InvoiceShareOptions(
	override val requestedPermissions: RequestedPermission,
	override val shareEncryptionKey: ShareMetadataBehaviour,
	val sharePatientId: ShareMetadataBehaviour
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
data class MaintenanceTaskShareOptions(
	override val requestedPermissions: RequestedPermission,
	override val shareEncryptionKey: ShareMetadataBehaviour,
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = ShareMetadataBehaviour.Never
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
data class MessageShareOptions(
	override val requestedPermissions: RequestedPermission,
	override val shareEncryptionKey: ShareMetadataBehaviour,
	val sharePatientId: ShareMetadataBehaviour
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
data class PatientShareOptions(
	override val requestedPermissions: RequestedPermission,
	override val shareEncryptionKey: ShareMetadataBehaviour,
	override val shareSecretIds: Set<String>,
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = ShareMetadataBehaviour.Never
}

@OptIn(InternalIcureApi::class)
data class ReceiptShareOptions(
	override val requestedPermissions: RequestedPermission,
	override val shareEncryptionKey: ShareMetadataBehaviour,
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = ShareMetadataBehaviour.Never
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
data class TimeTableShareOptions(
	override val requestedPermissions: RequestedPermission,
	override val shareEncryptionKey: ShareMetadataBehaviour,
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = ShareMetadataBehaviour.Never
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
data class TopicShareOptions(
	override val requestedPermissions: RequestedPermission,
	override val shareEncryptionKey: ShareMetadataBehaviour,
	val sharePatientId: ShareMetadataBehaviour
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
	override val shareSecretIds get() = null
}
