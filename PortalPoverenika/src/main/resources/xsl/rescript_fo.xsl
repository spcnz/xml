<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xs="http://www.w3.org/2001/XMLSchema"
                xmlns:fo="http://www.w3.org/1999/XSL/Format"
                exclude-result-prefixes="xs"
                version="2.0"
                xmlns:re="http://www.resenje.com"
                xmlns:sh="http://www.shared.com"
                xmlns:xalan="http://xml.apache.org/xalan">

    <xsl:variable name="space" select="'&#xA0;'"/>

    <xsl:template match="/">
        <xsl:variable name="space" select="'&#xA0;'"/>
        <xsl:variable name="date" select="/re:ResenjeRoot//re:Datum"/>

        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="page" page-height="792pt" page-width="650pt"  margin-top="50px" margin-bottom="20px">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="page">
                <xsl:variable name="date" select="/re:ResenjeRoot//re:Datum"/>

                <fo:flow flow-name="xsl-region-body" font-family="Times New Roman" font-size="0.95em" letter-spacing="0.05pt" margin-left="80px" margin-right="40px" text-align="justify">
                    <fo:block text-align="left">
                        Примери поступања Повереника по жалби
                    </fo:block>
                    <fo:block>
                        ______________________________________
                    </fo:block>
                    <fo:block text-align="left">
                        <xsl:variable name="appealState" select="re:ResenjeRoot//re:Status_zalbe"></xsl:variable>
                        <xsl:if test="$appealState ='PRIHVACENA'">
                            Решење када је жалба основана – налаже се:
                        </xsl:if>
                        <xsl:if test="$appealState ='ODBIJENA'">
                            Решење – одбија се као неоснована:
                        </xsl:if>
                    </fo:block>

                    <fo:block text-align="left">
                        <fo:inline-container inline-progression-dimension="65%">
                            <fo:block>
                                Бр.<xsl:value-of select="/re:ResenjeRoot//re:ID"/>/<xsl:value-of select="concat(substring($date,1,4),'-', substring($date,6,2))"/>
                            </fo:block>
                        </fo:inline-container>
                        <fo:inline-container inline-progression-dimension="15%">
                            <fo:block>
                                Датум <xsl:value-of select="concat(substring($date,9,2),'.',substring($date,6,2),'.',substring($date,1,4),'.')"/>године.
                            </fo:block>
                        </fo:inline-container>
                    </fo:block>

                    <fo:block margin-top="30px">
                        <xsl:copy>
                            <xsl:apply-templates select=" @* |re:ResenjeRoot//re:Opis_resenja"/>
                        </xsl:copy>
                    </fo:block>

                    <fo:block text-align="center"  margin-top="20px" font-family="Times New Roman" font-size="13px">
                        О Б Р А З Л О Ж Е Њ Е
                    </fo:block>

                    <fo:block margin-top="30px">
                        <fo:block>
                            <xsl:value-of select="/re:ResenjeRoot//re:Obrazlozenje//re:Opis_zalbe"/>

                        </fo:block>
                        <fo:block>
                            <xsl:value-of select="/re:ResenjeRoot//re:Obrazlozenje//re:Postupak_poverenika"/>

                        </fo:block>
                        <fo:block>
                            <xsl:copy>
                                <xsl:apply-templates select=" @* |re:ResenjeRoot//re:Obrazlozenje//re:Odgovor_na_zalbu"/>
                            </xsl:copy>
                        </fo:block>

                    </fo:block>

                    <fo:block margin-top="20px">
                        <xsl:value-of select="/re:ResenjeRoot//re:Uputstvo_o_pravnom_sredstvu"/>

                    </fo:block>



                    <fo:block font-family="Times New Roman" padding-top="10px">
                        <fo:inline-container inline-progression-dimension="65%">
                            <fo:block>

                            </fo:block>
                        </fo:inline-container>
                        <fo:inline-container>
                            <fo:block>
                                ПОВЕРЕНИК
                            </fo:block>
                            <fo:block>
                                <xsl:value-of select="/re:ResenjeRoot//re:Poverenik//sh:Ime"/> <xsl:value-of select="$space"/><xsl:value-of select="/re:ResenjeRoot//re:Poverenik//sh:Prezime"/>
                            </fo:block>
                        </fo:inline-container>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

    <xsl:template match="re:Razlozi">
       <fo:block>
            <xsl:for-each select="/re:ResenjeRoot//re:Obrazlozenje//re:Odgovor_na_zalbu/re:Razlozi/*">
               <fo:block margin-top="15px" indent="yes">
                    <xsl:value-of select="."/>
               </fo:block>
            </xsl:for-each>
       </fo:block>
    </xsl:template>

    <xsl:template match="re:Stavke_resenja">
        <fo:block text-align="center"  margin-top="20px" font-family="Times New Roman" font-size="13px">
            Р Е Ш Е Њ Е
        </fo:block>
        <xsl:for-each select="/re:ResenjeRoot//re:Opis_resenja/re:Stavke_resenja/*">
            <fo:block margin-top="15px" indent="yes">
                <xsl:value-of select="position()"/>.
                <xsl:value-of select="."/>
            </fo:block>
        </xsl:for-each>
    </xsl:template>

</xsl:stylesheet>