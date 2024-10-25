import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/base/identifier.dart';
import 'package:cardinal_sdk/model/embed/gender.dart';


abstract class PatientFilters {
	PatientFilters();

	static Future<BaseFilterOptions<Patient>> allPatientsForDataOwner(String dataOwnerId) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.allPatientsForDataOwner(
			dataOwnerId,
		);
	}

	static Future<FilterOptions<Patient>> allPatientsForSelf() async {
		return CardinalSdkPlatformInterface.instance.filters.patient.allPatientsForSelf(
		);
	}

	static Future<SortableFilterOptions<Patient>> byIds(List<String> ids) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byIds(
			ids,
		);
	}

	static Future<BaseSortableFilterOptions<Patient>> byIdentifiersForDataOwner(String dataOwnerId, List<Identifier> identifiers) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byIdentifiersForDataOwner(
			dataOwnerId,
			identifiers,
		);
	}

	static Future<BaseSortableFilterOptions<Patient>> bySsinsForDataOwner(String dataOwnerId, List<String> ssins) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.bySsinsForDataOwner(
			dataOwnerId,
			ssins,
		);
	}

	static Future<BaseSortableFilterOptions<Patient>> byDateOfBirthBetweenForDataOwner(String dataOwnerId, int fromDate, int toDate) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byDateOfBirthBetweenForDataOwner(
			dataOwnerId,
			fromDate,
			toDate,
		);
	}

	static Future<BaseFilterOptions<Patient>> byFuzzyNameForDataOwner(String dataOwnerId, String searchString) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byFuzzyNameForDataOwner(
			dataOwnerId,
			searchString,
		);
	}

	static Future<BaseSortableFilterOptions<Patient>> byGenderEducationProfessionForDataOwner(String dataOwnerId, Gender gender, String? education, String? profession) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byGenderEducationProfessionForDataOwner(
			dataOwnerId,
			gender,
			education,
			profession,
		);
	}

	static Future<BaseFilterOptions<Patient>> byActiveForDataOwner(String dataOwnerId, bool active) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byActiveForDataOwner(
			dataOwnerId,
			active,
		);
	}

	static Future<BaseSortableFilterOptions<Patient>> byTelecomForDataOwner(String dataOwnerId, String searchString) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byTelecomForDataOwner(
			dataOwnerId,
			searchString,
		);
	}

	static Future<BaseSortableFilterOptions<Patient>> byAddressPostalCodeHouseNumberForDataOwner(String dataOwnerId, String searchString, String postalCode, String? houseNumber) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byAddressPostalCodeHouseNumberForDataOwner(
			dataOwnerId,
			searchString,
			postalCode,
			houseNumber,
		);
	}

	static Future<BaseSortableFilterOptions<Patient>> byAddressForDataOwner(String dataOwnerId, String searchString) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byAddressForDataOwner(
			dataOwnerId,
			searchString,
		);
	}

	static Future<BaseSortableFilterOptions<Patient>> byExternalIdForDataOwner(String dataOwnerId, String externalIdPrefix) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byExternalIdForDataOwner(
			dataOwnerId,
			externalIdPrefix,
		);
	}

	static Future<SortableFilterOptions<Patient>> byIdentifiersForSelf(List<Identifier> identifiers) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byIdentifiersForSelf(
			identifiers,
		);
	}

	static Future<SortableFilterOptions<Patient>> bySsinsForSelf(List<String> ssins) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.bySsinsForSelf(
			ssins,
		);
	}

	static Future<SortableFilterOptions<Patient>> byDateOfBirthBetweenForSelf(int fromDate, int toDate) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byDateOfBirthBetweenForSelf(
			fromDate,
			toDate,
		);
	}

	static Future<FilterOptions<Patient>> byNameForSelf(String searchString) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byNameForSelf(
			searchString,
		);
	}

	static Future<SortableFilterOptions<Patient>> byGenderEducationProfessionForSelf(Gender gender, String? education, String? profession) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byGenderEducationProfessionForSelf(
			gender,
			education,
			profession,
		);
	}

	static Future<FilterOptions<Patient>> byActiveForSelf(bool active) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byActiveForSelf(
			active,
		);
	}

	static Future<SortableFilterOptions<Patient>> byTelecomForSelf(String searchString) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byTelecomForSelf(
			searchString,
		);
	}

	static Future<SortableFilterOptions<Patient>> byAddressPostalCodeHouseNumberForSelf(String searchString, String postalCode, String? houseNumber) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byAddressPostalCodeHouseNumberForSelf(
			searchString,
			postalCode,
			houseNumber,
		);
	}

	static Future<SortableFilterOptions<Patient>> byAddressForSelf(String searchString) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byAddressForSelf(
			searchString,
		);
	}

	static Future<SortableFilterOptions<Patient>> byExternalIdForSelf(String externalIdPrefix) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byExternalIdForSelf(
			externalIdPrefix,
		);
	}

	static Future<BaseSortableFilterOptions<Patient>> byModificationDateForDataOwner(String dataOwnerId, int? from, int? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byModificationDateForDataOwner(
			dataOwnerId,
			from,
			to,
			descending: descending,
		);
	}

	static Future<SortableFilterOptions<Patient>> byModificationDateForSelf(int? from, int? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byModificationDateForSelf(
			from,
			to,
			descending: descending,
		);
	}
}