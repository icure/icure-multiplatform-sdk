// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.CalendarItemJs
import com.icure.cardinal.sdk.js.model.EncryptedCalendarItemJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("CalendarItemBasicInGroupApi")
public external interface CalendarItemBasicInGroupApiJs {
	public fun matchCalendarItemsBy(groupId: String, filter: BaseFilterOptionsJs<CalendarItemJs>):
			Promise<Array<String>>

	public fun matchCalendarItemsBySorted(groupId: String,
			filter: BaseSortableFilterOptionsJs<CalendarItemJs>): Promise<Array<String>>

	public fun filterCalendarItemsBy(groupId: String, filter: BaseFilterOptionsJs<CalendarItemJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedCalendarItemJs>>>

	public fun filterCalendarItemsBySorted(groupId: String,
			filter: BaseSortableFilterOptionsJs<CalendarItemJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedCalendarItemJs>>>

	public fun deleteCalendarItemById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteCalendarItemsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deleteCalendarItem(calendarItem: GroupScopedJs<CalendarItemJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteCalendarItems(calendarItems: Array<GroupScopedJs<CalendarItemJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun createCalendarItem(entity: GroupScopedJs<EncryptedCalendarItemJs>):
			Promise<GroupScopedJs<EncryptedCalendarItemJs>>

	public fun modifyCalendarItem(entity: GroupScopedJs<EncryptedCalendarItemJs>):
			Promise<GroupScopedJs<EncryptedCalendarItemJs>>

	public fun getCalendarItem(groupId: String, entityId: String):
			Promise<GroupScopedJs<EncryptedCalendarItemJs>?>

	public fun getCalendarItems(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<EncryptedCalendarItemJs>>>
}
