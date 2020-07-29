package wawer.kamil.universitymanager.utils.generator.course;

import java.util.HashMap;
import java.util.Map;

public enum DefaultTeacherMap {

    Oskar_PRZYBYLSKI(0),
    Robert_GÓRECKA(1),
    Jacek_JASIŃSKI(2),
    Robert_CZERWIŃSKI(3),
    Alicja_SIKORA(4),
    Sławomir_KOWALSKA(5),
    Wiktoria_NOWICKA(6),
    Anastazja_ANDRZEJEWSKA(7),
    Laura_ZALEWSKA(8),
    Antonina_GRABOWSKA(9),
    Zofia_ZALEWSKA(10),
    Maria_BŁASZCZYK(11),
    Amelia_ZALEWSKI(12),
    Zofia_MAKOWSKI(13),
    Maria_BOROWSKI(14),
    Laura_DĄBROWSKA(15),
    Alicja_DĄBROWSKA(16),
    Magda_MAZUR(17),
    Lilianna_WOJCIECHOWSKA(18),
    Blanka_PIETRZAK(19),
    Jagoda_KOZŁOWSKA(20),
    Martyna_RUTKOWSKA(21),
    Tymon_TOMASZEWSKI(22),
    Łucja_BARAN(23),
    Matylda_OLSZEWSKA(24),
    Kaja_OSTROWSKI(25),
    Agata_JANKOWSKI(26),
    Zofia_OSTROWSKA(27),
    Zofia_JABŁOŃSKI(28),
    Kamil_DUDEK(29);

    private int index;
    private static Map<Integer, DefaultTeacherMap> map = new HashMap<>();

    DefaultTeacherMap(int index) {
        this.index = index;
    }

    static {
        for (DefaultTeacherMap firstName : DefaultTeacherMap.values()) {
            map.put(firstName.index, firstName);
        }
    }

    public static DefaultTeacherMap valueOf(Integer index) {
        return map.get(index);
    }
}
