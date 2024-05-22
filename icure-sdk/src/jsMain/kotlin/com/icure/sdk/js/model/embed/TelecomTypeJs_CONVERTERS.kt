package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.TelecomType
import kotlin.String

public fun telecomType_toJs(obj: TelecomType): String = obj.name

public fun telecomType_fromJs(obj: String): TelecomType = when (obj) {
	"Mobile" -> TelecomType.Mobile
	"Phone" -> TelecomType.Phone
	"Email" -> TelecomType.Email
	"Fax" -> TelecomType.Fax
	"Skype" -> TelecomType.Skype
	"Im" -> TelecomType.Im
	"Medibridge" -> TelecomType.Medibridge
	"Ehealthbox" -> TelecomType.Ehealthbox
	"Apicrypt" -> TelecomType.Apicrypt
	"Web" -> TelecomType.Web
	"Print" -> TelecomType.Print
	"Disk" -> TelecomType.Disk
	"Other" -> TelecomType.Other
	"Pager" -> TelecomType.Pager
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.TelecomType: $obj""")
}
