// dart format width=80
// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'form_template.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

// dart format off
T _$identity<T>(T value) => value;

/// @nodoc
mixin _$FormTemplate {
  String get id;
  String? get rev;
  int? get deletionDate;
  FormTemplateLayout? get templateLayout;
  Uint8List? get rawTemplateLayout;
  String? get name;
  String? get guid;
  DocumentGroup? get group;
  String? get descr;
  String? get disabled;
  CodeStub? get specialty;
  String? get author;
  String? get formInstancePreferredLocation;
  String? get keyboardShortcut;
  String? get shortReport;
  String? get mediumReport;
  String? get longReport;
  Set<String> get reports;
  Set<CodeStub> get tags;
  String? get layoutAttachmentId;
  String? get templateLayoutAttachmentId;

  /// Create a copy of FormTemplate
  /// with the given fields replaced by the non-null parameter values.
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  $FormTemplateCopyWith<FormTemplate> get copyWith =>
      _$FormTemplateCopyWithImpl<FormTemplate>(
          this as FormTemplate, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is FormTemplate &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.templateLayout, templateLayout) ||
                other.templateLayout == templateLayout) &&
            const DeepCollectionEquality()
                .equals(other.rawTemplateLayout, rawTemplateLayout) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.guid, guid) || other.guid == guid) &&
            (identical(other.group, group) || other.group == group) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.disabled, disabled) ||
                other.disabled == disabled) &&
            (identical(other.specialty, specialty) ||
                other.specialty == specialty) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.formInstancePreferredLocation,
                    formInstancePreferredLocation) ||
                other.formInstancePreferredLocation ==
                    formInstancePreferredLocation) &&
            (identical(other.keyboardShortcut, keyboardShortcut) ||
                other.keyboardShortcut == keyboardShortcut) &&
            (identical(other.shortReport, shortReport) ||
                other.shortReport == shortReport) &&
            (identical(other.mediumReport, mediumReport) ||
                other.mediumReport == mediumReport) &&
            (identical(other.longReport, longReport) ||
                other.longReport == longReport) &&
            const DeepCollectionEquality().equals(other.reports, reports) &&
            const DeepCollectionEquality().equals(other.tags, tags) &&
            (identical(other.layoutAttachmentId, layoutAttachmentId) ||
                other.layoutAttachmentId == layoutAttachmentId) &&
            (identical(other.templateLayoutAttachmentId,
                    templateLayoutAttachmentId) ||
                other.templateLayoutAttachmentId ==
                    templateLayoutAttachmentId));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        deletionDate,
        templateLayout,
        const DeepCollectionEquality().hash(rawTemplateLayout),
        name,
        guid,
        group,
        descr,
        disabled,
        specialty,
        author,
        formInstancePreferredLocation,
        keyboardShortcut,
        shortReport,
        mediumReport,
        longReport,
        const DeepCollectionEquality().hash(reports),
        const DeepCollectionEquality().hash(tags),
        layoutAttachmentId,
        templateLayoutAttachmentId
      ]);

  @override
  String toString() {
    return 'FormTemplate(id: $id, rev: $rev, deletionDate: $deletionDate, templateLayout: $templateLayout, rawTemplateLayout: $rawTemplateLayout, name: $name, guid: $guid, group: $group, descr: $descr, disabled: $disabled, specialty: $specialty, author: $author, formInstancePreferredLocation: $formInstancePreferredLocation, keyboardShortcut: $keyboardShortcut, shortReport: $shortReport, mediumReport: $mediumReport, longReport: $longReport, reports: $reports, tags: $tags, layoutAttachmentId: $layoutAttachmentId, templateLayoutAttachmentId: $templateLayoutAttachmentId)';
  }
}

/// @nodoc
abstract mixin class $FormTemplateCopyWith<$Res> {
  factory $FormTemplateCopyWith(
          FormTemplate value, $Res Function(FormTemplate) _then) =
      _$FormTemplateCopyWithImpl;
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      FormTemplateLayout? templateLayout,
      Uint8List? rawTemplateLayout,
      String? name,
      String? guid,
      DocumentGroup? group,
      String? descr,
      String? disabled,
      CodeStub? specialty,
      String? author,
      String? formInstancePreferredLocation,
      String? keyboardShortcut,
      String? shortReport,
      String? mediumReport,
      String? longReport,
      Set<String> reports,
      Set<CodeStub> tags,
      String? layoutAttachmentId,
      String? templateLayoutAttachmentId});

  $FormTemplateLayoutCopyWith<$Res>? get templateLayout;
  $DocumentGroupCopyWith<$Res>? get group;
  $CodeStubCopyWith<$Res>? get specialty;
}

/// @nodoc
class _$FormTemplateCopyWithImpl<$Res> implements $FormTemplateCopyWith<$Res> {
  _$FormTemplateCopyWithImpl(this._self, this._then);

  final FormTemplate _self;
  final $Res Function(FormTemplate) _then;

  /// Create a copy of FormTemplate
  /// with the given fields replaced by the non-null parameter values.
  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? templateLayout = freezed,
    Object? rawTemplateLayout = freezed,
    Object? name = freezed,
    Object? guid = freezed,
    Object? group = freezed,
    Object? descr = freezed,
    Object? disabled = freezed,
    Object? specialty = freezed,
    Object? author = freezed,
    Object? formInstancePreferredLocation = freezed,
    Object? keyboardShortcut = freezed,
    Object? shortReport = freezed,
    Object? mediumReport = freezed,
    Object? longReport = freezed,
    Object? reports = null,
    Object? tags = null,
    Object? layoutAttachmentId = freezed,
    Object? templateLayoutAttachmentId = freezed,
  }) {
    return _then(_self.copyWith(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      templateLayout: freezed == templateLayout
          ? _self.templateLayout
          : templateLayout // ignore: cast_nullable_to_non_nullable
              as FormTemplateLayout?,
      rawTemplateLayout: freezed == rawTemplateLayout
          ? _self.rawTemplateLayout
          : rawTemplateLayout // ignore: cast_nullable_to_non_nullable
              as Uint8List?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      guid: freezed == guid
          ? _self.guid
          : guid // ignore: cast_nullable_to_non_nullable
              as String?,
      group: freezed == group
          ? _self.group
          : group // ignore: cast_nullable_to_non_nullable
              as DocumentGroup?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      disabled: freezed == disabled
          ? _self.disabled
          : disabled // ignore: cast_nullable_to_non_nullable
              as String?,
      specialty: freezed == specialty
          ? _self.specialty
          : specialty // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      author: freezed == author
          ? _self.author
          : author // ignore: cast_nullable_to_non_nullable
              as String?,
      formInstancePreferredLocation: freezed == formInstancePreferredLocation
          ? _self.formInstancePreferredLocation
          : formInstancePreferredLocation // ignore: cast_nullable_to_non_nullable
              as String?,
      keyboardShortcut: freezed == keyboardShortcut
          ? _self.keyboardShortcut
          : keyboardShortcut // ignore: cast_nullable_to_non_nullable
              as String?,
      shortReport: freezed == shortReport
          ? _self.shortReport
          : shortReport // ignore: cast_nullable_to_non_nullable
              as String?,
      mediumReport: freezed == mediumReport
          ? _self.mediumReport
          : mediumReport // ignore: cast_nullable_to_non_nullable
              as String?,
      longReport: freezed == longReport
          ? _self.longReport
          : longReport // ignore: cast_nullable_to_non_nullable
              as String?,
      reports: null == reports
          ? _self.reports
          : reports // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      tags: null == tags
          ? _self.tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      layoutAttachmentId: freezed == layoutAttachmentId
          ? _self.layoutAttachmentId
          : layoutAttachmentId // ignore: cast_nullable_to_non_nullable
              as String?,
      templateLayoutAttachmentId: freezed == templateLayoutAttachmentId
          ? _self.templateLayoutAttachmentId
          : templateLayoutAttachmentId // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }

  /// Create a copy of FormTemplate
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $FormTemplateLayoutCopyWith<$Res>? get templateLayout {
    if (_self.templateLayout == null) {
      return null;
    }

    return $FormTemplateLayoutCopyWith<$Res>(_self.templateLayout!, (value) {
      return _then(_self.copyWith(templateLayout: value));
    });
  }

  /// Create a copy of FormTemplate
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $DocumentGroupCopyWith<$Res>? get group {
    if (_self.group == null) {
      return null;
    }

    return $DocumentGroupCopyWith<$Res>(_self.group!, (value) {
      return _then(_self.copyWith(group: value));
    });
  }

  /// Create a copy of FormTemplate
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get specialty {
    if (_self.specialty == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.specialty!, (value) {
      return _then(_self.copyWith(specialty: value));
    });
  }
}

/// @nodoc

class _FormTemplate implements FormTemplate {
  const _FormTemplate(
      {required this.id,
      this.rev = null,
      this.deletionDate = null,
      this.templateLayout = null,
      this.rawTemplateLayout = null,
      this.name = null,
      this.guid = null,
      this.group = null,
      this.descr = null,
      this.disabled = null,
      this.specialty = null,
      this.author = null,
      this.formInstancePreferredLocation = null,
      this.keyboardShortcut = null,
      this.shortReport = null,
      this.mediumReport = null,
      this.longReport = null,
      final Set<String> reports = const {},
      final Set<CodeStub> tags = const {},
      this.layoutAttachmentId = null,
      this.templateLayoutAttachmentId = null})
      : _reports = reports,
        _tags = tags;

  @override
  final String id;
  @override
  @JsonKey()
  final String? rev;
  @override
  @JsonKey()
  final int? deletionDate;
  @override
  @JsonKey()
  final FormTemplateLayout? templateLayout;
  @override
  @JsonKey()
  final Uint8List? rawTemplateLayout;
  @override
  @JsonKey()
  final String? name;
  @override
  @JsonKey()
  final String? guid;
  @override
  @JsonKey()
  final DocumentGroup? group;
  @override
  @JsonKey()
  final String? descr;
  @override
  @JsonKey()
  final String? disabled;
  @override
  @JsonKey()
  final CodeStub? specialty;
  @override
  @JsonKey()
  final String? author;
  @override
  @JsonKey()
  final String? formInstancePreferredLocation;
  @override
  @JsonKey()
  final String? keyboardShortcut;
  @override
  @JsonKey()
  final String? shortReport;
  @override
  @JsonKey()
  final String? mediumReport;
  @override
  @JsonKey()
  final String? longReport;
  final Set<String> _reports;
  @override
  @JsonKey()
  Set<String> get reports {
    if (_reports is EqualUnmodifiableSetView) return _reports;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_reports);
  }

  final Set<CodeStub> _tags;
  @override
  @JsonKey()
  Set<CodeStub> get tags {
    if (_tags is EqualUnmodifiableSetView) return _tags;
    // ignore: implicit_dynamic_type
    return EqualUnmodifiableSetView(_tags);
  }

  @override
  @JsonKey()
  final String? layoutAttachmentId;
  @override
  @JsonKey()
  final String? templateLayoutAttachmentId;

  /// Create a copy of FormTemplate
  /// with the given fields replaced by the non-null parameter values.
  @override
  @JsonKey(includeFromJson: false, includeToJson: false)
  @pragma('vm:prefer-inline')
  _$FormTemplateCopyWith<_FormTemplate> get copyWith =>
      __$FormTemplateCopyWithImpl<_FormTemplate>(this, _$identity);

  @override
  bool operator ==(Object other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _FormTemplate &&
            (identical(other.id, id) || other.id == id) &&
            (identical(other.rev, rev) || other.rev == rev) &&
            (identical(other.deletionDate, deletionDate) ||
                other.deletionDate == deletionDate) &&
            (identical(other.templateLayout, templateLayout) ||
                other.templateLayout == templateLayout) &&
            const DeepCollectionEquality()
                .equals(other.rawTemplateLayout, rawTemplateLayout) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.guid, guid) || other.guid == guid) &&
            (identical(other.group, group) || other.group == group) &&
            (identical(other.descr, descr) || other.descr == descr) &&
            (identical(other.disabled, disabled) ||
                other.disabled == disabled) &&
            (identical(other.specialty, specialty) ||
                other.specialty == specialty) &&
            (identical(other.author, author) || other.author == author) &&
            (identical(other.formInstancePreferredLocation,
                    formInstancePreferredLocation) ||
                other.formInstancePreferredLocation ==
                    formInstancePreferredLocation) &&
            (identical(other.keyboardShortcut, keyboardShortcut) ||
                other.keyboardShortcut == keyboardShortcut) &&
            (identical(other.shortReport, shortReport) ||
                other.shortReport == shortReport) &&
            (identical(other.mediumReport, mediumReport) ||
                other.mediumReport == mediumReport) &&
            (identical(other.longReport, longReport) ||
                other.longReport == longReport) &&
            const DeepCollectionEquality().equals(other._reports, _reports) &&
            const DeepCollectionEquality().equals(other._tags, _tags) &&
            (identical(other.layoutAttachmentId, layoutAttachmentId) ||
                other.layoutAttachmentId == layoutAttachmentId) &&
            (identical(other.templateLayoutAttachmentId,
                    templateLayoutAttachmentId) ||
                other.templateLayoutAttachmentId ==
                    templateLayoutAttachmentId));
  }

  @override
  int get hashCode => Object.hashAll([
        runtimeType,
        id,
        rev,
        deletionDate,
        templateLayout,
        const DeepCollectionEquality().hash(rawTemplateLayout),
        name,
        guid,
        group,
        descr,
        disabled,
        specialty,
        author,
        formInstancePreferredLocation,
        keyboardShortcut,
        shortReport,
        mediumReport,
        longReport,
        const DeepCollectionEquality().hash(_reports),
        const DeepCollectionEquality().hash(_tags),
        layoutAttachmentId,
        templateLayoutAttachmentId
      ]);

  @override
  String toString() {
    return 'FormTemplate(id: $id, rev: $rev, deletionDate: $deletionDate, templateLayout: $templateLayout, rawTemplateLayout: $rawTemplateLayout, name: $name, guid: $guid, group: $group, descr: $descr, disabled: $disabled, specialty: $specialty, author: $author, formInstancePreferredLocation: $formInstancePreferredLocation, keyboardShortcut: $keyboardShortcut, shortReport: $shortReport, mediumReport: $mediumReport, longReport: $longReport, reports: $reports, tags: $tags, layoutAttachmentId: $layoutAttachmentId, templateLayoutAttachmentId: $templateLayoutAttachmentId)';
  }
}

/// @nodoc
abstract mixin class _$FormTemplateCopyWith<$Res>
    implements $FormTemplateCopyWith<$Res> {
  factory _$FormTemplateCopyWith(
          _FormTemplate value, $Res Function(_FormTemplate) _then) =
      __$FormTemplateCopyWithImpl;
  @override
  @useResult
  $Res call(
      {String id,
      String? rev,
      int? deletionDate,
      FormTemplateLayout? templateLayout,
      Uint8List? rawTemplateLayout,
      String? name,
      String? guid,
      DocumentGroup? group,
      String? descr,
      String? disabled,
      CodeStub? specialty,
      String? author,
      String? formInstancePreferredLocation,
      String? keyboardShortcut,
      String? shortReport,
      String? mediumReport,
      String? longReport,
      Set<String> reports,
      Set<CodeStub> tags,
      String? layoutAttachmentId,
      String? templateLayoutAttachmentId});

  @override
  $FormTemplateLayoutCopyWith<$Res>? get templateLayout;
  @override
  $DocumentGroupCopyWith<$Res>? get group;
  @override
  $CodeStubCopyWith<$Res>? get specialty;
}

/// @nodoc
class __$FormTemplateCopyWithImpl<$Res>
    implements _$FormTemplateCopyWith<$Res> {
  __$FormTemplateCopyWithImpl(this._self, this._then);

  final _FormTemplate _self;
  final $Res Function(_FormTemplate) _then;

  /// Create a copy of FormTemplate
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $Res call({
    Object? id = null,
    Object? rev = freezed,
    Object? deletionDate = freezed,
    Object? templateLayout = freezed,
    Object? rawTemplateLayout = freezed,
    Object? name = freezed,
    Object? guid = freezed,
    Object? group = freezed,
    Object? descr = freezed,
    Object? disabled = freezed,
    Object? specialty = freezed,
    Object? author = freezed,
    Object? formInstancePreferredLocation = freezed,
    Object? keyboardShortcut = freezed,
    Object? shortReport = freezed,
    Object? mediumReport = freezed,
    Object? longReport = freezed,
    Object? reports = null,
    Object? tags = null,
    Object? layoutAttachmentId = freezed,
    Object? templateLayoutAttachmentId = freezed,
  }) {
    return _then(_FormTemplate(
      id: null == id
          ? _self.id
          : id // ignore: cast_nullable_to_non_nullable
              as String,
      rev: freezed == rev
          ? _self.rev
          : rev // ignore: cast_nullable_to_non_nullable
              as String?,
      deletionDate: freezed == deletionDate
          ? _self.deletionDate
          : deletionDate // ignore: cast_nullable_to_non_nullable
              as int?,
      templateLayout: freezed == templateLayout
          ? _self.templateLayout
          : templateLayout // ignore: cast_nullable_to_non_nullable
              as FormTemplateLayout?,
      rawTemplateLayout: freezed == rawTemplateLayout
          ? _self.rawTemplateLayout
          : rawTemplateLayout // ignore: cast_nullable_to_non_nullable
              as Uint8List?,
      name: freezed == name
          ? _self.name
          : name // ignore: cast_nullable_to_non_nullable
              as String?,
      guid: freezed == guid
          ? _self.guid
          : guid // ignore: cast_nullable_to_non_nullable
              as String?,
      group: freezed == group
          ? _self.group
          : group // ignore: cast_nullable_to_non_nullable
              as DocumentGroup?,
      descr: freezed == descr
          ? _self.descr
          : descr // ignore: cast_nullable_to_non_nullable
              as String?,
      disabled: freezed == disabled
          ? _self.disabled
          : disabled // ignore: cast_nullable_to_non_nullable
              as String?,
      specialty: freezed == specialty
          ? _self.specialty
          : specialty // ignore: cast_nullable_to_non_nullable
              as CodeStub?,
      author: freezed == author
          ? _self.author
          : author // ignore: cast_nullable_to_non_nullable
              as String?,
      formInstancePreferredLocation: freezed == formInstancePreferredLocation
          ? _self.formInstancePreferredLocation
          : formInstancePreferredLocation // ignore: cast_nullable_to_non_nullable
              as String?,
      keyboardShortcut: freezed == keyboardShortcut
          ? _self.keyboardShortcut
          : keyboardShortcut // ignore: cast_nullable_to_non_nullable
              as String?,
      shortReport: freezed == shortReport
          ? _self.shortReport
          : shortReport // ignore: cast_nullable_to_non_nullable
              as String?,
      mediumReport: freezed == mediumReport
          ? _self.mediumReport
          : mediumReport // ignore: cast_nullable_to_non_nullable
              as String?,
      longReport: freezed == longReport
          ? _self.longReport
          : longReport // ignore: cast_nullable_to_non_nullable
              as String?,
      reports: null == reports
          ? _self._reports
          : reports // ignore: cast_nullable_to_non_nullable
              as Set<String>,
      tags: null == tags
          ? _self._tags
          : tags // ignore: cast_nullable_to_non_nullable
              as Set<CodeStub>,
      layoutAttachmentId: freezed == layoutAttachmentId
          ? _self.layoutAttachmentId
          : layoutAttachmentId // ignore: cast_nullable_to_non_nullable
              as String?,
      templateLayoutAttachmentId: freezed == templateLayoutAttachmentId
          ? _self.templateLayoutAttachmentId
          : templateLayoutAttachmentId // ignore: cast_nullable_to_non_nullable
              as String?,
    ));
  }

  /// Create a copy of FormTemplate
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $FormTemplateLayoutCopyWith<$Res>? get templateLayout {
    if (_self.templateLayout == null) {
      return null;
    }

    return $FormTemplateLayoutCopyWith<$Res>(_self.templateLayout!, (value) {
      return _then(_self.copyWith(templateLayout: value));
    });
  }

  /// Create a copy of FormTemplate
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $DocumentGroupCopyWith<$Res>? get group {
    if (_self.group == null) {
      return null;
    }

    return $DocumentGroupCopyWith<$Res>(_self.group!, (value) {
      return _then(_self.copyWith(group: value));
    });
  }

  /// Create a copy of FormTemplate
  /// with the given fields replaced by the non-null parameter values.
  @override
  @pragma('vm:prefer-inline')
  $CodeStubCopyWith<$Res>? get specialty {
    if (_self.specialty == null) {
      return null;
    }

    return $CodeStubCopyWith<$Res>(_self.specialty!, (value) {
      return _then(_self.copyWith(specialty: value));
    });
  }
}

// dart format on
