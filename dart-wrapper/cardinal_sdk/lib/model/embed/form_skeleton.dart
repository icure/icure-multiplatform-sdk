// This file is auto-generated


class FormSkeleton {
	String? descr;
	String? formTemplateId;

	FormSkeleton({
		this.descr,
		this.formTemplateId
	});

	static Map<String, dynamic> encode(FormSkeleton value) {
		Map<String, dynamic> entityAsMap = {
			"descr" : value.descr,
			"formTemplateId" : value.formTemplateId
		};
		return entityAsMap;
	}
}