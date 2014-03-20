package ldrygala.petclinic.objects;

import ldrygala.petclinic.AbstractPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewOwnerPage extends AbstractPageObject {
	private WebElement firstName;
	private WebElement lastName;
	private WebElement address;
	private WebElement city;
	private WebElement telephone;
	@FindBy(xpath="//*[@id='owner']/table/tbody/tr[6]/td/p/input")
	private WebElement addOwnerButton;
	
	public NewOwnerPage setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
		return this;
	}

	public NewOwnerPage setLastName(String lastName) {
		this.lastName.sendKeys(lastName);
		return this;
	}

	public NewOwnerPage setAddress(String address) {
		this.address.sendKeys(address);
		return this;
	}

	public NewOwnerPage setCity(String city) {
		this.city.sendKeys(city);
		return this;
	}

	public NewOwnerPage setTelephone(String telephone) {
		this.telephone.sendKeys(telephone);
		return this;
	}

	public NewOwnerPage(WebDriver driver) {
		super(driver);
	}
	
	public OwnarInfomrationPage clickAddOwnerButton() {
		addOwnerButton.click();
		return PageFactory.initElements(driver, OwnarInfomrationPage.class);
	}

}
