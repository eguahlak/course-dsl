package dk.kalhauge.course.dsl

enum class ActivityType { READ, WRITE, WORK }

open class Activity(val lecture: Lecture, val title: String, val type: ActivityType, val load: Double)

fun Lecture.read(title: String, load: Double, build: Activity.() -> Unit = {}): Activity {
  val activity = Activity(
      this,
      title,
      ActivityType.READ,
      load
  )
  activity.build()
  add(activity)
  return activity
  }

fun Lecture.work(title: String, load: Double, build: Activity.() -> Unit = {}): Activity {
  val activity = Activity(
      this,
      title,
      ActivityType.WORK,
      load
  )
  activity.build()
  add(activity)
  return activity
  }

fun Lecture.write(title: String, load: Double, build: Activity.() -> Unit = {}): Activity {
  val activity = Activity(
      this,
      title,
      ActivityType.WRITE,
      load
  )
  activity.build()
  add(activity)
  return activity
  }