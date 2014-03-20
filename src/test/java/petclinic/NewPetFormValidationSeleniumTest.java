package petclinic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import ldrygala.petclinic.AbstractSelenium;
import ldrygala.petclinic.objects.NewPetPage;
import ldrygala.petclinic.objects.enums.PetType;

import org.junit.Before;
import org.junit.Test;

public class NewPetFormValidationSeleniumTest extends AbstractSelenium {

	private NewPetPage newPetPage;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		newPetPage = openPetClinic().clickFindOwner().clickAddOwner().setFirstName("firstName").setLastName("lastName")
				.setAddress("address").setCity("city").setTelephone("123123")
				.clickAddOwnerButton().clickAddNewPet();
	}
	
	@Test
	public void shouldCheckIfNameIsRequired() {
		newPetPage.setBirthDate("2011-01-01").setType(PetType.SNAKE).clickAddPetButton();
		
		assertTrue(newPetPage.hasError());
	}

	@Test
	public void shouldCheckIfBirthDateIsRequired() {
		newPetPage.setName("pet").setType(PetType.SNAKE).clickAddPetButton();
		
		assertTrue(newPetPage.hasError());
	}

	@Test
	public void shouldFail() {
		assertEquals(PetType.SNAKE, newPetPage.getPetType());
	}

	@Test
	public void shouldCheckIfBirdIsDefaultType() {
		assertEquals(PetType.BIRD, newPetPage.getPetType());
	}

}
