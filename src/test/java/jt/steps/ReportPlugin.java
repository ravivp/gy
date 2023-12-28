package jt.steps;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import core.utils.BaseTestUtils;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.*;
import core.utils.ThreadLocalEvent;
import java.lang.reflect.Field;
import java.net.URI;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

// ConcurrentEventListener
public class   ReportPlugin implements ConcurrentEventListener {

   /* public ReportPlugin(){

    }*/
   /* private static boolean stepFailed = false;


    @Override
    public void setEventPublisher(EventPublisher publisher) {
        System.out.println("register handlers!!!");
        publisher.registerHandlerFor(TestCaseStarted.class, this::scenarioStartedHandler);
        publisher.registerHandlerFor(TestCaseFinished.class, this::scenarioFinishedHandler);
        publisher.registerHandlerFor(TestStepStarted.class, this::stepStartedHandler);
        publisher.registerHandlerFor(TestStepFinished.class, this::stepFinishedHandler);
    }

    private void scenarioStartedHandler(TestCaseStarted event) {
        stepFailed = false;
    }

    private void scenarioFinishedHandler(TestCaseFinished event) {
        BaseTestUtils.reportInfoMessage("Scenario finish name is: " + event.getTestCase().getName() + " end of Scenario statement!");
        if (stepFailed) {
            Result result = event.getResult();
            setPrivateField(result, "status", Status.FAILED);
        }
    }

    private void stepStartedHandler(TestStepStarted event) {
        if (event.getTestStep() instanceof PickleStepTestStep) {
            PickleStepTestStep testStep = (PickleStepTestStep) event.getTestStep();
            BaseTestUtils.reportInfoMessage("step name is: " + testStep.getStep().getText() + " end of statement!");
            ThreadLocalEvent.setStep(testStep);
        }
    }

    private void stepFinishedHandler(TestStepFinished event) {
        if (event.getTestStep() instanceof PickleStepTestStep) {
            PickleStepTestStep testStep = (PickleStepTestStep) event.getTestStep();
            Result result = event.getResult();
            ThreadLocalEvent.setResult(result);
            if (result.getStatus().equals(Status.FAILED)) {
                if (!testStep.getStep().getKeyWord().startsWith("Given")) {
                    stepFailed = true;
                    setPrivateField(result, "status", Status.PASSED);
                }
            }
        }
    }

    private void setPrivateField(Object subject, String fieldName, Object value) {
        try {
            Field f = subject.getClass().getDeclaredField(fieldName);
            f.setAccessible(true);
            f.set(subject, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    private final Map<String, UUID> startedSteps = new TreeMap<String, UUID>();
    private final Map<String, Status> finishedCases = new TreeMap<String, Status>();

    @Override
    public void setEventPublisher(EventPublisher publisher) {

        publisher.registerHandlerFor(TestStepStarted.class, this::handleTestStepStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::handleTestCaseFinished);

    }

    private void handleTestStepStarted(TestStepStarted event) {
        startedSteps.put(event.getTestStep().toString(), event.getTestStep().getId());
        for (Map.Entry<String, UUID> entry : startedSteps.entrySet()) {
            String location = entry.getKey();
            UUID uuid = entry.getValue();

          //  System.out.println(location);
           // System.out.println(location + " ###fromTestStepStarted### " + uuid);

            //above prints
            //io.cucumber.core.runner.PickleStepTestStep@5a5c128 ###fromTestStepStarted### 7f964f1c-9442-43fc-97e9-9ec6717eb47f
            // io.cucumber.core.runner.PickleStepTestStep@77b919a3 ###fromTestStepStarted### a5d57753-aecb-40a0-a0cf-76bef7526dd8

        }
    }


    private void handleTestCaseFinished(TestStepFinished event) {
        finishedCases.put(event.getTestStep().toString(), event.getResult().getStatus());
        for (Map.Entry<String, Status> entry : finishedCases.entrySet()) {
            String location = entry.getKey();
            Status status = entry.getValue();
            if(entry.getValue().equals("PASSED")){

                System.out.println(entry.getKey() + ":" + entry.getValue());
                System.out.println( MarkupHelper.createLabel(location, ExtentColor.GREEN));

            }else if (entry.getValue().equals("FAILED")){

                System.out.println(MarkupHelper.createLabel(location, ExtentColor.GREEN));

            }else if (entry.getValue().equals("SKIPPED")){

                System.out.println(MarkupHelper.createLabel(location, ExtentColor.ORANGE));
            }



            //above prints
            //io.cucumber.core.runner.PickleStepTestStep@5a5c128 ###fromTestStepStarted### 7f964f1c-9442-43fc-97e9-9ec6717eb47f
            // io.cucumber.core.runner.PickleStepTestStep@77b919a3 ###fromTestStepStarted### a5d57753-aecb-40a0-a0cf-76bef7526dd8

        }
    }
}
