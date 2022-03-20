package lab12.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lab12.model.Department;
import lab12.model.Faculty;

public class DbService {

	private String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu24";

	private String username = "cs3220stu24";

	private String password = "X34IKkiiO6Fg";

	private Connection connection;

	public DbService()
	{
		try
		{
			connection = DriverManager.getConnection( url, username, password );
		}
		catch( SQLException e )
		{
			e.printStackTrace();
		}
	}

	public void close()
	{
		if( connection != null )
		{
			try
			{
				connection.close();
			}
			catch( SQLException e )
			{
				e.printStackTrace();
			}
		}
	}

	//Get department entries
	public List<Department> getDepartmentEntries()
	{
		List<Department> entries = new ArrayList<Department>();

		try
		{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery( "select * from department" );
			while( rs.next() )
			{
				Department entry = new Department();
				entry.setName( rs.getString( "name" ) );
				entries.add( entry );
				entry.setFaculty(getFacultyEntries(entry.getName()));
			}
			stmt.close();
		}
		catch( SQLException e )
		{
			e.printStackTrace();
		}

		return entries;
	}

	//Add department entry
	public int addDepartmentEntry( String name )
	{
		int id = 0;
		try
		{
			String sql = "insert into department (name) values (?)";
			PreparedStatement pstmt = connection.prepareStatement( sql,
					Statement.RETURN_GENERATED_KEYS );
			pstmt.setString( 1, name );
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if( rs.next() ) id = rs.getInt( 1 );
			pstmt.close();
		}
		catch( SQLException e )
		{
			e.printStackTrace();
		}
		return id;
	}

	//Get faculty entries -- TO DO --
	public List<Faculty> getFacultyEntries(String name)
	{
		List<Faculty> entries = new ArrayList<Faculty>();

		try
		{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery( "select * from faculty" );
			while( rs.next() )
			{
				
				if (name.equals( rs.getString("departmentName"))) {
					Faculty entry = new Faculty();
					entry.setName( rs.getString( "name" ) );
					entry.setChair( rs.getBoolean( "isChair" ) );
					entries.add( entry );
				}

			}
			stmt.close();
		}
		catch( SQLException e )
		{
			e.printStackTrace();
		}

		return entries;
	}

	//Add faculty entry -- TO DO --
	public int addFacultyEntry( String name, String departmentName, boolean isChair )
	{
		int id = 0;
		try
		{
			String sql = "insert into faculty (name, departmentName, isChair) values (?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement( sql,
					Statement.RETURN_GENERATED_KEYS );
			pstmt.setString( 1, name );
			pstmt.setString( 2, departmentName);
			pstmt.setBoolean( 3, isChair);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if( rs.next() ) id = rs.getInt( 1 );
			pstmt.close();
		}
		catch( SQLException e )
		{
			e.printStackTrace();
		}
		return id;
	}

}
