package est.day11.company.controller;

import est.day11.company.dto.AddContactPersonRequest;
import est.day11.company.dto.ContactPersonResponse;
import est.day11.company.entity.ContactPerson;
import est.day11.company.service.ContactPersonService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ContactPersonController {

    private final ContactPersonService contactPersonService;

    public ContactPersonController(ContactPersonService contactPersonService) {
        this.contactPersonService = contactPersonService;
    }

    @PostMapping("/companies/{id}/contacts")
    public ResponseEntity<ContactPersonResponse> addContactPerson(@PathVariable Long id, @RequestBody AddContactPersonRequest addContactPersonRequest) {
        ContactPerson cp = contactPersonService.addContactPerson(id, addContactPersonRequest);
        ContactPersonResponse contactPersonResponse = new ContactPersonResponse(cp);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(contactPersonResponse);
    }

    @GetMapping("/companies/{id}/contacts")
    public ResponseEntity<List<ContactPersonResponse>> getContactPersons(@PathVariable Long id) {
        List<ContactPersonResponse> cpList = contactPersonService.getContactPersons(id);
        return ResponseEntity.status(HttpStatus.OK)
            .body(cpList);
    }

    @GetMapping("/contacts/{cpId}")
    public ResponseEntity<ContactPersonResponse> getContactPerson(@PathVariable Long cpId) {
        ContactPerson cp = contactPersonService.getContactPersonById(cpId);
        ContactPersonResponse contactPersonResponse = new ContactPersonResponse(cp);
        return ResponseEntity.status(HttpStatus.OK)
            .body(contactPersonResponse);
    }

    @DeleteMapping("/contacts/{cpId}")
    public ResponseEntity<Void> deleteContactPerson(@PathVariable Long cpId) {
        contactPersonService.deleteContactPerson(cpId);
        return ResponseEntity.ok().build();
    }

}
