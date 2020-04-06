package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlbumController {
    /**
     * preia conexiunea de la obiectul Database
     * initializeaza obiectul statement care va executa queryul
     * si incearaca sa execute query ul
     * @param name
     * @param artistId
     * @param releaseYear
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void create(String name, int artistId, int releaseYear) throws SQLException, ClassNotFoundException {
        Connection conn=new Database().getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate("insert into  albums(name, artist_id , release_year) values('"+name+"','"+artistId+"'"+","+"'"+ releaseYear+"')");
        new Database().closeConnection();
    }

    /**
     *
     * preia conexiunea de la obiectul Database
     * initializeaza obiectul statement care va executa queryul
     * si incearaca sa execute query ul si sa memoreze rezultatul intr un omiect de tip ResultSet
     * si afiseaza outputul inregistatrt de variabila rs
     * @param id
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    public void findByArtist(int id ) throws SQLException, ClassNotFoundException {
        Connection con=new Database().getConnection();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from albums where artist_id='"+id+"'");
        while(rs.next())
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4));
        new Database().closeConnection();
    }

    /**
     * preia conexiunea de la obiectul Database
     * initializeaza obiectul statement care va executa queryul
     * si incearaca sa execute query ul si sa memoreze rezultatul intr un omiect de tip ResultSet
     * si afiseaza outputul inregistatrt de variabila rs
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void getSongs() throws SQLException, ClassNotFoundException {
        Connection con=new Database().getConnection();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from albums");
        while(rs.next())
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4));
        new Database().closeConnection();
    }
}
