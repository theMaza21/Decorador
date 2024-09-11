// Clase abstracta que representa la bebida base.
// Esta clase actúa como el componente en el patrón decorador.
package javaapplication46;
abstract class Bevage   {
    String description = "Unknown Bevage";

    // Método para obtener la descripción de la bebida
    public String getDescription() {
        return description;
    }

    // Método abstracto para calcular el costo de la bebida
    public abstract double cost();
}

// Clases concretas que representan tipos de café específicos (Componentes concretos)
// Cada una hereda de la clase Bevage y define un tipo particular de bebida.

class HouseBlend extends Bevage {
    // Constructor que establece la descripción del tipo de bebida
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    // Método que devuelve el costo del café HouseBlend
    public double cost() {
        return 0.89;
    }
}

class DarkRoast extends Bevage {
    // Constructor que establece la descripción del tipo de bebida
    public DarkRoast() {
        description = "Dark Roast Coffee";
    }

    // Método que devuelve el costo del café DarkRoast
    public double cost() {
        return 0.99;
    }
}

class Expresso extends Bevage {
    // Constructor que establece la descripción del tipo de bebida
    public Expresso() {
        description = "Expresso";
    }

    // Método que devuelve el costo del expresso
    public double cost() {
        return 1.99;
    }
}

class Decaf extends Bevage {
    // Constructor que establece la descripción del tipo de bebida
    public Decaf() {
        description = "Decaf Coffee";
    }

    // Método que devuelve el costo del café descafeinado
    public double cost() {
        return 1.05;
    }
}

// Clase abstracta que representa los condimentos adicionales (Decorador abstracto).
// Extiende la clase Bevage para asegurar que los decoradores sean tratados de la misma manera que las bebidas.
abstract class CondimentDecorator extends Bevage {
    // Método abstracto que obliga a los decoradores concretos a implementar la descripción adicional.
    public abstract String getDescription();
}

// Decoradores concretos que añaden funcionalidad (condimentos) a las bebidas.
// Estas clases representan los condimentos y cada una de ellas añade costo y descripción.

class SoyMilk extends CondimentDecorator {
    Bevage bevage; // Referencia a la bebida que se está decorando

    // Constructor que recibe una bebida que será decorada con leche de soya
    public SoyMilk(Bevage bevage) {
        this.bevage = bevage;
    }

    // Método que añade la descripción del condimento a la bebida
    public String getDescription() {
        return bevage.getDescription() + ", Soy Milk";
    }

    // Método que añade el costo del condimento al costo total de la bebida
    public double cost() {
        return 0.15 + bevage.cost();
    }
}

class WholeMilk extends CondimentDecorator {
    Bevage bevage; // Referencia a la bebida que se está decorando

    // Constructor que recibe una bebida que será decorada con leche entera
    public WholeMilk(Bevage bevage) {
        this.bevage = bevage;
    }

    // Método que añade la descripción del condimento a la bebida
    public String getDescription() {
        return bevage.getDescription() + ", Whole Milk";
    }

    // Método que añade el costo del condimento al costo total de la bebida
    public double cost() {
        return 0.10 + bevage.cost();
    }
}

class Chocolate extends CondimentDecorator {
    Bevage bevage; // Referencia a la bebida que se está decorando

    // Constructor que recibe una bebida que será decorada con chocolate
    public Chocolate(Bevage bevage) {
        this.bevage = bevage;
    }

    // Método que añade la descripción del condimento a la bebida
    public String getDescription() {
        return bevage.getDescription() + ", Chocolate";
    }

    // Método que añade el costo del condimento al costo total de la bebida
    public double cost() {
        return 0.20 + bevage.cost();
    }
}

class WhippedCream extends CondimentDecorator {
    Bevage bevage; // Referencia a la bebida que se está decorando

    // Constructor que recibe una bebida que será decorada con crema batida
    public WhippedCream(Bevage bevage) {
        this.bevage = bevage;
    }

    // Método que añade la descripción del condimento a la bebida
    public String getDescription() {
        return bevage.getDescription() + ", Whipped Cream";
    }

    // Método que añade el costo del condimento al costo total de la bebida
    public double cost() {
        return 0.30 + bevage.cost();
    }
}

// Clase principal que simula pedidos en una tienda de café utilizando el patrón decorador.
// En esta clase se crean bebidas base y se les añaden condimentos dinámicamente.

public class Starbucks {
    public static void main(String[] args) {
        // Pedido 1: Expresso con Leche de Soya (Decorado con SoyMilk)
        Bevage bevage1 = new Expresso();            // Se crea una bebida base (Expresso)
        bevage1 = new SoyMilk(bevage1);             // Se decora con leche de soya
        System.out.println(bevage1.getDescription() + " $" + bevage1.cost());

        // Pedido 2: DarkRoast con Chocolate y Crema batida (Apilamiento de decoradores)
        Bevage bevage2 = new DarkRoast();           // Se crea una bebida base (DarkRoast)
        bevage2 = new Chocolate(bevage2);           // Se decora con chocolate
        bevage2 = new WhippedCream(bevage2);        // Se decora con crema batida
        System.out.println(bevage2.getDescription() + " $" + bevage2.cost());

        // Pedido 3: HouseBlend con Leche Entera (Decorado con WholeMilk)
        Bevage bevage3 = new HouseBlend();          // Se crea una bebida base (HouseBlend)
        bevage3 = new WholeMilk(bevage3);           // Se decora con leche entera
        System.out.println(bevage3.getDescription() + " $" + bevage3.cost());
    }
}