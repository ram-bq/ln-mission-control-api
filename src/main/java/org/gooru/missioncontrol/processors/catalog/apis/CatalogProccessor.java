package org.gooru.missioncontrol.processors.catalog.apis;

import org.gooru.missioncontrol.constants.HttpConstants;
import org.gooru.missioncontrol.processors.exceptions.HttpResponseWrapperException;
import org.gooru.missioncontrol.processors.responses.MessageResponse;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

public class CatalogProccessor {
  
  protected final Vertx vertx;
  protected final Message<JsonObject> message;
  protected final Future<MessageResponse> result;
  protected final CatalogAPIService catalogAPIService; 
  protected static final String RESOURCE_IDS = "resource_ids";

  
  protected CatalogProccessor(Vertx vertx, Message<JsonObject> message) {
    this.vertx = vertx;
    this.message = message;
    this.result = Future.future();
    this.catalogAPIService = new CatalogAPIService(this.vertx.createHttpClient());
  }
  
 
  protected String validateAndExtractRequest(JsonObject requestData) {
    try {
      String resourceIdsStr = requestData.getString(RESOURCE_IDS);
      
      if(resourceIdsStr == null || resourceIdsStr.isEmpty()) {
        throw new HttpResponseWrapperException(HttpConstants.HttpStatus.BAD_REQUEST,
          "Invalid format of resource ids in payload");
      }
      
      return resourceIdsStr;        
    } catch (ClassCastException e) {
      throw new HttpResponseWrapperException(HttpConstants.HttpStatus.BAD_REQUEST,
          "Invalid format of resource ids in payload");
    }
    catch (NullPointerException ex) {
      throw new HttpResponseWrapperException(HttpConstants.HttpStatus.BAD_REQUEST,
        "Invalid resource ids passed in the request");
      }
  }

 
}