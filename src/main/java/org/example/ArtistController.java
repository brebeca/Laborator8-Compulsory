package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArtistController {
    /**
     *
     * preia conexiunea de la obiectul Database
     * initializeaza obiectul statement care va executa queryul
     * si incearaca sa execute query ul
     * @param name
     * @param country
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void create(String name, String country) throws SQLException, ClassNotFoundException {
        Connection conn=new Database().getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate("insert into  artists(name, country) values('"+name+"','"+country+"')");
        new Database().closeConnection();
        new Database().closeConnection();
    }

    /**
      * preia conexiunea de la obiectul Database
     * initializeaza obiectul statement care va executa queryul
    * si incearaca sa execute query ul si sa memoreze rezultatul intr un omiect de tip ResultSet
     * si afiseaza outputul inregistatrt de variabila rs
     * @param name
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void findByName(String name) throws SQLException, ClassNotFoundException {
        Connection con=new Database().getConnection();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from artists where name ='"+name+"'");
        while(rs.next())
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
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
    public void getArtsits() throws SQLException, ClassNotFoundException {
        Connection con=new Database().getConnection();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from artists");
        while(rs.next())
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
        new Database().closeConnection();
    }
}
