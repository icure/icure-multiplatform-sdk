// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'entity_subscription_configuration.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$EntitySubscriptionConfiguration {
  int get channelBufferCapacity;
  EntitySubscriptionConfigurationFullBufferBehaviour get onBufferFull;
  Duration get reconnectionDelay;
  double get retryDelayExponentFactor;
  int get connectionMaxRetries;

  /// Create a copy of EntitySubscriptionConfiguration
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EntitySubscriptionConfigurationCopyWith<EntitySubscriptionConfiguration>
      get copyWith => _$EntitySubscriptionConfigurationCopyWithImpl<
              EntitySubscriptionConfiguration>(
          this as EntitySubscriptionConfiguration, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EntitySubscriptionConfiguration &&
            (identical(other.channelBufferCapacity, channelBufferCapacity) ||
                other.channelBufferCapacity == channelBufferCapacity) &&
            (identical(other.onBufferFull, onBufferFull) ||
                other.onBufferFull == onBufferFull) &&
            (identical(other.reconnectionDelay, reconnectionDelay) ||
                other.reconnectionDelay == reconnectionDelay) &&
            (identical(
                    other.retryDelayExponentFactor, retryDelayExponentFactor) ||
                other.retryDelayExponentFactor == retryDelayExponentFactor) &&
            (identical(other.connectionMaxRetries, connectionMaxRetries) ||
                other.connectionMaxRetries == connectionMaxRetries));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      channelBufferCapacity,
      onBufferFull,
      reconnectionDelay,
      retryDelayExponentFactor,
      connectionMaxRetries);

  @override
  String toString() {
    return 'EntitySubscriptionConfiguration(channelBufferCapacity: $channelBufferCapacity, onBufferFull: $onBufferFull, reconnectionDelay: $reconnectionDelay, retryDelayExponentFactor: $retryDelayExponentFactor, connectionMaxRetries: $connectionMaxRetries)';
  }
}

/// @nodoc
abstract mixin class $EntitySubscriptionConfigurationCopyWith<$Res> {
  factory $EntitySubscriptionConfigurationCopyWith(
          EntitySubscriptionConfiguration value,
          $Res Function(EntitySubscriptionConfiguration) _then) =
      _$EntitySubscriptionConfigurationCopyWithImpl;
  @useResult
  $Res call(
      {int channelBufferCapacity,
      EntitySubscriptionConfigurationFullBufferBehaviour onBufferFull,
      Duration reconnectionDelay,
      double retryDelayExponentFactor,
      int connectionMaxRetries});
}

/// @nodoc
class _$EntitySubscriptionConfigurationCopyWithImpl<$Res>
    implements $EntitySubscriptionConfigurationCopyWith<$Res> {
  _$EntitySubscriptionConfigurationCopyWithImpl(this._self, this._then);

  final EntitySubscriptionConfiguration _self;
  final $Res Function(EntitySubscriptionConfiguration) _then;

  /// Create a copy of EntitySubscriptionConfiguration
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? channelBufferCapacity = null,
    Object? onBufferFull = null,
    Object? reconnectionDelay = null,
    Object? retryDelayExponentFactor = null,
    Object? connectionMaxRetries = null,
  }) {
    return _then(_self.copyWith(
      channelBufferCapacity: null == channelBufferCapacity
          ? _self.channelBufferCapacity
          : channelBufferCapacity // ignore: cast_nullable_to_non_nullable
              as int,
      onBufferFull: null == onBufferFull
          ? _self.onBufferFull
          : onBufferFull // ignore: cast_nullable_to_non_nullable
              as EntitySubscriptionConfigurationFullBufferBehaviour,
      reconnectionDelay: null == reconnectionDelay
          ? _self.reconnectionDelay
          : reconnectionDelay // ignore: cast_nullable_to_non_nullable
              as Duration,
      retryDelayExponentFactor: null == retryDelayExponentFactor
          ? _self.retryDelayExponentFactor
          : retryDelayExponentFactor // ignore: cast_nullable_to_non_nullable
              as double,
      connectionMaxRetries: null == connectionMaxRetries
          ? _self.connectionMaxRetries
          : connectionMaxRetries // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }
}

/// @nodoc

class _EntitySubscriptionConfiguration
    implements EntitySubscriptionConfiguration {
  const _EntitySubscriptionConfiguration(
      {this.channelBufferCapacity = 100,
      this.onBufferFull =
          EntitySubscriptionConfigurationFullBufferBehaviour.close,
      this.reconnectionDelay = const Duration(seconds: 2),
      this.retryDelayExponentFactor = 2.0,
      this.connectionMaxRetries = 5});

  @override
  @JsonKey()
  final int channelBufferCapacity;
  @override
  @JsonKey()
  final EntitySubscriptionConfigurationFullBufferBehaviour onBufferFull;
  @override
  @JsonKey()
  final Duration reconnectionDelay;
  @override
  @JsonKey()
  final double retryDelayExponentFactor;
  @override
  @JsonKey()
  final int connectionMaxRetries;

  /// Create a copy of EntitySubscriptionConfiguration
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EntitySubscriptionConfigurationCopyWith<_EntitySubscriptionConfiguration>
      get copyWith => __$EntitySubscriptionConfigurationCopyWithImpl<
          _EntitySubscriptionConfiguration>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EntitySubscriptionConfiguration &&
            (identical(other.channelBufferCapacity, channelBufferCapacity) ||
                other.channelBufferCapacity == channelBufferCapacity) &&
            (identical(other.onBufferFull, onBufferFull) ||
                other.onBufferFull == onBufferFull) &&
            (identical(other.reconnectionDelay, reconnectionDelay) ||
                other.reconnectionDelay == reconnectionDelay) &&
            (identical(
                    other.retryDelayExponentFactor, retryDelayExponentFactor) ||
                other.retryDelayExponentFactor == retryDelayExponentFactor) &&
            (identical(other.connectionMaxRetries, connectionMaxRetries) ||
                other.connectionMaxRetries == connectionMaxRetries));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType,
      channelBufferCapacity,
      onBufferFull,
      reconnectionDelay,
      retryDelayExponentFactor,
      connectionMaxRetries);

  @override
  String toString() {
    return 'EntitySubscriptionConfiguration(channelBufferCapacity: $channelBufferCapacity, onBufferFull: $onBufferFull, reconnectionDelay: $reconnectionDelay, retryDelayExponentFactor: $retryDelayExponentFactor, connectionMaxRetries: $connectionMaxRetries)';
  }
}

/// @nodoc
abstract mixin class _$EntitySubscriptionConfigurationCopyWith<$Res>
    implements $EntitySubscriptionConfigurationCopyWith<$Res> {
  factory _$EntitySubscriptionConfigurationCopyWith(
          _EntitySubscriptionConfiguration value,
          $Res Function(_EntitySubscriptionConfiguration) _then) =
      __$EntitySubscriptionConfigurationCopyWithImpl;
  @override
  @useResult
  $Res call(
      {int channelBufferCapacity,
      EntitySubscriptionConfigurationFullBufferBehaviour onBufferFull,
      Duration reconnectionDelay,
      double retryDelayExponentFactor,
      int connectionMaxRetries});
}

/// @nodoc
class __$EntitySubscriptionConfigurationCopyWithImpl<$Res>
    implements _$EntitySubscriptionConfigurationCopyWith<$Res> {
  __$EntitySubscriptionConfigurationCopyWithImpl(this._self, this._then);

  final _EntitySubscriptionConfiguration _self;
  final $Res Function(_EntitySubscriptionConfiguration) _then;

  /// Create a copy of EntitySubscriptionConfiguration
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? channelBufferCapacity = null,
    Object? onBufferFull = null,
    Object? reconnectionDelay = null,
    Object? retryDelayExponentFactor = null,
    Object? connectionMaxRetries = null,
  }) {
    return _then(_EntitySubscriptionConfiguration(
      channelBufferCapacity: null == channelBufferCapacity
          ? _self.channelBufferCapacity
          : channelBufferCapacity // ignore: cast_nullable_to_non_nullable
              as int,
      onBufferFull: null == onBufferFull
          ? _self.onBufferFull
          : onBufferFull // ignore: cast_nullable_to_non_nullable
              as EntitySubscriptionConfigurationFullBufferBehaviour,
      reconnectionDelay: null == reconnectionDelay
          ? _self.reconnectionDelay
          : reconnectionDelay // ignore: cast_nullable_to_non_nullable
              as Duration,
      retryDelayExponentFactor: null == retryDelayExponentFactor
          ? _self.retryDelayExponentFactor
          : retryDelayExponentFactor // ignore: cast_nullable_to_non_nullable
              as double,
      connectionMaxRetries: null == connectionMaxRetries
          ? _self.connectionMaxRetries
          : connectionMaxRetries // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }
}

// dart format on
