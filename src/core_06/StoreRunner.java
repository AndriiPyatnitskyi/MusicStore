package core_06;


import core_06.instruments.Instrument;

import java.util.List;
import java.util.Map;

public class StoreRunner {

    public static void main(String[] args) {
        OrderInitializer orderInitializer = new OrderInitializer();
        Map<Instrument, Integer> order;
        try {
            order = orderInitializer.orderInit();
            MusicStore musicStore = new MusicStore();

            System.out.println("The Original Stock:");
            System.out.println(musicStore.stock);
            System.out.println("The Order:");
            System.out.println(order);

            List<Instrument> instrumentToDispatch = musicStore.prepareInstruments(order);

            System.out.println("The Stock after dispatch: ");
            System.out.println(musicStore.stock);

            if (instrumentToDispatch.size() != 0) {
                System.out.println("List of dispatched instruments:");
                System.out.println(instrumentToDispatch);
            }

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } catch (MissingInstrumentException e) {
            System.err.println(e.getMessage());
        }
    }

}