// This file is auto-generated
import 'package:cardinal_sdk/model/couchdb/remote.dart';
import 'package:cardinal_sdk/model/base/versionable.dart';


class ReplicateCommand implements Versionable<String> {
	@override  String id;
	@override  String? rev;
	bool continuous = false;
	bool createTarget = false;
	List<String>? docIds;
	bool? cancel;
	String? filter;
	String? selector;
	Remote source;
	Remote target;

	ReplicateCommand({
		required this.id,
		required this.source,
		required this.target,
		this.rev,
		this.docIds,
		this.cancel,
		this.filter,
		this.selector,
		bool? continuous,
		bool? createTarget
	}) : continuous = continuous ?? false,
		createTarget = createTarget ?? false;

	static Map<String, dynamic> encode(ReplicateCommand value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"continuous" : value.continuous,
			"createTarget" : value.createTarget,
			"docIds" : value.docIds?.map((x0) => x0),
			"cancel" : value.cancel,
			"filter" : value.filter,
			"selector" : value.selector,
			"source" : Remote.encode(value.source),
			"target" : Remote.encode(value.target)
		};
		return entityAsMap;
	}
}