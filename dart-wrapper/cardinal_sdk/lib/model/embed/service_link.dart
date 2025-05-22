// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "service_link.freezed.dart";


@freezed
abstract class ServiceLink with _$ServiceLink {
	const factory ServiceLink({
		@Default(null) String? serviceId,
	}) = _ServiceLink;


	static Map<String, dynamic> encode(ServiceLink value) {
		Map<String, dynamic> entityAsMap = {
			"serviceId" : value.serviceId
		};
		return entityAsMap;
	}

	static ServiceLink fromJSON(Map<String, dynamic> data) {
		return ServiceLink(
			serviceId: (data["serviceId"] as String?)
		);
	}
}