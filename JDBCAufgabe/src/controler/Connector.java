package controler;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {
	static Connection con;
		
	public Connector() {
	}
		
	public static void main (String[] args) throws IOException {
		getCon();
		Customer cu = new Customer(208, "Papa", "kontakt");
		insertIntoTable(cu);
		//deleteTable();
		//cu.setFirstname("Ronja");
		//deleteById(cu);
		/*dropTable();
		insertIntoTable();
		*/
	}
	
	public static void getCon() throws IOException {
		String url = "jdbc:oracle:thin:@ora14.informatik.haw-hamburg.de:1521:inf14";
		String user = "ace590";
		String pass = getPassword();
		//System.out.println("User "+user+" Pass "+pass);
		
		try {
			 con = DriverManager.getConnection(url, user, pass);
			System.out.println("Verbindung wurde hergestellt");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
		
	public static String getPassword() throws IOException {
		FileReader fr;
		String password= "";
		try {
			fr = new FileReader("/Users/ronjaschottler/eclipse-workspace/JDBCAufgabe/lib/Password.txt");
			BufferedReader br = new BufferedReader(fr);
		    password = br.readLine();
		    br.close();
		} catch (FileNotFoundException e) {	
			e.printStackTrace();
		}
		return password;
	}
	
	public static void insertIntoTable(Customer cu) {
		try {
		
			 Statement statement = con.createStatement ( );
		    // statement.executeUpdate( "INSERT INTO ace590.Customer" +" VALUES ( ID_SEQ.NEXTVAL,'"+cu.getFirstname()+"', '"+cu.getFamilyname()+"', '"+heute.getDate()+"')");
			 statement.executeUpdate( "INSERT INTO ace590.Customer" +" VALUES ( "+cu.getId()+",'"+cu.getFirstname()+"', '"+cu.getFamilyname()+"', '02.04.2018')");
			 statement.close();
			 System.out.println("Kunde wurde erfolgreich eingefügt");
		}
		catch(SQLException e){
			System.out.println("Beim einfügen des Kundens ist ein Fehler aufgetreten "+ e.getMessage());
        }
	}
	
	public static void deleteTable() {
		try {
			Statement s = con.createStatement( );
			s.executeUpdate("Delete From ace590.Customer");
		}
		catch(SQLException e){
	        System.out.println( e.getMessage());
	        }
	}
	
	public static ResultSet selectById(Customer cu) {
		Statement s;
		ResultSet rs;
		try {
			s = con.createStatement( );
			String query = "SELECT id, firstname, familyname, entrydate FROM ace590.Customer"+" WHERE id = "+cu.getId()+" ";
			 rs = s.executeQuery(query);
				/*while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("id");
		         String firstname = rs.getString("firstname");
		         String familyname = rs.getString("familyname");
		         Date date = rs.getDate("entrydate");
		        // System.out.println("ID= "+ id+" firstname = "+firstname+" familyname = "+familyname+" date = "+date);
		      }*/
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void deleteById(Customer cu) {
		Statement s;
		try {
			s = con.createStatement( );
			String query = "DELETE FROM ace590.Customer"+" WHERE id = "+cu.getId()+" ";
			ResultSet rs = s.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public static void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public static void onUpdateFirstName(Customer cu) {
		 Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "UPDATE Customer " +
	                   "SET firstname = '"+cu.getFirstname()+"' WHERE id ="+cu.getId()+"";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void onUpdateFamilyName(Customer cu) {
		 Statement stmt;
		try {
			stmt = con.createStatement();
			String sql = "UPDATE Customer " +
	                   "SET familyname = '"+cu.getFamilyname()+"' WHERE id ="+cu.getId()+"";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	}


