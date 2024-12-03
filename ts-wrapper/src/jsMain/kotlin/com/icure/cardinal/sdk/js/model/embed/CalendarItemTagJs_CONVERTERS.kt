// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.embed.CalendarItemTag
import com.icure.cardinal.sdk.model.embed.DecryptedCalendarItemTag
import com.icure.cardinal.sdk.model.embed.EncryptedCalendarItemTag
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun calendarItemTag_toJs(obj: DecryptedCalendarItemTag): DecryptedCalendarItemTagJs {
	val code = nullToUndefined(
		obj.code
	)
	val date = nullToUndefined(
		longToNumber(obj.date)
	)
	val userId = nullToUndefined(
		obj.userId
	)
	val userName = nullToUndefined(
		obj.userName
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return DecryptedCalendarItemTagJs(js("{" +
		"code:code," +
		"date:date," +
		"userId:userId," +
		"userName:userName," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun calendarItemTag_fromJs(obj: DecryptedCalendarItemTagJs): DecryptedCalendarItemTag {
	val code = undefinedToNull(obj.code)
	val date = numberToLong(obj.date, "obj.date")
	val userId = undefinedToNull(obj.userId)
	val userName = undefinedToNull(obj.userName)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return DecryptedCalendarItemTag(
		code = code,
		date = date,
		userId = userId,
		userName = userName,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun calendarItemTag_toJs(obj: EncryptedCalendarItemTag): EncryptedCalendarItemTagJs {
	val code = nullToUndefined(
		obj.code
	)
	val date = nullToUndefined(
		longToNumber(obj.date)
	)
	val userId = nullToUndefined(
		obj.userId
	)
	val userName = nullToUndefined(
		obj.userName
	)
	val encryptedSelf = nullToUndefined(
		obj.encryptedSelf?.let { nonNull1 ->
			base64String_toJs(nonNull1)
		}
	)
	return EncryptedCalendarItemTagJs(js("{" +
		"code:code," +
		"date:date," +
		"userId:userId," +
		"userName:userName," +
		"encryptedSelf:encryptedSelf" +
	"}"))
}

public fun calendarItemTag_fromJs(obj: EncryptedCalendarItemTagJs): EncryptedCalendarItemTag {
	val code = undefinedToNull(obj.code)
	val date = numberToLong(obj.date, "obj.date")
	val userId = undefinedToNull(obj.userId)
	val userName = undefinedToNull(obj.userName)
	val encryptedSelf = obj.encryptedSelf?.let { nonNull1 ->
		base64String_fromJs(nonNull1)
	}
	return EncryptedCalendarItemTag(
		code = code,
		date = date,
		userId = userId,
		userName = userName,
		encryptedSelf = encryptedSelf,
	)
}

@Suppress("UNUSED_VARIABLE")
public fun calendarItemTag_toJs(obj: CalendarItemTag): CalendarItemTagJs = when (obj) {
	is EncryptedCalendarItemTag -> calendarItemTag_toJs(obj)
	is DecryptedCalendarItemTag -> calendarItemTag_toJs(obj)
}

public fun calendarItemTag_fromJs(obj: CalendarItemTagJs): CalendarItemTag = if (obj.isEncrypted) {
	calendarItemTag_fromJs(obj as EncryptedCalendarItemTagJs)
} else {
	calendarItemTag_fromJs(obj as DecryptedCalendarItemTagJs)
}
