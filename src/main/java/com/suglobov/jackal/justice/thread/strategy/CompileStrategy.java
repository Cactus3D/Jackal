package com.suglobov.jackal.justice.thread.strategy;

import com.suglobov.jackal.database.entity.Try;
import com.suglobov.jackal.database.service.TryService;
import com.suglobov.jackal.justice.service.CandidateService;
import com.suglobov.jackal.justice.service.CompileService;
import com.suglobov.jackal.justice.thread.JusticeThread;
import com.suglobov.jackal.justice.util.Message;
import com.suglobov.jackal.salvage.service.FilesStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author Cactus3D
 */
@Component
public class CompileStrategy implements Runnable {

    private final JusticeThread mainThread;
    private CandidateService candidate;
    private CompileService compileService;
    private FilesStorageService filesStorageService;
    private TryService tryService;

    public CompileStrategy(CandidateService candidate, JusticeThread mainThread) {
        this.candidate = candidate;
        this.mainThread = mainThread;
    }

    @Autowired
    public void setCompileService(CompileService compileService) {
        this.compileService = compileService;
    }

    @Autowired
    public void setFilesStorageService(FilesStorageService filesStorageService) {
        this.filesStorageService = filesStorageService;
    }

    @Autowired
    public void setTryService(TryService tryService) {
        this.tryService = tryService;
    }

    @Override
    public void run() {
        Message message = new Message("Compile");
        candidate.addMessage(message);
        try {
            message.setMessage(
                    compileService.compile(
                            filesStorageService.getFilesByID(
                                    candidate.getTryID())));
        } catch (IOException e) {
            message.setMessage("ERROR\n\nGet IOException\n" + e.toString());
        }
        Try _try = tryService.getById(candidate.getTryID());
        _try.setReport(candidate.getReport());
        tryService.editTry(_try);
        if (message.isCritical()) {
            mainThread.addToTestQueue(candidate);
        }
    }
}
