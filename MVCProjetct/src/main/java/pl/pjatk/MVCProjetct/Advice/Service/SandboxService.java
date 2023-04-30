package pl.pjatk.MVCProjetct.Advice.Service;

import org.springframework.stereotype.Service;

@Service
public class SandboxService {

    public String throwsException(boolean shouldThrowException){
        if (shouldThrowException){
            throw new RuntimeException();
        }
        return "Exception was not thrown";
    }
}
