//Generated code

part of 'swagger.swagger.dart';

// **************************************************************************
// ChopperGenerator
// **************************************************************************

// ignore_for_file: always_put_control_body_on_new_line, always_specify_types, prefer_const_declarations, unnecessary_brace_in_string_interps
class _$Swagger extends Swagger {
  _$Swagger([ChopperClient? client]) {
    if (client == null) return;
    this.client = client;
  }

  @override
  final definitionType = Swagger;

  @override
  Future<Response<dynamic>> _apiV1UserDeleteDelete({
    int? userId,
    String? name,
    String? lastname,
    String? email,
    String? phoneNumber,
    String? dob,
    bool? treatmentPersonalData,
  }) {
    final String $url = '/api/v1/user/delete';
    final Map<String, dynamic> $params = <String, dynamic>{
      'userId': userId,
      'name': name,
      'lastname': lastname,
      'email': email,
      'phoneNumber': phoneNumber,
      'dob': dob,
      'treatmentPersonalData': treatmentPersonalData,
    };
    final Request $request = Request(
      'DELETE',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }

  @override
  Future<Response<List<User20m2>>> _apiV1UserFindallGet() {
    final String $url = '/api/v1/user/findall';
    final Request $request = Request(
      'GET',
      $url,
      client.baseUrl,
    );
    return client.send<List<User20m2>, User20m2>($request);
  }

  @override
  Future<Response<User20m2>> _apiV1UserFindbyphoneGet(
      {required String? phone}) {
    final String $url = '/api/v1/user/findbyphone';
    final Map<String, dynamic> $params = <String, dynamic>{'phone': phone};
    final Request $request = Request(
      'GET',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<User20m2, User20m2>($request);
  }

  @override
  Future<Response<dynamic>> _apiV1UserSavePost({
    int? userId,
    String? name,
    String? lastname,
    String? email,
    String? phoneNumber,
    String? dob,
    bool? treatmentPersonalData,
  }) {
    final String $url = '/api/v1/user/save';
    final Map<String, dynamic> $params = <String, dynamic>{
      'userId': userId,
      'name': name,
      'lastname': lastname,
      'email': email,
      'phoneNumber': phoneNumber,
      'dob': dob,
      'treatmentPersonalData': treatmentPersonalData,
    };
    final Request $request = Request(
      'POST',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }

  @override
  Future<Response<dynamic>> _apiV1UserUpdatePut({
    int? userId,
    String? name,
    String? lastname,
    String? email,
    String? phoneNumber,
    String? dob,
    bool? treatmentPersonalData,
  }) {
    final String $url = '/api/v1/user/update';
    final Map<String, dynamic> $params = <String, dynamic>{
      'userId': userId,
      'name': name,
      'lastname': lastname,
      'email': email,
      'phoneNumber': phoneNumber,
      'dob': dob,
      'treatmentPersonalData': treatmentPersonalData,
    };
    final Request $request = Request(
      'PUT',
      $url,
      client.baseUrl,
      parameters: $params,
    );
    return client.send<dynamic, dynamic>($request);
  }
}
