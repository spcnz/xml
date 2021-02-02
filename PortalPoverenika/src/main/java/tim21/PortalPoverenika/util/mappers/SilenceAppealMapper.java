package tim21.PortalPoverenika.util.mappers;

import tim21.PortalPoverenika.model.decisionAppeal.TTextZalbe;
import tim21.PortalPoverenika.model.decisionAppeal.TZalba;
import tim21.PortalPoverenika.model.decisionAppeal.ZalbaRoot;
import tim21.PortalPoverenika.model.shared.Tacka;

import java.io.Serializable;
import java.util.List;

public class SilenceAppealMapper {

    public static ZalbaRoot addStaticText(ZalbaRoot rootAppeal) {
        TZalba appeal = rootAppeal.getZalba();
        appeal.setNaslov("ЖАЛБА  ПРОТИВ  ОДЛУКЕ ОРГАНА  ВЛАСТИ КОЈОМ ЈЕ\n" +
                "   ОДБИЈЕН ИЛИ ОДБАЧЕН ЗАХТЕВ ЗА ПРИСТУП ИНФОРМАЦИЈИ");
        appeal.getPrimaoc().setUloga("Поверенику за информације од јавног значаја и заштиту података о личности");
        appeal.setPodnaslov("ЖАЛБА");

        TTextZalbe contentWithStatic = new TTextZalbe();
        List<Serializable> content = contentWithStatic.getContent();

        content.add(" Наведеном одлуком органа власти (решењем, закључком, обавештењем у писаној форми са елементима одлуке) , супротно закону, одбијен-одбачен је мој захтев који сам\n" +
                " поднео/ла-упутио/ла дана");

        content.add(appeal.getTekstZalbe().getContent().get(1));
        content.add("године и тако ми ускраћено-онемогућено остваривање уставног и законског права на слободан приступ информацијама од јавног значаја.\n" +
                "    Oдлуку побијам у целости, односно у делу којим");
        content.add(appeal.getTekstZalbe().getContent().get(3));

        content.add(" jер није заснована на Закону о слободном приступу информацијама од јавног значаја.\n" +
                "                На основу изнетих разлога, предлажем да Повереник уважи моју жалбу,  поништи одлука првостепеног органа и омогући ми приступ траженој/им  информацији/ма.\n" +
                "                Жалбу подносим благовремено, у законском року утврђеном у члану 22. ст. 1. Закона о слободном приступу информацијама од јавног значаја.");

        appeal.setTekstZalbe(contentWithStatic);

        Tacka first = new Tacka();
        first.setValue("У жалби се мора навести одлука која се побија (решење, закључак, обавештење), назив органа који је одлуку донео, као и број и датум одлуке. Довољно је да жалилац наведе у жалби у ком погледу је незадовољан одлуком, с тим да жалбу не мора посебно образложити. ");
        appeal.getNapomena().getTacka().add(first);
        Tacka second = new Tacka();
        second.setValue("Уз жалбу обавезно приложити копију поднетог захтева и доказ о његовој предаји-упућивању органу као и копију одлуке органа која се оспорава жалбом.");
        appeal.getNapomena().getTacka().add(second);

        return rootAppeal;
    }
}
