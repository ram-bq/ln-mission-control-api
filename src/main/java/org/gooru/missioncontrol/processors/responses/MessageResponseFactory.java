package org.gooru.missioncontrol.processors.responses;

import org.gooru.missioncontrol.constants.HttpConstants;
import org.gooru.missioncontrol.constants.MessageConstants;
import io.vertx.core.json.JsonObject;

public final class MessageResponseFactory {

  private static final String API_VERSION_DEPRECATED = "API version is deprecated";

  private MessageResponseFactory() {
    throw new AssertionError();
  }

  public static MessageResponse createInvalidRequestResponse() {
    return new MessageResponse.Builder().failed().setStatusBadRequest().build();
  }

  public static MessageResponse createInvalidRequestResponse(String message) {
    return new MessageResponse.Builder().failed().setStatusBadRequest().setContentTypeJson()
        .setResponseBody(new JsonObject().put(MessageConstants.MSG_MESSAGE, message)).build();
  }

  public static MessageResponse createForbiddenResponse() {
    return new MessageResponse.Builder().failed().setStatusForbidden().build();
  }

  public static MessageResponse createForbiddenResponse(String message) {
    return new MessageResponse.Builder().failed().setStatusForbidden()
        .setResponseBody(new JsonObject().put(MessageConstants.MSG_MESSAGE, message)).build();
  }

  public static MessageResponse createInternalErrorResponse() {
    return new MessageResponse.Builder().failed().setStatusInternalError().build();
  }

  public static MessageResponse createInternalErrorResponse(String message) {
    return new MessageResponse.Builder().failed().setStatusInternalError().setContentTypeJson()
        .setResponseBody(new JsonObject().put(MessageConstants.MSG_MESSAGE, message)).build();
  }

  public static MessageResponse createNotFoundResponse() {
    return new MessageResponse.Builder().failed().setStatusNotFound().build();
  }

  public static MessageResponse createNotFoundResponse(String message) {
    return new MessageResponse.Builder().failed().setStatusNotFound().setContentTypeJson()
        .setResponseBody(new JsonObject().put(MessageConstants.MSG_MESSAGE, message)).build();
  }

  public static MessageResponse createGetResponse(JsonObject responseBody) {
    return new MessageResponse.Builder().successful().setStatusOkay().setContentTypeJson()
        .setResponseBody(responseBody).build();
  }

  public static MessageResponse createPostResponse() {
    return new MessageResponse.Builder().successful().setStatusCreated().build();
  }

  public static MessageResponse createNoContentResponse() {
    return new MessageResponse.Builder().successful().setStatusNoOutput().build();
  }

  public static MessageResponse createValidationErrorResponse(JsonObject errors) {
    return new MessageResponse.Builder().validationFailed().setStatusBadRequest()
        .setContentTypeJson().setResponseBody(errors).build();
  }

  public static MessageResponse createVersionDeprecatedResponse() {
    return new MessageResponse.Builder().failed().setStatusHttpCode(HttpConstants.HttpStatus.GONE)
        .setContentTypeJson()
        .setResponseBody(new JsonObject().put(MessageConstants.MSG_MESSAGE, API_VERSION_DEPRECATED))
        .build();
  }
}
