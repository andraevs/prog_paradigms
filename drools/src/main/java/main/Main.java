package main;


import facts.Order;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.KieServices;
import org.kie.internal.io.ResourceFactory;

import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
            try{





            KieServices ks = KieServices.Factory.get();

                KieFileSystem kieFileSystem = ks.newKieFileSystem();
                List<String> rules = Arrays.asList("rules/discount.drl");
                for (String rule : rules) {
                    kieFileSystem.write(ResourceFactory.newClassPathResource(rule));
                }

                KieBuilder kieBuilder = ks.newKieBuilder(kieFileSystem);
                kieBuilder.buildAll();

                KieRepository kieRepository = ks.getRepository();

                ReleaseId krDefaultReleaseId = kieRepository.getDefaultReleaseId();
                KieContainer kieContainer
                        = ks.newKieContainer(krDefaultReleaseId);

                KieSession kSession = kieContainer.newKieSession();

            Order order = new Order();
            order.setTotal(1200);

            kSession.insert(order);

            kSession.fireAllRules();

            System.out.println("Order Details: " + order);

            kSession.dispose();

    }
        catch(Exception e){
                System.out.println(e);
        }
}



}
