// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'referral_period.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$ReferralPeriod {
  DateTime? get startDate;
  DateTime? get endDate;
  String? get comment;

  /// Create a copy of ReferralPeriod
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ReferralPeriodCopyWith<ReferralPeriod> get copyWith =>
      _$ReferralPeriodCopyWithImpl<ReferralPeriod>(
          this as ReferralPeriod, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ReferralPeriod &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.endDate, endDate) || other.endDate == endDate) &&
            (identical(other.comment, comment) || other.comment == comment));
  }

  @override
  int get hashCode => Object.hash(runtimeType, startDate, endDate, comment);

  @override
  String toString() {
    return 'ReferralPeriod(startDate: $startDate, endDate: $endDate, comment: $comment)';
  }
}

/// @nodoc
abstract mixin class $ReferralPeriodCopyWith<$Res> {
  factory $ReferralPeriodCopyWith(
          ReferralPeriod value, $Res Function(ReferralPeriod) _then) =
      _$ReferralPeriodCopyWithImpl;
  @useResult
  $Res call({DateTime? startDate, DateTime? endDate, String? comment});
}

/// @nodoc
class _$ReferralPeriodCopyWithImpl<$Res>
    implements $ReferralPeriodCopyWith<$Res> {
  _$ReferralPeriodCopyWithImpl(this._self, this._then);

  final ReferralPeriod _self;
  final $Res Function(ReferralPeriod) _then;

  /// Create a copy of ReferralPeriod
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? startDate = freezed,
    Object? endDate = freezed,
    Object? comment = freezed,
  }) {
    return _then(_self.copyWith(
      startDate: freezed == startDate
          ? _self.startDate
          : startDate // ignore: cast_nullable_to_non_nullable
              as DateTime?,
      endDate: freezed == endDate
          ? _self.endDate
          : endDate // ignore: cast_nullable_to_non_nullable
              as DateTime?,
      comment: freezed == comment
          ? _self.comment
          : comment // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _ReferralPeriod implements ReferralPeriod {
  const _ReferralPeriod(
      {this.startDate = null, this.endDate = null, this.comment = null});

  @override
  @JsonKey()
  final DateTime? startDate;
  @override
  @JsonKey()
  final DateTime? endDate;
  @override
  @JsonKey()
  final String? comment;

  /// Create a copy of ReferralPeriod
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ReferralPeriodCopyWith<_ReferralPeriod> get copyWith =>
      __$ReferralPeriodCopyWithImpl<_ReferralPeriod>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ReferralPeriod &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.endDate, endDate) || other.endDate == endDate) &&
            (identical(other.comment, comment) || other.comment == comment));
  }

  @override
  int get hashCode => Object.hash(runtimeType, startDate, endDate, comment);

  @override
  String toString() {
    return 'ReferralPeriod(startDate: $startDate, endDate: $endDate, comment: $comment)';
  }
}

/// @nodoc
abstract mixin class _$ReferralPeriodCopyWith<$Res>
    implements $ReferralPeriodCopyWith<$Res> {
  factory _$ReferralPeriodCopyWith(
          _ReferralPeriod value, $Res Function(_ReferralPeriod) _then) =
      __$ReferralPeriodCopyWithImpl;
  @override
  @useResult
  $Res call({DateTime? startDate, DateTime? endDate, String? comment});
}

/// @nodoc
class __$ReferralPeriodCopyWithImpl<$Res>
    implements _$ReferralPeriodCopyWith<$Res> {
  __$ReferralPeriodCopyWithImpl(this._self, this._then);

  final _ReferralPeriod _self;
  final $Res Function(_ReferralPeriod) _then;

  /// Create a copy of ReferralPeriod
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? startDate = freezed,
    Object? endDate = freezed,
    Object? comment = freezed,
  }) {
    return _then(_ReferralPeriod(
      startDate: freezed == startDate
          ? _self.startDate
          : startDate // ignore: cast_nullable_to_non_nullable
              as DateTime?,
      endDate: freezed == endDate
          ? _self.endDate
          : endDate // ignore: cast_nullable_to_non_nullable
              as DateTime?,
      comment: freezed == comment
          ? _self.comment
          : comment // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

// dart format on
