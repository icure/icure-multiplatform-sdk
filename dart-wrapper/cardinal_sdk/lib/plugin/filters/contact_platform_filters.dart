// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/model/contact.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/base/identifier.dart';


class ContactPlatformFilters {
	MethodChannel _methodChannel;
	ContactPlatformFilters(this._methodChannel);

	Future<BaseFilterOptions<Contact>> allContactsForDataOwner(String dataOwnerId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.allContactsForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method allContactsForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Contact>> allContactsForSelf() async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.allContactsForSelf',
			{
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method allContactsForSelf");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Contact>> byFormIdsForDataOwner(String dataOwnerId, Set<String> formIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.byFormIdsForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"formIds": jsonEncode(formIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byFormIdsForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Contact>> byFormIdsForSelf(Set<String> formIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.byFormIdsForSelf',
			{
				"formIds": jsonEncode(formIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byFormIdsForSelf");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Contact>> byPatientsOpeningDateForDataOwner(String dataOwnerId, List<Patient> patients, { int? from, int? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.byPatientsOpeningDateForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientsOpeningDateForDataOwner");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Contact>> byPatientsOpeningDateForSelf(List<Patient> patients, { int? from, int? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.byPatientsOpeningDateForSelf',
			{
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientsOpeningDateForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Contact>> byPatientSecretIdsOpeningDateForDataOwner(String dataOwnerId, List<String> secretIds, { int? from, int? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.byPatientSecretIdsOpeningDateForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientSecretIdsOpeningDateForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Contact>> byPatientSecretIdsOpeningDateForSelf(List<String> secretIds, { int? from, int? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.byPatientSecretIdsOpeningDateForSelf',
			{
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientSecretIdsOpeningDateForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Contact>> byExternalId(String externalId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.byExternalId',
			{
				"externalId": jsonEncode(externalId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byExternalId");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Contact>> byIdentifiersForSelf(List<Identifier> identifiers) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.byIdentifiersForSelf',
			{
				"identifiers": jsonEncode(identifiers.map((x0) => Identifier.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byIdentifiersForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Contact>> byIdentifiersForDataOwner(String dataOwnerId, List<Identifier> identifiers) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.byIdentifiersForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"identifiers": jsonEncode(identifiers.map((x0) => Identifier.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byIdentifiersForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Contact>> byCodeAndOpeningDateForDataOwner(String dataOwnerId, String codeType, { String? codeCode, int? startOfContactOpeningDate, int? endOfContactOpeningDate }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.byCodeAndOpeningDateForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"codeType": jsonEncode(codeType),
				"codeCode": jsonEncode(codeCode),
				"startOfContactOpeningDate": jsonEncode(startOfContactOpeningDate),
				"endOfContactOpeningDate": jsonEncode(endOfContactOpeningDate),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byCodeAndOpeningDateForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Contact>> byCodeAndOpeningDateForSelf(String codeType, { String? codeCode, int? startOfContactOpeningDate, int? endOfContactOpeningDate }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.byCodeAndOpeningDateForSelf',
			{
				"codeType": jsonEncode(codeType),
				"codeCode": jsonEncode(codeCode),
				"startOfContactOpeningDate": jsonEncode(startOfContactOpeningDate),
				"endOfContactOpeningDate": jsonEncode(endOfContactOpeningDate),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byCodeAndOpeningDateForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Contact>> byTagAndOpeningDateForDataOwner(String dataOwnerId, String tagType, { String? tagCode, int? startOfContactOpeningDate, int? endOfContactOpeningDate }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.byTagAndOpeningDateForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"tagType": jsonEncode(tagType),
				"tagCode": jsonEncode(tagCode),
				"startOfContactOpeningDate": jsonEncode(startOfContactOpeningDate),
				"endOfContactOpeningDate": jsonEncode(endOfContactOpeningDate),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byTagAndOpeningDateForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Contact>> byOpeningDateForDataOwner(String dataOwnerId, { int? startDate, int? endDate, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.byOpeningDateForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"startDate": jsonEncode(startDate),
				"endDate": jsonEncode(endDate),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byOpeningDateForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Contact>> byOpeningDateForSelf({ int? startDate, int? endDate, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.byOpeningDateForSelf',
			{
				"startDate": jsonEncode(startDate),
				"endDate": jsonEncode(endDate),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byOpeningDateForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Contact>> byServiceTagForSelf(String tagType, { String? tagCode }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.byServiceTagForSelf',
			{
				"tagType": jsonEncode(tagType),
				"tagCode": jsonEncode(tagCode),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byServiceTagForSelf");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Contact>> byServiceTagForDataOwner(String dataOwnerId, String tagType, { String? tagCode }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.byServiceTagForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"tagType": jsonEncode(tagType),
				"tagCode": jsonEncode(tagCode),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byServiceTagForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Contact>> byServiceCodeForSelf(String codeType, { String? codeCode }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.byServiceCodeForSelf',
			{
				"codeType": jsonEncode(codeType),
				"codeCode": jsonEncode(codeCode),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byServiceCodeForSelf");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Contact>> byServiceCodeForDataOwner(String dataOwnerId, String codeType, { String? codeCode }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.byServiceCodeForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"codeType": jsonEncode(codeType),
				"codeCode": jsonEncode(codeCode),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byServiceCodeForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Contact>> byTagAndOpeningDateForSelf(String tagType, { String? tagCode, int? startOfContactOpeningDate, int? endOfContactOpeningDate }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.byTagAndOpeningDateForSelf',
			{
				"tagType": jsonEncode(tagType),
				"tagCode": jsonEncode(tagCode),
				"startOfContactOpeningDate": jsonEncode(startOfContactOpeningDate),
				"endOfContactOpeningDate": jsonEncode(endOfContactOpeningDate),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byTagAndOpeningDateForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Contact>> byPatientsForDataOwner(String dataOwnerId, List<Patient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.byPatientsForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientsForDataOwner");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Contact>> byPatientsForSelf(List<Patient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.byPatientsForSelf',
			{
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientsForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Contact>> byPatientsSecretIdsForDataOwner(String dataOwnerId, List<String> secretIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.byPatientsSecretIdsForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientsSecretIdsForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Contact>> byPatientsSecretIdsForSelf(List<String> secretIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.byPatientsSecretIdsForSelf',
			{
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientsSecretIdsForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Contact>> byServiceIds(List<String> serviceIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ContactFilters.byServiceIds',
			{
				"serviceIds": jsonEncode(serviceIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byServiceIds");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}
}