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
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
sealed interface CalendarItem :
	StoredDocument,
	ICureDocument<String>,
	HasEncryptionMetadata,
	Encryptable {
	override val id: String

	override val rev: String?

	override val created: Long?

	override val modified: Long?

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	override val tags: Set<CodeStub>

	override val codes: Set<CodeStub>

	override val endOfLife: Long?

	override val deletionDate: Long?

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

	override val secretForeignKeys: Set<String>

	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	override val delegations: Map<String, Set<Delegation>>

	override val encryptionKeys: Map<String, Set<Delegation>>

	override val encryptedSelf: Base64String?

	override val securityMetadata: SecurityMetadata?
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
	override val tags: Set<CodeStub> = emptySet(),
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
	override val meetingTags: Set<CalendarItemTag> = emptySet(),
	override val flowItem: FlowItem? = null,
	override val secretForeignKeys: Set<String> = emptySet(),
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
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
	override val tags: Set<CodeStub> = emptySet(),
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
	override val meetingTags: Set<CalendarItemTag> = emptySet(),
	override val flowItem: FlowItem? = null,
	override val secretForeignKeys: Set<String> = emptySet(),
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : CalendarItem {
	// region CalendarItem-EncryptedCalendarItem
	override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): EncryptedCalendarItem =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

public fun CalendarItem.copy(
	id: String = this.id,
	rev: String? = this.rev,
	created: Long? = this.created,
	modified: Long? = this.modified,
	author: String? = this.author,
	responsible: String? = this.responsible,
	medicalLocationId: String? = this.medicalLocationId,
	tags: Set<CodeStub> = this.tags,
	codes: Set<CodeStub> = this.codes,
	endOfLife: Long? = this.endOfLife,
	deletionDate: Long? = this.deletionDate,
	title: String? = this.title,
	calendarItemTypeId: String? = this.calendarItemTypeId,
	masterCalendarItemId: String? = this.masterCalendarItemId,
	patientId: String? = this.patientId,
	important: Boolean? = this.important,
	homeVisit: Boolean? = this.homeVisit,
	phoneNumber: String? = this.phoneNumber,
	placeId: String? = this.placeId,
	address: Address? = this.address,
	addressText: String? = this.addressText,
	startTime: Long? = this.startTime,
	endTime: Long? = this.endTime,
	confirmationTime: Long? = this.confirmationTime,
	cancellationTimestamp: Long? = this.cancellationTimestamp,
	confirmationId: String? = this.confirmationId,
	duration: Long? = this.duration,
	allDay: Boolean? = this.allDay,
	details: String? = this.details,
	wasMigrated: Boolean? = this.wasMigrated,
	agendaId: String? = this.agendaId,
	hcpId: String? = this.hcpId,
	recurrenceId: String? = this.recurrenceId,
	meetingTags: Set<CalendarItemTag> = this.meetingTags,
	flowItem: FlowItem? = this.flowItem,
	secretForeignKeys: Set<String> = this.secretForeignKeys,
	cryptedForeignKeys: Map<String, Set<Delegation>> = this.cryptedForeignKeys,
	delegations: Map<String, Set<Delegation>> = this.delegations,
	encryptionKeys: Map<String, Set<Delegation>> = this.encryptionKeys,
	encryptedSelf: Base64String? = this.encryptedSelf,
	securityMetadata: SecurityMetadata? = this.securityMetadata,
): CalendarItem {
	return when (this) {
		is DecryptedCalendarItem ->
			copy(
				id = id,
				rev = rev,
				created = created,
				modified = modified,
				author = author,
				responsible = responsible,
				medicalLocationId = medicalLocationId,
				tags = tags,
				codes = codes,
				endOfLife = endOfLife,
				deletionDate = deletionDate,
				title = title,
				calendarItemTypeId = calendarItemTypeId,
				masterCalendarItemId = masterCalendarItemId,
				patientId = patientId,
				important = important,
				homeVisit = homeVisit,
				phoneNumber = phoneNumber,
				placeId = placeId,
				address = address,
				addressText = addressText,
				startTime = startTime,
				endTime = endTime,
				confirmationTime =
				confirmationTime,
				cancellationTimestamp = cancellationTimestamp,
				confirmationId =
				confirmationId,
				duration = duration,
				allDay = allDay,
				details = details,
				wasMigrated =
				wasMigrated,
				agendaId = agendaId,
				hcpId = hcpId,
				recurrenceId = recurrenceId,
				meetingTags =
				meetingTags,
				flowItem = flowItem,
				secretForeignKeys = secretForeignKeys,
				cryptedForeignKeys = cryptedForeignKeys,
				delegations = delegations,
				encryptionKeys =
				encryptionKeys,
				encryptedSelf = encryptedSelf,
				securityMetadata = securityMetadata,
			)
		is EncryptedCalendarItem ->
			copy(
				id = id,
				rev = rev,
				created = created,
				modified = modified,
				author = author,
				responsible = responsible,
				medicalLocationId = medicalLocationId,
				tags =
				tags,
				codes = codes,
				endOfLife = endOfLife,
				deletionDate = deletionDate,
				title = title,
				calendarItemTypeId = calendarItemTypeId,
				masterCalendarItemId = masterCalendarItemId,
				patientId = patientId,
				important = important,
				homeVisit = homeVisit,
				phoneNumber =
				phoneNumber,
				placeId = placeId,
				address = address,
				addressText = addressText,
				startTime =
				startTime,
				endTime = endTime,
				confirmationTime = confirmationTime,
				cancellationTimestamp =
				cancellationTimestamp,
				confirmationId = confirmationId,
				duration = duration,
				allDay =
				allDay,
				details = details,
				wasMigrated = wasMigrated,
				agendaId = agendaId,
				hcpId = hcpId,
				recurrenceId = recurrenceId,
				meetingTags = meetingTags,
				flowItem = flowItem,
				secretForeignKeys = secretForeignKeys,
				cryptedForeignKeys = cryptedForeignKeys,
				delegations = delegations,
				encryptionKeys = encryptionKeys,
				encryptedSelf = encryptedSelf,
				securityMetadata = securityMetadata,
			)
	}
}
