package practice.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import practice.model.ScheduleEntry;

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
	
	//Get reservations entries
	public List<ScheduleEntry> getReservations()
	{
		List<ScheduleEntry> entries = new ArrayList<ScheduleEntry>();
		try
		{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from reservations");
			while( rs.next() )
			{
				ScheduleEntry entry = new ScheduleEntry();
				if (!rs.getString("MON").equals(" ")) {
					entry.setDay("MON");
					entry.setName(rs.getString("MON"));
					entry.setTime(rs.getString("time"));
					entries.add(entry);
				}
				if (!rs.getString("TUE").equals(" ")) {
					entry.setDay("TUE");
					entry.setName(rs.getString("TUE"));
					entry.setTime(rs.getString("time"));
					entries.add(entry);
				}
				if (!rs.getString("WED").equals(" ")) {
					entry.setDay("WED");
					entry.setName(rs.getString("WED"));
					entry.setTime(rs.getString("time"));
					entries.add(entry);
				}
				if (!rs.getString("THR").equals(" ")) {
					entry.setDay("THR");
					entry.setName(rs.getString("THR"));
					entry.setTime(rs.getString("time"));
					entries.add(entry);
				}
				if (!rs.getString("FRI").equals(" ")) {
					entry.setDay("FRI");
					entry.setName(rs.getString("FRI"));
					entry.setTime(rs.getString("time"));
					entries.add(entry);
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
	
	//Add user to reservations
	public void addReservation() {
		try
		{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("update ? from reservations");
		}
		catch( SQLException e )
		{
			e.printStackTrace();
		}
	}
	
	//Remove user from reservations
	
	
	
}
