// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/form.dart';
import 'package:cardinal_sdk/model/patient.dart';


abstract class FormFilters {
	FormFilters();

	static Future<BaseFilterOptions<Form>> byParentIdForDataOwner(String dataOwnerId, String parentId) async {
		return CardinalSdkPlatformInterface.instance.filters.form.byParentIdForDataOwner(
			dataOwnerId,
			parentId,
		);
	}

	static Future<FilterOptions<Form>> byParentIdForSelf(String parentId) async {
		return CardinalSdkPlatformInterface.instance.filters.form.byParentIdForSelf(
			parentId,
		);
	}

	static Future<SortableFilterOptions<Form>> byPatientsOpeningDateForDataOwner(String dataOwnerId, List<Patient> patients, { int? from, int? to, bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.form.byPatientsOpeningDateForDataOwner(
			dataOwnerId,
			patients,
			from: from,
			to: to,
			descending: descending,
		);
	}

	static Future<SortableFilterOptions<Form>> byPatientsOpeningDateForSelf(List<Patient> patients, { int? from, int? to, bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.form.byPatientsOpeningDateForSelf(
			patients,
			from: from,
			to: to,
			descending: descending,
		);
	}

	static Future<BaseSortableFilterOptions<Form>> byPatientSecretIdsOpeningDateForDataOwner(String dataOwnerId, List<String> secretIds, { int? from, int? to, bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.form.byPatientSecretIdsOpeningDateForDataOwner(
			dataOwnerId,
			secretIds,
			from: from,
			to: to,
			descending: descending,
		);
	}

	static Future<SortableFilterOptions<Form>> byPatientSecretIdsOpeningDateForSelf(List<String> secretIds, { int? from, int? to, bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.form.byPatientSecretIdsOpeningDateForSelf(
			secretIds,
			from: from,
			to: to,
			descending: descending,
		);
	}

	static Future<BaseSortableFilterOptions<Form>> byLogicalUuid(String logicalUuid, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.form.byLogicalUuid(
			logicalUuid,
			descending: descending,
		);
	}

	static Future<BaseSortableFilterOptions<Form>> byUniqueId(String uniqueId, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.form.byUniqueId(
			uniqueId,
			descending: descending,
		);
	}
}