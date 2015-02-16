package by.epamlab.web.controllers;

import by.epamlab.issues.model.Attachment;
import by.epamlab.issues.service.AssignmentService;
import by.epamlab.issues.service.AttachmentService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

@Controller
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;
    @Autowired
    AssignmentService assignmentService;

    @RequestMapping(value = "/home/issues/issuedetails/upload/{assignmentId}", method = RequestMethod.POST)
    public String save(
            @ModelAttribute("attachment") Attachment attachment,
            @RequestParam("file") MultipartFile file,
            @PathVariable("assignmentId") String assignmentId) {
        try {
            Blob blob = attachmentService.getBlob(file.getBytes());
            attachment.setContent(blob);
        } catch (IOException e) {
            e.printStackTrace();
        }
        attachment.setName(file.getOriginalFilename());
        attachment.setSize(String.valueOf(file.getSize()));
        attachment.setContenttype(file.getContentType());
        attachment.setProject(assignmentService.getAssignmentById(Integer.valueOf(assignmentId)).getTask().getProject());
        attachment.setTask(assignmentService.getAssignmentById(Integer.valueOf(assignmentId)).getTask());
        attachmentService.save(attachment);
        return "redirect:/home/issues/issuedetails/"+assignmentId;
    }

    @RequestMapping(value = "/home/issues/issuedetails/download/{documentId}", method = RequestMethod.POST)
    public String download(@PathVariable("documentId")
                           Integer documentId, HttpServletResponse response) {

        Attachment doc = attachmentService.getById(documentId);
        try {
            response.setHeader("Content-Disposition", "inline;filename=\"" +doc.getName()+ "\"");
            OutputStream out = response.getOutputStream();
            response.setContentType(doc.getContenttype());
            IOUtils.copy(doc.getContent().getBinaryStream(), out);
            out.flush();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @RequestMapping(value = "/home/issues/issuedetails/delete/{assignmentId}/{documentId}", method = RequestMethod.POST)
    public String remove(@PathVariable("documentId")Integer documentId, @PathVariable("assignmentId")Integer assignmentId) {

        attachmentService.delete(documentId);

        return "redirect:/home/issues/issuedetails/"+assignmentId;
    }

}
