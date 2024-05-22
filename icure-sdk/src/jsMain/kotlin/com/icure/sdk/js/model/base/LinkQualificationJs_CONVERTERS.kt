package com.icure.sdk.js.model.base

import com.icure.sdk.model.base.LinkQualification
import kotlin.String

public fun linkQualification_toJs(obj: LinkQualification): String = obj.name

public fun linkQualification_fromJs(obj: String): LinkQualification = when (obj) {
	"Exact" -> LinkQualification.Exact
	"Narrower" -> LinkQualification.Narrower
	"Broader" -> LinkQualification.Broader
	"Approximate" -> LinkQualification.Approximate
	"Sequence" -> LinkQualification.Sequence
	"Parent" -> LinkQualification.Parent
	"Child" -> LinkQualification.Child
	"RelatedCode" -> LinkQualification.RelatedCode
	"LinkedPackage" -> LinkQualification.LinkedPackage
	"RelatedService" -> LinkQualification.RelatedService
	"InResponseTo" -> LinkQualification.InResponseTo
	"Replaces" -> LinkQualification.Replaces
	"Transforms" -> LinkQualification.Transforms
	"TransformsAndReplaces" -> LinkQualification.TransformsAndReplaces
	"AppendsTo" -> LinkQualification.AppendsTo
	"BasedOn" -> LinkQualification.BasedOn
	"DerivedFrom" -> LinkQualification.DerivedFrom
	"Device" -> LinkQualification.Device
	"Focus" -> LinkQualification.Focus
	"HasMember" -> LinkQualification.HasMember
	"Performer" -> LinkQualification.Performer
	"Specimen" -> LinkQualification.Specimen
	"ResultInterpreter" -> LinkQualification.ResultInterpreter
	"Request" -> LinkQualification.Request
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.base.LinkQualification: $obj""")
}
