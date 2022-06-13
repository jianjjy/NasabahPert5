import java.time.LocalDate;

public class Nasabah {
    private String nomorRekening;
    private String namaNasabah;
    private long saldoNasabah = 0;
    private String nomorKartuNasabah;
    private String pinNasabah;
    private LocalDate tglDaftarNasabah;

    public Nasabah() {
    }

    // public Nasabah(String nomorRekening, String namaNasabah, long saldoNasabah, Date tglDaftarNasabah) {
    //     this.nomorRekening = nomorRekening;
    //     this.namaNasabah = namaNasabah;
    //     this.saldoNasabah = saldoNasabah;
    //     this.tglDaftarNasabah = java.time.LocalDate.now();
    // }

    public Nasabah(String nomorRekening, String namaNasabah, long saldoNasabah, String nomorKartuNasabah, String pinNasabah) {
        this.nomorRekening = nomorRekening;
        this.namaNasabah = namaNasabah;
        this.saldoNasabah = saldoNasabah;
        this.nomorKartuNasabah = nomorKartuNasabah;
        this.pinNasabah = pinNasabah;
        this.tglDaftarNasabah = java.time.LocalDate.now();
    }

    public String getNomorRekening() {
        return this.nomorRekening;
    }

    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }

    public String getNamaNasabah() {
        return this.namaNasabah;
    }

    public void setNamaNasabah(String namaNasabah) {
        this.namaNasabah = namaNasabah;
    }

    public long getSaldoNasabah() {
        return this.saldoNasabah;
    }

    public void setSaldoNasabah(long saldoNasabah) {
        this.saldoNasabah = saldoNasabah;
    }

    public String getNomorKartuNasabah() {
        return this.nomorKartuNasabah;
    }

    public void setNomorKartuNasabah(String nomorKartuNasabah) {
        this.nomorKartuNasabah = nomorKartuNasabah;
    }

    public String getPinNasabah() {
        return this.pinNasabah;
    }

    public void setPinNasabah(String pinNasabah) {
        this.pinNasabah = pinNasabah;
    }

    public LocalDate getTglDaftarNasabah() {
        return this.tglDaftarNasabah;
    }

    public void setTglDaftarNasabah(LocalDate tglDaftarNasabah) {
        this.tglDaftarNasabah = tglDaftarNasabah;
    }


    @Override
    public String toString() {
        return getNomorRekening() + "\t| " + 
            getNamaNasabah() + "\t\t| " +
            getSaldoNasabah() + "\t\t| " +
            getNomorKartuNasabah() + "\t| " +
            getPinNasabah() + "\t| " +
            tglDaftarNasabah.toString() + ""
           ;
    }
}
