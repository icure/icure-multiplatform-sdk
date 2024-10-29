import 'package:cardinal_sdk/auth/credentials.dart';

class AuthenticationMethod {
  final Map<String, dynamic> _json;
  AuthenticationMethod._internal(this._json);

  factory AuthenticationMethod.UsingCredentials(Credentials credentials) {
    return AuthenticationMethod._internal(
        {
          "kotlinType": "com.icure.cardinal.sdk.dart.auth.AuthenticationMethod.UsingCredentials",
          "credentials": Credentials.encode(credentials)
        }
    );
  }

  static Map<String, dynamic> encode(AuthenticationMethod value) {
    return Map.unmodifiable(value._json);
  }
}