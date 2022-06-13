import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        ArrayList <Nasabah> data = new ArrayList<Nasabah>();
        ArrayList <logMutasi> logMutasis = new ArrayList <logMutasi>();

        init(data);

        String nomorRekening;
        String nomorRekening2;
        String namaNasabah;
        long saldoNasabah = 0;
        long setoran = 0;
        String nomorKartuNasabah;
        String pinNasabah;
        String cekPIN;
        String infoMutasi;
        boolean ditemukan = false;
        boolean cek = false;

        int pilihan;
        String yn = "y";
        do {
            cetakMenu();
            pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    bersihkanLayar();
                    System.out.println("Tambah Nasabah Baru, silahkan masukkan data nasabah");
                    System.out.println("---------------------------------------------------");
                    System.out.print ("Nomor Rekening\t\t\t: ");
                    nomorRekening = input.next();
                    System.out.print ("Nama Nasabah\t\t\t: ");
                    namaNasabah = input.next();
                    System.out.print ("Saldo Awal Nasabah\t\t: ");
                    saldoNasabah = input.nextLong();
                    System.out.print ("Nomor Kartu Nasabah\t\t: ");
                    nomorKartuNasabah = input.next();
                    System.out.print ("PIN Nasabah\t\t\t: ");
                    pinNasabah = input.next();
                    System.out.print ("Masukkan PIN Nasabah lagi\t: ");
                    cekPIN = input.next();

                    if (pinNasabah.equals(cekPIN)) {
                        data.add (new Nasabah(nomorRekening, namaNasabah, saldoNasabah, nomorKartuNasabah, pinNasabah));
                        System.out.println("Data berhasil dimasukkan");
                    } else {
                        System.out.println("PIN yang dimasukkan berbeda");
                    }

                    break;
                
                case 2: //setor
                    bersihkanLayar();
                    System.out.println("Setor Dana, silahkan masukkan data nasabah");
                    System.out.println("------------------------------------------");
                    System.out.print ("Nomor Rekening\t\t\t: ");
                    nomorRekening = input.next();
                    int i = 0;
                    ditemukan = false;
                    for (Nasabah nasabah : data) {
                        if (nasabah.getNomorRekening().equals(nomorRekening))
                        {
                            System.out.print ("Masukkan PIN\t\t\t: ");
                            pinNasabah = input.next();
                            if (nasabah.getPinNasabah().equals(pinNasabah)) {
                                System.out.print ("Jumlah uang yang disetor\t: ");
                                setoran = input.nextLong();

                                nasabah.setSaldoNasabah(nasabah.getSaldoNasabah()+setoran);
                                data.set(i, nasabah);

                                infoMutasi = nasabah.getNamaNasabah() + nomorRekening + " telah menyetor uang sejumlah Rp." + setoran;
                                logMutasis.add (new logMutasi(nomorRekening, infoMutasi));

                                System.out.println ("Setoran berhasil");

                                ditemukan = true;
                            } else {
                                System.out.println ("PIN Salah");
                                break;
                            }
                        }
                        i++;
                    }
                    if (ditemukan == false) {
                        System.out.println("Rekening yang dimasukkan salah");
                    }
                    break;
                
                case 3 : //cetak mutasi
                    bersihkanLayar();
                    System.out.println("Cetak Mutasi, silahkan masukkan data nasabah");
                    System.out.println("--------------------------------------------");
                    System.out.print ("Nomor Rekening\t\t: ");
                    nomorRekening = input.next();
                    ditemukan = false;
                    for (Nasabah nasabah : data) {
                        if (nasabah.getNomorRekening().equals(nomorRekening))
                        {
                            ditemukan = true;
                            System.out.print ("Masukkan PIN\t\t: ");
                            pinNasabah = input.next();
                            if (nasabah.getPinNasabah().equals(pinNasabah)) {
                                for (logMutasi Mutasi : logMutasis) {
                                    if (Mutasi.getNomorRekening().equals(nomorRekening)) {
                                        System.out.println(Mutasi.getInfoMutasi());
                                        cek = true;
                                    }
                                }
                                if (cek == false) {
                                    System.out.println("Tidak ada transaksi");
                                }
                            } else {
                                System.out.println ("PIN Salah");
                                break;
                            }
                        }
                        if (ditemukan) {
                            break;
                        }
                    }
                    if (ditemukan == false) {
                        System.out.println("Rekening yang dimasukkan salah");
                    }
                    break;
                    
                case 4: //transfer
                    bersihkanLayar();
                    System.out.println("Transfer, silahkan masukkan data nasabah");
                    System.out.println("----------------------------------------");
                    System.out.print ("Nomor Rekening\t\t\t\t: ");
                    nomorRekening = input.next();
                    i = 0;
                    ditemukan = false;
                    boolean ditemukan2 = false;
                    for (Nasabah nasabah : data) {
                        if (nasabah.getNomorRekening().equals(nomorRekening))
                        {
                            ditemukan = true;
                            System.out.print ("Masukkan PIN\t\t\t\t: ");
                            pinNasabah = input.next();
                            if (nasabah.getPinNasabah().equals(pinNasabah)) {
                                System.out.print ("Masukkan Nomor Rekening Penerima\t: ");
                                nomorRekening2 = input.next();
                                int j = 0;
                                for (Nasabah nasabah2 : data) {
                                    if (nasabah2.getNomorRekening().equals(nomorRekening2))
                                    {
                                        ditemukan2 = true;
                                        if (ditemukan2 && ditemukan) {
                                            System.out.print ("Jumlah uang yang ditransfer\t\t: ");
                                            setoran = input.nextLong();
            
                                            if (nasabah.getSaldoNasabah()>= setoran) {
                                                nasabah.setSaldoNasabah(nasabah.getSaldoNasabah()-setoran);
                                                data.set(i, nasabah);
            
                                                nasabah2.setSaldoNasabah(nasabah2.getSaldoNasabah()+setoran);
                                                data.set(j, nasabah2);
                
                                                infoMutasi = nasabah.getNamaNasabah() + " " + nomorRekening + " telah mengirim uang sejumlah Rp." + setoran + " kepada " + nasabah2.getNamaNasabah() + " " + nomorRekening2;
                                                logMutasis.add (new logMutasi(nomorRekening, infoMutasi));
    
                                                infoMutasi = nasabah2.getNamaNasabah() + " " + nomorRekening2 + " telah menerima uang sejumlah Rp." + setoran + " dari " + nasabah.getNamaNasabah() + " " + nomorRekening;
                                                logMutasis.add (new logMutasi(nomorRekening2, infoMutasi));
                
                                                System.out.println ("Transfer berhasil");
                                            } else {
                                                System.out.println("Saldo tidak mencukupi");
                                            }
                                        }
                                    }
                                    j++;
                                }
                                if (ditemukan2 == false) {
                                    System.out.println ("Rekening penerima salah");
                                }
                            } else {
                                System.out.println ("PIN Salah");
                                break;
                            }
                        }
                        if (ditemukan) {
                            break;
                        }
                        i++;
                    }
                    if (ditemukan == false) {
                        System.out.println("Rekening yang dimasukkan salah");
                    }
                    break;

                case 5 :
                    bersihkanLayar();
                    cetakNasabah(data);
                    break;

                case 6 :
                    break;

                default:
                    continue;
            }
            System.out.print("Apakan anda ingin kembali ke menu utama? (y/n) : ");
            yn = input.next();
            if (yn.equalsIgnoreCase("n")) {
                System.out.println("Terima kasih");
            }
        } while (yn.equalsIgnoreCase("y"));
        
    }

    public static void cetakMenu ()
    {
        System.out.println("----------------");
        System.out.println("Aplikasi Banking");
        System.out.println("----------------");
        System.out.println("1. Tambah Nasabah Baru");
        System.out.println("2. Setor Uang");
        System.out.println("3. Cetak Mutasi");
        System.out.println("4. Transfer Uang");
        System.out.println("5. Cetak Nasabah");
        System.out.println("6. Keluar");
        System.out.print("Masukkan Pilihan Anda : ");
    }

    public static void cetakNasabah (ArrayList<Nasabah> data)
    {
        System.out.println("No Rek\t\t| Nama\t\t| Saldo\t\t| No Kartu\t\t| Pin\t\t| Tanggal Daftar");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (Nasabah nsbhString : data) {
            System.out.println(nsbhString);
        }
    }

    public static ArrayList <Nasabah> init (ArrayList<Nasabah> data)
    {
        data.add (new Nasabah("03081210001", "Andi", 10000, "0001 0002 00003 0001", "000001"));
        data.add (new Nasabah("03081210002", "Budi", 20000, "0001 0002 00003 0002", "000002"));
        data.add (new Nasabah("03081210003", "Citra", 30000, "0001 0002 00003 0003", "000003"));
        return data;
    }

    public static void bersihkanLayar(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
