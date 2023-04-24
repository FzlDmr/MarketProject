import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Market extends Urunler{
    List<String> secilenUrunlerList = new ArrayList<>();
    List<Urunler> urunlerList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    int secim;
    String urun;
    double kilo;
    String cevap;
    double fiyat;
    double ucret;
    double toplamUcret=0;

    protected void urunEkleme() {

        Urunler domates = new Urunler("00", "Domates", 2.10);
        Urunler patates = new Urunler("01", "Patates", 3.20);
        Urunler biber = new Urunler("02", "Biber  ", 1.50);
        Urunler sogan = new Urunler("03", "Sogan  ", 2.30);
        Urunler havuc = new Urunler("04", "Havuc  ", 3.10);
        Urunler elma = new Urunler("05", "Elma   ", 1.20);
        Urunler muz = new Urunler("06","Muz    ", 1.90);
        Urunler cilek = new Urunler("07", "Cilek  ", 6.10);
        Urunler kavun = new Urunler("08", "Kavun  ", 4.30);
        Urunler uzum = new Urunler("09","Uzum   ", 2.70);
        Urunler limon = new Urunler("10", "Limon  ", 0.50);


        urunlerList.add(domates);
        urunlerList.add(patates);
        urunlerList.add(biber);
        urunlerList.add(sogan);
        urunlerList.add(havuc);
        urunlerList.add(elma);
        urunlerList.add(muz);
        urunlerList.add(cilek);
        urunlerList.add(kavun);
        urunlerList.add(uzum);
        urunlerList.add(limon);

        alisverisBaslangic();
    }
    protected void alisverisBaslangic(){

        do {

            for (Urunler urun : urunlerList) {//Burada toString() ve for dongusu ile tum objelerimizi ekrana yazdirdik
                System.out.println( urun + "  ");
            }

            System.out.println("Lutfen Secmek Istediginiz Urunun Numarasini Giriniz");

                secim = scan.nextInt();
                //System.out.println();

            if (secim < 0 || secim > 10) {
                System.out.println("Hatali Secim! Lutfen 0 ile 10 arasinda bir deger girin.");
                continue; // Döngünün başına dön
            }


                urun = urunlerList.get(secim).getName();//kullanicinin girdigi urunun adini getName() ile aldik
                fiyat = urunlerList.get(secim).getPrice();//kullanicinin girdigi urunun fiyatini getPrice() ile aldik

                System.out.println(urun +"Urununu  Sectiniz\nKac Kilogram Almak Istersiniz");
                kilo = scan.nextDouble();
                ucret = fiyat*kilo;
                toplamUcret+=ucret;

                secilenUrunlerList.add(urunlerList.get(secim).getName());//kullanicinin sectigi urunun ismini Listeye ekledik
                System.out.println("Sepetinizde Bulunan Urunler\n"+secilenUrunlerList);
                alisverisKontrol();


        }while(true);

    }

    protected void alisverisKontrol() {

        System.out.println("Alisverise Devam Etmek Ister Misiniz?");
        cevap = scan.next();
        if(cevap.equalsIgnoreCase("evet")){
               alisverisBaslangic();
        } else if (cevap.equalsIgnoreCase("hayir")) {
            odeme();
        }else{
            System.out.println("Hatali Giris Yaptiniz. Lutfen Tekrar Giriniz.");
            alisverisKontrol();
        }

    }

    protected void odeme(){

        double odenenTutar;
        double paraUstu;
        System.out.println("Odemeniz Gereken Toplam Tutar: "+ toplamUcret);
        System.out.println("Odeyeceginiz Tutari Giriniz: ");
        odenenTutar = scan.nextDouble();
        if (odenenTutar<toplamUcret){
            System.out.println("Odemeniz Gereken Tutar Toplam Tutar Kadar veya Toplam Tutardan Fazla Olmalidir");
            odeme();
        }
        paraUstu = odenenTutar-toplamUcret;
        System.out.println("Para Ustunuz "+paraUstu + " TL Iyi Gunler.");
        System.exit(0);
    }


}
