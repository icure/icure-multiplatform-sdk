// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/embed/service.dart';
import 'package:cardinal_sdk/model/base/identifier.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/base/link_qualification.dart';


abstract class ServiceFilters {
	ServiceFilters();

	static Future<BaseFilterOptions<Service>> allServicesForDataOwner(String dataOwnerId) async {
		return CardinalSdkPlatformInterface.instance.filters.service.allServicesForDataOwner(
			dataOwnerId,
		);
	}

	static Future<FilterOptions<Service>> allServicesForSelf() async {
		return CardinalSdkPlatformInterface.instance.filters.service.allServicesForSelf(
		);
	}

	static Future<BaseSortableFilterOptions<Service>> byIdentifiersForDataOwner(String dataOwnerId, List<Identifier> identifiers) async {
		return CardinalSdkPlatformInterface.instance.filters.service.byIdentifiersForDataOwner(
			dataOwnerId,
			identifiers,
		);
	}

	static Future<BaseSortableFilterOptions<Service>> byCodeAndValueDateForDataOwner(String dataOwnerId, String codeType, String? codeCode, int? startOfServiceValueDate, int? endOfServiceValueDate) async {
		return CardinalSdkPlatformInterface.instance.filters.service.byCodeAndValueDateForDataOwner(
			dataOwnerId,
			codeType,
			codeCode,
			startOfServiceValueDate,
			endOfServiceValueDate,
		);
	}

	static Future<BaseSortableFilterOptions<Service>> byTagAndValueDateForDataOwner(String dataOwnerId, String tagType, String? tagCode, int? startOfServiceValueDate, int? endOfServiceValueDate) async {
		return CardinalSdkPlatformInterface.instance.filters.service.byTagAndValueDateForDataOwner(
			dataOwnerId,
			tagType,
			tagCode,
			startOfServiceValueDate,
			endOfServiceValueDate,
		);
	}

	static Future<SortableFilterOptions<Service>> byPatientsForDataOwner(String dataOwnerId, List<Patient> patients) async {
		return CardinalSdkPlatformInterface.instance.filters.service.byPatientsForDataOwner(
			dataOwnerId,
			patients,
		);
	}

	static Future<BaseSortableFilterOptions<Service>> byPatientsSecretIdsForDataOwner(String dataOwnerId, List<String> secretIds) async {
		return CardinalSdkPlatformInterface.instance.filters.service.byPatientsSecretIdsForDataOwner(
			dataOwnerId,
			secretIds,
		);
	}

	static Future<BaseSortableFilterOptions<Service>> byHealthElementIdFromSubContactForDataOwner(String dataOwnerId, List<String> healthElementIds) async {
		return CardinalSdkPlatformInterface.instance.filters.service.byHealthElementIdFromSubContactForDataOwner(
			dataOwnerId,
			healthElementIds,
		);
	}

	static Future<SortableFilterOptions<Service>> byIdentifiersForSelf(List<Identifier> identifiers) async {
		return CardinalSdkPlatformInterface.instance.filters.service.byIdentifiersForSelf(
			identifiers,
		);
	}

	static Future<SortableFilterOptions<Service>> byCodeAndValueDateForSelf(String codeType, String? codeCode, int? startOfServiceValueDate, int? endOfServiceValueDate) async {
		return CardinalSdkPlatformInterface.instance.filters.service.byCodeAndValueDateForSelf(
			codeType,
			codeCode,
			startOfServiceValueDate,
			endOfServiceValueDate,
		);
	}

	static Future<SortableFilterOptions<Service>> byTagAndValueDateForSelf(String tagType, String? tagCode, int? startOfServiceValueDate, int? endOfServiceValueDate) async {
		return CardinalSdkPlatformInterface.instance.filters.service.byTagAndValueDateForSelf(
			tagType,
			tagCode,
			startOfServiceValueDate,
			endOfServiceValueDate,
		);
	}

	static Future<SortableFilterOptions<Service>> byPatientsForSelf(List<Patient> patients) async {
		return CardinalSdkPlatformInterface.instance.filters.service.byPatientsForSelf(
			patients,
		);
	}

	static Future<SortableFilterOptions<Service>> byPatientsSecretIdsForSelf(List<String> secretIds) async {
		return CardinalSdkPlatformInterface.instance.filters.service.byPatientsSecretIdsForSelf(
			secretIds,
		);
	}

	static Future<SortableFilterOptions<Service>> byHealthElementIdFromSubContactForSelf(List<String> healthElementIds) async {
		return CardinalSdkPlatformInterface.instance.filters.service.byHealthElementIdFromSubContactForSelf(
			healthElementIds,
		);
	}

	static Future<BaseSortableFilterOptions<Service>> byIds(List<String> ids) async {
		return CardinalSdkPlatformInterface.instance.filters.service.byIds(
			ids,
		);
	}

	static Future<BaseFilterOptions<Service>> byAssociationId(String associationId) async {
		return CardinalSdkPlatformInterface.instance.filters.service.byAssociationId(
			associationId,
		);
	}

	static Future<BaseFilterOptions<Service>> byQualifiedLink(List<String> linkValues, LinkQualification? linkQualification) async {
		return CardinalSdkPlatformInterface.instance.filters.service.byQualifiedLink(
			linkValues,
			linkQualification,
		);
	}

	static Future<SortableFilterOptions<Service>> byPatientsDateForDataOwner(String dataOwnerId, List<Patient> patients, int? from, int? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.service.byPatientsDateForDataOwner(
			dataOwnerId,
			patients,
			from,
			to,
			descending: descending,
		);
	}

	static Future<SortableFilterOptions<Service>> byPatientsDateForSelf(List<Patient> patients, int? from, int? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.service.byPatientsDateForSelf(
			patients,
			from,
			to,
			descending: descending,
		);
	}

	static Future<BaseSortableFilterOptions<Service>> byPatientSecretIdsDateForDataOwner(String dataOwnerId, List<String> secretIds, int? from, int? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.service.byPatientSecretIdsDateForDataOwner(
			dataOwnerId,
			secretIds,
			from,
			to,
			descending: descending,
		);
	}

	static Future<SortableFilterOptions<Service>> byPatientSecretIdsDateForSelf(List<String> secretIds, int? from, int? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.service.byPatientSecretIdsDateForSelf(
			secretIds,
			from,
			to,
			descending: descending,
		);
	}
}