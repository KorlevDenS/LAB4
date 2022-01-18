import Lab4.*;
import Lab4.MainCharacterFriend;

public class Main {
    public static void main(String[] args) {
        MainCharacter Dunno = new MainCharacter("Незнайка", 135.5, 20);
        MainCharacterFriend Donut = new MainCharacterFriend("Пончик", 140.2);
        // создание водоёма и моста
        Reservoir reservoir = new Reservoir("сказочная река", 6, 4, 2000);
        Reservoir.Bridge bridge1 = reservoir.new Bridge(300.5, BridgeMaterials.STEEL);
        //
        System.out.println(Dunno.sitUnderBridge(bridge1));
        Dunno.reactToSituation(new LifeCase("сел", "под мост", 2021, 12, 25, DunnoEmotions.STRIVE));
        System.out.println(Dunno.strainMind());
        System.out.println(Dunno.know(new Song("Чика", "Артур Пирожков")));
        System.out.println(Dunno.sing(new Song("Чика", "Артур Пирожков")));
        Riddle riddle1 = new Riddle("У него два горба, В них и пища и вода", "Верблюд");
        System.out.println(Dunno.makeARiddle(DunnoRiddles.RIDDLE4));
        System.out.println(Dunno.solveARiddle(riddle1, "Конь"));
        Folklore proverb1 = new Folklore(DunnoFolklore.PROVERB3.getDescription());
        System.out.println(Dunno.tryToRememberSth(proverb1));
        LifeCase jump = new LifeCase("прыжок с парашютом", "Италия", 2014, 8, 8, DunnoEmotions.AFRAID);
        Dunno.knowledge.add(jump);
        System.out.println(Dunno.tryToRememberSth(jump));
        System.out.println(Dunno.tryToRememberSth(Donut));
        String situation = Donut.sitIntoRocket(new Rocket(30000, 1000, 153.4));
        System.out.println(Dunno.imagine(situation, "космос", 2021, 12, 25, DunnoEmotions.BORING));
        Dunno.reactToSituation(new LifeCase("не может помочь другу", "под мостом", 2021,
                12, 25, DunnoEmotions.GRIEVE));
        System.out.println(Donut.likeDoingSth(EntertainmentTypes.EAT));
        // Проверка работы кода 4 лабы
        // перехват проверяемого исключения
        FlashLight miniSun1 = new FlashLight(2);
        try {
            miniSun1.turnOn();
        } catch (EquipmentNotFoundException ex) {
            miniSun1.installTheLamp(70);
            System.out.println("Отсутствующая лампа установлена");
            miniSun1.turnedOn = true;
        }
        // работа со статическим внутренним классом
        Reservoir.Pair p = Reservoir.squareValue(5,2000, 4);
        System.out.println("Площадь такого водоёма = " + p.getFirst()
                + " метров квадратных, а объем = " + p.getSecond() + " метров кубических.");
        // работа с внутренними и локальными и анонимными классами
        Reservoir.Embankment riverBank = reservoir.new Embankment();
        System.out.println(riverBank.illuminate(70));
        System.out.println("Количество фонарей на набережной: " + riverBank.getNumberOfFlashLights());
        try {
            bridge1.turnOffLightning();
        } catch (EquipmentNotFoundException e) {
            bridge1.illuminate(100);
            System.out.println("Освещение моста установлено, проверено и выключено");
        }
        System.out.println(bridge1.illuminate(70));
        var lightManager = new CityLightningProcessor(18);
        lightManager.setCurrentHour(18);
        lightManager.manageAllTheLightning(riverBank, bridge1);
    }

}