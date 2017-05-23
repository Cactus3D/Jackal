package com.suglobov.jackal.rest.controller;

import com.suglobov.jackal.salvage.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class FileUploadController {

    private final UploadService storageService;
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    public FileUploadController(UploadService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("file/")
    public String listUploadedFiles(Model model) throws IOException {
        return "uploadForm";
    }

    @PostMapping("file/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   @RequestParam("taskID") int task,
                                   @RequestParam("variantID") int variant,
                                   RedirectAttributes redirectAttributes) {
        int newID;
        //Добавление попытки в базу, получение newID
        newID = counter.intValue();
        //Candidate candidate = new Candidate(newID, task, variant);
        //Сохранение файлов по полученному newID
        storageService.store(file, counter.intValue());
        //Добавление в очередь на тестирование
        //QueueManager.addToQueue(candidate);
        redirectAttributes.addFlashAttribute("id", newID);
        return "redirect:/file/";
    }

    @GetMapping("file/lol")
    public String shwoUploadStatus(@RequestParam("id") int id,
                                   Model model) {
        return "uploadForm";
    }

}