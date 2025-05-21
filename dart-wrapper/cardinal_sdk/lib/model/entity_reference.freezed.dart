// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'entity_reference.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EntityReference {
  String get id;
  String? get rev;
  int? get deletionDate;
  String? get docId;

  /// Create a copy of EntityReference
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EntityReferenceCopyWith<EntityReference> get copyWith =>
      _$EntityReferenceCopyWithImpl<EntityReference>(
          this as EntityReference, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EntityReference &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.docId, docId) || other.docId == docId));
  }

  @override
  int get hashCode => Object.hash(runtimeType, id, rev, deletionDate, docId);

  @override
  String toString() {
    return 'EntityReference(id: $id, rev: $rev, deletionDate: $deletionDate, docId: $docId)';
  }
}

/// @nodoc
abstract mixin class $EntityReferenceCopyWith<$Res> {
  factory $EntityReferenceCopyWith(
          EntityReference value, $Res Function(EntityReference) _then) =
      _$EntityReferenceCopyWithImpl;
  @useResult
  $Res call({String id, String? rev, int? deletionDate, String? docId});
}

/// @nodoc
class _$EntityReferenceCopyWithImpl<$Res>
    implements $EntityReferenceCopyWith<$Res> {
  _$EntityReferenceCopyWithImpl(this._self, this._then);

  final EntityReference _self;
  final $Res Function(EntityReference) _then;

  /// Create a copy of EntityReference
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? docId = freezed,
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
      docId: freezed == docId
          ? _self.docId
          : docId // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _EntityReference implements EntityReference {
  const _EntityReference(
      {required this.id,
      this.rev = null,
      this.deletionDate = null,
      this.docId = null});

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
  final String? docId;

  /// Create a copy of EntityReference
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EntityReferenceCopyWith<_EntityReference> get copyWith =>
      __$EntityReferenceCopyWithImpl<_EntityReference>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EntityReference &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.docId, docId) || other.docId == docId));
  }

  @override
  int get hashCode => Object.hash(runtimeType, id, rev, deletionDate, docId);

  @override
  String toString() {
    return 'EntityReference(id: $id, rev: $rev, deletionDate: $deletionDate, docId: $docId)';
  }
}

/// @nodoc
abstract mixin class _$EntityReferenceCopyWith<$Res>
    implements $EntityReferenceCopyWith<$Res> {
  factory _$EntityReferenceCopyWith(
          _EntityReference value, $Res Function(_EntityReference) _then) =
      __$EntityReferenceCopyWithImpl;
  @override
  @useResult
  $Res call({String id, String? rev, int? deletionDate, String? docId});
}

/// @nodoc
class __$EntityReferenceCopyWithImpl<$Res>
    implements _$EntityReferenceCopyWith<$Res> {
  __$EntityReferenceCopyWithImpl(this._self, this._then);

  final _EntityReference _self;
  final $Res Function(_EntityReference) _then;

  /// Create a copy of EntityReference
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? docId = freezed,
  }) {
    return _then(_EntityReference(
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
      docId: freezed == docId
          ? _self.docId
          : docId // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

// dart format on
