package com.convolutionai.flut.core

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.stream.scaladsl._
import scala.concurrent.{ExecutionContext, Future}


abstract  class ApiService(urlBase: String)(implicit val system: ActorSystem, ec: ExecutionContext) {

  protected val connectionFlow: Flow[HttpRequest, HttpResponse, Future[Http.OutgoingConnection]] =
    Http().outgoingConnection(urlBase)

  protected def dispatchRequest(request: HttpRequest): Future[HttpResponse] =
    Source.single(request)
      .via(connectionFlow)
      .runWith(Sink.head)



}

