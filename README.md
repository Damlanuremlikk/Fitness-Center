# Fitness-Center

## Project Purpose
Projemizin amacı hedef kitlemiz olan tüm personel ve müşterilere kendilerine özgü işlemleri yapma imkanı  sunmaktır*
### Summary
*Projemiz Fitness merkezindeki tüm çalışanların ve müşterilerin bilgilerini işleyerek ve Fitness merkezi içerisindeki bölüm, oda ve gerekli ekipmanların hepsini kayıt altına tutarak Fitness merkezimizin işleyişini düzene sokmayı amaçlar. Fitness merkezimizin içerisinde genel müdür, müdür, eğitmen, kayıtçı ve temizlikçi ve müşteriler(Gold,Ekonomik,Standart) bulunmaktadır. Her bir çalışan ve müşteri için alanına göre farklı id ler atanmakta ve farklı görevlere erişim sağlayabilmektedirler. Örneğin Genel müdürün şube silme yetkisi olması ve aynı zamanda müdürün yapabileceği tüm işlere yetkisi olması gibi veya genel müdürümüzün çalışan ekleme çıkarma yetkisi olduğu gibi vb. Programımızda giriş yaptığı kişiye göre yapabileceği işlemleri önüne getirebilmesi için giriş ekranı mevcuttur*
![uml](https://user-images.githubusercontent.com/76573894/161192584-69a7e41b-0e5f-48ec-bf11-ad364c15cc12.jpg)
#### s
*Programı IntroScreen classını çalıştırarak başlattığınızda konsola birtakım yazılar çıkar ve sonra kullanıcıdan ID ve şifresini isteyen bir do-while döngüsüne girer. While ın içine boolean bir değer döndüren userLogin metodu koyulmuştur. Bu metod kullanıcının girdiği ID ilk önce Workers.txt dosyasında, daha sonra Customers.txt dosyasında satır satır okuyarak arar. Ne zaman bir id eşleşmesi yakalarsa, aynı satırdaki password bilgisi ile kullanıcının girdiği password ü karşılaştırır. Eğer password:
   doğru ise True döner döngüden çıkar. 
   yanlış ise False döner ekrana şifrenin yanlış olduğunu yazdırır ve döngü devam eder.
Eğer hiç id bulamazsa False döner ve id nin bulanamadığını ekrana yazdırır connectUser metodu bizden bir ID ister ve verilen ID bilgisine göre ne tür bir çalışan veya ne tür bir müşteri olduğunu seçer ve o tipte bir nesne oluşturur. *
```
int userID;
        do {
            System.out.println("UserID:");
            userID = scan.nextInt();
            System.out.println("Password:");
            password = scan.next();
        } while(!userLogin(userID, password));

        Person user = connectUser(userID);
        user.setId(userID);
        PrintStream var10000 = System.out;
        String var10001 = user.getName();
        var10000.println("Wellcome " + var10001 + " " + user.getSurname());
        int var4 = user.getId();
        takeLog(var4 + " [" + user.getName() + " " + user.getSurname() + "] Logged in...");

        while(user.screen(user)) {
        }

    }

```
*Person Class ındaki createId fonksiyonu bizden bir dosya ve bir tam sayi(userID) istemektedir. Bu argumanlar kullanıcının dolduracağı değerler değildir,   kullanıcının kullanabileceği metotlarda, doldurulmuş şekilde yazılıdır. add registerer dediği zaman Workers.txt dosyasındaki 13000000 ile 1400000 arasındaki en yüksek id yi bulur, bir fazlasını değer olarak döndürür. Kullanıcı add customer dediği zaman, (girilen customerType a göre, örneğin Gold) Customers.txt dosyasındaki 21000000 ile 22000000 arasındaki en yüksek id yi bulur ve bir fazlasını döndürür*
```
 public int createId(File file,int userID){
        try {
            Scanner reader=new Scanner(file);
            String line;
            String[] linesp;
            int id=userID;
            while (reader.hasNext()) {
                line=reader.nextLine();
                linesp=line.split("   ");
                if(Integer.parseInt(linesp[0])<(userID+999998)){
                    if(id<=Integer.parseInt(linesp[0])){                //buraya kucuktur yazmadığım için biraz sıkıntı olmuştu
                        id=(Integer.parseInt(linesp[0])+1);
                    }
                }
            }
            reader.close();
            return id;
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return -1;
        }
    }
```

