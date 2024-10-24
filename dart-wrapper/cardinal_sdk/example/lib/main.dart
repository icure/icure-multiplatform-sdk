import 'dart:math';

import 'package:cardinal_sdk/model/patient.dart';
import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:cardinal_sdk/cardinal_sdk.dart';

import 'dart:math';
import 'dart:convert';

String generateUuid() {
  final random = Random.secure();

  String generateHex(int count) {
    return List<int>.generate(count, (_) => random.nextInt(256))
        .map((int byte) => byte.toRadixString(16).padLeft(2, '0'))
        .join('');
  }

  String generateTimeLow() {
    return generateHex(4);
  }

  String generateTimeMid() {
    return generateHex(2);
  }

  String generateTimeHiAndVersion() {
    final timeHi = generateHex(2);
    final hiAndVersion = (int.parse(timeHi, radix: 16) & 0x0fff) | 0x4000;
    return hiAndVersion.toRadixString(16).padLeft(4, '0');
  }

  String generateClockSeqAndReserved() {
    final clockSeq = generateHex(2);
    final clockSeqRes = (int.parse(clockSeq, radix: 16) & 0x3fff) | 0x8000;
    return clockSeqRes.toRadixString(16).padLeft(4, '0');
  }

  String generateNode() {
    return generateHex(6);
  }

  return '${generateTimeLow()}-${generateTimeMid()}-${generateTimeHiAndVersion()}-${generateClockSeqAndReserved()}-${generateNode()}';
}

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _res = 'Unfinished';

  @override
  void initState() {
    super.initState();
    initStateAsync();
  }

  Future<void> initStateAsync() async {
    print("Started init");
    final sdk = await CardinalSdk.initialize("luca+dartman@icure.com", "4a57f15e-10b3-4287-9d33-1cea74d39db3");
    print("Sdk initialized");
    final patient = await sdk.patient.createPatient(
      await sdk.patient.withEncryptionMetadata(DecryptedPatient(
        generateUuid(),
        firstName: "Gino",
        lastName: "Bros",
        note: "The third mario bros"
      ), null)
    );
    print("Created patient");
    print(patient);
    print("Retrieved patient");
    print(DecryptedPatient.encode(await sdk.patient.getPatient(patient.id)));
    print("Retrieved encrypted patient");
    print(EncryptedPatient.encode(await sdk.patient.encrypted.getPatient(patient.id)));
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Text('Example1: $_res'),
        ),
      ),
    );
  }
}
