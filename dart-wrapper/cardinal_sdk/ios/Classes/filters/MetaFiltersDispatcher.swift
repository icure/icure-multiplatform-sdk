// auto-generated file
import CardinalDartSdkSupportLib

class MetaFiltersDispatcher {

  static func dispatch(
    methodName: String,
    parameters: [String : String],
    resultCallback: @escaping (
      String?,
      String?,
      String?,
      String?
    ) -> Void
  ) -> Bool {
    switch methodName {
    case "intersection": intersection(parameters: parameters, resultCallback: resultCallback)
    case "sortableIntersection": sortableIntersection(parameters: parameters, resultCallback: resultCallback)
    case "baseIntersection": baseIntersection(parameters: parameters, resultCallback: resultCallback)
    case "baseSortableIntersection": baseSortableIntersection(parameters: parameters, resultCallback: resultCallback)
    case "difference": difference(parameters: parameters, resultCallback: resultCallback)
    case "sortableDifference": sortableDifference(parameters: parameters, resultCallback: resultCallback)
    case "baseDifference": baseDifference(parameters: parameters, resultCallback: resultCallback)
    case "baseSortableDifference": baseSortableDifference(parameters: parameters, resultCallback: resultCallback)
    case "union": union(parameters: parameters, resultCallback: resultCallback)
    case "baseUnion": baseUnion(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func intersection(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MetaFilters.shared.intersection(
        dartResultCallback: resultCallback,
        leftString: parameters["left"]!,
        rightString: parameters["right"]!
    )
  }
  private static func sortableIntersection(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MetaFilters.shared.sortableIntersection(
        dartResultCallback: resultCallback,
        leftString: parameters["left"]!,
        rightString: parameters["right"]!
    )
  }
  private static func baseIntersection(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MetaFilters.shared.baseIntersection(
        dartResultCallback: resultCallback,
        leftString: parameters["left"]!,
        rightString: parameters["right"]!
    )
  }
  private static func baseSortableIntersection(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MetaFilters.shared.baseSortableIntersection(
        dartResultCallback: resultCallback,
        leftString: parameters["left"]!,
        rightString: parameters["right"]!
    )
  }
  private static func difference(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MetaFilters.shared.difference(
        dartResultCallback: resultCallback,
        leftString: parameters["left"]!,
        rightString: parameters["right"]!
    )
  }
  private static func sortableDifference(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MetaFilters.shared.sortableDifference(
        dartResultCallback: resultCallback,
        leftString: parameters["left"]!,
        rightString: parameters["right"]!
    )
  }
  private static func baseDifference(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MetaFilters.shared.baseDifference(
        dartResultCallback: resultCallback,
        leftString: parameters["left"]!,
        rightString: parameters["right"]!
    )
  }
  private static func baseSortableDifference(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MetaFilters.shared.baseSortableDifference(
        dartResultCallback: resultCallback,
        leftString: parameters["left"]!,
        rightString: parameters["right"]!
    )
  }
  private static func union(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MetaFilters.shared.union(
        dartResultCallback: resultCallback,
        leftString: parameters["left"]!,
        rightString: parameters["right"]!
    )
  }
  private static func baseUnion(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MetaFilters.shared.baseUnion(
        dartResultCallback: resultCallback,
        leftString: parameters["left"]!,
        rightString: parameters["right"]!
    )
  }
}
