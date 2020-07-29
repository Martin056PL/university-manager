package wawer.kamil.universitymanager.utils.generator.course;

import java.util.HashMap;
import java.util.Map;

public enum DefaultCourseNameMap {

    Fizyka(0),
    Funkcje_elementarne(1),
    Matematyka_I(2),
    Podstawy_elektrotechniki(3),
    Grafika_inżynierska(4),
    Wprowadzenie_do_mechatroniki(5),
    Nauka_o_materiałach_I(6),
    Bezpieczeństwo_i_higiena_pracy(7),
    Ochrona_własności_intelektualnej(8),
    Przysposobienie_biblioteczne(9),
    Matematyka_II(10),
    Postawy_metrologii(11),
    Wybrane_zagadnienia_diagnostyki_maszyn(12),
    Informatyka_I(13),
    Wstęp_do_komputerowego_projektowania_maszyn(14),
    Mechanika_techniczna(15),
    Nauka_o_materiałach_II(16),
    Elementy_przedsiębiorczości(17),
    Małe_i_średnie_przedsiębiorstwa(18),
    Zarządzanie_innowacjami(19),
    Systemy_innowacyjne(20),
    Język_angielski_I(21),
    Język_niemiecki_I(22),
    Informatyka_II(23),
    Techniki_wytwarzania_i_systemy_montażu(24),
    Wytrzymałość_materiałów(25),
    Rachunek_prawdopodobieństwa_i_statystyka(26),
    Wychowanie_fizyczne_I(27),
    Metrologia_wielkości_geometrycznych(28),
    Recykling(29),
    Podstawy_ekoinżynierii_i_zarządzanie_środowiskowe(30),
    Język_angielski_II(31),
    Język_niemiecki_II(32),
    Podstawy_automatyki(33),
    Podstawy_elektroniki(34),
    Podstawy_konstrukcji_maszyn(35),
    Metrologia_wielkości_elektrycznych(36),
    Wychowanie_fizyczne_II(37),
    Teoria_maszyn_i_mechanizmów(38),
    Niezawodność_systemów_logistycznych(39),
    Podstawy_logistyki(40),
    Język_angielski_III(41),
    Język_niemiecki_III(42),
    Podstawy_automatyzacji(43),
    Teoria_i_technika_sterowania(44),
    Napędy_elektryczne(45),
    Elementy_teorii_optymalizacji(46),
    Mechatronika__w_systemach_nadzoru_i_bezpieczeństwa(47),
    Mechatronika_w_medycynie(48),
    Język_angielski_IV(49),
    Język_niemiecki_IV(50),
    Zagadnienia_eksploatacji_maszyn_w_konstrukcji_zespołów_mechatronicznych(51),
    Elementy_teorii_niezawodności(52),
    Wirtualne_prototypowanie_maszyn_i_mechanizmów(53),
    Metoda_elementów_skończonych(54),
    Cyfrowe_przetwarzanie_sygnałów(55),
    Projekt_inżynierski_I(56),
    Instalacje_elektryczne_i_układy_zasilania(57),
    Elementy_systemów_zapewnienia_jakości(58),
    Komputerowe_systemy_wspomagania_projektowania_maszyn(59),
    Podstawy_techniki_mikroprocesorowej(60),
    Systemy_wbudowane(61),
    Projektowanie_systemów_mechatronicznych(62),
    Projektowanie_mechatronicznych_stanowisk_badawczych(63),
    Czujniki_optoelektryczne(64),
    Technika_światłowodowa(65),
    Bezpieczeństwo_użytkowania_urządzeń_elektrycznych(66),
    Podstawy_robotyki(67),
    Kompatybilność_elektromagnetyczna_systemów_mechatronicznych(68),
    Seminarium(69),
    Projekt_inżynierski_II(70),
    Systemy_mikroelektromechaniczne(71),
    Czujniki_i_aktuatory299(72),
    Wirtualne_systemy_sterowania_i_nadzoru(73),
    Podstawy_monitorowania_i_diagnostyki_układów_mechatronicznych(74),
    Podstawy_programowania_niskopoziomowego(75);

    private int index;
    private static Map<Integer, DefaultCourseNameMap> map = new HashMap<>();

    DefaultCourseNameMap(int index) {
        this.index = index;
    }

    static {
        for (DefaultCourseNameMap defaultCourseNameMap : DefaultCourseNameMap.values()) {
            map.put(defaultCourseNameMap.index, defaultCourseNameMap);
        }
    }

    public static DefaultCourseNameMap valueOf(Integer index) {
        return map.get(index);
    }
}
