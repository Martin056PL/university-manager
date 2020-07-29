package wawer.kamil.universitymanager.utils.generator.student;

import java.util.HashMap;
import java.util.Map;

public enum DefaultStudentFirstNameMap {

    Magda(0),
    Aleksandra(1),
    Wiktoria(2),
    Emilia(3),
    Laura(4),
    Natalia(5),
    Antonina(6),
    Pola(7),
    Lilianna(8),
    Iga(9),
    Marcelina(10),
    Anna(11),
    Gabriela(12),
    Helena(13),
    Michalina(14),
    Nadia(15),
    Kornelia(16),
    Milena(17),
    Martyna(18),
    Klara(19),
    Nikola(20),
    Jagoda(21),
    Łucja(22),
    Barbara(23),
    Karolina(24),
    Agata(25),
    Magdalena(26),
    Weronika(27),
    Kaja(28),
    Blanka(29),
    Nela(30),
    Nina(31),
    Anastazja(32),
    Kinga(33),
    Sara(34),
    Paulina(35),
    Matylda(36),
    Małgorzata(37),
    Joanna(38),
    Aniela(39),
    Zuzanna(40),
    Julia(41),
    Maja(42),
    Zofia(43),
    Hanna(44),
    Lena(45),
    Alicja(46),
    Maria(47),
    Amelia(48),
    Oliwia(49),
    Żaneta(50),
    Antoni(51),
    Jakub(52),
    Jan(53),
    Szymon(54),
    Aleksander(55),
    Franciszek(56),
    Filip(57),
    Mikołaj(58),
    Wojciech(59),
    Kacper(60),
    Przemysław(61),
    Piotr(62),
    Patryk(63),
    Paweł(64),
    Stefan(65),
    Sergiusz(66),
    Sylwester(67),
    Seweryn(68),
    Stanisław(69),
    Tomasz(70),
    Sebastian(71),
    Sławomir(72),
    Tymoteusz(73),
    Tadeusz(74),
    Teodor(75),
    Tymon(76),
    Witold(77),
    Władysław(78),
    Adam(79),
    Walerian(80),
    Wiktor(81),
    Ziemowit(82),
    Zbigniew(83),
    Henryk(84),
    Bartosz(85),
    Marian(86),
    Jacek(87),
    Leonard(88),
    Kamil(89),
    Marcin(90),
    Marek(91),
    Tobaisz(92),
    Radosław(93),
    Robert(94),
    Michał(95),
    Joahim(96),
    Matuesz(97),
    Oskar(98),
    Włodzimierz(99),
    Mirosław(100);

    private int index;
    private static Map<Integer, DefaultStudentFirstNameMap> map = new HashMap<>();

    DefaultStudentFirstNameMap(int index) {
        this.index = index;
    }

    static {
        for (DefaultStudentFirstNameMap firstName : DefaultStudentFirstNameMap.values()) {
            map.put(firstName.index, firstName);
        }
    }

    public static DefaultStudentFirstNameMap valueOf(Integer index) {
        return map.get(index);
    }
}
