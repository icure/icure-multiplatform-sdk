import 'dart:async';

import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';

/// A future associated to a job that can be cancelled.
/// If you use an API method that return this future and don't have an interest in the result anymore you should call
/// the cancel method, or the job will keep running and waste resources.
/// Note that the future's job will only be cancelled when cancel is explicitly called: if you use timeout and the
/// timeLimit expires the job will keep executing.
class CancellableFuture<T> implements Future<T> {
  final Future<T> _future;
  final int _cancellationToken;

  CancellableFuture.internalConstructor(this._future, this._cancellationToken);

  @override
  Stream<T> asStream() {
    return this._future.asStream();
  }

  @override
  CancellableFuture<T> catchError(Function onError, {bool Function(Object error)? test}) {
    return CancellableFuture.internalConstructor(
        this._future.catchError(onError, test: test),
        this._cancellationToken
    );
  }

  @override
  CancellableFuture<R> then<R>(FutureOr<R> Function(T value) onValue, {Function? onError}) {
    return CancellableFuture.internalConstructor(
        this._future.then(onValue, onError: onError),
        this._cancellationToken
    );
  }

  @override
  CancellableFuture<T> timeout(Duration timeLimit, {FutureOr<T> Function()? onTimeout}) {
    return CancellableFuture.internalConstructor(
        this._future.timeout(timeLimit, onTimeout: onTimeout),
        this._cancellationToken
    );
  }

  @override
  CancellableFuture<T> whenComplete(FutureOr<void> Function() action) {
    return CancellableFuture.internalConstructor(
        this._future.whenComplete(action),
        this._cancellationToken
    );
  }

  /// Cancels the execution of the job that will complete this future.
  /// This method returns as soon as the job has been notified of the cancellation request, however note that this does
  /// not mean that the job has been cancelled or will be cancelled. Jobs can only be cancelled while they are
  /// performing certain operations (for example while performing web requests). If the job has received a cancellation
  /// request, but the job does not perform any more cancellable operations before completion the future will be
  /// completed normally (with a success or error, but not with a cancellation).
  ///
  /// When the job cancels any task waiting for this future result will receive a TODO what error?
  ///
  /// If the job already terminated (successfully, with an error, or due to cancellation) cancel has no effect.
  Future<void> cancel() async {
    await CardinalSdkPlatformInterface.instance.utils.cancelJob(this._cancellationToken);
  }
}