// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'time_table_hour.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$TimeTableHour {
  int? get startHour;
  int? get endHour;

  /// Create a copy of TimeTableHour
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $TimeTableHourCopyWith<TimeTableHour> get copyWith =>
      _$TimeTableHourCopyWithImpl<TimeTableHour>(
          this as TimeTableHour, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is TimeTableHour &&
            (identical(other.startHour, startHour) ||
                other.startHour == startHour) &&
            (identical(other.endHour, endHour) || other.endHour == endHour));
  }

  @override
  int get hashCode => Object.hash(runtimeType, startHour, endHour);

  @override
  String toString() {
    return 'TimeTableHour(startHour: $startHour, endHour: $endHour)';
  }
}

/// @nodoc
abstract mixin class $TimeTableHourCopyWith<$Res> {
  factory $TimeTableHourCopyWith(
          TimeTableHour value, $Res Function(TimeTableHour) _then) =
      _$TimeTableHourCopyWithImpl;
  @useResult
  $Res call({int? startHour, int? endHour});
}

/// @nodoc
class _$TimeTableHourCopyWithImpl<$Res>
    implements $TimeTableHourCopyWith<$Res> {
  _$TimeTableHourCopyWithImpl(this._self, this._then);

  final TimeTableHour _self;
  final $Res Function(TimeTableHour) _then;

  /// Create a copy of TimeTableHour
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? startHour = freezed,
    Object? endHour = freezed,
  }) {
    return _then(_self.copyWith(
      startHour: freezed == startHour
          ? _self.startHour
          : startHour // ignore: cast_nullable_to_non_nullable
              as int?,
      endHour: freezed == endHour
          ? _self.endHour
          : endHour // ignore: cast_nullable_to_non_nullable
              as int?,
    ));
  }
}

/// @nodoc

class _TimeTableHour implements TimeTableHour {
  const _TimeTableHour({this.startHour = null, this.endHour = null});

  @override
  @JsonKey()
  final int? startHour;
  @override
  @JsonKey()
  final int? endHour;

  /// Create a copy of TimeTableHour
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$TimeTableHourCopyWith<_TimeTableHour> get copyWith =>
      __$TimeTableHourCopyWithImpl<_TimeTableHour>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _TimeTableHour &&
            (identical(other.startHour, startHour) ||
                other.startHour == startHour) &&
            (identical(other.endHour, endHour) || other.endHour == endHour));
  }

  @override
  int get hashCode => Object.hash(runtimeType, startHour, endHour);

  @override
  String toString() {
    return 'TimeTableHour(startHour: $startHour, endHour: $endHour)';
  }
}

/// @nodoc
abstract mixin class _$TimeTableHourCopyWith<$Res>
    implements $TimeTableHourCopyWith<$Res> {
  factory _$TimeTableHourCopyWith(
          _TimeTableHour value, $Res Function(_TimeTableHour) _then) =
      __$TimeTableHourCopyWithImpl;
  @override
  @useResult
  $Res call({int? startHour, int? endHour});
}

/// @nodoc
class __$TimeTableHourCopyWithImpl<$Res>
    implements _$TimeTableHourCopyWith<$Res> {
  __$TimeTableHourCopyWithImpl(this._self, this._then);

  final _TimeTableHour _self;
  final $Res Function(_TimeTableHour) _then;

  /// Create a copy of TimeTableHour
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? startHour = freezed,
    Object? endHour = freezed,
  }) {
    return _then(_TimeTableHour(
      startHour: freezed == startHour
          ? _self.startHour
          : startHour // ignore: cast_nullable_to_non_nullable
              as int?,
      endHour: freezed == endHour
          ? _self.endHour
          : endHour // ignore: cast_nullable_to_non_nullable
              as int?,
    ));
  }
}

// dart format on
