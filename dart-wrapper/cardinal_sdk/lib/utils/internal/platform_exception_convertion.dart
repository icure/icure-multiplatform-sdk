import 'package:cardinal_sdk/errors/cancellation_exception.dart';
import 'package:cardinal_sdk/errors/cardinal_argument_error.dart';
import 'package:cardinal_sdk/errors/dart_callback_exception.dart';
import 'package:cardinal_sdk/errors/internal_cardinal_error.dart';
import 'package:cardinal_sdk/utils/internal/error_references.dart';
import 'package:flutter/services.dart';

Never convertPlatformException(dynamic e) {
  if (e is PlatformException) {
    throw _platformExceptionDetailsToDart(e.code, e.message, e.details as String?);
  } else {
    throw e;
  }
}

dynamic _platformExceptionDetailsToDart(String code, String? message, String? platformStackTrace) {
  switch (code) {
    case "IllegalArgumentException":
      return CardinalArgumentError(message ?? code, platformStackTrace);
    case "IllegalStateException":
      return CardinalArgumentError(message ?? code, platformStackTrace);
    case "RevisionConflictException":
      return CardinalArgumentError(message ?? code, platformStackTrace);
    case "CancellationException":
    case "JobCancellationException":
      return CancellationException(platformStackTrace);
    case "DartCallbackException":
      if (message == null) throw AssertionError("Message should not be null for dart callback exceptions");
      final errorDetails = ErrorReferences.pop(message);
      if (errorDetails == null) throw AssertionError("Missing error details for dart callback exception");
      return DartCallbackException(
          dartException: errorDetails.e,
          dartStackTrace: errorDetails.trace,
          platformStackTrace: platformStackTrace
      );
  }
  return InternalCardinalError(message ?? code, platformStackTrace);
}
