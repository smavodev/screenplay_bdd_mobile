package com.nttdata.ct.stepDefinitions;

import com.nttdata.ct.questions.LoginSuccess;
import com.nttdata.ct.questions.Message;
import com.nttdata.ct.task.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;


public class LoginSwagLabs {

    @Given("que el usuario esta en la app SwagLabs")
    public void que_el_usuario_esta_en_la_app_swag_labs() {
        theActorCalled("Usuario");
    }

    @When("el usuario ingrese sus credenciales usuario {string} y password {string}")
    public void el_usuario_ingrese_sus_credenciales_usuario_y_password(String user, String password) {
        theActorInTheSpotlight().attemptsTo(
                Login.withCredentials(user, password)
        );
    }

    @Then("el incio de sesion es exitoso")
    public void el_incio_de_sesion_es_exitoso() {
        theActorInTheSpotlight().should(
                seeThat("El título products es visible", LoginSuccess.ok(), equalTo(true))
        );
    }

    @Then("se muestra el mensaje {string}")
    public void se_muestra_el_mensaje(String message) {
        theActorInTheSpotlight().should(
                seeThat("El mensaje de error", Message.error(), equalTo(message))
        );
    }
}
