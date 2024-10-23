// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/agenda.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';


class AgendaPlatformApi {
	MethodChannel _methodChannel;
	AgendaPlatformApi(this._methodChannel);

	Future<Agenda> createAgenda(String sdkId, Agenda agendaDto) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaApi.createAgenda',
			{
				"sdkId": sdkId,
				"agendaDto": jsonEncode(Agenda.encode(agendaDto)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createAgenda");
		final parsedResJson = jsonDecode(res);
		return Agenda.fromJSON(parsedResJson);
	}

	Future<DocIdentifier> deleteAgendaById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaApi.deleteAgendaById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteAgendaById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteAgendasByIds(String sdkId, List<IdWithMandatoryRev> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaApi.deleteAgendasByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => IdWithMandatoryRev.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteAgendasByIds");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DocIdentifier.fromJSON(x1) );
	}

	Future<void> purgeAgendaById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaApi.purgeAgendaById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
	}

	Future<Agenda> undeleteAgendaById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaApi.undeleteAgendaById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteAgendaById");
		final parsedResJson = jsonDecode(res);
		return Agenda.fromJSON(parsedResJson);
	}

	Future<DocIdentifier> deleteAgenda(String sdkId, Agenda agenda) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaApi.deleteAgenda',
			{
				"sdkId": sdkId,
				"agenda": jsonEncode(Agenda.encode(agenda)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteAgenda");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteAgendas(String sdkId, List<Agenda> agendas) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaApi.deleteAgendas',
			{
				"sdkId": sdkId,
				"agendas": jsonEncode(agendas.map((x0) => Agenda.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteAgendas");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DocIdentifier.fromJSON(x1) );
	}

	Future<void> purgeAgenda(String sdkId, Agenda agenda) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaApi.purgeAgenda',
			{
				"sdkId": sdkId,
				"agenda": jsonEncode(Agenda.encode(agenda)),
			}
		);
	}

	Future<Agenda> undeleteAgenda(String sdkId, Agenda agenda) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaApi.undeleteAgenda',
			{
				"sdkId": sdkId,
				"agenda": jsonEncode(Agenda.encode(agenda)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteAgenda");
		final parsedResJson = jsonDecode(res);
		return Agenda.fromJSON(parsedResJson);
	}

	Future<Agenda> getAgenda(String sdkId, String agendaId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaApi.getAgenda',
			{
				"sdkId": sdkId,
				"agendaId": jsonEncode(agendaId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getAgenda");
		final parsedResJson = jsonDecode(res);
		return Agenda.fromJSON(parsedResJson);
	}

	Future<List<Agenda>> getAgendas(String sdkId, List<String> agendaIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaApi.getAgendas',
			{
				"sdkId": sdkId,
				"agendaIds": jsonEncode(agendaIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getAgendas");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => Agenda.fromJSON(x1) );
	}

	Future<Agenda> modifyAgenda(String sdkId, Agenda agendaDto) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaApi.modifyAgenda',
			{
				"sdkId": sdkId,
				"agendaDto": jsonEncode(Agenda.encode(agendaDto)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyAgenda");
		final parsedResJson = jsonDecode(res);
		return Agenda.fromJSON(parsedResJson);
	}

	Future<List<String>> matchAgendasBy(String sdkId, BaseFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaApi.matchAgendasBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchAgendasBy");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<List<String>> matchAgendasBySorted(String sdkId, BaseSortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaApi.matchAgendasBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchAgendasBySorted");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<PaginatedListIterator<Agenda>> filterAgendasBy(String sdkId, BaseFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaApi.filterAgendasBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterAgendasBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Agenda.fromJSON(x0));
	}

	Future<PaginatedListIterator<Agenda>> filterAgendasBySorted(String sdkId, BaseSortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AgendaApi.filterAgendasBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterAgendasBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Agenda.fromJSON(x0));
	}
}