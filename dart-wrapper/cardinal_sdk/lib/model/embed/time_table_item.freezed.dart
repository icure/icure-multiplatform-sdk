// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'time_table_item.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$TimeTableItem {
  int? get rruleStartDate;
  String? get rrule;
  int? get notBeforeInMinutes;
  int? get notAfterInMinutes;
  String? get zoneId;
  List<String> get days;
  List<String> get recurrenceTypes;
  List<TimeTableHour> get hours;
  String? get calendarItemTypeId;
  bool get homeVisit;
  String? get placeId;
  bool get publicTimeTableItem;
  bool get acceptsNewPatient;
  bool get unavailable;
  Set<String> get reservingRights;

  /// Create a copy of TimeTableItem
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $TimeTableItemCopyWith<TimeTableItem> get copyWith =>
      _$TimeTableItemCopyWithImpl<TimeTableItem>(
          this as TimeTableItem, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is TimeTableItem &&
            (identical(other.rruleStartDate, rruleStartDate) ||
                other.rruleStartDate == rruleStartDate) &&
            (identical(other.rrule, rrule) || other.rrule == rrule) &&
            (identical(other.notBeforeInMinutes, notBeforeInMinutes) ||
                other.notBeforeInMinutes == notBeforeInMinutes) &&
            (identical(other.notAfterInMinutes, notAfterInMinutes) ||
                other.notAfterInMinutes == notAfterInMinutes) &&
            (identical(other.zoneId, zoneId) || other.zoneId == zoneId) &&
            const DeepCollectionEquality().equals(other.days, days) &&
            const DeepCollectionEquality()
                .equals(other.recurrenceTypes, recurrenceTypes) &&
            const DeepCollectionEquality().equals(other.hours, hours) &&
            (identical(other.calendarItemTypeId, calendarItemTypeId) ||
                other.calendarItemTypeId == calendarItemTypeId) &&
            (identical(other.homeVisit, homeVisit) ||
                other.homeVisit == homeVisit) &&
            (identical(other.placeId, placeId) || other.placeId == placeId) &&
            (identical(other.publicTimeTableItem, publicTimeTableItem) ||
                other.publicTimeTableItem == publicTimeTableItem) &&
            (identical(other.acceptsNewPatient, acceptsNewPatient) ||
                other.acceptsNewPatient == acceptsNewPatient) &&
            (identical(other.unavailable, unavailable) ||
                other.unavailable == unavailable) &&
            const DeepCollectionEquality()
                .equals(other.reservingRights, reservingRights));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      rruleStartDate,
      rrule,
      notBeforeInMinutes,
      notAfterInMinutes,
      zoneId,
      const DeepCollectionEquality().hash(days),
      const DeepCollectionEquality().hash(recurrenceTypes),
      const DeepCollectionEquality().hash(hours),
      calendarItemTypeId,
      homeVisit,
      placeId,
      publicTimeTableItem,
      acceptsNewPatient,
      unavailable,
      const DeepCollectionEquality().hash(reservingRights));

  @override
  String toString() {
    return 'TimeTableItem(rruleStartDate: $rruleStartDate, rrule: $rrule, notBeforeInMinutes: $notBeforeInMinutes, notAfterInMinutes: $notAfterInMinutes, zoneId: $zoneId, days: $days, recurrenceTypes: $recurrenceTypes, hours: $hours, calendarItemTypeId: $calendarItemTypeId, homeVisit: $homeVisit, placeId: $placeId, publicTimeTableItem: $publicTimeTableItem, acceptsNewPatient: $acceptsNewPatient, unavailable: $unavailable, reservingRights: $reservingRights)';
  }
}

/// @nodoc
abstract mixin class $TimeTableItemCopyWith<$Res> {
  factory $TimeTableItemCopyWith(
          TimeTableItem value, $Res Function(TimeTableItem) _then) =
      _$TimeTableItemCopyWithImpl;
  @useResult
  $Res call(
      {int? rruleStartDate,
      String? rrule,
      int? notBeforeInMinutes,
      int? notAfterInMinutes,
      String? zoneId,
      List<String> days,
      List<String> recurrenceTypes,
      List<TimeTableHour> hours,
      String? calendarItemTypeId,
      bool homeVisit,
      String? placeId,
      bool publicTimeTableItem,
      bool acceptsNewPatient,
      bool unavailable,
      Set<String> reservingRights});
}

/// @nodoc
class _$TimeTableItemCopyWithImpl<$Res>
    implements $TimeTableItemCopyWith<$Res> {
  _$TimeTableItemCopyWithImpl(this._self, this._then);

  final TimeTableItem _self;
  final $Res Function(TimeTableItem) _then;

  /// Create a copy of TimeTableItem
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? rruleStartDate = freezed,
    Object? rrule = freezed,
    Object? notBeforeInMinutes = freezed,
    Object? notAfterInMinutes = freezed,
    Object? zoneId = freezed,
    Object? days = null,
    Object? recurrenceTypes = null,
    Object? hours = null,
    Object? calendarItemTypeId = freezed,
    Object? homeVisit = null,
    Object? placeId = freezed,
    Object? publicTimeTableItem = null,
    Object? acceptsNewPatient = null,
    Object? unavailable = null,
    Object? reservingRights = null,
  }) {
    return _then(_self.copyWith(
      rruleStartDate: freezed == rruleStartDate
          ? _self.rruleStartDate
          : rruleStartDate // ignore: cast_nullable_to_non_nullable
              as int?,
      rrule: freezed == rrule
          ? _self.rrule
          : rrule // ignore: cast_nullable_to_non_nullable
              as String?,
      notBeforeInMinutes: freezed == notBeforeInMinutes
          ? _self.notBeforeInMinutes
          : notBeforeInMinutes // ignore: cast_nullable_to_non_nullable
              as int?,
      notAfterInMinutes: freezed == notAfterInMinutes
          ? _self.notAfterInMinutes
          : notAfterInMinutes // ignore: cast_nullable_to_non_nullable
              as int?,
      zoneId: freezed == zoneId
          ? _self.zoneId
          : zoneId // ignore: cast_nullable_to_non_nullable
              as String?,
      days: null == days
          ? _self.days
          : days // ignore: cast_nullable_to_non_nullable
              as List<String>,
      recurrenceTypes: null == recurrenceTypes
          ? _self.recurrenceTypes
          : recurrenceTypes // ignore: cast_nullable_to_non_nullable
              as List<String>,
      hours: null == hours
          ? _self.hours
          : hours // ignore: cast_nullable_to_non_nullable
              as List<TimeTableHour>,
      calendarItemTypeId: freezed == calendarItemTypeId
          ? _self.calendarItemTypeId
          : calendarItemTypeId // ignore: cast_nullable_to_non_nullable
              as String?,
      homeVisit: null == homeVisit
          ? _self.homeVisit
          : homeVisit // ignore: cast_nullable_to_non_nullable
              as bool,
      placeId: freezed == placeId
          ? _self.placeId
          : placeId // ignore: cast_nullable_to_non_nullable
              as String?,
      publicTimeTableItem: null == publicTimeTableItem
          ? _self.publicTimeTableItem
          : publicTimeTableItem // ignore: cast_nullable_to_non_nullable
              as bool,
      acceptsNewPatient: null == acceptsNewPatient
          ? _self.acceptsNewPatient
          : acceptsNewPatient // ignore: cast_nullable_to_non_nullable
              as bool,
      unavailable: null == unavailable
          ? _self.unavailable
          : unavailable // ignore: cast_nullable_to_non_nullable
              as bool,
      reservingRights: null == reservingRights
          ? _self.reservingRights
          : reservingRights // ignore: cast_nullable_to_non_nullable
              as Set<String>,
    ));
  }
}

/// @nodoc

class _TimeTableItem implements TimeTableItem {
  const _TimeTableItem(
      {this.rruleStartDate = null,
      this.rrule = null,
      this.notBeforeInMinutes = null,
      this.notAfterInMinutes = null,
      this.zoneId = null,
      final List<String> days = const [],
      final List<String> recurrenceTypes = const [],
      final List<TimeTableHour> hours = const [],
      this.calendarItemTypeId = null,
      this.homeVisit = false,
      this.placeId = null,
      this.publicTimeTableItem = false,
      this.acceptsNewPatient = true,
      this.unavailable = false,
      final Set<String> reservingRights = const {}})
      : _days = days,
        _recurrenceTypes = recurrenceTypes,
        _hours = hours,
        _reservingRights = reservingRights;

  @override
  @JsonKey()
  final int? rruleStartDate;
  @override
  @JsonKey()
  final String? rrule;
  @override
  @JsonKey()
  final int? notBeforeInMinutes;
  @override
  @JsonKey()
  final int? notAfterInMinutes;
  @override
  @JsonKey()
  final String? zoneId;
  final List<String> _days;
  @override
  @JsonKey()
  List<String> get days {
    if (_days is EqualUnmodifiableListView) return _days;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_days);
  }

  final List<String> _recurrenceTypes;
  @override
  @JsonKey()
  List<String> get recurrenceTypes {
    if (_recurrenceTypes is EqualUnmodifiableListView) return _recurrenceTypes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_recurrenceTypes);
  }

  final List<TimeTableHour> _hours;
  @override
  @JsonKey()
  List<TimeTableHour> get hours {
    if (_hours is EqualUnmodifiableListView) return _hours;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_hours);
  }

  @override
  @JsonKey()
  final String? calendarItemTypeId;
  @override
  @JsonKey()
  final bool homeVisit;
  @override
  @JsonKey()
  final String? placeId;
  @override
  @JsonKey()
  final bool publicTimeTableItem;
  @override
  @JsonKey()
  final bool acceptsNewPatient;
  @override
  @JsonKey()
  final bool unavailable;
  final Set<String> _reservingRights;
  @override
  @JsonKey()
  Set<String> get reservingRights {
    if (_reservingRights is EqualUnmodifiableSetView) return _reservingRights;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_reservingRights);
  }

  /// Create a copy of TimeTableItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$TimeTableItemCopyWith<_TimeTableItem> get copyWith =>
      __$TimeTableItemCopyWithImpl<_TimeTableItem>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _TimeTableItem &&
            (identical(other.rruleStartDate, rruleStartDate) ||
                other.rruleStartDate == rruleStartDate) &&
            (identical(other.rrule, rrule) || other.rrule == rrule) &&
            (identical(other.notBeforeInMinutes, notBeforeInMinutes) ||
                other.notBeforeInMinutes == notBeforeInMinutes) &&
            (identical(other.notAfterInMinutes, notAfterInMinutes) ||
                other.notAfterInMinutes == notAfterInMinutes) &&
            (identical(other.zoneId, zoneId) || other.zoneId == zoneId) &&
            const DeepCollectionEquality().equals(other._days, _days) &&
            const DeepCollectionEquality()
                .equals(other._recurrenceTypes, _recurrenceTypes) &&
            const DeepCollectionEquality().equals(other._hours, _hours) &&
            (identical(other.calendarItemTypeId, calendarItemTypeId) ||
                other.calendarItemTypeId == calendarItemTypeId) &&
            (identical(other.homeVisit, homeVisit) ||
                other.homeVisit == homeVisit) &&
            (identical(other.placeId, placeId) || other.placeId == placeId) &&
            (identical(other.publicTimeTableItem, publicTimeTableItem) ||
                other.publicTimeTableItem == publicTimeTableItem) &&
            (identical(other.acceptsNewPatient, acceptsNewPatient) ||
                other.acceptsNewPatient == acceptsNewPatient) &&
            (identical(other.unavailable, unavailable) ||
                other.unavailable == unavailable) &&
            const DeepCollectionEquality()
                .equals(other._reservingRights, _reservingRights));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      rruleStartDate,
      rrule,
      notBeforeInMinutes,
      notAfterInMinutes,
      zoneId,
      const DeepCollectionEquality().hash(_days),
      const DeepCollectionEquality().hash(_recurrenceTypes),
      const DeepCollectionEquality().hash(_hours),
      calendarItemTypeId,
      homeVisit,
      placeId,
      publicTimeTableItem,
      acceptsNewPatient,
      unavailable,
      const DeepCollectionEquality().hash(_reservingRights));

  @override
  String toString() {
    return 'TimeTableItem(rruleStartDate: $rruleStartDate, rrule: $rrule, notBeforeInMinutes: $notBeforeInMinutes, notAfterInMinutes: $notAfterInMinutes, zoneId: $zoneId, days: $days, recurrenceTypes: $recurrenceTypes, hours: $hours, calendarItemTypeId: $calendarItemTypeId, homeVisit: $homeVisit, placeId: $placeId, publicTimeTableItem: $publicTimeTableItem, acceptsNewPatient: $acceptsNewPatient, unavailable: $unavailable, reservingRights: $reservingRights)';
  }
}

/// @nodoc
abstract mixin class _$TimeTableItemCopyWith<$Res>
    implements $TimeTableItemCopyWith<$Res> {
  factory _$TimeTableItemCopyWith(
          _TimeTableItem value, $Res Function(_TimeTableItem) _then) =
      __$TimeTableItemCopyWithImpl;
  @override
  @useResult
  $Res call(
      {int? rruleStartDate,
      String? rrule,
      int? notBeforeInMinutes,
      int? notAfterInMinutes,
      String? zoneId,
      List<String> days,
      List<String> recurrenceTypes,
      List<TimeTableHour> hours,
      String? calendarItemTypeId,
      bool homeVisit,
      String? placeId,
      bool publicTimeTableItem,
      bool acceptsNewPatient,
      bool unavailable,
      Set<String> reservingRights});
}

/// @nodoc
class __$TimeTableItemCopyWithImpl<$Res>
    implements _$TimeTableItemCopyWith<$Res> {
  __$TimeTableItemCopyWithImpl(this._self, this._then);

  final _TimeTableItem _self;
  final $Res Function(_TimeTableItem) _then;

  /// Create a copy of TimeTableItem
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? rruleStartDate = freezed,
    Object? rrule = freezed,
    Object? notBeforeInMinutes = freezed,
    Object? notAfterInMinutes = freezed,
    Object? zoneId = freezed,
    Object? days = null,
    Object? recurrenceTypes = null,
    Object? hours = null,
    Object? calendarItemTypeId = freezed,
    Object? homeVisit = null,
    Object? placeId = freezed,
    Object? publicTimeTableItem = null,
    Object? acceptsNewPatient = null,
    Object? unavailable = null,
    Object? reservingRights = null,
  }) {
    return _then(_TimeTableItem(
      rruleStartDate: freezed == rruleStartDate
          ? _self.rruleStartDate
          : rruleStartDate // ignore: cast_nullable_to_non_nullable
              as int?,
      rrule: freezed == rrule
          ? _self.rrule
          : rrule // ignore: cast_nullable_to_non_nullable
              as String?,
      notBeforeInMinutes: freezed == notBeforeInMinutes
          ? _self.notBeforeInMinutes
          : notBeforeInMinutes // ignore: cast_nullable_to_non_nullable
              as int?,
      notAfterInMinutes: freezed == notAfterInMinutes
          ? _self.notAfterInMinutes
          : notAfterInMinutes // ignore: cast_nullable_to_non_nullable
              as int?,
      zoneId: freezed == zoneId
          ? _self.zoneId
          : zoneId // ignore: cast_nullable_to_non_nullable
              as String?,
      days: null == days
          ? _self._days
          : days // ignore: cast_nullable_to_non_nullable
              as List<String>,
      recurrenceTypes: null == recurrenceTypes
          ? _self._recurrenceTypes
          : recurrenceTypes // ignore: cast_nullable_to_non_nullable
              as List<String>,
      hours: null == hours
          ? _self._hours
          : hours // ignore: cast_nullable_to_non_nullable
              as List<TimeTableHour>,
      calendarItemTypeId: freezed == calendarItemTypeId
          ? _self.calendarItemTypeId
          : calendarItemTypeId // ignore: cast_nullable_to_non_nullable
              as String?,
      homeVisit: null == homeVisit
          ? _self.homeVisit
          : homeVisit // ignore: cast_nullable_to_non_nullable
              as bool,
      placeId: freezed == placeId
          ? _self.placeId
          : placeId // ignore: cast_nullable_to_non_nullable
              as String?,
      publicTimeTableItem: null == publicTimeTableItem
          ? _self.publicTimeTableItem
          : publicTimeTableItem // ignore: cast_nullable_to_non_nullable
              as bool,
      acceptsNewPatient: null == acceptsNewPatient
          ? _self.acceptsNewPatient
          : acceptsNewPatient // ignore: cast_nullable_to_non_nullable
              as bool,
      unavailable: null == unavailable
          ? _self.unavailable
          : unavailable // ignore: cast_nullable_to_non_nullable
              as bool,
      reservingRights: null == reservingRights
          ? _self._reservingRights
          : reservingRights // ignore: cast_nullable_to_non_nullable
              as Set<String>,
    ));
  }
}

// dart format on
