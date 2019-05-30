package oby_na_trzy.crm.resource;

import oby_na_trzy.crm.model.Faktura;
import oby_na_trzy.crm.model.Klienci;
import oby_na_trzy.crm.model.Telefony;
import oby_na_trzy.crm.repository.HistoriaRepository;
import oby_na_trzy.crm.repository.KlienciRepository;
import oby_na_trzy.crm.repository.TelefonyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/faktura")
public class FakturaResource {

    @Autowired
    HistoriaRepository historiaRepository;
    @Autowired
    KlienciRepository klienciRepository;
    @Autowired
    TelefonyRepository telefonyRepository;

    @GetMapping(value = "/getfacture/{id}")
    public Faktura getFacture(@PathVariable("id") int id){
        Klienci klient = klienciRepository.findById(id);
        List<Telefony> telefony_a = telefonyRepository.findAllByIdKlienta(id);
        ArrayList<Float> koszta = new ArrayList<>();
        ArrayList<String> telefony = new ArrayList<>();
        Float koszt = 0f;

        for (Telefony telefon: telefony_a) {
            koszta.add(historiaRepository.findAllByIdSumHistoria(telefon.getId()));
            telefony.add(telefon.getNumer());
            koszt += historiaRepository.findAllByIdSumHistoria(telefon.getId());
        }
        Faktura faktura = new Faktura();

        faktura.setImie(klient.getImie());
        faktura.setNazwisko(klient.getNazwisko());
        faktura.setAdres_zam(klient.getAdres_zam());
        faktura.setPesel(klient.getPesel());
        faktura.setTelefony(telefony);
        faktura.setOplaty(koszta);
        faktura.setOplata(koszt);

        return faktura;
    }


}
