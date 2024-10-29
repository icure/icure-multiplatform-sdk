// ignore_for_file: avoid_print

import 'dart:developer';
import 'dart:io';
import 'dart:math';

import 'package:cardinal_sdk/auth/authentication_method.dart';
import 'package:cardinal_sdk/auth/authentication_process_telecom_type.dart';
import 'package:cardinal_sdk/auth/captcha_options.dart';
import 'package:cardinal_sdk/auth/credentials.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/filters/meta_filters.dart';
import 'package:cardinal_sdk/filters/patient_filters.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/options/storage_options.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:flutter/material.dart';
import 'dart:async';

import 'package:cardinal_sdk/cardinal_sdk.dart';

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
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text('Auth App')),
        body: AuthForm(),
      ),
    );
  }
}

class AuthForm extends StatefulWidget {
  @override
  _AuthFormState createState() => _AuthFormState();
}

class _AuthFormState extends State<AuthForm> {
  final TextEditingController emailController = TextEditingController();
  final TextEditingController codeController = TextEditingController();
  AuthenticationWithProcessStep? step;

  void startInit(String email) async {
    print("Starting auth");
    step = await CardinalSdk.initializeWithProcess(
      null,
      "https://api.icure.cloud",
      "https://msg-gw.icure.cloud",
      throw UnimplementedError("Take the specId from the cockpit"),
      throw UnimplementedError("Take the processId from the cockpit"),
      AuthenticationProcessTelecomType.email,
      email,
      CaptchaOptions.KerberusDelegated(),
      StorageOptions.PlatformDefault,
    );
    print("Auth process started");
  }

  Future<void> usePages(CardinalSdk sdk) async {
    final pages = await sdk.patient.encrypted.filterPatientsBy(await PatientFilters.allPatientsForSelf());
    while (await pages.hasNext()) {
      print("Got page ${(await pages.next(10)).map((e) => EncryptedPatient.encode(e)).toList()}");
    }
  }

  Future<void> doFilterExample() async {
    final simple = PatientFilters.byActiveForSelf(true);
    final sortable = PatientFilters.byAddressForSelf("address");
    print("Simple ${FilterOptions.encode(await simple)}");
    print("Sortable ${FilterOptions.encode(await simple)}");
    print("(sortable & simple) - (sortable | (simple & sortable)) ${FilterOptions.encode(await ((sortable & simple) - (sortable | (simple & sortable))))}");
  }

  void completeInitAndTry(String code) async {
    final currStep = step;
    if (currStep == null) {
      print("Authentication with process step not set");
      return;
    }
    print("Completing auth");
    final sdk = await currStep.completeAuthentication(code);
    print("Sdk initialized");
    final patient = await sdk.patient.createPatient(
      await sdk.patient.withEncryptionMetadata(DecryptedPatient(
        generateUuid(),
        firstName: "Gino",
        lastName: "Bros",
        note: "The third mario bros"
      ))
    );
    print("Created patient");
    print(patient);
    print("Retrieved patient");
    print(DecryptedPatient.encode(await sdk.patient.getPatient(patient.id)));
    print("Retrieved encrypted patient");
    print(EncryptedPatient.encode(await sdk.patient.encrypted.getPatient(patient.id)));
    // print("Creating more patients");
    // final List<DecryptedPatient> manyPatients = [];
    // for (int i = 0; i < 100; i++) {
    //   manyPatients.add(await sdk.patient.withEncryptionMetadata(DecryptedPatient(
    //           generateUuid(),
    //           firstName: "Gino",
    //           lastName: "Bros-${generateUuid()}",
    //           note: "The third mario bros"
    //   ), null));
    // }
    // await sdk.patient.createPatients(manyPatients);
    // print("Created many patients, now retrieving");
    final filter = await PatientFilters.allPatientsForSelf();
    await usePages(sdk);
    await forceGC();
    print("Subscribing");
    final subscription = await sdk.patient.subscribeToEvents({SubscriptionEventType.create}, filter);
    print("Subscribed, get some events expecting null");
    print("GetEvent returned ${await subscription.getEvent()}");
    print("WaitForEvent 2s returned ${await subscription.waitForEvent(const Duration(seconds: 2))}");
    print("Create some data and get event");
    for (int i = 0; i < 3; i++) {
      await sdk.patient.createPatient(await sdk.patient.withEncryptionMetadata(DecryptedPatient(
        generateUuid(),
        firstName: "Gino",
        lastName: "Bros-${generateUuid()}",
        note: "$i"
      )));
      if (i % 2 == 0) {
        print("WaitForEvent 1s returned ${await subscription.waitForEvent(const Duration(seconds: 1))}");
      } else {
        sleep(const Duration(seconds: 1));
        print("GetEvent returned ${await subscription.getEvent()}");
      }
    }
    print("Closing");
    await subscription.close();
    print("Close reason ${await subscription.getCloseReason()}");
    print("Done iterating");
    await doFilterExample();
  }

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          TextField(
            controller: emailController,
            decoration: InputDecoration(labelText: 'Email'),
          ),
          TextField(
            controller: codeController,
            decoration: InputDecoration(labelText: 'Code'),
          ),
          SizedBox(height: 20),
          ElevatedButton(
            onPressed: () => startInit(emailController.text),
            child: Text('Start Auth'),
          ),
          ElevatedButton(
            onPressed: () => completeInitAndTry(codeController.text),
            child: Text('Try SDK'),
          ),
        ],
      ),
    );
  }
}

Future<void> forceGC({
  Duration? timeout,
  int fullGcCycles = 1,
}) async {
  final stopwatch = timeout == null ? null : (Stopwatch()..start());
  final barrier = reachabilityBarrier;

  final storage = <List<int>>[];

  void allocateMemory() {
    storage.add(List.generate(30000, (n) => n));
    if (storage.length > 100) {
      storage.removeAt(0);
    }
  }

  while (reachabilityBarrier < barrier + fullGcCycles) {
    if ((stopwatch?.elapsed ?? Duration.zero) > (timeout ?? Duration.zero)) {
      throw TimeoutException('forceGC timed out', timeout);
    }
    await Future<void>.delayed(Duration.zero);
    allocateMemory();
  }
}
