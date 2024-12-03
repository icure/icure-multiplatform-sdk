import 'package:cardinal_sdk/errors/cancellation_exception.dart';
import 'package:cardinal_sdk/errors/cardinal_argument_error.dart';
import 'package:cardinal_sdk/errors/internal_cardinal_error.dart';
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
  }
  return InternalCardinalError(message ?? code, platformStackTrace);
}
