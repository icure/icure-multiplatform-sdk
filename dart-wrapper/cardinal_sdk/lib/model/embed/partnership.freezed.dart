// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'partnership.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$Partnership {
  PartnershipType? get type;
  PartnershipStatus? get status;
  String? get partnerId;
  String? get meToOtherRelationshipDescription;
  String? get otherToMeRelationshipDescription;

  /// Create a copy of Partnership
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $PartnershipCopyWith<Partnership> get copyWith =>
      _$PartnershipCopyWithImpl<Partnership>(this as Partnership, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is Partnership &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.partnerId, partnerId) ||
                other.partnerId == partnerId) &&
            (identical(other.meToOtherRelationshipDescription,
                    meToOtherRelationshipDescription) ||
                other.meToOtherRelationshipDescription ==
                    meToOtherRelationshipDescription) &&
            (identical(other.otherToMeRelationshipDescription,
                    otherToMeRelationshipDescription) ||
                other.otherToMeRelationshipDescription ==
                    otherToMeRelationshipDescription));
  }

  @override
  int get hashCode => Object.hash(runtimeType, type, status, partnerId,
      meToOtherRelationshipDescription, otherToMeRelationshipDescription);

  @override
  String toString() {
    return 'Partnership(type: $type, status: $status, partnerId: $partnerId, meToOtherRelationshipDescription: $meToOtherRelationshipDescription, otherToMeRelationshipDescription: $otherToMeRelationshipDescription)';
  }
}

/// @nodoc
abstract mixin class $PartnershipCopyWith<$Res> {
  factory $PartnershipCopyWith(
          Partnership value, $Res Function(Partnership) _then) =
      _$PartnershipCopyWithImpl;
  @useResult
  $Res call(
      {PartnershipType? type,
      PartnershipStatus? status,
      String? partnerId,
      String? meToOtherRelationshipDescription,
      String? otherToMeRelationshipDescription});
}

/// @nodoc
class _$PartnershipCopyWithImpl<$Res> implements $PartnershipCopyWith<$Res> {
  _$PartnershipCopyWithImpl(this._self, this._then);

  final Partnership _self;
  final $Res Function(Partnership) _then;

  /// Create a copy of Partnership
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? type = freezed,
    Object? status = freezed,
    Object? partnerId = freezed,
    Object? meToOtherRelationshipDescription = freezed,
    Object? otherToMeRelationshipDescription = freezed,
  }) {
    return _then(_self.copyWith(
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as PartnershipType?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as PartnershipStatus?,
      partnerId: freezed == partnerId
          ? _self.partnerId
          : partnerId // ignore: cast_nullable_to_non_nullable
              as String?,
      meToOtherRelationshipDescription: freezed ==
              meToOtherRelationshipDescription
          ? _self.meToOtherRelationshipDescription
          : meToOtherRelationshipDescription // ignore: cast_nullable_to_non_nullable
              as String?,
      otherToMeRelationshipDescription: freezed ==
              otherToMeRelationshipDescription
          ? _self.otherToMeRelationshipDescription
          : otherToMeRelationshipDescription // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

/// @nodoc

class _Partnership implements Partnership {
  const _Partnership(
      {this.type = null,
      this.status = null,
      this.partnerId = null,
      this.meToOtherRelationshipDescription = null,
      this.otherToMeRelationshipDescription = null});

  @override
  @JsonKey()
  final PartnershipType? type;
  @override
  @JsonKey()
  final PartnershipStatus? status;
  @override
  @JsonKey()
  final String? partnerId;
  @override
  @JsonKey()
  final String? meToOtherRelationshipDescription;
  @override
  @JsonKey()
  final String? otherToMeRelationshipDescription;

  /// Create a copy of Partnership
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$PartnershipCopyWith<_Partnership> get copyWith =>
      __$PartnershipCopyWithImpl<_Partnership>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _Partnership &&
            (identical(other.type, type) || other.type == type) &&
            (identical(other.status, status) || other.status == status) &&
            (identical(other.partnerId, partnerId) ||
                other.partnerId == partnerId) &&
            (identical(other.meToOtherRelationshipDescription,
                    meToOtherRelationshipDescription) ||
                other.meToOtherRelationshipDescription ==
                    meToOtherRelationshipDescription) &&
            (identical(other.otherToMeRelationshipDescription,
                    otherToMeRelationshipDescription) ||
                other.otherToMeRelationshipDescription ==
                    otherToMeRelationshipDescription));
  }

  @override
  int get hashCode => Object.hash(runtimeType, type, status, partnerId,
      meToOtherRelationshipDescription, otherToMeRelationshipDescription);

  @override
  String toString() {
    return 'Partnership(type: $type, status: $status, partnerId: $partnerId, meToOtherRelationshipDescription: $meToOtherRelationshipDescription, otherToMeRelationshipDescription: $otherToMeRelationshipDescription)';
  }
}

/// @nodoc
abstract mixin class _$PartnershipCopyWith<$Res>
    implements $PartnershipCopyWith<$Res> {
  factory _$PartnershipCopyWith(
          _Partnership value, $Res Function(_Partnership) _then) =
      __$PartnershipCopyWithImpl;
  @override
  @useResult
  $Res call(
      {PartnershipType? type,
      PartnershipStatus? status,
      String? partnerId,
      String? meToOtherRelationshipDescription,
      String? otherToMeRelationshipDescription});
}

/// @nodoc
class __$PartnershipCopyWithImpl<$Res> implements _$PartnershipCopyWith<$Res> {
  __$PartnershipCopyWithImpl(this._self, this._then);

  final _Partnership _self;
  final $Res Function(_Partnership) _then;

  /// Create a copy of Partnership
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? type = freezed,
    Object? status = freezed,
    Object? partnerId = freezed,
    Object? meToOtherRelationshipDescription = freezed,
    Object? otherToMeRelationshipDescription = freezed,
  }) {
    return _then(_Partnership(
      type: freezed == type
          ? _self.type
          : type // ignore: cast_nullable_to_non_nullable
              as PartnershipType?,
      status: freezed == status
          ? _self.status
          : status // ignore: cast_nullable_to_non_nullable
              as PartnershipStatus?,
      partnerId: freezed == partnerId
          ? _self.partnerId
          : partnerId // ignore: cast_nullable_to_non_nullable
              as String?,
      meToOtherRelationshipDescription: freezed ==
              meToOtherRelationshipDescription
          ? _self.meToOtherRelationshipDescription
          : meToOtherRelationshipDescription // ignore: cast_nullable_to_non_nullable
              as String?,
      otherToMeRelationshipDescription: freezed ==
              otherToMeRelationshipDescription
          ? _self.otherToMeRelationshipDescription
          : otherToMeRelationshipDescription // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }
}

// dart format on
