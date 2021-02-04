<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xs="http://www.w3.org/2001/XMLSchema"
                xmlns:fo="http://www.w3.org/1999/XSL/Format"
                exclude-result-prefixes="xs"
                version="2.0"
                xmlns:za="http://www.zalbacutanje.com"
                xmlns:sh="http://www.shared.com"
                xmlns:xalan="http://xml.apache.org/xalan">

    <xsl:variable name="space" select="'&#xA0;'"/>

    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="page" page-height="792pt" page-width="612pt"  margin-top="50px">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="page">
                <fo:flow flow-name="xsl-region-body" font-family="Times New Roman" font-size="0.95em" letter-spacing="0.05pt" margin-left="80px" margin-right="40px">
                    <fo:block font-weight="bold">
                        ЖАЛБА КАДА ОРГАН ВЛАСТИ <fo:inline text-decoration="underline">НИЈЕ ПОСТУПИО/ није поступио у целости/ ПО ЗАХТЕВУ </fo:inline>
                    </fo:block>
                    <fo:block font-weight="bold" margin-bottom="20px" text-align="center">ТРАЖИОЦА У ЗАКОНСКОМ РОКУ (ЋУТАЊЕ УПРАВЕ)</fo:block>
                    <fo:block font-weight="bold"><xsl:value-of select="za:ZalbaCutanjeRoot/za:zalbaCutanje/za:primaoc/sh:Uloga"/></fo:block>
                    <fo:block>
                        Адреса за пошту: <xsl:value-of select="za:ZalbaCutanjeRoot/za:zalbaCutanje//sh:Adresa/sh:Grad"/>, <xsl:value-of select="za:ZalbaCutanjeRoot/za:zalbaCutanje//sh:Adresa/sh:Ulica"/>, бр. <xsl:value-of select="za:ZalbaCutanjeRoot/za:zalbaCutanje//sh:Adresa/sh:Broj"/>, <xsl:value-of select="za:ZalbaCutanjeRoot/za:zalbaCutanje//sh:Adresa/sh:Postanski_broj"/>
                    </fo:block>
                    <fo:block margin-top="30px">
                        У складу са чланом 22. Закона о слободном приступу информацијама од јавног значаја
                    <fo:block>
                        подносим:
                    </fo:block>
                    </fo:block>
                    <fo:block text-align="center" font-weight="bold">
                        Ж А Л Б У
                    </fo:block>
                    <fo:block text-align="center">против</fo:block>
                    <fo:block>
                        <fo:inline text-decoration="underline"><xsl:value-of select="//za:naziv_organa"/></fo:inline>
                    </fo:block>
                    <fo:block text-align="center" margin-bottom="15px">( навести назив органа)</fo:block>
                    <fo:block text-align="center">
                        због тога што орган власти:
                    </fo:block>
                    <fo:block text-align="center">
                        <fo:inline text-decoration="underline"><xsl:value-of select="//za:razlog"/></fo:inline>
                    </fo:block>
                    <fo:block text-align="center" margin-bottom="15px">
                        (подвући  због чега се изјављује жалба)
                    </fo:block>

                    <fo:block>
                        по мом захтеву  за слободан приступ информацијама од јавног значаја који сам поднео  том
                    </fo:block>
                    <fo:block>
                        <xsl:variable name="date" select="//za:sadrzaj//za:datum"/>
                        органу  дана <fo:inline text-decoration="underline">
                        <xsl:value-of select="concat(substring($date,9,2),'.',substring($date,6,2),'.',substring($date,1,4),'.')"/></fo:inline> године, а којим сам тражио/ла да ми се у складу са Законом о
                        <fo:block>слободном приступу информацијама од јавног значаја омогући увид- копија документа који </fo:block>
                        <fo:block>садржи информације  о /у вези са :</fo:block>
                        <fo:block margin-top="10px">
                            <fo:inline text-decoration="underline"><xsl:value-of select="//za:sadrzaj//za:podaci_o_zahtevu"/></fo:inline>
                        </fo:block>
                        <fo:block text-align="center" margin-bottom="25px">(навести податке о захтеву и информацији/ама)</fo:block>
                    </fo:block>

                    <fo:block margin-left="20px">
                        На основу изнетог, предлажем да Повереник уважи моју жалбу и омогући ми приступ
                    </fo:block>
                    <fo:block>траженој/им  информацији/ма.</fo:block>
                    <fo:block margin-left="20px">
                        Као доказ , уз жалбу достављам копију захтева са доказом о предаји органу власти.
                    </fo:block>
                    <fo:block><fo:inline font-weight="bold" >Напомена:</fo:inline>Код жалбе  због непоступању по захтеву у целости, треба приложити и </fo:block>
                    <fo:block>добијени одговор органа власти.</fo:block>

                    <fo:block text-align="right" margin-top="20px">
                        <xsl:variable name="firstName" select="//za:sadrzaj//za:podnosilac_zalbe/sh:Ime"/>
                        <xsl:variable name="lastName" select="//za:sadrzaj//za:podnosilac_zalbe/sh:Prezime"/>
                        <fo:inline text-decoration="underline"><xsl:value-of select="concat($firstName, ' ', $lastName)"/></fo:inline>
                        <fo:block>Подносилац жалбе / Име и презиме</fo:block>
                        <fo:block>................</fo:block>
                        <fo:block>потпис</fo:block>
                        <fo:block> <fo:inline text-decoration="underline"><xsl:value-of select="//za:sadrzaj//za:podnosilac_zalbe//sh:Adresa/sh:Grad"/>,  <xsl:value-of select="//za:sadrzaj//za:podnosilac_zalbe//sh:Adresa/sh:Ulica"/>, бр. <xsl:value-of select="//za:sadrzaj//za:podnosilac_zalbe//sh:Adresa/sh:Broj"/>, <xsl:value-of select="//za:sadrzaj//za:podnosilac_zalbe//sh:Adresa/sh:Postanski_broj"/></fo:inline>
                        </fo:block>
                        <fo:block>адресa</fo:block>
                        <fo:block><fo:inline text-decoration="underline"><xsl:value-of select="//za:sadrzaj//za:podnosilac_zalbe//sh:drugi_podaci_za_kontakt"/></fo:inline></fo:block>
                        <fo:block>други подаци за контакт</fo:block>
                    </fo:block>

                    <fo:block text-align="left">
                        <xsl:variable name="date" select="//za:sadrzaj//za:datum_vreme//sh:datum"/>
                        <xsl:variable name="d1" select="concat(substring($date,9,2),'.',substring($date,6,2),'.',substring($date,1,4),'.')"/>
                        У <fo:inline text-decoration="underline"><xsl:value-of select="za:ZalbaCutanjeRoot/za:zalbaCutanje//sh:Adresa/sh:Grad"/></fo:inline>, дана <fo:inline text-decoration="underline"><xsl:value-of select="$d1"/></fo:inline> године
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

</xsl:stylesheet>