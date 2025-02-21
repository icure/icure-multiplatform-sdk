package com.icure.cardinal.sdk.model.base

import org.taktik.icure.services.`external`.rest.v2.dto.embed.AddressDto
import org.taktik.icure.services.`external`.rest.v2.dto.embed.GenderDto
import org.taktik.icure.services.`external`.rest.v2.dto.embed.PersonNameDto
import kotlin.String
import kotlin.collections.List
import com.icure.cardinal.sdk.model.embed.Address
import com.icure.cardinal.sdk.model.embed.Gender
import com.icure.cardinal.sdk.model.embed.PersonName
import org.taktik.icure.services.`external`.rest.v2.dto.embed.AddressDto
import org.taktik.icure.services.`external`.rest.v2.dto.embed.GenderDto
import org.taktik.icure.services.`external`.rest.v2.dto.embed.PersonNameDto
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
interface Person : Identifiable<String> {
	public val civility: String?

	public val gender: GenderDto?

	public val firstName: String?

	public val lastName: String?

	public val companyName: String?

	public val names: List<PersonNameDto>

	public val addresses: List<AddressDto>

	public val languages: List<String>
	// region Person-Person

	// endregion
}
