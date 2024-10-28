// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/health_element.dart';
import 'package:cardinal_sdk/model/base/identifier.dart';
import 'package:cardinal_sdk/model/patient.dart';


abstract class HealthElementFilters {
	HealthElementFilters();

	static Future<BaseFilterOptions<HealthElement>> allHealthElementsForDataOwner(String dataOwnerId) async {
		return CardinalSdkPlatformInterface.instance.filters.healthElement.allHealthElementsForDataOwner(
			dataOwnerId,
		);
	}

	static Future<FilterOptions<HealthElement>> allHealthElementsForSelf() async {
		return CardinalSdkPlatformInterface.instance.filters.healthElement.allHealthElementsForSelf(
		);
	}

	static Future<BaseSortableFilterOptions<HealthElement>> byIdentifiersForDataOwner(String dataOwnerId, List<Identifier> identifiers) async {
		return CardinalSdkPlatformInterface.instance.filters.healthElement.byIdentifiersForDataOwner(
			dataOwnerId,
			identifiers,
		);
	}

	static Future<SortableFilterOptions<HealthElement>> byIdentifiersForSelf(List<Identifier> identifiers) async {
		return CardinalSdkPlatformInterface.instance.filters.healthElement.byIdentifiersForSelf(
			identifiers,
		);
	}

	static Future<BaseSortableFilterOptions<HealthElement>> byCodeForDataOwner(String dataOwnerId, String codeType, String? codeCode) async {
		return CardinalSdkPlatformInterface.instance.filters.healthElement.byCodeForDataOwner(
			dataOwnerId,
			codeType,
			codeCode,
		);
	}

	static Future<SortableFilterOptions<HealthElement>> byCodeForSelf(String codeType, String? codeCode) async {
		return CardinalSdkPlatformInterface.instance.filters.healthElement.byCodeForSelf(
			codeType,
			codeCode,
		);
	}

	static Future<BaseSortableFilterOptions<HealthElement>> byTagForDataOwner(String dataOwnerId, String tagType, String? tagCode) async {
		return CardinalSdkPlatformInterface.instance.filters.healthElement.byTagForDataOwner(
			dataOwnerId,
			tagType,
			tagCode,
		);
	}

	static Future<SortableFilterOptions<HealthElement>> byTagForSelf(String tagType, String? tagCode) async {
		return CardinalSdkPlatformInterface.instance.filters.healthElement.byTagForSelf(
			tagType,
			tagCode,
		);
	}

	static Future<SortableFilterOptions<HealthElement>> byPatientsForDataOwner(String dataOwnerId, List<Patient> patients) async {
		return CardinalSdkPlatformInterface.instance.filters.healthElement.byPatientsForDataOwner(
			dataOwnerId,
			patients,
		);
	}

	static Future<SortableFilterOptions<HealthElement>> byPatientsForSelf(List<Patient> patients) async {
		return CardinalSdkPlatformInterface.instance.filters.healthElement.byPatientsForSelf(
			patients,
		);
	}

	static Future<BaseSortableFilterOptions<HealthElement>> byPatientsSecretIdsForDataOwner(String dataOwnerId, List<String> secretIds) async {
		return CardinalSdkPlatformInterface.instance.filters.healthElement.byPatientsSecretIdsForDataOwner(
			dataOwnerId,
			secretIds,
		);
	}

	static Future<SortableFilterOptions<HealthElement>> byPatientsSecretIdsForSelf(List<String> secretIds) async {
		return CardinalSdkPlatformInterface.instance.filters.healthElement.byPatientsSecretIdsForSelf(
			secretIds,
		);
	}

	static Future<BaseSortableFilterOptions<HealthElement>> byIds(List<String> ids) async {
		return CardinalSdkPlatformInterface.instance.filters.healthElement.byIds(
			ids,
		);
	}

	static Future<SortableFilterOptions<HealthElement>> byPatientsOpeningDateForDataOwner(String dataOwnerId, List<Patient> patients, int? from, int? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.healthElement.byPatientsOpeningDateForDataOwner(
			dataOwnerId,
			patients,
			from,
			to,
			descending: descending,
		);
	}

	static Future<SortableFilterOptions<HealthElement>> byPatientsOpeningDateForSelf(List<Patient> patients, int? from, int? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.healthElement.byPatientsOpeningDateForSelf(
			patients,
			from,
			to,
			descending: descending,
		);
	}

	static Future<BaseSortableFilterOptions<HealthElement>> byPatientSecretIdsOpeningDateForDataOwner(String dataOwnerId, List<String> secretIds, int? from, int? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.healthElement.byPatientSecretIdsOpeningDateForDataOwner(
			dataOwnerId,
			secretIds,
			from,
			to,
			descending: descending,
		);
	}

	static Future<SortableFilterOptions<HealthElement>> byPatientSecretIdsOpeningDateForSelf(List<String> secretIds, int? from, int? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.healthElement.byPatientSecretIdsOpeningDateForSelf(
			secretIds,
			from,
			to,
			descending: descending,
		);
	}

	static Future<BaseFilterOptions<HealthElement>> byStatusForDataOwner(String dataOwnerId, int status) async {
		return CardinalSdkPlatformInterface.instance.filters.healthElement.byStatusForDataOwner(
			dataOwnerId,
			status,
		);
	}

	static Future<FilterOptions<HealthElement>> byStatusForSelf(int status) async {
		return CardinalSdkPlatformInterface.instance.filters.healthElement.byStatusForSelf(
			status,
		);
	}
}