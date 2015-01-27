/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faisal.customer.controller;

import com.faisal.customer.model.FileUploadForm;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author faisal
 */
@Controller
@RequestMapping("/fileupload")
public class FileUploadController {
    private String saveDirectory = "D:/t/"; //Here I Added
     
    @RequestMapping( method = RequestMethod.GET)
    public String displayForm() {
        return "fileUpload";
    }
     
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(
            @ModelAttribute("fileupload") FileUploadForm uploadForm,
                    Model map) throws IllegalStateException, IOException {
         
        List<MultipartFile> files = uploadForm.getFiles();
 
        List<String> fileNames = new ArrayList<String>();
         
        if(null != files && files.size() > 0) {
            for (MultipartFile multipartFile : files) {
 
                String fileName = multipartFile.getOriginalFilename();
                fileNames.add(fileName);
                //Handle file content - multipartFile.getInputStream()
                multipartFile.transferTo(new File(saveDirectory + multipartFile.getOriginalFilename()));   //Here I Added
            }
        }
         
        map.addAttribute("files", fileNames);
        return "success";
    }
    
//    @RequestMapping(method = RequestMethod.GET)
//    public ModelAndView initPage(){
//    ModelAndView m = new ModelAndView("fileUpload");
//    return m;
//    }
//    
//    @RequestMapping(method = RequestMethod.POST)
//    public String save(
//            @ModelAttribute("saveUpload") FileUploadForm uploadForm,
//                    Model map) {
//         System.out.println("clicked");
//        List<MultipartFile> files = uploadForm.getFiles();
// 
//        List<String> fileNames = new ArrayList<String>();
//         
//        if(null != files && files.size() > 0) {
//            for (MultipartFile multipartFile : files) {
// 
//                String fileName = multipartFile.getOriginalFilename();
//                System.out.println("filename: "+fileName);
//                fileNames.add(fileName);
//                //Handle file content - multipartFile.getInputStream()
// 
//            }
//        }
//         
//        map.addAttribute("files", fileNames);
//        return "success";
//    }
}
