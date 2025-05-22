// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'episode.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$DecryptedEpisode {
  String get id;
  String? get name;
  String? get comment;
  int? get startDate;
  int? get endDate;
  Base64String? get encryptedSelf;

  /// Create a copy of DecryptedEpisode
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $DecryptedEpisodeCopyWith<DecryptedEpisode> get copyWith =>
      _$DecryptedEpisodeCopyWithImpl<DecryptedEpisode>(
          this as DecryptedEpisode, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is DecryptedEpisode &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.comment, comment) || other.comment == comment) &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.endDate, endDate) || other.endDate == endDate) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, id, name, comment, startDate, endDate, encryptedSelf);

  @override
  String toString() {
    return 'DecryptedEpisode(id: $id, name: $name, comment: $comment, startDate: $startDate, endDate: $endDate, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $DecryptedEpisodeCopyWith<$Res> {
  factory $DecryptedEpisodeCopyWith(
          DecryptedEpisode value, $Res Function(DecryptedEpisode) _then) =
      _$DecryptedEpisodeCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? name,
      String? comment,
      int? startDate,
      int? endDate,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$DecryptedEpisodeCopyWithImpl<$Res>
    implements $DecryptedEpisodeCopyWith<$Res> {
  _$DecryptedEpisodeCopyWithImpl(this._self, this._then);

  final DecryptedEpisode _self;
  final $Res Function(DecryptedEpisode) _then;

  /// Create a copy of DecryptedEpisode
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? name = freezed,
    Object? comment = freezed,
    Object? startDate = freezed,
    Object? endDate = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      comment: freezed == comment
          ? _self.comment
          : comment // ignore: cast_nullable_to_non_nullable
              as String?,
      startDate: freezed == startDate
          ? _self.startDate
          : startDate // ignore: cast_nullable_to_non_nullable
              as int?,
      endDate: freezed == endDate
          ? _self.endDate
          : endDate // ignore: cast_nullable_to_non_nullable
              as int?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _DecryptedEpisode implements DecryptedEpisode {
  const _DecryptedEpisode(
      {required this.id,
      this.name = null,
      this.comment = null,
      this.startDate = null,
      this.endDate = null,
      this.encryptedSelf = null});

  @override
  final String id;
  @override
  @JsonKey()
  final String? name;
  @override
  @JsonKey()
  final String? comment;
  @override
  @JsonKey()
  final int? startDate;
  @override
  @JsonKey()
  final int? endDate;
  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of DecryptedEpisode
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$DecryptedEpisodeCopyWith<_DecryptedEpisode> get copyWith =>
      __$DecryptedEpisodeCopyWithImpl<_DecryptedEpisode>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _DecryptedEpisode &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.comment, comment) || other.comment == comment) &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.endDate, endDate) || other.endDate == endDate) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, id, name, comment, startDate, endDate, encryptedSelf);

  @override
  String toString() {
    return 'DecryptedEpisode(id: $id, name: $name, comment: $comment, startDate: $startDate, endDate: $endDate, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$DecryptedEpisodeCopyWith<$Res>
    implements $DecryptedEpisodeCopyWith<$Res> {
  factory _$DecryptedEpisodeCopyWith(
          _DecryptedEpisode value, $Res Function(_DecryptedEpisode) _then) =
      __$DecryptedEpisodeCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? name,
      String? comment,
      int? startDate,
      int? endDate,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$DecryptedEpisodeCopyWithImpl<$Res>
    implements _$DecryptedEpisodeCopyWith<$Res> {
  __$DecryptedEpisodeCopyWithImpl(this._self, this._then);

  final _DecryptedEpisode _self;
  final $Res Function(_DecryptedEpisode) _then;

  /// Create a copy of DecryptedEpisode
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? name = freezed,
    Object? comment = freezed,
    Object? startDate = freezed,
    Object? endDate = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_DecryptedEpisode(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      comment: freezed == comment
          ? _self.comment
          : comment // ignore: cast_nullable_to_non_nullable
              as String?,
      startDate: freezed == startDate
          ? _self.startDate
          : startDate // ignore: cast_nullable_to_non_nullable
              as int?,
      endDate: freezed == endDate
          ? _self.endDate
          : endDate // ignore: cast_nullable_to_non_nullable
              as int?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc
mixin _$EncryptedEpisode {
  String get id;
  String? get name;
  String? get comment;
  int? get startDate;
  int? get endDate;
  Base64String? get encryptedSelf;

  /// Create a copy of EncryptedEpisode
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $EncryptedEpisodeCopyWith<EncryptedEpisode> get copyWith =>
      _$EncryptedEpisodeCopyWithImpl<EncryptedEpisode>(
          this as EncryptedEpisode, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is EncryptedEpisode &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.comment, comment) || other.comment == comment) &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.endDate, endDate) || other.endDate == endDate) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, id, name, comment, startDate, endDate, encryptedSelf);

  @override
  String toString() {
    return 'EncryptedEpisode(id: $id, name: $name, comment: $comment, startDate: $startDate, endDate: $endDate, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class $EncryptedEpisodeCopyWith<$Res> {
  factory $EncryptedEpisodeCopyWith(
          EncryptedEpisode value, $Res Function(EncryptedEpisode) _then) =
      _$EncryptedEpisodeCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? name,
      String? comment,
      int? startDate,
      int? endDate,
      Base64String? encryptedSelf});
}

/// @nodoc
class _$EncryptedEpisodeCopyWithImpl<$Res>
    implements $EncryptedEpisodeCopyWith<$Res> {
  _$EncryptedEpisodeCopyWithImpl(this._self, this._then);

  final EncryptedEpisode _self;
  final $Res Function(EncryptedEpisode) _then;

  /// Create a copy of EncryptedEpisode
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? name = freezed,
    Object? comment = freezed,
    Object? startDate = freezed,
    Object? endDate = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_self.copyWith(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      comment: freezed == comment
          ? _self.comment
          : comment // ignore: cast_nullable_to_non_nullable
              as String?,
      startDate: freezed == startDate
          ? _self.startDate
          : startDate // ignore: cast_nullable_to_non_nullable
              as int?,
      endDate: freezed == endDate
          ? _self.endDate
          : endDate // ignore: cast_nullable_to_non_nullable
              as int?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

/// @nodoc

class _EncryptedEpisode implements EncryptedEpisode {
  const _EncryptedEpisode(
      {required this.id,
      this.name = null,
      this.comment = null,
      this.startDate = null,
      this.endDate = null,
      this.encryptedSelf = null});

  @override
  final String id;
  @override
  @JsonKey()
  final String? name;
  @override
  @JsonKey()
  final String? comment;
  @override
  @JsonKey()
  final int? startDate;
  @override
  @JsonKey()
  final int? endDate;
  @override
  @JsonKey()
  final Base64String? encryptedSelf;

  /// Create a copy of EncryptedEpisode
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$EncryptedEpisodeCopyWith<_EncryptedEpisode> get copyWith =>
      __$EncryptedEpisodeCopyWithImpl<_EncryptedEpisode>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _EncryptedEpisode &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.comment, comment) || other.comment == comment) &&
            (identical(other.startDate, startDate) ||
                other.startDate == startDate) &&
            (identical(other.endDate, endDate) || other.endDate == endDate) &&
            (identical(other.encryptedSelf, encryptedSelf) ||
                other.encryptedSelf == encryptedSelf));
  }

  @override
  int get hashCode => Object.hash(
      runtimeType, id, name, comment, startDate, endDate, encryptedSelf);

  @override
  String toString() {
    return 'EncryptedEpisode(id: $id, name: $name, comment: $comment, startDate: $startDate, endDate: $endDate, encryptedSelf: $encryptedSelf)';
  }
}

/// @nodoc
abstract mixin class _$EncryptedEpisodeCopyWith<$Res>
    implements $EncryptedEpisodeCopyWith<$Res> {
  factory _$EncryptedEpisodeCopyWith(
          _EncryptedEpisode value, $Res Function(_EncryptedEpisode) _then) =
      __$EncryptedEpisodeCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? name,
      String? comment,
      int? startDate,
      int? endDate,
      Base64String? encryptedSelf});
}

/// @nodoc
class __$EncryptedEpisodeCopyWithImpl<$Res>
    implements _$EncryptedEpisodeCopyWith<$Res> {
  __$EncryptedEpisodeCopyWithImpl(this._self, this._then);

  final _EncryptedEpisode _self;
  final $Res Function(_EncryptedEpisode) _then;

  /// Create a copy of EncryptedEpisode
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? name = freezed,
    Object? comment = freezed,
    Object? startDate = freezed,
    Object? endDate = freezed,
    Object? encryptedSelf = freezed,
  }) {
    return _then(_EncryptedEpisode(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      comment: freezed == comment
          ? _self.comment
          : comment // ignore: cast_nullable_to_non_nullable
              as String?,
      startDate: freezed == startDate
          ? _self.startDate
          : startDate // ignore: cast_nullable_to_non_nullable
              as int?,
      endDate: freezed == endDate
          ? _self.endDate
          : endDate // ignore: cast_nullable_to_non_nullable
              as int?,
      encryptedSelf: freezed == encryptedSelf
          ? _self.encryptedSelf
          : encryptedSelf // ignore: cast_nullable_to_non_nullable
              as Base64String?,
    ));
  }
}

// dart format on
