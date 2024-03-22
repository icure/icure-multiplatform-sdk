package com.icure.sdk.model.filter

import com.icure.sdk.model.base.Identifiable
import kotlin.String

public interface AbstractFilter<O : Identifiable<String>> : Filter<O> {
  public val desc: String?
}
