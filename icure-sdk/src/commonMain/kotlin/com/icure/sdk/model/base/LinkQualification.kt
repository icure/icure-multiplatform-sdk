package com.icure.sdk.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class LinkQualification() {
	@SerialName("exact")
	Exact,

	@SerialName("narrower")
	Narrower,

	@SerialName("broader")
	Broader,

	@SerialName("approximate")
	Approximate,

	@SerialName("sequence")
	Sequence,

	@SerialName("parent")
	Parent,

	@SerialName("child")
	Child,

	@SerialName("relatedCode")
	RelatedCode,

	@SerialName("linkedPackage")
	LinkedPackage,

	@SerialName("relatedService")
	RelatedService,

	@SerialName("inResponseTo")
	InResponseTo,

	@SerialName("replaces")
	Replaces,

	@SerialName("transforms")
	Transforms,

	@SerialName("transformsAndReplaces")
	TransformsAndReplaces,

	@SerialName("appendsTo")
	AppendsTo,

	@SerialName("basedOn")
	BasedOn,

	@SerialName("derivedFrom")
	DerivedFrom,

	@SerialName("device")
	Device,

	@SerialName("focus")
	Focus,

	@SerialName("hasMember")
	HasMember,

	@SerialName("performer")
	Performer,

	@SerialName("specimen")
	Specimen,

	@SerialName("resultInterpreter")
	ResultInterpreter,

	@SerialName("request")
	Request,
}
