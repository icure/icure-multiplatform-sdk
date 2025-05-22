// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'key_pair_update_notification.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$KeyPairUpdateNotification {
  CardinalRsaPublicKey get newPublicKey;
  String get concernedDataOwnerId;

  /// Create a copy of KeyPairUpdateNotification
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $KeyPairUpdateNotificationCopyWith<KeyPairUpdateNotification> get copyWith =>
      _$KeyPairUpdateNotificationCopyWithImpl<KeyPairUpdateNotification>(
          this as KeyPairUpdateNotification, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is KeyPairUpdateNotification &&
            (identical(other.newPublicKey, newPublicKey) ||
                other.newPublicKey == newPublicKey) &&
            (identical(other.concernedDataOwnerId, concernedDataOwnerId) ||
                other.concernedDataOwnerId == concernedDataOwnerId));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, newPublicKey, concernedDataOwnerId);

  @override
  String toString() {
    return 'KeyPairUpdateNotification(newPublicKey: $newPublicKey, concernedDataOwnerId: $concernedDataOwnerId)';
  }
}

/// @nodoc
abstract mixin class $KeyPairUpdateNotificationCopyWith<$Res> {
  factory $KeyPairUpdateNotificationCopyWith(KeyPairUpdateNotification value,
          $Res Function(KeyPairUpdateNotification) _then) =
      _$KeyPairUpdateNotificationCopyWithImpl;
  @useResult
  $Res call({CardinalRsaPublicKey newPublicKey, String concernedDataOwnerId});
}

/// @nodoc
class _$KeyPairUpdateNotificationCopyWithImpl<$Res>
    implements $KeyPairUpdateNotificationCopyWith<$Res> {
  _$KeyPairUpdateNotificationCopyWithImpl(this._self, this._then);

  final KeyPairUpdateNotification _self;
  final $Res Function(KeyPairUpdateNotification) _then;

  /// Create a copy of KeyPairUpdateNotification
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? newPublicKey = null,
    Object? concernedDataOwnerId = null,
  }) {
    return _then(_self.copyWith(
      newPublicKey: null == newPublicKey
          ? _self.newPublicKey
          : newPublicKey // ignore: cast_nullable_to_non_nullable
              as CardinalRsaPublicKey,
      concernedDataOwnerId: null == concernedDataOwnerId
          ? _self.concernedDataOwnerId
          : concernedDataOwnerId // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc

class _KeyPairUpdateNotification implements KeyPairUpdateNotification {
  const _KeyPairUpdateNotification(
      {required this.newPublicKey, required this.concernedDataOwnerId});

  @override
  final CardinalRsaPublicKey newPublicKey;
  @override
  final String concernedDataOwnerId;

  /// Create a copy of KeyPairUpdateNotification
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$KeyPairUpdateNotificationCopyWith<_KeyPairUpdateNotification>
      get copyWith =>
          __$KeyPairUpdateNotificationCopyWithImpl<_KeyPairUpdateNotification>(
              this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _KeyPairUpdateNotification &&
            (identical(other.newPublicKey, newPublicKey) ||
                other.newPublicKey == newPublicKey) &&
            (identical(other.concernedDataOwnerId, concernedDataOwnerId) ||
                other.concernedDataOwnerId == concernedDataOwnerId));
  }

  @override
  int get hashCode =>
      Object.hash(runtimeType, newPublicKey, concernedDataOwnerId);

  @override
  String toString() {
    return 'KeyPairUpdateNotification(newPublicKey: $newPublicKey, concernedDataOwnerId: $concernedDataOwnerId)';
  }
}

/// @nodoc
abstract mixin class _$KeyPairUpdateNotificationCopyWith<$Res>
    implements $KeyPairUpdateNotificationCopyWith<$Res> {
  factory _$KeyPairUpdateNotificationCopyWith(_KeyPairUpdateNotification value,
          $Res Function(_KeyPairUpdateNotification) _then) =
      __$KeyPairUpdateNotificationCopyWithImpl;
  @override
  @useResult
  $Res call({CardinalRsaPublicKey newPublicKey, String concernedDataOwnerId});
}

/// @nodoc
class __$KeyPairUpdateNotificationCopyWithImpl<$Res>
    implements _$KeyPairUpdateNotificationCopyWith<$Res> {
  __$KeyPairUpdateNotificationCopyWithImpl(this._self, this._then);

  final _KeyPairUpdateNotification _self;
  final $Res Function(_KeyPairUpdateNotification) _then;

  /// Create a copy of KeyPairUpdateNotification
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? newPublicKey = null,
    Object? concernedDataOwnerId = null,
  }) {
    return _then(_KeyPairUpdateNotification(
      newPublicKey: null == newPublicKey
          ? _self.newPublicKey
          : newPublicKey // ignore: cast_nullable_to_non_nullable
              as CardinalRsaPublicKey,
      concernedDataOwnerId: null == concernedDataOwnerId
          ? _self.concernedDataOwnerId
          : concernedDataOwnerId // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

// dart format on
