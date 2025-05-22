// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'typed_value.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DecryptedTypedValue {
  TypedValuesType? get type;
  bool? get booleanValue;
  int? get integerValue;
  double? get doubleValue;
  String? get stringValue;
  DateTime? get dateValue;
  Base64String? get encryptedSelf;

  /// Create a copy of DecryptedTypedValue
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedTypedValueCopyWith<DecryptedTypedValue> get copyWith =>
      _$DecryptedTypedValueCopyWithImpl<DecryptedTypedValue>(
          this as DecryptedTypedValue, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedTypedValue &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.booleanValue, booleanValue) ||
                other.booleanValue == booleanValue) &&
            (identical(other.integerValue, integerValue) ||
                other.integerValue == integerValue) &&
            (identical(other.doubleValue, doubleValue) ||
                other.doubleValue == doubleValue) &&
            (identical(other.stringValue, stringValue) ||
                other.stringValue == stringValue) &&
            (identical(other.dateValue, dateValue) ||
                other.dateValue == dateValue) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(runtimeType, type, booleanValue, integerValue,
      doubleValue, stringValue, dateValue, encryptedSelf);

  @override
  String toString() {
    return 'DecryptedTypedValue(type: $type, booleanValue: $booleanValue, integerValue: $integerValue, doubleValue: $doubleValue, stringValue: $stringValue, dateValue: $dateValue, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $DecryptedTypedValueCopyWith<$Res> {
  factory $DecryptedTypedValueCopyWith(
          DecryptedTypedValue value, $Res Function(DecryptedTypedValue) _then) =
      _$DecryptedTypedValueCopyWithImpl;
  @useResult
  $Res call(
      {TypedValuesType? type,
      bool? booleanValue,
      int? integerValue,
      double? doubleValue,
      String? stringValue,
      DateTime? dateValue,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$DecryptedTypedValueCopyWithImpl<$Res>
    implements $DecryptedTypedValueCopyWith<$Res> {
  _$DecryptedTypedValueCopyWithImpl(this._self, this._then);

  final DecryptedTypedValue _self;
  final $Res Function(DecryptedTypedValue) _then;

  /// Create a copy of DecryptedTypedValue
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? type = freezed,
    Object? booleanValue = freezed,
    Object? integerValue = freezed,
    Object? doubleValue = freezed,
    Object? stringValue = freezed,
    Object? dateValue = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as TypedValuesType?,
      booleanValue: freezed == booleanValue
          ? _self.booleanValue
          : booleanValue // ignore: cast_nullable_to_non_nullable
              as bool?,
      integerValue: freezed == integerValue
          ? _self.integerValue
          : integerValue // ignore: cast_nullable_to_non_nullable
              as int?,
      doubleValue: freezed == doubleValue
          ? _self.doubleValue
          : doubleValue // ignore: cast_nullable_to_non_nullable
              as double?,
      stringValue: freezed == stringValue
          ? _self.stringValue
          : stringValue // ignore: cast_nullable_to_non_nullable
              as String?,
      dateValue: freezed == dateValue
          ? _self.dateValue
          : dateValue // ignore: cast_nullable_to_non_nullable
              as DateTime?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _DecryptedTypedValue implements DecryptedTypedValue {
  const _DecryptedTypedValue(
      {this.type = null,
      this.booleanValue = null,
      this.integerValue = null,
      this.doubleValue = null,
      this.stringValue = null,
      this.dateValue = null,
      this.encryptedSelf = null});

  @override
  @JsonKey()
  final TypedValuesType? type;
  @override
  @JsonKey()
  final bool? booleanValue;
  @override
  @JsonKey()
  final int? integerValue;
  @override
  @JsonKey()
  final double? doubleValue;
  @override
  @JsonKey()
  final String? stringValue;
  @override
  @JsonKey()
  final DateTime? dateValue;
  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of DecryptedTypedValue
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedTypedValueCopyWith<_DecryptedTypedValue> get copyWith =>
      __$DecryptedTypedValueCopyWithImpl<_DecryptedTypedValue>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedTypedValue &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.booleanValue, booleanValue) ||
                other.booleanValue == booleanValue) &&
            (identical(other.integerValue, integerValue) ||
                other.integerValue == integerValue) &&
            (identical(other.doubleValue, doubleValue) ||
                other.doubleValue == doubleValue) &&
            (identical(other.stringValue, stringValue) ||
                other.stringValue == stringValue) &&
            (identical(other.dateValue, dateValue) ||
                other.dateValue == dateValue) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(runtimeType, type, booleanValue, integerValue,
      doubleValue, stringValue, dateValue, encryptedSelf);

  @override
  String toString() {
    return 'DecryptedTypedValue(type: $type, booleanValue: $booleanValue, integerValue: $integerValue, doubleValue: $doubleValue, stringValue: $stringValue, dateValue: $dateValue, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedTypedValueCopyWith<$Res>
    implements $DecryptedTypedValueCopyWith<$Res> {
  factory _$DecryptedTypedValueCopyWith(_DecryptedTypedValue value,
          $Res Function(_DecryptedTypedValue) _then) =
      __$DecryptedTypedValueCopyWithImpl;
  @override
  @useResult
  $Res call(
      {TypedValuesType? type,
      bool? booleanValue,
      int? integerValue,
      double? doubleValue,
      String? stringValue,
      DateTime? dateValue,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$DecryptedTypedValueCopyWithImpl<$Res>
    implements _$DecryptedTypedValueCopyWith<$Res> {
  __$DecryptedTypedValueCopyWithImpl(this._self, this._then);

  final _DecryptedTypedValue _self;
  final $Res Function(_DecryptedTypedValue) _then;

  /// Create a copy of DecryptedTypedValue
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? type = freezed,
    Object? booleanValue = freezed,
    Object? integerValue = freezed,
    Object? doubleValue = freezed,
    Object? stringValue = freezed,
    Object? dateValue = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_DecryptedTypedValue(
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as TypedValuesType?,
      booleanValue: freezed == booleanValue
          ? _self.booleanValue
          : booleanValue // ignore: cast_nullable_to_non_nullable
              as bool?,
      integerValue: freezed == integerValue
          ? _self.integerValue
          : integerValue // ignore: cast_nullable_to_non_nullable
              as int?,
      doubleValue: freezed == doubleValue
          ? _self.doubleValue
          : doubleValue // ignore: cast_nullable_to_non_nullable
              as double?,
      stringValue: freezed == stringValue
          ? _self.stringValue
          : stringValue // ignore: cast_nullable_to_non_nullable
              as String?,
      dateValue: freezed == dateValue
          ? _self.dateValue
          : dateValue // ignore: cast_nullable_to_non_nullable
              as DateTime?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc
mixin _$EncryptedTypedValue {
  TypedValuesType? get type;
  bool? get booleanValue;
  int? get integerValue;
  double? get doubleValue;
  String? get stringValue;
  DateTime? get dateValue;
  Base64String? get encryptedSelf;

  /// Create a copy of EncryptedTypedValue
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedTypedValueCopyWith<EncryptedTypedValue> get copyWith =>
      _$EncryptedTypedValueCopyWithImpl<EncryptedTypedValue>(
          this as EncryptedTypedValue, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedTypedValue &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.booleanValue, booleanValue) ||
                other.booleanValue == booleanValue) &&
            (identical(other.integerValue, integerValue) ||
                other.integerValue == integerValue) &&
            (identical(other.doubleValue, doubleValue) ||
                other.doubleValue == doubleValue) &&
            (identical(other.stringValue, stringValue) ||
                other.stringValue == stringValue) &&
            (identical(other.dateValue, dateValue) ||
                other.dateValue == dateValue) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(runtimeType, type, booleanValue, integerValue,
      doubleValue, stringValue, dateValue, encryptedSelf);

  @override
  String toString() {
    return 'EncryptedTypedValue(type: $type, booleanValue: $booleanValue, integerValue: $integerValue, doubleValue: $doubleValue, stringValue: $stringValue, dateValue: $dateValue, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $EncryptedTypedValueCopyWith<$Res> {
  factory $EncryptedTypedValueCopyWith(
          EncryptedTypedValue value, $Res Function(EncryptedTypedValue) _then) =
      _$EncryptedTypedValueCopyWithImpl;
  @useResult
  $Res call(
      {TypedValuesType? type,
      bool? booleanValue,
      int? integerValue,
      double? doubleValue,
      String? stringValue,
      DateTime? dateValue,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$EncryptedTypedValueCopyWithImpl<$Res>
    implements $EncryptedTypedValueCopyWith<$Res> {
  _$EncryptedTypedValueCopyWithImpl(this._self, this._then);

  final EncryptedTypedValue _self;
  final $Res Function(EncryptedTypedValue) _then;

  /// Create a copy of EncryptedTypedValue
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? type = freezed,
    Object? booleanValue = freezed,
    Object? integerValue = freezed,
    Object? doubleValue = freezed,
    Object? stringValue = freezed,
    Object? dateValue = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as TypedValuesType?,
      booleanValue: freezed == booleanValue
          ? _self.booleanValue
          : booleanValue // ignore: cast_nullable_to_non_nullable
              as bool?,
      integerValue: freezed == integerValue
          ? _self.integerValue
          : integerValue // ignore: cast_nullable_to_non_nullable
              as int?,
      doubleValue: freezed == doubleValue
          ? _self.doubleValue
          : doubleValue // ignore: cast_nullable_to_non_nullable
              as double?,
      stringValue: freezed == stringValue
          ? _self.stringValue
          : stringValue // ignore: cast_nullable_to_non_nullable
              as String?,
      dateValue: freezed == dateValue
          ? _self.dateValue
          : dateValue // ignore: cast_nullable_to_non_nullable
              as DateTime?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _EncryptedTypedValue implements EncryptedTypedValue {
  const _EncryptedTypedValue(
      {this.type = null,
      this.booleanValue = null,
      this.integerValue = null,
      this.doubleValue = null,
      this.stringValue = null,
      this.dateValue = null,
      this.encryptedSelf = null});

  @override
  @JsonKey()
  final TypedValuesType? type;
  @override
  @JsonKey()
  final bool? booleanValue;
  @override
  @JsonKey()
  final int? integerValue;
  @override
  @JsonKey()
  final double? doubleValue;
  @override
  @JsonKey()
  final String? stringValue;
  @override
  @JsonKey()
  final DateTime? dateValue;
  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of EncryptedTypedValue
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedTypedValueCopyWith<_EncryptedTypedValue> get copyWith =>
      __$EncryptedTypedValueCopyWithImpl<_EncryptedTypedValue>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedTypedValue &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.booleanValue, booleanValue) ||
                other.booleanValue == booleanValue) &&
            (identical(other.integerValue, integerValue) ||
                other.integerValue == integerValue) &&
            (identical(other.doubleValue, doubleValue) ||
                other.doubleValue == doubleValue) &&
            (identical(other.stringValue, stringValue) ||
                other.stringValue == stringValue) &&
            (identical(other.dateValue, dateValue) ||
                other.dateValue == dateValue) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(runtimeType, type, booleanValue, integerValue,
      doubleValue, stringValue, dateValue, encryptedSelf);

  @override
  String toString() {
    return 'EncryptedTypedValue(type: $type, booleanValue: $booleanValue, integerValue: $integerValue, doubleValue: $doubleValue, stringValue: $stringValue, dateValue: $dateValue, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedTypedValueCopyWith<$Res>
    implements $EncryptedTypedValueCopyWith<$Res> {
  factory _$EncryptedTypedValueCopyWith(_EncryptedTypedValue value,
          $Res Function(_EncryptedTypedValue) _then) =
      __$EncryptedTypedValueCopyWithImpl;
  @override
  @useResult
  $Res call(
      {TypedValuesType? type,
      bool? booleanValue,
      int? integerValue,
      double? doubleValue,
      String? stringValue,
      DateTime? dateValue,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$EncryptedTypedValueCopyWithImpl<$Res>
    implements _$EncryptedTypedValueCopyWith<$Res> {
  __$EncryptedTypedValueCopyWithImpl(this._self, this._then);

  final _EncryptedTypedValue _self;
  final $Res Function(_EncryptedTypedValue) _then;

  /// Create a copy of EncryptedTypedValue
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? type = freezed,
    Object? booleanValue = freezed,
    Object? integerValue = freezed,
    Object? doubleValue = freezed,
    Object? stringValue = freezed,
    Object? dateValue = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_EncryptedTypedValue(
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as TypedValuesType?,
      booleanValue: freezed == booleanValue
          ? _self.booleanValue
          : booleanValue // ignore: cast_nullable_to_non_nullable
              as bool?,
      integerValue: freezed == integerValue
          ? _self.integerValue
          : integerValue // ignore: cast_nullable_to_non_nullable
              as int?,
      doubleValue: freezed == doubleValue
          ? _self.doubleValue
          : doubleValue // ignore: cast_nullable_to_non_nullable
              as double?,
      stringValue: freezed == stringValue
          ? _self.stringValue
          : stringValue // ignore: cast_nullable_to_non_nullable
              as String?,
      dateValue: freezed == dateValue
          ? _self.dateValue
          : dateValue // ignore: cast_nullable_to_non_nullable
              as DateTime?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

// dart format on
