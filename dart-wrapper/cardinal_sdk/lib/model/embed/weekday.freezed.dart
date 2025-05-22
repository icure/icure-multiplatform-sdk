// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'weekday.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Weekday {
  CodeStub? get weekday;
  int? get weekNumber;

  /// Create a copy of Weekday
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $WeekdayCopyWith<Weekday> get copyWith =>
      _$WeekdayCopyWithImpl<Weekday>(this as Weekday, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Weekday &&
            (identical(other.weekday, weekday) || other.weekday == weekday) &&
            (identical(other.weekNumber, weekNumber) ||
                other.weekNumber == weekNumber));
  }

  @override
  int get hashCode => Object.hash(runtimeType, weekday, weekNumber);

  @override
  String toString() {
    return 'Weekday(weekday: $weekday, weekNumber: $weekNumber)';
  }
}

/// @nodoc
abstract mixin class $WeekdayCopyWith<$Res> {
  factory $WeekdayCopyWith(Weekday value, $Res Function(Weekday) _then) =
      _$WeekdayCopyWithImpl;
  @useResult
  $Res call({CodeStub? weekday, int? weekNumber});

  $CodeStubCopyWith<$Res>? get weekday;
}

/// @nodoc
class _$WeekdayCopyWithImpl<$Res> implements $WeekdayCopyWith<$Res> {
  _$WeekdayCopyWithImpl(this._self, this._then);

  final Weekday _self;
  final $Res Function(Weekday) _then;

  /// Create a copy of Weekday
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? weekday = freezed,
    Object? weekNumber = freezed,
  }) {
    return _then(_self.copyWith(
      weekday: freezed == weekday
          ? _self.weekday
          : weekday // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      weekNumber: freezed == weekNumber
          ? _self.weekNumber
          : weekNumber // ignore: cast_nullable_to_non_nullable
              as int?,
    ));
  }

  /// Create a copy of Weekday
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get weekday {
    if (_self.weekday == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.weekday!, (value) {
      return _then(_self.copyWith(weekday: value));
    });
  }
}

/// @nodoc

class _Weekday implements Weekday {
  const _Weekday({this.weekday = null, this.weekNumber = null});

  @override
  @JsonKey()
  final CodeStub? weekday;
  @override
  @JsonKey()
  final int? weekNumber;

  /// Create a copy of Weekday
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$WeekdayCopyWith<_Weekday> get copyWith =>
      __$WeekdayCopyWithImpl<_Weekday>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Weekday &&
            (identical(other.weekday, weekday) || other.weekday == weekday) &&
            (identical(other.weekNumber, weekNumber) ||
                other.weekNumber == weekNumber));
  }

  @override
  int get hashCode => Object.hash(runtimeType, weekday, weekNumber);

  @override
  String toString() {
    return 'Weekday(weekday: $weekday, weekNumber: $weekNumber)';
  }
}

/// @nodoc
abstract mixin class _$WeekdayCopyWith<$Res> implements $WeekdayCopyWith<$Res> {
  factory _$WeekdayCopyWith(_Weekday value, $Res Function(_Weekday) _then) =
      __$WeekdayCopyWithImpl;
  @override
  @useResult
  $Res call({CodeStub? weekday, int? weekNumber});

  @override
  $CodeStubCopyWith<$Res>? get weekday;
}

/// @nodoc
class __$WeekdayCopyWithImpl<$Res> implements _$WeekdayCopyWith<$Res> {
  __$WeekdayCopyWithImpl(this._self, this._then);

  final _Weekday _self;
  final $Res Function(_Weekday) _then;

  /// Create a copy of Weekday
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? weekday = freezed,
    Object? weekNumber = freezed,
  }) {
    return _then(_Weekday(
      weekday: freezed == weekday
          ? _self.weekday
          : weekday // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      weekNumber: freezed == weekNumber
          ? _self.weekNumber
          : weekNumber // ignore: cast_nullable_to_non_nullable
              as int?,
    ));
  }

  /// Create a copy of Weekday
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get weekday {
    if (_self.weekday == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.weekday!, (value) {
      return _then(_self.copyWith(weekday: value));
    });
  }
}

// dart format on
