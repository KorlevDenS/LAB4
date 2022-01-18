package Lab4;

public enum BridgeMaterials {
    WOOD("дерево"),
    STEEL("сталь"),
    STONE("камень");

    final private String material;

    BridgeMaterials(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

}
