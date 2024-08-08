# Türkçe Doğal Dil İşleme Yarışması <br> Serbest Kategori - TEKNOFEST

![Static Badge](https://img.shields.io/badge/java-21.0.6-red?style=flat-square)
&nbsp; &nbsp; ![Static Badge](https://img.shields.io/badge/node-v20.12.0-red?style=flat&logo=nodedotjs&logoColor=green)
&nbsp; &nbsp; ![Static Badge](https://img.shields.io/badge/npm-v10.5.1-red?style=flat&logo=npm)
&nbsp; &nbsp; ![Static Badge](https://img.shields.io/badge/apache%20maven%20wrapper-3.6.3-red?style=flat-square&logo=apachemaven&logoColor=blue&labelColor=%23fffdd0&color=blue)
&nbsp; &nbsp; ![Static Badge](https://img.shields.io/badge/spring-3.3.2-red?style=flat-square&logo=spring&labelColor=white&color=green)

## **Proje Hakkında** 
>Bu proje, kullanıcıdan alınan bir başlangıç URL'si üzerinden başlayarak web scraping ile ilgili işlemleri gerçekleştirir. Başlangıç URL'si içinde bulunan diğer URL'leri tespit eder ve belirli bir domain ile aynı uzantıya sahip olanları filtreler. Ardından bu URL'leri ziyaret ederek sayfa içeriğini HTML olarak alır ve bu HTML kodlarını parse ederek metin haline getirir. Elde edilen metin verilerini Zemberek, Morphology ve normalizasyon gibi doğal dil işleme tekniklerini kullanan bir API'ye gönderir. API'den gelen dil işleme sonuçlarını kullanarak öneriler elde edilir.
### Takım Hakkında
> Takım Adı: Vanitas <br>
> Takım Id: 561863 <br>
> Takım Kaptanı: Osman Batur Arpacık <br>
> Takım Üyesi: Yunus Öz <br>
> <a href="#contact" class="button">İletişim</a>

## Kullanılan Teknolojiler
[![Static Badge](https://img.shields.io/badge/Java%20Spring---?style=for-the-badge&logo=spring&labelColor=white)](https://spring.io/)
&nbsp; &nbsp; &nbsp;
 [![Static Badge](https://img.shields.io/badge/react---?style=for-the-badge&logo=react&labelColor=white&color=lightblue)](https://react.dev/)

## Doğal Dil İşleme Kütüphanesi
> [ZEMBEREK](https://github.com/ahmetaa/zemberek-nlp)

## Kullanılan Açık Kaynak Veri Seti
> [479k English Words](https://www.kaggle.com/datasets/yk1598/479k-english-words)


## Kurulması Gereken Bağımlılıklar
>java 21.0.6 <br>
>apache maven wrapper 3.6.3 <br>
>node v20.12.0 <br>
>npm 10.5.1 <br>
>[]()

## Kullanım
##### 1. Clone this repository
>  ```sh
>    //open cmd
>    
>    cd /d C:\
>    
>    mkdir vanitas
>    
>    cd vanitas
>    
>    git clone https://github.com/OsmanBaturArpacik/2024-Turkce-Dogal-Dil--sleme-Yarismasi-Serbest-Kategori.git
>
>    cd 2024-Turkce-Dogal-Dil--sleme-Yarismasi-Serbest-Kategori
>    
>  ```
>
>
##### 2. Build, Install & Run
>  ```sh
> 
>    cd backend/nlp
>
>    ./mvnw clean package
> 
>    ./mvnw spring-boot:run 
>  
>    cd ../../
>
>    cd frontend/vanitas-front
>
>    npm install
>  
>    npm run build
>  
>    npm start
>  
>  ```
>
#### Video: [Demo](https://www.loom.com/share/e7c3333469954d19a1173b0c89af56c0?sid=5b1c166a-e229-4385-96c8-f3ff6c482a8c)
#### Sunum: [Sunum Linki](https://drive.google.com/drive/folders/1UT_ykWNRKOLNeRctnxrqjUZTQYbKiU0e?usp=sharing)
<div id="contact">
    <h2>İletişim</h2>

>&nbsp;[![Static Badge](https://img.shields.io/badge/Osman%20Batur%20Arpac%C4%B1k---?style=social&logo=linkedin&labelColor=white&color=lightblue)](https://www.linkedin.com/in/osman-batur-arpacik/)
>&nbsp;[![Static Badge](https://img.shields.io/badge/OsmanBaturArpacik---?style=social&logo=github&labelColor=white&color=lightblue)](https://github.com/OsmanBaturArpacik)
>&nbsp;[![Static Badge](https://img.shields.io/badge/osmanbatur%40outlook.com---?style=social&logo=gmail&logoColor=black&labelColor=white&color=lightblue)](mailto:osmanbatur@outlook.com)
>
>&nbsp;[![Static Badge](https://img.shields.io/badge/Yunus%20Oz---?style=social&logo=linkedin&labelColor=white&color=lightblue)](https://www.linkedin.com/in/yunus-oz-90326169/)
>&nbsp;[![Static Badge](https://img.shields.io/badge/YunusOz---?style=social&logo=github&labelColor=white&color=lightblue)](https://github.com/ozyunus)
>&nbsp;[![Static Badge](https://img.shields.io/badge/ozyunus%40msn.com---?style=social&logo=gmail&logoColor=black&labelColor=white&color=lightblue)](mailto:ozyunus@msn.com)
</div>
