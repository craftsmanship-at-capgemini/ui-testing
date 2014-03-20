package ldrygala.petclinic.objects;

import ldrygala.petclinic.AbstractPageObject;
import ldrygala.petclinic.objects.enums.PetType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewPetPage extends AbstractPageObject {
	private WebElement name;
	private WebElement birthDate;
	private WebElement type;
	@FindBy(xpath="//*[@id='pet']/table/tbody/tr[4]/td/p/input")
	private WebElement addPetButton;
	
	
	public NewPetPage(WebDriver driver) {
		super(driver);
	}
	
	public NewPetPage setName(String in) {
		name.sendKeys(in);
		return this;
	}

	public NewPetPage setBirthDate(String in) {
		birthDate.sendKeys(in);
		return this;
	}
	
	public NewPetPage setType(PetType in) {
		new Select(type).selectByValue(in.getKey());
		return this;
	}

	public PetType getPetType() {
		return PetType.getPetType(type.getAttribute("value"));
	}
	
	public void clickAddPetButton() {
		addPetButton.click();
	}

}
