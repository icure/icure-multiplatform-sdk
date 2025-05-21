// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'right.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Right {
  String? get userId;
  bool get read;
  bool get write;
  bool get administration;

  /// Create a copy of Right
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $RightCopyWith<Right> get copyWith =>
      _$RightCopyWithImpl<Right>(this as Right, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Right &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.read, read) || other.read == read) &&
            (identical(other.write, write) || other.write == write) &&
            (identical(other.administration, administration) ||
                other.administration == administration));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, userId, read, write, administration);

  @override
  String toString() {
    return 'Right(userId: $userId, read: $read, write: $write, administration: $administration)';
  }
}

/// @nodoc
abstract mixin class $RightCopyWith<$Res> {
  factory $RightCopyWith(Right value, $Res Function(Right) _then) =
      _$RightCopyWithImpl;
  @useResult
  $Res call({String? userId, bool read, bool write, bool administration});
}

/// @nodoc
class _$RightCopyWithImpl<$Res> implements $RightCopyWith<$Res> {
  _$RightCopyWithImpl(this._self, this._then);

  final Right _self;
  final $Res Function(Right) _then;

  /// Create a copy of Right
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? userId = freezed,
    Object? read = null,
    Object? write = null,
    Object? administration = null,
  }) {
    return _then(_self.copyWith(
      userId: freezed == userId
          ? _self.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String?,
      read: null == read
          ? _self.read
          : read // ignore: cast_nullable_to_non_nullable
              as bool,
      write: null == write
          ? _self.write
          : write // ignore: cast_nullable_to_non_nullable
              as bool,
      administration: null == administration
          ? _self.administration
          : administration // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }
}

/// @nodoc

class _Right implements Right {
  const _Right(
      {this.userId = null,
      this.read = false,
      this.write = false,
      this.administration = false});

  @override
  @JsonKey()
  final String? userId;
  @override
  @JsonKey()
  final bool read;
  @override
  @JsonKey()
  final bool write;
  @override
  @JsonKey()
  final bool administration;

  /// Create a copy of Right
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$RightCopyWith<_Right> get copyWith =>
      __$RightCopyWithImpl<_Right>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Right &&
            (identical(other.userId, userId) || other.userId == userId) &&
            (identical(other.read, read) || other.read == read) &&
            (identical(other.write, write) || other.write == write) &&
            (identical(other.administration, administration) ||
                other.administration == administration));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, userId, read, write, administration);

  @override
  String toString() {
    return 'Right(userId: $userId, read: $read, write: $write, administration: $administration)';
  }
}

/// @nodoc
abstract mixin class _$RightCopyWith<$Res> implements $RightCopyWith<$Res> {
  factory _$RightCopyWith(_Right value, $Res Function(_Right) _then) =
      __$RightCopyWithImpl;
  @override
  @useResult
  $Res call({String? userId, bool read, bool write, bool administration});
}

/// @nodoc
class __$RightCopyWithImpl<$Res> implements _$RightCopyWith<$Res> {
  __$RightCopyWithImpl(this._self, this._then);

  final _Right _self;
  final $Res Function(_Right) _then;

  /// Create a copy of Right
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? userId = freezed,
    Object? read = null,
    Object? write = null,
    Object? administration = null,
  }) {
    return _then(_Right(
      userId: freezed == userId
          ? _self.userId
          : userId // ignore: cast_nullable_to_non_nullable
              as String?,
      read: null == read
          ? _self.read
          : read // ignore: cast_nullable_to_non_nullable
              as bool,
      write: null == write
          ? _self.write
          : write // ignore: cast_nullable_to_non_nullable
              as bool,
      administration: null == administration
          ? _self.administration
          : administration // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }
}

// dart format on
