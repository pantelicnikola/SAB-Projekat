/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testiranje;

import connection.Connect;
import funkcionalnosti.Funkcionalnosti;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import student.pn130473;
import testovi.JavniTest;
import java.sql.*;

/**
 *
 * @author stefan
 */
public class Testiranje {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Connect con = new Connect();
        
        Funkcionalnosti funkcionalnosti = new pn130473();
        double procenata = JavniTest.test(funkcionalnosti);
        double koeficijentDomaci = 0.2;
        double koeficijentJavniTest = 0.5;
        double koeficijentTajniTestovi = 0.5;
        
        System.out.println();
        System.out.println("==============================================");
        System.out.println("Na javnom testu osvojili ste " + procenata * koeficijentDomaci * koeficijentJavniTest + " poena");
        System.out.println("==============================================");
    }
    
}
