package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import jdk.nashorn.internal.ir.ObjectNode;
import models.LocationDetails;
import play.api.libs.ws.WSBody;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import static play.libs.Json.toJson;
import play.libs.ws.*;
import java.util.concurrent.CompletionStage;

public class HomeController extends Controller {
    private final WSClient ws;

    @Inject
    public HomeController(WSClient ws){
        this.ws = ws;
    }

    @Inject
    FormFactory formFactory;
    public Result handleUpdates(){
        DynamicForm dynamicForm = formFactory.form().bindFromRequest();
        String userName = dynamicForm.get("userName");
        String latitude = dynamicForm.get("latitude");
        String longitude = dynamicForm.get("longitude");
        String timestamp = dynamicForm.get("timestamp");

        LocationDetails locationDetails = formFactory.form(LocationDetails.class).bindFromRequest().get();
        locationDetails.save();
       
        System.out.println("Username:"+userName+" Latitude:"+latitude+" Longitude:"+longitude+" Timestamp:"+timestamp);

        com.fasterxml.jackson.databind.node.ObjectNode responseJson = Json.newObject();
        responseJson.put("value","5");
        return ok(responseJson);



    }
    public Result receiveJson(){
        return ok("Hi");
    }

    public Result receiveJsonAbc(){

        JsonNode json = request().body().asJson();
        if(json == null) {
            return badRequest("Expecting Json Prax");
        } else {
            String name = json.findPath("name").asText();
            if(name == null) {
                return badRequest("Missing parameter [name]");
            } else {
                return ok("Hello " + name);
            }
        }
    }


}
