// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'message_read_status.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$MessageReadStatus {
  int? get time;
  bool get read;

  /// Create a copy of MessageReadStatus
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $MessageReadStatusCopyWith<MessageReadStatus> get copyWith =>
      _$MessageReadStatusCopyWithImpl<MessageReadStatus>(
          this as MessageReadStatus, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is MessageReadStatus &&
            (identical(other.time, time) || other.time == time) &&
            (identical(other.read, read) || other.read == read));
  }

  @override
  int get hashCode => Object.hash(runtimeType, time, read);

  @override
  String toString() {
    return 'MessageReadStatus(time: $time, read: $read)';
  }
}

/// @nodoc
abstract mixin class $MessageReadStatusCopyWith<$Res> {
  factory $MessageReadStatusCopyWith(
          MessageReadStatus value, $Res Function(MessageReadStatus) _then) =
      _$MessageReadStatusCopyWithImpl;
  @useResult
  $Res call({int? time, bool read});
}

/// @nodoc
class _$MessageReadStatusCopyWithImpl<$Res>
    implements $MessageReadStatusCopyWith<$Res> {
  _$MessageReadStatusCopyWithImpl(this._self, this._then);

  final MessageReadStatus _self;
  final $Res Function(MessageReadStatus) _then;

  /// Create a copy of MessageReadStatus
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? time = freezed,
    Object? read = null,
  }) {
    return _then(_self.copyWith(
      time: freezed == time
          ? _self.time
          : time // ignore: cast_nullable_to_non_nullable
              as int?,
      read: null == read
          ? _self.read
          : read // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }
}

/// @nodoc

class _MessageReadStatus implements MessageReadStatus {
  const _MessageReadStatus({this.time = null, this.read = false});

  @override
  @JsonKey()
  final int? time;
  @override
  @JsonKey()
  final bool read;

  /// Create a copy of MessageReadStatus
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$MessageReadStatusCopyWith<_MessageReadStatus> get copyWith =>
      __$MessageReadStatusCopyWithImpl<_MessageReadStatus>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _MessageReadStatus &&
            (identical(other.time, time) || other.time == time) &&
            (identical(other.read, read) || other.read == read));
  }

  @override
  int get hashCode => Object.hash(runtimeType, time, read);

  @override
  String toString() {
    return 'MessageReadStatus(time: $time, read: $read)';
  }
}

/// @nodoc
abstract mixin class _$MessageReadStatusCopyWith<$Res>
    implements $MessageReadStatusCopyWith<$Res> {
  factory _$MessageReadStatusCopyWith(
          _MessageReadStatus value, $Res Function(_MessageReadStatus) _then) =
      __$MessageReadStatusCopyWithImpl;
  @override
  @useResult
  $Res call({int? time, bool read});
}

/// @nodoc
class __$MessageReadStatusCopyWithImpl<$Res>
    implements _$MessageReadStatusCopyWith<$Res> {
  __$MessageReadStatusCopyWithImpl(this._self, this._then);

  final _MessageReadStatus _self;
  final $Res Function(_MessageReadStatus) _then;

  /// Create a copy of MessageReadStatus
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? time = freezed,
    Object? read = null,
  }) {
    return _then(_MessageReadStatus(
      time: freezed == time
          ? _self.time
          : time // ignore: cast_nullable_to_non_nullable
              as int?,
      read: null == read
          ? _self.read
          : read // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }
}

// dart format on
