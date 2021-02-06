<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:ob="http://www.obavestenje.com"
                xmlns:sh="http://www.shared.com"
                version="2.0">

    <xsl:template match="/">
        <html>
            <head>
                <title>Obavestenje</title>
                <style type="text/css">
                    html {
                    font-family: Times New Roman;
                    letter-spacing:0.05pt;
                    font: 12pt;
                    }
                    p {
                    margin: 0%
                    }

                    .underline{
                    border-bottom: 1px dotted;
                    width: 100%;
                    display: block;
                    }
                </style>
            </head>
            <body>
                <xsl:variable name="space" select="'&#xA0;'"/>
                <xsl:variable name="date" select="/ob:ObavestenjeRoot/ob:Obavestenje/ob:Datum"/>
                <xsl:variable name="d1" select="concat(substring($date,9,2),'.',substring($date,6,2),'.',substring($date,1,4),'.')"/>

                <div style="width: 60%; padding-left:20%; margin: 30px;" >
                    <div style="width:40%; margin-bottom:10px">
                    <p font-family="Times New Roman" font-size="16px" >
                        <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje/ob:Organ/ob:Naziv"/>
                    </p>
                    <p style="font-size:16px" class="underline">

                        <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje/ob:Organ/sh:Adresa/sh:Ulica"/>, <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje/ob:Organ/sh:Adresa/sh:Broj"/>, <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje/ob:Organ/sh:Adresa/sh:Grad"/>, <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje/ob:Organ/sh:Adresa/sh:Postanski_broj"/>

                    </p>
                    (назив и седиште органа)
                </div>
                <div>
                    <p style="font-size:16px" >
                        Број предмета: <u><xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje/ob:Broj_predmeta"/></u>
                    </p>
                    <p style="font-size:16px; padding-bottom:10px" >
                        Датум: <u><xsl:value-of select="$d1"/></u>
                    </p>
                </div>
                    <div style="width:60%; margin-bottom:10px" >
                        <xsl:choose>
                            <xsl:when test="boolean(ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Fizicko_lice)">
                                <div class="underline" style="padding-bottom:10px">
                                    <xsl:variable name="name" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Fizicko_lice/sh:Ime"/>
                                    <xsl:variable name="lastName"  select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Fizicko_lice/sh:Prezime"/>
                                    <xsl:value-of select="concat($name, ' ', $lastName)"/>
                                </div>
                                <div class="underline" style="padding-bottom:10px">
                                    <xsl:variable name="city" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Fizicko_lice/sh:Adresa/sh:Grad"/>
                                    <xsl:variable name="street" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Fizicko_lice/sh:Adresa/sh:Ulica"/>
                                    <xsl:variable name="streetNum" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Fizicko_lice/sh:Adresa/sh:Broj"/>
                                    <xsl:variable name="postCode" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Fizicko_lice/sh:Adresa/sh:Postanski_broj"/>

                                    <xsl:value-of select="concat($street, ' ', $streetNum, ', ', $city, ', ', $postCode)"/>
                                </div>
                            </xsl:when>
                            <xsl:otherwise>
                                <div class="underline" style="padding-bottom:10px">
                                    (<u><xsl:value-of select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Pravno_lice/sh:Naziv"/></u>)
                                </div>
                                <div class="underline" style="padding-bottom:10px">
                                    <xsl:variable name="city" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Pravno_lice/sh:Adresa/sh:Grad"/>
                                    <xsl:variable name="street" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Pravno_lice/sh:Adresa/sh:Ulica"/>
                                    <xsl:variable name="streetNum" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Pravno_lice/sh:Adresa/sh:Broj"/>
                                    <xsl:variable name="postCode" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Pravno_lice/sh:Adresa/sh:Postanski_broj"/>

                                    <xsl:value-of select="concat($street, ' ', $streetNum, ', ', $city, ', ', $postCode)"/>)
                                </div>
                            </xsl:otherwise>
                        </xsl:choose>
                        (Име и презиме / назив / и адреса подносиоца захтева)
                    </div>

                    <div style="text-align: center">
                        <p>
                            <h2>О Б А В Е Ш Т Е Њ Е</h2>
                        </p>
                    </div>
                    <div style="text-align: center; width: 60%; padding-left:20%">
                        <p >
                            <h3><b>о стављању на увид документа који садржи тражену информацију и о изради копије</b></h3>
                        </p>
                    </div>

                    <p style="text-align: justify; font-size: 16px;padding-top:15px;text-indent: 20px;">
                        На основу члана 16. ст. 1 Закона о слободном приступу информацијама од јавног значаја, поступајући по вашем захтеву за слободан приступ информацијама од
                        <u><xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje/ob:Odgovor/ob:Godina_zahteva"/></u>
                        год., којим сте тражили увид у документ/е са информацијама о/у вези са:
                    </p>

                    <p  style="text-align: justify; font-size: 16px;padding-top:5px; margin-top:20px" class="underline">
                        <xsl:apply-templates select="/ob:ObavestenjeRoot/ob:Obavestenje/ob:Odgovor/ob:Opis_trazene_informacije"/>
                    </p>
                    <p style="text-align:center">
                        (опис тражене информације)
                    </p>

                    <xsl:variable name="datum" select="/ob:ObavestenjeRoot/ob:Obavestenje//ob:Odgovor/ob:Datum"/>
                    <xsl:variable name="d2" select="concat(substring($datum,9,2),'.',substring($datum,6,2),'.',substring($datum,1,4),'.')"/>

                    <p  style="text-align: justify; font-size: 16px;padding-top:20px; margin-top:20px" >
                        обавештавамо вас да дана
                        <xsl:value-of select="$d2"/>
                        , у
                        <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje//ob:Odgovor/ob:Sati"/>
                        часова, односно у времену од
                        <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje//ob:Odgovor/ob:Sati_od"/>
                        до
                        <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje//ob:Odgovor/ob:Sati_do"/>
                        часова, у просторијама органа у
                        <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje//ob:Odgovor/ob:Lokacija//ob:Grad"/>
                        ул.
                        <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje//ob:Odgovor/ob:Lokacija//ob:Ulica"/>
                        бр.
                        <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje//ob:Odgovor/ob:Lokacija//ob:Broj"/>
                        , канцеларија бр.
                        <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje//ob:Odgovor/ob:Lokacija/ob:Broj_kancelarije"/>
                        можете извршити увид у документ/е у коме је садржана тражена информација.
                    </p>
                    <p  style="text-align: justify; font-size: 16px;padding-top:20px;text-indent: 20px;">
                        Том приликом, на ваш захтев, може вам се издати и копија документа са траженом информацијом.
                    </p>
                    <p  style="text-align: justify; font-size: 16px;padding-top:20px;text-indent: 20px;">
                        Трошкови су утврђени Уредбом Владе Републике Србије („Сл. гласник РС“, бр. 8/06), и то: копија стране А4
                        формата износи 3 динара, А3 формата 6 динара, CD 35 динара, дискете 20 динара, DVD 40 динара, аудио-касета
                        – 150 динара, видео-касета 300 динара, претварање једне стране документа из физичког у електронски облик – 30 динара.
                    </p>
                    <p style="text-align: justify; font-size: 16px;padding-top:20px;text-indent: 20px;">
                        Износ укупних трошкова израде копије документа по вашем захтеву износи
                        <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje//ob:Podaci_o_placanju//ob:Ukupni_troskovi"/>
                        динара и уплаћује се на жиро-рачун Буџета Републике Србије бр.  <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje//ob:Podaci_o_placanju//ob:Broj_racuna"/>, с позивом на број 97 – ознака
                        шифре општине/града где се налази орган власти (из Правилника о условима и начину вођења рачуна – „Сл. гласник РС“, 20/07... 40/10).
                    </p>

                    <div style="padding-top:20px">
                        <div style="width: 30%; float: left;">
                            <div style="text-align: justify; font-size: 16px;">
                                Достављено:
                                <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje//ob:Dostavljeno"/>
                            </div>
                        </div>
                        <div style="width: 30%; float:left;text-align:center;height:40px;padding-top:20px;">
                            <p>
                                (М.П)
                            </p>

                        </div>
                        <div style="width: 30%;float: right;padding-right:5%;padding-top:10%;">
                            <p>
                                _________________________
                            </p>
                            <p>
                                (Потпис овлашћеног лица, односно руководиоца органа)
                            </p>
                        </div>
                    </div>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>