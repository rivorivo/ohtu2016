/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author rivorivo
 */
public class StatisticsTest {
    
    Statistics statsit;
    
     
        Reader readerStub = new Reader() {

            @Override
            public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
        };
        @Before
        public void setUp(){
            statsit=new Statistics(readerStub);
          
        }
        
        @Test
        public void kurriEiKulli(){
            assertEquals("Kurri",statsit.search("Kurri").getName());
        }
        
        @Test
        public void narionJengi(){
            assertEquals("PIT",statsit.search("Lemieux").getTeam());
        }
        
        @Test
        public void edmontoninPelaajat(){
  
            ArrayList<String> edmontonilaiset = new ArrayList<String>();
            for (Player p : statsit.team("EDM")) {
               edmontonilaiset.add(p.getName());
            }
           
            assertEquals("[Semenko, Kurri, Gretzky]",edmontonilaiset.toString());
        }
        
        @Test
        public void pörssikärkiToimii(){
           ArrayList<String> top3 = new ArrayList<String>();
            for (Player p : statsit.topScorers(2)) {
               top3.add(p.getName());
            } 
            assertEquals("[Gretzky, Lemieux, Yzerman]",top3.toString());
        }
        
        @Test
        public void eiPalautaVääriä(){
            assertEquals(null,statsit.search("Söderholm"));
        }
}