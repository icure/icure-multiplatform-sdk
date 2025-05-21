// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'failed_request_details.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$FailedRequestDetails {
  String get entityId;
  EntityReferenceInGroup get delegateReference;
  bool get updatedForMigration;
  int? get code;
  String? get reason;
  DelegateShareOptions? get request;
  bool get shouldRetry;

  /// Create a copy of FailedRequestDetails
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $FailedRequestDetailsCopyWith<FailedRequestDetails> get copyWith =>
      _$FailedRequestDetailsCopyWithImpl<FailedRequestDetails>(
          this as FailedRequestDetails, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is FailedRequestDetails &&
            (identical(other.entityId, entityId) ||
                other.entityId == entityId) &&
            (identical(other.delegateReference, delegateReference) ||
                other.delegateReference == delegateReference) &&
            (identical(other.updatedForMigration, updatedForMigration) ||
                other.updatedForMigration == updatedForMigration) &&
            (identical(other.code, code) || other.code == code) &&
            (identical(other.reason, reason) || other.reason == reason) &&
            (identical(other.request, request) || other.request == request) &&
            (identical(other.shouldRetry, shouldRetry) ||
                other.shouldRetry == shouldRetry));
  }

  @override
  int get hashCode => Object.hash(runtimeType, entityId, delegateReference,
      updatedForMigration, code, reason, request, shouldRetry);

  @override
  String toString() {
    return 'FailedRequestDetails(entityId: $entityId, delegateReference: $delegateReference, updatedForMigration: $updatedForMigration, code: $code, reason: $reason, request: $request, shouldRetry: $shouldRetry)';
  }
}

/// @nodoc
abstract mixin class $FailedRequestDetailsCopyWith<$Res> {
  factory $FailedRequestDetailsCopyWith(FailedRequestDetails value,
          $Res Function(FailedRequestDetails) _then) =
      _$FailedRequestDetailsCopyWithImpl;
  @useResult
  $Res call(
      {String entityId,
      EntityReferenceInGroup delegateReference,
      bool updatedForMigration,
      int? code,
      String? reason,
      DelegateShareOptions? request,
      bool shouldRetry});

  $EntityReferenceInGroupCopyWith<$Res> get delegateReference;
  $DelegateShareOptionsCopyWith<$Res>? get request;
}

/// @nodoc
class _$FailedRequestDetailsCopyWithImpl<$Res>
    implements $FailedRequestDetailsCopyWith<$Res> {
  _$FailedRequestDetailsCopyWithImpl(this._self, this._then);

  final FailedRequestDetails _self;
  final $Res Function(FailedRequestDetails) _then;

  /// Create a copy of FailedRequestDetails
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? entityId = null,
    Object? delegateReference = null,
    Object? updatedForMigration = null,
    Object? code = freezed,
    Object? reason = freezed,
    Object? request = freezed,
    Object? shouldRetry = null,
  }) {
    return _then(_self.copyWith(
      entityId: null == entityId
          ? _self.entityId
          : entityId // ignore: cast_nullable_to_non_nullable
              as String,
      delegateReference: null == delegateReference
          ? _self.delegateReference
          : delegateReference // ignore: cast_nullable_to_non_nullable
              as EntityReferenceInGroup,
      updatedForMigration: null == updatedForMigration
          ? _self.updatedForMigration
          : updatedForMigration // ignore: cast_nullable_to_non_nullable
              as bool,
      code: freezed == code
          ? _self.code
          : code // ignore: cast_nullable_to_non_nullable
              as int?,
      reason: freezed == reason
          ? _self.reason
          : reason // ignore: cast_nullable_to_non_nullable
              as String?,
      request: freezed == request
          ? _self.request
          : request // ignore: cast_nullable_to_non_nullable
              as DelegateShareOptions?,
      shouldRetry: null == shouldRetry
          ? _self.shouldRetry
          : shouldRetry // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }

  /// Create a copy of FailedRequestDetails
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $EntityReferenceInGroupCopyWith<$Res> get delegateReference {
    return $EntityReferenceInGroupCopyWith<$Res>(_self.delegateReference,
        (value) {
      return _then(_self.copyWith(delegateReference: value));
    });
  }

  /// Create a copy of FailedRequestDetails
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $DelegateShareOptionsCopyWith<$Res>? get request {
    if (_self.request == null) {
      return null;
    }

    return $DelegateShareOptionsCopyWith<$Res>(_self.request!, (value) {
      return _then(_self.copyWith(request: value));
    });
  }
}

/// @nodoc

class _FailedRequestDetails implements FailedRequestDetails {
  const _FailedRequestDetails(
      {required this.entityId,
      required this.delegateReference,
      required this.updatedForMigration,
      required this.code,
      required this.reason,
      required this.request,
      required this.shouldRetry});

  @override
  final String entityId;
  @override
  final EntityReferenceInGroup delegateReference;
  @override
  final bool updatedForMigration;
  @override
  final int? code;
  @override
  final String? reason;
  @override
  final DelegateShareOptions? request;
  @override
  final bool shouldRetry;

  /// Create a copy of FailedRequestDetails
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$FailedRequestDetailsCopyWith<_FailedRequestDetails> get copyWith =>
      __$FailedRequestDetailsCopyWithImpl<_FailedRequestDetails>(
          this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _FailedRequestDetails &&
            (identical(other.entityId, entityId) ||
                other.entityId == entityId) &&
            (identical(other.delegateReference, delegateReference) ||
                other.delegateReference == delegateReference) &&
            (identical(other.updatedForMigration, updatedForMigration) ||
                other.updatedForMigration == updatedForMigration) &&
            (identical(other.code, code) || other.code == code) &&
            (identical(other.reason, reason) || other.reason == reason) &&
            (identical(other.request, request) || other.request == request) &&
            (identical(other.shouldRetry, shouldRetry) ||
                other.shouldRetry == shouldRetry));
  }

  @override
  int get hashCode => Object.hash(runtimeType, entityId, delegateReference,
      updatedForMigration, code, reason, request, shouldRetry);

  @override
  String toString() {
    return 'FailedRequestDetails(entityId: $entityId, delegateReference: $delegateReference, updatedForMigration: $updatedForMigration, code: $code, reason: $reason, request: $request, shouldRetry: $shouldRetry)';
  }
}

/// @nodoc
abstract mixin class _$FailedRequestDetailsCopyWith<$Res>
    implements $FailedRequestDetailsCopyWith<$Res> {
  factory _$FailedRequestDetailsCopyWith(_FailedRequestDetails value,
          $Res Function(_FailedRequestDetails) _then) =
      __$FailedRequestDetailsCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String entityId,
      EntityReferenceInGroup delegateReference,
      bool updatedForMigration,
      int? code,
      String? reason,
      DelegateShareOptions? request,
      bool shouldRetry});

  @override
  $EntityReferenceInGroupCopyWith<$Res> get delegateReference;
  @override
  $DelegateShareOptionsCopyWith<$Res>? get request;
}

/// @nodoc
class __$FailedRequestDetailsCopyWithImpl<$Res>
    implements _$FailedRequestDetailsCopyWith<$Res> {
  __$FailedRequestDetailsCopyWithImpl(this._self, this._then);

  final _FailedRequestDetails _self;
  final $Res Function(_FailedRequestDetails) _then;

  /// Create a copy of FailedRequestDetails
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? entityId = null,
    Object? delegateReference = null,
    Object? updatedForMigration = null,
    Object? code = freezed,
    Object? reason = freezed,
    Object? request = freezed,
    Object? shouldRetry = null,
  }) {
    return _then(_FailedRequestDetails(
      entityId: null == entityId
          ? _self.entityId
          : entityId // ignore: cast_nullable_to_non_nullable
              as String,
      delegateReference: null == delegateReference
          ? _self.delegateReference
          : delegateReference // ignore: cast_nullable_to_non_nullable
              as EntityReferenceInGroup,
      updatedForMigration: null == updatedForMigration
          ? _self.updatedForMigration
          : updatedForMigration // ignore: cast_nullable_to_non_nullable
              as bool,
      code: freezed == code
          ? _self.code
          : code // ignore: cast_nullable_to_non_nullable
              as int?,
      reason: freezed == reason
          ? _self.reason
          : reason // ignore: cast_nullable_to_non_nullable
              as String?,
      request: freezed == request
          ? _self.request
          : request // ignore: cast_nullable_to_non_nullable
              as DelegateShareOptions?,
      shouldRetry: null == shouldRetry
          ? _self.shouldRetry
          : shouldRetry // ignore: cast_nullable_to_non_nullable
              as bool,
    ));
  }

  /// Create a copy of FailedRequestDetails
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $EntityReferenceInGroupCopyWith<$Res> get delegateReference {
    return $EntityReferenceInGroupCopyWith<$Res>(_self.delegateReference,
        (value) {
      return _then(_self.copyWith(delegateReference: value));
    });
  }

  /// Create a copy of FailedRequestDetails
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $DelegateShareOptionsCopyWith<$Res>? get request {
    if (_self.request == null) {
      return null;
    }

    return $DelegateShareOptionsCopyWith<$Res>(_self.request!, (value) {
      return _then(_self.copyWith(request: value));
    });
  }
}

// dart format on
