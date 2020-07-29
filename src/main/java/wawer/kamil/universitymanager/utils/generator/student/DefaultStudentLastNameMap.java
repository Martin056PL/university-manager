package wawer.kamil.universitymanager.utils.generator.student;

import java.util.HashMap;
import java.util.Map;

public enum DefaultStudentLastNameMap {

    NOWAK(0),
    KOWALSKA(1),
    KOWALSKI(2),
    WIŚNIEWSKA(3),
    WIŚNIEWSKI(4),
    WÓJCIK(5),
    KOWALCZYK(6),
    KAMIŃSKA(7),
    KAMIŃSKI(8),
    LEWANDOWSKA(9),
    LEWANDOWSKI(10),
    DĄBROWSKA(11),
    DĄBROWSKI(12),
    ZIELIŃSKA(13),
    ZIELIŃSKI(14),
    SZYMAŃSKA(15),
    SZYMAŃSKI(16),
    WOŹNIAK(17),
    KOZŁOWSKA(18),
    KOZŁOWSKI(19),
    JANKOWSKA(20),
    JANKOWSKI(21),
    WOJCIECHOWSKA(22),
    MAZUR(23),
    KWIATKOWSKA(24),
    WOJCIECHOWSKI(25),
    KWIATKOWSKI(26),
    KRAWCZYK(27),
    PIOTROWSKA(28),
    KACZMAREK(29),
    PIOTROWSKI(30),
    GRABOWSKA(31),
    GRABOWSKI(32),
    PAWŁOWSKA(33),
    ZAJĄC(34),
    MICHALSKA(35),
    PAWŁOWSKI(36),
    MICHALSKI(37),
    KRÓL(38),
    NOWAKOWSKA(39),
    NOWAKOWSKI(40),
    WIECZOREK(41),
    JABŁOŃSKA(42),
    WRÓBEL(43),
    MAJEWSKA(44),
    JABŁOŃSKI(45),
    ADAMCZYK(46),
    DUDEK(47),
    NOWICKA(48),
    MAJEWSKI(49),
    NOWICKI(50),
    OLSZEWSKA(51),
    OLSZEWSKI(52),
    JAWORSKA(53),
    STĘPIEŃ(54),
    MALINOWSKA(55),
    JAWORSKI(56),
    MALINOWSKI(57),
    GÓRSKA(58),
    PAWLAK(59),
    GÓRSKI(60),
    WITKOWSKA(61),
    WITKOWSKI(62),
    WALCZAK(63),
    RUTKOWSKA(64),
    SIKORA(65),
    RUTKOWSKI(66),
    BRZEZIŃSKA(67),
    MAKOWSKI(68),
    PRZYBYLSKA(69),
    CZERWIŃSKI(70),
    SZYMCZAK(71),
    BARANOWSKI(72),
    BARANOWSKA(73),
    MRÓZ(74),
    BRZEZIŃSKI(75),
    BŁASZCZYK(76),
    KACZMARCZYK(77),
    BOROWSKA(78),
    PRZYBYLSKI(79),
    ANDRZEJEWSKA(80),
    CIEŚLAK(81),
    GÓRECKA(82),
    BOROWSKI(83),
    ANDRZEJEWSKI(84),
    MICHALAK(85),
    BARAN(86),
    OSTROWSKA(87),
    SZEWCZYK(88),
    OSTROWSKI(89),
    TOMASZEWSKA(90),
    TOMASZEWSKI(91),
    PIETRZAK(92),
    JASIŃSKA(93),
    DUDA(94),
    WRÓBLEWSKA(95),
    ZALEWSKI(96),
    ZALEWSKA(97),
    WRÓBLEWSKI(98),
    MARCINIAK(99),
    JASIŃSKI(100);

    private int index;
    private static Map<Integer, DefaultStudentLastNameMap> map = new HashMap<>();

    DefaultStudentLastNameMap(int index) {
        this.index = index;
    }

    static {
        for (DefaultStudentLastNameMap lastName : DefaultStudentLastNameMap.values()) {
            map.put(lastName.index, lastName);
        }
    }

    public static DefaultStudentLastNameMap valueOf(Integer index) {
        return map.get(index);
    }
}