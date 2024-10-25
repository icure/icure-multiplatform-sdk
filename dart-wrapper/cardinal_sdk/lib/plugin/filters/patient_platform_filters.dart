import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/base/identifier.dart';
import 'package:cardinal_sdk/model/embed/gender.dart';


class PatientPlatformFilters {
	MethodChannel _methodChannel;
	PatientPlatformFilters(this._methodChannel);

	Future<BaseFilterOptions<Patient>> allPatientsForDataOwner(String dataOwnerId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientFilters.allPatientsForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method allPatientsForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Patient>> allPatientsForSelf() async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientFilters.allPatientsForSelf',
			{
			}
		);
		if (res == null) throw AssertionError("received null result from platform method allPatientsForSelf");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Patient>> byIds(List<String> ids) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientFilters.byIds',
			{
				"ids": jsonEncode(ids.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byIds");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Patient>> byIdentifiersForDataOwner(String dataOwnerId, List<Identifier> identifiers) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientFilters.byIdentifiersForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"identifiers": jsonEncode(identifiers.map((x0) => Identifier.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byIdentifiersForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Patient>> bySsinsForDataOwner(String dataOwnerId, List<String> ssins) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientFilters.bySsinsForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"ssins": jsonEncode(ssins.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method bySsinsForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Patient>> byDateOfBirthBetweenForDataOwner(String dataOwnerId, int fromDate, int toDate) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientFilters.byDateOfBirthBetweenForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"fromDate": jsonEncode(fromDate),
				"toDate": jsonEncode(toDate),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byDateOfBirthBetweenForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Patient>> byFuzzyNameForDataOwner(String dataOwnerId, String searchString) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientFilters.byFuzzyNameForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"searchString": jsonEncode(searchString),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byFuzzyNameForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Patient>> byGenderEducationProfessionForDataOwner(String dataOwnerId, Gender gender, String? education, String? profession) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientFilters.byGenderEducationProfessionForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"gender": jsonEncode(Gender.encode(gender)),
				"education": jsonEncode(education),
				"profession": jsonEncode(profession),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byGenderEducationProfessionForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<Patient>> byActiveForDataOwner(String dataOwnerId, bool active) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientFilters.byActiveForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"active": jsonEncode(active),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byActiveForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Patient>> byTelecomForDataOwner(String dataOwnerId, String searchString) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientFilters.byTelecomForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"searchString": jsonEncode(searchString),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byTelecomForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Patient>> byAddressPostalCodeHouseNumberForDataOwner(String dataOwnerId, String searchString, String postalCode, String? houseNumber) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientFilters.byAddressPostalCodeHouseNumberForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"searchString": jsonEncode(searchString),
				"postalCode": jsonEncode(postalCode),
				"houseNumber": jsonEncode(houseNumber),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byAddressPostalCodeHouseNumberForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Patient>> byAddressForDataOwner(String dataOwnerId, String searchString) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientFilters.byAddressForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"searchString": jsonEncode(searchString),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byAddressForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Patient>> byExternalIdForDataOwner(String dataOwnerId, String externalIdPrefix) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientFilters.byExternalIdForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"externalIdPrefix": jsonEncode(externalIdPrefix),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byExternalIdForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Patient>> byIdentifiersForSelf(List<Identifier> identifiers) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientFilters.byIdentifiersForSelf',
			{
				"identifiers": jsonEncode(identifiers.map((x0) => Identifier.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byIdentifiersForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Patient>> bySsinsForSelf(List<String> ssins) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientFilters.bySsinsForSelf',
			{
				"ssins": jsonEncode(ssins.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method bySsinsForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Patient>> byDateOfBirthBetweenForSelf(int fromDate, int toDate) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientFilters.byDateOfBirthBetweenForSelf',
			{
				"fromDate": jsonEncode(fromDate),
				"toDate": jsonEncode(toDate),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byDateOfBirthBetweenForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Patient>> byNameForSelf(String searchString) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientFilters.byNameForSelf',
			{
				"searchString": jsonEncode(searchString),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byNameForSelf");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Patient>> byGenderEducationProfessionForSelf(Gender gender, String? education, String? profession) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientFilters.byGenderEducationProfessionForSelf',
			{
				"gender": jsonEncode(Gender.encode(gender)),
				"education": jsonEncode(education),
				"profession": jsonEncode(profession),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byGenderEducationProfessionForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Patient>> byActiveForSelf(bool active) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientFilters.byActiveForSelf',
			{
				"active": jsonEncode(active),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byActiveForSelf");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Patient>> byTelecomForSelf(String searchString) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientFilters.byTelecomForSelf',
			{
				"searchString": jsonEncode(searchString),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byTelecomForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Patient>> byAddressPostalCodeHouseNumberForSelf(String searchString, String postalCode, String? houseNumber) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientFilters.byAddressPostalCodeHouseNumberForSelf',
			{
				"searchString": jsonEncode(searchString),
				"postalCode": jsonEncode(postalCode),
				"houseNumber": jsonEncode(houseNumber),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byAddressPostalCodeHouseNumberForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Patient>> byAddressForSelf(String searchString) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientFilters.byAddressForSelf',
			{
				"searchString": jsonEncode(searchString),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byAddressForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Patient>> byExternalIdForSelf(String externalIdPrefix) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientFilters.byExternalIdForSelf',
			{
				"externalIdPrefix": jsonEncode(externalIdPrefix),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byExternalIdForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Patient>> byModificationDateForDataOwner(String dataOwnerId, int? from, int? to, { bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientFilters.byModificationDateForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
				"descending": jsonEncode(descending),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byModificationDateForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Patient>> byModificationDateForSelf(int? from, int? to, { bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PatientFilters.byModificationDateForSelf',
			{
				"from": jsonEncode(from),
				"to": jsonEncode(to),
				"descending": jsonEncode(descending),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byModificationDateForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}
}