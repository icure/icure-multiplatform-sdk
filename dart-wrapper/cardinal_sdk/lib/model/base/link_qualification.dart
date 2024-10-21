// This file is auto-generated


enum LinkQualification {
	exact,
	narrower,
	broader,
	approximate,
	sequence,
	parent,
	child,
	relatedCode,
	linkedPackage,
	relatedService,
	inResponseTo,
	replaces,
	transforms,
	transformsAndReplaces,
	appendsTo,
	basedOn,
	derivedFrom,
	device,
	focus,
	hasMember,
	performer,
	specimen,
	resultInterpreter,
	request;

	static String encode(LinkQualification value) {
		switch (value) {
			case LinkQualification.exact:
				return '"Exact"';
			case LinkQualification.narrower:
				return '"Narrower"';
			case LinkQualification.broader:
				return '"Broader"';
			case LinkQualification.approximate:
				return '"Approximate"';
			case LinkQualification.sequence:
				return '"Sequence"';
			case LinkQualification.parent:
				return '"Parent"';
			case LinkQualification.child:
				return '"Child"';
			case LinkQualification.relatedCode:
				return '"RelatedCode"';
			case LinkQualification.linkedPackage:
				return '"LinkedPackage"';
			case LinkQualification.relatedService:
				return '"RelatedService"';
			case LinkQualification.inResponseTo:
				return '"InResponseTo"';
			case LinkQualification.replaces:
				return '"Replaces"';
			case LinkQualification.transforms:
				return '"Transforms"';
			case LinkQualification.transformsAndReplaces:
				return '"TransformsAndReplaces"';
			case LinkQualification.appendsTo:
				return '"AppendsTo"';
			case LinkQualification.basedOn:
				return '"BasedOn"';
			case LinkQualification.derivedFrom:
				return '"DerivedFrom"';
			case LinkQualification.device:
				return '"Device"';
			case LinkQualification.focus:
				return '"Focus"';
			case LinkQualification.hasMember:
				return '"HasMember"';
			case LinkQualification.performer:
				return '"Performer"';
			case LinkQualification.specimen:
				return '"Specimen"';
			case LinkQualification.resultInterpreter:
				return '"ResultInterpreter"';
			case LinkQualification.request:
				return '"Request"';
			}
	}

}