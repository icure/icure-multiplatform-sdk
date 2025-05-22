// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'property_type_stub.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$PropertyTypeStub {
  String? get identifier;
  TypedValuesType? get type;

  /// Create a copy of PropertyTypeStub
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $PropertyTypeStubCopyWith<PropertyTypeStub> get copyWith =>
      _$PropertyTypeStubCopyWithImpl<PropertyTypeStub>(
          this as PropertyTypeStub, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is PropertyTypeStub &&
            (identical(other.identifier, identifier) ||
                other.identifier == identifier) &&
            (identical(other.type, type) || other.type == type));
  }

  @override
  int get hashCode => Object.hash(runtimeType, identifier, type);

  @override
  String toString() {
    return 'PropertyTypeStub(identifier: $identifier, type: $type)';
  }
}

/// @nodoc
abstract mixin class $PropertyTypeStubCopyWith<$Res> {
  factory $PropertyTypeStubCopyWith(
          PropertyTypeStub value, $Res Function(PropertyTypeStub) _then) =
      _$PropertyTypeStubCopyWithImpl;
  @useResult
  $Res call({String? identifier, TypedValuesType? type});
}

/// @nodoc
class _$PropertyTypeStubCopyWithImpl<$Res>
    implements $PropertyTypeStubCopyWith<$Res> {
  _$PropertyTypeStubCopyWithImpl(this._self, this._then);

  final PropertyTypeStub _self;
  final $Res Function(PropertyTypeStub) _then;

  /// Create a copy of PropertyTypeStub
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? identifier = freezed,
    Object? type = freezed,
  }) {
    return _then(_self.copyWith(
      identifier: freezed == identifier
          ? _self.identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as String?,
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as TypedValuesType?,
    ));
  }
}

/// @nodoc

class _PropertyTypeStub implements PropertyTypeStub {
  const _PropertyTypeStub({this.identifier = null, this.type = null});

  @override
  @JsonKey()
  final String? identifier;
  @override
  @JsonKey()
  final TypedValuesType? type;

  /// Create a copy of PropertyTypeStub
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$PropertyTypeStubCopyWith<_PropertyTypeStub> get copyWith =>
      __$PropertyTypeStubCopyWithImpl<_PropertyTypeStub>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _PropertyTypeStub &&
            (identical(other.identifier, identifier) ||
                other.identifier == identifier) &&
            (identical(other.type, type) || other.type == type));
  }

  @override
  int get hashCode => Object.hash(runtimeType, identifier, type);

  @override
  String toString() {
    return 'PropertyTypeStub(identifier: $identifier, type: $type)';
  }
}

/// @nodoc
abstract mixin class _$PropertyTypeStubCopyWith<$Res>
    implements $PropertyTypeStubCopyWith<$Res> {
  factory _$PropertyTypeStubCopyWith(
          _PropertyTypeStub value, $Res Function(_PropertyTypeStub) _then) =
      __$PropertyTypeStubCopyWithImpl;
  @override
  @useResult
  $Res call({String? identifier, TypedValuesType? type});
}

/// @nodoc
class __$PropertyTypeStubCopyWithImpl<$Res>
    implements _$PropertyTypeStubCopyWith<$Res> {
  __$PropertyTypeStubCopyWithImpl(this._self, this._then);

  final _PropertyTypeStub _self;
  final $Res Function(_PropertyTypeStub) _then;

  /// Create a copy of PropertyTypeStub
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? identifier = freezed,
    Object? type = freezed,
  }) {
    return _then(_PropertyTypeStub(
      identifier: freezed == identifier
          ? _self.identifier
          : identifier // ignore: cast_nullable_to_non_nullable
              as String?,
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as TypedValuesType?,
    ));
  }
}

// dart format on
