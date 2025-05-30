// auto-generated file
import 'package:cardinal_sdk/model/embed/partnership_type.dart';
import 'package:cardinal_sdk/model/embed/partnership_status.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "partnership.freezed.dart";


@freezed
abstract class Partnership with _$Partnership {
	const factory Partnership({
		@Default(null) PartnershipType? type,
		@Default(null) PartnershipStatus? status,
		@Default(null) String? partnerId,
		@Default(null) String? meToOtherRelationshipDescription,
		@Default(null) String? otherToMeRelationshipDescription,
	}) = _Partnership;


	static Map<String, dynamic> encode(Partnership value) {
		Map<String, dynamic> entityAsMap = {
			"type" : value.type == null ? null : PartnershipType.encode(value.type!),
			"status" : value.status == null ? null : PartnershipStatus.encode(value.status!),
			"partnerId" : value.partnerId,
			"meToOtherRelationshipDescription" : value.meToOtherRelationshipDescription,
			"otherToMeRelationshipDescription" : value.otherToMeRelationshipDescription
		};
		return entityAsMap;
	}

	static Partnership fromJSON(Map<String, dynamic> data) {
		return Partnership(
			type: data["type"] == null ? null : PartnershipType.fromJSON(data["type"]),
			status: data["status"] == null ? null : PartnershipStatus.fromJSON(data["status"]),
			partnerId: (data["partnerId"] as String?),
			meToOtherRelationshipDescription: (data["meToOtherRelationshipDescription"] as String?),
			otherToMeRelationshipDescription: (data["otherToMeRelationshipDescription"] as String?)
		);
	}
}