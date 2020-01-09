package dk.kalhauge.util

import dk.kalhauge.org.course.dsl.Course
import dk.kalhauge.org.course.dsl.Week
import java.lang.Math.abs

fun String.anchorize() = toLowerCase().replace("[^a-z0-9]+".toRegex(), "-")

// TODO: move to relevant course-dsl file
fun Week.image(link: String, alt: String = "") = "![](../resources/$link)"
fun Course.image(link: String, alt: String = "") = "![](resources/$link)"

fun nice(value: Double) = if (abs(value) < 0.0001) "" else "$value"