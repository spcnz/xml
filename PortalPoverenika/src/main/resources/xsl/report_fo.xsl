<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:ns2="http://www.izvestaj.com"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">

    <xsl:variable name="date" select="/ns2:IzvestajRoot/@content"/>
    <xsl:variable name="d1" select="concat(substring($date,9,2),'.',substring($date,6,2),'.',substring($date,1,4),'.')"/>

    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="bookstore-page">
                    <fo:region-body margin="0.75in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

                <fo:page-sequence master-reference="bookstore-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-family="Times New Roman" font-size="24px" font-weight="bold" padding="10px" text-align="center">
                        Podneti Izveštaj od <xsl:value-of select="$d1" />
                    </fo:block>

                    <fo:block font-family="Times New Roman" font-size="20px" font-weight="bold" padding-top="20px" text-align="center">
                        Zahtevi
                    </fo:block>

                    <fo:block padding-bottom="15px">
                        <fo:table font-family="Times New Roman" border="1px">
                            <fo:table-column column-width="33%"/>
                            <fo:table-column column-width="33%"/>

                            <fo:table-body>
                                <fo:table-row border="1px solid darkgrey">
                                    <fo:table-cell background-color="#dbdbdb"  color="black" padding="10px" font-weight="bold">
                                        <fo:block>Zahtevi</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell background-color="#dbdbdb"  color="black" padding="10px" font-weight="bold">
                                        <fo:block>Odbijeni Zahtevi</fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row border="1px solid darkgrey">
                                    <fo:table-cell padding="10px">
                                        <fo:block>
                                            <xsl:value-of select="//ns2:Izvestaj/ns2:FizickoLice/ns2:BrojZahteva" />
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="10px">
                                        <fo:block>
                                            <xsl:value-of select="//ns2:Izvestaj/ns2:FizickoLice/ns2:BrojOdbijenihZahteva" />
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
                    <fo:block font-family="Times New Roman" font-size="20px" font-weight="bold" padding="10px" text-align="center">
                        Žalbe
                    </fo:block>
                    <fo:block padding-bottom="15px">
                        <fo:table font-family="Times New Roman"  border="1px">
                            <fo:table-column column-width="25%"/>
                            <fo:table-column column-width="25%"/>
                            <fo:table-column column-width="25%"/>

                            <fo:table-body>
                                <fo:table-row border="1px solid darkgrey">
                                    <fo:table-cell background-color="#dbdbdb"  color="black" padding="10px" font-weight="bold">
                                        <fo:block></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell background-color="#dbdbdb"   color="black" padding="10px" font-weight="bold">
                                        <fo:block>Žalbe na Odluku</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell background-color="#dbdbdb"  color="black" padding="10px" font-weight="bold">
                                        <fo:block>Žalbe na Ćutanje</fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row border="1px solid darkgrey">
                                    <fo:table-cell padding="10px">
                                        <fo:block>
                                            Fizičko Lice
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="10px">
                                        <fo:block>
                                            <xsl:value-of select="//ns2:Izvestaj/ns2:FizickoLice/ns2:BrojZalbiOdluka" />
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="10px">
                                        <fo:block>
                                            <xsl:value-of select="//ns2:Izvestaj/ns2:FizickoLice/ns2:BrojZalbiCutanje" />
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row border="1px solid darkgrey">
                                    <fo:table-cell padding="10px">
                                        <fo:block>
                                            Pravno Lice
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="10px">
                                        <fo:block>
                                            <xsl:value-of select="//ns2:Izvestaj/ns2:PravnoLice/ns2:BrojZalbiOdluka" />
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="10px">
                                        <fo:block>
                                            <xsl:value-of select="//ns2:Izvestaj/ns2:PravnoLice/ns2:BrojZalbiCutanje" />
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>


                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>