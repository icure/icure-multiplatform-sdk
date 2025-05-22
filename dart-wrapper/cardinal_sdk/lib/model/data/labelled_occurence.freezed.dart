// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'labelled_occurence.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$LabelledOccurence {
  String get label;
  int get occurence;

  /// Create a copy of LabelledOccurence
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $LabelledOccurenceCopyWith<LabelledOccurence> get copyWith =>
      _$LabelledOccurenceCopyWithImpl<LabelledOccurence>(
          this as LabelledOccurence, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is LabelledOccurence &&
            (identical(other.label, label) || other.label == label) &&
            (identical(other.occurence, occurence) ||
                other.occurence == occurence));
  }

  @override
  int get hashCode => Object.hash(runtimeType, label, occurence);

  @override
  String toString() {
    return 'LabelledOccurence(label: $label, occurence: $occurence)';
  }
}

/// @nodoc
abstract mixin class $LabelledOccurenceCopyWith<$Res> {
  factory $LabelledOccurenceCopyWith(
          LabelledOccurence value, $Res Function(LabelledOccurence) _then) =
      _$LabelledOccurenceCopyWithImpl;
  @useResult
  $Res call({String label, int occurence});
}

/// @nodoc
class _$LabelledOccurenceCopyWithImpl<$Res>
    implements $LabelledOccurenceCopyWith<$Res> {
  _$LabelledOccurenceCopyWithImpl(this._self, this._then);

  final LabelledOccurence _self;
  final $Res Function(LabelledOccurence) _then;

  /// Create a copy of LabelledOccurence
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? label = null,
    Object? occurence = null,
  }) {
    return _then(_self.copyWith(
      label: null == label
          ? _self.label
          : label // ignore: cast_nullable_to_non_nullable
              as String,
      occurence: null == occurence
          ? _self.occurence
          : occurence // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }
}

/// @nodoc

class _LabelledOccurence implements LabelledOccurence {
  const _LabelledOccurence({required this.label, required this.occurence});

  @override
  final String label;
  @override
  final int occurence;

  /// Create a copy of LabelledOccurence
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$LabelledOccurenceCopyWith<_LabelledOccurence> get copyWith =>
      __$LabelledOccurenceCopyWithImpl<_LabelledOccurence>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _LabelledOccurence &&
            (identical(other.label, label) || other.label == label) &&
            (identical(other.occurence, occurence) ||
                other.occurence == occurence));
  }

  @override
  int get hashCode => Object.hash(runtimeType, label, occurence);

  @override
  String toString() {
    return 'LabelledOccurence(label: $label, occurence: $occurence)';
  }
}

/// @nodoc
abstract mixin class _$LabelledOccurenceCopyWith<$Res>
    implements $LabelledOccurenceCopyWith<$Res> {
  factory _$LabelledOccurenceCopyWith(
          _LabelledOccurence value, $Res Function(_LabelledOccurence) _then) =
      __$LabelledOccurenceCopyWithImpl;
  @override
  @useResult
  $Res call({String label, int occurence});
}

/// @nodoc
class __$LabelledOccurenceCopyWithImpl<$Res>
    implements _$LabelledOccurenceCopyWith<$Res> {
  __$LabelledOccurenceCopyWithImpl(this._self, this._then);

  final _LabelledOccurence _self;
  final $Res Function(_LabelledOccurence) _then;

  /// Create a copy of LabelledOccurence
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? label = null,
    Object? occurence = null,
  }) {
    return _then(_LabelledOccurence(
      label: null == label
          ? _self.label
          : label // ignore: cast_nullable_to_non_nullable
              as String,
      occurence: null == occurence
          ? _self.occurence
          : occurence // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }
}

// dart format on
