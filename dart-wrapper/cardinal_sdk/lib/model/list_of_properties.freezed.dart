// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'list_of_properties.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$ListOfProperties {
  Set<DecryptedPropertyStub> get properties;

  /// Create a copy of ListOfProperties
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ListOfPropertiesCopyWith<ListOfProperties> get copyWith =>
      _$ListOfPropertiesCopyWithImpl<ListOfProperties>(
          this as ListOfProperties, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ListOfProperties &&
            const DeepCollectionEquality()
                .equals(other.properties, properties));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, const DeepCollectionEquality().hash(properties));

  @override
  String toString() {
    return 'ListOfProperties(properties: $properties)';
  }
}

/// @nodoc
abstract mixin class $ListOfPropertiesCopyWith<$Res> {
  factory $ListOfPropertiesCopyWith(
          ListOfProperties value, $Res Function(ListOfProperties) _then) =
      _$ListOfPropertiesCopyWithImpl;
  @useResult
  $Res call({Set<DecryptedPropertyStub> properties});
}

/// @nodoc
class _$ListOfPropertiesCopyWithImpl<$Res>
    implements $ListOfPropertiesCopyWith<$Res> {
  _$ListOfPropertiesCopyWithImpl(this._self, this._then);

  final ListOfProperties _self;
  final $Res Function(ListOfProperties) _then;

  /// Create a copy of ListOfProperties
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? properties = null,
  }) {
    return _then(_self.copyWith(
      properties: null == properties
          ? _self.properties
          : properties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>,
    ));
  }
}

/// @nodoc

class _ListOfProperties implements ListOfProperties {
  const _ListOfProperties(
      {final Set<DecryptedPropertyStub> properties = const {}})
      : _properties = properties;

  final Set<DecryptedPropertyStub> _properties;
  @override
  @JsonKey()
  Set<DecryptedPropertyStub> get properties {
    if (_properties is EqualUnmodifiableSetView) return _properties;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_properties);
  }

  /// Create a copy of ListOfProperties
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ListOfPropertiesCopyWith<_ListOfProperties> get copyWith =>
      __$ListOfPropertiesCopyWithImpl<_ListOfProperties>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ListOfProperties &&
            const DeepCollectionEquality()
                .equals(other._properties, _properties));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, const DeepCollectionEquality().hash(_properties));

  @override
  String toString() {
    return 'ListOfProperties(properties: $properties)';
  }
}

/// @nodoc
abstract mixin class _$ListOfPropertiesCopyWith<$Res>
    implements $ListOfPropertiesCopyWith<$Res> {
  factory _$ListOfPropertiesCopyWith(
          _ListOfProperties value, $Res Function(_ListOfProperties) _then) =
      __$ListOfPropertiesCopyWithImpl;
  @override
  @useResult
  $Res call({Set<DecryptedPropertyStub> properties});
}

/// @nodoc
class __$ListOfPropertiesCopyWithImpl<$Res>
    implements _$ListOfPropertiesCopyWith<$Res> {
  __$ListOfPropertiesCopyWithImpl(this._self, this._then);

  final _ListOfProperties _self;
  final $Res Function(_ListOfProperties) _then;

  /// Create a copy of ListOfProperties
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? properties = null,
  }) {
    return _then(_ListOfProperties(
      properties: null == properties
          ? _self._properties
          : properties // ignore: cast_nullable_to_non_nullable
              as Set<DecryptedPropertyStub>,
    ));
  }
}

// dart format on
