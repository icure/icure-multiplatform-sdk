class AuthenticationProcessTemplateParameters {
  final String? firstName;
  final String? lastName;

  const AuthenticationProcessTemplateParameters({
    this.firstName,
    this.lastName
  });

  static Map<String, dynamic> encode(AuthenticationProcessTemplateParameters value) {
    return {
      "firstName": value.firstName,
      "lastName": value.lastName
    };
  }
}