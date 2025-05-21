// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'calendar_item_type.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$CalendarItemType {
  String get id;
  String? get rev;
  int? get deletionDate;
  String? get healthcarePartyId;
  String? get agendaId;
  bool get defaultCalendarItemType;
  String? get name;
  String? get color;
  int get duration;
  String? get externalRef;
  String? get mikronoId;
  Set<String> get docIds;
  Map<String, String> get otherInfos;
  Map<String, String> get subjectByLanguage;

  /// Create a copy of CalendarItemType
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $CalendarItemTypeCopyWith<CalendarItemType> get copyWith =>
      _$CalendarItemTypeCopyWithImpl<CalendarItemType>(
          this as CalendarItemType, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is CalendarItemType &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.healthcarePartyId, healthcarePartyId) ||
                other.healthcarePartyId == healthcarePartyId) &&
            (identical(other.agendaId, agendaId) ||
                other.agendaId == agendaId) &&
            (identical(
                    other.defaultCalendarItemType, defaultCalendarItemType) ||
                other.defaultCalendarItemType == defaultCalendarItemType) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.color, color) || other.color == color) &&
            (identical(other.duration, duration) ||
                other.duration == duration) &&
            (identical(other.externalRef, externalRef) ||
                other.externalRef == externalRef) &&
            (identical(other.mikronoId, mikronoId) ||
                other.mikronoId == mikronoId) &&
            const DeepCollectionEquality().equals(other.docIds, docIds) &&
            const DeepCollectionEquality()
                .equals(other.otherInfos, otherInfos) &&
            const DeepCollectionEquality()
                .equals(other.subjectByLanguage, subjectByLanguage));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      deletionDate,
      healthcarePartyId,
      agendaId,
      defaultCalendarItemType,
      name,
      color,
      duration,
      externalRef,
      mikronoId,
      const DeepCollectionEquality().hash(docIds),
      const DeepCollectionEquality().hash(otherInfos),
      const DeepCollectionEquality().hash(subjectByLanguage));

  @override
  String toString() {
    return 'CalendarItemType(id: $id, rev: $rev, deletionDate: $deletionDate, healthcarePartyId: $healthcarePartyId, agendaId: $agendaId, defaultCalendarItemType: $defaultCalendarItemType, name: $name, color: $color, duration: $duration, externalRef: $externalRef, mikronoId: $mikronoId, docIds: $docIds, otherInfos: $otherInfos, subjectByLanguage: $subjectByLanguage)';
  }
}

/// @nodoc
abstract mixin class $CalendarItemTypeCopyWith<$Res> {
  factory $CalendarItemTypeCopyWith(
          CalendarItemType value, $Res Function(CalendarItemType) _then) =
      _$CalendarItemTypeCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      String? healthcarePartyId,
      String? agendaId,
      bool defaultCalendarItemType,
      String? name,
      String? color,
      int duration,
      String? externalRef,
      String? mikronoId,
      Set<String> docIds,
      Map<String, String> otherInfos,
      Map<String, String> subjectByLanguage});
}

/// @nodoc
class _$CalendarItemTypeCopyWithImpl<$Res>
    implements $CalendarItemTypeCopyWith<$Res> {
  _$CalendarItemTypeCopyWithImpl(this._self, this._then);

  final CalendarItemType _self;
  final $Res Function(CalendarItemType) _then;

  /// Create a copy of CalendarItemType
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? healthcarePartyId = freezed,
    Object? agendaId = freezed,
    Object? defaultCalendarItemType = null,
    Object? name = freezed,
    Object? color = freezed,
    Object? duration = null,
    Object? externalRef = freezed,
    Object? mikronoId = freezed,
    Object? docIds = null,
    Object? otherInfos = null,
    Object? subjectByLanguage = null,
  }) {
    return _then(_self.copyWith(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      healthcarePartyId: freezed == healthcarePartyId
          ? _self.healthcarePartyId
          : healthcarePartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      agendaId: freezed == agendaId
          ? _self.agendaId
          : agendaId // ignore: cast_nullable_to_non_nullable
              as String?,
      defaultCalendarItemType: null == defaultCalendarItemType
          ? _self.defaultCalendarItemType
          : defaultCalendarItemType // ignore: cast_nullable_to_non_nullable
              as bool,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      color: freezed == color
          ? _self.color
          : color // ignore: cast_nullable_to_non_nullable
              as String?,
      duration: null == duration
          ? _self.duration
          : duration // ignore: cast_nullable_to_non_nullable
              as int,
      externalRef: freezed == externalRef
          ? _self.externalRef
          : externalRef // ignore: cast_nullable_to_non_nullable
              as String?,
      mikronoId: freezed == mikronoId
          ? _self.mikronoId
          : mikronoId // ignore: cast_nullable_to_non_nullable
              as String?,
      docIds: null == docIds
          ? _self.docIds
          : docIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      otherInfos: null == otherInfos
          ? _self.otherInfos
          : otherInfos // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      subjectByLanguage: null == subjectByLanguage
          ? _self.subjectByLanguage
          : subjectByLanguage // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
    ));
  }
}

/// @nodoc

class _CalendarItemType implements CalendarItemType {
  const _CalendarItemType(
      {required this.id,
      this.rev = null,
      this.deletionDate = null,
      this.healthcarePartyId = null,
      this.agendaId = null,
      this.defaultCalendarItemType = false,
      this.name = null,
      this.color = null,
      this.duration = 0,
      this.externalRef = null,
      this.mikronoId = null,
      final Set<String> docIds = const {},
      final Map<String, String> otherInfos = const {},
      final Map<String, String> subjectByLanguage = const {}})
      : _docIds = docIds,
        _otherInfos = otherInfos,
        _subjectByLanguage = subjectByLanguage;

  @override
  final String id;
  @override
  @JsonKey()
  final String? rev;
  @override
  @JsonKey()
  final int? deletionDate;
  @override
  @JsonKey()
  final String? healthcarePartyId;
  @override
  @JsonKey()
  final String? agendaId;
  @override
  @JsonKey()
  final bool defaultCalendarItemType;
  @override
  @JsonKey()
  final String? name;
  @override
  @JsonKey()
  final String? color;
  @override
  @JsonKey()
  final int duration;
  @override
  @JsonKey()
  final String? externalRef;
  @override
  @JsonKey()
  final String? mikronoId;
  final Set<String> _docIds;
  @override
  @JsonKey()
  Set<String> get docIds {
    if (_docIds is EqualUnmodifiableSetView) return _docIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_docIds);
  }

  final Map<String, String> _otherInfos;
  @override
  @JsonKey()
  Map<String, String> get otherInfos {
    if (_otherInfos is EqualUnmodifiableMapView) return _otherInfos;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_otherInfos);
  }

  final Map<String, String> _subjectByLanguage;
  @override
  @JsonKey()
  Map<String, String> get subjectByLanguage {
    if (_subjectByLanguage is EqualUnmodifiableMapView)
      return _subjectByLanguage;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_subjectByLanguage);
  }

  /// Create a copy of CalendarItemType
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$CalendarItemTypeCopyWith<_CalendarItemType> get copyWith =>
      __$CalendarItemTypeCopyWithImpl<_CalendarItemType>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _CalendarItemType &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.healthcarePartyId, healthcarePartyId) ||
                other.healthcarePartyId == healthcarePartyId) &&
            (identical(other.agendaId, agendaId) ||
                other.agendaId == agendaId) &&
            (identical(
                    other.defaultCalendarItemType, defaultCalendarItemType) ||
                other.defaultCalendarItemType == defaultCalendarItemType) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.color, color) || other.color == color) &&
            (identical(other.duration, duration) ||
                other.duration == duration) &&
            (identical(other.externalRef, externalRef) ||
                other.externalRef == externalRef) &&
            (identical(other.mikronoId, mikronoId) ||
                other.mikronoId == mikronoId) &&
            const DeepCollectionEquality().equals(other._docIds, _docIds) &&
            const DeepCollectionEquality()
                .equals(other._otherInfos, _otherInfos) &&
            const DeepCollectionEquality()
                .equals(other._subjectByLanguage, _subjectByLanguage));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      rev,
      deletionDate,
      healthcarePartyId,
      agendaId,
      defaultCalendarItemType,
      name,
      color,
      duration,
      externalRef,
      mikronoId,
      const DeepCollectionEquality().hash(_docIds),
      const DeepCollectionEquality().hash(_otherInfos),
      const DeepCollectionEquality().hash(_subjectByLanguage));

  @override
  String toString() {
    return 'CalendarItemType(id: $id, rev: $rev, deletionDate: $deletionDate, healthcarePartyId: $healthcarePartyId, agendaId: $agendaId, defaultCalendarItemType: $defaultCalendarItemType, name: $name, color: $color, duration: $duration, externalRef: $externalRef, mikronoId: $mikronoId, docIds: $docIds, otherInfos: $otherInfos, subjectByLanguage: $subjectByLanguage)';
  }
}

/// @nodoc
abstract mixin class _$CalendarItemTypeCopyWith<$Res>
    implements $CalendarItemTypeCopyWith<$Res> {
  factory _$CalendarItemTypeCopyWith(
          _CalendarItemType value, $Res Function(_CalendarItemType) _then) =
      __$CalendarItemTypeCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      String? healthcarePartyId,
      String? agendaId,
      bool defaultCalendarItemType,
      String? name,
      String? color,
      int duration,
      String? externalRef,
      String? mikronoId,
      Set<String> docIds,
      Map<String, String> otherInfos,
      Map<String, String> subjectByLanguage});
}

/// @nodoc
class __$CalendarItemTypeCopyWithImpl<$Res>
    implements _$CalendarItemTypeCopyWith<$Res> {
  __$CalendarItemTypeCopyWithImpl(this._self, this._then);

  final _CalendarItemType _self;
  final $Res Function(_CalendarItemType) _then;

  /// Create a copy of CalendarItemType
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? healthcarePartyId = freezed,
    Object? agendaId = freezed,
    Object? defaultCalendarItemType = null,
    Object? name = freezed,
    Object? color = freezed,
    Object? duration = null,
    Object? externalRef = freezed,
    Object? mikronoId = freezed,
    Object? docIds = null,
    Object? otherInfos = null,
    Object? subjectByLanguage = null,
  }) {
    return _then(_CalendarItemType(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      healthcarePartyId: freezed == healthcarePartyId
          ? _self.healthcarePartyId
          : healthcarePartyId // ignore: cast_nullable_to_non_nullable
              as String?,
      agendaId: freezed == agendaId
          ? _self.agendaId
          : agendaId // ignore: cast_nullable_to_non_nullable
              as String?,
      defaultCalendarItemType: null == defaultCalendarItemType
          ? _self.defaultCalendarItemType
          : defaultCalendarItemType // ignore: cast_nullable_to_non_nullable
              as bool,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      color: freezed == color
          ? _self.color
          : color // ignore: cast_nullable_to_non_nullable
              as String?,
      duration: null == duration
          ? _self.duration
          : duration // ignore: cast_nullable_to_non_nullable
              as int,
      externalRef: freezed == externalRef
          ? _self.externalRef
          : externalRef // ignore: cast_nullable_to_non_nullable
              as String?,
      mikronoId: freezed == mikronoId
          ? _self.mikronoId
          : mikronoId // ignore: cast_nullable_to_non_nullable
              as String?,
      docIds: null == docIds
          ? _self._docIds
          : docIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      otherInfos: null == otherInfos
          ? _self._otherInfos
          : otherInfos // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
      subjectByLanguage: null == subjectByLanguage
          ? _self._subjectByLanguage
          : subjectByLanguage // ignore: cast_nullable_to_non_nullable
              as Map<String, String>,
    ));
  }
}

// dart format on
