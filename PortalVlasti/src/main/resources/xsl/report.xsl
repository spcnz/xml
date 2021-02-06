<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:ns2="http://www.izvestaj.com" version="2.0">

    <xsl:template match="/">
        <html>
            <head>
                <title>Report</title>
                <style type="text/css">
                    .styled-table {
                    border-collapse: collapse;
                    margin: 0 auto;
                    font-size: 0.9em;
                    font-family: sans-serif;
                    width:60%;
                    padding: 15px;
                    text-align:center;
                    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
                    }
                    .styled-table thead tr {
                    background-color: #009879;
                    color: #ffffff;
                    text-align: left;
                    }
                    .styled-table tbody tr {
                    border-bottom: 1px solid #dddddd;
                    }

                    .styled-table tbody tr:nth-of-type(even) {
                    background-color: #f3f3f3;
                    }

                    .styled-table tbody tr:last-of-type {
                    border-bottom: 2px solid #009879;
                    }




                </style>
            </head>
            <xsl:variable name="date" select="/ns2:IzvestajRoot/@content"/>
            <xsl:variable name="d1" select="concat(substring($date,9,2),'.',substring($date,6,2),'.',substring($date,1,4),'.')"/>

            <body>
                <h1 style="text-align:center">Podneti Izveštaj od <xsl:value-of select="$d1" /></h1>
                <h2 style="text-align:center;padding-top:15px">Zahtevi</h2>
                <table class="styled-table">
                    <tr>
                        <th>Podneti Zahtevi</th>
                        <th>Odbijeni Zahtevi</th>
                    </tr>
                    <tr>
                        <td>
                            <xsl:value-of select="//ns2:Izvestaj/ns2:FizickoLice/ns2:BrojZahteva" />
                        </td>

                        <td>
                            <xsl:value-of select="//ns2:Izvestaj/ns2:FizickoLice/ns2:BrojOdbijenihZahteva" />
                        </td>
                    </tr>
                </table>

                <h2 style="text-align:center">Žalbe</h2>
                <table class="styled-table">
                    <tr>
                        <th></th>
                        <th>Žalbe na Odluku</th>
                        <th>Žalbe na Ćutanje</th>
                    </tr>
                    <tr>
                        <td>
                            Fizičko Lice
                        </td>

                        <td>
                            <xsl:value-of select="//ns2:Izvestaj/ns2:FizickoLice/ns2:BrojZalbiOdluka" />
                        </td>
                        <td>
                            <xsl:value-of select="//ns2:Izvestaj/ns2:FizickoLice/ns2:BrojZalbiCutanje" />
                        </td>

                    </tr>

                    <tr>
                        <td>
                            Pravno Lice
                        </td>

                        <td>
                            <xsl:value-of select="//ns2:Izvestaj/ns2:PravnoLice/ns2:BrojZalbiOdluka" />
                        </td>
                        <td>
                            <xsl:value-of select="//ns2:Izvestaj/ns2:PravnoLice/ns2:BrojZalbiCutanje" />
                        </td>

                    </tr>
                </table>

            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>