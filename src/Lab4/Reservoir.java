package Lab4;

public class Reservoir {

    private final String name;
    private final int depth;
    private final int width;
    private final int length;

    public Reservoir(String name, int depth, int width, int length) throws IncorrectDataForObjectException {
        if ((depth < 1)||(depth > 10000)||(width < 2)||(length < 0))
            throw new IncorrectDataForObjectException("Reservoirs with such params cannot exist.");
        this.name = name;
        this.depth = depth;
        this.width = width;
        this.length = length;
    }

    public Reservoir(int depth, int width, int length) throws IncorrectDataForObjectException {
        if ((depth < 1)||(depth > 10000)||(width < 2)||(length < 0))
            throw new IncorrectDataForObjectException("Reservoirs with such params cannot exist.");
        this.name = "unknown";
        this.depth = depth;
        this.width = width;
        this.length = length;
    }

    public class Embankment implements Illuminated {

        private final FlashLight[] embankmentLighting;
        private final int length;

        public Embankment() {
            this.length = Reservoir.this.length;
            this.embankmentLighting = new FlashLight[2 * (length / 10)];
            for (int i = 0; i < 2 * (length / 10); i++) {
                embankmentLighting[i] = new FlashLight(4);
                embankmentLighting[i].installTheLamp(70);
            }
        }

        public String illuminate(int brightness) {
            for (FlashLight flashlight : embankmentLighting) {
                try {
                    flashlight.turnOn();
                } catch (EquipmentNotFoundException e) {
                    flashlight.installTheLamp(brightness);
                    System.out.println("Отсутвующая лампа установлена");
                    flashlight.turnedOn = true;
                }
            }
            return "Вдоль набережной зажглись фоанри и осветили её.";
        }

        public String turnOffLightning() throws EquipmentNotFoundException {
            if (embankmentLighting == null) throw new EquipmentNotFoundException();
            for (FlashLight flashlight : embankmentLighting) {
                flashlight.turnOff();
            }
            return "Освещенеи набережной выключено.";
        }

        public int getNumberOfFlashLights() {
            return 2 * (this.length / 10);
        }

    }

    public class Bridge implements Illuminated{

        private final Double height;
        private final String material;
        private final int width;
        private FlashLight[] bridgeFlashlights;

        public Bridge(Double height, BridgeMaterials material) {
            this.material = material.getMaterial();
            this.height = height;
            this.width = Reservoir.this.width;
        }

        public String addFlashlights(int height) throws IncorrectDataForObjectException{
            if ((height < 1)||(height > 20))
                throw new IncorrectDataForObjectException("Flashlights with such height cannot exist.");
            this.bridgeFlashlights = new FlashLight[2 * (width / 10) ];
            for (int i = 0; i < 2 * (width / 10); i++) {
                bridgeFlashlights[i] = new FlashLight(height);
            }
            return "На мосту теперь установлены фонари.";
        }

        public String illuminate(int brightness) {
            if (bridgeFlashlights == null)
            System.out.println(this.addFlashlights(4));
            for (FlashLight flashlight : bridgeFlashlights) {
                try {
                    flashlight.turnOn();
                } catch (EquipmentNotFoundException e) {
                    flashlight.installTheLamp(brightness);
                    System.out.println("Отсутвующая лампа установлена");
                    flashlight.turnedOn = true;
                }
            }

                var reflectedLight = new Illuminated() {

                    private String reflect() {
                        return "Свет фонарей отразился в воде с яркостью " + brightness / 2 + ".";
                    }

                    public String illuminate(int brightness) {
                        if ((brightness / 2 <= 50)&&(brightness / 2>35))
                            return reflect() + " Под мостом стало светло.";
                        else return reflect() + " По мостом стало не совсем темно.";
                    }
                };
            return "На мосту зажглись фоанри и осветили его. " + reflectedLight.illuminate(brightness);
        }

        public String turnOffLightning() throws EquipmentNotFoundException {
            if (bridgeFlashlights == null) throw new EquipmentNotFoundException();
            for (FlashLight flashlight : bridgeFlashlights) {
                flashlight.turnOff();
            }
            return "Освещение моста выключено.";
        }

        public int getNumberOfFlashLights() {
            return 2 * (this.width / 10);
        }

        public int getWidth() {
            return width;
        }

        public String getMaterial() {
            return material;
        }

        public Double getHeight() {
            return height;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (this.getClass() != obj.getClass())
                return false;
            Reservoir.Bridge otherObj = (Reservoir.Bridge) obj;
            return (height.equals(otherObj.height))
                    && ((material.equals(otherObj.material))
                    && (width == otherObj.width));
        }

        public int hashCode() {
            return 31 * this.height.hashCode()
                    + 31 * this.material.hashCode()
                    + 31 * this.width;
        }

        public String toString() {
            return getClass().getName()
                    + "[height=" + height
                    + ";width=" + width
                    + ";material=" + material
                    + "]";
        }
    }

    public static class Pair {

        private final int first;
        private final int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return this.first;
        }

        public int getSecond() {
            return this.second;
        }
    }

    public static Pair squareValue(int width, int length, int depth) {

        Reservoir w = new Reservoir(depth, width, length);
        int square = w.length * w.width;
        int value = square * w.depth;

        return new Pair(square, value);
    }

    public String getName() {
        return this.name;
    }

    public int getWidth() {
        return this.width;
    }

    public int getDepth() {
        return this.depth;
    }

    public int getLength() {
        return this.length;
    }

    @Override

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass())
            return false;
        Reservoir otherObj = (Reservoir) obj;
        return (depth == otherObj.depth)
                && (width == otherObj.width)
                && (length == otherObj.length)
                && (name.equals(otherObj.name));
    }

    public int hashCode() {
        return 31 * name.hashCode()
                + 31 * depth
                + 31 * length
                + 31 * width;
    }
}
