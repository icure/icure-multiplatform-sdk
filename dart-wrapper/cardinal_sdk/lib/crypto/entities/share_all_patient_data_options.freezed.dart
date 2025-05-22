// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'share_all_patient_data_options.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$ShareAllPatientDataOptionsEntityResult {
  bool? get success;
  ShareAllPatientDataOptionsSharePatientDataError? get error;
  int get modified;

  /// Create a copy of ShareAllPatientDataOptionsEntityResult
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ShareAllPatientDataOptionsEntityResultCopyWith<
          ShareAllPatientDataOptionsEntityResult>
      get copyWith => _$ShareAllPatientDataOptionsEntityResultCopyWithImpl<
              ShareAllPatientDataOptionsEntityResult>(
          this as ShareAllPatientDataOptionsEntityResult, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ShareAllPatientDataOptionsEntityResult &&
            (identical(other.success, success) || other.success == success) &&
            (identical(other.error, error) || other.error == error) &&
            (identical(other.modified, modified) ||
                other.modified == modified));
  }

  @override
  int get hashCode => Object.hash(runtimeType, success, error, modified);

  @override
  String toString() {
    return 'ShareAllPatientDataOptionsEntityResult(success: $success, error: $error, modified: $modified)';
  }
}

/// @nodoc
abstract mixin class $ShareAllPatientDataOptionsEntityResultCopyWith<$Res> {
  factory $ShareAllPatientDataOptionsEntityResultCopyWith(
          ShareAllPatientDataOptionsEntityResult value,
          $Res Function(ShareAllPatientDataOptionsEntityResult) _then) =
      _$ShareAllPatientDataOptionsEntityResultCopyWithImpl;
  @useResult
  $Res call(
      {bool? success,
      ShareAllPatientDataOptionsSharePatientDataError? error,
      int modified});
}

/// @nodoc
class _$ShareAllPatientDataOptionsEntityResultCopyWithImpl<$Res>
    implements $ShareAllPatientDataOptionsEntityResultCopyWith<$Res> {
  _$ShareAllPatientDataOptionsEntityResultCopyWithImpl(this._self, this._then);

  final ShareAllPatientDataOptionsEntityResult _self;
  final $Res Function(ShareAllPatientDataOptionsEntityResult) _then;

  /// Create a copy of ShareAllPatientDataOptionsEntityResult
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? success = freezed,
    Object? error = freezed,
    Object? modified = null,
  }) {
    return _then(_self.copyWith(
      success: freezed == success
          ? _self.success
          : success // ignore: cast_nullable_to_non_nullable
              as bool?,
      error: freezed == error
          ? _self.error
          : error // ignore: cast_nullable_to_non_nullable
              as ShareAllPatientDataOptionsSharePatientDataError?,
      modified: null == modified
          ? _self.modified
          : modified // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }
}

/// @nodoc

class _ShareAllPatientDataOptionsEntityResult
    implements ShareAllPatientDataOptionsEntityResult {
  const _ShareAllPatientDataOptionsEntityResult(
      {this.success = null, this.error = null, required this.modified});

  @override
  @JsonKey()
  final bool? success;
  @override
  @JsonKey()
  final ShareAllPatientDataOptionsSharePatientDataError? error;
  @override
  final int modified;

  /// Create a copy of ShareAllPatientDataOptionsEntityResult
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ShareAllPatientDataOptionsEntityResultCopyWith<
          _ShareAllPatientDataOptionsEntityResult>
      get copyWith => __$ShareAllPatientDataOptionsEntityResultCopyWithImpl<
          _ShareAllPatientDataOptionsEntityResult>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ShareAllPatientDataOptionsEntityResult &&
            (identical(other.success, success) || other.success == success) &&
            (identical(other.error, error) || other.error == error) &&
            (identical(other.modified, modified) ||
                other.modified == modified));
  }

  @override
  int get hashCode => Object.hash(runtimeType, success, error, modified);

  @override
  String toString() {
    return 'ShareAllPatientDataOptionsEntityResult(success: $success, error: $error, modified: $modified)';
  }
}

/// @nodoc
abstract mixin class _$ShareAllPatientDataOptionsEntityResultCopyWith<$Res>
    implements $ShareAllPatientDataOptionsEntityResultCopyWith<$Res> {
  factory _$ShareAllPatientDataOptionsEntityResultCopyWith(
          _ShareAllPatientDataOptionsEntityResult value,
          $Res Function(_ShareAllPatientDataOptionsEntityResult) _then) =
      __$ShareAllPatientDataOptionsEntityResultCopyWithImpl;
  @override
  @useResult
  $Res call(
      {bool? success,
      ShareAllPatientDataOptionsSharePatientDataError? error,
      int modified});
}

/// @nodoc
class __$ShareAllPatientDataOptionsEntityResultCopyWithImpl<$Res>
    implements _$ShareAllPatientDataOptionsEntityResultCopyWith<$Res> {
  __$ShareAllPatientDataOptionsEntityResultCopyWithImpl(this._self, this._then);

  final _ShareAllPatientDataOptionsEntityResult _self;
  final $Res Function(_ShareAllPatientDataOptionsEntityResult) _then;

  /// Create a copy of ShareAllPatientDataOptionsEntityResult
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? success = freezed,
    Object? error = freezed,
    Object? modified = null,
  }) {
    return _then(_ShareAllPatientDataOptionsEntityResult(
      success: freezed == success
          ? _self.success
          : success // ignore: cast_nullable_to_non_nullable
              as bool?,
      error: freezed == error
          ? _self.error
          : error // ignore: cast_nullable_to_non_nullable
              as ShareAllPatientDataOptionsSharePatientDataError?,
      modified: null == modified
          ? _self.modified
          : modified // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }
}

/// @nodoc
mixin _$ShareAllPatientDataOptionsResult {
  EncryptedPatient get patient;
  Map<ShareAllPatientDataOptionsShareableEntity,
      ShareAllPatientDataOptionsEntityResult> get statuses;

  /// Create a copy of ShareAllPatientDataOptionsResult
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ShareAllPatientDataOptionsResultCopyWith<ShareAllPatientDataOptionsResult>
      get copyWith => _$ShareAllPatientDataOptionsResultCopyWithImpl<
              ShareAllPatientDataOptionsResult>(
          this as ShareAllPatientDataOptionsResult, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ShareAllPatientDataOptionsResult &&
            (identical(other.patient, patient) || other.patient == patient) &&
            const DeepCollectionEquality().equals(other.statuses, statuses));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, patient, const DeepCollectionEquality().hash(statuses));

  @override
  String toString() {
    return 'ShareAllPatientDataOptionsResult(patient: $patient, statuses: $statuses)';
  }
}

/// @nodoc
abstract mixin class $ShareAllPatientDataOptionsResultCopyWith<$Res> {
  factory $ShareAllPatientDataOptionsResultCopyWith(
          ShareAllPatientDataOptionsResult value,
          $Res Function(ShareAllPatientDataOptionsResult) _then) =
      _$ShareAllPatientDataOptionsResultCopyWithImpl;
  @useResult
  $Res call(
      {EncryptedPatient patient,
      Map<ShareAllPatientDataOptionsShareableEntity,
              ShareAllPatientDataOptionsEntityResult>
          statuses});

  $EncryptedPatientCopyWith<$Res> get patient;
}

/// @nodoc
class _$ShareAllPatientDataOptionsResultCopyWithImpl<$Res>
    implements $ShareAllPatientDataOptionsResultCopyWith<$Res> {
  _$ShareAllPatientDataOptionsResultCopyWithImpl(this._self, this._then);

  final ShareAllPatientDataOptionsResult _self;
  final $Res Function(ShareAllPatientDataOptionsResult) _then;

  /// Create a copy of ShareAllPatientDataOptionsResult
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? patient = null,
    Object? statuses = null,
  }) {
    return _then(_self.copyWith(
      patient: null == patient
          ? _self.patient
          : patient // ignore: cast_nullable_to_non_nullable
              as EncryptedPatient,
      statuses: null == statuses
          ? _self.statuses
          : statuses // ignore: cast_nullable_to_non_nullable
              as Map<ShareAllPatientDataOptionsShareableEntity,
                  ShareAllPatientDataOptionsEntityResult>,
    ));
  }

  /// Create a copy of ShareAllPatientDataOptionsResult
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $EncryptedPatientCopyWith<$Res> get patient {
    return $EncryptedPatientCopyWith<$Res>(_self.patient, (value) {
      return _then(_self.copyWith(patient: value));
    });
  }
}

/// @nodoc

class _ShareAllPatientDataOptionsResult
    implements ShareAllPatientDataOptionsResult {
  const _ShareAllPatientDataOptionsResult(
      {required this.patient,
      required final Map<ShareAllPatientDataOptionsShareableEntity,
              ShareAllPatientDataOptionsEntityResult>
          statuses})
      : _statuses = statuses;

  @override
  final EncryptedPatient patient;
  final Map<ShareAllPatientDataOptionsShareableEntity,
      ShareAllPatientDataOptionsEntityResult> _statuses;
  @override
  Map<ShareAllPatientDataOptionsShareableEntity,
      ShareAllPatientDataOptionsEntityResult> get statuses {
    if (_statuses is EqualUnmodifiableMapView) return _statuses;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableMapView(_statuses);
  }

  /// Create a copy of ShareAllPatientDataOptionsResult
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ShareAllPatientDataOptionsResultCopyWith<_ShareAllPatientDataOptionsResult>
      get copyWith => __$ShareAllPatientDataOptionsResultCopyWithImpl<
          _ShareAllPatientDataOptionsResult>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ShareAllPatientDataOptionsResult &&
            (identical(other.patient, patient) || other.patient == patient) &&
            const DeepCollectionEquality().equals(other._statuses, _statuses));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, patient, const DeepCollectionEquality().hash(_statuses));

  @override
  String toString() {
    return 'ShareAllPatientDataOptionsResult(patient: $patient, statuses: $statuses)';
  }
}

/// @nodoc
abstract mixin class _$ShareAllPatientDataOptionsResultCopyWith<$Res>
    implements $ShareAllPatientDataOptionsResultCopyWith<$Res> {
  factory _$ShareAllPatientDataOptionsResultCopyWith(
          _ShareAllPatientDataOptionsResult value,
          $Res Function(_ShareAllPatientDataOptionsResult) _then) =
      __$ShareAllPatientDataOptionsResultCopyWithImpl;
  @override
  @useResult
  $Res call(
      {EncryptedPatient patient,
      Map<ShareAllPatientDataOptionsShareableEntity,
              ShareAllPatientDataOptionsEntityResult>
          statuses});

  @override
  $EncryptedPatientCopyWith<$Res> get patient;
}

/// @nodoc
class __$ShareAllPatientDataOptionsResultCopyWithImpl<$Res>
    implements _$ShareAllPatientDataOptionsResultCopyWith<$Res> {
  __$ShareAllPatientDataOptionsResultCopyWithImpl(this._self, this._then);

  final _ShareAllPatientDataOptionsResult _self;
  final $Res Function(_ShareAllPatientDataOptionsResult) _then;

  /// Create a copy of ShareAllPatientDataOptionsResult
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? patient = null,
    Object? statuses = null,
  }) {
    return _then(_ShareAllPatientDataOptionsResult(
      patient: null == patient
          ? _self.patient
          : patient // ignore: cast_nullable_to_non_nullable
              as EncryptedPatient,
      statuses: null == statuses
          ? _self._statuses
          : statuses // ignore: cast_nullable_to_non_nullable
              as Map<ShareAllPatientDataOptionsShareableEntity,
                  ShareAllPatientDataOptionsEntityResult>,
    ));
  }

  /// Create a copy of ShareAllPatientDataOptionsResult
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $EncryptedPatientCopyWith<$Res> get patient {
    return $EncryptedPatientCopyWith<$Res>(_self.patient, (value) {
      return _then(_self.copyWith(patient: value));
    });
  }
}

/// @nodoc
mixin _$ShareAllPatientDataOptionsBulkShareFailure {
  List<FailedRequestDetails> get errors;
  String get message;

  /// Create a copy of ShareAllPatientDataOptionsBulkShareFailure
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ShareAllPatientDataOptionsBulkShareFailureCopyWith<
          ShareAllPatientDataOptionsBulkShareFailure>
      get copyWith => _$ShareAllPatientDataOptionsBulkShareFailureCopyWithImpl<
              ShareAllPatientDataOptionsBulkShareFailure>(
          this as ShareAllPatientDataOptionsBulkShareFailure, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ShareAllPatientDataOptionsBulkShareFailure &&
            const DeepCollectionEquality().equals(other.errors, errors) &&
            (identical(other.message, message) || other.message == message));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, const DeepCollectionEquality().hash(errors), message);

  @override
  String toString() {
    return 'ShareAllPatientDataOptionsBulkShareFailure(errors: $errors, message: $message)';
  }
}

/// @nodoc
abstract mixin class $ShareAllPatientDataOptionsBulkShareFailureCopyWith<$Res> {
  factory $ShareAllPatientDataOptionsBulkShareFailureCopyWith(
          ShareAllPatientDataOptionsBulkShareFailure value,
          $Res Function(ShareAllPatientDataOptionsBulkShareFailure) _then) =
      _$ShareAllPatientDataOptionsBulkShareFailureCopyWithImpl;
  @useResult
  $Res call({List<FailedRequestDetails> errors, String message});
}

/// @nodoc
class _$ShareAllPatientDataOptionsBulkShareFailureCopyWithImpl<$Res>
    implements $ShareAllPatientDataOptionsBulkShareFailureCopyWith<$Res> {
  _$ShareAllPatientDataOptionsBulkShareFailureCopyWithImpl(
      this._self, this._then);

  final ShareAllPatientDataOptionsBulkShareFailure _self;
  final $Res Function(ShareAllPatientDataOptionsBulkShareFailure) _then;

  /// Create a copy of ShareAllPatientDataOptionsBulkShareFailure
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? errors = null,
    Object? message = null,
  }) {
    return _then(_self.copyWith(
      errors: null == errors
          ? _self.errors
          : errors // ignore: cast_nullable_to_non_nullable
              as List<FailedRequestDetails>,
      message: null == message
          ? _self.message
          : message // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc

class _ShareAllPatientDataOptionsBulkShareFailure
    implements ShareAllPatientDataOptionsBulkShareFailure {
  const _ShareAllPatientDataOptionsBulkShareFailure(
      {required final List<FailedRequestDetails> errors, required this.message})
      : _errors = errors;

  final List<FailedRequestDetails> _errors;
  @override
  List<FailedRequestDetails> get errors {
    if (_errors is EqualUnmodifiableListView) return _errors;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableListView(_errors);
  }

  @override
  final String message;

  /// Create a copy of ShareAllPatientDataOptionsBulkShareFailure
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ShareAllPatientDataOptionsBulkShareFailureCopyWith<
          _ShareAllPatientDataOptionsBulkShareFailure>
      get copyWith => __$ShareAllPatientDataOptionsBulkShareFailureCopyWithImpl<
          _ShareAllPatientDataOptionsBulkShareFailure>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ShareAllPatientDataOptionsBulkShareFailure &&
            const DeepCollectionEquality().equals(other._errors, _errors) &&
            (identical(other.message, message) || other.message == message));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, const DeepCollectionEquality().hash(_errors), message);

  @override
  String toString() {
    return 'ShareAllPatientDataOptionsBulkShareFailure(errors: $errors, message: $message)';
  }
}

/// @nodoc
abstract mixin class _$ShareAllPatientDataOptionsBulkShareFailureCopyWith<$Res>
    implements $ShareAllPatientDataOptionsBulkShareFailureCopyWith<$Res> {
  factory _$ShareAllPatientDataOptionsBulkShareFailureCopyWith(
          _ShareAllPatientDataOptionsBulkShareFailure value,
          $Res Function(_ShareAllPatientDataOptionsBulkShareFailure) _then) =
      __$ShareAllPatientDataOptionsBulkShareFailureCopyWithImpl;
  @override
  @useResult
  $Res call({List<FailedRequestDetails> errors, String message});
}

/// @nodoc
class __$ShareAllPatientDataOptionsBulkShareFailureCopyWithImpl<$Res>
    implements _$ShareAllPatientDataOptionsBulkShareFailureCopyWith<$Res> {
  __$ShareAllPatientDataOptionsBulkShareFailureCopyWithImpl(
      this._self, this._then);

  final _ShareAllPatientDataOptionsBulkShareFailure _self;
  final $Res Function(_ShareAllPatientDataOptionsBulkShareFailure) _then;

  /// Create a copy of ShareAllPatientDataOptionsBulkShareFailure
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? errors = null,
    Object? message = null,
  }) {
    return _then(_ShareAllPatientDataOptionsBulkShareFailure(
      errors: null == errors
          ? _self._errors
          : errors // ignore: cast_nullable_to_non_nullable
              as List<FailedRequestDetails>,
      message: null == message
          ? _self.message
          : message // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc
mixin _$ShareAllPatientDataOptionsFailedRequest {
  String get description;

  /// Create a copy of ShareAllPatientDataOptionsFailedRequest
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $ShareAllPatientDataOptionsFailedRequestCopyWith<
          ShareAllPatientDataOptionsFailedRequest>
      get copyWith => _$ShareAllPatientDataOptionsFailedRequestCopyWithImpl<
              ShareAllPatientDataOptionsFailedRequest>(
          this as ShareAllPatientDataOptionsFailedRequest, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is ShareAllPatientDataOptionsFailedRequest &&
            (identical(other.description, description) ||
                other.description == description));
  }

  @override
  int get hashCode => Object.hash(runtimeType, description);

  @override
  String toString() {
    return 'ShareAllPatientDataOptionsFailedRequest(description: $description)';
  }
}

/// @nodoc
abstract mixin class $ShareAllPatientDataOptionsFailedRequestCopyWith<$Res> {
  factory $ShareAllPatientDataOptionsFailedRequestCopyWith(
          ShareAllPatientDataOptionsFailedRequest value,
          $Res Function(ShareAllPatientDataOptionsFailedRequest) _then) =
      _$ShareAllPatientDataOptionsFailedRequestCopyWithImpl;
  @useResult
  $Res call({String description});
}

/// @nodoc
class _$ShareAllPatientDataOptionsFailedRequestCopyWithImpl<$Res>
    implements $ShareAllPatientDataOptionsFailedRequestCopyWith<$Res> {
  _$ShareAllPatientDataOptionsFailedRequestCopyWithImpl(this._self, this._then);

  final ShareAllPatientDataOptionsFailedRequest _self;
  final $Res Function(ShareAllPatientDataOptionsFailedRequest) _then;

  /// Create a copy of ShareAllPatientDataOptionsFailedRequest
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? description = null,
  }) {
    return _then(_self.copyWith(
      description: null == description
          ? _self.description
          : description // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc

class _ShareAllPatientDataOptionsFailedRequest
    implements ShareAllPatientDataOptionsFailedRequest {
  const _ShareAllPatientDataOptionsFailedRequest({required this.description});

  @override
  final String description;

  /// Create a copy of ShareAllPatientDataOptionsFailedRequest
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$ShareAllPatientDataOptionsFailedRequestCopyWith<
          _ShareAllPatientDataOptionsFailedRequest>
      get copyWith => __$ShareAllPatientDataOptionsFailedRequestCopyWithImpl<
          _ShareAllPatientDataOptionsFailedRequest>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _ShareAllPatientDataOptionsFailedRequest &&
            (identical(other.description, description) ||
                other.description == description));
  }

  @override
  int get hashCode => Object.hash(runtimeType, description);

  @override
  String toString() {
    return 'ShareAllPatientDataOptionsFailedRequest(description: $description)';
  }
}

/// @nodoc
abstract mixin class _$ShareAllPatientDataOptionsFailedRequestCopyWith<$Res>
    implements $ShareAllPatientDataOptionsFailedRequestCopyWith<$Res> {
  factory _$ShareAllPatientDataOptionsFailedRequestCopyWith(
          _ShareAllPatientDataOptionsFailedRequest value,
          $Res Function(_ShareAllPatientDataOptionsFailedRequest) _then) =
      __$ShareAllPatientDataOptionsFailedRequestCopyWithImpl;
  @override
  @useResult
  $Res call({String description});
}

/// @nodoc
class __$ShareAllPatientDataOptionsFailedRequestCopyWithImpl<$Res>
    implements _$ShareAllPatientDataOptionsFailedRequestCopyWith<$Res> {
  __$ShareAllPatientDataOptionsFailedRequestCopyWithImpl(
      this._self, this._then);

  final _ShareAllPatientDataOptionsFailedRequest _self;
  final $Res Function(_ShareAllPatientDataOptionsFailedRequest) _then;

  /// Create a copy of ShareAllPatientDataOptionsFailedRequest
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? description = null,
  }) {
    return _then(_ShareAllPatientDataOptionsFailedRequest(
      description: null == description
          ? _self.description
          : description // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

// dart format on
