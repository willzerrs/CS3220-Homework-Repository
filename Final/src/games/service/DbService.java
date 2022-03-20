package games.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import games.model.Comments;
import games.model.Reviews;


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

	public List<Reviews> getGames() {
		List<Reviews> entries = new ArrayList<Reviews>();

		try
		{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery( "select * from games" );
			while( rs.next() )
			{
				Reviews entry = new Reviews();
				entry.setGame( rs.getString( "game" ) );
				entry.setReview( rs.getString( "rating" ) );
				entries.add( entry );
			}
			stmt.close();
		}
		catch( SQLException e )
		{
			e.printStackTrace();
		}

		return entries;
	}
	
	public int addGame( String game )
	{
		int id = 0;
		try
		{
			String sql = "insert into games (game) values (?)";
			PreparedStatement pstmt = connection.prepareStatement( sql,
					Statement.RETURN_GENERATED_KEYS );
			pstmt.setString( 1, game );
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
	
	public List<Comments> getReviews() {
		List<Comments> entries = new ArrayList<Comments>();

		try
		{
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery( "select * from comments" );
			while( rs.next() )
			{
				Comments entry = new Comments();
				entry.setUsername( rs.getString( "username" ) );
				entry.setGame( rs.getString( "game" ) );
				entry.setRating( rs.getString( "rating" ) );
				entry.setComments( rs.getString( "comments" ) );
				entries.add( entry );
			}
			stmt.close();
		}
		catch( SQLException e )
		{
			e.printStackTrace();
		}

		return entries;
	}

	//Add game rating
	public int addRating( String name, String game, String rating, String comments )
	{
		int id = 0;
		try
		{
			String sql = "insert into comments (username, game, rating, comments) values (?, ?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement( sql,
					Statement.RETURN_GENERATED_KEYS );
			pstmt.setString( 1, name );
			pstmt.setString( 2, game );
			pstmt.setString( 3, rating );
			pstmt.setString( 4, comments );
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
