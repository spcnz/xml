<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xs="http://www.w3.org/2001/XMLSchema"
                exclude-result-prefixes="xs"
                version="2.0"
                xmlns:za="http://www.zalbacutanje.com"
                xmlns:sh="http://www.shared.com">

    <xsl:variable name="space" select="'&#xA0;'"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>ЖАЛБА</title>
                <style>
                    .ssdpage {position:relative; border:solid 1pt black; margin:10pt auto 10pt auto; overflow:hidden;}
                    .ssddiv {position:absolute;  letter-spacing:0.05pt }
                    .ssdspan {position:absolute; white-space:pre;}
                    .ssdimg {position:absolute;}
                    .ssdsvg {position:absolute;}
                    .cs1 { font:10pt 'Times New Roman'; color:#000000; font-weight:bold;}
                    .cs2 { font:10pt 'Times New Roman'; color:#000000;}
                    .cs3 { font:11pt 'Times New Roman'; color:#000000; font-weight:bold;}
                    .cs4 { font:12pt 'Times New Roman'; color:#000000; font-weight:bold;}
                    .cs5 { font:12pt 'Times New Roman'; color:#000000;}
                    .cs6 { font:11pt 'Times New Roman'; color:#000000;}
                    .heading-font { font:10pt 'Times New Roman'; color:#000000; font-weight:bold; letter-spacing:0.05pt}

                    .underline{
                    border-bottom: 1px dotted;
                    width: 100%;
                    display: block;
                    }
                </style>
            </head>
            <body>
                <div class="ssdpage" style="width:612pt; height:792pt; text-align: justify;" >
                    <div class="ssddiv" style="left:100.2pt; top: 70px;tЖАЛБА op:71.95pt" >
                        <div class="heading heading-font">ЖАЛБА КАДА ОРГАН ВЛАСТИ <u>НИЈЕ ПОСТУПИО/ није поступио у целости/ ПО ЗАХТЕВУ</u>
                            <div class="ssddiv" style="left: 100px">ТРАЖИОЦА У ЗАКОНСКОМ РОКУ (ЋУТАЊЕ УПРАВЕ)</div>
                        </div>
                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" width="568" height="19" class="ssdsvg" ><defs /><g transform="scale(1.33333)"><g transform="matrix(1,0,0,1,-92.7839965820313,-108.81689453125)"><path d="M92.7839965820313,108.81689453125 L92.7839965820313,122.56689453125 L518.623901367188,122.56689453125 L518.623901367188,108.81689453125" fill="none" /></g></g></svg></div>
                    <div class="ssddiv" style="left:92.75pt; top:108.6pt;"><span class="ssdspan cs4" style="left:0pt"> <xsl:value-of select="za:ZalbaCutanjeRoot/za:zalbaCutanje/za:primaoc/sh:Uloga"/></span></div>
                    <div class="ssddiv" style="left:90pt; top:123.3pt;"><span class="ssdspan cs6" style="left:0pt; letter-spacing:-0.05pt">Адреса за пошту: <xsl:value-of select="za:ZalbaCutanjeRoot/za:zalbaCutanje//sh:Adresa/sh:Grad"/>, <xsl:value-of select="za:ZalbaCutanjeRoot/za:zalbaCutanje//sh:Adresa/sh:Ulica"/>, бр. <xsl:value-of select="za:ZalbaCutanjeRoot/za:zalbaCutanje//sh:Adresa/sh:Broj"/>, <xsl:value-of select="za:ZalbaCutanjeRoot/za:zalbaCutanje//sh:Adresa/sh:Postanski_broj"/></span></div>
                    <div class="ssddiv" style="left:25pt; top:140.3pt;">
                        <span class="ssdspan cs5" style="left:0pt; letter-spacing:-0.05pt">
                            У складу са чланом 22. Закона о слободном приступу информацијама од јавног значаја
                            подносим:

                        </span>
                    </div>

                    <div class="ssddiv" style="left:292.85pt; top:186.7pt;"><span class="ssdspan cs3" style="left:0pt; letter-spacing:0.05pt">Ж А Л Б У
                        <span class="ssdspan cs5" style="left:4pt; letter-spacing:-0.05pt">против</span>
                    </span>
                    </div>

                    <div class="ssddiv" style="left:90.85pt; top:230.7pt; width: 600px; ">
                        <span class="ssdspan underline"><xsl:value-of select="//za:naziv_organa"/></span>
                    </div>

                    <div class="ssddiv" style="left:250.85pt; top:250.7pt;">
                        због тога што орган власти:
                        <div class="cs4">
                            <span class="underline" style="text-align: center;"><xsl:value-of select="//za:razlog"/></span>
                        </div>
                    </div>

                    <div class="ssddiv" style="left:25pt; top:290.3pt;">
                        <span class="ssdspan cs5" style="left:0pt; letter-spacing:-0.05pt; line-height: 1.6;">
                            по мом захтеву за слободан приступ информацијама од јавног значаја који сам поднео том
                            органу дана <u><xsl:value-of select="//za:sadrzaj//za:datum"/></u> године, а којим сам тражио/ла да ми се у складу са Законом о
                            слободном приступу информацијама од јавног значаја омогући увид- копија документа који
                            садржи информације о /у вези са :
                        </span>
                    </div>

                    <div class="ssddiv" style="left:90.85pt; top:400.7pt; width: 600px">
                        <span class="underline"><xsl:value-of select="//za:sadrzaj//za:podaci_o_zahtevu"/></span>
                    </div>


                    <div class="ssddiv" style="left:25pt; top:450.3pt;">
                        <span class="ssdspan cs5" style="left:0pt; letter-spacing:-0.05pt; line-height: 1.6;">
                            На основу изнетог, предлажем да Повереник уважи моју жалбу и омогући ми приступ
                            траженој/им информацији/ма
                            Као доказ , уз жалбу достављам копију захтева са доказом о предаји органу власти.
                            <b>Напомена:</b> Код жалбе због непоступању по захтеву у целости, треба приложити и
                            добијени одговор органа власти.
                        </span>
                    </div>

                    <div class="ssddiv" style="left:280pt; top:550.3pt; text-align: right;">
                        <span class="ssdspan cs5" style="left:0pt; letter-spacing:-0.05pt; line-height: 1.6;">
                            <u><xsl:value-of select="//za:sadrzaj//za:podnosilac_zalbe/sh:Ime"/>&#x0020;<xsl:value-of select="//za:sadrzaj//za:podnosilac_zalbe/sh:Prezime"/></u>
                            Подносилац жалбе / Име и презиме
                            ............................
                            потпис
                            <u><xsl:value-of select="//za:sadrzaj//za:podnosilac_zalbe//sh:Adresa/sh:Grad"/>,  <xsl:value-of select="//za:sadrzaj//za:podnosilac_zalbe//sh:Adresa/sh:Ulica"/>, бр. <xsl:value-of select="//za:sadrzaj//za:podnosilac_zalbe//sh:Adresa/sh:Broj"/>, <xsl:value-of select="//za:sadrzaj//za:podnosilac_zalbe//sh:Adresa/sh:Postanski_broj"/></u>
                            адреса
                            <u><xsl:value-of select="//za:sadrzaj//za:podnosilac_zalbe//sh:drugi_podaci_za_kontakt"/></u>
                            други подаци за контакт
                        </span>
                    </div>

                    <div class="ssddiv" style="left:25pt; top:690.3pt;">
                        <span class="ssdspan cs5" style="left:0pt; letter-spacing:-0.05pt; line-height: 1.6;">
                            У <u><xsl:value-of select="za:ZalbaCutanjeRoot/za:zalbaCutanje//sh:Adresa/sh:Grad"/></u>, дана <u><xsl:value-of select="//za:sadrzaj//za:datum_vreme//sh:datum"/></u> године
                        </span>
                    </div>

                </div>
        </body>
    </html>
    </xsl:template>

</xsl:stylesheet>