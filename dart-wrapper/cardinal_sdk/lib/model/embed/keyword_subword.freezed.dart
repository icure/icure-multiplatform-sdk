// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'keyword_subword.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$KeywordSubword {
  String? get value;
  List<KeywordSubword>? get subWords;

  /// Create a copy of KeywordSubword
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $KeywordSubwordCopyWith<KeywordSubword> get copyWith =>
      _$KeywordSubwordCopyWithImpl<KeywordSubword>(
          this as KeywordSubword, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is KeywordSubword &&
            (identical(other.value, value) || other.value == value) &&
            const DeepCollectionEquality().equals(other.subWords, subWords));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, value, const DeepCollectionEquality().hash(subWords));

  @override
  String toString() {
    return 'KeywordSubword(value: $value, subWords: $subWords)';
  }
}

/// @nodoc
abstract mixin class $KeywordSubwordCopyWith<$Res> {
  factory $KeywordSubwordCopyWith(
          KeywordSubword value, $Res Function(KeywordSubword) _then) =
      _$KeywordSubwordCopyWithImpl;
  @useResult
  $Res call({String? value, List<KeywordSubword>? subWords});
}

/// @nodoc
class _$KeywordSubwordCopyWithImpl<$Res>
    implements $KeywordSubwordCopyWith<$Res> {
  _$KeywordSubwordCopyWithImpl(this._self, this._then);

  final KeywordSubword _self;
  final $Res Function(KeywordSubword) _then;

  /// Create a copy of KeywordSubword
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? value = freezed,
    Object? subWords = freezed,
  }) {
    return _then(_self.copyWith(
      value: freezed == value
          ? _self.value
          : value // ignore: cast_nullable_to_non_nullable
              as String?,
      subWords: freezed == subWords
          ? _self.subWords
          : subWords // ignore: cast_nullable_to_non_nullable
              as List<KeywordSubword>?,
    ));
  }
}

/// @nodoc

class _KeywordSubword implements KeywordSubword {
  const _KeywordSubword(
      {this.value = null, final List<KeywordSubword>? subWords = null})
      : _subWords = subWords;

  @override
  @JsonKey()
  final String? value;
  final List<KeywordSubword>? _subWords;
  @override
  @JsonKey()
  List<KeywordSubword>? get subWords {
    final value = _subWords;
    if (value == null) return null;
    if (_subWords is EqualUnmodifiableListView) return _subWords;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(value);
  }

  /// Create a copy of KeywordSubword
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$KeywordSubwordCopyWith<_KeywordSubword> get copyWith =>
      __$KeywordSubwordCopyWithImpl<_KeywordSubword>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _KeywordSubword &&
            (identical(other.value, value) || other.value == value) &&
            const DeepCollectionEquality().equals(other._subWords, _subWords));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, value, const DeepCollectionEquality().hash(_subWords));

  @override
  String toString() {
    return 'KeywordSubword(value: $value, subWords: $subWords)';
  }
}

/// @nodoc
abstract mixin class _$KeywordSubwordCopyWith<$Res>
    implements $KeywordSubwordCopyWith<$Res> {
  factory _$KeywordSubwordCopyWith(
          _KeywordSubword value, $Res Function(_KeywordSubword) _then) =
      __$KeywordSubwordCopyWithImpl;
  @override
  @useResult
  $Res call({String? value, List<KeywordSubword>? subWords});
}

/// @nodoc
class __$KeywordSubwordCopyWithImpl<$Res>
    implements _$KeywordSubwordCopyWith<$Res> {
  __$KeywordSubwordCopyWithImpl(this._self, this._then);

  final _KeywordSubword _self;
  final $Res Function(_KeywordSubword) _then;

  /// Create a copy of KeywordSubword
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? value = freezed,
    Object? subWords = freezed,
  }) {
    return _then(_KeywordSubword(
      value: freezed == value
          ? _self.value
          : value // ignore: cast_nullable_to_non_nullable
              as String?,
      subWords: freezed == subWords
          ? _self._subWords
          : subWords // ignore: cast_nullable_to_non_nullable
              as List<KeywordSubword>?,
    ));
  }
}

// dart format on
