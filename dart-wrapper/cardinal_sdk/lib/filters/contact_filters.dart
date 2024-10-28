// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/contact.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/base/identifier.dart';


abstract class ContactFilters {
	ContactFilters();

	static Future<BaseFilterOptions<Contact>> allContactsForDataOwner(String dataOwnerId) async {
		return CardinalSdkPlatformInterface.instance.filters.contact.allContactsForDataOwner(
			dataOwnerId,
		);
	}

	static Future<FilterOptions<Contact>> allContactsForSelf() async {
		return CardinalSdkPlatformInterface.instance.filters.contact.allContactsForSelf(
		);
	}

	static Future<BaseFilterOptions<Contact>> byFormIdsForDataOwner(String dataOwnerId, Set<String> formIds) async {
		return CardinalSdkPlatformInterface.instance.filters.contact.byFormIdsForDataOwner(
			dataOwnerId,
			formIds,
		);
	}

	static Future<FilterOptions<Contact>> byFormIdsForSelf(Set<String> formIds) async {
		return CardinalSdkPlatformInterface.instance.filters.contact.byFormIdsForSelf(
			formIds,
		);
	}

	static Future<SortableFilterOptions<Contact>> byPatientsOpeningDateForDataOwner(String dataOwnerId, List<Patient> patients, int? from, int? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.contact.byPatientsOpeningDateForDataOwner(
			dataOwnerId,
			patients,
			from,
			to,
			descending: descending,
		);
	}

	static Future<SortableFilterOptions<Contact>> byPatientsOpeningDateForSelf(List<Patient> patients, int? from, int? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.contact.byPatientsOpeningDateForSelf(
			patients,
			from,
			to,
			descending: descending,
		);
	}

	static Future<BaseSortableFilterOptions<Contact>> byPatientSecretIdsOpeningDateForDataOwner(String dataOwnerId, List<String> secretIds, int? from, int? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.contact.byPatientSecretIdsOpeningDateForDataOwner(
			dataOwnerId,
			secretIds,
			from,
			to,
			descending: descending,
		);
	}

	static Future<SortableFilterOptions<Contact>> byPatientSecretIdsOpeningDateForSelf(List<String> secretIds, int? from, int? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.contact.byPatientSecretIdsOpeningDateForSelf(
			secretIds,
			from,
			to,
			descending: descending,
		);
	}

	static Future<BaseFilterOptions<Contact>> byExternalId(String externalId) async {
		return CardinalSdkPlatformInterface.instance.filters.contact.byExternalId(
			externalId,
		);
	}

	static Future<SortableFilterOptions<Contact>> byIdentifiersForSelf(List<Identifier> identifiers) async {
		return CardinalSdkPlatformInterface.instance.filters.contact.byIdentifiersForSelf(
			identifiers,
		);
	}

	static Future<BaseSortableFilterOptions<Contact>> byIdentifiersForDataOwner(String dataOwnerId, List<Identifier> identifiers) async {
		return CardinalSdkPlatformInterface.instance.filters.contact.byIdentifiersForDataOwner(
			dataOwnerId,
			identifiers,
		);
	}

	static Future<BaseSortableFilterOptions<Contact>> byCodeAndOpeningDateForDataOwner(String dataOwnerId, String codeType, String? codeCode, int? startOfContactOpeningDate, int? endOfContactOpeningDate) async {
		return CardinalSdkPlatformInterface.instance.filters.contact.byCodeAndOpeningDateForDataOwner(
			dataOwnerId,
			codeType,
			codeCode,
			startOfContactOpeningDate,
			endOfContactOpeningDate,
		);
	}

	static Future<SortableFilterOptions<Contact>> byCodeAndOpeningDateForSelf(String codeType, String? codeCode, int? startOfContactOpeningDate, int? endOfContactOpeningDate) async {
		return CardinalSdkPlatformInterface.instance.filters.contact.byCodeAndOpeningDateForSelf(
			codeType,
			codeCode,
			startOfContactOpeningDate,
			endOfContactOpeningDate,
		);
	}

	static Future<BaseSortableFilterOptions<Contact>> byTagAndOpeningDateForDataOwner(String dataOwnerId, String tagType, String? tagCode, int? startOfContactOpeningDate, int? endOfContactOpeningDate) async {
		return CardinalSdkPlatformInterface.instance.filters.contact.byTagAndOpeningDateForDataOwner(
			dataOwnerId,
			tagType,
			tagCode,
			startOfContactOpeningDate,
			endOfContactOpeningDate,
		);
	}

	static Future<BaseSortableFilterOptions<Contact>> byOpeningDateForDataOwner(String dataOwnerId, int? startDate, int? endDate, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.contact.byOpeningDateForDataOwner(
			dataOwnerId,
			startDate,
			endDate,
			descending: descending,
		);
	}

	static Future<SortableFilterOptions<Contact>> byOpeningDateForSelf(int? startDate, int? endDate, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.contact.byOpeningDateForSelf(
			startDate,
			endDate,
			descending: descending,
		);
	}

	static Future<FilterOptions<Contact>> byServiceTagForSelf(String tagType, String? tagCode) async {
		return CardinalSdkPlatformInterface.instance.filters.contact.byServiceTagForSelf(
			tagType,
			tagCode,
		);
	}

	static Future<BaseFilterOptions<Contact>> byServiceTagForDataOwner(String dataOwnerId, String tagType, String? tagCode) async {
		return CardinalSdkPlatformInterface.instance.filters.contact.byServiceTagForDataOwner(
			dataOwnerId,
			tagType,
			tagCode,
		);
	}

	static Future<FilterOptions<Contact>> byServiceCodeForSelf(String codeType, String? codeCode) async {
		return CardinalSdkPlatformInterface.instance.filters.contact.byServiceCodeForSelf(
			codeType,
			codeCode,
		);
	}

	static Future<BaseFilterOptions<Contact>> byServiceCodeForDataOwner(String dataOwnerId, String codeType, String? codeCode) async {
		return CardinalSdkPlatformInterface.instance.filters.contact.byServiceCodeForDataOwner(
			dataOwnerId,
			codeType,
			codeCode,
		);
	}

	static Future<SortableFilterOptions<Contact>> byTagAndOpeningDateForSelf(String tagType, String? tagCode, int? startOfContactOpeningDate, int? endOfContactOpeningDate) async {
		return CardinalSdkPlatformInterface.instance.filters.contact.byTagAndOpeningDateForSelf(
			tagType,
			tagCode,
			startOfContactOpeningDate,
			endOfContactOpeningDate,
		);
	}

	static Future<SortableFilterOptions<Contact>> byPatientsForDataOwner(String dataOwnerId, List<Patient> patients) async {
		return CardinalSdkPlatformInterface.instance.filters.contact.byPatientsForDataOwner(
			dataOwnerId,
			patients,
		);
	}

	static Future<SortableFilterOptions<Contact>> byPatientsForSelf(List<Patient> patients) async {
		return CardinalSdkPlatformInterface.instance.filters.contact.byPatientsForSelf(
			patients,
		);
	}

	static Future<BaseSortableFilterOptions<Contact>> byPatientsSecretIdsForDataOwner(String dataOwnerId, List<String> secretIds) async {
		return CardinalSdkPlatformInterface.instance.filters.contact.byPatientsSecretIdsForDataOwner(
			dataOwnerId,
			secretIds,
		);
	}

	static Future<SortableFilterOptions<Contact>> byPatientsSecretIdsForSelf(List<String> secretIds) async {
		return CardinalSdkPlatformInterface.instance.filters.contact.byPatientsSecretIdsForSelf(
			secretIds,
		);
	}

	static Future<BaseSortableFilterOptions<Contact>> byServiceIds(List<String> serviceIds) async {
		return CardinalSdkPlatformInterface.instance.filters.contact.byServiceIds(
			serviceIds,
		);
	}
}