// This file is auto-generated
import 'package:cardinal_sdk/model/base/code_stub.dart';


class Identifier {
	String? id;
	String? assigner;
	String? start;
	String? end;
	String? system;
	CodeStub? type;
	String? use;
	String? value;

	Identifier({
		this.id,
		this.assigner,
		this.start,
		this.end,
		this.system,
		this.type,
		this.use,
		this.value
	});

	static Map<String, dynamic> encode(Identifier value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"assigner" : value.assigner,
			"start" : value.start,
			"end" : value.end,
			"system" : value.system,
			"type" : value.type == null ? null : CodeStub.encode(value.type!),
			"use" : value.use,
			"value" : value.value
		};
		return entityAsMap;
	}
}