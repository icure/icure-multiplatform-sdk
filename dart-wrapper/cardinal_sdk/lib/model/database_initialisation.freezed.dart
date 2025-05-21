// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'database_initialisation.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DatabaseInitialisation {
  List<User>? get users;
  List<HealthcareParty>? get healthcareParties;
  Replication? get replication;
  String? get minimumKrakenVersion;

  /// Create a copy of DatabaseInitialisation
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DatabaseInitialisationCopyWith<DatabaseInitialisation> get copyWith =>
      _$DatabaseInitialisationCopyWithImpl<DatabaseInitialisation>(
          this as DatabaseInitialisation, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DatabaseInitialisation &&
            const DeepCollectionEquality().equals(other.users, users) &&
            const DeepCollectionEquality()
                .equals(other.healthcareParties, healthcareParties) &&
            (identical(other.replication, replication) ||
                other.replication == replication) &&
            (identical(other.minimumKrakenVersion, minimumKrakenVersion) ||
                other.minimumKrakenVersion == minimumKrakenVersion));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(users),
      const DeepCollectionEquality().hash(healthcareParties),
      replication,
      minimumKrakenVersion);

  @override
  String toString() {
    return 'DatabaseInitialisation(users: $users, healthcareParties: $healthcareParties, replication: $replication, minimumKrakenVersion: $minimumKrakenVersion)';
  }
}

/// @nodoc
abstract mixin class $DatabaseInitialisationCopyWith<$Res> {
  factory $DatabaseInitialisationCopyWith(DatabaseInitialisation value,
          $Res Function(DatabaseInitialisation) _then) =
      _$DatabaseInitialisationCopyWithImpl;
  @useResult
  $Res call(
      {List<User>? users,
      List<HealthcareParty>? healthcareParties,
      Replication? replication,
      String? minimumKrakenVersion});

  $ReplicationCopyWith<$Res>? get replication;
}

/// @nodoc
class _$DatabaseInitialisationCopyWithImpl<$Res>
    implements $DatabaseInitialisationCopyWith<$Res> {
  _$DatabaseInitialisationCopyWithImpl(this._self, this._then);

  final DatabaseInitialisation _self;
  final $Res Function(DatabaseInitialisation) _then;

  /// Create a copy of DatabaseInitialisation
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? users = freezed,
    Object? healthcareParties = freezed,
    Object? replication = freezed,
    Object? minimumKrakenVersion = freezed,
  }) {
    return _then(_self.copyWith(
      users: freezed == users
          ? _self.users
          : users // ignore: cast_nullable_to_non_nullable
              as List<User>?,
      healthcareParties: freezed == healthcareParties
          ? _self.healthcareParties
          : healthcareParties // ignore: cast_nullable_to_non_nullable
              as List<HealthcareParty>?,
      replication: freezed == replication
          ? _self.replication
          : replication // ignore: cast_nullable_to_non_nullable
              as Replication?,
      minimumKrakenVersion: freezed == minimumKrakenVersion
          ? _self.minimumKrakenVersion
          : minimumKrakenVersion // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }

  /// Create a copy of DatabaseInitialisation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $ReplicationCopyWith<$Res>? get replication {
    if (_self.replication == null) {
      return null;
    }

    return $ReplicationCopyWith<$Res>(_self.replication!, (value) {
      return _then(_self.copyWith(replication: value));
    });
  }
}

/// @nodoc

class _DatabaseInitialisation implements DatabaseInitialisation {
  const _DatabaseInitialisation(
      {final List<User>? users = const [],
      final List<HealthcareParty>? healthcareParties = const [],
      this.replication = null,
      this.minimumKrakenVersion = null})
      : _users = users,
        _healthcareParties = healthcareParties;

  final List<User>? _users;
  @override
  @JsonKey()
  List<User>? get users {
    final value = _users;
    if (value == null) return null;
    if (_users is EqualUnmodifiableListView) return _users;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  final List<HealthcareParty>? _healthcareParties;
  @override
  @JsonKey()
  List<HealthcareParty>? get healthcareParties {
    final value = _healthcareParties;
    if (value == null) return null;
    if (_healthcareParties is EqualUnmodifiableListView)
      return _healthcareParties;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  @override
  @JsonKey()
  final Replication? replication;
  @override
  @JsonKey()
  final String? minimumKrakenVersion;

  /// Create a copy of DatabaseInitialisation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DatabaseInitialisationCopyWith<_DatabaseInitialisation> get copyWith =>
      __$DatabaseInitialisationCopyWithImpl<_DatabaseInitialisation>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DatabaseInitialisation &&
            const DeepCollectionEquality().equals(other._users, _users) &&
            const DeepCollectionEquality()
                .equals(other._healthcareParties, _healthcareParties) &&
            (identical(other.replication, replication) ||
                other.replication == replication) &&
            (identical(other.minimumKrakenVersion, minimumKrakenVersion) ||
                other.minimumKrakenVersion == minimumKrakenVersion));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(_users),
      const DeepCollectionEquality().hash(_healthcareParties),
      replication,
      minimumKrakenVersion);

  @override
  String toString() {
    return 'DatabaseInitialisation(users: $users, healthcareParties: $healthcareParties, replication: $replication, minimumKrakenVersion: $minimumKrakenVersion)';
  }
}

/// @nodoc
abstract mixin class _$DatabaseInitialisationCopyWith<$Res>
    implements $DatabaseInitialisationCopyWith<$Res> {
  factory _$DatabaseInitialisationCopyWith(_DatabaseInitialisation value,
          $Res Function(_DatabaseInitialisation) _then) =
      __$DatabaseInitialisationCopyWithImpl;
  @override
  @useResult
  $Res call(
      {List<User>? users,
      List<HealthcareParty>? healthcareParties,
      Replication? replication,
      String? minimumKrakenVersion});

  @override
  $ReplicationCopyWith<$Res>? get replication;
}

/// @nodoc
class __$DatabaseInitialisationCopyWithImpl<$Res>
    implements _$DatabaseInitialisationCopyWith<$Res> {
  __$DatabaseInitialisationCopyWithImpl(this._self, this._then);

  final _DatabaseInitialisation _self;
  final $Res Function(_DatabaseInitialisation) _then;

  /// Create a copy of DatabaseInitialisation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? users = freezed,
    Object? healthcareParties = freezed,
    Object? replication = freezed,
    Object? minimumKrakenVersion = freezed,
  }) {
    return _then(_DatabaseInitialisation(
      users: freezed == users
          ? _self._users
          : users // ignore: cast_nullable_to_non_nullable
              as List<User>?,
      healthcareParties: freezed == healthcareParties
          ? _self._healthcareParties
          : healthcareParties // ignore: cast_nullable_to_non_nullable
              as List<HealthcareParty>?,
      replication: freezed == replication
          ? _self.replication
          : replication // ignore: cast_nullable_to_non_nullable
              as Replication?,
      minimumKrakenVersion: freezed == minimumKrakenVersion
          ? _self.minimumKrakenVersion
          : minimumKrakenVersion // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }

  /// Create a copy of DatabaseInitialisation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $ReplicationCopyWith<$Res>? get replication {
    if (_self.replication == null) {
      return null;
    }

    return $ReplicationCopyWith<$Res>(_self.replication!, (value) {
      return _then(_self.copyWith(replication: value));
    });
  }
}

// dart format on
