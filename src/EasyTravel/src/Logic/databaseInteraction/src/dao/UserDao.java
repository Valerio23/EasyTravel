package dao;

import java.io.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import dao.*;
import entities.Follow;
import entities.User;
import entities.Viaggio;
import queries.*;
import utilities.Utilities;

public class UserDao {

	private final static String DB_URL = "jdbc:mysql://127.0.0.1:3306/mydb_progettoISPW";
	private final static String USER = "root";
	private final static String PASS = "";

    private static String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";

    public static Scanner scan;
	
    public User registerUsr() throws Exception {
    	
    	String username;
    	String password = new String();
    	String firstName = new String();
    	String secondName = new String();
    	String email;
    	String secretQuestion = "come si chiama tua madre?";
    	String secretAnswer = "cazzimiei";
    	int age;
    	boolean ret;
    	
    	Statement stmt = null;
    	Connection conn = null;
    	
    	
    	System.out.print("Name: ");
   		firstName = scan.next();
 	
    	System.out.println();
    	System.out.print("Surname: ");
    	secondName = scan.next();
    	
    	System.out.println();
    	System.out.print("Age: ");
    	age = scan.nextInt();
    	

    	System.out.println();
    	//for the username must check if it's unique
    	
    	while(true) {
    		
	    	System.out.print("Username: ");
	    	username = scan.next();
	    	
	    	
	    	try {
	            // STEP 2: loading dinamico del driver mysql
				Class.forName(DRIVER_CLASS_NAME);
	        	
	            // STEP 3: apertura connessione
	            conn = DriverManager.getConnection(DB_URL, USER, PASS);
	
	            // STEP 4: creazione ed esecuzione della query
	            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
	                    ResultSet.CONCUR_READ_ONLY);
	            ret = SimpleQueries.controlUniqueUsername(stmt, username);
	            if(ret) break;
	            System.out.println("Insert a new username");
	            
	        } finally {
	            // STEP 5.2: Clean-up dell'ambiente
	            try {
	                if (stmt != null)
	                    stmt.close();
	            } catch (SQLException se2) {
	            }
	            try {
	                if (conn != null)
	                    conn.close();
	            } catch (SQLException se) {
	                se.printStackTrace();
	            }
	        }
    	}

    	System.out.println();
    	System.out.print("Email: ");
    	email = scan.next();

    	while(true) {
    		
	    	System.out.println();
	    	System.out.print("Password: ");
	    	password = scan.next();
	    	
	    	Utilities u = new Utilities();
	    	
	    	if(u.checkPass(password)) {
	    		System.out.println("Valid password");
	    		break;
	    	}else {
	    		System.out.println("Invalid password");
	    	}
	    	
    	}
    	
    	
    	User usr = new User(firstName, secondName, age, username, email, password, secretQuestion, secretAnswer);

    	
    	try {
            // STEP 2: loading dinamico del driver mysql
            Class.forName(DRIVER_CLASS_NAME);

            // STEP 3: apertura connessione
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // STEP 4.1: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            int result = CRUDQueries.inserisciNuovoUtente(stmt, usr);
            
        } finally {
            // STEP 5.2: Clean-up dell'ambiente        	
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
        }
    	
    	return usr;
    }
    
    
    
    public void modifPsw(User usr) throws Exception {
    
    	Statement stmt = null;
    	Connection conn = null;
    	
    	System.out.println("Your current password is: " + usr.getPassword());
    	System.out.println("\nInsert the new password");

    	
    	while(true) {
    		
	    	System.out.println();
	    	System.out.print("New password: ");
	    	String password = scan.next();
	    	
	    	Utilities u = new Utilities();
	    	
	    	if(u.checkPass(password)) {
	    		
	    		System.out.println("Valid password");
	        	usr.setPassword(password);
	    		break;
	    		
	    	}else {
	    		
	    		System.out.println("Invalid password");
	    	
	    	}
	    	
    	}
    	

    	
    	try {
            // STEP 2: loading dinamico del driver mysql
            Class.forName(DRIVER_CLASS_NAME);

            // STEP 3: apertura connessione
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // STEP 4.1: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            int result = CRUDQueries.modifPassword(stmt, usr);

            
        } finally {
            // STEP 5.2: Clean-up dell'ambiente        	
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
        }
    	
    	
    	System.out.println("\nSUCCESS: password correctly changed.");

    	
    }
    
    
       
    public User logUsr() throws Exception {
    	
		String username;
		String password;
		
		Statement stmt = null;
    	Connection conn = null;
    	boolean ret;
    	

    	System.out.println();
    	//for the username must check if it's unique
    	System.out.print("Username: ");
    	username = scan.next();
    	
    	System.out.println();
    	System.out.print("Password: ");
    	password = scan.next();
    	
		User usr = new User(username, password);

		try {
            // STEP 2: loading dinamico del driver mysql
			Class.forName(DRIVER_CLASS_NAME);
        	
            // STEP 3: apertura connessione
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // STEP 4: creazione ed esecuzione della query
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ret = SimpleQueries.loginPswChecker(stmt, usr);

            
        } finally {
            // STEP 5.2: Clean-up dell'ambiente
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
				
		return usr;
		
    }
    
    
    
    
    public void persInfo(User usr) {
    	
    	
    	System.out.println("These are the informations of your account:\n");
    	System.out.println("Cognome: "+usr.getSecondName());
    	System.out.println("Nome: "+usr.getFirstName());
    	System.out.println("Età: "+usr.getAge());
    	System.out.println("Email: "+usr.getEmail());
    	System.out.println("Username: "+usr.getUsername());
    	System.out.println("Password: "+usr.getPassword());
    	System.out.println("Secret Question: "+usr.getSQ());
    	System.out.println("Secret Ansewer: "+usr.getSA());

    	System.out.println();
    	System.out.println();


    	
    }
    
    
    
    
    
    
 
    public static void main(String args[]) throws Exception {
    	
    	scan = new Scanner(System.in);
    	scan.useDelimiter("\n");
    	

    	UserDao d = new UserDao();
     	
    	
    	User usr = d.logUsr();
    	
    	Viaggio v = new Viaggio(1, "username4", "Londra", "null", true);
    	
    	CommentDao.writeComment(usr, v);
    	
    	/*    	
    	List<Viaggio> list = ViaggiDao.retreiveTravells(usr);

		System.out.println("\n\n\n*************************************************\n\n");

		System.out.println("\t ____________________________");

		for (Viaggio viaggio : list) {
			System.out.println("\t|  "+viaggio.getDst()+"      |  "+viaggio.getIdU()+"      |");
			System.out.println("\t ----------------------------");

		}
    	*/

       	scan.close();

    }
    
}
