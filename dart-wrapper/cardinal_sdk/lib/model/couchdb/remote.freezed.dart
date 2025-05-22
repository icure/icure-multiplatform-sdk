// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'remote.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Remote {
  String get url;
  RemoteAuthentication? get auth;

  /// Create a copy of Remote
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $RemoteCopyWith<Remote> get copyWith =>
      _$RemoteCopyWithImpl<Remote>(this as Remote, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Remote &&
            (identical(other.url, url) || other.url == url) &&
            (identical(other.auth, auth) || other.auth == auth));
  }

  @override
  int get hashCode => Object.hash(runtimeType, url, auth);

  @override
  String toString() {
    return 'Remote(url: $url, auth: $auth)';
  }
}

/// @nodoc
abstract mixin class $RemoteCopyWith<$Res> {
  factory $RemoteCopyWith(Remote value, $Res Function(Remote) _then) =
      _$RemoteCopyWithImpl;
  @useResult
  $Res call({String url, RemoteAuthentication? auth});

  $RemoteAuthenticationCopyWith<$Res>? get auth;
}

/// @nodoc
class _$RemoteCopyWithImpl<$Res> implements $RemoteCopyWith<$Res> {
  _$RemoteCopyWithImpl(this._self, this._then);

  final Remote _self;
  final $Res Function(Remote) _then;

  /// Create a copy of Remote
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? url = null,
    Object? auth = freezed,
  }) {
    return _then(_self.copyWith(
      url: null == url
          ? _self.url
          : url // ignore: cast_nullable_to_non_nullable
              as String,
      auth: freezed == auth
          ? _self.auth
          : auth // ignore: cast_nullable_to_non_nullable
              as RemoteAuthentication?,
    ));
  }

  /// Create a copy of Remote
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $RemoteAuthenticationCopyWith<$Res>? get auth {
    if (_self.auth == null) {
      return null;
    }

    return $RemoteAuthenticationCopyWith<$Res>(_self.auth!, (value) {
      return _then(_self.copyWith(auth: value));
    });
  }
}

/// @nodoc

class _Remote implements Remote {
  const _Remote({required this.url, this.auth = null});

  @override
  final String url;
  @override
  @JsonKey()
  final RemoteAuthentication? auth;

  /// Create a copy of Remote
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$RemoteCopyWith<_Remote> get copyWith =>
      __$RemoteCopyWithImpl<_Remote>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Remote &&
            (identical(other.url, url) || other.url == url) &&
            (identical(other.auth, auth) || other.auth == auth));
  }

  @override
  int get hashCode => Object.hash(runtimeType, url, auth);

  @override
  String toString() {
    return 'Remote(url: $url, auth: $auth)';
  }
}

/// @nodoc
abstract mixin class _$RemoteCopyWith<$Res> implements $RemoteCopyWith<$Res> {
  factory _$RemoteCopyWith(_Remote value, $Res Function(_Remote) _then) =
      __$RemoteCopyWithImpl;
  @override
  @useResult
  $Res call({String url, RemoteAuthentication? auth});

  @override
  $RemoteAuthenticationCopyWith<$Res>? get auth;
}

/// @nodoc
class __$RemoteCopyWithImpl<$Res> implements _$RemoteCopyWith<$Res> {
  __$RemoteCopyWithImpl(this._self, this._then);

  final _Remote _self;
  final $Res Function(_Remote) _then;

  /// Create a copy of Remote
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? url = null,
    Object? auth = freezed,
  }) {
    return _then(_Remote(
      url: null == url
          ? _self.url
          : url // ignore: cast_nullable_to_non_nullable
              as String,
      auth: freezed == auth
          ? _self.auth
          : auth // ignore: cast_nullable_to_non_nullable
              as RemoteAuthentication?,
    ));
  }

  /// Create a copy of Remote
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $RemoteAuthenticationCopyWith<$Res>? get auth {
    if (_self.auth == null) {
      return null;
    }

    return $RemoteAuthenticationCopyWith<$Res>(_self.auth!, (value) {
      return _then(_self.copyWith(auth: value));
    });
  }
}

// dart format on
