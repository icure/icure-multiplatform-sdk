package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.requests.RequestedPermission
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.Serializable

@InternalIcureApi
interface SimpleDelegateShareOptions {
	/**
	 * The secret ids you want to share with the delegate.
	 */
	val shareSecretIds: Set<String>?
	/**
	 * Specifies if the encryption key of the entity should be shared (giving access to the encrypted information)
	 */
	val shareEncryptionKey: ShareMetadataBehaviour
	/**
	 * Specifies if the id of the "owning" entity should be shared. The type of the owning entity and exact meaning of
	 * the relationship between the "owning" entity and the entity being shared depends on the shared entity type.
	 */
	val shareOwningEntityIds: ShareMetadataBehaviour
	/**
	 * Specifies the permissions that the delegate will have on the shared entity.
	 * - FullWrite: the delegate will get write access to the full entity. If the delegator is not allowed to give
	 *   write access, the sharing will fail
	 * - MaxWrite: the delegate will get the highest permissions that the current user can grant. In the current version
	 *   of the SDK this means that if the delegator can grant full write access, the delegate will have full write
	 *   access, otherwise the delegate will have full read access.
	 * - FullRead: gives the delegate full read access to the entity, failing if the delegator can't grant read to
	 *   the full entity. In the current version of the SDK this can never fail as long as the delegator has access to
	 *   the entity.
	 * - MaxRead: gives the delegate as much read access to the entity as the delegator can give. In the current version
	 *   of the SDK as long this is equivalent to FullRead.
	 * - Root: for internal use only
	 */
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
	@DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions: RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	/**
	 * Specifies if the id of the patient linked to the access log should be shared with the delegate
	 */
	@DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
@Serializable
data class CalendarItemShareOptions(
	@DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions: RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	/**
	 * Specifies if the id of the patient linked to the calendar item should be shared with the delegate
	 */
	@DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
@Serializable
data class ClassificationShareOptions(
	@DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions: RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	/**
	 * Specifies if the id of the patient linked to the classification should be shared with the delegate
	 */
	@DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
@Serializable
data class ContactShareOptions(
	@DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	/**
	 * Specifies if the id of the patient linked to the contact should be shared with the delegate
	 */
	@DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
@Serializable
data class DocumentShareOptions(
	@DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	/**
	 * Specifies if the id of the message linked to the document (if any) should be shared with the delegate
	 */
	@DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val shareMessageId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = shareMessageId
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
@Serializable
data class FormShareOptions(
	@DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	/**
	 * Specifies if the id of the patient linked to the form should be shared with the delegate
	 */
	@DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
@Serializable
data class HealthElementShareOptions(
	@DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	/**
	 * Specifies if the id of the patient linked to the health element should be shared with the delegate
	 */
	@DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
@Serializable
data class InvoiceShareOptions(
	@DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	/**
	 * Specifies if the id of the patient linked to the invoice should be shared with the delegate
	 */
	@DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
@Serializable
data class MaintenanceTaskShareOptions(
	@DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = ShareMetadataBehaviour.Never
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
@Serializable
data class MessageShareOptions(
	override val shareSecretIds: Set<String>,
	@DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	/**
	 * Specifies if the id of the patient linked to the message should be shared with the delegate
	 */
	@DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
}

@OptIn(InternalIcureApi::class)
@Serializable
data class PatientShareOptions(
	override val shareSecretIds: Set<String>,
	@DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = ShareMetadataBehaviour.Never
}

@OptIn(InternalIcureApi::class)
@Serializable
data class ReceiptShareOptions(
	@DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = ShareMetadataBehaviour.Never
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
@Serializable
data class TimeTableShareOptions(
	@DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = ShareMetadataBehaviour.Never
	override val shareSecretIds get() = null
}

@OptIn(InternalIcureApi::class)
@Serializable
data class TopicShareOptions(
	@DefaultValue("com.icure.cardinal.sdk.model.requests.RequestedPermission.MaxWrite")
	override val requestedPermissions:  RequestedPermission = RequestedPermission.MaxWrite,
	@DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	override val shareEncryptionKey: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
	/**
	 * Specifies if the id of the patient linked to the topic should be shared with the delegate
	 */
	@DefaultValue("com.icure.cardinal.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable")
	val sharePatientId: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable
) : SimpleDelegateShareOptions {

	override val shareOwningEntityIds get() = sharePatientId
	override val shareSecretIds get() = null
}
