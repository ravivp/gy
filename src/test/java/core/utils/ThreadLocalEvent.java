package core.utils;

import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.Result;

public class ThreadLocalEvent {


    private PickleStepTestStep testStep;
    private Result result;

    public PickleStepTestStep getTestStep() {
        return testStep;
    }

    public void setTestStep(PickleStepTestStep testStep) {
        this.testStep = testStep;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
