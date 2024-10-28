// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/embed/service.dart';
import 'package:cardinal_sdk/model/base/identifier.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/base/link_qualification.dart';


class ServicePlatformFilters {
	MethodChannel _methodChannel;
	ServicePlatformFilters(this._methodChannel);

	Future<BaseFilterOptions<Service>> allServicesForDataOwner(String dataOwnerId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ServiceFilters.allServicesForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method allServicesForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Service>> allServicesForSelf() async {
		final res = await _methodChannel.invokeMethod<String>(
			'ServiceFilters.allServicesForSelf',
			{
			}
		);
		if (res == null) throw AssertionError("received null result from platform method allServicesForSelf");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Service>> byIdentifiersForDataOwner(String dataOwnerId, List<Identifier> identifiers) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ServiceFilters.byIdentifiersForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"identifiers": jsonEncode(identifiers.map((x0) => Identifier.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byIdentifiersForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Service>> byCodeAndValueDateForDataOwner(String dataOwnerId, String codeType, { String? codeCode, int? startOfServiceValueDate, int? endOfServiceValueDate }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ServiceFilters.byCodeAndValueDateForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"codeType": jsonEncode(codeType),
				"codeCode": jsonEncode(codeCode),
				"startOfServiceValueDate": jsonEncode(startOfServiceValueDate),
				"endOfServiceValueDate": jsonEncode(endOfServiceValueDate),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byCodeAndValueDateForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Service>> byTagAndValueDateForDataOwner(String dataOwnerId, String tagType, { String? tagCode, int? startOfServiceValueDate, int? endOfServiceValueDate }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ServiceFilters.byTagAndValueDateForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"tagType": jsonEncode(tagType),
				"tagCode": jsonEncode(tagCode),
				"startOfServiceValueDate": jsonEncode(startOfServiceValueDate),
				"endOfServiceValueDate": jsonEncode(endOfServiceValueDate),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byTagAndValueDateForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Service>> byPatientsForDataOwner(String dataOwnerId, List<Patient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ServiceFilters.byPatientsForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byPatientsForDataOwner");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Service>> byPatientsSecretIdsForDataOwner(String dataOwnerId, List<String> secretIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ServiceFilters.byPatientsSecretIdsForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byPatientsSecretIdsForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Service>> byHealthElementIdFromSubContactForDataOwner(String dataOwnerId, List<String> healthElementIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ServiceFilters.byHealthElementIdFromSubContactForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"healthElementIds": jsonEncode(healthElementIds.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byHealthElementIdFromSubContactForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Service>> byIdentifiersForSelf(List<Identifier> identifiers) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ServiceFilters.byIdentifiersForSelf',
			{
				"identifiers": jsonEncode(identifiers.map((x0) => Identifier.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byIdentifiersForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Service>> byCodeAndValueDateForSelf(String codeType, { String? codeCode, int? startOfServiceValueDate, int? endOfServiceValueDate }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ServiceFilters.byCodeAndValueDateForSelf',
			{
				"codeType": jsonEncode(codeType),
				"codeCode": jsonEncode(codeCode),
				"startOfServiceValueDate": jsonEncode(startOfServiceValueDate),
				"endOfServiceValueDate": jsonEncode(endOfServiceValueDate),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byCodeAndValueDateForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Service>> byTagAndValueDateForSelf(String tagType, { String? tagCode, int? startOfServiceValueDate, int? endOfServiceValueDate }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ServiceFilters.byTagAndValueDateForSelf',
			{
				"tagType": jsonEncode(tagType),
				"tagCode": jsonEncode(tagCode),
				"startOfServiceValueDate": jsonEncode(startOfServiceValueDate),
				"endOfServiceValueDate": jsonEncode(endOfServiceValueDate),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byTagAndValueDateForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Service>> byPatientsForSelf(List<Patient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ServiceFilters.byPatientsForSelf',
			{
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byPatientsForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Service>> byPatientsSecretIdsForSelf(List<String> secretIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ServiceFilters.byPatientsSecretIdsForSelf',
			{
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byPatientsSecretIdsForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Service>> byHealthElementIdFromSubContactForSelf(List<String> healthElementIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ServiceFilters.byHealthElementIdFromSubContactForSelf',
			{
				"healthElementIds": jsonEncode(healthElementIds.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byHealthElementIdFromSubContactForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Service>> byIds(List<String> ids) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ServiceFilters.byIds',
			{
				"ids": jsonEncode(ids.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byIds");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Service>> byAssociationId(String associationId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ServiceFilters.byAssociationId',
			{
				"associationId": jsonEncode(associationId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byAssociationId");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Service>> byQualifiedLink(List<String> linkValues, { LinkQualification? linkQualification }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ServiceFilters.byQualifiedLink',
			{
				"linkValues": jsonEncode(linkValues.map((x0) => x0).toList()),
				"linkQualification": jsonEncode(linkQualification == null ? null : LinkQualification.encode(linkQualification!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byQualifiedLink");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Service>> byPatientsDateForDataOwner(String dataOwnerId, List<Patient> patients, { int? from, int? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ServiceFilters.byPatientsDateForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
				"descending": jsonEncode(descending),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byPatientsDateForDataOwner");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Service>> byPatientsDateForSelf(List<Patient> patients, { int? from, int? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ServiceFilters.byPatientsDateForSelf',
			{
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
				"descending": jsonEncode(descending),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byPatientsDateForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Service>> byPatientSecretIdsDateForDataOwner(String dataOwnerId, List<String> secretIds, { int? from, int? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ServiceFilters.byPatientSecretIdsDateForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
				"descending": jsonEncode(descending),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byPatientSecretIdsDateForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Service>> byPatientSecretIdsDateForSelf(List<String> secretIds, { int? from, int? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ServiceFilters.byPatientSecretIdsDateForSelf',
			{
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
				"descending": jsonEncode(descending),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byPatientSecretIdsDateForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}
}