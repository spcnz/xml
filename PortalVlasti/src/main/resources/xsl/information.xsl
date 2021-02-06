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

                <div style="width: 60%; padding-left:30%">
                    <u>
                    <p font-family="Times New Roman" font-size="16px" >
                        <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje/ob:Organ/ob:Naziv"/>
                    </p>
                    <p style="font-size:16px" >

                        <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje/ob:Organ/sh:Adresa/sh:Ulica"/>, <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje/ob:Organ/sh:Adresa/sh:Broj"/>, <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje/ob:Organ/sh:Adresa/sh:Grad"/>, <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje/ob:Organ/sh:Adresa/sh:Postanski_broj"/>

                    </p>
                    </u>
                    <p style="font-size:16px" >
                        Број предмета: <u><xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje/ob:Broj_predmeta"/></u>
                    </p>
                    <p style="font-size:16px; padding-bottom:10px" >
                        Датум: <u><xsl:value-of select="$d1"/></u>
                    </p>
                    <p style="font-size:16px" >
                        <xsl:choose>
                            <xsl:when test="boolean(ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Fizicko_lice)">
                                <div class="underline">
                                    daaaa
                                    <xsl:variable name="name" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Fizicko_lice/sh:Ime"/>
                                    <xsl:variable name="lastName"  select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Fizicko_lice/sh:Prezime"/>
                                    (<xsl:value-of select="concat($name, ' ', $lastName)"/>
                                </div>
                                <div class="underline">
                                    nee
                                    <xsl:variable name="city" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Fizicko_lice/sh:Adresa/sh:Grad"/>
                                    <xsl:variable name="street" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Fizicko_lice/sh:Adresa/sh:Ulica"/>
                                    <xsl:variable name="streetNum" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Fizicko_lice/sh:Adresa/sh:Broj"/>
                                    <xsl:variable name="postCode" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Fizicko_lice/sh:Adresa/sh:Postanski_broj"/>

                                    <xsl:value-of select="concat($street, ' ', $streetNum, ', ', $city, ', ', $postCode)"/>)
                                </div>
                            </xsl:when>
                            <xsl:otherwise>
                                <div class="underline">
                                    (<u><xsl:value-of select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Pravno_lice/sh:Naziv"/></u>)
                                </div>
                                <div class="underline">
                                    <xsl:variable name="city" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Pravno_lice/sh:Adresa/sh:Grad"/>
                                    <xsl:variable name="street" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Pravno_lice/sh:Adresa/sh:Ulica"/>
                                    <xsl:variable name="streetNum" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Pravno_lice/sh:Adresa/sh:Broj"/>
                                    <xsl:variable name="postCode" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Pravno_lice/sh:Adresa/sh:Postanski_broj"/>

                                    <xsl:value-of select="concat($street, ' ', $streetNum, ', ', $city, ', ', $postCode)"/>)
                                </div>
                            </xsl:otherwise>
                        </xsl:choose>
                    </p>
<!--                    <p style="font-size:16px" >-->
<!--                        <xsl:value-of select="/ob:obavestenje/ob:obavestenje_body/ob:informacije_o_podnosiocu/re:adresa"/>-->
<!--                        <xsl:value-of select="/ob:obavestenje/ob:obavestenje_body/ob:informacije_o_podnosiocu/re:adresa/re:ulica/@broj"/>-->
<!--                    </p>-->
<!--                    <div style="text-align: center">-->
<!--                        <p>-->
<!--                            <h2><xsl:value-of select="/ob:obavestenje/ob:obavestenje_body/ob:naslov"/></h2>-->
<!--                        </p>-->
<!--                    </div>-->
<!--                    <div style="text-align: center; width: 60%; padding-left:20%">-->
<!--                        <p >-->
<!--                            <h3><b><xsl:value-of select="/ob:obavestenje/ob:obavestenje_body/ob:podnaslov"/></b></h3>-->
<!--                        </p>-->
<!--                    </div>-->

<!--                    <p style="text-align: justify; font-size: 16px;padding-top:15px;text-indent: 20px;">-->
<!--                        На основу члана 16. ст. 1 Закона о слободном приступу информацијама од јавног значаја, поступајући по вашем захтеву за слободан приступ информацијама од-->
<!--                        <xsl:value-of select="/ob:obavestenje/ob:obavestenje_body/ob:tekst_zahteva/re:godina"/>-->
<!--                        год., којим сте тражили увид у документ/е са информацијама о/у вези са:-->
<!--                    </p>-->

<!--                    <p  style="text-align: justify; font-size: 16px;padding-top:5px">-->
<!--                        <xsl:apply-templates select="/ob:obavestenje/ob:obavestenje_body/ob:tekst_zahteva/re:opis_trazene_informacije"/>-->
<!--                    </p>-->

<!--                    <p  style="text-align: center; font-size: 16px" >-->
<!--                        (oпис тражене информације)-->
<!--                    </p>-->

<!--                    <p  style="text-align: justify; font-size: 16px;padding-top:20px" >-->
<!--                        обавештавамо вас да дана-->
<!--                        <xsl:value-of select="/ob:obavestenje/ob:obavestenje_body/ob:tekst_zahteva/re:dan"/>-->
<!--                        , у-->
<!--                        <xsl:value-of select="/ob:obavestenje/ob:obavestenje_body/ob:tekst_zahteva/re:vreme"/>-->
<!--                        часова, односно у времену од-->
<!--                        <xsl:value-of select="/ob:obavestenje/ob:obavestenje_body/ob:tekst_zahteva/re:radno_vreme/re:pocetak"/>-->
<!--                        до-->
<!--                        <xsl:value-of select="/ob:obavestenje/ob:obavestenje_body/ob:tekst_zahteva/re:radno_vreme/re:kraj"/>-->
<!--                        часова, у просторијама органа у-->
<!--                        <xsl:value-of select="/ob:obavestenje/ob:obavestenje_body/ob:tekst_zahteva/re:adresa/re:mesto"/>-->
<!--                        ул.-->
<!--                        <xsl:value-of select="/ob:obavestenje/ob:obavestenje_body/ob:tekst_zahteva/re:adresa/re:ulica"/>-->
<!--                        бр.-->
<!--                        <xsl:value-of select="/ob:obavestenje/ob:obavestenje_body/ob:tekst_zahteva/re:adresa/re:ulica/@broj"/>-->
<!--                        , канцеларија бр.-->
<!--                        <xsl:value-of select="/ob:obavestenje/ob:obavestenje_body/ob:tekst_zahteva/re:broj_kancelarije"/>-->
<!--                        можете извршити увид у документ/е у коме је садржана тражена информација.-->
<!--                    </p>-->
<!--                    <p  style="text-align: justify; font-size: 16px;padding-top:20px;text-indent: 20px;">-->
<!--                        Том приликом, на ваш захтев, може вам се издати и копија документа са траженом информацијом.-->
<!--                    </p>-->
<!--                    <p  style="text-align: justify; font-size: 16px;padding-top:20px;text-indent: 20px;">-->
<!--                        Трошкови су утврђени Уредбом Владе Републике Србије („Сл. гласник РС“, бр. 8/06), и то: копија стране А4-->
<!--                        формата износи 3 динара, А3 формата 6 динара, CD 35 динара, дискете 20 динара, DVD 40 динара, аудио-касета-->
<!--                        – 150 динара, видео-касета 300 динара, претварање једне стране документа из физичког у електронски облик – 30 динара.-->
<!--                    </p>-->
<!--                    <p style="text-align: justify; font-size: 16px;padding-top:20px;text-indent: 20px;">-->
<!--                        Износ укупних трошкова израде копије документа по вашем захтеву износи-->
<!--                        <xsl:value-of select="/ob:obavestenje/ob:obavestenje_body/ob:tekst_zahteva/re:ukupan_trosak/re:iznos"/>-->
<!--                        динара и уплаћује се на жиро-рачун Буџета Републике Србије бр. 840-742328-843-30, с позивом на број 97 – ознака-->
<!--                        шифре општине/града где се налази орган власти (из Правилника о условима и начину вођења рачуна – „Сл. гласник РС“, 20/07... 40/10).-->
<!--                    </p>-->

<!--                    <div style="padding-top:20px">-->
<!--                        <div style="width: 30%; float: left;">-->
<!--                            <div style="text-align: justify; font-size: 16px;">-->
<!--                                Достављено:-->
<!--                                <xsl:for-each select="/ob:obavestenje/ob:obavestenje_body/ob:opcija_dostave/re:opcija">-->
<!--                                    <xsl:if test="@izabran='true'">-->
<!--                                        <p>-->
<!--                                            <xsl:value-of select="position()"/>.-->
<!--                                            <xsl:value-of select="."/>-->
<!--                                        </p>-->
<!--                                    </xsl:if>-->
<!--                                </xsl:for-each>-->
<!--                            </div>-->
<!--                        </div>-->
<!--                        <div style="width: 30%; float:left;text-align:center;height:40px;padding-top:20px;">-->
<!--                            <p>-->
<!--                                (М.П)-->
<!--                            </p>-->

<!--                        </div>-->
<!--                        <div style="width: 30%;float: right;padding-right:5%;padding-top:10%;">-->
<!--                            <p>-->
<!--                                _________________________-->
<!--                            </p>-->
<!--                            <p>-->
<!--                                (Потпис овлашћеног лица, односно руководиоца органа)-->
<!--                            </p>-->
<!--                        </div>-->
<!--                    </div>-->
<!--                    <div>-->
<!--                        <a href="{/ob:obavestenje/ob:obavestenje_body/@link_na_zahtev}">Референцирани захтев</a>-->
<!--                    </div>-->
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>