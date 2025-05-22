// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'entity_reference_in_group.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EntityReferenceInGroup {
  String get entityId;
  String? get groupId;

  /// Create a copy of EntityReferenceInGroup
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EntityReferenceInGroupCopyWith<EntityReferenceInGroup> get copyWith =>
      _$EntityReferenceInGroupCopyWithImpl<EntityReferenceInGroup>(
          this as EntityReferenceInGroup, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EntityReferenceInGroup &&
            (identical(other.entityId, entityId) ||
                other.entityId == entityId) &&
            (identical(other.groupId, groupId) || other.groupId == groupId));
  }

  @override
  int get hashCode => Object.hash(runtimeType, entityId, groupId);

  @override
  String toString() {
    return 'EntityReferenceInGroup(entityId: $entityId, groupId: $groupId)';
  }
}

/// @nodoc
abstract mixin class $EntityReferenceInGroupCopyWith<$Res> {
  factory $EntityReferenceInGroupCopyWith(EntityReferenceInGroup value,
          $Res Function(EntityReferenceInGroup) _then) =
      _$EntityReferenceInGroupCopyWithImpl;
  @useResult
  $Res call({String entityId, String? groupId});
}

/// @nodoc
class _$EntityReferenceInGroupCopyWithImpl<$Res>
    implements $EntityReferenceInGroupCopyWith<$Res> {
  _$EntityReferenceInGroupCopyWithImpl(this._self, this._then);

  final EntityReferenceInGroup _self;
  final $Res Function(EntityReferenceInGroup) _then;

  /// Create a copy of EntityReferenceInGroup
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? entityId = null,
    Object? groupId = freezed,
  }) {
    return _then(_self.copyWith(
      entityId: null == entityId
          ? _self.entityId
          : entityId // ignore: cast_nullable_to_non_nullable
              as String,
      groupId: freezed == groupId
          ? _self.groupId
          : groupId // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _EntityReferenceInGroup implements EntityReferenceInGroup {
  const _EntityReferenceInGroup({required this.entityId, this.groupId = null});

  @override
  final String entityId;
  @override
  @JsonKey()
  final String? groupId;

  /// Create a copy of EntityReferenceInGroup
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EntityReferenceInGroupCopyWith<_EntityReferenceInGroup> get copyWith =>
      __$EntityReferenceInGroupCopyWithImpl<_EntityReferenceInGroup>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EntityReferenceInGroup &&
            (identical(other.entityId, entityId) ||
                other.entityId == entityId) &&
            (identical(other.groupId, groupId) || other.groupId == groupId));
  }

  @override
  int get hashCode => Object.hash(runtimeType, entityId, groupId);

  @override
  String toString() {
    return 'EntityReferenceInGroup(entityId: $entityId, groupId: $groupId)';
  }
}

/// @nodoc
abstract mixin class _$EntityReferenceInGroupCopyWith<$Res>
    implements $EntityReferenceInGroupCopyWith<$Res> {
  factory _$EntityReferenceInGroupCopyWith(_EntityReferenceInGroup value,
          $Res Function(_EntityReferenceInGroup) _then) =
      __$EntityReferenceInGroupCopyWithImpl;
  @override
  @useResult
  $Res call({String entityId, String? groupId});
}

/// @nodoc
class __$EntityReferenceInGroupCopyWithImpl<$Res>
    implements _$EntityReferenceInGroupCopyWith<$Res> {
  __$EntityReferenceInGroupCopyWithImpl(this._self, this._then);

  final _EntityReferenceInGroup _self;
  final $Res Function(_EntityReferenceInGroup) _then;

  /// Create a copy of EntityReferenceInGroup
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? entityId = null,
    Object? groupId = freezed,
  }) {
    return _then(_EntityReferenceInGroup(
      entityId: null == entityId
          ? _self.entityId
          : entityId // ignore: cast_nullable_to_non_nullable
              as String,
      groupId: freezed == groupId
          ? _self.groupId
          : groupId // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

// dart format on
