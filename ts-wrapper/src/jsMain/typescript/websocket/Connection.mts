export interface Connection {
  /**
   * Close the connection definitively
   *
   * This will bypass the retry mechanism and close the connection
   */
  close(): Promise<void>

  /**
   * Subscribe to connection state changes
   *
   * @param callback The callback to be called when the connection is reconnected (due to a retry)
   */
  onReconnected(callback: () => Promise<void>): void

  /**
   * Subscribe to connection state changes
   *
   * @param callback The callback to be called when the connection is disconnected, either by the server or by the client. It can be called multiple times due to retries
   * - `code` The close code
   * - `reason` The close reason
   */
  onDisconnected(callback: (code: number | null, reason: string | null) => Promise<void>): void

  /**
   * Subscribe to connection state changes
   *
   * @param callback The callback to be called when an error occurs
   * - `errorMessage` The error message
   * - `fatal` Whether the error is fatal or not, if `fatal` is `true`, the connection will be closed and have to be re-established by the client
   */
  onError(callback: (errorMessage: string | null, fatal: boolean) => Promise<void>): void
}