package steps;

import Enums.VariablesSession;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class CalculadoraAppiumStep {
    private static final Map<String, String> OPERACIONES = new HashMap<>();
    DesiredCapabilities dc = new DesiredCapabilities();

    static {
        OPERACIONES.put("suma", "plus");
        OPERACIONES.put("resta", "minus");
        OPERACIONES.put("multiplicacion", "multiply");
        OPERACIONES.put("division", "divide");
    }

    @Step
    public void abrirCalculadora() {
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "com.android.calculator2");
        dc.setCapability("appActivity", ".Calculator");
    }

    @Step
    public void realizarOperacion(String operacion, String numeroUno, String numeroDos) throws MalformedURLException {
        AndroidDriver<AndroidElement> ad = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        MobileElement el1 = (MobileElement) ad.findElementById("com.android.calculator2:id/digit_".concat(numeroUno));
        el1.click();
        MobileElement el3 = (MobileElement) ad.findElementByAccessibilityId(OPERACIONES.get(operacion));
        el3.click();
        MobileElement el4 = (MobileElement) ad.findElementById("com.android.calculator2:id/digit_".concat(numeroDos));
        el4.click();
        MobileElement el5 = (MobileElement) ad.findElementByAccessibilityId("equals");
        el5.click();
        Serenity.setSessionVariable(VariablesSession.SESION_RESULTADO.getValor()).to(ad.findElementById("com.android.calculator2:id/result").getText());
    }

    @Step
    public void verificarResultado(String resultado) {
        Assert.assertEquals(Serenity.sessionVariableCalled(VariablesSession.SESION_RESULTADO.getValor()), resultado);
    }
}
