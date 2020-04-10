package org.example;


import com.github.javafaker.Faker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App
{
    public static void main( String[] args ){
        try{
            Database database=new Database();
            Connection connection=database.getConnection();
            ArtistController artistController = new ArtistController(connection);
            AlbumController albumController=new AlbumController(connection);

            //Generarea datelor din Albums si Artists
            Faker faker = new Faker();
            int artistId=1;
            for(int i=0; i<30 ;i++){
                String name = faker.artist().name();
                String country = faker.address().country();
                artistController.create(name, country);
                //artistId=artistController.getIdByName(name);
                String albumName=faker.relationships().any();
                albumController.create(albumName,artistController.getIdByName(name),2000);
             }

            //Popularea tabelei Charts
            ChartController chartController= new ChartController(connection);
            for(int i=1; i<=albumController.getCount() ;i++){
               chartController.insert(i);
            }

            chartController.getArtists();

            database.closeConnection();

        }catch(Exception e){
            System.out.println(e.getMessage()+" eroare "+e.getCause());
        }
}
}
