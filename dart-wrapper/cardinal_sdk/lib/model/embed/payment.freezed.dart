// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'payment.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Payment {
  int get paymentDate;
  PaymentType? get paymentType;
  double? get paid;

  /// Create a copy of Payment
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $PaymentCopyWith<Payment> get copyWith =>
      _$PaymentCopyWithImpl<Payment>(this as Payment, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Payment &&
            (identical(other.paymentDate, paymentDate) ||
                other.paymentDate == paymentDate) &&
            (identical(other.paymentType, paymentType) ||
                other.paymentType == paymentType) &&
            (identical(other.paid, paid) || other.paid == paid));
  }

  @override
  int get hashCode => Object.hash(runtimeType, paymentDate, paymentType, paid);

  @override
  String toString() {
    return 'Payment(paymentDate: $paymentDate, paymentType: $paymentType, paid: $paid)';
  }
}

/// @nodoc
abstract mixin class $PaymentCopyWith<$Res> {
  factory $PaymentCopyWith(Payment value, $Res Function(Payment) _then) =
      _$PaymentCopyWithImpl;
  @useResult
  $Res call({int paymentDate, PaymentType? paymentType, double? paid});
}

/// @nodoc
class _$PaymentCopyWithImpl<$Res> implements $PaymentCopyWith<$Res> {
  _$PaymentCopyWithImpl(this._self, this._then);

  final Payment _self;
  final $Res Function(Payment) _then;

  /// Create a copy of Payment
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? paymentDate = null,
    Object? paymentType = freezed,
    Object? paid = freezed,
  }) {
    return _then(_self.copyWith(
      paymentDate: null == paymentDate
          ? _self.paymentDate
          : paymentDate // ignore: cast_nullable_to_non_nullable
              as int,
      paymentType: freezed == paymentType
          ? _self.paymentType
          : paymentType // ignore: cast_nullable_to_non_nullable
              as PaymentType?,
      paid: freezed == paid
          ? _self.paid
          : paid // ignore: cast_nullable_to_non_nullable
              as double?,
    ));
  }
}

/// @nodoc

class _Payment implements Payment {
  const _Payment(
      {this.paymentDate = 0, this.paymentType = null, this.paid = null});

  @override
  @JsonKey()
  final int paymentDate;
  @override
  @JsonKey()
  final PaymentType? paymentType;
  @override
  @JsonKey()
  final double? paid;

  /// Create a copy of Payment
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$PaymentCopyWith<_Payment> get copyWith =>
      __$PaymentCopyWithImpl<_Payment>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Payment &&
            (identical(other.paymentDate, paymentDate) ||
                other.paymentDate == paymentDate) &&
            (identical(other.paymentType, paymentType) ||
                other.paymentType == paymentType) &&
            (identical(other.paid, paid) || other.paid == paid));
  }

  @override
  int get hashCode => Object.hash(runtimeType, paymentDate, paymentType, paid);

  @override
  String toString() {
    return 'Payment(paymentDate: $paymentDate, paymentType: $paymentType, paid: $paid)';
  }
}

/// @nodoc
abstract mixin class _$PaymentCopyWith<$Res> implements $PaymentCopyWith<$Res> {
  factory _$PaymentCopyWith(_Payment value, $Res Function(_Payment) _then) =
      __$PaymentCopyWithImpl;
  @override
  @useResult
  $Res call({int paymentDate, PaymentType? paymentType, double? paid});
}

/// @nodoc
class __$PaymentCopyWithImpl<$Res> implements _$PaymentCopyWith<$Res> {
  __$PaymentCopyWithImpl(this._self, this._then);

  final _Payment _self;
  final $Res Function(_Payment) _then;

  /// Create a copy of Payment
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? paymentDate = null,
    Object? paymentType = freezed,
    Object? paid = freezed,
  }) {
    return _then(_Payment(
      paymentDate: null == paymentDate
          ? _self.paymentDate
          : paymentDate // ignore: cast_nullable_to_non_nullable
              as int,
      paymentType: freezed == paymentType
          ? _self.paymentType
          : paymentType // ignore: cast_nullable_to_non_nullable
              as PaymentType?,
      paid: freezed == paid
          ? _self.paid
          : paid // ignore: cast_nullable_to_non_nullable
              as double?,
    ));
  }
}

// dart format on
