// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'replication.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Replication {
  String get id;
  String? get rev;
  int? get deletionDate;
  String? get name;
  String? get context;
  List<DatabaseSynchronization> get databaseSynchronizations;

  /// Create a copy of Replication
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ReplicationCopyWith<Replication> get copyWith =>
      _$ReplicationCopyWithImpl<Replication>(this as Replication, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Replication &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.context, context) || other.context == context) &&
            const DeepCollectionEquality().equals(
                other.databaseSynchronizations, databaseSynchronizations));
  }

  @override
  int get hashCode => Object.hash(runtimeType, id, rev, deletionDate, name,
      context, const DeepCollectionEquality().hash(databaseSynchronizations));

  @override
  String toString() {
    return 'Replication(id: $id, rev: $rev, deletionDate: $deletionDate, name: $name, context: $context, databaseSynchronizations: $databaseSynchronizations)';
  }
}

/// @nodoc
abstract mixin class $ReplicationCopyWith<$Res> {
  factory $ReplicationCopyWith(
          Replication value, $Res Function(Replication) _then) =
      _$ReplicationCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      String? name,
      String? context,
      List<DatabaseSynchronization> databaseSynchronizations});
}

/// @nodoc
class _$ReplicationCopyWithImpl<$Res> implements $ReplicationCopyWith<$Res> {
  _$ReplicationCopyWithImpl(this._self, this._then);

  final Replication _self;
  final $Res Function(Replication) _then;

  /// Create a copy of Replication
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? name = freezed,
    Object? context = freezed,
    Object? databaseSynchronizations = null,
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
      context: freezed == context
          ? _self.context
          : context // ignore: cast_nullable_to_non_nullable
              as String?,
      databaseSynchronizations: null == databaseSynchronizations
          ? _self.databaseSynchronizations
          : databaseSynchronizations // ignore: cast_nullable_to_non_nullable
              as List<DatabaseSynchronization>,
    ));
  }
}

/// @nodoc

class _Replication implements Replication {
  const _Replication(
      {required this.id,
      this.rev = null,
      this.deletionDate = null,
      this.name = null,
      this.context = null,
      final List<DatabaseSynchronization> databaseSynchronizations = const []})
      : _databaseSynchronizations = databaseSynchronizations;

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
  final String? context;
  final List<DatabaseSynchronization> _databaseSynchronizations;
  @override
  @JsonKey()
  List<DatabaseSynchronization> get databaseSynchronizations {
    if (_databaseSynchronizations is EqualUnmodifiableListView)
      return _databaseSynchronizations;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_databaseSynchronizations);
  }

  /// Create a copy of Replication
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ReplicationCopyWith<_Replication> get copyWith =>
      __$ReplicationCopyWithImpl<_Replication>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Replication &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.context, context) || other.context == context) &&
            const DeepCollectionEquality().equals(
                other._databaseSynchronizations, _databaseSynchronizations));
  }

  @override
  int get hashCode => Object.hash(runtimeType, id, rev, deletionDate, name,
      context, const DeepCollectionEquality().hash(_databaseSynchronizations));

  @override
  String toString() {
    return 'Replication(id: $id, rev: $rev, deletionDate: $deletionDate, name: $name, context: $context, databaseSynchronizations: $databaseSynchronizations)';
  }
}

/// @nodoc
abstract mixin class _$ReplicationCopyWith<$Res>
    implements $ReplicationCopyWith<$Res> {
  factory _$ReplicationCopyWith(
          _Replication value, $Res Function(_Replication) _then) =
      __$ReplicationCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      String? name,
      String? context,
      List<DatabaseSynchronization> databaseSynchronizations});
}

/// @nodoc
class __$ReplicationCopyWithImpl<$Res> implements _$ReplicationCopyWith<$Res> {
  __$ReplicationCopyWithImpl(this._self, this._then);

  final _Replication _self;
  final $Res Function(_Replication) _then;

  /// Create a copy of Replication
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? name = freezed,
    Object? context = freezed,
    Object? databaseSynchronizations = null,
  }) {
    return _then(_Replication(
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
      context: freezed == context
          ? _self.context
          : context // ignore: cast_nullable_to_non_nullable
              as String?,
      databaseSynchronizations: null == databaseSynchronizations
          ? _self._databaseSynchronizations
          : databaseSynchronizations // ignore: cast_nullable_to_non_nullable
              as List<DatabaseSynchronization>,
    ));
  }
}

// dart format on
