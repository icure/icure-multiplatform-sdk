package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class TelecomType() {
	@SerialName("mobile")
	Mobile,

	@SerialName("phone")
	Phone,

	@SerialName("email")
	Email,

	@SerialName("fax")
	Fax,

	@SerialName("skype")
	Skype,

	@SerialName("im")
	Im,

	@SerialName("medibridge")
	Medibridge,

	@SerialName("ehealthbox")
	Ehealthbox,

	@SerialName("apicrypt")
	Apicrypt,

	@SerialName("web")
	Web,

	@SerialName("print")
	Print,

	@SerialName("disk")
	Disk,

	@SerialName("other")
	Other,

	@SerialName("pager")
	Pager,
}
