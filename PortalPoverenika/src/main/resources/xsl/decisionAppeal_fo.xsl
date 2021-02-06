<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xs="http://www.w3.org/2001/XMLSchema"
                xmlns:fo="http://www.w3.org/1999/XSL/Format"
                exclude-result-prefixes="xs"
                version="2.0"
                xmlns:za="http://www.zalbanaodluku.com"
                xmlns:sh="http://www.shared.com"
                xmlns:xalan="http://xml.apache.org/xalan">

    <xsl:variable name="space" select="'&#xA0;'"/>

    <xsl:template match="/">
        <xsl:variable name="space" select="'&#xA0;'"/>
        <xsl:variable name="date" select="/za:ZalbaRoot/za:Zalba//za:Datum_podnosenja_zahteva"/>
        <xsl:variable name="d1" select="concat(substring($date,9,2),'.',substring($date,6,2),'.',substring($date,1,4),'.')"/>
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="page" page-height="792pt" page-width="612pt"  margin-top="50px">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="page">
                <fo:flow flow-name="xsl-region-body" font-family="Times New Roman" font-size="0.95em" letter-spacing="0.05pt" margin-left="80px" margin-right="40px">
                    <fo:block font-weight="bold" text-align="center">
                        ЖАЛБА  ПРОТИВ  ОДЛУКЕ ОРГАНА  ВЛАСТИ КОЈОМ ЈЕ
                    </fo:block>
                    <fo:block font-weight="bold" margin-bottom="20px" text-align="center"><fo:inline text-decoration="underline">ОДБИЈЕН ИЛИ ОДБАЧЕН ЗАХТЕВ</fo:inline> ЗА ПРИСТУП ИНФОРМАЦИЈИ</fo:block>
                    <fo:block font-weight="bold"><xsl:value-of select="za:ZalbaRoot/za:Zalba/za:Primaoc/sh:Uloga" /></fo:block>
                    <fo:block>
                        Адреса за пошту:  <xsl:value-of select="za:ZalbaRoot/za:Zalba//sh:Adresa/sh:Grad"/>,  <xsl:value-of select="za:ZalbaRoot/za:Zalba//sh:Adresa/sh:Ulica"/>, бр. <xsl:value-of select="za:ZalbaRoot/za:Zalba//sh:Adresa/sh:Broj"/>, <xsl:value-of select="za:ZalbaRoot/za:Zalba//sh:Adresa/sh:Postanski_broj"/>
                    </fo:block>
                    <fo:block text-align="center" margin-top="20px" margin-bottom="20px" font-weight="bold">
                        Ж А Л Б A
                    </fo:block>

                    <fo:block text-align="center" margin-bottom="15px">
                        <xsl:choose>
                            <xsl:when test="boolean(za:ZalbaRoot/za:Zalba/za:Fizicko_lice)">
                                <fo:inline text-decoration="underline" text-align="center">
                                    <xsl:variable name="name" select="za:ZalbaRoot/za:Zalba/za:Fizicko_lice/sh:Ime"/>
                                    <xsl:variable name="lastName" select="za:ZalbaRoot/za:Zalba/za:Fizicko_lice/sh:Prezime"/>
                                    (<xsl:value-of select="concat($name, ' ', $lastName)"/>
                                </fo:inline>
                                <fo:inline text-decoration="underline" text-align="center">
                                    <xsl:variable name="city" select="za:ZalbaRoot/za:Zalba/za:Fizicko_lice/sh:Adresa/sh:Grad"/>
                                    <xsl:variable name="street" select="za:ZalbaRoot/za:Zalba/za:Fizicko_lice/sh:Adresa/sh:Ulica"/>
                                    <xsl:variable name="streetNum" select="za:ZalbaRoot/za:Zalba/za:Fizicko_lice/sh:Adresa/sh:Broj"/>
                                    <xsl:variable name="postCode" select="za:ZalbaRoot/za:Zalba/za:Fizicko_lice/sh:Adresa/sh:Postanski_broj"/>

                                    <xsl:value-of select="concat($street, ' ', $streetNum, ', ', $city, ', ', $postCode)"/>)
                                </fo:inline>
                                <fo:block text-align="center">
                                    (Име, презиме, односно назив,седиште жалиоца и адреса)
                                </fo:block>
                            </xsl:when>
                            <xsl:otherwise>
                                <fo:block text-decoration="underline" text-align="center">
                                    (<u><xsl:value-of select="za:ZalbaRoot/za:Zalba/za:Pravno_lice/sh:Naziv"/></u>)
                                </fo:block>
                                <fo:block text-align="center">
                                    (Име, презиме, односно назив,седиште жалиоца и адреса)
                                </fo:block>

                            </xsl:otherwise>
                        </xsl:choose>
                    </fo:block>

                    <fo:block text-align="center" margin-bottom="15px">
                        против решења-закључка
                    </fo:block>
                    <fo:block text-align="center" text-decoration="underline">
                        Naziv organa vlasti
                    </fo:block>
                    <fo:block text-align="center" margin-bottom="30px">( навести назив органа)</fo:block>


                    <fo:block margin-top="20px" margin-bottom="20px">
                        Број
                        <xsl:variable name="requestID" select="za:ZalbaRoot/@href"/>
                        <fo:inline text-decoration="underline"> <xsl:value-of select="substring($requestID, 16)" /></fo:inline>
                        од
                        <xsl:value-of select="$d1"/>
                        године.
                    </fo:block>

                    <fo:block margin-left="20px">
                        Наведеном одлуком органа власти (решењем, закључком, обавештењем у писаној форми са
                    </fo:block>
                    <fo:block>
                        елементима одлуке) , супротно закону, одбијен-одбачен је мој захтев који сам поднео/ла-упутио/ла дана
                        <fo:inline text-decoration="underline"> <xsl:value-of select="$d1"/></fo:inline>
                        године и тако ми ускраћено-онемогућено остваривање уставног и законског права на слободан
                        приступ информацијама од јавног значаја. Oдлуку побијам у целости, односно у делу којим.

                        <fo:block text-decoration="underline" margin-bottom="10px" margin-top="10px"><xsl:value-of select="/za:ZalbaRoot//za:Osnova_zalbe"/></fo:block>
                        јер није заснована на Закону о слободном приступу информацијама од јавног значаја.
                    </fo:block>
                    <fo:block margin-left="20px">
                        На основу изнетих разлога, предлажем да Повереник уважи моју жалбу,  поништи
                    </fo:block>
                    <fo:block>
                        одлука првостепеног органа и омогући ми приступ траженој/им  информацији/ма.
                    </fo:block>
                    <fo:block margin-left="20px">
                        Жалбу подносим благовремено, у законском року утврђеном у члану 22. ст. 1. Закона о
                    </fo:block>
                    <fo:block>
                        слободном приступу информацијама од јавног значаја.
                    </fo:block>
                    <fo:block text-align="left" margin-top="10px">
                        <xsl:variable name="date" select="/za:ZalbaRoot//za:Datum"/>
                        <xsl:variable name="d2" select="concat(substring($date,9,2),'.',substring($date,6,2),'.',substring($date,1,4),'.')"/>
                        У <fo:inline text-decoration="underline"><xsl:value-of select="/za:ZalbaRoot//za:Grad"/></fo:inline>
                        дана   <fo:inline text-decoration="underline"><xsl:value-of select="$d2"/></fo:inline>
                    </fo:block>


                    <fo:block text-align="right">
                        <xsl:variable name="firstName" select="/za:ZalbaRoot//za:Podnosilac/sh:Ime"/>
                        <xsl:variable name="lastName" select="/za:ZalbaRoot//za:Podnosilac/sh:Prezime"/>
                        <fo:inline text-decoration="underline"><xsl:value-of select="concat($firstName, ' ', $lastName)"/></fo:inline>
                        <fo:block margin-bottom="10px">Подносилац жалбе / Име и презиме</fo:block>
                        <fo:block text-decoration="underline">
                            <xsl:value-of select="/za:ZalbaRoot//za:Podnosilac/sh:Adresa/sh:Ulica"/>,
                            <xsl:value-of select="/za:ZalbaRoot//za:Podnosilac/sh:Adresa/sh:Broj"/>,
                            <xsl:value-of select="/za:ZalbaRoot//za:Podnosilac/sh:Adresa/sh:Grad"/>,
                            <xsl:value-of select="/za:ZalbaRoot//za:Podnosilac/sh:Adresa/sh:Postanski_broj"/>
                        </fo:block>
                        <fo:block margin-bottom="10px">адресa</fo:block>

                        <fo:block>
                            <fo:inline text-decoration="underline">
                                <xsl:value-of select="/za:ZalbaRoot//za:Podnosilac/sh:drugi_podaci_za_kontakt"/>
                            </fo:inline>
                        </fo:block>
                        <fo:block margin-bottom="10px">други подаци за контакт</fo:block>
                        <fo:block>................</fo:block>
                        <fo:block>потпис</fo:block>
                    </fo:block>

                    <fo:block text-align="left" >
                        <fo:inline font-weight="bold" margin-bottom="10px">Напомена:</fo:inline>
                        <fo:block margin-bottom="10px" margin-left="20px">
                            •	У жалби се мора навести одлука која се побија (решење, закључак, обавештење),
                        назив органа који је одлуку донео, као и број и датум одлуке. Довољно је да жалилац
                        наведе у жалби у ком погледу је незадовољан одлуком, с тим да жалбу не мора посебно образложити.
                        Ако жалбу изјављује на овом обрасцу, додатно образложење може  посебно приложити.
                        </fo:block>
                        <fo:block margin-bottom="10px" margin-left="20px">
                        •	Уз жалбу обавезно приложити копију поднетог захтева и доказ о његовој предаји-упућивању
                        органу као и копију одлуке органа која се оспорава жалбом.
                    </fo:block>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

</xsl:stylesheet>