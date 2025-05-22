// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'entity_access_information.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EntityAccessInformation {
  Map<EntityReferenceInGroup, AccessLevel> get permissionsByDataOwnerId;
  bool get hasUnknownAnonymousDataOwners;

  /// Create a copy of EntityAccessInformation
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EntityAccessInformationCopyWith<EntityAccessInformation> get copyWith =>
      _$EntityAccessInformationCopyWithImpl<EntityAccessInformation>(
          this as EntityAccessInformation, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EntityAccessInformation &&
            const DeepCollectionEquality().equals(
                other.permissionsByDataOwnerId, permissionsByDataOwnerId) &&
            (identical(other.hasUnknownAnonymousDataOwners,
                    hasUnknownAnonymousDataOwners) ||
                other.hasUnknownAnonymousDataOwners ==
                    hasUnknownAnonymousDataOwners));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(permissionsByDataOwnerId),
      hasUnknownAnonymousDataOwners);

  @override
  String toString() {
    return 'EntityAccessInformation(permissionsByDataOwnerId: $permissionsByDataOwnerId, hasUnknownAnonymousDataOwners: $hasUnknownAnonymousDataOwners)';
  }
}

/// @nodoc
abstract mixin class $EntityAccessInformationCopyWith<$Res> {
  factory $EntityAccessInformationCopyWith(EntityAccessInformation value,
          $Res Function(EntityAccessInformation) _then) =
      _$EntityAccessInformationCopyWithImpl;
  @useResult
  $Res call(
      {Map<EntityReferenceInGroup, AccessLevel> permissionsByDataOwnerId,
      bool hasUnknownAnonymousDataOwners});
}

/// @nodoc
class _$EntityAccessInformationCopyWithImpl<$Res>
    implements $EntityAccessInformationCopyWith<$Res> {
  _$EntityAccessInformationCopyWithImpl(this._self, this._then);

  final EntityAccessInformation _self;
  final $Res Function(EntityAccessInformation) _then;

  /// Create a copy of EntityAccessInformation
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? permissionsByDataOwnerId = null,
    Object? hasUnknownAnonymousDataOwners = null,
  }) {
    return _then(_self.copyWith(
      permissionsByDataOwnerId: null == permissionsByDataOwnerId
          ? _self.permissionsByDataOwnerId
          : permissionsByDataOwnerId // ignore: cast_nullable_to_non_nullable
              as Map<EntityReferenceInGroup, AccessLevel>,
      hasUnknownAnonymousDataOwners: null == hasUnknownAnonymousDataOwners
          ? _self.hasUnknownAnonymousDataOwners
          : hasUnknownAnonymousDataOwners // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }
}

/// @nodoc

class _EntityAccessInformation implements EntityAccessInformation {
  const _EntityAccessInformation(
      {required final Map<EntityReferenceInGroup, AccessLevel>
          permissionsByDataOwnerId,
      required this.hasUnknownAnonymousDataOwners})
      : _permissionsByDataOwnerId = permissionsByDataOwnerId;

  final Map<EntityReferenceInGroup, AccessLevel> _permissionsByDataOwnerId;
  @override
  Map<EntityReferenceInGroup, AccessLevel> get permissionsByDataOwnerId {
    if (_permissionsByDataOwnerId is EqualUnmodifiableMapView)
      return _permissionsByDataOwnerId;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_permissionsByDataOwnerId);
  }

  @override
  final bool hasUnknownAnonymousDataOwners;

  /// Create a copy of EntityAccessInformation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EntityAccessInformationCopyWith<_EntityAccessInformation> get copyWith =>
      __$EntityAccessInformationCopyWithImpl<_EntityAccessInformation>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EntityAccessInformation &&
            const DeepCollectionEquality().equals(
                other._permissionsByDataOwnerId, _permissionsByDataOwnerId) &&
            (identical(other.hasUnknownAnonymousDataOwners,
                    hasUnknownAnonymousDataOwners) ||
                other.hasUnknownAnonymousDataOwners ==
                    hasUnknownAnonymousDataOwners));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(_permissionsByDataOwnerId),
      hasUnknownAnonymousDataOwners);

  @override
  String toString() {
    return 'EntityAccessInformation(permissionsByDataOwnerId: $permissionsByDataOwnerId, hasUnknownAnonymousDataOwners: $hasUnknownAnonymousDataOwners)';
  }
}

/// @nodoc
abstract mixin class _$EntityAccessInformationCopyWith<$Res>
    implements $EntityAccessInformationCopyWith<$Res> {
  factory _$EntityAccessInformationCopyWith(_EntityAccessInformation value,
          $Res Function(_EntityAccessInformation) _then) =
      __$EntityAccessInformationCopyWithImpl;
  @override
  @useResult
  $Res call(
      {Map<EntityReferenceInGroup, AccessLevel> permissionsByDataOwnerId,
      bool hasUnknownAnonymousDataOwners});
}

/// @nodoc
class __$EntityAccessInformationCopyWithImpl<$Res>
    implements _$EntityAccessInformationCopyWith<$Res> {
  __$EntityAccessInformationCopyWithImpl(this._self, this._then);

  final _EntityAccessInformation _self;
  final $Res Function(_EntityAccessInformation) _then;

  /// Create a copy of EntityAccessInformation
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? permissionsByDataOwnerId = null,
    Object? hasUnknownAnonymousDataOwners = null,
  }) {
    return _then(_EntityAccessInformation(
      permissionsByDataOwnerId: null == permissionsByDataOwnerId
          ? _self._permissionsByDataOwnerId
          : permissionsByDataOwnerId // ignore: cast_nullable_to_non_nullable
              as Map<EntityReferenceInGroup, AccessLevel>,
      hasUnknownAnonymousDataOwners: null == hasUnknownAnonymousDataOwners
          ? _self.hasUnknownAnonymousDataOwners
          : hasUnknownAnonymousDataOwners // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }
}

// dart format on
