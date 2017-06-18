/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import connection.Connect;
import funkcionalnosti.Funkcionalnosti;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigDecimal;

/**
 *
 * @author stefan
 */
public class pn130473 extends Funkcionalnosti{

    Connection con;
    
    public pn130473() {
        
        con = Connect.getConnection();
    }
   
    @Override
    public int unesiGradiliste(String naziv, Date datumOsnivanja) {
        try {
            CallableStatement cs = con.prepareCall("{call unesiGradiliste(?,?,?)}");
            cs.setString(1,naziv);
            cs.setDate(2, datumOsnivanja);
            cs.registerOutParameter(3, java.sql.Types.INTEGER);
            
            cs.executeUpdate();
            return cs.getInt(3);
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    @Override
    public int obrisiGradiliste(int idGradiliste) {
        try {
            CallableStatement cs = con.prepareCall("{call obrisiGradiliste(?)}");
            cs.setInt(1,idGradiliste);
            int ra = cs.executeUpdate();
            if (ra == 0) return 1;
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public List<Integer> dohvatiSvaGradilista() {
        List<Integer> ret = new ArrayList();
        try {
            CallableStatement cs = con.prepareCall("{call dohvatiSvaGradilista()}");
            cs.execute();
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                ret.add(rs.getInt("IdGradiliste"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    @Override
    public int unesiObjekat(String naziv, int idGradiliste) {
        try {
            CallableStatement cs = con.prepareCall("{call unesiObjekat(?,?,?)}");
            cs.setString(1,naziv);
            cs.setInt(2, idGradiliste);
            cs.registerOutParameter(3, java.sql.Types.INTEGER);
            cs.executeUpdate();
            return cs.getInt(3);
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    @Override
    public int obrisiObjekat(int idObjekat) {
        try {
            CallableStatement cs = con.prepareCall("{call obrisiObjekat(?)}");
            cs.setInt(1,idObjekat);
            int ra = cs.executeUpdate();
            if (ra == 0) return 1;
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int unesiSprat(int brSprata, int idObjekat) {
        try {
            CallableStatement cs = con.prepareCall("{call unesiSprat(?,?,?)}");
            cs.setInt(1,brSprata);
            cs.setInt(2,idObjekat);
            cs.registerOutParameter(3, java.sql.Types.INTEGER);
            cs.executeUpdate();
            return cs.getInt(3);
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    @Override
    public int obrisiSprat(int idSprat) {
        try {
            CallableStatement cs = con.prepareCall("{call obrisiSprat(?)}");
            cs.setInt(1,idSprat);
            int ra = cs.executeUpdate();
            if (ra == 0) return 1;
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int unesiZaposlenog(String ime, String prezime, String jmbg, String pol, String ziroRacun, String email, String brojTelefona) {
        try {
            CallableStatement cs = con.prepareCall("{call unesiZaposlenog(?,?,?,?,?,?,?,?)}");
            cs.setString(1,ime);
            cs.setString(2,prezime);
            cs.setString(3,jmbg);
            cs.setString(4,pol);
            cs.setString(5,ziroRacun);
            cs.setString(6,email);
            cs.setString(7,brojTelefona);
            cs.registerOutParameter(8, java.sql.Types.INTEGER);
            cs.executeUpdate();
            return cs.getInt(8);
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    @Override
    public int obrisiZaposlenog(int idZaposleni) {
        try {
            CallableStatement cs = con.prepareCall("{call obrisiZaposlenog(?)}");
            cs.setInt(1,idZaposleni);
            int ra = cs.executeUpdate();
            if (ra == 0) return 1;
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public BigDecimal dohvatiUkupanIsplacenIznosZaZaposlenog(int idZaposleni) {
        try {
            CallableStatement cs = con.prepareCall("{call dohvatiUkupanIsplacenIznosZaZaposlenog(?,?)}");
            cs.setInt(1,idZaposleni);
            cs.registerOutParameter(2, java.sql.Types.DECIMAL);
            cs.executeUpdate();
            return cs.getBigDecimal(2);
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return BigDecimal.valueOf(-1.0);
        }
    }

    @Override
    public BigDecimal dohvatiProsecnuOcenuZaZaposlenog(int idZaposleni) {
        try {
            CallableStatement cs = con.prepareCall("{call dohvatiProsecnuOcenuZaZaposlenog(?,?)}");
            cs.setInt(1,idZaposleni);
            cs.registerOutParameter(2, java.sql.Types.DECIMAL);
            cs.executeUpdate();
            return cs.getBigDecimal(2);
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return BigDecimal.valueOf(-1.0);
        }
        
    }

    @Override
    public int dohvatiBrojTrenutnoZaduzeneOpremeZaZaposlenog(int idZaposleni) {
        try {
            CallableStatement cs = con.prepareCall("{call dohvatiBrojTrenutnoZaduzeneOpremeZaZaposlenog(?,?)}");
            cs.setInt(1,idZaposleni);
            cs.registerOutParameter(2, java.sql.Types.INTEGER);
            cs.executeUpdate();
            return cs.getInt(2);
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    @Override
    public List<Integer> dohvatiSveZaposlene() {
        List<Integer> ret = new ArrayList();
        try {
            CallableStatement cs = con.prepareCall("{call dohvatiSveZaposlene()}");
            cs.execute();
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                ret.add(rs.getInt("IdZaposleni"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    @Override
    public int unesiMagacin(int idSef, BigDecimal plata, int idGradiliste) {
        try {
            CallableStatement cs = con.prepareCall("{call unesiMagacin(?,?,?,?)}");
            cs.setInt(1,idSef);
            cs.setBigDecimal(2,plata);
            cs.setInt(3,idGradiliste);
            cs.registerOutParameter(4, java.sql.Types.INTEGER);
            cs.executeUpdate();
            return cs.getInt(4);
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int obrisiMagacin(int idMagacin) {
        try {
            CallableStatement cs = con.prepareCall("{call obrisiMagacin(?)}");
            cs.setInt(1,idMagacin);
            int ra = cs.executeUpdate();
            if (ra == 0) return 1;
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int izmeniSefaZaMagacin(int idMagacin, int idSefNovo) {
        try {
            CallableStatement cs = con.prepareCall("{call izmeniSefaZaMagacin(?,?)}");
            cs.setInt(1,idMagacin);
            cs.setInt(2,idSefNovo);
            int ra = cs.executeUpdate();
            if (ra == 0) return 1;
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int izmeniPlatuZaMagacin(int idMagacin, BigDecimal plataNovo) {
        try {
            CallableStatement cs = con.prepareCall("{call izmeniPlatuZaMagacin(?,?)}");
            cs.setInt(1,idMagacin);
            cs.setBigDecimal(2,plataNovo);
            int ra = cs.executeUpdate();
            if (ra == 0) return 1;
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int isplatiPlateZaposlenimaUSvimMagacinima() {
        try {
            CallableStatement cs = con.prepareCall("{call isplatiPlateZaposlenimaUSvimMagacinima()}");
            int ra = cs.executeUpdate();
            if (ra == 0) return 1;
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int isplatiPlateZaposlenimaUMagacinu(int idMagacin) {
        try {
            CallableStatement cs = con.prepareCall("{call isplatiPlateZaposlenimaUMagacinu(?)}");
            cs.setInt(1,idMagacin);
            int ra = cs.executeUpdate();
            if (ra == 0) return 1;
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int unesiRobuUMagacinPoKolicini(int idRoba, int idMagacin, BigDecimal kolicina) {
        try {
            CallableStatement cs = con.prepareCall("{call unesiRobuUMagacinPoKolicini(?,?,?,?)}");
            cs.setInt(1,idRoba);
            cs.setInt(2,idMagacin);
            cs.setBigDecimal(3,kolicina);
            cs.registerOutParameter(4, java.sql.Types.INTEGER);
            cs.executeUpdate();
            return cs.getInt(4);
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    @Override
    public int unesiRobuUMagacinPoBrojuJedinica(int idRoba, int idMagacin, int brojJedinica) {
        try {
            CallableStatement cs = con.prepareCall("{call unesiRobuUMagacinPoKolicini(?,?,?,?)}");
            cs.setInt(1,idRoba);
            cs.setInt(2,idMagacin);
            cs.setInt(3,brojJedinica);
            cs.registerOutParameter(4, java.sql.Types.INTEGER);
            cs.executeUpdate();
            return cs.getInt(4);
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    @Override
    public BigDecimal uzmiRobuIzMagacinaPoKolicini(int idRoba, int idMagacin, BigDecimal kolicina) {
        try {
            CallableStatement cs = con.prepareCall("{call uzmiRobuIzMagacinaPoKolicini(?,?,?,?)}");
            cs.setInt(1,idRoba);
            cs.setInt(2,idMagacin);
            cs.setBigDecimal(3,kolicina);
            cs.registerOutParameter(4, java.sql.Types.DECIMAL);
            cs.executeUpdate();
            return cs.getBigDecimal(4);
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return BigDecimal.valueOf(-1.0);
        }
    }

    @Override
    public int uzmiRobuIzMagacinaPoBrojuJedinica(int idRoba, int idMagacin, int brojJedinca) {
        try {
            CallableStatement cs = con.prepareCall("{call uzmiRobuIzMagacinaPoKolicini(?,?,?,?)}");
            cs.setInt(1,idRoba);
            cs.setInt(2,idMagacin);
            cs.setBigDecimal(3,new BigDecimal(brojJedinca));
            cs.registerOutParameter(4, java.sql.Types.DECIMAL);
            cs.executeUpdate();
            return cs.getBigDecimal(4).intValue();
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    @Override
    public BigDecimal pogledajKolicinuRobeUMagacinu(int idRoba, int idMagacin) {
        try {
            CallableStatement cs = con.prepareCall("{call pogledajKolicinuRobeUMagacinu(?,?,?)}");
            cs.setInt(1,idRoba);
            cs.setInt(2,idMagacin);
            cs.registerOutParameter(3, java.sql.Types.DECIMAL);
            cs.executeUpdate();
            return cs.getBigDecimal(3);
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return BigDecimal.valueOf(-1.0);
        }
    }

    @Override
    public int pogledajBrojJedinicaRobeUMagacinu(int idRoba, int idMagacin) {
        try{    
            CallableStatement cs = con.prepareCall("{call pogledajKolicinuRobeUMagacinu(?,?,?)}");
            cs.setInt(1,idRoba);
            cs.setInt(2,idMagacin);
            cs.registerOutParameter(3, java.sql.Types.DECIMAL);
            cs.executeUpdate();
            return cs.getBigDecimal(3).intValue();
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int unesiTipRobe(String naziv) {
        try{    
            CallableStatement cs = con.prepareCall("{call unesiTipRobe(?,?)}");
            cs.setString(1,naziv);
            cs.registerOutParameter(2, java.sql.Types.INTEGER);
            cs.executeUpdate();
            return cs.getInt(2);
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    @Override
    public int obrisiTipRobe(int idTipRobe) {
        try{    
            CallableStatement cs = con.prepareCall("{call obrisiTipRobe(?)}");
            cs.setInt(1,idTipRobe);
            int ra = cs.executeUpdate();
            if (ra == 0) return 1;
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int unesiRobu(String naziv, String kod, int idTipRobe) {
        try{    
            CallableStatement cs = con.prepareCall("{call unesiRobu(?,?,?,?)}");
            cs.setString(1,naziv);
            cs.setString(2,kod);
            cs.setInt(3,idTipRobe);
            cs.registerOutParameter(4, java.sql.Types.INTEGER);
            cs.executeUpdate();
            return cs.getInt(4);
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    @Override
    public int obrisiRobu(int idRoba) {
        try{    
            CallableStatement cs = con.prepareCall("{call obrisiRobu(?)}");
            cs.setInt(1,idRoba);
            int ra = cs.executeUpdate();
            if (ra == 0) return 1;
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public List<Integer> dohvatiSvuRobu() {
        List<Integer> ret = new ArrayList();
        try {
            CallableStatement cs = con.prepareCall("{call dohvatiSvuRobu()}");
            cs.execute();
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                ret.add(rs.getInt("IdRoba"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    @Override
    public int zaposleniRadiUMagacinu(int idZaposleni, int idMagacin) {
        try{    
            CallableStatement cs = con.prepareCall("{call zaposleniRadiUMagacinu(?,?,?)}");
            cs.setInt(1,idZaposleni);
            cs.setInt(2,idMagacin);
            cs.registerOutParameter(3, java.sql.Types.INTEGER);
            cs.executeUpdate();
            return cs.getInt(3);
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    @Override
    public int zaposleniNeRadiUMagacinu(int idZaposleni) {
        try{    
            CallableStatement cs = con.prepareCall("{call zaposleniNeRadiUMagacinu(?)}");
            cs.setInt(1,idZaposleni);
            int ra = cs.executeUpdate();
            if (ra == 0) return 1;
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int zaposleniZaduzujeOpremu(int idZaposlenogKojiZaduzuje, int idMagacin, int idRoba, Date datumZaduzenja, String napomena) {
        try{    
            CallableStatement cs = con.prepareCall("{call zaposleniZaduzujeOpremu(?,?,?,?,?,?)}");
            cs.setInt(1,idZaposlenogKojiZaduzuje);
            cs.setInt(2,idMagacin);
            cs.setInt(3,idRoba);
            cs.setDate(4,datumZaduzenja);
            cs.setString(5,napomena);
            cs.registerOutParameter(6, java.sql.Types.INTEGER);
            cs.executeUpdate();
            return cs.getInt(6);
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    @Override
    public int zaposleniRazduzujeOpremu(int idZaduzenjaOpreme, Date datumRazduzenja) {
        try{    
            CallableStatement cs = con.prepareCall("{call zaposleniRazduzujeOpremu(?,?)}");
            cs.setInt(1,idZaduzenjaOpreme);
            cs.setDate(2,datumRazduzenja);
            int ra = cs.executeUpdate();
            if (ra == 0) return 1;
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int unesiNormuUgradnogDela(String naziv, BigDecimal cenaIzrade, BigDecimal jedinicnaPlataRadnika) {
        try{    
            CallableStatement cs = con.prepareCall("{call unesiNormuUgradnogDela(?,?,?,?)}");
            cs.setString(1,naziv);
            cs.setBigDecimal(2,cenaIzrade);
            cs.setBigDecimal(3,jedinicnaPlataRadnika);
            cs.registerOutParameter(4, java.sql.Types.INTEGER);
            cs.executeUpdate();
            return cs.getInt(4);
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    @Override
    public int obrisiNormuUgradnogDela(int idNormaUgradnogDela) {
        try{    
            CallableStatement cs = con.prepareCall("{call obrisiNormuUgradnogDela(?)}");
            cs.setInt(1,idNormaUgradnogDela);
            int ra = cs.executeUpdate();
            if (ra == 0) return 1;
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public BigDecimal dohvatiJedinicnuPlatuRadnikaNormeUgradnogDela(int idNR) {
        try {
            CallableStatement cs = con.prepareCall("{call dohvatiJedinicnuPlatuRadnikaNormeUgradnogDela(?,?)}");
            cs.setInt(1,idNR);
            cs.registerOutParameter(2, java.sql.Types.DECIMAL);
            cs.executeUpdate();
            return cs.getBigDecimal(2);
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return BigDecimal.valueOf(-1.0);
        }
    }

    @Override
    public int unesiPotrebanMaterijalPoBrojuJedinica(int idRobaKojaJePotrosniMaterijal, int idNormaUgradnogDela, int brojJedinica) {
        try{    
            CallableStatement cs = con.prepareCall("{call unesiPotrebanMaterijalPoKolicini(?,?,?,?)}");
            cs.setInt(1,idRobaKojaJePotrosniMaterijal);
            cs.setInt(2,idNormaUgradnogDela);
            cs.setInt(3,brojJedinica);
            cs.registerOutParameter(4, java.sql.Types.INTEGER);
            cs.executeUpdate();
            return cs.getInt(4);
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    @Override
    public int unesiPotrebanMaterijalPoKolicini(int idRobaKojaJePotrosniMaterijal, int idNormaUgradnogDela, BigDecimal kolicina) {
        try{    
            CallableStatement cs = con.prepareCall("{call unesiPotrebanMaterijalPoKolicini(?,?,?,?)}");
            cs.setInt(1,idRobaKojaJePotrosniMaterijal);
            cs.setInt(2,idNormaUgradnogDela);
            cs.setBigDecimal(3,kolicina);
            cs.registerOutParameter(4, java.sql.Types.INTEGER);
            cs.executeUpdate();
            return cs.getInt(4);
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    @Override
    public int obrisiPotrebanMaterijal(int idRobaKojaJePotrosniMaterijal, int idNormaUgradnogDela) {
        try{    
            CallableStatement cs = con.prepareCall("{call obrisiPotrebanMaterijal(?,?)}");
            cs.setInt(1,idRobaKojaJePotrosniMaterijal);
            cs.setInt(2,idNormaUgradnogDela);
            int ra = cs.executeUpdate();
            if (ra == 0) return 1;
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int unesiPosao(int idNormaUgradnogDela, int idSprat, Date datumPocetka) {
        try{    
            CallableStatement cs = con.prepareCall("{call unesiPosao(?,?,?,?)}");
            cs.setInt(1,idNormaUgradnogDela);
            cs.setInt(2,idSprat);
            cs.setDate(3,datumPocetka);
            cs.registerOutParameter(4, java.sql.Types.INTEGER);
            cs.executeUpdate();
            return cs.getInt(4);
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    @Override
    public int obrisiPosao(int idPosao) {
        try{    
            CallableStatement cs = con.prepareCall("{call obrisiPosao(?)}");
            cs.setInt(1,idPosao);
            int ra = cs.executeUpdate();
            if (ra == 0) return 1;
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int izmeniDatumPocetkaZaPosao(int idPosao, Date datumPocetka) {
        try{    
            CallableStatement cs = con.prepareCall("{call izmeniDatumPocetkaZaPosao(?,?)}");
            cs.setInt(1,idPosao);
            cs.setDate(2,datumPocetka);
            int ra = cs.executeUpdate();
            if (ra == 0) return 1;
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int zavrsiPosao(int idPosao, Date datumKraja) {
        try{    
            CallableStatement cs = con.prepareCall("{call zavrsiPosao(?,?)}");
            cs.setInt(1,idPosao);
            cs.setDate(2,datumKraja);
            int ra = cs.executeUpdate();
            if (ra == 0) return 1;
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int zaposleniRadiNaPoslu(int idZaposleni, int idPosao, Date datumPocetka) {
        try{    
            CallableStatement cs = con.prepareCall("{call zaposleniRadiNaPoslu(?,?,?,?)}");
            cs.setInt(1,idZaposleni);
            cs.setInt(2,idPosao);
            cs.setDate(3,datumPocetka);
            cs.registerOutParameter(4, java.sql.Types.INTEGER);
            cs.executeUpdate();
            return cs.getInt(4);
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    @Override
    public int zaposleniJeZavrsioSaRadomNaPoslu(int idZaposleniNaPoslu, Date datumKraja) {
        try{    
            CallableStatement cs = con.prepareCall("{call zaposleniJeZavrsioSaRadomNaPoslu(?,?)}");
            cs.setInt(1,idZaposleniNaPoslu);
            cs.setDate(2,datumKraja);
            int ra = cs.executeUpdate();
            if (ra == 0) return 1;
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int izmeniDatumPocetkaRadaZaposlenogNaPoslu(int idZaposleniNaPoslu, Date datumPocetkaNovo) {
        try{    
            CallableStatement cs = con.prepareCall("{call izmeniDatumPocetkaRadaZaposlenogNaPoslu(?,?)}");
            cs.setInt(1,idZaposleniNaPoslu);
            cs.setDate(2,datumPocetkaNovo);
            int ra = cs.executeUpdate();
            if (ra == 0) return 1;
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int izmeniDatumKrajaRadaZaposlenogNaPoslu(int idZaposleniNaPoslu, Date datumKrajaNovo) {
        try{    
            CallableStatement cs = con.prepareCall("{call izmeniDatumKrajaRadaZaposlenogNaPoslu(?,?)}");
            cs.setInt(1,idZaposleniNaPoslu);
            cs.setDate(2,datumKrajaNovo);
            int ra = cs.executeUpdate();
            if (ra == 0) return 1;
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int zaposleniDobijaOcenu(int idZaposleniNaPoslu, int ocena) {
        try{    
            CallableStatement cs = con.prepareCall("{call zaposleniDobijaOcenu(?,?)}");
            cs.setInt(1,idZaposleniNaPoslu);
            cs.setInt(2,ocena);
            int ra = cs.executeUpdate();
            if (ra == 0) return 1;
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int obrisiOcenuZaposlenom(int idZaposleniNaPoslu) {
        try{    
            CallableStatement cs = con.prepareCall("{call obrisiOcenuZaposlenom(?)}");
            cs.setInt(1,idZaposleniNaPoslu);
            int ra = cs.executeUpdate();
            if (ra == 0) return 1;
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public int izmeniOcenuZaZaposlenogNaPoslu(int idZaposleniNaPoslu, int ocenaNovo) {
        try{    
            CallableStatement cs = con.prepareCall("{call izmeniOcenuZaZaposlenogNaPoslu(?,?)}");
            cs.setInt(1,idZaposleniNaPoslu);
            cs.setInt(2,ocenaNovo);
            int ra = cs.executeUpdate();
            if (ra == 0) return 1;
            else return 0;
        } catch (SQLException ex) {
            Logger.getLogger(pn130473.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
}
