// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/user.dart';


class UserPlatformFilters {
	MethodChannel _methodChannel;
	UserPlatformFilters(this._methodChannel);

	Future<BaseFilterOptions<User>> all() async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserFilters.all',
			{
			}
		);
		if (res == null) throw AssertionError("received null result from platform method all");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<User>> byIds(List<String> ids) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserFilters.byIds',
			{
				"ids": jsonEncode(ids.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byIds");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<User>> byPatientId(String patientId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserFilters.byPatientId',
			{
				"patientId": jsonEncode(patientId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byPatientId");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<User>> byHealthcarePartyId(String healthcarePartyId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserFilters.byHealthcarePartyId',
			{
				"healthcarePartyId": jsonEncode(healthcarePartyId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byHealthcarePartyId");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<User>> byNameEmailOrPhone(String searchString) async {
		final res = await _methodChannel.invokeMethod<String>(
			'UserFilters.byNameEmailOrPhone',
			{
				"searchString": jsonEncode(searchString),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byNameEmailOrPhone");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}
}