package globant.talentpod.restSample.domain.process;

import java.io.IOException;

public interface EmployeeProcessor {

    public void storeEmployee(String employee) throws IOException;
}
