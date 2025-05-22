// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'identifier_selector.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$IdentifierSelector {
  String get assigner;
  String get valueField;

  /// Create a copy of IdentifierSelector
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $IdentifierSelectorCopyWith<IdentifierSelector> get copyWith =>
      _$IdentifierSelectorCopyWithImpl<IdentifierSelector>(
          this as IdentifierSelector, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is IdentifierSelector &&
            (identical(other.assigner, assigner) ||
                other.assigner == assigner) &&
            (identical(other.valueField, valueField) ||
                other.valueField == valueField));
  }

  @override
  int get hashCode => Object.hash(runtimeType, assigner, valueField);

  @override
  String toString() {
    return 'IdentifierSelector(assigner: $assigner, valueField: $valueField)';
  }
}

/// @nodoc
abstract mixin class $IdentifierSelectorCopyWith<$Res> {
  factory $IdentifierSelectorCopyWith(
          IdentifierSelector value, $Res Function(IdentifierSelector) _then) =
      _$IdentifierSelectorCopyWithImpl;
  @useResult
  $Res call({String assigner, String valueField});
}

/// @nodoc
class _$IdentifierSelectorCopyWithImpl<$Res>
    implements $IdentifierSelectorCopyWith<$Res> {
  _$IdentifierSelectorCopyWithImpl(this._self, this._then);

  final IdentifierSelector _self;
  final $Res Function(IdentifierSelector) _then;

  /// Create a copy of IdentifierSelector
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? assigner = null,
    Object? valueField = null,
  }) {
    return _then(_self.copyWith(
      assigner: null == assigner
          ? _self.assigner
          : assigner // ignore: cast_nullable_to_non_nullable
              as String,
      valueField: null == valueField
          ? _self.valueField
          : valueField // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc

class _IdentifierSelector implements IdentifierSelector {
  const _IdentifierSelector({required this.assigner, required this.valueField});

  @override
  final String assigner;
  @override
  final String valueField;

  /// Create a copy of IdentifierSelector
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$IdentifierSelectorCopyWith<_IdentifierSelector> get copyWith =>
      __$IdentifierSelectorCopyWithImpl<_IdentifierSelector>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _IdentifierSelector &&
            (identical(other.assigner, assigner) ||
                other.assigner == assigner) &&
            (identical(other.valueField, valueField) ||
                other.valueField == valueField));
  }

  @override
  int get hashCode => Object.hash(runtimeType, assigner, valueField);

  @override
  String toString() {
    return 'IdentifierSelector(assigner: $assigner, valueField: $valueField)';
  }
}

/// @nodoc
abstract mixin class _$IdentifierSelectorCopyWith<$Res>
    implements $IdentifierSelectorCopyWith<$Res> {
  factory _$IdentifierSelectorCopyWith(
          _IdentifierSelector value, $Res Function(_IdentifierSelector) _then) =
      __$IdentifierSelectorCopyWithImpl;
  @override
  @useResult
  $Res call({String assigner, String valueField});
}

/// @nodoc
class __$IdentifierSelectorCopyWithImpl<$Res>
    implements _$IdentifierSelectorCopyWith<$Res> {
  __$IdentifierSelectorCopyWithImpl(this._self, this._then);

  final _IdentifierSelector _self;
  final $Res Function(_IdentifierSelector) _then;

  /// Create a copy of IdentifierSelector
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? assigner = null,
    Object? valueField = null,
  }) {
    return _then(_IdentifierSelector(
      assigner: null == assigner
          ? _self.assigner
          : assigner // ignore: cast_nullable_to_non_nullable
              as String,
      valueField: null == valueField
          ? _self.valueField
          : valueField // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

// dart format on
