package $package$.route

import akka.http.scaladsl.server.{Directives, Route}

class SwaggerSiteRoute extends Directives with RouteProvider {
  override val route: Route =
    path("swagger") { getFromResource("swagger-ui/index.html") } ~ getFromResourceDirectory(
      "swagger-ui")
}