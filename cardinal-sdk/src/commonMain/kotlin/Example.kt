import com.icure.cardinal.sdk.CardinalSdk

suspend fun doExchangeDataRecovery(
	patientSdk: CardinalSdk
) {
	// Implement this yourself
	val recoveryKey = askRecoveryKey()

	val recoveryResult = patientSdk.recovery.recoverExchangeData(recoveryKey)
	if (recoveryResult != null) throw IllegalArgumentException("Invalid recovery key for reason $recoveryResult")
}