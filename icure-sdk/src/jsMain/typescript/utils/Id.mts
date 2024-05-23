let crypto: Crypto

export function randomUuid(): string {
  if (!crypto) {
    if (typeof window !== 'undefined') {
      crypto = window.crypto
    } else if (typeof self !== 'undefined') {
      crypto = self.crypto
    } else throw new Error(
      "Can't generate uuid as crypto is not available. Initialising an instance of iCure API with a crypto service for this environment should solve the issue."
    )
  }
  return crypto.randomUUID()
}