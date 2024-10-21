// This file is auto-generated
import 'package:cardinal_sdk/model/embed/typed_values_type.dart';
import 'package:cardinal_sdk/model/constants/property_type_scope.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';


class PropertyType implements StoredDocument {
	@override  String id;
	@override  String? rev;
	@override  int? deletionDate;
	String identifier;
	TypedValuesType? type;
	PropertyTypeScope? scope;
	bool unique = false;
	String? editor;
	bool localized = false;

	PropertyType({
		required this.id,
		required this.identifier,
		this.rev,
		this.deletionDate,
		this.type,
		this.scope,
		this.editor,
		bool? unique,
		bool? localized
	}) : unique = unique ?? false,
		localized = localized ?? false;

	static Map<String, dynamic> encode(PropertyType value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"identifier" : value.identifier,
			"type" : value.type == null ? null : TypedValuesType.encode(value.type!),
			"scope" : value.scope == null ? null : PropertyTypeScope.encode(value.scope!),
			"unique" : value.unique,
			"editor" : value.editor,
			"localized" : value.localized
		};
		return entityAsMap;
	}
}