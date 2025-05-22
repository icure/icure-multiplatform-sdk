// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'regimen_item.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$RegimenItem {
  int? get date;
  int? get dayNumber;
  Weekday? get weekday;
  CodeStub? get dayPeriod;
  int? get timeOfDay;
  AdministrationQuantity? get administratedQuantity;

  /// Create a copy of RegimenItem
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $RegimenItemCopyWith<RegimenItem> get copyWith =>
      _$RegimenItemCopyWithImpl<RegimenItem>(this as RegimenItem, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is RegimenItem &&
            (identical(other.date, date) || other.date == date) &&
            (identical(other.dayNumber, dayNumber) ||
                other.dayNumber == dayNumber) &&
            (identical(other.weekday, weekday) || other.weekday == weekday) &&
            (identical(other.dayPeriod, dayPeriod) ||
                other.dayPeriod == dayPeriod) &&
            (identical(other.timeOfDay, timeOfDay) ||
                other.timeOfDay == timeOfDay) &&
            (identical(other.administratedQuantity, administratedQuantity) ||
                other.administratedQuantity == administratedQuantity));
  }

  @override
  int get hashCode => Object.hash(runtimeType, date, dayNumber, weekday,
      dayPeriod, timeOfDay, administratedQuantity);

  @override
  String toString() {
    return 'RegimenItem(date: $date, dayNumber: $dayNumber, weekday: $weekday, dayPeriod: $dayPeriod, timeOfDay: $timeOfDay, administratedQuantity: $administratedQuantity)';
  }
}

/// @nodoc
abstract mixin class $RegimenItemCopyWith<$Res> {
  factory $RegimenItemCopyWith(
          RegimenItem value, $Res Function(RegimenItem) _then) =
      _$RegimenItemCopyWithImpl;
  @useResult
  $Res call(
      {int? date,
      int? dayNumber,
      Weekday? weekday,
      CodeStub? dayPeriod,
      int? timeOfDay,
      AdministrationQuantity? administratedQuantity});

  $WeekdayCopyWith<$Res>? get weekday;
  $CodeStubCopyWith<$Res>? get dayPeriod;
  $AdministrationQuantityCopyWith<$Res>? get administratedQuantity;
}

/// @nodoc
class _$RegimenItemCopyWithImpl<$Res> implements $RegimenItemCopyWith<$Res> {
  _$RegimenItemCopyWithImpl(this._self, this._then);

  final RegimenItem _self;
  final $Res Function(RegimenItem) _then;

  /// Create a copy of RegimenItem
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? date = freezed,
    Object? dayNumber = freezed,
    Object? weekday = freezed,
    Object? dayPeriod = freezed,
    Object? timeOfDay = freezed,
    Object? administratedQuantity = freezed,
  }) {
    return _then(_self.copyWith(
      date: freezed == date
          ? _self.date
          : date // ignore: cast_nullable_to_non_nullable
              as int?,
      dayNumber: freezed == dayNumber
          ? _self.dayNumber
          : dayNumber // ignore: cast_nullable_to_non_nullable
              as int?,
      weekday: freezed == weekday
          ? _self.weekday
          : weekday // ignore: cast_nullable_to_non_nullable
              as Weekday?,
      dayPeriod: freezed == dayPeriod
          ? _self.dayPeriod
          : dayPeriod // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      timeOfDay: freezed == timeOfDay
          ? _self.timeOfDay
          : timeOfDay // ignore: cast_nullable_to_non_nullable
              as int?,
      administratedQuantity: freezed == administratedQuantity
          ? _self.administratedQuantity
          : administratedQuantity // ignore: cast_nullable_to_non_nullable
              as AdministrationQuantity?,
    ));
  }

  /// Create a copy of RegimenItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $WeekdayCopyWith<$Res>? get weekday {
    if (_self.weekday == null) {
      return null;
    }

    return $WeekdayCopyWith<$Res>(_self.weekday!, (value) {
      return _then(_self.copyWith(weekday: value));
    });
  }

  /// Create a copy of RegimenItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get dayPeriod {
    if (_self.dayPeriod == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.dayPeriod!, (value) {
      return _then(_self.copyWith(dayPeriod: value));
    });
  }

  /// Create a copy of RegimenItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $AdministrationQuantityCopyWith<$Res>? get administratedQuantity {
    if (_self.administratedQuantity == null) {
      return null;
    }

    return $AdministrationQuantityCopyWith<$Res>(_self.administratedQuantity!,
        (value) {
      return _then(_self.copyWith(administratedQuantity: value));
    });
  }
}

/// @nodoc

class _RegimenItem implements RegimenItem {
  const _RegimenItem(
      {this.date = null,
      this.dayNumber = null,
      this.weekday = null,
      this.dayPeriod = null,
      this.timeOfDay = null,
      this.administratedQuantity = null});

  @override
  @JsonKey()
  final int? date;
  @override
  @JsonKey()
  final int? dayNumber;
  @override
  @JsonKey()
  final Weekday? weekday;
  @override
  @JsonKey()
  final CodeStub? dayPeriod;
  @override
  @JsonKey()
  final int? timeOfDay;
  @override
  @JsonKey()
  final AdministrationQuantity? administratedQuantity;

  /// Create a copy of RegimenItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$RegimenItemCopyWith<_RegimenItem> get copyWith =>
      __$RegimenItemCopyWithImpl<_RegimenItem>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _RegimenItem &&
            (identical(other.date, date) || other.date == date) &&
            (identical(other.dayNumber, dayNumber) ||
                other.dayNumber == dayNumber) &&
            (identical(other.weekday, weekday) || other.weekday == weekday) &&
            (identical(other.dayPeriod, dayPeriod) ||
                other.dayPeriod == dayPeriod) &&
            (identical(other.timeOfDay, timeOfDay) ||
                other.timeOfDay == timeOfDay) &&
            (identical(other.administratedQuantity, administratedQuantity) ||
                other.administratedQuantity == administratedQuantity));
  }

  @override
  int get hashCode => Object.hash(runtimeType, date, dayNumber, weekday,
      dayPeriod, timeOfDay, administratedQuantity);

  @override
  String toString() {
    return 'RegimenItem(date: $date, dayNumber: $dayNumber, weekday: $weekday, dayPeriod: $dayPeriod, timeOfDay: $timeOfDay, administratedQuantity: $administratedQuantity)';
  }
}

/// @nodoc
abstract mixin class _$RegimenItemCopyWith<$Res>
    implements $RegimenItemCopyWith<$Res> {
  factory _$RegimenItemCopyWith(
          _RegimenItem value, $Res Function(_RegimenItem) _then) =
      __$RegimenItemCopyWithImpl;
  @override
  @useResult
  $Res call(
      {int? date,
      int? dayNumber,
      Weekday? weekday,
      CodeStub? dayPeriod,
      int? timeOfDay,
      AdministrationQuantity? administratedQuantity});

  @override
  $WeekdayCopyWith<$Res>? get weekday;
  @override
  $CodeStubCopyWith<$Res>? get dayPeriod;
  @override
  $AdministrationQuantityCopyWith<$Res>? get administratedQuantity;
}

/// @nodoc
class __$RegimenItemCopyWithImpl<$Res> implements _$RegimenItemCopyWith<$Res> {
  __$RegimenItemCopyWithImpl(this._self, this._then);

  final _RegimenItem _self;
  final $Res Function(_RegimenItem) _then;

  /// Create a copy of RegimenItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? date = freezed,
    Object? dayNumber = freezed,
    Object? weekday = freezed,
    Object? dayPeriod = freezed,
    Object? timeOfDay = freezed,
    Object? administratedQuantity = freezed,
  }) {
    return _then(_RegimenItem(
      date: freezed == date
          ? _self.date
          : date // ignore: cast_nullable_to_non_nullable
              as int?,
      dayNumber: freezed == dayNumber
          ? _self.dayNumber
          : dayNumber // ignore: cast_nullable_to_non_nullable
              as int?,
      weekday: freezed == weekday
          ? _self.weekday
          : weekday // ignore: cast_nullable_to_non_nullable
              as Weekday?,
      dayPeriod: freezed == dayPeriod
          ? _self.dayPeriod
          : dayPeriod // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      timeOfDay: freezed == timeOfDay
          ? _self.timeOfDay
          : timeOfDay // ignore: cast_nullable_to_non_nullable
              as int?,
      administratedQuantity: freezed == administratedQuantity
          ? _self.administratedQuantity
          : administratedQuantity // ignore: cast_nullable_to_non_nullable
              as AdministrationQuantity?,
    ));
  }

  /// Create a copy of RegimenItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $WeekdayCopyWith<$Res>? get weekday {
    if (_self.weekday == null) {
      return null;
    }

    return $WeekdayCopyWith<$Res>(_self.weekday!, (value) {
      return _then(_self.copyWith(weekday: value));
    });
  }

  /// Create a copy of RegimenItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get dayPeriod {
    if (_self.dayPeriod == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.dayPeriod!, (value) {
      return _then(_self.copyWith(dayPeriod: value));
    });
  }

  /// Create a copy of RegimenItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $AdministrationQuantityCopyWith<$Res>? get administratedQuantity {
    if (_self.administratedQuantity == null) {
      return null;
    }

    return $AdministrationQuantityCopyWith<$Res>(_self.administratedQuantity!,
        (value) {
      return _then(_self.copyWith(administratedQuantity: value));
    });
  }
}

// dart format on
