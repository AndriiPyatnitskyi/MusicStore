package core_06;

import core_06.instruments.Guitar;
import core_06.instruments.Instrument;
import core_06.instruments.Piano;
import core_06.instruments.Trumpet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OrderInitializer {

    private int quantityInOrder;
    private Scanner scanner = new Scanner(System.in);
    private int counterOfScannersLoops = 0;
    Map<Instrument, Integer> order = new HashMap<>();

    Map<Instrument, Integer> orderInit() throws MissingInstrumentException {

        order.put(new Guitar(), quantityInOrder);
        order.put(new Piano(), quantityInOrder);
        order.put(new Trumpet(), quantityInOrder);

        scanDataFromInput();

        return order;
    }

    private void scanDataFromInput() throws MissingInstrumentException {
        if (counterOfScannersLoops == 0) {
            System.out.println("Type the name of instrument you want to order:");
        } else {
            System.out.println("You can add more instruments to the order, please type the name of instrument.");
            System.out.println("To complete the order type 'done'");
        }
        String input = scanner.next().toLowerCase();
        switch (input) {
            case "guitar":
                instrumentQuantity(input);
                break;
            case "piano":
                instrumentQuantity(input);
                break;
            case "trumpet":
                instrumentQuantity(input);
                break;
            case "done":
                System.out.println("Please wait for processing the order.\n");
                counterOfScannersLoops = 0;
                break;
            default:
                counterOfScannersLoops = 0;
                throw new MissingInstrumentException("[ERROR]: we do not have '" + input
                        + "' instrument, make another order please.");
        }
    }

    private void instrumentQuantity(String input) throws MissingInstrumentException {
        System.out.println("How many " + input + " do you need?");
        quantityInOrder = scanner.nextInt();
        counterOfScannersLoops++;
        for(Map.Entry<Instrument, Integer> entry : order.entrySet()) {
            if (entry.getKey().toString().equals(input)) {
                entry.setValue(entry.getValue() + quantityInOrder);
            }
        }
        scanDataFromInput();
    }

}
