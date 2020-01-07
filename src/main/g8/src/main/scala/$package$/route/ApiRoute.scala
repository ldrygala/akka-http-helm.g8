package $package$.route

import akka.http.scaladsl.server.{Directives, Route}

class ApiRoute(routes: Seq[RouteProvider], apiRoutes: Seq[RouteProvider])
    extends Directives {
  val route: Route = pathPrefix(ApiRoute.Prefix) {
    reduce(apiRoutes)
  } ~ reduce(routes)

  private[this] def reduce(routes: Seq[RouteProvider]): Route =
    if (routes.isEmpty) reject else routes.map(_.route).reduce(_ ~ _)
}

object ApiRoute {
  val Prefix: String = "api"
}
