import 'package:device_preview/device_preview.dart';
import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:provider/provider.dart';
import 'package:url_strategy/url_strategy.dart';
import 'package:ventimetriquadri/screens/pages/home.dart';
import 'package:ventimetriquadri/screens/pages/registration_page.dart';
import 'package:ventimetriquadri/screens/pages/menu_screen.dart';
import 'package:ventimetriquadri/screens/pages/splash.dart';
import 'package:web_browser_detect/web_browser_detect.dart';

import 'databundle/data_bundle_notifier.dart';

void main() {
  //setPathUrlStrategy();
  runApp(DevicePreview(
    enabled: false,
    tools: const [
      ...DevicePreview.defaultTools,
    ],
    builder: (context) => MyApp(),
  ));
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
      create: (context) => DataBundleNotifier(),
      child: MaterialApp(
          localizationsDelegates: const [
            GlobalMaterialLocalizations.delegate
          ],
          supportedLocales: const [
            Locale('en'),
            Locale('it')
          ],
          color: const Color(0xFF121212),
          debugShowCheckedModeBanner: false,
          locale: DevicePreview.locale(context),
          builder: DevicePreview.appBuilder,
          title: '20m2',
          initialRoute: SplashScreen20m2.id,
          routes:{
            Home20m2.id : (context) => const Home20m2(),
            SplashScreen20m2.id : (context) => SplashScreen20m2(),
            MenuScreen.id : (context) => MenuScreen(),
            RegistrationPage.id : (context) => const RegistrationPage(),
          }
      ),
    );
  }
}