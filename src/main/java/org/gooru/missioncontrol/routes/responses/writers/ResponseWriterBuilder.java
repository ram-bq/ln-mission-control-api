package org.gooru.missioncontrol.routes.responses.writers;

import org.gooru.missioncontrol.routes.responses.transformers.ResponseTransformer;
import io.vertx.core.AsyncResult;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

/**
 * @author ashish on 10/1/18.
 */
public final class ResponseWriterBuilder {

  private ResponseWriterBuilder() {
    throw new AssertionError();
  }

  public static ResponseWriter build(RoutingContext routingContext,
      AsyncResult<Message<JsonObject>> message) {
    if (routingContext == null || message == null) {
      throw new IllegalArgumentException(
          "Invalid or null routing context or message for Response Writer creation");
    }
    return new HttpServerResponseWriter(routingContext, message);
  }

  public static ResponseWriter build(RoutingContext routingContext,
      ResponseTransformer transformer) {
    if (routingContext == null || transformer == null) {
      throw new IllegalArgumentException(
          "Invalid or null routing context or transformer for Response Writer creation");
    }
    return new HttpServerResponseWriter(routingContext, transformer);
  }
}
