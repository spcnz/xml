<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xs="http://www.w3.org/2001/XMLSchema"
                xmlns:fo="http://www.w3.org/1999/XSL/Format"
                exclude-result-prefixes="xs"
                version="2.0"
                xmlns:za="http://www.zahtev.com"
                xmlns:sh="http://www.shared.com"
                xmlns:xalan="http://xml.apache.org/xalan">

    <xsl:variable name="space" select="'&#xA0;'"/>

    <xsl:template match="/">
        <xsl:variable name="space" select="'&#xA0;'"/>
        <xsl:variable name="date" select="//za:sadrzaj/za:datum_vreme/sh:datum"/>
        <xsl:variable name="d1" select="concat(substring($date,9,2),'.',substring($date,6,2),'.',substring($date,1,4),'.')"/>

        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="page" page-height="792pt" page-width="612pt"  margin-top="50px">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="page">
                <fo:flow flow-name="xsl-region-body" font-family="Times New Roman" font-size="0.95em" letter-spacing="0.05pt" margin-left="80px" margin-right="40px">
                    <fo:block font-family="Times New Roman" font-size="14px" text-align="center">
                        <xsl:value-of select="za:ZahtevRoot//za:nadlezni_organ/za:naziv"/>
                    </fo:block>
                    <fo:block>
                        <xsl:value-of select="za:ZahtevRoot//za:nadlezni_organ/za:sediste"/>
                    </fo:block>

                    <fo:block font-family="Times New Roman" font-size="15px" text-align="center">
                        ...............................................................................................................
                    </fo:block>

                    <fo:block font-family="Times New Roman" font-size="12px" text-align="center">
                        назив и седиште органа коме се захтев упућује
                    </fo:block>

                    <fo:block font-family="Times New Roman" text-align="center" font-size="20px" font-weight="bold" padding-top="50px">
                        З А Х Т Е В
                    </fo:block>

                    <fo:block font-family="Times New Roman" text-align="center" font-size="14px" font-weight="bold" padding-top="5px">
                        за приступ информацији од јавног значаја
                    </fo:block>

                    <fo:block font-family="Times New Roman" text-align="justify" font-size="11px"  padding-top="15px" >
                        На основу члана 15. ст. 1. Закона о слободном приступу информацијама од јавног значаја
                        („Службени гласник РС“, бр. 120/04, 54/07, 104/09 и 36/10), од горе наведеног органа захтевам:*
                    </fo:block>

                    <fo:block-container margin-left="10px" padding-top="10px">
                        <fo:block font-family="Times New Roman" font-size="11px">
                            <xsl:value-of select="//za:tip_zahteva" />
                        </fo:block>
                    </fo:block-container>

                    <fo:block-container margin-left="20px" >
                        <fo:block font-family="Times New Roman" font-size="11px">
                            <xsl:if test="//za:nacini_dostave/za:POSTA">
                                поштом
                            </xsl:if>
                            <xsl:if test="//za:nacini_dostave/za:EMAIL">
                                електронском поштом
                            </xsl:if>
                            <xsl:if test="//za:nacini_dostave/za:FAKS">
                                факсом
                            </xsl:if>

                        </fo:block>
                    </fo:block-container>

                    <fo:block font-family="Times New Roman" margin-left="10px" font-size="11px"  padding-top="15px" >
                        Овај захтев се односи на следеће информације:
                    </fo:block>

                    <fo:block font-family="Times New Roman" margin-left="10px" font-size="14px"  padding-top="5px" >
                        <xsl:value-of select="//za:sadrzaj//za:opis_informacije"/>
                    </fo:block>
                    <fo:block>
                        (навести што прецизнији опис информације која се тражи као и друге податке који олакшавају проналажење тражене информације)
                    </fo:block>

                    <fo:block padding-top="20px">
                        <fo:inline-container inline-progression-dimension="50%">
                            <fo:block font-family="Times New Roman" text-align="justify" font-size="11px" padding-top="10px">
                                У Beograd,
                            </fo:block>
                            <fo:block font-family="Times New Roman" text-align="justify" font-size="11px" padding-top="10px">
                                <xsl:value-of select="$d1"/> године.
                                године.
                            </fo:block>
                        </fo:inline-container>
                        <fo:inline-container font-family="Times New Roman" text-align="center" font-size="11px" inline-progression-dimension="50%">
                            <fo:block padding-top="10px">
                                <xsl:value-of select="//za:trazilac_informacije/sh:Ime"/>        <xsl:value-of select="//za:trazilac_informacije/sh:Prezime"/>
                            </fo:block>
                            (Тражилац информације/Име и презиме)

                            <fo:block padding-top="10px">
                                <xsl:value-of select="//za:trazilac_informacije//sh:Ulica"/>    <xsl:value-of select="//za:trazilac_informacije//sh:Broj"/> ,  <xsl:value-of select="//za:trazilac_informacije//sh:Grad"/>,  <xsl:value-of select="//za:trazilac_informacije//sh:Postanski_broj"/>
                            </fo:block>
                            (адреса)
                            <fo:block padding-top="10px">
                                <xsl:value-of select="//za:trazilac_informacije//sh:drugi_podaci_za_kontakt"/>
                            </fo:block>
                            (други подаци за контакт)
                            <fo:block padding-top="10px">
                                _______________________
                            </fo:block>
                            <fo:block>
                                Потпис
                            </fo:block>

                        </fo:inline-container>
                    </fo:block>
                    <fo:block margin-top="30px">
                        ________________________________________________________________
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="9px">
                        * У кућици означити која законска права на приступ информацијама желите да остварите.
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="9px">
                        ** У кућици означити начин достављања копије докумената.
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="9px">
                        *** Када захтевате други начин достављања обавезно уписати који начин достављања захтевате.
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

</xsl:stylesheet>