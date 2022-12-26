import java.util.Scanner;

public class inventory_Fitri{
    static Scanner s = new Scanner(System.in);
    static String jenis[] = { "Tomat\t", "Kangkung\t", "Bawang Putih", "Bawang Merah", "Cabai\t", "Apel\t", "Pisang\t", "Alpukat\t", "Jeruk\t", "Jambu\t" };
    static int nomer[] = {1,2,3,4,5,6,7,8,9,10};
    static int jLayak[] = {20, 35, 16, 12, 50, 10, 12, 11, 11, 10 };
    static int jEx[] = {8, 10, 4, 5, 22, 4, 2, 3, 2, 2 };
    static String kode[] = {"A31", "A25", "A13", "A12", "A77" ,"B55", "B32", "B87", "B02", "B10" };
    static int input[] = new int[10];
    static int input2[] = new int[10];
    static int totInput[]=new int[10];
    static int output[] = new int[10];
    static int totin[] = new int[10];
    static int totout[] = new int[10];
    static int tot[] = new int[10];
    static int totKurang = 0, totTambah = 0, totLayak = 0, totBusuk = 0, totTerbuang = 0, totSeluruh = 0;
    static String jabatan []={"SV","ST"};
    static String kunci[] = { "Fitri", "12345" };
    static String yes, nama, pass, nm;
    public static void main(String args[]) {
        System.out.print("\t\t\t\t\t\t\t\tMasukkan ussername : ");
        nama = s.nextLine();
        System.out.print("\t\t\t\t\t\t\t\tMasukkan password : ");
        pass = s.nextLine();
        if (nama.equalsIgnoreCase(kunci[0]) && pass.equalsIgnoreCase(kunci[1])) {
            System.out.println("\t\t\t\t\t\t─────────────────────────────────────────────────────────────");
            System.out.println("\t\t\t\t\t\t               Welcome to Storage Raw Material");
            System.out.println("\t\t\t\t\t\t─────────────────────────────────────────────────────────────");
            menu();
        } else {
            System.out.print("\t\t\t\t\t\t\tMaaf Ussername atau Password anda salah!" + "\n");
            main(args);
        }
    }
    static void logout() {
        s.nextLine();
        System.out.print("Apakah anda yakin ingin logout? (yes/no) : ");
        yes = s.nextLine();
        if (yes.equalsIgnoreCase("yes")) {
            System.out.println("Terimakasih!");
        } else {
            menu();
        }
    }

    static void menu() {
        System.out.println(
                "=============\t      ===============\t      ===============\t      ==================\t================\t================\t===============");
        System.out.println(
                "|  1. Stok  |\t      |2.Tambah Bahan|\t      |3.Pengambilan|\t      |    4. Search   |\t|  5. Laporan  |   \t| 6.My Account |\t|  7.Logout   |");
        System.out.println(
                "=============\t      ===============\t      ===============\t      ==================\t================\t================\t===============");
        System.out.print("\t\t\t\t\t\tSilahkan Pilih Menu : ");
        int mn;
        mn = s.nextInt();
        switch (mn) {
            case 1:
                pilihan();
                break;
            case 2:
                tambah();
                break;
            case 3:
                kurang();
                break;
            case 4:
                cari();
                break;
            case 5:
                laporan();
                break;
            case 6:
                account();
                break;
            case 7:
                logout();
                break;
            default:
                System.out.println("\t\t\t\t\t   ***Menu tidak terdaftar***");
                menu();
                break;
            }
        }
        static void pilihan() {
            System.out.println(" _________________________________________________________________________________");
            System.out.println("|             \t\t\tList Bahan-bahan\t\t\t\t  |");
            System.out.println("|_________________________________________________________________________________|");
            System.out.print("|No|Pilihan\t\t\t   Jumlah layak\t    Jumlah Busuk\tTotal     |");
            System.out.println("\n|_________________________________________________________________________________|");
            for (int i = 0; i < kode.length; i++) {
                    tot[i] = jLayak[i] + jEx[i];
                    System.out.printf("|%s|%s\t\t\t%s\t\t%s\t\t%s\t  |", kode[i], jenis[i], jLayak[i], jEx[i],  tot[i]);
                    System.out.println();
                
            }
            System.out.println("|_________________________________________________________________________________|");
            back2();
        }
    
        static void tambah() {
            s.nextLine();
            System.out.print("Input bahan yang akan ditambah : ");
           nm = s.nextLine();
           for (int i=0; i<jenis.length; i++){
            if(nm.equalsIgnoreCase(jenis[i])){
                System.out.println("Bahan ke "+nomer[i]+" yaitu bahan "+jenis[i]);
                System.out.print("Tambahan sebelum di cek yaitu : ");
                input[i] = s.nextInt();
                tot[i] += input[i];
                totin[i] += input[i];
                System.out.print("Bahan yang layak  : ");
                input2[i] = s.nextInt();
                jLayak[i] += input2[i];
                totInput[i] = input[i]-input2[i];
                jEx[i] += totInput[i];
                System.out.println("Bahan yang exp  : "+totInput[i]);
                
            }
        }
        back3();   
    }
        static void kurang() {
            s.nextLine();
            System.out.print("Input bahan yang akan diambil : ");
            nm = s.nextLine();
            for (int i=0; i<jenis.length; i++){
             if(nm.equalsIgnoreCase(jenis[i])){
                 System.out.println("Bahan ke "+nomer[i]+" yaitu bahan "+jenis[i]);
                 System.out.print("Bahan yang diambil sebanyak : ");
                 output[i] = s.nextInt();
                    jLayak[i] -= output[i];
                    tot[i] -= output[i];
                    totout[i] += output[i];
                }
            }
           back4();
        }
    
    static void up() {
        System.out.println(
                " ______________________________________________________________________________________________________________________________________________________");
        System.out.println("|             \t\t\t\t\t\t\t\tList Bahan-Bahan\t\t\t\t\t\t\t      |");
        System.out.println(
                "|_____________________________________________________________________________________________________________________________________________________|");
        System.out.println("|No|Pilihan\t\t\t   Jumlah layak\t\tJumlah Busuk\t\tPenambahan\t\tPemakaian\t\tTerbuang\t Total|");
        System.out.println(
                "|_____________________________________________________________________________________________________________________________________________________|");
        for (int i = 0; i < kode.length; i++) {
                tot[i]= jLayak[i] + jEx[i];
                System.out.printf("|%s|%s\t\t\t%s\t\t     %s\t\t\t     %s\t\t            %s\t\t\t   %s\t\t   %s |",
                        kode[i], jenis[i], jLayak[i], jEx[i], totin[i], totout[i],jEx[i], tot[i]);
                System.out.println();
            
        }
        System.out.println(
                "|_____________________________________________________________________________________________________________________________________________________|");
        back2();
    }
         
    static void cari() {
    
        for (int i = 0; i<jenis.length; i++){
           System.out.println((nomer[i])+". Bahan "+jenis[i]);
        }
       System.out.println();
       s.nextLine();
       System.out.print("Input bahan yang akan dicari: ");
       nm = s.nextLine();
       for (int i=0; i<jenis.length; i++){
        if(nm.equalsIgnoreCase(jenis[i])){
            System.out.println("Bahan ke "+nomer[i]+" yaitu bahan "+jenis[i]);
            System.out.println("Bahan layak pakai\t: "+jLayak[i]);
            System.out.println("Bahan busuk/exp\t\t: "+jEx[i]);
            System.out.println("Penambahan bahan\t: "+totin[i]);
            System.out.println("Pemakaian bahan\t: "+totout[i]);
        }
    }
       System.out.println();
       back1();
    }

    static void laporan() {
        int awal = 0,totAwal=0;
        System.out.println("\t\t\t\tLaporan Akhir Penyediaan Bahan Sayuran dan Buah-buahan");
        System.out.println(
                " _______________________________________________________________________________________________________________________________");
        System.out.println("|            \t\t\t\t\t\tList Bahan-Bahan\t\t\t\t\t\t\t|");
        System.out.println(
                "|_______________________________________________________________________________________________________________________________|");
        System.out.println(
                "|No|Pilihan\t\tJumlah layak\tJumlah Busuk\tPenambahan\tPemakaian\tTerbuang\tTotal Awal\tTotal\t|");
        System.out.println(
                "|_______________________________________________________________________________________________________________________________|");
        for (int i = 0; i < kode.length; i++) {
                tot[i] = jLayak[i] + jEx[i];
                awal = tot[i] - totin[i] + totout[i];
                System.out.printf(
                        "|%s|%s\t   %s\t\t     %s\t\t     %s\t\t     %s\t\t    %s\t\t %s\t\t%s\t|",
                        kode[i], jenis[i], jLayak[i], jEx[i], totin[i], totout[i],jEx[i], awal, tot[i]);
                System.out.println();   
        }
        System.out.println(
                "|_______________________________________________________________________________________________________________________________|");
        for (int i = 0; i < kode.length; i++) {
                totTambah += totin[i];
                totKurang += totout[i];
                totLayak += jLayak[i];
                totBusuk += jEx[i];
                totTerbuang += jEx[i];
                totAwal += tot[i] - totin[i] + totout[i];
                totSeluruh += tot[i];
            
        }
        System.out.println("Total bahan baik : " + totLayak);
        System.out.println("Total bahan busuk : " + totBusuk);
        System.out.println("Total penambahan : " + totTambah);
        System.out.println("Total pemakaian : " + totKurang);
        System.out.println("Total bahan terbuang : "+totTerbuang);
        System.out.println("Total awal : " + totAwal);
        System.out.println("Total Keseluruhan Akhir : " + totSeluruh);
        back2();
    }

    static void account() {
        Scanner s = new Scanner(System.in);
        int bulan;
        String namaDepan, namaBelakang, kodeId, idCard;
        double penghasilan, gaji, bonus;
        System.out.println();
        System.out.println("\t-------------------------------------------------------------");
        System.out.println("\t\t\t\tMasukkan Data Anda");
        System.out.println("\t-------------------------------------------------------------");
        System.out.println();
        System.out.print("\tIsi inisial ID CARD\t: ");
        kodeId = s.nextLine();

        if (kodeId.equalsIgnoreCase(jabatan[0])) {
            System.out.print("\tMasukkan Kode id card : ");
            idCard = s.nextLine();
            System.out.print("\tNama Depan\t\t: ");
            namaDepan = s.nextLine();
            System.out.print("\tNama Belakang\t\t: ");
            namaBelakang = s.nextLine();
            System.out.println("\t=====================================================");
            System.out.println("\t\t\t\tMy Account");
            System.out.println("\t=====================================================");
            System.out.println("\tNama Lengkap\t\t: " + namaDepan + " " + namaBelakang);
            System.out.println("\tID Card Anda : "+jabatan[0]+idCard);
            System.out.println("\tJabatan Anda Adalah Supervisor");
            System.out.print("\tMasukkan bulan\t\t: ");
            bulan = s.nextInt();
            System.out.print("\tMasukkan penghasilan : ");
            penghasilan = s.nextDouble();
            
            if (totKurang == 0) {
                bonus = 0.05;
                gaji = penghasilan + (bonus * penghasilan);
                System.out.printf("\tGaji Anda di bulan %s : %.3f\n",bulan,gaji);
            } else if (totKurang <= 10) {
                bonus = 0.2;
                gaji = penghasilan + (bonus * penghasilan);
                System.out.printf("\tGaji Anda di bulan %s : %.3f\n",bulan,gaji);
            } else if (totKurang <= 30) {
                bonus = 0.3;
                gaji = penghasilan + (bonus * penghasilan);
                System.out.printf("\tGaji Anda di bulan %s : %.3f\n",bulan,gaji);
            } else if (totKurang > 30) {
                bonus = 0.5;
                gaji = penghasilan + (bonus * penghasilan);
                System.out.printf("\tGaji Anda di bulan %s : %.3f\n",bulan,gaji);
            }
            System.out.println("\t========================================================================");
            back2();

        } else if (kodeId.equalsIgnoreCase(jabatan[1])) {
            System.out.print("\tMasukkan Kode id card : ");
            idCard = s.nextLine();
            System.out.print("\tNama Depan\t\t: ");
            namaDepan = s.nextLine();
            System.out.print("\tNama Belakang\t\t: ");
            namaBelakang = s.nextLine();
            System.out.println("\t=====================================================");
            System.out.println("\t\t\t\tMy Account");
            System.out.println("\t=====================================================");
            System.out.println("\tNama Lengkap\t\t: " + namaDepan + " " + namaBelakang);
            System.out.println("\tID Card Anda : "+jabatan[1]+idCard);
            System.out.println("\tJabatan Anda Adalah Staff");
            System.out.print("\tMasukkan bulan\t\t: ");
            bulan = s.nextInt();
            System.out.print("\tMasukkan penghasilan : ");
            penghasilan = s.nextDouble();

            if (totKurang == 0) {
                bonus = 0.01;
                gaji = penghasilan + (bonus * penghasilan);
                System.out.printf("\tGaji Anda di bulan %s : %.3f\n",bulan,gaji);
            } else if (totKurang <= 10) {
                bonus = 0.02;
                gaji = penghasilan + (bonus * penghasilan);
                System.out.printf("\tGaji Anda di bulan %s : %.3f\n",bulan,gaji);
            } else if (totKurang <= 30) {
                bonus = 0.03;
                gaji = penghasilan + (bonus * penghasilan);
                System.out.printf("\tGaji Anda di bulan %s : %.3f\n",bulan,gaji);
            } else if (totKurang > 30) {
                bonus = 0.05;
                gaji = penghasilan + (bonus * penghasilan);
                System.out.printf("\tGaji Anda di bulan %s : %.3f\n",bulan,gaji);
            }
            System.out.println("\t========================================================================");
            back2();
        } else {
            System.out.println("\tKode ID CARD yang anda input salah, coba lagi!");
            account();
        }
    }
    

    static void back1(){
        s.nextLine();
        System.out.print("Apakah Anda ingin kembali mencari? (yes/no) : ");
        yes = s.nextLine();
        if (yes.equalsIgnoreCase("yes")) {
            cari();
        } else {
            menu();
        }
    }
    static void back2() {
        s.nextLine();
        System.out.print("Apakah Anda ingin kembali ke menu? (yes/no) : ");
        yes = s.nextLine();
        if (yes.equalsIgnoreCase("yes")) {
            menu();
        } else {
           logout();
        }
    }
    static void back3(){
        s.nextLine();
        System.out.print("Apakah Anda ingin kembali menginput? (yes/no) : ");
        yes = s.nextLine();
        if (yes.equalsIgnoreCase("yes")) {
            tambah();
        } else {
            up();
        }
    }
    static void back4(){
        s.nextLine();
        System.out.print("Apakah Anda ingin kembali menginput? (yes/no) : ");
        yes = s.nextLine();
        if (yes.equalsIgnoreCase("yes")) {
            kurang();
        } else {
            up();
        }
    }
    
}