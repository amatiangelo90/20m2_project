import 'dart:async';
import 'package:flutter/material.dart';
import 'package:web_browser_detect/web_browser_detect.dart';
import 'home.dart';

class SplashScreen20m2 extends StatefulWidget {
  static String id = 'splash';
  @override
  _SplashScreen20m2State createState() => _SplashScreen20m2State();
}

class _SplashScreen20m2State extends State<SplashScreen20m2> {

  @override
  void initState() {
    Timer(
      const Duration(milliseconds: 3000), () {
      Navigator.pushNamed(context, Home20m2.id);
    },
    );
    super.initState();

  }

  @override
  Widget build(BuildContext context) {
    return  SafeArea(
      child: Container(
        color: Color(0xff121212),
        child: Center(
          child: SizedBox(
            height: 150,
            child: Image.asset('images/whitenobg.png',
              fit: BoxFit.contain,
            ),
          ),
        ),
      ),
    );
  }
}