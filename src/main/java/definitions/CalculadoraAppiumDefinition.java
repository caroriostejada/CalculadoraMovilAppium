package definitions;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;
import steps.CalculadoraAppiumStep;

import java.net.MalformedURLException;

public class CalculadoraAppiumDefinition {

    @Steps CalculadoraAppiumStep calculadoraAppiumStep;

    @Dado("^que ingreso a la calculadora del celular usando el simulador$")
    public void abrirCalculadora() {
        calculadoraAppiumStep.abrirCalculadora();
    }

    @Cuando("^realizo una (.*) basica con los datos (.*) y (.*)$")
    public void realizarOperacion(String operacion, String numeroUno, String numeroDos) throws MalformedURLException {
        calculadoraAppiumStep.realizarOperacion(operacion, numeroUno, numeroDos);
    }

    @Entonces("^se verifica que el (.*) sea el esperado$")
    public void verificarResultado(String resultado) {
        calculadoraAppiumStep.verificarResultado(resultado);
    }
}
