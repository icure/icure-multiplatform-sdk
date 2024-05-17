package com.icure.sdk.model

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.HasEncryptionMetadata
import com.icure.sdk.model.base.ICureDocument
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.Address
import com.icure.sdk.model.embed.CalendarItemTag
import com.icure.sdk.model.embed.DecryptedAddress
import com.icure.sdk.model.embed.Delegation
import com.icure.sdk.model.embed.Encryptable
import com.icure.sdk.model.embed.EncryptedAddress
import com.icure.sdk.model.embed.FlowItem
import com.icure.sdk.model.embed.SecurityMetadata
import com.icure.sdk.model.specializations.Base64String
import com.icure.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface CalendarItem :
	StoredDocument,
	ICureDocument<String>,
	HasEncryptionMetadata,
	Encryptable {
	public val id: String

	public val rev: String?

	public val created: Long?

	public val modified: Long?

	public val author: String?

	public val responsible: String?

	public val medicalLocationId: String?

	public val tags: Set<CodeStub>

	public val codes: Set<CodeStub>

	public val endOfLife: Long?

	public val deletionDate: Long?

	public val title: String?

	public val calendarItemTypeId: String?

	public val masterCalendarItemId: String?

	public val patientId: String?

	public val important: Boolean?

	public val homeVisit: Boolean?

	public val phoneNumber: String?

	public val placeId: String?

	public val address: Address?

	public val addressText: String?

	public val startTime: Long?

	public val endTime: Long?

	public val confirmationTime: Long?

	public val cancellationTimestamp: Long?

	public val confirmationId: String?

	public val duration: Long?

	public val allDay: Boolean?

	public val details: String?

	public val wasMigrated: Boolean?

	public val agendaId: String?

	public val hcpId: String?

	public val recurrenceId: String?

	public val meetingTags: Set<CalendarItemTag>

	public val flowItem: FlowItem?

	public val secretForeignKeys: Set<String>

	public val cryptedForeignKeys: Map<String, Set<Delegation>>

	public val delegations: Map<String, Set<Delegation>>

	public val encryptionKeys: Map<String, Set<Delegation>>

	public val encryptedSelf: Base64String?

	public val securityMetadata: SecurityMetadata?
	// region CalendarItem-CalendarItem

	// endregion
}

@Serializable
data class DecryptedCalendarItem(
	override val id: String,
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	override val title: String? = null,
	override val calendarItemTypeId: String? = null,
	override val masterCalendarItemId: String? = null,
	override val patientId: String? = null,
	override val important: Boolean? = null,
	override val homeVisit: Boolean? = null,
	override val phoneNumber: String? = null,
	override val placeId: String? = null,
	override val address: DecryptedAddress? = null,
	override val addressText: String? = null,
	override val startTime: Long? = null,
	override val endTime: Long? = null,
	override val confirmationTime: Long? = null,
	override val cancellationTimestamp: Long? = null,
	override val confirmationId: String? = null,
	override val duration: Long? = null,
	override val allDay: Boolean? = null,
	override val details: String? = null,
	override val wasMigrated: Boolean? = null,
	override val agendaId: String? = null,
	override val hcpId: String? = null,
	override val recurrenceId: String? = null,
	@DefaultValue("emptySet()")
	override val meetingTags: Set<CalendarItemTag> = emptySet(),
	override val flowItem: FlowItem? = null,
	@DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : CalendarItem {
	// region CalendarItem-DecryptedCalendarItem
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): DecryptedCalendarItem =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

@Serializable
data class EncryptedCalendarItem(
	override val id: String,
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	override val title: String? = null,
	override val calendarItemTypeId: String? = null,
	override val masterCalendarItemId: String? = null,
	override val patientId: String? = null,
	override val important: Boolean? = null,
	override val homeVisit: Boolean? = null,
	override val phoneNumber: String? = null,
	override val placeId: String? = null,
	override val address: EncryptedAddress? = null,
	override val addressText: String? = null,
	override val startTime: Long? = null,
	override val endTime: Long? = null,
	override val confirmationTime: Long? = null,
	override val cancellationTimestamp: Long? = null,
	override val confirmationId: String? = null,
	override val duration: Long? = null,
	override val allDay: Boolean? = null,
	override val details: String? = null,
	override val wasMigrated: Boolean? = null,
	override val agendaId: String? = null,
	override val hcpId: String? = null,
	override val recurrenceId: String? = null,
	@DefaultValue("emptySet()")
	override val meetingTags: Set<CalendarItemTag> = emptySet(),
	override val flowItem: FlowItem? = null,
	@DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : CalendarItem {
	// region CalendarItem-EncryptedCalendarItem
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): EncryptedCalendarItem =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}
