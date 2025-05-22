// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'administration_quantity.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$AdministrationQuantity {
  double? get quantity;
  CodeStub? get administrationUnit;
  String? get unit;

  /// Create a copy of AdministrationQuantity
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $AdministrationQuantityCopyWith<AdministrationQuantity> get copyWith =>
      _$AdministrationQuantityCopyWithImpl<AdministrationQuantity>(
          this as AdministrationQuantity, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is AdministrationQuantity &&
            (identical(other.quantity, quantity) ||
                other.quantity == quantity) &&
            (identical(other.administrationUnit, administrationUnit) ||
                other.administrationUnit == administrationUnit) &&
            (identical(other.unit, unit) || other.unit == unit));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, quantity, administrationUnit, unit);

  @override
  String toString() {
    return 'AdministrationQuantity(quantity: $quantity, administrationUnit: $administrationUnit, unit: $unit)';
  }
}

/// @nodoc
abstract mixin class $AdministrationQuantityCopyWith<$Res> {
  factory $AdministrationQuantityCopyWith(AdministrationQuantity value,
          $Res Function(AdministrationQuantity) _then) =
      _$AdministrationQuantityCopyWithImpl;
  @useResult
  $Res call({double? quantity, CodeStub? administrationUnit, String? unit});

  $CodeStubCopyWith<$Res>? get administrationUnit;
}

/// @nodoc
class _$AdministrationQuantityCopyWithImpl<$Res>
    implements $AdministrationQuantityCopyWith<$Res> {
  _$AdministrationQuantityCopyWithImpl(this._self, this._then);

  final AdministrationQuantity _self;
  final $Res Function(AdministrationQuantity) _then;

  /// Create a copy of AdministrationQuantity
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? quantity = freezed,
    Object? administrationUnit = freezed,
    Object? unit = freezed,
  }) {
    return _then(_self.copyWith(
      quantity: freezed == quantity
          ? _self.quantity
          : quantity // ignore: cast_nullable_to_non_nullable
              as double?,
      administrationUnit: freezed == administrationUnit
          ? _self.administrationUnit
          : administrationUnit // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      unit: freezed == unit
          ? _self.unit
          : unit // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }

  /// Create a copy of AdministrationQuantity
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get administrationUnit {
    if (_self.administrationUnit == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.administrationUnit!, (value) {
      return _then(_self.copyWith(administrationUnit: value));
    });
  }
}

/// @nodoc

class _AdministrationQuantity implements AdministrationQuantity {
  const _AdministrationQuantity(
      {this.quantity = null, this.administrationUnit = null, this.unit = null});

  @override
  @JsonKey()
  final double? quantity;
  @override
  @JsonKey()
  final CodeStub? administrationUnit;
  @override
  @JsonKey()
  final String? unit;

  /// Create a copy of AdministrationQuantity
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$AdministrationQuantityCopyWith<_AdministrationQuantity> get copyWith =>
      __$AdministrationQuantityCopyWithImpl<_AdministrationQuantity>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _AdministrationQuantity &&
            (identical(other.quantity, quantity) ||
                other.quantity == quantity) &&
            (identical(other.administrationUnit, administrationUnit) ||
                other.administrationUnit == administrationUnit) &&
            (identical(other.unit, unit) || other.unit == unit));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, quantity, administrationUnit, unit);

  @override
  String toString() {
    return 'AdministrationQuantity(quantity: $quantity, administrationUnit: $administrationUnit, unit: $unit)';
  }
}

/// @nodoc
abstract mixin class _$AdministrationQuantityCopyWith<$Res>
    implements $AdministrationQuantityCopyWith<$Res> {
  factory _$AdministrationQuantityCopyWith(_AdministrationQuantity value,
          $Res Function(_AdministrationQuantity) _then) =
      __$AdministrationQuantityCopyWithImpl;
  @override
  @useResult
  $Res call({double? quantity, CodeStub? administrationUnit, String? unit});

  @override
  $CodeStubCopyWith<$Res>? get administrationUnit;
}

/// @nodoc
class __$AdministrationQuantityCopyWithImpl<$Res>
    implements _$AdministrationQuantityCopyWith<$Res> {
  __$AdministrationQuantityCopyWithImpl(this._self, this._then);

  final _AdministrationQuantity _self;
  final $Res Function(_AdministrationQuantity) _then;

  /// Create a copy of AdministrationQuantity
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? quantity = freezed,
    Object? administrationUnit = freezed,
    Object? unit = freezed,
  }) {
    return _then(_AdministrationQuantity(
      quantity: freezed == quantity
          ? _self.quantity
          : quantity // ignore: cast_nullable_to_non_nullable
              as double?,
      administrationUnit: freezed == administrationUnit
          ? _self.administrationUnit
          : administrationUnit // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      unit: freezed == unit
          ? _self.unit
          : unit // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }

  /// Create a copy of AdministrationQuantity
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get administrationUnit {
    if (_self.administrationUnit == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.administrationUnit!, (value) {
      return _then(_self.copyWith(administrationUnit: value));
    });
  }
}

// dart format on
