// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/entity_reference_in_group.dart';
import 'package:cardinal_sdk/model/base/identifier.dart';
import 'package:cardinal_sdk/model/embed/gender.dart';


abstract class PatientFilters {
	PatientFilters();

	static Future<BaseFilterOptions<Patient>> allPatientsForDataOwner(String dataOwnerId) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.allPatientsForDataOwner(
			dataOwnerId,
		);
	}

	static Future<BaseFilterOptions<Patient>> allPatientsForDataOwnerInGroup(EntityReferenceInGroup dataOwner) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.allPatientsForDataOwnerInGroup(
			dataOwner,
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

	static Future<BaseSortableFilterOptions<Patient>> byIdentifiersForDataOwnerInGroup(EntityReferenceInGroup dataOwner, List<Identifier> identifiers) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byIdentifiersForDataOwnerInGroup(
			dataOwner,
			identifiers,
		);
	}

	static Future<BaseSortableFilterOptions<Patient>> bySsinsForDataOwner(String dataOwnerId, List<String> ssins) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.bySsinsForDataOwner(
			dataOwnerId,
			ssins,
		);
	}

	static Future<BaseSortableFilterOptions<Patient>> bySsinsForDataOwnerInGroup(EntityReferenceInGroup dataOwner, List<String> ssins) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.bySsinsForDataOwnerInGroup(
			dataOwner,
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

	static Future<BaseSortableFilterOptions<Patient>> byDateOfBirthBetweenForDataOwnerInGroup(EntityReferenceInGroup dataOwner, int fromDate, int toDate) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byDateOfBirthBetweenForDataOwnerInGroup(
			dataOwner,
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

	static Future<BaseFilterOptions<Patient>> byFuzzyNameForDataOwnerInGroup(EntityReferenceInGroup dataOwner, String searchString) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byFuzzyNameForDataOwnerInGroup(
			dataOwner,
			searchString,
		);
	}

	static Future<BaseSortableFilterOptions<Patient>> byGenderEducationProfessionForDataOwner(String dataOwnerId, Gender gender, { String? education, String? profession }) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byGenderEducationProfessionForDataOwner(
			dataOwnerId,
			gender,
			education: education,
			profession: profession,
		);
	}

	static Future<BaseSortableFilterOptions<Patient>> byGenderEducationProfessionForDataOwnerInGroup(EntityReferenceInGroup dataOwner, Gender gender, { String? education, String? profession }) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byGenderEducationProfessionForDataOwnerInGroup(
			dataOwner,
			gender,
			education: education,
			profession: profession,
		);
	}

	static Future<BaseFilterOptions<Patient>> byActiveForDataOwner(String dataOwnerId, bool active) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byActiveForDataOwner(
			dataOwnerId,
			active,
		);
	}

	static Future<BaseFilterOptions<Patient>> byActiveForDataOwnerInGroup(EntityReferenceInGroup dataOwner, bool active) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byActiveForDataOwnerInGroup(
			dataOwner,
			active,
		);
	}

	static Future<BaseSortableFilterOptions<Patient>> byTelecomForDataOwner(String dataOwnerId, String searchString) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byTelecomForDataOwner(
			dataOwnerId,
			searchString,
		);
	}

	static Future<BaseSortableFilterOptions<Patient>> byTelecomForDataOwnerInGroup(EntityReferenceInGroup dataOwner, String searchString) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byTelecomForDataOwnerInGroup(
			dataOwner,
			searchString,
		);
	}

	static Future<BaseSortableFilterOptions<Patient>> byAddressPostalCodeHouseNumberForDataOwner(String dataOwnerId, String searchString, String postalCode, { String? houseNumber }) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byAddressPostalCodeHouseNumberForDataOwner(
			dataOwnerId,
			searchString,
			postalCode,
			houseNumber: houseNumber,
		);
	}

	static Future<BaseSortableFilterOptions<Patient>> byAddressPostalCodeHouseNumberForDataOwnerInGroup(EntityReferenceInGroup dataOwner, String searchString, String postalCode, { String? houseNumber }) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byAddressPostalCodeHouseNumberForDataOwnerInGroup(
			dataOwner,
			searchString,
			postalCode,
			houseNumber: houseNumber,
		);
	}

	static Future<BaseSortableFilterOptions<Patient>> byAddressForDataOwner(String dataOwnerId, String searchString) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byAddressForDataOwner(
			dataOwnerId,
			searchString,
		);
	}

	static Future<BaseSortableFilterOptions<Patient>> byAddressForDataOwnerInGroup(EntityReferenceInGroup dataOwner, String searchString) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byAddressForDataOwnerInGroup(
			dataOwner,
			searchString,
		);
	}

	static Future<BaseSortableFilterOptions<Patient>> byExternalIdForDataOwner(String dataOwnerId, String externalIdPrefix) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byExternalIdForDataOwner(
			dataOwnerId,
			externalIdPrefix,
		);
	}

	static Future<BaseSortableFilterOptions<Patient>> byExternalIdForDataOwnerInGroup(EntityReferenceInGroup dataOwner, String externalIdPrefix) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byExternalIdForDataOwnerInGroup(
			dataOwner,
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

	static Future<SortableFilterOptions<Patient>> byGenderEducationProfessionForSelf(Gender gender, { String? education, String? profession }) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byGenderEducationProfessionForSelf(
			gender,
			education: education,
			profession: profession,
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

	static Future<SortableFilterOptions<Patient>> byAddressPostalCodeHouseNumberForSelf(String searchString, String postalCode, { String? houseNumber }) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byAddressPostalCodeHouseNumberForSelf(
			searchString,
			postalCode,
			houseNumber: houseNumber,
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

	static Future<FilterOptions<Patient>> byTagForSelf(String tagType, String? tagCode) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byTagForSelf(
			tagType,
			tagCode,
		);
	}

	static Future<BaseFilterOptions<Patient>> byTagForDataOwner(String dataOwnerId, String tagType, String? tagCode) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byTagForDataOwner(
			dataOwnerId,
			tagType,
			tagCode,
		);
	}

	static Future<BaseFilterOptions<Patient>> byTagForDataOwnerInGroup(EntityReferenceInGroup dataOwner, String tagType, String? tagCode) async {
		return CardinalSdkPlatformInterface.instance.filters.patient.byTagForDataOwnerInGroup(
			dataOwner,
			tagType,
			tagCode,
		);
	}
}