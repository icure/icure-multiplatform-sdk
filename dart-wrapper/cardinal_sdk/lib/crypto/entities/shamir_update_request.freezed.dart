// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'shamir_update_request.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$ShamirUpdateRequest {
  Set<String> get notariesIds;
  int get minShares;

  /// Create a copy of ShamirUpdateRequest
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ShamirUpdateRequestCopyWith<ShamirUpdateRequest> get copyWith =>
      _$ShamirUpdateRequestCopyWithImpl<ShamirUpdateRequest>(
          this as ShamirUpdateRequest, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ShamirUpdateRequest &&
            const DeepCollectionEquality()
                .equals(other.notariesIds, notariesIds) &&
            (identical(other.minShares, minShares) ||
                other.minShares == minShares));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, const DeepCollectionEquality().hash(notariesIds), minShares);

  @override
  String toString() {
    return 'ShamirUpdateRequest(notariesIds: $notariesIds, minShares: $minShares)';
  }
}

/// @nodoc
abstract mixin class $ShamirUpdateRequestCopyWith<$Res> {
  factory $ShamirUpdateRequestCopyWith(
          ShamirUpdateRequest value, $Res Function(ShamirUpdateRequest) _then) =
      _$ShamirUpdateRequestCopyWithImpl;
  @useResult
  $Res call({Set<String> notariesIds, int minShares});
}

/// @nodoc
class _$ShamirUpdateRequestCopyWithImpl<$Res>
    implements $ShamirUpdateRequestCopyWith<$Res> {
  _$ShamirUpdateRequestCopyWithImpl(this._self, this._then);

  final ShamirUpdateRequest _self;
  final $Res Function(ShamirUpdateRequest) _then;

  /// Create a copy of ShamirUpdateRequest
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? notariesIds = null,
    Object? minShares = null,
  }) {
    return _then(_self.copyWith(
      notariesIds: null == notariesIds
          ? _self.notariesIds
          : notariesIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      minShares: null == minShares
          ? _self.minShares
          : minShares // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }
}

/// @nodoc

class _ShamirUpdateRequest implements ShamirUpdateRequest {
  const _ShamirUpdateRequest(
      {required final Set<String> notariesIds, required this.minShares})
      : _notariesIds = notariesIds;

  final Set<String> _notariesIds;
  @override
  Set<String> get notariesIds {
    if (_notariesIds is EqualUnmodifiableSetView) return _notariesIds;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_notariesIds);
  }

  @override
  final int minShares;

  /// Create a copy of ShamirUpdateRequest
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ShamirUpdateRequestCopyWith<_ShamirUpdateRequest> get copyWith =>
      __$ShamirUpdateRequestCopyWithImpl<_ShamirUpdateRequest>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ShamirUpdateRequest &&
            const DeepCollectionEquality()
                .equals(other._notariesIds, _notariesIds) &&
            (identical(other.minShares, minShares) ||
                other.minShares == minShares));
  }

  @override
  int get hashCode => Object.hash(runtimeType,
      const DeepCollectionEquality().hash(_notariesIds), minShares);

  @override
  String toString() {
    return 'ShamirUpdateRequest(notariesIds: $notariesIds, minShares: $minShares)';
  }
}

/// @nodoc
abstract mixin class _$ShamirUpdateRequestCopyWith<$Res>
    implements $ShamirUpdateRequestCopyWith<$Res> {
  factory _$ShamirUpdateRequestCopyWith(_ShamirUpdateRequest value,
          $Res Function(_ShamirUpdateRequest) _then) =
      __$ShamirUpdateRequestCopyWithImpl;
  @override
  @useResult
  $Res call({Set<String> notariesIds, int minShares});
}

/// @nodoc
class __$ShamirUpdateRequestCopyWithImpl<$Res>
    implements _$ShamirUpdateRequestCopyWith<$Res> {
  __$ShamirUpdateRequestCopyWithImpl(this._self, this._then);

  final _ShamirUpdateRequest _self;
  final $Res Function(_ShamirUpdateRequest) _then;

  /// Create a copy of ShamirUpdateRequest
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? notariesIds = null,
    Object? minShares = null,
  }) {
    return _then(_ShamirUpdateRequest(
      notariesIds: null == notariesIds
          ? _self._notariesIds
          : notariesIds // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      minShares: null == minShares
          ? _self.minShares
          : minShares // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }
}

// dart format on
