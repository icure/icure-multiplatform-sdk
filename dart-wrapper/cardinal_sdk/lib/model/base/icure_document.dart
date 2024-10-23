// auto-generated file
import 'package:cardinal_sdk/model/base/identifiable.dart';
import 'package:cardinal_sdk/model/base/has_tags.dart';
import 'package:cardinal_sdk/model/base/has_codes.dart';


abstract interface class ICureDocument<T> implements Identifiable<T>, HasTags, HasCodes {
	abstract int? created;
	abstract int? modified;
	abstract String? author;
	abstract String? responsible;
	abstract String? medicalLocationId;
	abstract int? endOfLife;
}