let initializedCrypto: Crypto

export function randomUuid(): string {
  if (!initializedCrypto) {
    if (typeof crypto !== 'undefined') {
      initializedCrypto = crypto
    } else if (typeof window !== 'undefined') {
      initializedCrypto = window.crypto
    } else if (typeof self !== 'undefined') {
      initializedCrypto = self.crypto
    } else throw new Error(
      "Can't generate uuid as crypto is not available. Initialising an instance of iCure API with a crypto service for this environment should solve the issue."
    )
  }
  return initializedCrypto.randomUUID()
}