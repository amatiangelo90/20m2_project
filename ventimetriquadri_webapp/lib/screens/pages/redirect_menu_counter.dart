import 'package:circular_countdown_timer/circular_countdown_timer.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class RedirectMenu extends StatefulWidget {
  const RedirectMenu({Key? key}) : super(key: key);

  @override
  State<RedirectMenu> createState() => _RedirectMenuState();
}

class _RedirectMenuState extends State<RedirectMenu> {
  @override
  Widget build(BuildContext context) {
    return Container(
      child: CircularCountDownTimer(
        duration: 3,
        initialDuration: 3,
        controller: CountDownController(),
        width: MediaQuery.of(context).size.width / 2,
        height: MediaQuery.of(context).size.height / 2,
        ringColor: Colors.grey[300]!,
        ringGradient: null,
        fillColor: Colors.purpleAccent[100]!,
        fillGradient: null,
        backgroundColor: Colors.purple[500],
        backgroundGradient: null,
        strokeWidth: 20.0,
        strokeCap: StrokeCap.round,
        textStyle: const TextStyle(
            fontSize: 33.0, color: Colors.white, fontWeight: FontWeight.bold),
        textFormat: CountdownTextFormat.S,
        isReverse: true,
        isReverseAnimation: true,
        isTimerTextShown: true,
        autoStart: false,
        onStart: () {
          debugPrint('Countdown Started');
        },
        onComplete: () {
          debugPrint('Countdown Ended');
        },
        onChange: (String timeStamp) {
          debugPrint('Countdown Changed $timeStamp');
        },
        timeFormatterFunction: (defaultFormatterFunction, duration) {
          if (duration.inSeconds == 0) {
            return "Start";
          } else {
            return Function.apply(defaultFormatterFunction, [duration]);
          }
        },
      ),
    );
  }
}
