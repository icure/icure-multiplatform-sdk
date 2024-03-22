package com.icure.sdk.model

data class CodeStub(
	val id: String, // id = type|code|version  => this must be unique
	val context: String? = null, //ex: When embedded the context where this code is used
	val type: String? = null, //ex: ICD (type + version + code combination must be unique) (or from tags -> CD-ITEM)
	val code: String? = null, //ex: I06.2 (or from tags -> healthcareelement). Local codes are encoded as LOCAL:SLLOCALFROMMYSOFT
	val version: String? = null, //ex: 10. Must be lexicographically searchable
	val contextLabel: String? = null,
	val label: Map<String, String>? = null //ex: {en: Rheumatic Aortic Stenosis, fr: Sténose rhumatoïde de l'Aorte}
)