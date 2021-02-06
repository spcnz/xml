<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:za="http://www.zalbanaodluku.com"
                xmlns:sh="http://www.shared.com"
                version="2.0">
<xsl:template match="/">
    <html>
        <head>
            <title>Zalba na odluku</title>
            <style type="text/css">
                html {
                font-family: Times New Roman;
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
            <xsl:variable name="date" select="/za:ZalbaRoot/za:Zalba//za:Datum_podnosenja_zahteva"/>
            <xsl:variable name="d1" select="concat(substring($date,9,2),'.',substring($date,6,2),'.',substring($date,1,4),'.')"/>
            <div style="width: 50%; padding-left:30%;font-family:Times New Roman">
                <p style="font-size:15px;text-align:center; font-weight:bold" >
                    ЖАЛБА  ПРОТИВ  ОДЛУКЕ ОРГАНА  ВЛАСТИ КОЈОМ ЈЕ
                        ОДБИЈЕН ИЛИ ОДБАЧЕН ЗАХТЕВ ЗА ПРИСТУП ИНФОРМАЦИЈИ
                </p>
                <p style="font-size:15px;font-weight:bold;padding-top:10px; margin-top:10px">
                    <xsl:value-of select="za:ZalbaRoot/za:Zalba/za:Primaoc/sh:Uloga" />
                </p>
                <p style="font-size:15px" >
                    Адреса за пошту:  <xsl:value-of select="za:ZalbaRoot/za:Zalba//sh:Adresa/sh:Grad"/>,  <xsl:value-of select="za:ZalbaRoot/za:Zalba//sh:Adresa/sh:Ulica"/>, бр. <xsl:value-of select="za:ZalbaRoot/za:Zalba//sh:Adresa/sh:Broj"/>, <xsl:value-of select="za:ZalbaRoot/za:Zalba//sh:Adresa/sh:Postanski_broj"/>
                </p>
                <h2 style="padding-top:17px;text-align:center">
                    Ж А Л Б А
                </h2>
                <p style="padding-top:15px;font-size:16px;font-weight:bold;text-align:center">
                    <xsl:choose>
                        <xsl:when test="boolean(za:ZalbaRoot/za:Zalba/za:Fizicko_lice)">
                            <div class="underline">
                                <xsl:variable name="name" select="za:ZalbaRoot/za:Zalba/za:Fizicko_lice/sh:Ime"/>
                                <xsl:variable name="lastName" select="za:ZalbaRoot/za:Zalba/za:Fizicko_lice/sh:Prezime"/>
                                (<xsl:value-of select="concat($name, ' ', $lastName)"/>
                            </div>
                            <div class="underline">
                                <xsl:variable name="city" select="za:ZalbaRoot/za:Zalba/za:Fizicko_lice/sh:Adresa/sh:Grad"/>
                                <xsl:variable name="street" select="za:ZalbaRoot/za:Zalba/za:Fizicko_lice/sh:Adresa/sh:Ulica"/>
                                <xsl:variable name="streetNum" select="za:ZalbaRoot/za:Zalba/za:Fizicko_lice/sh:Adresa/sh:Broj"/>
                                <xsl:variable name="postCode" select="za:ZalbaRoot/za:Zalba/za:Fizicko_lice/sh:Adresa/sh:Postanski_broj"/>

                                <xsl:value-of select="concat($street, ' ', $streetNum, ', ', $city, ', ', $postCode)"/>)
                            </div>
                        </xsl:when>
                        <xsl:otherwise>
                            <div class="underline">
                            (<u><xsl:value-of select="za:ZalbaRoot/za:Zalba/za:Pravno_lice/sh:Naziv"/></u>)
                            </div>
                        </xsl:otherwise>
                    </xsl:choose>
                </p>
                <p style="font-size:16px;text-align:center">
                    (Име, презиме, односно назив,седиште жалиоца и адреса)
                </p>
                <p style="padding-top:15px;font-size:16px;text-align:center">
                    против решења-закључка
                </p>
                <p style="padding-top:30px;font-size:16px;text-align:center" class="underline">
                   Naziv organa vlasti
                </p>
                <p style="font-size:16px;text-align:center" >
                    (назив органа који је донео одлуку)
                </p>
                <p style="padding-top:15px;font-size:16px;text-align:justify">
                    Број
                    <xsl:variable name="requestID" select="za:ZalbaRoot/@href"/>
                    <u><xsl:value-of select="substring($requestID, 16)" /></u>
                    од
                    <xsl:value-of select="$d1"/>
                    године.
                </p>
                <p style="padding-top:15px;font-size:16px;text-align:justify">
                        Наведеном одлуком органа власти (решењем, закључком, обавештењем у писаној форми са елементима
                    одлуке) , супротно закону, одбијен-одбачен је мој захтев који сам поднео/ла-упутио/ла дана
                    <u><xsl:value-of select="$d1"/></u>
                    године и тако ми ускраћено-онемогућено остваривање уставног и законског права на слободан
                    приступ информацијама од јавног значаја. Oдлуку побијам у целости, односно у делу којим.
                    <div class="underline" style="margin-top:10px;margin-bottom:10px;">
                        <xsl:value-of select="/za:ZalbaRoot//za:Osnova_zalbe"/>
                    </div>
                    јер није заснована на Закону о слободном приступу информацијама од јавног значаја.
                </p>
                <p style="padding-top:15px;font-size:16px;text-align:justify">
                        На основу изнетих разлога, предлажем да Повереник уважи моју жалбу,  поништи одлука првостепеног
                    органа и омогући ми приступ траженој/им  информацији/ма.
                </p>
                <p style="padding-top:15px;font-size:16px;text-align:justify">
                        Жалбу подносим благовремено, у законском року утврђеном у члану 22. ст. 1.
                    Закона о слободном приступу информацијама од јавног значаја.
                </p>

                <div style="width=50%;float:right;padding-top:20px">
                    <p style="padding-top:30px" class="underline">
                        <xsl:value-of select="/za:ZalbaRoot//za:Podnosilac/sh:Ime"/><xsl:value-of select="$space"/>
                        <xsl:value-of select="/za:ZalbaRoot//za:Podnosilac/sh:Prezime"/>
                    </p>
                    Подносилац жалбе / Име и презиме
                    <p style="padding-top:15px" class="underline">
                        <xsl:value-of select="/za:ZalbaRoot//za:Podnosilac/sh:Adresa/sh:Ulica"/>,
                        <xsl:value-of select="/za:ZalbaRoot//za:Podnosilac/sh:Adresa/sh:Broj"/>,
                        <xsl:value-of select="/za:ZalbaRoot//za:Podnosilac/sh:Adresa/sh:Grad"/>,
                        <xsl:value-of select="/za:ZalbaRoot//za:Podnosilac/sh:Adresa/sh:Postanski_broj"/>
                    </p>
                    адреса
                    <p style="padding-top:15px" class="underline">
                        <xsl:value-of select="/za:ZalbaRoot//za:Podnosilac/sh:drugi_podaci_za_kontakt"/>
                    </p>
                    други подаци за контакт
                    <p style="padding-top:15px" class="underline">

                    </p>
                    <p>
                        Потпис
                    </p>
                </div>

                <div style="font-size:15px;height:150px;padding-top:50px"  >
                    <xsl:variable name="date" select="/za:ZalbaRoot//za:Datum"/>
                    <xsl:variable name="d2" select="concat(substring($date,9,2),'.',substring($date,6,2),'.',substring($date,1,4),'.')"/>
                    У <u><xsl:value-of select="/za:ZalbaRoot//za:Grad"/></u>,
                    дана   <u><xsl:value-of select="$d2"/></u>

                </div>

                <p style="font-size:16px ;margin-top:30px">
                    <b>Напомена:</b>
                </p>
                <p style="font-size:16px">
                        •	У жалби се мора навести одлука која се побија (решење, закључак, обавештење),
                    назив органа који је одлуку донео, као и број и датум одлуке. Довољно је да жалилац
                    наведе у жалби у ком погледу је незадовољан одлуком, с тим да жалбу не мора посебно образложити.
                    Ако жалбу изјављује на овом обрасцу, додатно образложење може  посебно приложити.
                </p>
                <p style="font-size:16px">
                        •	Уз жалбу обавезно приложити копију поднетог захтева и доказ о његовој предаји-упућивању
                    органу као и копију одлуке органа која се оспорава жалбом.
                </p>
            </div>
        </body>
    </html>
</xsl:template>
</xsl:stylesheet>