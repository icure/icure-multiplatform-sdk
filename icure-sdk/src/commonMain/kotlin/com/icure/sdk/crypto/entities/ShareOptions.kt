package com.icure.sdk.crypto.entities

import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.InternalIcureApi
import kotlinx.serialization.Serializable

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
@Serializable
data class AccessLogShareOptions(
	@DefaultValue("com.icure.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions: RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
@Serializable
data class CalendarItemShareOptions(
	@DefaultValue("com.icure.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions: RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
@Serializable
data class ClassificationShareOptions(
	@DefaultValue("com.icure.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions: RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
@Serializable
data class ContactShareOptions(
	@DefaultValue("com.icure.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
@Serializable
data class DocumentShareOptions(
	@DefaultValue("com.icure.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val shareMessageId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = shareMessageId
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
@Serializable
data class FormShareOptions(
	@DefaultValue("com.icure.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
@Serializable
data class HealthElementShareOptions(
	@DefaultValue("com.icure.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
@Serializable
data class InvoiceShareOptions(
	@DefaultValue("com.icure.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
@Serializable
data class MaintenanceTaskShareOptions(
	@DefaultValue("com.icure.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = ShareMetadataBehaviour.Never
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
@Serializable
data class MessageShareOptions(
	override val shareSecretIds: Set<String>,
	@DefaultValue("com.icure.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
}

@OptIn(InternalIcureApi::class)
@Serializable
data class PatientShareOptions(
	override val shareSecretIds: Set<String>,
	@DefaultValue("com.icure.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = ShareMetadataBehaviour.Never
}

@OptIn(InternalIcureApi::class)
@Serializable
data class ReceiptShareOptions(
	@DefaultValue("com.icure.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = ShareMetadataBehaviour.Never
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
@Serializable
data class TimeTableShareOptions(
	@DefaultValue("com.icure.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = ShareMetadataBehaviour.Never
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
@Serializable
data class TopicShareOptions(
	@DefaultValue("com.icure.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	@DefaultValue("com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
	override val shareSecretIds get() = null
}
