/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stok;
/**
 *
 * @author MUTLU
 */
public class parti {
    private int parti_no;
    private String tarih;
    private String saat;

    public int getParti_no() {
        return parti_no;
    }

    public void setParti_no(int parti_no) {
        this.parti_no = parti_no;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getSaat() {
        return saat;
    }

    public void setSaat(String saat) {
        this.saat = saat;
    }

    public parti(int parti_no, String tarih, String saat) {
        this.parti_no = parti_no;
        this.tarih = tarih;
        this.saat = saat;
    }
}
