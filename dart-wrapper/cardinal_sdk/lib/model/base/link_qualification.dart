// auto-generated file


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
				return 'exact';
			case LinkQualification.narrower:
				return 'narrower';
			case LinkQualification.broader:
				return 'broader';
			case LinkQualification.approximate:
				return 'approximate';
			case LinkQualification.sequence:
				return 'sequence';
			case LinkQualification.parent:
				return 'parent';
			case LinkQualification.child:
				return 'child';
			case LinkQualification.relatedCode:
				return 'relatedCode';
			case LinkQualification.linkedPackage:
				return 'linkedPackage';
			case LinkQualification.relatedService:
				return 'relatedService';
			case LinkQualification.inResponseTo:
				return 'inResponseTo';
			case LinkQualification.replaces:
				return 'replaces';
			case LinkQualification.transforms:
				return 'transforms';
			case LinkQualification.transformsAndReplaces:
				return 'transformsAndReplaces';
			case LinkQualification.appendsTo:
				return 'appendsTo';
			case LinkQualification.basedOn:
				return 'basedOn';
			case LinkQualification.derivedFrom:
				return 'derivedFrom';
			case LinkQualification.device:
				return 'device';
			case LinkQualification.focus:
				return 'focus';
			case LinkQualification.hasMember:
				return 'hasMember';
			case LinkQualification.performer:
				return 'performer';
			case LinkQualification.specimen:
				return 'specimen';
			case LinkQualification.resultInterpreter:
				return 'resultInterpreter';
			case LinkQualification.request:
				return 'request';
			}
	}


	static LinkQualification fromJSON(String data) {
		switch (data) {
			case "exact":
				return LinkQualification.exact;
			case "narrower":
				return LinkQualification.narrower;
			case "broader":
				return LinkQualification.broader;
			case "approximate":
				return LinkQualification.approximate;
			case "sequence":
				return LinkQualification.sequence;
			case "parent":
				return LinkQualification.parent;
			case "child":
				return LinkQualification.child;
			case "relatedCode":
				return LinkQualification.relatedCode;
			case "linkedPackage":
				return LinkQualification.linkedPackage;
			case "relatedService":
				return LinkQualification.relatedService;
			case "inResponseTo":
				return LinkQualification.inResponseTo;
			case "replaces":
				return LinkQualification.replaces;
			case "transforms":
				return LinkQualification.transforms;
			case "transformsAndReplaces":
				return LinkQualification.transformsAndReplaces;
			case "appendsTo":
				return LinkQualification.appendsTo;
			case "basedOn":
				return LinkQualification.basedOn;
			case "derivedFrom":
				return LinkQualification.derivedFrom;
			case "device":
				return LinkQualification.device;
			case "focus":
				return LinkQualification.focus;
			case "hasMember":
				return LinkQualification.hasMember;
			case "performer":
				return LinkQualification.performer;
			case "specimen":
				return LinkQualification.specimen;
			case "resultInterpreter":
				return LinkQualification.resultInterpreter;
			case "request":
				return LinkQualification.request;
			default:
				throw ArgumentError('Invalid LinkQualification entry value $data');
			}
	}

}