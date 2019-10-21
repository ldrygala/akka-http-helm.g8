package $package$.route

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{Matchers, WordSpec}

import scala.concurrent.Future

class HealthCheckRouteTest extends WordSpec with Matchers with ScalatestRouteTest {
  val healthCheckRoute = new HealthCheckRoute().route

  "HealthCheck" should {
    "handle /health/alive" in {
      Get("/health/alive") ~> healthCheckRoute ~> check {
        status shouldBe StatusCodes.OK
      }
    }
    "handle /health/ready" in {
      Get("/health/ready") ~> healthCheckRoute ~> check {
        status shouldBe StatusCodes.OK
      }
    }
  }
}