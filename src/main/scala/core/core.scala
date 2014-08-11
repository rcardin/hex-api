import akka.actor.ActorSystem

/**
 * The dependecy from ActorSystem lets to build properly test cases.
 */
trait Core {
  implicit def system: ActorSystem
}

/**
 * This trait implements ``Core`` by starting the required ``ActorSystem`` and registering the
 * termination handler to stop the system when the JVM exits.
 */
trait BootedCore extends Core {

  /**
   * Construct the ActorSystem we will use in our application
   */
  implicit lazy val system = ActorSystem("akka-hex")

  /**
   * Ensure that the constructed ActorSystem is shut down when the JVM shuts down
   */
  sys.addShutdownHook(system.shutdown())
}

/**
 * Trait containing core actors of Hex application. It must be mixed with some
 * trait extending Core, due to cake pattern
 */
trait CoreActors {
  this: Core =>

  // TODO
}