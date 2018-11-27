package boynerfatura;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MUTLU
 */
public class urun {
    private String irsNo;
    private String irsTarih;
    private int malzKodu;
    private String malzTanımı;
    private float birimFiyati;
    private int miktar;
    private int kdvOrani;
    private float iskonto;

    public String getIrsNo() {
        return irsNo;
    }

    public void setIrsNo(String irsNo) {
        this.irsNo = irsNo;
    }

    public String getIrsTarih() {
        return irsTarih;
    }

    public void setIrsTarih(String irsTarih) {
        this.irsTarih = irsTarih;
    }

    public int getMalzKodu() {
        return malzKodu;
    }

    public void setMalzKodu(int malzKodu) {
        this.malzKodu = malzKodu;
    }

    public String getMalzTanımı() {
        return malzTanımı;
    }

    public void setMalzTanımı(String malzTanımı) {
        this.malzTanımı = malzTanımı;
    }

    public float getBirimFiyati() {
        return birimFiyati;
    }

    public void setBirimFiyati(float birimFiyati) {
        this.birimFiyati = birimFiyati;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public int getKdvOrani() {
        return kdvOrani;
    }

    public void setKdvOrani(int kdvOrani) {
        this.kdvOrani = kdvOrani;
    }

    public float getIskonto() {
        return iskonto;
    }

    public void setIskonto(float iskonto) {
        this.iskonto = iskonto;
    }

    public urun(String irsNo, String irsTarih, int malzKodu, String malzTanımı, float birimFiyati, int miktar, int kdvOrani, float iskonto) {
        this.irsNo = irsNo;
        this.irsTarih = irsTarih;
        this.malzKodu = malzKodu;
        this.malzTanımı = malzTanımı;
        this.birimFiyati = birimFiyati;
        this.miktar = miktar;
        this.kdvOrani = kdvOrani;
        this.iskonto = iskonto;
    }
    

    
}
