// import CardinalDartSdkSupportLib
//
// class PaginatedListIteratorDispatcher {
//
//   static func dispatch(
//     methodName: String,
//     parameters: [String : String],
//     resultCallback: @escaping (
//       String?,
//       String?,
//       String?
//     ) -> Void
//   ) -> Bool {
//     switch methodName {
// 		case "hasNext": hasNext(parameters: parameters, resultCallback: resultCallback)
// 		case "next": next(parameters: parameters, resultCallback: resultCallback)
//     	default: return false
//     }
//     return true
//   }
//
// 	private static func hasNext(
// 		parameters: [String : String],
// 		resultCallback: @escaping (String?,String?, String?) -> Void
// 	) {
// 		PaginatedListIterator.shared.hasNext(
// 			dartResultCallback: resultCallback,
// 			sdkId: parameters["sdkId"]!,
// 		)
// 	}
//
// 	private static func next(
// 		parameters: [String : String],
// 		resultCallback: @escaping (String?,String?, String?) -> Void
// 	) {
// 		PaginatedListIterator.shared.next(
// 			dartResultCallback: resultCallback,
// 			sdkId: parameters["sdkId"]!,
// 			limit: parameters["limit"]!
// 		)
// 	}
//
// }