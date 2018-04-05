package Test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controler.Connector;
import controler.Customer;

public class TestC {
	static Connection con;

	@Before
	public void setUp() throws Exception {
		try {
			Connector.getCon();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Test
	public void testInDB() {
		long id = 0;
		String firstname = "";
		String familyname = "";
		Date date;
		Customer cu = new Customer(1011,"Winni","Fred");
		Connector.insertIntoTable(cu);
		ResultSet rs = Connector.selectById(cu);
			try {
				while(rs.next()){
				 //Retrieve by column name
				 id  = rs.getInt("id");
				 firstname = rs.getString("firstname");
				 familyname = rs.getString("familyname");
				 date = rs.getDate("entrydate");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertEquals(firstname, cu.getFirstname());
		
	}
	
	@Test
	public void testdelete() throws SQLException {
		Customer cu = new Customer(1012,"Max","Keller");
		Connector.insertIntoTable(cu);
		Connector.deleteById(cu);
		ResultSet rs = Connector.selectById(cu);
		assertEquals(false, rs.next());	
	}
	
	@Test
	public void testforChanges() throws SQLException {
		String fm = "";
		Customer cu = new Customer(1015,"Mimi","Meier");
		Connector.insertIntoTable(cu);
		cu.setFamilyname("Hummel");
		ResultSet rs = Connector.selectById(cu);
		while(rs.next()){
		fm = rs.getString("familyname");
		}
		assertEquals("Hummel", fm);	
	}
	
	@After
	public void tearDown() throws Exception {
		Connector.deleteTable();
		
	}
}
