import 'package:cardinal_sdk/auth/credentials.dart';

sealed class AuthenticationMethod {

  static Map<String, dynamic> encode(AuthenticationMethod value) {
    switch (value) {
      case UsingCredentials v:
        final encodedValue = UsingCredentials.encode(v);
        encodedValue["type"] = "com.icure.cardinal.sdk.dart.options.AuthenticationMethod.UsingCredentials";
        return encodedValue;
    }
  }

}

class UsingCredentials extends AuthenticationMethod {
  final Credentials _credentials;

  UsingCredentials(this._credentials);

  static Map<String, dynamic> encode(UsingCredentials value) {
    return {
      "credentials": Credentials.encode(value._credentials)
    };
  }
}