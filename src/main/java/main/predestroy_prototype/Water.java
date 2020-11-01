package main.predestroy_prototype;

public class Water {

    public Water() {
        System.out.println("о Создаётся бин water (XML): Destroy-метод нигде не указан");
    }

    public void init() {
        System.out.println("\t$ Инит " + this.getClass().getSimpleName());
    }

    public void waterDestroy() {
        System.out.println("x Дестрой " + this.getClass().getSimpleName());
    }
}
