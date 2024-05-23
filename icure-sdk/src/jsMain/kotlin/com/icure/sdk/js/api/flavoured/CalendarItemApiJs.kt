// auto-generated file
package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.CalendarItemJs
import com.icure.sdk.js.model.DecryptedCalendarItemJs
import com.icure.sdk.js.model.EncryptedCalendarItemJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.Promise

@JsName("CalendarItemApi")
public external interface CalendarItemApiJs {
	public val encrypted: CalendarItemFlavouredApiJs<EncryptedCalendarItemJs>

	public val tryAndRecover: CalendarItemFlavouredApiJs<CalendarItemJs>

	public fun createCalendarItem(entity: DecryptedCalendarItemJs): Promise<DecryptedCalendarItemJs>

	public fun withEncryptionMetadata(
		base: DecryptedCalendarItemJs?,
		patient: PatientJs,
		user: UserJs?,
		delegates: dynamic,
		secretId: SecretIdOptionJs,
	): Promise<DecryptedCalendarItemJs>

	public fun deleteCalendarItem(entityId: String): Promise<DocIdentifierJs>

	public fun deleteCalendarItems(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun shareWith(
		delegateId: String,
		calendarItem: DecryptedCalendarItemJs,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedCalendarItemJs>>

	public fun findCalendarItemsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		startDate: Double?,
		endDate: Double?,
		descending: Boolean?,
	): Promise<PaginatedListIteratorJs<DecryptedCalendarItemJs>>
}
