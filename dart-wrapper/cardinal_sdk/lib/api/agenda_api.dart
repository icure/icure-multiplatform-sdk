// auto-generated file
import 'package:cardinal_sdk/model/agenda.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/group_scoped.dart';


class AgendaApi {
	final String _sdkId;
	final Object _dartSdk;
	final AgendaInGroupApi inGroup;
	AgendaApi(
		this._sdkId,
		this._dartSdk
		) : inGroup = AgendaInGroupApi(_sdkId, _dartSdk);

	Future<Agenda> createAgenda(Agenda agendaDto) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.createAgenda(
			_sdkId,
			agendaDto,
		);
	}

	Future<DocIdentifier> deleteAgendaById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.deleteAgendaById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteAgendasByIds(List<StoredDocumentIdentifier> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.deleteAgendasByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeAgendaById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.purgeAgendaById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<Agenda> undeleteAgendaById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.undeleteAgendaById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteAgenda(Agenda agenda) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.deleteAgenda(
			_sdkId,
			agenda,
		);
	}

	Future<List<DocIdentifier>> deleteAgendas(List<Agenda> agendas) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.deleteAgendas(
			_sdkId,
			agendas,
		);
	}

	Future<void> purgeAgenda(Agenda agenda) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.purgeAgenda(
			_sdkId,
			agenda,
		);
	}

	Future<Agenda> undeleteAgenda(Agenda agenda) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.undeleteAgenda(
			_sdkId,
			agenda,
		);
	}

	Future<Agenda?> getAgenda(String agendaId) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.getAgenda(
			_sdkId,
			agendaId,
		);
	}

	Future<List<Agenda>> getAgendas(List<String> agendaIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.getAgendas(
			_sdkId,
			agendaIds,
		);
	}

	Future<Agenda> modifyAgenda(Agenda agendaDto) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.modifyAgenda(
			_sdkId,
			agendaDto,
		);
	}

	Future<List<String>> matchAgendasBy(BaseFilterOptions<Agenda> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.matchAgendasBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchAgendasBySorted(BaseSortableFilterOptions<Agenda> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.matchAgendasBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<Agenda>> filterAgendasBy(BaseFilterOptions<Agenda> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.filterAgendasBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<Agenda>> filterAgendasBySorted(BaseSortableFilterOptions<Agenda> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.filterAgendasBySorted(
			_sdkId,
			filter,
		);
	}
}

class AgendaInGroupApi {
	final String _sdkId;
	final Object _dartSdk;
	AgendaInGroupApi(
		this._sdkId,
		this._dartSdk
		);

	Future<GroupScoped<Agenda>?> getAgenda(String groupId, String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.inGroup.getAgenda(
			_sdkId,
			groupId,
			entityId,
		);
	}

	Future<List<GroupScoped<Agenda>>> getAgendas(String groupId, List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.inGroup.getAgendas(
			_sdkId,
			groupId,
			entityIds,
		);
	}

	Future<GroupScoped<Agenda>> createAgenda(GroupScoped<Agenda> entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.inGroup.createAgenda(
			_sdkId,
			entity,
		);
	}

	Future<GroupScoped<Agenda>> modifyAgenda(GroupScoped<Agenda> entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.inGroup.modifyAgenda(
			_sdkId,
			entity,
		);
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> deleteAgendas(List<GroupScoped<Agenda>> agendas) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.inGroup.deleteAgendas(
			_sdkId,
			agendas,
		);
	}

	Future<GroupScoped<StoredDocumentIdentifier>> deleteAgenda(GroupScoped<Agenda> agenda) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.inGroup.deleteAgenda(
			_sdkId,
			agenda,
		);
	}

	Future<List<GroupScoped<StoredDocumentIdentifier>>> deleteAgendasByIds(List<GroupScoped<StoredDocumentIdentifier>> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.inGroup.deleteAgendasByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<GroupScoped<StoredDocumentIdentifier>> deleteAgendaById(GroupScoped<StoredDocumentIdentifier> entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.inGroup.deleteAgendaById(
			_sdkId,
			entityId,
		);
	}

	Future<List<String>> matchAgendasBy(String groupId, BaseFilterOptions<Agenda> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.inGroup.matchAgendasBy(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<List<String>> matchAgendasBySorted(String groupId, BaseSortableFilterOptions<Agenda> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.inGroup.matchAgendasBySorted(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<PaginatedListIterator<GroupScoped<Agenda>>> filterAgendasBy(String groupId, BaseFilterOptions<Agenda> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.inGroup.filterAgendasBy(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<PaginatedListIterator<GroupScoped<Agenda>>> filterAgendasBySorted(String groupId, BaseSortableFilterOptions<Agenda> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.agenda.inGroup.filterAgendasBySorted(
			_sdkId,
			groupId,
			filter,
		);
	}
}