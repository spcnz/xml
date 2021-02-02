package tim21.PortalPoverenika.util.mappers;

import org.apache.jena.assembler.JA;
import tim21.PortalPoverenika.model.silenceAppeal.ObjectFactory;
import tim21.PortalPoverenika.model.silenceAppeal.TZalbaCutanje;
import tim21.PortalPoverenika.model.silenceAppeal.ZalbaCutanjeRoot;

import javax.xml.bind.JAXBElement;
import java.io.Serializable;
import java.util.List;

public class SilenceAppealMapper {

    public static ZalbaCutanjeRoot addStaticText(ZalbaCutanjeRoot rootAppeal) {
        ObjectFactory factory = new ObjectFactory();

        TZalbaCutanje appeal = rootAppeal.getZalbaCutanje();
        TZalbaCutanje.Naziv heading = new TZalbaCutanje.Naziv();
        heading.setValue("            ЖАЛБА КАДА ОРГАН ВЛАСТИ НИЈЕ ПОСТУПИО/ није поступио у целости/ ПО ЗАХТЕВУ ТРАЖИОЦА У ЗАКОНСКОМ  РОКУ  (ЋУТАЊЕ УПРАВЕ)\n");
        appeal.getPrimaoc().setUloga("Поверенику за информације од јавног значаја и заштиту података о личности");

        TZalbaCutanje.Sadrzaj contentWithStatic = new TZalbaCutanje.Sadrzaj();
        List<Serializable> content = contentWithStatic.getContent();

        content.add("У складу са чланом 22. Закона о слободном приступу информацијама од јавног значаја подносим:");
        TZalbaCutanje.Sadrzaj.Podnaslov subheading = new TZalbaCutanje.Sadrzaj.Podnaslov();
        subheading.setValue("Ж А Л Б У");

        content.add(factory.createTZalbaCutanjeSadrzajPodnaslov(subheading));
        content.add("против");

        content.add(appeal.getSadrzaj().getContent().get(3));
        content.add("због тога што орган власти:");
        content.add(appeal.getSadrzaj().getContent().get(5));

        content.add("(подвући  због чега се изјављује жалба) по мом захтеву  за слободан приступ информацијама од јавног значаја који сам поднео  том органу  дана ");

        content.add(appeal.getSadrzaj().getContent().get(7));
        content.add("   године, а којим сам тражио/ла да ми се у складу са Законом о слободном приступу информацијама од јавног значаја омогући увид- копија документа који садржи информације  о /у вези са :");
        content.add(appeal.getSadrzaj().getContent().get(9));

        content.add(" (навести податке о захтеву и информацији/ама)\n" +
                "            \n" +
                "            На основу изнетог, предлажем да Повереник уважи моју жалбу и омогући ми приступ траженој/им  информацији/ма.\n" +
                "            Као доказ , уз жалбу достављам копију захтева са доказом о предаји органу власти.");

        TZalbaCutanje.Sadrzaj.Istaknuto note = new TZalbaCutanje.Sadrzaj.Istaknuto();
        note.setValue("Напомена:");

        content.add(factory.createTZalbaCutanjeSadrzajIstaknuto(note));
        content.add("Код жалбе  због непоступању по захтеву у целости, треба приложити и добијени одговор органа власти");

        content.add(appeal.getSadrzaj().getContent().get(13));
        content.add(appeal.getSadrzaj().getContent().get(14));
        content.add(appeal.getSadrzaj().getContent().get(15));


        appeal.setSadrzaj(contentWithStatic);

        return rootAppeal;
    }
}
