// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'telecom.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EncryptedTelecom {
  TelecomType? get telecomType;
  String? get telecomNumber;
  String? get telecomDescription;
  Base64String? get encryptedSelf;

  /// Create a copy of EncryptedTelecom
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedTelecomCopyWith<EncryptedTelecom> get copyWith =>
      _$EncryptedTelecomCopyWithImpl<EncryptedTelecom>(
          this as EncryptedTelecom, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedTelecom &&
            (identical(other.telecomType, telecomType) ||
                other.telecomType == telecomType) &&
            (identical(other.telecomNumber, telecomNumber) ||
                other.telecomNumber == telecomNumber) &&
            (identical(other.telecomDescription, telecomDescription) ||
                other.telecomDescription == telecomDescription) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(runtimeType, telecomType, telecomNumber,
      telecomDescription, encryptedSelf);

  @override
  String toString() {
    return 'EncryptedTelecom(telecomType: $telecomType, telecomNumber: $telecomNumber, telecomDescription: $telecomDescription, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $EncryptedTelecomCopyWith<$Res> {
  factory $EncryptedTelecomCopyWith(
          EncryptedTelecom value, $Res Function(EncryptedTelecom) _then) =
      _$EncryptedTelecomCopyWithImpl;
  @useResult
  $Res call(
      {TelecomType? telecomType,
      String? telecomNumber,
      String? telecomDescription,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$EncryptedTelecomCopyWithImpl<$Res>
    implements $EncryptedTelecomCopyWith<$Res> {
  _$EncryptedTelecomCopyWithImpl(this._self, this._then);

  final EncryptedTelecom _self;
  final $Res Function(EncryptedTelecom) _then;

  /// Create a copy of EncryptedTelecom
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? telecomType = freezed,
    Object? telecomNumber = freezed,
    Object? telecomDescription = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      telecomType: freezed == telecomType
          ? _self.telecomType
          : telecomType // ignore: cast_nullable_to_non_nullable
              as TelecomType?,
      telecomNumber: freezed == telecomNumber
          ? _self.telecomNumber
          : telecomNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      telecomDescription: freezed == telecomDescription
          ? _self.telecomDescription
          : telecomDescription // ignore: cast_nullable_to_non_nullable
              as String?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _EncryptedTelecom implements EncryptedTelecom {
  const _EncryptedTelecom(
      {this.telecomType = null,
      this.telecomNumber = null,
      this.telecomDescription = null,
      this.encryptedSelf = null});

  @override
  @JsonKey()
  final TelecomType? telecomType;
  @override
  @JsonKey()
  final String? telecomNumber;
  @override
  @JsonKey()
  final String? telecomDescription;
  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of EncryptedTelecom
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedTelecomCopyWith<_EncryptedTelecom> get copyWith =>
      __$EncryptedTelecomCopyWithImpl<_EncryptedTelecom>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedTelecom &&
            (identical(other.telecomType, telecomType) ||
                other.telecomType == telecomType) &&
            (identical(other.telecomNumber, telecomNumber) ||
                other.telecomNumber == telecomNumber) &&
            (identical(other.telecomDescription, telecomDescription) ||
                other.telecomDescription == telecomDescription) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(runtimeType, telecomType, telecomNumber,
      telecomDescription, encryptedSelf);

  @override
  String toString() {
    return 'EncryptedTelecom(telecomType: $telecomType, telecomNumber: $telecomNumber, telecomDescription: $telecomDescription, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedTelecomCopyWith<$Res>
    implements $EncryptedTelecomCopyWith<$Res> {
  factory _$EncryptedTelecomCopyWith(
          _EncryptedTelecom value, $Res Function(_EncryptedTelecom) _then) =
      __$EncryptedTelecomCopyWithImpl;
  @override
  @useResult
  $Res call(
      {TelecomType? telecomType,
      String? telecomNumber,
      String? telecomDescription,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$EncryptedTelecomCopyWithImpl<$Res>
    implements _$EncryptedTelecomCopyWith<$Res> {
  __$EncryptedTelecomCopyWithImpl(this._self, this._then);

  final _EncryptedTelecom _self;
  final $Res Function(_EncryptedTelecom) _then;

  /// Create a copy of EncryptedTelecom
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? telecomType = freezed,
    Object? telecomNumber = freezed,
    Object? telecomDescription = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_EncryptedTelecom(
      telecomType: freezed == telecomType
          ? _self.telecomType
          : telecomType // ignore: cast_nullable_to_non_nullable
              as TelecomType?,
      telecomNumber: freezed == telecomNumber
          ? _self.telecomNumber
          : telecomNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      telecomDescription: freezed == telecomDescription
          ? _self.telecomDescription
          : telecomDescription // ignore: cast_nullable_to_non_nullable
              as String?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc
mixin _$DecryptedTelecom {
  TelecomType? get telecomType;
  String? get telecomNumber;
  String? get telecomDescription;
  Base64String? get encryptedSelf;

  /// Create a copy of DecryptedTelecom
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedTelecomCopyWith<DecryptedTelecom> get copyWith =>
      _$DecryptedTelecomCopyWithImpl<DecryptedTelecom>(
          this as DecryptedTelecom, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedTelecom &&
            (identical(other.telecomType, telecomType) ||
                other.telecomType == telecomType) &&
            (identical(other.telecomNumber, telecomNumber) ||
                other.telecomNumber == telecomNumber) &&
            (identical(other.telecomDescription, telecomDescription) ||
                other.telecomDescription == telecomDescription) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(runtimeType, telecomType, telecomNumber,
      telecomDescription, encryptedSelf);

  @override
  String toString() {
    return 'DecryptedTelecom(telecomType: $telecomType, telecomNumber: $telecomNumber, telecomDescription: $telecomDescription, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $DecryptedTelecomCopyWith<$Res> {
  factory $DecryptedTelecomCopyWith(
          DecryptedTelecom value, $Res Function(DecryptedTelecom) _then) =
      _$DecryptedTelecomCopyWithImpl;
  @useResult
  $Res call(
      {TelecomType? telecomType,
      String? telecomNumber,
      String? telecomDescription,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$DecryptedTelecomCopyWithImpl<$Res>
    implements $DecryptedTelecomCopyWith<$Res> {
  _$DecryptedTelecomCopyWithImpl(this._self, this._then);

  final DecryptedTelecom _self;
  final $Res Function(DecryptedTelecom) _then;

  /// Create a copy of DecryptedTelecom
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? telecomType = freezed,
    Object? telecomNumber = freezed,
    Object? telecomDescription = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      telecomType: freezed == telecomType
          ? _self.telecomType
          : telecomType // ignore: cast_nullable_to_non_nullable
              as TelecomType?,
      telecomNumber: freezed == telecomNumber
          ? _self.telecomNumber
          : telecomNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      telecomDescription: freezed == telecomDescription
          ? _self.telecomDescription
          : telecomDescription // ignore: cast_nullable_to_non_nullable
              as String?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _DecryptedTelecom implements DecryptedTelecom {
  const _DecryptedTelecom(
      {this.telecomType = null,
      this.telecomNumber = null,
      this.telecomDescription = null,
      this.encryptedSelf = null});

  @override
  @JsonKey()
  final TelecomType? telecomType;
  @override
  @JsonKey()
  final String? telecomNumber;
  @override
  @JsonKey()
  final String? telecomDescription;
  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of DecryptedTelecom
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedTelecomCopyWith<_DecryptedTelecom> get copyWith =>
      __$DecryptedTelecomCopyWithImpl<_DecryptedTelecom>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedTelecom &&
            (identical(other.telecomType, telecomType) ||
                other.telecomType == telecomType) &&
            (identical(other.telecomNumber, telecomNumber) ||
                other.telecomNumber == telecomNumber) &&
            (identical(other.telecomDescription, telecomDescription) ||
                other.telecomDescription == telecomDescription) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(runtimeType, telecomType, telecomNumber,
      telecomDescription, encryptedSelf);

  @override
  String toString() {
    return 'DecryptedTelecom(telecomType: $telecomType, telecomNumber: $telecomNumber, telecomDescription: $telecomDescription, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedTelecomCopyWith<$Res>
    implements $DecryptedTelecomCopyWith<$Res> {
  factory _$DecryptedTelecomCopyWith(
          _DecryptedTelecom value, $Res Function(_DecryptedTelecom) _then) =
      __$DecryptedTelecomCopyWithImpl;
  @override
  @useResult
  $Res call(
      {TelecomType? telecomType,
      String? telecomNumber,
      String? telecomDescription,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$DecryptedTelecomCopyWithImpl<$Res>
    implements _$DecryptedTelecomCopyWith<$Res> {
  __$DecryptedTelecomCopyWithImpl(this._self, this._then);

  final _DecryptedTelecom _self;
  final $Res Function(_DecryptedTelecom) _then;

  /// Create a copy of DecryptedTelecom
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? telecomType = freezed,
    Object? telecomNumber = freezed,
    Object? telecomDescription = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_DecryptedTelecom(
      telecomType: freezed == telecomType
          ? _self.telecomType
          : telecomType // ignore: cast_nullable_to_non_nullable
              as TelecomType?,
      telecomNumber: freezed == telecomNumber
          ? _self.telecomNumber
          : telecomNumber // ignore: cast_nullable_to_non_nullable
              as String?,
      telecomDescription: freezed == telecomDescription
          ? _self.telecomDescription
          : telecomDescription // ignore: cast_nullable_to_non_nullable
              as String?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

// dart format on
