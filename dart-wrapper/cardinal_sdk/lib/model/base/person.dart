// auto-generated file
import 'package:cardinal_sdk/model/embed/gender.dart';
import 'package:cardinal_sdk/model/embed/person_name.dart';
import 'package:cardinal_sdk/model/embed/address.dart';
import 'package:cardinal_sdk/model/base/identifiable.dart';


abstract interface class Person implements Identifiable<String> {
	abstract final String? civility;
	abstract final Gender? gender;
	abstract final String? firstName;
	abstract final String? lastName;
	abstract final String? companyName;
	abstract final List<PersonName> names;
	List<Address> get addresses;
	abstract final List<String> languages;
}