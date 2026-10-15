package components;

import control.Button;
import control.Label;
import org.openqa.selenium.By;

public class NavigationMenu {
    public void selectOptionMenu(String option) {
        Button menuOption = new Button(By.xpath("//android.widget.TextView[@text='" + option + "']"));
        menuOption.click();
    }

    public boolean optionDisplayed(String option) {
        Label optionMenu = new Label(By.xpath("//android.widget.TextView[@text='" + option + "']"));
        return optionMenu.isControlDisplayed();
    }
}
