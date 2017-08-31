package controllers;

import play.*;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.*;

import views.html.*;

import javax.inject.Inject;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }


}
