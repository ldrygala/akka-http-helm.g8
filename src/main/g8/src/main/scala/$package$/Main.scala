package $package$

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import $package$.route.{ApiRoute, HealthCheckRoute, SwaggerSiteRoute}
import com.typesafe.scalalogging.StrictLogging

import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success}

object Main extends App with StrictLogging {
  implicit val actorSystem: ActorSystem           = ActorSystem("$name$")
  implicit val executionContext: ExecutionContext = actorSystem.dispatcher
  
  val host = "0.0.0.0"
  val port = 8080

  val healthCheckRoute = new HealthCheckRoute()
  val swaggerSiteRoute = new SwaggerSiteRoute()
  val apiRoute = new ApiRoute(
    routes = Seq(healthCheckRoute, swaggerSiteRoute),
    apiRoutes = Seq.empty
  )

  val serverBinding = Http().newServerAt(host, port).bindFlow(apiRoute.route)
  serverBinding.onComplete {
    case Success(_) =>
      logger.info("$name$ is up and running on " + host + ":" + port)
    case Failure(e) =>
      logger.error("$name$ could not start", e)
  }

  scala.sys.addShutdownHook {
    logger.info("Shutting down")
    serverBinding
      .flatMap(_.unbind())
      .onComplete {
        case Success(_) =>
          logger.info("Unbind succeed")
        case Failure(ex) =>
          logger.error("Unbind failed", ex)
      }
  }
}
