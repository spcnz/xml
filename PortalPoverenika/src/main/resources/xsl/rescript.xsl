<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:re="http://www.resenje.com"
                xmlns:sh="http://www.shared.com"
                version="2.0">
<xsl:template match="/">
<html>
    <head>
        <title>RESENJE</title>
        <style type="text/css">
            html {
                font-family: Times New Roman;
                margin-left:20%;
                letter-spacing:0.05pt;
                margin-top:30px;
            }
            .underline{
                border-bottom: 1px dotted;
                width: 100%;
                display: block;
            }
            hr {
                display: block;
                height: 1px;
                border: 0;
                border-top: 2px solid black;
                padding: 0;
            }

        </style>
    </head>
    <body>
        <xsl:variable name="space" select="'&#xA0;'"/>
        <xsl:variable name="date" select="/re:ResenjeRoot//re:Datum"/>
        <div style="width: 70%;">
            <p style="text-align:justify">Примери поступања Повереника по жалби</p>
            <hr/>
            <p>
                <xsl:variable name="appealState" select="re:ResenjeRoot//re:Status_zalbe"></xsl:variable>
                <xsl:if test="$appealState ='PRIHVACENA'">
                    Решење када је жалба основана – налаже се:
                </xsl:if>
                <xsl:if test="$appealState ='ODBIJENA'">
                    Решење – одбија се као неоснована:
                </xsl:if>
            </p>
            <div style="float: left; width:75%">
                <p>
                    Бр.<xsl:value-of select="/re:ResenjeRoot//re:ID"/>/<xsl:value-of select="concat(substring($date,1,4),'-', substring($date,6,2))"/>
                </p>
            </div>
            <div style="float: right% width:30%">
                <p>Датум <xsl:value-of select="concat(substring($date,9,2),'.',substring($date,6,2),'.',substring($date,1,4),'.')"/>године.
                </p>
            </div>

            <div style="text-align:justify; margin-top:50px" >
                <p style=" text-indent: 30px;">
                <xsl:copy>
                    <xsl:apply-templates select=" @* |re:ResenjeRoot//re:Opis_resenja"/>
                </xsl:copy>
                </p>
            </div>


            <div>
                <h4 style="text-align:center">
                    О Б Р А З Л О Ж Е Њ Е
                </h4>

                <div style="text-align:justify " >
                    <p style=" text-indent: 30px;">
                        <xsl:value-of select="/re:ResenjeRoot//re:Obrazlozenje//re:Opis_zalbe"/>
                    </p>
                    <p style=" text-indent: 30px;">
                        <xsl:value-of select="/re:ResenjeRoot//re:Obrazlozenje//re:Postupak_poverenika"/>
                    </p>

                    <xsl:copy>
                        <xsl:apply-templates select=" @* |re:ResenjeRoot//re:Obrazlozenje//re:Odgovor_na_zalbu"/>
                    </xsl:copy>
                </div>
            </div>
            <div>
                <p style=" text-indent: 30px;">
                    <xsl:value-of select="/re:ResenjeRoot//re:Uputstvo_o_pravnom_sredstvu"/>
                </p>
            </div>

            <div style="float:right">
                <p>ПОВЕРЕНИК</p>
                <p><xsl:value-of select="/re:ResenjeRoot//re:Poverenik//sh:Ime"/> <xsl:value-of select="$space"/><xsl:value-of select="/re:ResenjeRoot//re:Poverenik//sh:Prezime"/> </p>
            </div>


                </div>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="re:Razlozi">
        <p style=" text-indent: 30px;">
            <xsl:for-each select="/re:ResenjeRoot//re:Obrazlozenje//re:Odgovor_na_zalbu/re:Razlozi/*">
            <p style=" text-indent: 30px;">
                <xsl:value-of select="."/>
            </p>
        </xsl:for-each>
        </p>
    </xsl:template>

    <xsl:template match="re:Stavke_resenja">
        <h4 style="text-align:center">
            Р Е Ш Е Њ Е
        </h4>
        <xsl:for-each select="/re:ResenjeRoot//re:Opis_resenja/re:Stavke_resenja/*">
            <p style=" text-indent: 30px;">
                <xsl:value-of select="position()"/>.
                <xsl:value-of select="."/>
            </p>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>