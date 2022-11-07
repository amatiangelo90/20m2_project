import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../../databundle/branch.dart';
import '../../databundle/data_bundle_notifier.dart';
import '../../menu/pdf_viewer.dart';

class MenuScreen extends StatefulWidget {
  static String id = 'menudetails';
  @override
  _MenuScreenState createState() => _MenuScreenState();
}

class _MenuScreenState extends State<MenuScreen> {

  late double height;
  late double width;

  @override
  Widget build(BuildContext context) {

    height  = MediaQuery.of(context).size.height;
    width  = MediaQuery.of(context).size.width;
    return GestureDetector(
      onTap: (){
        FocusScope.of(context).requestFocus(FocusNode());
      },
      child: Consumer<DataBundleNotifier>(
        builder: (child, bundleNotifier, _){
          return Scaffold(
            appBar: AppBar(
              leading: IconButton(
                icon: Icon(Icons.arrow_back_ios),
                onPressed: (){
                  Navigator.of(context).pop();
                },
              ),
              title: const Text('20M2 - PANINI E POI..',
                  style: TextStyle(fontWeight: FontWeight.w500, color:
                  Colors.white, fontSize: 18, fontFamily: 'Dance')),
              backgroundColor: Color(0xff121212),
            ),
            body: Container(
              decoration: BoxDecoration(
                image: DecorationImage(
                  colorFilter: ColorFilter.mode(Colors.black.withOpacity(0.5), BlendMode.hardLight),
                  image: const AssetImage("images/20m2.png"),
                  fit: BoxFit.cover,
                ),
              ),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.spaceAround,
                children: [
                  const SizedBox(height: 180),
                  Center(
                    child: Column(
                      children: [
                        Image.asset('images/20m2_logo.png', height: 55),
                        const Text('20M2 - PANINI E POI..',
                            style: TextStyle(fontWeight: FontWeight.w500, color:
                            Colors.white, fontSize: 9, fontFamily: 'Dance'))
                      ],
                    ),
                  ),
                  const SizedBox(height: 105),
                  Column(
                    children: [
                      buildButton('MENU\' CISTERNINO', bundleNotifier, Branch20m2.CISTERNINO),
                      buildButton('MENU\' LOCOROTONDO', bundleNotifier, Branch20m2.LOCOROTONDO),
                      buildButton('MENU\' MONOPOLI', bundleNotifier, Branch20m2.MONOPOLI),

                    ],
                  ),
                ],
              ) /* add child content here */,
            ),
          );
        },
      ),
    );
  }

  buildButton(String s, DataBundleNotifier bundleNotifier,
      Branch20m2 branch) {
    return Padding(
      padding: const EdgeInsets.only(bottom: 10),
      child: SizedBox(
        width: width - 30,
        height: 60,

        child: ElevatedButton(onPressed: (){
          bundleNotifier.setCurrentBranch(branch);
          Navigator.push(
            context,
            MaterialPageRoute(
              builder: (context) => PdfViewerPage(),
            ),
          );
        },style: ButtonStyle(
            backgroundColor: MaterialStateProperty.resolveWith((states) => Colors.transparent),
            shape: MaterialStateProperty.all<RoundedRectangleBorder>(
                RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(18.0),
                    side: const BorderSide(color: Colors.white)
                )
            )
        ), child: Text(s,
            style: const TextStyle(fontWeight: FontWeight.bold, color:
            Colors.white, fontSize: 25, fontFamily: 'Dance')),),
      ),
    );
  }
}