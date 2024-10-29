class CaptchaOptions {

  final Map<String, dynamic> _json;

  CaptchaOptions._internal(this._json);

  factory CaptchaOptions.Recaptcha(String solution) {
    return CaptchaOptions._internal({
      "solution": solution,
      "kotlinType": "com.icure.cardinal.sdk.dart.auth.CaptchaOptions.Recaptcha"
    });
  }

  factory CaptchaOptions.FriendlyCaptcha(String solution) {
    return CaptchaOptions._internal({
      "solution": solution,
      "kotlinType": "com.icure.cardinal.sdk.dart.auth.CaptchaOptions.FriendlyCaptcha"
    });
  }

  factory CaptchaOptions.KerberusComputed(Solution solution) {
    return CaptchaOptions._internal({
      "solution": Solution.encode(solution),
      "kotlinType": "com.icure.cardinal.sdk.dart.auth.CaptchaOptions.Kerberus.Computed"
    });
  }

  factory CaptchaOptions.KerberusDelegated() {
    return CaptchaOptions._internal({
      "kotlinType": "com.icure.cardinal.sdk.dart.auth.CaptchaOptions.Kerberus.Delegated"
    });
  }

  static Map<String, dynamic> encode(CaptchaOptions value) {
    return Map.unmodifiable(value._json);
  }
}

class Solution {
  final String id;
  final List<String> nonces;

  Solution(this.id, this.nonces);

  static Map<String, dynamic> encode(Solution value) {
    return {
      "id": value.id,
      "nonces": value.nonces
    };
  }

}