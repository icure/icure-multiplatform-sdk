enum AuthenticationProcessTelecomType {
  email, mobilePhone;

  static String encode(AuthenticationProcessTelecomType value) {
    switch(value) {
      case AuthenticationProcessTelecomType.email:
        return "Email";
      case AuthenticationProcessTelecomType.mobilePhone:
        return "MobilePhone";
    }
  }
}