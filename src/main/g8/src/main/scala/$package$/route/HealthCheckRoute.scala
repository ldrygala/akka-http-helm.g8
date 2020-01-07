package $package$.route

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.{Directives, Route}

class HealthCheckRoute extends Directives with RouteProvider {
  override val route: Route = pathPrefix("health") {
    path("alive") {
      complete(StatusCodes.OK)
    } ~ path("ready") {
      // TODO should check external dependencies.
      complete(StatusCodes.OK)
    }
  }
}