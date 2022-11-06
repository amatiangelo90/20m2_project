import 'package:flutter/cupertino.dart';
import 'package:flutter/foundation.dart';
import 'package:intl/intl.dart';
import '../output/swagger.swagger.dart';
import 'Branch.dart';

class DataBundleNotifier extends ChangeNotifier{

  String baseUrlHttps = 'https://servicedbacorp741w.com:8444/ventimetriquadriservice';
  String baseUrlHttp = 'http://servicedbacorp741w.com:8080/ventimetriquadriservice';

  String pdfItaCisternino = 'assets/MENU-CISTERNINO-2022_GIUGNO.pdf';
  String pdfEnCisternino = 'assets/MENU-CISTERNINO-2022_GIUGNO-INGLESE.pdf';
  String pdfItaLocorotondo = 'assets/MENU-LOCOROTONDO-2022_GIUGNO.pdf';
  String pdfEngLocorotondo = 'assets/MENU-LOCOROTONDO-2022_GIUGNO-INGLESE.pdf';
  String pdfItaMonopoli = 'assets/MENU-MONOPOLI-2022_GIUGNO.pdf';
  String pdfEngMonopoli = 'assets/MENU-MONOPOLI-2022_GIUGNO-INGLESE.pdf';

  String currentPdfIta = '';
  String currentPdfEng = '';

  TextEditingController nameController = TextEditingController();
  TextEditingController lastnameController = TextEditingController();
  TextEditingController emailController = TextEditingController();
  TextEditingController phoneController = TextEditingController();
  String dob = '';

  Branch currentBranch = Branch.CISTERNINO;

  DateFormat dateFormat = DateFormat("dd-MM-yyyy");

  late User20m2 currentUser;

  DateTime currentDate = DateTime(1990, 05, 19, 0,0,0,0,0);

  bool checkedValue = false;

  String currentLanguage = 'ITA';

  String formErrors = 'false';

  String errorFormMessage = '';

  void switchCurrentLanguage(){
    if(currentLanguage == 'ITA'){
      currentLanguage = 'ENG';
    }else{
      currentLanguage = 'ITA';
    }

    notifyListeners();
  }

  void setCurrentBranch(Branch branch){
    currentBranch = branch;
    switch(branch){
      case Branch.CISTERNINO:
        currentPdfIta = pdfItaCisternino;
        currentPdfEng = pdfEnCisternino;
        break;
      case Branch.LOCOROTONDO:
        currentPdfIta = pdfItaLocorotondo;
        currentPdfEng = pdfEngLocorotondo;
        break;
      case Branch.MONOPOLI:
        currentPdfIta = pdfItaMonopoli;
        currentPdfEng = pdfEngMonopoli;
        break;
    }
    notifyListeners();
  }

  void turnCheckedValue(){
    if(checkedValue){
      checkedValue = false;
    }else{
      checkedValue = true;
    }
    notifyListeners();
  }

  void setCurrentUser(User20m2 user){
    currentUser = user;
    alreadyRegisteredUser = true;
    emailController.text = currentUser.email!;
    nameController.text = currentUser.name!;
    lastnameController.text = currentUser.lastname!;

    try{
      currentDate = dateFormat.parse(currentUser.dob!);
    }catch(e){
      print('date invalid');
    }
    checkedValue = currentUser.treatmentPersonalData!;
    notifyListeners();
  }

  bool alreadyRegisteredUser = false;

  Swagger getSwaggerClient(){
    if(kIsWeb){
      return Swagger.create(
          baseUrl: baseUrlHttps
      );
    }else{
      return Swagger.create(
          baseUrl: baseUrlHttp
      );
    }
  }

  void setCurrentDate(DateTime date) {
    dob = dateFormat.format(date);
    notifyListeners();
  }

  void setErrorFlag(String value) {
    formErrors = value;
    notifyListeners();
  }

  void setErrorMessage(String s) {
    errorFormMessage = s;
    notifyListeners();
  }
}