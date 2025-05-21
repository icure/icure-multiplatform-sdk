// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'reference_range.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$ReferenceRange {
  double? get low;
  double? get high;
  String? get stringValue;
  List<CodeStub> get tags;
  List<CodeStub> get codes;
  List<Annotation> get notes;
  Range? get age;

  /// Create a copy of ReferenceRange
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ReferenceRangeCopyWith<ReferenceRange> get copyWith =>
      _$ReferenceRangeCopyWithImpl<ReferenceRange>(
          this as ReferenceRange, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ReferenceRange &&
            (identical(other.low, low) || other.low == low) &&
            (identical(other.high, high) || other.high == high) &&
            (identical(other.stringValue, stringValue) ||
                other.stringValue == stringValue) &&
            const DeepCollectionEquality().equals(other.tags, tags) &&
            const DeepCollectionEquality().equals(other.codes, codes) &&
            const DeepCollectionEquality().equals(other.notes, notes) &&
            (identical(other.age, age) || other.age == age));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      low,
      high,
      stringValue,
      const DeepCollectionEquality().hash(tags),
      const DeepCollectionEquality().hash(codes),
      const DeepCollectionEquality().hash(notes),
      age);

  @override
  String toString() {
    return 'ReferenceRange(low: $low, high: $high, stringValue: $stringValue, tags: $tags, codes: $codes, notes: $notes, age: $age)';
  }
}

/// @nodoc
abstract mixin class $ReferenceRangeCopyWith<$Res> {
  factory $ReferenceRangeCopyWith(
          ReferenceRange value, $Res Function(ReferenceRange) _then) =
      _$ReferenceRangeCopyWithImpl;
  @useResult
  $Res call(
      {double? low,
      double? high,
      String? stringValue,
      List<CodeStub> tags,
      List<CodeStub> codes,
      List<Annotation> notes,
      Range? age});

  $RangeCopyWith<$Res>? get age;
}

/// @nodoc
class _$ReferenceRangeCopyWithImpl<$Res>
    implements $ReferenceRangeCopyWith<$Res> {
  _$ReferenceRangeCopyWithImpl(this._self, this._then);

  final ReferenceRange _self;
  final $Res Function(ReferenceRange) _then;

  /// Create a copy of ReferenceRange
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? low = freezed,
    Object? high = freezed,
    Object? stringValue = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? notes = null,
    Object? age = freezed,
  }) {
    return _then(_self.copyWith(
      low: freezed == low
          ? _self.low
          : low // ignore: cast_nullable_to_non_nullable
              as double?,
      high: freezed == high
          ? _self.high
          : high // ignore: cast_nullable_to_non_nullable
              as double?,
      stringValue: freezed == stringValue
          ? _self.stringValue
          : stringValue // ignore: cast_nullable_to_non_nullable
              as String?,
      tags: null == tags
          ? _self.tags
          : tags // ignore: cast_nullable_to_non_nullable
              as List<CodeStub>,
      codes: null == codes
          ? _self.codes
          : codes // ignore: cast_nullable_to_non_nullable
              as List<CodeStub>,
      notes: null == notes
          ? _self.notes
          : notes // ignore: cast_nullable_to_non_nullable
              as List<Annotation>,
      age: freezed == age
          ? _self.age
          : age // ignore: cast_nullable_to_non_nullable
              as Range?,
    ));
  }

  /// Create a copy of ReferenceRange
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $RangeCopyWith<$Res>? get age {
    if (_self.age == null) {
      return null;
    }

    return $RangeCopyWith<$Res>(_self.age!, (value) {
      return _then(_self.copyWith(age: value));
    });
  }
}

/// @nodoc

class _ReferenceRange implements ReferenceRange {
  const _ReferenceRange(
      {this.low = null,
      this.high = null,
      this.stringValue = null,
      final List<CodeStub> tags = const [],
      final List<CodeStub> codes = const [],
      final List<Annotation> notes = const [],
      this.age = null})
      : _tags = tags,
        _codes = codes,
        _notes = notes;

  @override
  @JsonKey()
  final double? low;
  @override
  @JsonKey()
  final double? high;
  @override
  @JsonKey()
  final String? stringValue;
  final List<CodeStub> _tags;
  @override
  @JsonKey()
  List<CodeStub> get tags {
    if (_tags is EqualUnmodifiableListView) return _tags;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_tags);
  }

  final List<CodeStub> _codes;
  @override
  @JsonKey()
  List<CodeStub> get codes {
    if (_codes is EqualUnmodifiableListView) return _codes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_codes);
  }

  final List<Annotation> _notes;
  @override
  @JsonKey()
  List<Annotation> get notes {
    if (_notes is EqualUnmodifiableListView) return _notes;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_notes);
  }

  @override
  @JsonKey()
  final Range? age;

  /// Create a copy of ReferenceRange
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ReferenceRangeCopyWith<_ReferenceRange> get copyWith =>
      __$ReferenceRangeCopyWithImpl<_ReferenceRange>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ReferenceRange &&
            (identical(other.low, low) || other.low == low) &&
            (identical(other.high, high) || other.high == high) &&
            (identical(other.stringValue, stringValue) ||
                other.stringValue == stringValue) &&
            const DeepCollectionEquality().equals(other._tags, _tags) &&
            const DeepCollectionEquality().equals(other._codes, _codes) &&
            const DeepCollectionEquality().equals(other._notes, _notes) &&
            (identical(other.age, age) || other.age == age));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      low,
      high,
      stringValue,
      const DeepCollectionEquality().hash(_tags),
      const DeepCollectionEquality().hash(_codes),
      const DeepCollectionEquality().hash(_notes),
      age);

  @override
  String toString() {
    return 'ReferenceRange(low: $low, high: $high, stringValue: $stringValue, tags: $tags, codes: $codes, notes: $notes, age: $age)';
  }
}

/// @nodoc
abstract mixin class _$ReferenceRangeCopyWith<$Res>
    implements $ReferenceRangeCopyWith<$Res> {
  factory _$ReferenceRangeCopyWith(
          _ReferenceRange value, $Res Function(_ReferenceRange) _then) =
      __$ReferenceRangeCopyWithImpl;
  @override
  @useResult
  $Res call(
      {double? low,
      double? high,
      String? stringValue,
      List<CodeStub> tags,
      List<CodeStub> codes,
      List<Annotation> notes,
      Range? age});

  @override
  $RangeCopyWith<$Res>? get age;
}

/// @nodoc
class __$ReferenceRangeCopyWithImpl<$Res>
    implements _$ReferenceRangeCopyWith<$Res> {
  __$ReferenceRangeCopyWithImpl(this._self, this._then);

  final _ReferenceRange _self;
  final $Res Function(_ReferenceRange) _then;

  /// Create a copy of ReferenceRange
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? low = freezed,
    Object? high = freezed,
    Object? stringValue = freezed,
    Object? tags = null,
    Object? codes = null,
    Object? notes = null,
    Object? age = freezed,
  }) {
    return _then(_ReferenceRange(
      low: freezed == low
          ? _self.low
          : low // ignore: cast_nullable_to_non_nullable
              as double?,
      high: freezed == high
          ? _self.high
          : high // ignore: cast_nullable_to_non_nullable
              as double?,
      stringValue: freezed == stringValue
          ? _self.stringValue
          : stringValue // ignore: cast_nullable_to_non_nullable
              as String?,
      tags: null == tags
          ? _self._tags
          : tags // ignore: cast_nullable_to_non_nullable
              as List<CodeStub>,
      codes: null == codes
          ? _self._codes
          : codes // ignore: cast_nullable_to_non_nullable
              as List<CodeStub>,
      notes: null == notes
          ? _self._notes
          : notes // ignore: cast_nullable_to_non_nullable
              as List<Annotation>,
      age: freezed == age
          ? _self.age
          : age // ignore: cast_nullable_to_non_nullable
              as Range?,
    ));
  }

  /// Create a copy of ReferenceRange
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $RangeCopyWith<$Res>? get age {
    if (_self.age == null) {
      return null;
    }

    return $RangeCopyWith<$Res>(_self.age!, (value) {
      return _then(_self.copyWith(age: value));
    });
  }
}

// dart format on
