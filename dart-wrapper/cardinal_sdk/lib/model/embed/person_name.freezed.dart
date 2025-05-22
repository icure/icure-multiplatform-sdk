// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'person_name.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$PersonName {
  String? get lastName;
  List<String> get firstNames;
  int? get start;
  int? get end;
  List<String> get prefix;
  List<String> get suffix;
  String? get text;
  PersonNameUse? get use;

  /// Create a copy of PersonName
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $PersonNameCopyWith<PersonName> get copyWith =>
      _$PersonNameCopyWithImpl<PersonName>(this as PersonName, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is PersonName &&
            (identical(other.lastName, lastName) ||
                other.lastName == lastName) &&
            const DeepCollectionEquality()
                .equals(other.firstNames, firstNames) &&
            (identical(other.start, start) || other.start == start) &&
            (identical(other.end, end) || other.end == end) &&
            const DeepCollectionEquality().equals(other.prefix, prefix) &&
            const DeepCollectionEquality().equals(other.suffix, suffix) &&
            (identical(other.text, text) || other.text == text) &&
            (identical(other.use, use) || other.use == use));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      lastName,
      const DeepCollectionEquality().hash(firstNames),
      start,
      end,
      const DeepCollectionEquality().hash(prefix),
      const DeepCollectionEquality().hash(suffix),
      text,
      use);

  @override
  String toString() {
    return 'PersonName(lastName: $lastName, firstNames: $firstNames, start: $start, end: $end, prefix: $prefix, suffix: $suffix, text: $text, use: $use)';
  }
}

/// @nodoc
abstract mixin class $PersonNameCopyWith<$Res> {
  factory $PersonNameCopyWith(
          PersonName value, $Res Function(PersonName) _then) =
      _$PersonNameCopyWithImpl;
  @useResult
  $Res call(
      {String? lastName,
      List<String> firstNames,
      int? start,
      int? end,
      List<String> prefix,
      List<String> suffix,
      String? text,
      PersonNameUse? use});
}

/// @nodoc
class _$PersonNameCopyWithImpl<$Res> implements $PersonNameCopyWith<$Res> {
  _$PersonNameCopyWithImpl(this._self, this._then);

  final PersonName _self;
  final $Res Function(PersonName) _then;

  /// Create a copy of PersonName
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? lastName = freezed,
    Object? firstNames = null,
    Object? start = freezed,
    Object? end = freezed,
    Object? prefix = null,
    Object? suffix = null,
    Object? text = freezed,
    Object? use = freezed,
  }) {
    return _then(_self.copyWith(
      lastName: freezed == lastName
          ? _self.lastName
          : lastName // ignore: cast_nullable_to_non_nullable
              as String?,
      firstNames: null == firstNames
          ? _self.firstNames
          : firstNames // ignore: cast_nullable_to_non_nullable
              as List<String>,
      start: freezed == start
          ? _self.start
          : start // ignore: cast_nullable_to_non_nullable
              as int?,
      end: freezed == end
          ? _self.end
          : end // ignore: cast_nullable_to_non_nullable
              as int?,
      prefix: null == prefix
          ? _self.prefix
          : prefix // ignore: cast_nullable_to_non_nullable
              as List<String>,
      suffix: null == suffix
          ? _self.suffix
          : suffix // ignore: cast_nullable_to_non_nullable
              as List<String>,
      text: freezed == text
          ? _self.text
          : text // ignore: cast_nullable_to_non_nullable
              as String?,
      use: freezed == use
          ? _self.use
          : use // ignore: cast_nullable_to_non_nullable
              as PersonNameUse?,
    ));
  }
}

/// @nodoc

class _PersonName implements PersonName {
  const _PersonName(
      {this.lastName = null,
      final List<String> firstNames = const [],
      this.start = null,
      this.end = null,
      final List<String> prefix = const [],
      final List<String> suffix = const [],
      this.text = null,
      this.use = null})
      : _firstNames = firstNames,
        _prefix = prefix,
        _suffix = suffix;

  @override
  @JsonKey()
  final String? lastName;
  final List<String> _firstNames;
  @override
  @JsonKey()
  List<String> get firstNames {
    if (_firstNames is EqualUnmodifiableListView) return _firstNames;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_firstNames);
  }

  @override
  @JsonKey()
  final int? start;
  @override
  @JsonKey()
  final int? end;
  final List<String> _prefix;
  @override
  @JsonKey()
  List<String> get prefix {
    if (_prefix is EqualUnmodifiableListView) return _prefix;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_prefix);
  }

  final List<String> _suffix;
  @override
  @JsonKey()
  List<String> get suffix {
    if (_suffix is EqualUnmodifiableListView) return _suffix;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_suffix);
  }

  @override
  @JsonKey()
  final String? text;
  @override
  @JsonKey()
  final PersonNameUse? use;

  /// Create a copy of PersonName
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$PersonNameCopyWith<_PersonName> get copyWith =>
      __$PersonNameCopyWithImpl<_PersonName>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _PersonName &&
            (identical(other.lastName, lastName) ||
                other.lastName == lastName) &&
            const DeepCollectionEquality()
                .equals(other._firstNames, _firstNames) &&
            (identical(other.start, start) || other.start == start) &&
            (identical(other.end, end) || other.end == end) &&
            const DeepCollectionEquality().equals(other._prefix, _prefix) &&
            const DeepCollectionEquality().equals(other._suffix, _suffix) &&
            (identical(other.text, text) || other.text == text) &&
            (identical(other.use, use) || other.use == use));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      lastName,
      const DeepCollectionEquality().hash(_firstNames),
      start,
      end,
      const DeepCollectionEquality().hash(_prefix),
      const DeepCollectionEquality().hash(_suffix),
      text,
      use);

  @override
  String toString() {
    return 'PersonName(lastName: $lastName, firstNames: $firstNames, start: $start, end: $end, prefix: $prefix, suffix: $suffix, text: $text, use: $use)';
  }
}

/// @nodoc
abstract mixin class _$PersonNameCopyWith<$Res>
    implements $PersonNameCopyWith<$Res> {
  factory _$PersonNameCopyWith(
          _PersonName value, $Res Function(_PersonName) _then) =
      __$PersonNameCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String? lastName,
      List<String> firstNames,
      int? start,
      int? end,
      List<String> prefix,
      List<String> suffix,
      String? text,
      PersonNameUse? use});
}

/// @nodoc
class __$PersonNameCopyWithImpl<$Res> implements _$PersonNameCopyWith<$Res> {
  __$PersonNameCopyWithImpl(this._self, this._then);

  final _PersonName _self;
  final $Res Function(_PersonName) _then;

  /// Create a copy of PersonName
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? lastName = freezed,
    Object? firstNames = null,
    Object? start = freezed,
    Object? end = freezed,
    Object? prefix = null,
    Object? suffix = null,
    Object? text = freezed,
    Object? use = freezed,
  }) {
    return _then(_PersonName(
      lastName: freezed == lastName
          ? _self.lastName
          : lastName // ignore: cast_nullable_to_non_nullable
              as String?,
      firstNames: null == firstNames
          ? _self._firstNames
          : firstNames // ignore: cast_nullable_to_non_nullable
              as List<String>,
      start: freezed == start
          ? _self.start
          : start // ignore: cast_nullable_to_non_nullable
              as int?,
      end: freezed == end
          ? _self.end
          : end // ignore: cast_nullable_to_non_nullable
              as int?,
      prefix: null == prefix
          ? _self._prefix
          : prefix // ignore: cast_nullable_to_non_nullable
              as List<String>,
      suffix: null == suffix
          ? _self._suffix
          : suffix // ignore: cast_nullable_to_non_nullable
              as List<String>,
      text: freezed == text
          ? _self.text
          : text // ignore: cast_nullable_to_non_nullable
              as String?,
      use: freezed == use
          ? _self.use
          : use // ignore: cast_nullable_to_non_nullable
              as PersonNameUse?,
    ));
  }
}

// dart format on
