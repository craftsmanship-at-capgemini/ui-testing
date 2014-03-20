package petclinic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ldrygala.petclinic.AbstractSelenium;
import ldrygala.petclinic.objects.NewOwnerPage;

public class NewOwnerFormValidationSeleniumTest extends AbstractSelenium {

	private NewOwnerPage newOwnerPage;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		newOwnerPage = openPetClinic().clickFindOwner().clickAddOwner();
	}

	@Test
	public void shouldCheckIfFirsNameIsRequired() {
		newOwnerPage.setLastName("lastName").setAddress("address")
				.setCity("city").setTelephone("123123").clickAddOwnerButton();
		
		assertTrue(newOwnerPage.hasError());
	}

	@Test
	public void shouldCheckIfAddressIsRequired() {
		newOwnerPage.setFirstName("firstName").setLastName("lastName")
				.setCity("city").setTelephone("123123").clickAddOwnerButton();
		
		assertTrue(newOwnerPage.hasError());
	}

	@Test
	public void shouldCheckIfTelefonRequieredNumericValue() {
		newOwnerPage.setFirstName("firstName").setLastName("lastName")
				.setAddress("address").setCity("city").setTelephone("telefon")
				.clickAddOwnerButton();
		
		assertTrue(newOwnerPage.hasError());
	}

	@Test
	public void shouldAddNewOwner() {
		newOwnerPage.setFirstName("firstName").setLastName("lastName")
				.setAddress("address").setCity("city").setTelephone("123123")
				.clickAddOwnerButton();

		assertFalse(newOwnerPage.hasError());
	}

}
