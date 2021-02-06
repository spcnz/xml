<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xs="http://www.w3.org/2001/XMLSchema"
                xmlns:fo="http://www.w3.org/1999/XSL/Format"
                exclude-result-prefixes="xs"
                version="2.0"
                xmlns:ob="http://www.obavestenje.com"
                xmlns:sh="http://www.shared.com"
                xmlns:xalan="http://xml.apache.org/xalan">

    <xsl:variable name="space" select="'&#xA0;'"/>

    <xsl:template match="/">
        <xsl:variable name="space" select="'&#xA0;'"/>
        <xsl:variable name="date" select="/ob:ObavestenjeRoot/ob:Obavestenje/ob:Datum"/>
        <xsl:variable name="d1" select="concat(substring($date,9,2),'.',substring($date,6,2),'.',substring($date,1,4),'.')"/>

        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="page" page-height="792pt" page-width="612pt"  margin-top="50px">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="page">
                <fo:flow flow-name="xsl-region-body" font-family="Times New Roman" font-size="0.95em" letter-spacing="0.05pt" margin-left="80px" margin-right="40px">
                    <fo:block font-family="Times New Roman" font-size="13px" >
                        <fo:inline text-decoration="underline">
                        <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje/ob:Organ/ob:Naziv"/>
                        </fo:inline>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="13px" >
                        <fo:inline text-decoration="underline">
                        <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje/ob:Organ/sh:Adresa/sh:Ulica"/>, <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje/ob:Organ/sh:Adresa/sh:Broj"/>, <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje/ob:Organ/sh:Adresa/sh:Grad"/>, <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje/ob:Organ/sh:Adresa/sh:Postanski_broj"/>
                        </fo:inline>
                        <fo:block>
                            (назив и седиште органа)
                        </fo:block>
                    </fo:block>

                    <fo:block font-family="Times New Roman" font-size="13px"  margin-top="10px">
                        Број предмета:  <fo:inline text-decoration="underline"><xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje/ob:Broj_predmeta"/></fo:inline>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="13px" padding-bottom="16px" >
                        Датум:  <fo:inline text-decoration="underline"><xsl:value-of select="$d1"/></fo:inline>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="13px" >
                        <xsl:choose>
                            <xsl:when test="boolean(ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Fizicko_lice)">
                                <fo:block class="underline" style="padding-bottom:10px">
                                    <xsl:variable name="name" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Fizicko_lice/sh:Ime"/>
                                    <xsl:variable name="lastName"  select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Fizicko_lice/sh:Prezime"/>
                                    <xsl:value-of select="concat($name, ' ', $lastName)"/>
                                </fo:block>
                                <fo:block class="underline" style="padding-bottom:10px">
                                    <xsl:variable name="city" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Fizicko_lice/sh:Adresa/sh:Grad"/>
                                    <xsl:variable name="street" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Fizicko_lice/sh:Adresa/sh:Ulica"/>
                                    <xsl:variable name="streetNum" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Fizicko_lice/sh:Adresa/sh:Broj"/>
                                    <xsl:variable name="postCode" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Fizicko_lice/sh:Adresa/sh:Postanski_broj"/>

                                    <xsl:value-of select="concat($street, ' ', $streetNum, ', ', $city, ', ', $postCode)"/>
                                </fo:block>
                            </xsl:when>
                            <xsl:otherwise>
                                <fo:block class="underline" style="padding-bottom:10px">
                                    (<u><xsl:value-of select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Pravno_lice/sh:Naziv"/></u>)
                                </fo:block>
                                <fo:block class="underline" style="padding-bottom:10px">
                                    <xsl:variable name="city" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Pravno_lice/sh:Adresa/sh:Grad"/>
                                    <xsl:variable name="street" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Pravno_lice/sh:Adresa/sh:Ulica"/>
                                    <xsl:variable name="streetNum" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Pravno_lice/sh:Adresa/sh:Broj"/>
                                    <xsl:variable name="postCode" select="ob:ObavestenjeRoot/ob:Obavestenje/ob:Podnosilac/ob:Pravno_lice/sh:Adresa/sh:Postanski_broj"/>

                                    <xsl:value-of select="concat($street, ' ', $streetNum, ', ', $city, ', ', $postCode)"/>)
                                </fo:block>
                            </xsl:otherwise>
                        </xsl:choose>
                        (Име и презиме / назив / и адреса подносиоца захтева)
                    </fo:block>
                    <fo:block font-family="Times New Roman" text-align="center" padding-top="30px" font-size="20px" font-weight="bold" >
                        О Б А В Е Ш Т Е Њ Е
                    </fo:block>

                    <fo:block font-family="Times New Roman" text-align="center" font-size="14px" font-weight="bold" padding-top="10px">
                        о стављању на увид документа који садржи тражену информацију и о изради копије
                    </fo:block>


                    <fo:block font-family="Times New Roman" text-align="justify" font-size="13px"  padding-top="25px">
                        На основу члана 16. ст. 1 Закона о слободном приступу информацијама од јавног значаја, поступајући по вашем захтеву за слободан приступ информацијама од
                        <fo:inline text-decoration="underline"> <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje/ob:Odgovor/ob:Godina_zahteva"/>
                        </fo:inline>
                        год., којим сте тражили увид у документ/е са информацијама о/у вези са:
                    </fo:block>

                    <fo:block font-family="Times New Roman" padding-top="10px" text-align="justify" font-size="13px"  >
                        <fo:inline text-decoration="underline">

                        <xsl:apply-templates select="/ob:ObavestenjeRoot/ob:Obavestenje/ob:Odgovor/ob:Opis_trazene_informacije"/>
                        </fo:inline>
                    </fo:block>

                    <fo:block font-family="Times New Roman" text-align="center" font-size="13px" >
                        (oпис тражене информације)
                    </fo:block>

                    <xsl:variable name="datum" select="/ob:ObavestenjeRoot/ob:Obavestenje//ob:Odgovor/ob:Datum"/>
                    <xsl:variable name="d2" select="concat(substring($datum,9,2),'.',substring($datum,6,2),'.',substring($datum,1,4),'.')"/>


                    <fo:block font-family="Times New Roman" text-align="justify" font-size="13px" padding-top="30px" >
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
                    </fo:block>
                    <fo:block font-family="Times New Roman" text-align="justify"  font-size="13px" padding-top="20px">
                        Том приликом, на ваш захтев, може вам се издати и копија документа са траженом информацијом.
                    </fo:block>
                    <fo:block font-family="Times New Roman" text-align="justify"  font-size="13x" padding-top="10px">
                        Трошкови су утврђени Уредбом Владе Републике Србије („Сл. гласник РС“, бр. 8/06), и то: копија стране А4
                        формата износи 3 динара, А3 формата 6 динара, CD 35 динара, дискете 20 динара, DVD 40 динара, аудио-касета
                        – 150 динара, видео-касета 300 динара, претварање једне стране документа из физичког у електронски облик – 30 динара.
                    </fo:block>
                    <fo:block font-family="Times New Roman" text-align="justify"  font-size="13px" padding-top="10px">
                        Износ укупних трошкова израде копије документа по вашем захтеву износи
                        <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje//ob:Podaci_o_placanju//ob:Ukupni_troskovi"/>
                        динара и уплаћује се на жиро-рачун Буџета Републике Србије бр.  <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje//ob:Podaci_o_placanju//ob:Broj_racuna"/>, с позивом на број 97 – ознака
                        шифре општине/града где се налази орган власти (из Правилника о условима и начину вођења рачуна – „Сл. гласник РС“, 20/07... 40/10).
                    </fo:block>

                    <fo:block padding-top="50px">
                        <fo:inline-container inline-progression-dimension="24%">
                            <fo:block font-family="Times New Roman" text-align="left" margin-left="0" font-size="13px" padding-top="10px">
                                Достављено:     <xsl:value-of select="/ob:ObavestenjeRoot/ob:Obavestenje//ob:Dostavljeno"/>

                            </fo:block>
                        </fo:inline-container>
                        <fo:inline-container font-family="Times New Roman" text-align="center" inline-progression-dimension="15%">
                            <fo:block>
                                (М.П)
                            </fo:block>

                        </fo:inline-container>
                        <fo:inline-container font-family="Times New Roman" text-align="center" inline-progression-dimension="75%">
                            <fo:block>
                                _________________________
                            </fo:block>
                            <fo:block>
                                (Потпис овлашћеног лица, односно руководиоца органа)
                            </fo:block>
                        </fo:inline-container>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

</xsl:stylesheet>