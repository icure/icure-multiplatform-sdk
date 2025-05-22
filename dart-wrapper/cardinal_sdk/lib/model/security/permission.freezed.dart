// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'permission.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Permission {
  Set<PermissionItem> get grants;
  Set<PermissionItem> get revokes;

  /// Create a copy of Permission
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $PermissionCopyWith<Permission> get copyWith =>
      _$PermissionCopyWithImpl<Permission>(this as Permission, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Permission &&
            const DeepCollectionEquality().equals(other.grants, grants) &&
            const DeepCollectionEquality().equals(other.revokes, revokes));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(grants),
      const DeepCollectionEquality().hash(revokes));

  @override
  String toString() {
    return 'Permission(grants: $grants, revokes: $revokes)';
  }
}

/// @nodoc
abstract mixin class $PermissionCopyWith<$Res> {
  factory $PermissionCopyWith(
          Permission value, $Res Function(Permission) _then) =
      _$PermissionCopyWithImpl;
  @useResult
  $Res call({Set<PermissionItem> grants, Set<PermissionItem> revokes});
}

/// @nodoc
class _$PermissionCopyWithImpl<$Res> implements $PermissionCopyWith<$Res> {
  _$PermissionCopyWithImpl(this._self, this._then);

  final Permission _self;
  final $Res Function(Permission) _then;

  /// Create a copy of Permission
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? grants = null,
    Object? revokes = null,
  }) {
    return _then(_self.copyWith(
      grants: null == grants
          ? _self.grants
          : grants // ignore: cast_nullable_to_non_nullable
              as Set<PermissionItem>,
      revokes: null == revokes
          ? _self.revokes
          : revokes // ignore: cast_nullable_to_non_nullable
              as Set<PermissionItem>,
    ));
  }
}

/// @nodoc

class _Permission implements Permission {
  const _Permission(
      {final Set<PermissionItem> grants = const {},
      final Set<PermissionItem> revokes = const {}})
      : _grants = grants,
        _revokes = revokes;

  final Set<PermissionItem> _grants;
  @override
  @JsonKey()
  Set<PermissionItem> get grants {
    if (_grants is EqualUnmodifiableSetView) return _grants;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_grants);
  }

  final Set<PermissionItem> _revokes;
  @override
  @JsonKey()
  Set<PermissionItem> get revokes {
    if (_revokes is EqualUnmodifiableSetView) return _revokes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_revokes);
  }

  /// Create a copy of Permission
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$PermissionCopyWith<_Permission> get copyWith =>
      __$PermissionCopyWithImpl<_Permission>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Permission &&
            const DeepCollectionEquality().equals(other._grants, _grants) &&
            const DeepCollectionEquality().equals(other._revokes, _revokes));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      const DeepCollectionEquality().hash(_grants),
      const DeepCollectionEquality().hash(_revokes));

  @override
  String toString() {
    return 'Permission(grants: $grants, revokes: $revokes)';
  }
}

/// @nodoc
abstract mixin class _$PermissionCopyWith<$Res>
    implements $PermissionCopyWith<$Res> {
  factory _$PermissionCopyWith(
          _Permission value, $Res Function(_Permission) _then) =
      __$PermissionCopyWithImpl;
  @override
  @useResult
  $Res call({Set<PermissionItem> grants, Set<PermissionItem> revokes});
}

/// @nodoc
class __$PermissionCopyWithImpl<$Res> implements _$PermissionCopyWith<$Res> {
  __$PermissionCopyWithImpl(this._self, this._then);

  final _Permission _self;
  final $Res Function(_Permission) _then;

  /// Create a copy of Permission
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? grants = null,
    Object? revokes = null,
  }) {
    return _then(_Permission(
      grants: null == grants
          ? _self._grants
          : grants // ignore: cast_nullable_to_non_nullable
              as Set<PermissionItem>,
      revokes: null == revokes
          ? _self._revokes
          : revokes // ignore: cast_nullable_to_non_nullable
              as Set<PermissionItem>,
    ));
  }
}

// dart format on
