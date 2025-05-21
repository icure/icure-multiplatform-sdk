// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'front_end_migration.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$FrontEndMigration {
  String get id;
  String? get rev;
  int? get deletionDate;
  String? get name;
  int? get startDate;
  int? get endDate;
  FrontEndMigrationStatus? get status;
  String? get logs;
  String? get userId;
  String? get startKey;
  String? get startKeyDocId;
  int? get processCount;
  Set<DecryptedPropertyStub> get properties;

  /// Create a copy of FrontEndMigration
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $FrontEndMigrationCopyWith<FrontEndMigration> get copyWith =>
      _$FrontEndMigrationCopyWithImpl<FrontEndMigration>(
          this as FrontEndMigration, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is FrontEndMigration &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.endDate, endDate) || other.endDate == endDate) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.logs, logs) || other.logs == logs) &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.startKey, startKey) ||
                other.startKey == startKey) &&
            (identical(other.startKeyDocId, startKeyDocId) ||
                other.startKeyDocId == startKeyDocId) &&
            (identical(other.processCount, processCount) ||
                other.processCount == processCount) &&
            const DeepCollectionEquality()
                .equals(other.properties, properties));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      deletionDate,
      name,
      startDate,
      endDate,
      status,
      logs,
      userId,
      startKey,
      startKeyDocId,
      processCount,
      const DeepCollectionEquality().hash(properties));

  @override
  String toString() {
    return 'FrontEndMigration(id: $id, rev: $rev, deletionDate: $deletionDate, name: $name, startDate: $startDate, endDate: $endDate, status: $status, logs: $logs, userId: $userId, startKey: $startKey, startKeyDocId: $startKeyDocId, processCount: $processCount, properties: $properties)';
  }
}

/// @nodoc
abstract mixin class $FrontEndMigrationCopyWith<$Res> {
  factory $FrontEndMigrationCopyWith(
          FrontEndMigration value, $Res Function(FrontEndMigration) _then) =
      _$FrontEndMigrationCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      String? name,
      int? startDate,
      int? endDate,
      FrontEndMigrationStatus? status,
      String? logs,
      String? userId,
      String? startKey,
      String? startKeyDocId,
      int? processCount,
      Set<DecryptedPropertyStub> properties});
}

/// @nodoc
class _$FrontEndMigrationCopyWithImpl<$Res>
    implements $FrontEndMigrationCopyWith<$Res> {
  _$FrontEndMigrationCopyWithImpl(this._self, this._then);

  final FrontEndMigration _self;
  final $Res Function(FrontEndMigration) _then;

  /// Create a copy of FrontEndMigration
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? name = freezed,
    Object? startDate = freezed,
    Object? endDate = freezed,
    Object? status = freezed,
    Object? logs = freezed,
    Object? userId = freezed,
    Object? startKey = freezed,
    Object? startKeyDocId = freezed,
    Object? processCount = freezed,
    Object? properties = null,
  }) {
    return _then(_self.copyWith(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      startDate: freezed == startDate
          ? _self.startDate
          : startDate // ignore: cast_nullable_to_non_nullable
              as int?,
      endDate: freezed == endDate
          ? _self.endDate
          : endDate // ignore: cast_nullable_to_non_nullable
              as int?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as FrontEndMigrationStatus?,
      logs: freezed == logs
          ? _self.logs
          : logs // ignore: cast_nullable_to_non_nullable
              as String?,
      userId: freezed == userId
          ? _self.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String?,
      startKey: freezed == startKey
          ? _self.startKey
          : startKey // ignore: cast_nullable_to_non_nullable
              as String?,
      startKeyDocId: freezed == startKeyDocId
          ? _self.startKeyDocId
          : startKeyDocId // ignore: cast_nullable_to_non_nullable
              as String?,
      processCount: freezed == processCount
          ? _self.processCount
          : processCount // ignore: cast_nullable_to_non_nullable
              as int?,
      properties: null == properties
          ? _self.properties
          : properties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>,
    ));
  }
}

/// @nodoc

class _FrontEndMigration implements FrontEndMigration {
  const _FrontEndMigration(
      {required this.id,
      this.rev = null,
      this.deletionDate = null,
      this.name = null,
      this.startDate = null,
      this.endDate = null,
      this.status = null,
      this.logs = null,
      this.userId = null,
      this.startKey = null,
      this.startKeyDocId = null,
      this.processCount = null,
      final Set<DecryptedPropertyStub> properties = const {}})
      : _properties = properties;

  @override
  final String id;
  @override
  @JsonKey()
  final String? rev;
  @override
  @JsonKey()
  final int? deletionDate;
  @override
  @JsonKey()
  final String? name;
  @override
  @JsonKey()
  final int? startDate;
  @override
  @JsonKey()
  final int? endDate;
  @override
  @JsonKey()
  final FrontEndMigrationStatus? status;
  @override
  @JsonKey()
  final String? logs;
  @override
  @JsonKey()
  final String? userId;
  @override
  @JsonKey()
  final String? startKey;
  @override
  @JsonKey()
  final String? startKeyDocId;
  @override
  @JsonKey()
  final int? processCount;
  final Set<DecryptedPropertyStub> _properties;
  @override
  @JsonKey()
  Set<DecryptedPropertyStub> get properties {
    if (_properties is EqualUnmodifiableSetView) return _properties;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_properties);
  }

  /// Create a copy of FrontEndMigration
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$FrontEndMigrationCopyWith<_FrontEndMigration> get copyWith =>
      __$FrontEndMigrationCopyWithImpl<_FrontEndMigration>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _FrontEndMigration &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.endDate, endDate) || other.endDate == endDate) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.logs, logs) || other.logs == logs) &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.startKey, startKey) ||
                other.startKey == startKey) &&
            (identical(other.startKeyDocId, startKeyDocId) ||
                other.startKeyDocId == startKeyDocId) &&
            (identical(other.processCount, processCount) ||
                other.processCount == processCount) &&
            const DeepCollectionEquality()
                .equals(other._properties, _properties));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      deletionDate,
      name,
      startDate,
      endDate,
      status,
      logs,
      userId,
      startKey,
      startKeyDocId,
      processCount,
      const DeepCollectionEquality().hash(_properties));

  @override
  String toString() {
    return 'FrontEndMigration(id: $id, rev: $rev, deletionDate: $deletionDate, name: $name, startDate: $startDate, endDate: $endDate, status: $status, logs: $logs, userId: $userId, startKey: $startKey, startKeyDocId: $startKeyDocId, processCount: $processCount, properties: $properties)';
  }
}

/// @nodoc
abstract mixin class _$FrontEndMigrationCopyWith<$Res>
    implements $FrontEndMigrationCopyWith<$Res> {
  factory _$FrontEndMigrationCopyWith(
          _FrontEndMigration value, $Res Function(_FrontEndMigration) _then) =
      __$FrontEndMigrationCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      String? name,
      int? startDate,
      int? endDate,
      FrontEndMigrationStatus? status,
      String? logs,
      String? userId,
      String? startKey,
      String? startKeyDocId,
      int? processCount,
      Set<DecryptedPropertyStub> properties});
}

/// @nodoc
class __$FrontEndMigrationCopyWithImpl<$Res>
    implements _$FrontEndMigrationCopyWith<$Res> {
  __$FrontEndMigrationCopyWithImpl(this._self, this._then);

  final _FrontEndMigration _self;
  final $Res Function(_FrontEndMigration) _then;

  /// Create a copy of FrontEndMigration
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? name = freezed,
    Object? startDate = freezed,
    Object? endDate = freezed,
    Object? status = freezed,
    Object? logs = freezed,
    Object? userId = freezed,
    Object? startKey = freezed,
    Object? startKeyDocId = freezed,
    Object? processCount = freezed,
    Object? properties = null,
  }) {
    return _then(_FrontEndMigration(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      startDate: freezed == startDate
          ? _self.startDate
          : startDate // ignore: cast_nullable_to_non_nullable
              as int?,
      endDate: freezed == endDate
          ? _self.endDate
          : endDate // ignore: cast_nullable_to_non_nullable
              as int?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as FrontEndMigrationStatus?,
      logs: freezed == logs
          ? _self.logs
          : logs // ignore: cast_nullable_to_non_nullable
              as String?,
      userId: freezed == userId
          ? _self.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String?,
      startKey: freezed == startKey
          ? _self.startKey
          : startKey // ignore: cast_nullable_to_non_nullable
              as String?,
      startKeyDocId: freezed == startKeyDocId
          ? _self.startKeyDocId
          : startKeyDocId // ignore: cast_nullable_to_non_nullable
              as String?,
      processCount: freezed == processCount
          ? _self.processCount
          : processCount // ignore: cast_nullable_to_non_nullable
              as int?,
      properties: null == properties
          ? _self._properties
          : properties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>,
    ));
  }
}

// dart format on
