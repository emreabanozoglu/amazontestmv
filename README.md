# Amazon Test MV

## Getting Started


*Projede TestNG'nin default report'u kullanılmıştır. Eğer Intelij IDEA kullanıyorsanız raporların üretilmesi için Run/Debug Configuraitons üzerinden TestNG bölümündeki Configuration sekmesi üzerindeki Listeners sekmesinden "Use default reports" seçeneğinin işaretlenmesi gerekmektedir.

*Proje default olarak paralel execution yapılacak şekilde ayarlanmıştır. Windows işletim sisteminde browserların ayağa kalkabilmesi için "chromedriver.exe" ve "geckodriver.exe" dosyalarının System Variables üzerinde tanımlı olması gerekmektedir.

*Failure durumunda screenshot dosyaları proje dosyalarının bulunduğu dizin içerisinde ../screenshots klasöründe tutulur.

*Tüm testler tamamlandıktan sonra raporlar proje dosyalarının bulunduğu dizin içerisinde ../test-output klasöründe tutulur.

## Running the tests

Proje klonlandıktan sonra testlerin başlatılması testng.xml dosyası run edilmelidir.

## Built With

[MAVEN](https://maven.apache.org/) - Project Structure.
[TESTNG](https://testng.org/) - Unit test framework.

## Authors
* **Emre Abanozoğlu**  [emreabanozoglu](https://github.com/emreabanozoglu)
