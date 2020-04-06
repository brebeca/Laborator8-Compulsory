package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App
{
    public static void main( String[] args ){
        try{
            ArtistController controller = new ArtistController();
            AlbumController albumController=new AlbumController();
            System.out.println("Inainte de a aduaga pe : artist3");
            controller.getArtsits();
            System.out.println("Dupa aduagarea lui : artist3");
            controller.create("artist3","rom");
            controller.getArtsits();
            System.out.println("Toti artistii cu numele : artist1");
            controller.findByName("artist1");
            System.out.println(" ");
            System.out.println("Inainte de a aduaga pe : song2");
            albumController.getSongs();
            albumController.create("song2",2,2013);
            System.out.println("Dupa aduagarea lui : song2");
            albumController.getSongs();
            System.out.println("Toate cantecele artisului cu indexul : 1");
            albumController.findByArtist(1);
        }catch(Exception e){
            System.out.println(e.getMessage()+" eroare "+e.getCause());
        }
}
}
