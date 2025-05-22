// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'embedded_time_table.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EmbeddedTimeTable {
  String get id;
  Set<CodeStub> get codes;
  String? get medicalLocationId;
  int? get endOfLife;
  String? get name;
  int? get startTime;
  int? get endTime;
  List<TimeTableItem> get items;

  /// Create a copy of EmbeddedTimeTable
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EmbeddedTimeTableCopyWith<EmbeddedTimeTable> get copyWith =>
      _$EmbeddedTimeTableCopyWithImpl<EmbeddedTimeTable>(
          this as EmbeddedTimeTable, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EmbeddedTimeTable &&
            (identical(other.id, id) || other.id == id) &&
            const DeepCollectionEquality().equals(other.codes, codes) &&
            (identical(other.medicalLocationId, medicalLocationId) ||
                other.medicalLocationId == medicalLocationId) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.startTime, startTime) ||
                other.startTime == startTime) &&
            (identical(other.endTime, endTime) || other.endTime == endTime) &&
            const DeepCollectionEquality().equals(other.items, items));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      const DeepCollectionEquality().hash(codes),
      medicalLocationId,
      endOfLife,
      name,
      startTime,
      endTime,
      const DeepCollectionEquality().hash(items));

  @override
  String toString() {
    return 'EmbeddedTimeTable(id: $id, codes: $codes, medicalLocationId: $medicalLocationId, endOfLife: $endOfLife, name: $name, startTime: $startTime, endTime: $endTime, items: $items)';
  }
}

/// @nodoc
abstract mixin class $EmbeddedTimeTableCopyWith<$Res> {
  factory $EmbeddedTimeTableCopyWith(
          EmbeddedTimeTable value, $Res Function(EmbeddedTimeTable) _then) =
      _$EmbeddedTimeTableCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      Set<CodeStub> codes,
      String? medicalLocationId,
      int? endOfLife,
      String? name,
      int? startTime,
      int? endTime,
      List<TimeTableItem> items});
}

/// @nodoc
class _$EmbeddedTimeTableCopyWithImpl<$Res>
    implements $EmbeddedTimeTableCopyWith<$Res> {
  _$EmbeddedTimeTableCopyWithImpl(this._self, this._then);

  final EmbeddedTimeTable _self;
  final $Res Function(EmbeddedTimeTable) _then;

  /// Create a copy of EmbeddedTimeTable
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? codes = null,
    Object? medicalLocationId = freezed,
    Object? endOfLife = freezed,
    Object? name = freezed,
    Object? startTime = freezed,
    Object? endTime = freezed,
    Object? items = null,
  }) {
    return _then(_self.copyWith(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      codes: null == codes
          ? _self.codes
          : codes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      medicalLocationId: freezed == medicalLocationId
          ? _self.medicalLocationId
          : medicalLocationId // ignore: cast_nullable_to_non_nullable
              as String?,
      endOfLife: freezed == endOfLife
          ? _self.endOfLife
          : endOfLife // ignore: cast_nullable_to_non_nullable
              as int?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      startTime: freezed == startTime
          ? _self.startTime
          : startTime // ignore: cast_nullable_to_non_nullable
              as int?,
      endTime: freezed == endTime
          ? _self.endTime
          : endTime // ignore: cast_nullable_to_non_nullable
              as int?,
      items: null == items
          ? _self.items
          : items // ignore: cast_nullable_to_non_nullable
              as List<TimeTableItem>,
    ));
  }
}

/// @nodoc

class _EmbeddedTimeTable implements EmbeddedTimeTable {
  const _EmbeddedTimeTable(
      {required this.id,
      final Set<CodeStub> codes = const {},
      this.medicalLocationId = null,
      this.endOfLife = null,
      this.name = null,
      this.startTime = null,
      this.endTime = null,
      final List<TimeTableItem> items = const []})
      : _codes = codes,
        _items = items;

  @override
  final String id;
  final Set<CodeStub> _codes;
  @override
  @JsonKey()
  Set<CodeStub> get codes {
    if (_codes is EqualUnmodifiableSetView) return _codes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_codes);
  }

  @override
  @JsonKey()
  final String? medicalLocationId;
  @override
  @JsonKey()
  final int? endOfLife;
  @override
  @JsonKey()
  final String? name;
  @override
  @JsonKey()
  final int? startTime;
  @override
  @JsonKey()
  final int? endTime;
  final List<TimeTableItem> _items;
  @override
  @JsonKey()
  List<TimeTableItem> get items {
    if (_items is EqualUnmodifiableListView) return _items;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_items);
  }

  /// Create a copy of EmbeddedTimeTable
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EmbeddedTimeTableCopyWith<_EmbeddedTimeTable> get copyWith =>
      __$EmbeddedTimeTableCopyWithImpl<_EmbeddedTimeTable>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EmbeddedTimeTable &&
            (identical(other.id, id) || other.id == id) &&
            const DeepCollectionEquality().equals(other._codes, _codes) &&
            (identical(other.medicalLocationId, medicalLocationId) ||
                other.medicalLocationId == medicalLocationId) &&
            (identical(other.endOfLife, endOfLife) ||
                other.endOfLife == endOfLife) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.startTime, startTime) ||
                other.startTime == startTime) &&
            (identical(other.endTime, endTime) || other.endTime == endTime) &&
            const DeepCollectionEquality().equals(other._items, _items));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      id,
      const DeepCollectionEquality().hash(_codes),
      medicalLocationId,
      endOfLife,
      name,
      startTime,
      endTime,
      const DeepCollectionEquality().hash(_items));

  @override
  String toString() {
    return 'EmbeddedTimeTable(id: $id, codes: $codes, medicalLocationId: $medicalLocationId, endOfLife: $endOfLife, name: $name, startTime: $startTime, endTime: $endTime, items: $items)';
  }
}

/// @nodoc
abstract mixin class _$EmbeddedTimeTableCopyWith<$Res>
    implements $EmbeddedTimeTableCopyWith<$Res> {
  factory _$EmbeddedTimeTableCopyWith(
          _EmbeddedTimeTable value, $Res Function(_EmbeddedTimeTable) _then) =
      __$EmbeddedTimeTableCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      Set<CodeStub> codes,
      String? medicalLocationId,
      int? endOfLife,
      String? name,
      int? startTime,
      int? endTime,
      List<TimeTableItem> items});
}

/// @nodoc
class __$EmbeddedTimeTableCopyWithImpl<$Res>
    implements _$EmbeddedTimeTableCopyWith<$Res> {
  __$EmbeddedTimeTableCopyWithImpl(this._self, this._then);

  final _EmbeddedTimeTable _self;
  final $Res Function(_EmbeddedTimeTable) _then;

  /// Create a copy of EmbeddedTimeTable
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? codes = null,
    Object? medicalLocationId = freezed,
    Object? endOfLife = freezed,
    Object? name = freezed,
    Object? startTime = freezed,
    Object? endTime = freezed,
    Object? items = null,
  }) {
    return _then(_EmbeddedTimeTable(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      codes: null == codes
          ? _self._codes
          : codes // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      medicalLocationId: freezed == medicalLocationId
          ? _self.medicalLocationId
          : medicalLocationId // ignore: cast_nullable_to_non_nullable
              as String?,
      endOfLife: freezed == endOfLife
          ? _self.endOfLife
          : endOfLife // ignore: cast_nullable_to_non_nullable
              as int?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      startTime: freezed == startTime
          ? _self.startTime
          : startTime // ignore: cast_nullable_to_non_nullable
              as int?,
      endTime: freezed == endTime
          ? _self.endTime
          : endTime // ignore: cast_nullable_to_non_nullable
              as int?,
      items: null == items
          ? _self._items
          : items // ignore: cast_nullable_to_non_nullable
              as List<TimeTableItem>,
    ));
  }
}

// dart format on
