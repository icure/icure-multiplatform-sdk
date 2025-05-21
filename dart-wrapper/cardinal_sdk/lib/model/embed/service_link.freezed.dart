// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'service_link.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$ServiceLink {
  String? get serviceId;

  /// Create a copy of ServiceLink
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ServiceLinkCopyWith<ServiceLink> get copyWith =>
      _$ServiceLinkCopyWithImpl<ServiceLink>(this as ServiceLink, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ServiceLink &&
            (identical(other.serviceId, serviceId) ||
                other.serviceId == serviceId));
  }

  @override
  int get hashCode => Object.hash(runtimeType, serviceId);

  @override
  String toString() {
    return 'ServiceLink(serviceId: $serviceId)';
  }
}

/// @nodoc
abstract mixin class $ServiceLinkCopyWith<$Res> {
  factory $ServiceLinkCopyWith(
          ServiceLink value, $Res Function(ServiceLink) _then) =
      _$ServiceLinkCopyWithImpl;
  @useResult
  $Res call({String? serviceId});
}

/// @nodoc
class _$ServiceLinkCopyWithImpl<$Res> implements $ServiceLinkCopyWith<$Res> {
  _$ServiceLinkCopyWithImpl(this._self, this._then);

  final ServiceLink _self;
  final $Res Function(ServiceLink) _then;

  /// Create a copy of ServiceLink
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? serviceId = freezed,
  }) {
    return _then(_self.copyWith(
      serviceId: freezed == serviceId
          ? _self.serviceId
          : serviceId // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _ServiceLink implements ServiceLink {
  const _ServiceLink({this.serviceId = null});

  @override
  @JsonKey()
  final String? serviceId;

  /// Create a copy of ServiceLink
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ServiceLinkCopyWith<_ServiceLink> get copyWith =>
      __$ServiceLinkCopyWithImpl<_ServiceLink>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ServiceLink &&
            (identical(other.serviceId, serviceId) ||
                other.serviceId == serviceId));
  }

  @override
  int get hashCode => Object.hash(runtimeType, serviceId);

  @override
  String toString() {
    return 'ServiceLink(serviceId: $serviceId)';
  }
}

/// @nodoc
abstract mixin class _$ServiceLinkCopyWith<$Res>
    implements $ServiceLinkCopyWith<$Res> {
  factory _$ServiceLinkCopyWith(
          _ServiceLink value, $Res Function(_ServiceLink) _then) =
      __$ServiceLinkCopyWithImpl;
  @override
  @useResult
  $Res call({String? serviceId});
}

/// @nodoc
class __$ServiceLinkCopyWithImpl<$Res> implements _$ServiceLinkCopyWith<$Res> {
  __$ServiceLinkCopyWithImpl(this._self, this._then);

  final _ServiceLink _self;
  final $Res Function(_ServiceLink) _then;

  /// Create a copy of ServiceLink
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? serviceId = freezed,
  }) {
    return _then(_ServiceLink(
      serviceId: freezed == serviceId
          ? _self.serviceId
          : serviceId // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

// dart format on
