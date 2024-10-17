import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:cardinal_sdk/cardinal_sdk.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _res1 = 'Unfinished 1';
  String _res2 = 'Unfinished 2';
  final _cardinalSdkPlugin = CardinalSdk();

  @override
  void initState() {
    super.initState();
    initState2();
    initState1();
  }

  Future<void> initState1() async {
    print("Started state 1");
    String platformVersion;
    try {
      platformVersion =
          await _cardinalSdkPlugin.example(5000) ?? 'Null example 5000';
      print("On init state 1 done with $platformVersion");
    } on PlatformException {
      platformVersion = 'Failed to get platform version.';
    }
    if (!mounted) return;
    setState(() {
      _res1 = platformVersion;
    });
  }

  Future<void> initState2() async {
    print("Started state 2");
    String platformVersion;
    try {
      platformVersion =
          await _cardinalSdkPlugin.example(5001) ?? 'Null example 5001';
      print("On init state 2 done with $platformVersion");
    } on PlatformException {
      platformVersion = 'Failed to get platform version.';
    }

    if (!mounted) return;

    setState(() {
      _res2 = platformVersion;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Text('Example1: $_res1\nExample2: $_res2\n'),
        ),
      ),
    );
  }
}
