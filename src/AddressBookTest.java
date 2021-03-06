import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class AddressBookTest {
	BuddyInfo nullBuddy = null;
	BuddyInfo blankBuddy = null;
	BuddyInfo testBuddy1 = null;
	BuddyInfo testBuddy2 = null;
	AddressBook book = null;
	
	@Before
	public void setUp() {
		blankBuddy = new BuddyInfo();
		testBuddy1 = new BuddyInfo("Travis", "1234 Fake Street", "(613) 098-7654");
		testBuddy2 = new BuddyInfo("Homer","Carleton","(613) 123-4567");
		book = new AddressBook();
	}
	
	@Test
	public void testAdd() {
		book.addBuddy(testBuddy2);
		assertNotEquals("Buddy should be in list.",-1,book.indexOf(testBuddy2));
	}
	
	@Test
	public void testNotFound() {
		assertEquals("Buddy should not be in list.",-1,book.indexOf(testBuddy2));
	}
	
	@Test
	public void testRemove() {
		book.addBuddy(testBuddy1);
		book.removeBuddy(testBuddy1);
		assertEquals("Buddy should not be in list.",-1,book.indexOf(testBuddy1));
	}
	
	@Test
	public void testSize() {
		book.addBuddy(testBuddy1);
		book.addBuddy(testBuddy2);
		assertEquals("Size should be 2.",2,book.size());
	}
	
	@Test
	public void testClear() {
		book.addBuddy(testBuddy1);
		book.addBuddy(testBuddy2);
		book.clear();
		assertEquals("size should be 0.",0,book.size());
	}
	
	@Test
	public void testIO(){
		book.addBuddy(testBuddy1);
		book.addBuddy(testBuddy2);
		String file = "BookTest.txt";
		book.export(file);
		AddressBook book2 = AddressBook.importBook(file);
		assertTrue("Books should be equal.",book.equals(book2));
	}
	
	@Test
	public void testSerial(){
		book.addBuddy(testBuddy1);
		book.addBuddy(testBuddy2);
		String file = "SerialTest.txt";
		book.serialExport(file);
		AddressBook book2 = AddressBook.serialImport(file);
		assertTrue("Books should be equal.",book.equals(book2));
	}
	
	@Test
	public void testXML(){
		book.addBuddy(testBuddy1);
		book.addBuddy(testBuddy2);
		String file = "XMLTest.xml";
		book.exportToXMLFile(file);
		AddressBook book2 = null;
		try{
			book2 = AddressBook.importFromXmlFileDOM(file);
		}catch(Exception e){
			e.printStackTrace();
		}
		assertTrue("Books should be equal.",book.equals(book2));
	}
}
