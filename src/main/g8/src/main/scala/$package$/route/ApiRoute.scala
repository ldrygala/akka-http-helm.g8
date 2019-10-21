package $package$.route

import akka.http.scaladsl.server.Route

class ApiRoute(healthCheckRoute: HealthCheckRoute) {
    val route: Route = healthCheckRoute.route
}