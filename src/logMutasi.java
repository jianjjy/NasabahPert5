public class logMutasi {
    private String nomorRekening;
    private String infoMutasi;


    public logMutasi() {
    }

    public logMutasi(String nomorRekening, String infoMutasi) {
        this.nomorRekening = nomorRekening;
        this.infoMutasi = infoMutasi;
    }

    public String getNomorRekening() {
        return this.nomorRekening;
    }

    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }

    public String getInfoMutasi() {
        return this.infoMutasi;
    }

    public void setInfoMutasi(String infoMutasi) {
        this.infoMutasi = infoMutasi;
    }

}
