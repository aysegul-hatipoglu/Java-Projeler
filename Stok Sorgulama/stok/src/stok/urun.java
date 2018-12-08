/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stok;



public class urun {
    private int urun_id;
    private String urun_adi;
    private int urun_fiyati;
    private int adet;

    public urun(int urun_id, String urun_adi, int urun_fiyati, int adet) {
        this.urun_id = urun_id;
        this.urun_adi = urun_adi;
        this.urun_fiyati = urun_fiyati;
        this.adet = adet;
    }

    public int getUrun_fiyati() {
        return urun_fiyati;
    }

    public void setUrun_fiyati(int urun_fiyati) {
        this.urun_fiyati = urun_fiyati;
    }

    public int getUrun_id() {
        return urun_id;
    }

    public void setUrun_id(int urun_id) {
        this.urun_id = urun_id;
    }

    public String getUrun_adi() {
        return urun_adi;
    }

    public void setUrun_adi(String urun_adi) {
        this.urun_adi = urun_adi;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }


}
