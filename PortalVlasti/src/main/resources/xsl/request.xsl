<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:za="http://www.zahtev.com"
                xmlns:sh="http://www.shared.com"
                xmlns:fo="http://www.w3.org/1999/XSL/Format"
                version="2.0">

    <xsl:template match="/">
        <html>
            <head>
                <title>Obavestenje</title>
                <style type="text/css">
                    html {
                    font-family: Times New Roman;
                    margin-top: 20px;
                    margin-bottom:20px;
                    }
                    p {
                    margin: 0%
                    }
                    hr {
                        display: block;
                        height: 1px;
                        border: 0;
                        border-top: 2px solid black;
                        padding: 0;
                    }
                    .underline{
                    border-bottom: 1px dotted;
                    width: 100%;
                    display: block;
                    }

                </style>
            </head>
            <body>
                <xsl:variable name="date" select="//za:sadrzaj/za:datum_vreme/sh:datum"/>
                <xsl:variable name="d1" select="concat(substring($date,9,2),'.',substring($date,6,2),'.',substring($date,1,4),'.')"/>
                <div style="width: 50%; padding-left:30%">
                    <p style="font-family:Times New Roman; font-size:18px; text-align:center">
                        <xsl:value-of select="za:ZahtevRoot//za:nadlezni_organ/za:naziv"/>
                        <xsl:value-of select="za:ZahtevRoot//za:nadlezni_organ/za:sediste"/>
                    </p>

                    <hr/>

                    <p style="font-family:Times New Roman; font-size:14px; text-align:center">
                        (назив и седиште органа коме се захтев упућује)
                    </p>

                    <h1 style="font-family:Times New Roman;  text-align:center;padding-top:50px">
                        З А Х Т Е В
                    </h1>

                    <h2 style="font-family:Times New Roman;text-align:center">
                        за приступ информацији од јавног значаја
                    </h2>

                    <p style="font-family:Times New Roman; font-size:15px; text-align:justify;padding-top:15px" >
                        На основу члана 15. ст. 1. Закона о слободном приступу информацијама од јавног значаја
                        („Службени гласник РС“, бр. 120/04, 54/07, 104/09 и 36/10), од горе наведеног органа захтевам:*
                    </p>
                    <div style="text-align: center">
                        <xsl:value-of select="//za:tip_zahteva" />
                    </div>


                    <div style="margin-left:65px" >
                        <p style="font-family:Times New Roman; font-size:13px;" >

                            <xsl:variable name="delivery" select="//za:nacini_dostave"></xsl:variable>
                            <xsl:if test="//za:nacini_dostave/za:POSTA">
                                поштом
                            </xsl:if>
                            <xsl:if test="//za:nacini_dostave/za:EMAIL">
                                електронском поштом
                            </xsl:if>
                            <xsl:if test="//za:nacini_dostave/za:FAKS">
                                факсом
                            </xsl:if>

                        </p>
                    </div>

                    <p style="font-family:Times New Roman; font-size:15px;padding-top:25px" >
                        Овај захтев се односи на следеће информације:
                    </p>

                    <p style="font-family:Times New Roman; font-size:20px;padding-top:5px;margin-left:10px;text-indent: 40px; margin-top:20px" class="underline">
                        <xsl:value-of select="//za:sadrzaj//za:opis_informacije"/>
                    </p>
                    <div>
                        (навести што прецизнији опис информације која се тражи као и друге податке који олакшавају проналажење тражене информације)
                    </div>

                    <div style="padding-top:20px">
                        <div style="width:45%;float:left">
                            <p style="font-family:Times New Roman;text-align:justify; font-size:15px;padding-top:15px;margin-left:10px">
                                У Beograd,
                            </p>
                            <p style="font-family:Times New Roman;text-align:justify; font-size:15px;padding-top:15px;margin-left:10px">
                                <xsl:value-of select="$d1"/> године.
                            </p>
                        </div>
                        <div style="font-family:Times New Roman;text-align:justify; font-size:15px;padding-top:15px;margin-left:10px;width:45%;float:right">
                            <p style="padding-top:10px" class="underline">
                                <xsl:value-of select="//za:trazilac_informacije/sh:Ime"/>        <xsl:value-of select="//za:trazilac_informacije/sh:Prezime"/>
                            </p>
                            (Тражилац информације/Име и презиме)
                            <p style="padding-top:10px" class="underline">
                                <xsl:value-of select="//za:trazilac_informacije//sh:Ulica"/>    <xsl:value-of select="//za:trazilac_informacije//sh:Broj"/> ,  <xsl:value-of select="//za:trazilac_informacije//sh:Grad"/>,  <xsl:value-of select="//za:trazilac_informacije//sh:Postanski_broj"/>
                            </p>
                            (адреса)
                            <p style="padding-top:10px" class="underline">
                                <xsl:value-of select="//za:trazilac_informacije//sh:drugi_podaci_za_kontakt"/>
                            </p>
                            (други подаци за контакт)
                            <p style="padding-top:10px">
                                _______________________
                            </p>
                            <p>
                                Потпис
                            </p>

                        </div>
                    </div>

                    <div style="padding-top:200px;">
                        <p>
                            ________________________________________________________________
                        </p>
                        <p font-family="Times New Roman" font-size="9px">
                            * У кућици означити која законска права на приступ информацијама желите да остварите.
                        </p>
                        <p font-family="Times New Roman" font-size="9px">
                            ** У кућици означити начин достављања копије докумената.
                        </p>
                        <p font-family="Times New Roman" font-size="9px">
                            *** Када захтевате други начин достављања обавезно уписати који начин достављања захтевате.
                        </p>
                    </div>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>