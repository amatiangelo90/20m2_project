import 'package:chopper/chopper.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_holo_date_picker/date_picker_theme.dart';
import 'package:flutter_holo_date_picker/i18n/date_picker_i18n.dart';
import 'package:flutter_holo_date_picker/widget/date_picker_widget.dart';
import 'package:provider/provider.dart';
import 'package:ventimetriquadri/databundle/data_bundle_notifier.dart';
import 'package:ventimetriquadri/output/swagger.swagger.dart';
import 'package:ventimetriquadri/screens/pages/menu_screen.dart';


class RegistrationPage extends StatefulWidget {
  const RegistrationPage({Key? key}) : super(key: key);

  static String id = 'menu';

  @override
  State<RegistrationPage> createState() => _RegistrationPageState();
}

class _RegistrationPageState extends State<RegistrationPage> {

  @override
  Widget build(BuildContext context) {
    return Consumer<DataBundleNotifier>(
      builder: (child, dataBundleNotifier, _){
        return GestureDetector(
          onTap: (){
            FocusScope.of(context).requestFocus(FocusNode());
          },
          child: Scaffold(
            appBar: AppBar(
              actions: [
                GestureDetector(
                  onLongPress: (){
                    Navigator.pushNamed(context, MenuScreen.id);
                  },
                  child: Image.asset('images/whitenobg.png', height: 100),
                )
              ],
              leading: IconButton(
                icon: Icon(Icons.arrow_back_ios),
                onPressed: (){
                  Navigator.of(context).pop();
                },
              ),
              title: const Text(
                'Dati personali' , style: TextStyle(
                  color: Colors.white,
                  fontFamily: 'Dance',
                  fontWeight: FontWeight.bold,
                  fontSize: 19
              ),
              ),
              centerTitle: true,
              elevation: 0,
              backgroundColor: const Color(0xFF121212),
            ),
            backgroundColor: const Color(0xFFfdfdff),
            body: Container(
              width: double.infinity,
              padding: const EdgeInsets.all(8.0),
              child: SingleChildScrollView(
                scrollDirection: Axis.vertical,
                child: AutofillGroup(
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.stretch,
                    children: <Widget>[
                      dataBundleNotifier.alreadyRegisteredUser ? Padding(
                        padding: const EdgeInsets.all(5.0),
                        child: Center(
                          child: Text(
                            'Bentornato/a ${dataBundleNotifier.currentUser.name!} 😎' , style: TextStyle(
                              color: Colors.grey.shade700,
                              fontFamily: 'Dance',
                              fontWeight: FontWeight.bold,
                              fontSize: 19
                          ),
                          ),
                        ),
                      ) : const Text(''),
                      Row(
                        children: [
                          Text(
                            ' +39  ' , style: TextStyle(
                              color: Colors.grey.shade700,
                              fontFamily: 'Dance',
                              fontWeight: FontWeight.bold,
                              fontSize: 19
                          ),
                          ),
                          Expanded(
                            child: TextFormField(
                              autofillHints: const [AutofillHints.telephoneNumber],
                              style: TextStyle(
                                  color: Colors.grey.shade700,
                                  fontFamily: 'Dance',
                                  fontWeight: FontWeight.bold,
                                  fontSize: 16
                              ),
                              textInputAction: TextInputAction.next,
                              textCapitalization: TextCapitalization.words,
                              keyboardType: TextInputType.number,
                              onChanged: (phoneNumber) async {
                                if(phoneNumber.length >= 10){
                                  Response apiV1UserFindallGet = await dataBundleNotifier
                                      .getSwaggerClient().apiV1WebsiteCustomersFindbyphoneGet(phone: dataBundleNotifier.phoneController.text);
                                  if(apiV1UserFindallGet.isSuccessful){
                                    if(apiV1UserFindallGet.body != null){
                                      dataBundleNotifier.setCurrentUser(apiV1UserFindallGet.body);
                                      dataBundleNotifier.getSwaggerClient().apiV1WebsiteCustomersUpdatePut(
                                        customerId: dataBundleNotifier.currentUser.customerId!.toInt(),
                                        phoneNumber: dataBundleNotifier.currentUser.phoneNumber,
                                        name: dataBundleNotifier.currentUser.name,
                                        dob: dataBundleNotifier.dob,
                                        email: dataBundleNotifier.currentUser.email,
                                        lastname: dataBundleNotifier.currentUser.lastname,
                                        treatmentPersonalData: dataBundleNotifier.currentUser.treatmentPersonalData,
                                        accessCounter: dataBundleNotifier.currentUser!.accessCounter! + 1,
                                      );
                                      FocusManager.instance.primaryFocus?.unfocus();
                                    }
                                  }
                                }
                              },
                              decoration: const InputDecoration(
                                  filled: true,
                                  fillColor: Color(0xfffdfdff),
                                  focusedBorder: OutlineInputBorder(
                                    borderRadius: BorderRadius.all(Radius.circular(20.0)),
                                    borderSide: BorderSide(color: Colors.grey, width: 1.3),
                                  ),
                                  labelText: 'cellulare *',
                                  enabledBorder: OutlineInputBorder(
                                    borderRadius: BorderRadius.all(Radius.circular(20.0)),
                                    borderSide: BorderSide(color: Colors.grey, width: 1.0),
                                  ),
                                  focusColor: Colors.grey,
                                  border: OutlineInputBorder()),
                              controller: dataBundleNotifier.phoneController,
                            ),
                          ),
                        ],
                      ),
                      const SizedBox(height: 9,),
                      TextFormField(
                        autofillHints: const [AutofillHints.givenName],
                        style: TextStyle(
                            color: Colors.grey.shade700,
                            fontFamily: 'Dance',
                            fontWeight: FontWeight.bold,
                            fontSize: 16
                        ),
                        textInputAction: TextInputAction.next,
                        textCapitalization: TextCapitalization.words,
                        onEditingComplete: (){
                        },
                        decoration: const InputDecoration(
                            focusedBorder: OutlineInputBorder(
                              borderRadius: BorderRadius.all(Radius.circular(20.0)),
                              borderSide: BorderSide(color: Colors.grey, width: 1.3),
                            ),
                            labelText: 'nome *',
                            enabledBorder: OutlineInputBorder(
                              borderRadius: BorderRadius.all(Radius.circular(20.0)),
                              borderSide: BorderSide(color: Colors.grey, width: 1.0),
                            ),
                            hintStyle: TextStyle(color: Colors.red),
                            filled: true,
                            fillColor: Color(0xfffdfdff),
                            focusColor: Colors.grey,
                            border: OutlineInputBorder()),
                        controller: dataBundleNotifier.nameController,
                      ),
                      const SizedBox(height: 9,),
                      TextFormField(
                        autofillHints: const [AutofillHints.familyName],
                        style: TextStyle(
                            color: Colors.grey.shade700,
                            fontFamily: 'Dance',
                            fontWeight: FontWeight.bold,
                            fontSize: 16
                        ),
                        textInputAction: TextInputAction.next,
                        textCapitalization: TextCapitalization.words,
                        onEditingComplete: (){
                        },
                        decoration: const InputDecoration(
                            focusedBorder: OutlineInputBorder(
                              borderRadius: BorderRadius.all(Radius.circular(20.0)),
                              borderSide: BorderSide(color: Colors.grey, width: 1.3),
                            ),
                            labelText: 'cognome *',
                            enabledBorder: OutlineInputBorder(
                              borderRadius: BorderRadius.all(Radius.circular(20.0)),
                              borderSide: BorderSide(color: Colors.grey, width: 1.0),
                            ),
                            hintStyle: TextStyle(color: Colors.red),
                            filled: true,
                            fillColor: Color(0xfffdfdff),
                            focusColor: Colors.grey,
                            border: OutlineInputBorder()),
                        controller: dataBundleNotifier.lastnameController,
                      ),
                      const SizedBox(height: 9,),
                      TextFormField(
                        autofillHints: const [AutofillHints.email],
                        style: TextStyle(
                            color: Colors.grey.shade700,
                            fontFamily: 'Dance',
                            fontWeight: FontWeight.bold,
                            fontSize: 16
                        ),
                        textInputAction: TextInputAction.next,
                        textCapitalization: TextCapitalization.words,
                        onEditingComplete: (){
                        },
                        decoration: const InputDecoration(
                            focusedBorder: OutlineInputBorder(
                              borderRadius: BorderRadius.all(Radius.circular(20.0)),
                              borderSide: BorderSide(color: Colors.grey, width: 1.3),
                            ),
                            labelText: 'email',
                            enabledBorder: OutlineInputBorder(
                              borderRadius: BorderRadius.all(Radius.circular(20.0)),
                              borderSide: BorderSide(color: Colors.grey, width: 1.0),
                            ),
                            hintStyle: TextStyle(color: Colors.red),
                            filled: true,
                            fillColor: Color(0xfffdfdff),
                            focusColor: Colors.grey,
                            border: OutlineInputBorder()),
                        controller: dataBundleNotifier.emailController,
                      ),
                      const SizedBox(height: 5,),
                      Text(' Data di nascita *', style: TextStyle(
                          color: Colors.grey.shade700,
                          fontFamily: 'Dance',
                          fontWeight: FontWeight.bold,
                          fontSize: 16
                      ),),
                      Padding(
                        padding: const EdgeInsets.all(3.0),
                        child: Container(
                          decoration: BoxDecoration(
                              color: Colors.white,
                              border: Border.all(color: Colors.grey),
                              borderRadius: const BorderRadius.all(
                                Radius.circular(15.0)
                            ),
                          ),
                          child: DatePickerWidget(
                            looping: false,
                            firstDate: DateTime(1940),
                            lastDate: DateTime(2018),
                            locale: DateTimePickerLocale.it,
                            dateFormat:
                            "dd/MMMM/yyyy",
                            // locale: DatePicker.localeFromString('th'),
                            onChange: (DateTime newDate, _) {
                              dataBundleNotifier.setDbo(newDate);
                            },
                            pickerTheme: DateTimePickerTheme(
                              backgroundColor: Colors.transparent,
                              itemTextStyle:
                              const TextStyle(color: Colors.black, fontFamily: 'Dance', fontWeight: FontWeight.bold, fontSize: 19),
                              dividerColor: Colors.grey.shade700,
                            ),
                          ),
                        ),
                      ),
                      const SizedBox(height: 9,),
                      Text(
                        '  campo obbligatorio *' , style: TextStyle(
                          color: Colors.grey.shade700,
                          fontFamily: 'Dance',
                          fontWeight: FontWeight.bold,
                          fontSize: 11
                      ),
                      ),
                      Padding(
                        padding: const EdgeInsets.only(right: 10, left: 10),
                        child: Center(
                          child: Row(
                            children: [
                              Checkbox(
                                fillColor: MaterialStateProperty.resolveWith((states) => Colors.grey.shade700,),
                                activeColor: Colors.blueGrey,
                                value: dataBundleNotifier.checkedValue, onChanged: (val){
                                dataBundleNotifier.turnCheckedValue();
                              },),
                              Text(
                                'Presto il consenso al trattamento dei dati personali',style: TextStyle(
                                  color: Colors.grey.shade700,
                                  fontFamily: 'Dance',
                                  fontWeight: FontWeight.bold,
                                  fontSize: 12
                              ),
                              ),
                            ],
                          ),
                        ),
                      ),
                      Center(child: Text( dataBundleNotifier.formErrors == 'true' ? dataBundleNotifier.errorFormMessage : '', style: TextStyle(fontFamily: 'Dance', color: Colors.red, fontWeight: FontWeight.bold, fontSize: 16),)),
                      SizedBox(
                        width: 300,
                        height: 50,

                        child: ElevatedButton(onPressed: (){

                          dataBundleNotifier.setErrorFlag('false');
                          dataBundleNotifier.setErrorMessage('');
                          if(dataBundleNotifier.phoneController.text.isEmpty){
                            dataBundleNotifier.setErrorFlag('true');
                            dataBundleNotifier.setErrorMessage('Inserisci il numero di cellulare');
                          }else if(dataBundleNotifier.nameController.text.isEmpty){
                            dataBundleNotifier.setErrorFlag('true');
                            dataBundleNotifier.setErrorMessage('Inserisci il nome');
                          }else if(dataBundleNotifier.lastnameController.text.isEmpty){
                            dataBundleNotifier.setErrorFlag('true');
                            dataBundleNotifier.setErrorMessage('Inserisci il cognome');
                          }else if(dataBundleNotifier.dob == ''){
                            dataBundleNotifier.setErrorFlag('true');
                            dataBundleNotifier.setErrorMessage('Inserisci la data di nascita');
                          }
                          else{
                            try{
                              dataBundleNotifier.getSwaggerClient().apiV1WebsiteCustomersSavePost(
                                  name: dataBundleNotifier.nameController.text,
                                  dob: dataBundleNotifier.dob,
                                  email: dataBundleNotifier.emailController.text,
                                  lastname: dataBundleNotifier.lastnameController.text,
                                  phoneNumber: dataBundleNotifier.phoneController.text,
                                  treatmentPersonalData: dataBundleNotifier.checkedValue,
                                  customerId: 0,
                                  accessCounter: 1,
                                  branch20m2: customersBranch20m2ToJson(CustomersBranch20m2.cisternino),
                              );
                            }catch(e){
                              print(e.toString());
                            }
                            Navigator.pushNamed(context, MenuScreen.id);
                          }
                        },style: ButtonStyle(
                            backgroundColor: MaterialStateProperty.resolveWith((states) => Colors.white,),
                            shape: MaterialStateProperty.all<RoundedRectangleBorder>(
                                RoundedRectangleBorder(
                                    borderRadius: BorderRadius.circular(18.0),
                                    side: const BorderSide(color: Colors.grey)
                                )
                            )
                        ), child: Text('ACCEDI AL MENU\'',
                            style: TextStyle(fontWeight: FontWeight.bold, color:
                            Colors.grey.shade700, fontSize: 18, fontFamily: 'Dance')),),
                      ),
                    ],
                  ),
                ),
              ),
            ),
          ),
        );
      },
    );
  }
}
