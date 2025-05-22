// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'registration_information.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$RegistrationInformation {
  String get firstName;
  String get lastName;
  String get emailAddress;
  String? get userOptions;
  Set<String> get userRoles;
  String? get minimumKrakenVersion;

  /// Create a copy of RegistrationInformation
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $RegistrationInformationCopyWith<RegistrationInformation> get copyWith =>
      _$RegistrationInformationCopyWithImpl<RegistrationInformation>(
          this as RegistrationInformation, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is RegistrationInformation &&
            (identical(other.firstName, firstName) ||
                other.firstName == firstName) &&
            (identical(other.lastName, lastName) ||
                other.lastName == lastName) &&
            (identical(other.emailAddress, emailAddress) ||
                other.emailAddress == emailAddress) &&
            (identical(other.userOptions, userOptions) ||
                other.userOptions == userOptions) &&
            const DeepCollectionEquality().equals(other.userRoles, userRoles) &&
            (identical(other.minimumKrakenVersion, minimumKrakenVersion) ||
                other.minimumKrakenVersion == minimumKrakenVersion));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      firstName,
      lastName,
      emailAddress,
      userOptions,
      const DeepCollectionEquality().hash(userRoles),
      minimumKrakenVersion);

  @override
  String toString() {
    return 'RegistrationInformation(firstName: $firstName, lastName: $lastName, emailAddress: $emailAddress, userOptions: $userOptions, userRoles: $userRoles, minimumKrakenVersion: $minimumKrakenVersion)';
  }
}

/// @nodoc
abstract mixin class $RegistrationInformationCopyWith<$Res> {
  factory $RegistrationInformationCopyWith(RegistrationInformation value,
          $Res Function(RegistrationInformation) _then) =
      _$RegistrationInformationCopyWithImpl;
  @useResult
  $Res call(
      {String firstName,
      String lastName,
      String emailAddress,
      String? userOptions,
      Set<String> userRoles,
      String? minimumKrakenVersion});
}

/// @nodoc
class _$RegistrationInformationCopyWithImpl<$Res>
    implements $RegistrationInformationCopyWith<$Res> {
  _$RegistrationInformationCopyWithImpl(this._self, this._then);

  final RegistrationInformation _self;
  final $Res Function(RegistrationInformation) _then;

  /// Create a copy of RegistrationInformation
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? firstName = null,
    Object? lastName = null,
    Object? emailAddress = null,
    Object? userOptions = freezed,
    Object? userRoles = null,
    Object? minimumKrakenVersion = freezed,
  }) {
    return _then(_self.copyWith(
      firstName: null == firstName
          ? _self.firstName
          : firstName // ignore: cast_nullable_to_non_nullable
              as String,
      lastName: null == lastName
          ? _self.lastName
          : lastName // ignore: cast_nullable_to_non_nullable
              as String,
      emailAddress: null == emailAddress
          ? _self.emailAddress
          : emailAddress // ignore: cast_nullable_to_non_nullable
              as String,
      userOptions: freezed == userOptions
          ? _self.userOptions
          : userOptions // ignore: cast_nullable_to_non_nullable
              as String?,
      userRoles: null == userRoles
          ? _self.userRoles
          : userRoles // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      minimumKrakenVersion: freezed == minimumKrakenVersion
          ? _self.minimumKrakenVersion
          : minimumKrakenVersion // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _RegistrationInformation implements RegistrationInformation {
  const _RegistrationInformation(
      {required this.firstName,
      required this.lastName,
      required this.emailAddress,
      this.userOptions = null,
      final Set<String> userRoles = const {},
      this.minimumKrakenVersion = null})
      : _userRoles = userRoles;

  @override
  final String firstName;
  @override
  final String lastName;
  @override
  final String emailAddress;
  @override
  @JsonKey()
  final String? userOptions;
  final Set<String> _userRoles;
  @override
  @JsonKey()
  Set<String> get userRoles {
    if (_userRoles is EqualUnmodifiableSetView) return _userRoles;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_userRoles);
  }

  @override
  @JsonKey()
  final String? minimumKrakenVersion;

  /// Create a copy of RegistrationInformation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$RegistrationInformationCopyWith<_RegistrationInformation> get copyWith =>
      __$RegistrationInformationCopyWithImpl<_RegistrationInformation>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _RegistrationInformation &&
            (identical(other.firstName, firstName) ||
                other.firstName == firstName) &&
            (identical(other.lastName, lastName) ||
                other.lastName == lastName) &&
            (identical(other.emailAddress, emailAddress) ||
                other.emailAddress == emailAddress) &&
            (identical(other.userOptions, userOptions) ||
                other.userOptions == userOptions) &&
            const DeepCollectionEquality()
                .equals(other._userRoles, _userRoles) &&
            (identical(other.minimumKrakenVersion, minimumKrakenVersion) ||
                other.minimumKrakenVersion == minimumKrakenVersion));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      firstName,
      lastName,
      emailAddress,
      userOptions,
      const DeepCollectionEquality().hash(_userRoles),
      minimumKrakenVersion);

  @override
  String toString() {
    return 'RegistrationInformation(firstName: $firstName, lastName: $lastName, emailAddress: $emailAddress, userOptions: $userOptions, userRoles: $userRoles, minimumKrakenVersion: $minimumKrakenVersion)';
  }
}

/// @nodoc
abstract mixin class _$RegistrationInformationCopyWith<$Res>
    implements $RegistrationInformationCopyWith<$Res> {
  factory _$RegistrationInformationCopyWith(_RegistrationInformation value,
          $Res Function(_RegistrationInformation) _then) =
      __$RegistrationInformationCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String firstName,
      String lastName,
      String emailAddress,
      String? userOptions,
      Set<String> userRoles,
      String? minimumKrakenVersion});
}

/// @nodoc
class __$RegistrationInformationCopyWithImpl<$Res>
    implements _$RegistrationInformationCopyWith<$Res> {
  __$RegistrationInformationCopyWithImpl(this._self, this._then);

  final _RegistrationInformation _self;
  final $Res Function(_RegistrationInformation) _then;

  /// Create a copy of RegistrationInformation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? firstName = null,
    Object? lastName = null,
    Object? emailAddress = null,
    Object? userOptions = freezed,
    Object? userRoles = null,
    Object? minimumKrakenVersion = freezed,
  }) {
    return _then(_RegistrationInformation(
      firstName: null == firstName
          ? _self.firstName
          : firstName // ignore: cast_nullable_to_non_nullable
              as String,
      lastName: null == lastName
          ? _self.lastName
          : lastName // ignore: cast_nullable_to_non_nullable
              as String,
      emailAddress: null == emailAddress
          ? _self.emailAddress
          : emailAddress // ignore: cast_nullable_to_non_nullable
              as String,
      userOptions: freezed == userOptions
          ? _self.userOptions
          : userOptions // ignore: cast_nullable_to_non_nullable
              as String?,
      userRoles: null == userRoles
          ? _self._userRoles
          : userRoles // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      minimumKrakenVersion: freezed == minimumKrakenVersion
          ? _self.minimumKrakenVersion
          : minimumKrakenVersion // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

// dart format on
