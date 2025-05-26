package com.icure.cardinal.sdk.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class LinkQualification() {
	@SerialName("exact")
	Exact("exact"),

	@SerialName("narrower")
	Narrower("narrower"),

	@SerialName("broader")
	Broader("broader"),

	@SerialName("approximate")
	Approximate("approximate"),

	@SerialName("sequence")
	Sequence("sequence"),

	@SerialName("parent")
	Parent("parent"),

	@SerialName("child")
	Child("child"),

	@SerialName("relatedCode")
	RelatedCode("relatedCode"),

	@SerialName("linkedPackage")
	LinkedPackage("linkedPackage"),

	@SerialName("relatedService")
	RelatedService("relatedService"),

	@SerialName("inResponseTo")
	InResponseTo("inResponseTo"),

	@SerialName("replaces")
	Replaces("replaces"),

	@SerialName("transforms")
	Transforms("transforms"),

	@SerialName("transformsAndReplaces")
	TransformsAndReplaces("transformsAndReplaces"),

	@SerialName("appendsTo")
	AppendsTo("appendsTo"),

	@SerialName("basedOn")
	BasedOn("basedOn"),

	@SerialName("derivedFrom")
	DerivedFrom("derivedFrom"),

	@SerialName("device")
	Device("device"),

	@SerialName("focus")
	Focus("focus"),

	@SerialName("hasMember")
	HasMember("hasMember"),

	@SerialName("performer")
	Performer("performer"),

	@SerialName("specimen")
	Specimen("specimen"),

	@SerialName("resultInterpreter")
	ResultInterpreter("resultInterpreter"),

	@SerialName("request")
	Request("request"),
	;

	public val dtoSerialName: String
}
